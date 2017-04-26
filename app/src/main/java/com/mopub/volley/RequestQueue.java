package com.mopub.volley;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.CacheDispatcher;
import com.mopub.volley.ExecutorDelivery;
import com.mopub.volley.Network;
import com.mopub.volley.NetworkDispatcher;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue$RequestFilter;
import com.mopub.volley.ResponseDelivery;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
   private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
   private final Cache mCache;
   private CacheDispatcher mCacheDispatcher;
   private final PriorityBlockingQueue mCacheQueue;
   private final Set mCurrentRequests;
   private final ResponseDelivery mDelivery;
   private NetworkDispatcher[] mDispatchers;
   private final Network mNetwork;
   private final PriorityBlockingQueue mNetworkQueue;
   private AtomicInteger mSequenceGenerator;
   private final Map mWaitingRequests;

   public RequestQueue(Cache var1, Network var2) {
      this(var1, var2, 4);
   }

   public RequestQueue(Cache var1, Network var2, int var3) {
      this(var1, var2, var3, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
   }

   public RequestQueue(Cache var1, Network var2, int var3, ResponseDelivery var4) {
      this.mSequenceGenerator = new AtomicInteger();
      this.mWaitingRequests = new HashMap();
      this.mCurrentRequests = new HashSet();
      this.mCacheQueue = new PriorityBlockingQueue();
      this.mNetworkQueue = new PriorityBlockingQueue();
      this.mCache = var1;
      this.mNetwork = var2;
      this.mDispatchers = new NetworkDispatcher[var3];
      this.mDelivery = var4;
   }

   public Request add(Request param1) {
      // $FF: Couldn't be decompiled
   }

   public void cancelAll(RequestQueue$RequestFilter param1) {
      // $FF: Couldn't be decompiled
   }

   public void cancelAll(final Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Cannot cancelAll with a null tag");
      } else {
         this.cancelAll(new RequestQueue$RequestFilter() {
            public boolean apply(Request var1x) {
               return var1x.getTag() == var1;
            }
         });
      }
   }

   void finish(Request param1) {
      // $FF: Couldn't be decompiled
   }

   public Cache getCache() {
      return this.mCache;
   }

   public int getSequenceNumber() {
      return this.mSequenceGenerator.incrementAndGet();
   }

   public void start() {
      this.stop();
      this.mCacheDispatcher = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
      this.mCacheDispatcher.start();

      for(int var1 = 0; var1 < this.mDispatchers.length; ++var1) {
         NetworkDispatcher var2 = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
         this.mDispatchers[var1] = var2;
         var2.start();
      }

   }

   public void stop() {
      if(this.mCacheDispatcher != null) {
         this.mCacheDispatcher.quit();
      }

      for(int var1 = 0; var1 < this.mDispatchers.length; ++var1) {
         if(this.mDispatchers[var1] != null) {
            this.mDispatchers[var1].quit();
         }
      }

   }
}
