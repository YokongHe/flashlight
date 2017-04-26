package com.mopub.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.Build.VERSION;
import com.mopub.volley.Cache;
import com.mopub.volley.Network;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.ResponseDelivery;
import com.mopub.volley.VolleyError;
import com.mopub.volley.VolleyLog;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher extends Thread {
   private final Cache mCache;
   private final ResponseDelivery mDelivery;
   private final Network mNetwork;
   private final BlockingQueue mQueue;
   private volatile boolean mQuit = false;

   public NetworkDispatcher(BlockingQueue var1, Network var2, Cache var3, ResponseDelivery var4) {
      this.mQueue = var1;
      this.mNetwork = var2;
      this.mCache = var3;
      this.mDelivery = var4;
   }

   @TargetApi(14)
   private void addTrafficStatsTag(Request var1) {
      if(VERSION.SDK_INT >= 14) {
         TrafficStats.setThreadStatsTag(var1.getTrafficStatsTag());
      }

   }

   private void parseAndDeliverNetworkError(Request var1, VolleyError var2) {
      var2 = var1.parseNetworkError(var2);
      this.mDelivery.postError(var1, var2);
   }

   public void quit() {
      this.mQuit = true;
      this.interrupt();
   }

   public void run() {
      Process.setThreadPriority(10);

      while(true) {
         Request var1;
         while(true) {
            try {
               var1 = (Request)this.mQueue.take();
               break;
            } catch (InterruptedException var3) {
               if(this.mQuit) {
                  return;
               }
            }
         }

         try {
            var1.addMarker("network-queue-take");
            if(var1.isCanceled()) {
               var1.finish("network-discard-cancelled");
            } else {
               this.addTrafficStatsTag(var1);
               NetworkResponse var2 = this.mNetwork.performRequest(var1);
               var1.addMarker("network-http-complete");
               if(var2.notModified && var1.hasHadResponseDelivered()) {
                  var1.finish("not-modified");
               } else {
                  Response var6 = var1.parseNetworkResponse(var2);
                  var1.addMarker("network-parse-complete");
                  if(var1.shouldCache() && var6.cacheEntry != null) {
                     this.mCache.put(var1.getCacheKey(), var6.cacheEntry);
                     var1.addMarker("network-cache-written");
                  }

                  var1.markDelivered();
                  this.mDelivery.postResponse(var1, var6);
               }
            }
         } catch (VolleyError var4) {
            this.parseAndDeliverNetworkError(var1, var4);
         } catch (Exception var5) {
            VolleyLog.e(var5, "Unhandled exception %s", new Object[]{var5.toString()});
            this.mDelivery.postError(var1, new VolleyError(var5));
         }
      }
   }
}
