package com.mopub.volley.toolbox;

import android.os.SystemClock;
import com.mopub.volley.Cache$Entry;
import com.mopub.volley.Network;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.VolleyError;
import com.mopub.volley.VolleyLog;
import com.mopub.volley.toolbox.ByteArrayPool;
import com.mopub.volley.toolbox.HttpStack;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork implements Network {
   protected static final boolean DEBUG;
   private static int DEFAULT_POOL_SIZE;
   private static int SLOW_REQUEST_THRESHOLD_MS;
   protected final HttpStack mHttpStack;
   protected final ByteArrayPool mPool;

   static {
      DEBUG = VolleyLog.DEBUG;
      SLOW_REQUEST_THRESHOLD_MS = 3000;
      DEFAULT_POOL_SIZE = 4096;
   }

   public BasicNetwork(HttpStack var1) {
      this(var1, new ByteArrayPool(DEFAULT_POOL_SIZE));
   }

   public BasicNetwork(HttpStack var1, ByteArrayPool var2) {
      this.mHttpStack = var1;
      this.mPool = var2;
   }

   private void addCacheHeaders(Map var1, Cache$Entry var2) {
      if(var2 != null) {
         if(var2.etag != null) {
            var1.put("If-None-Match", var2.etag);
         }

         if(var2.serverDate > 0L) {
            var1.put("If-Modified-Since", DateUtils.formatDate(new Date(var2.serverDate)));
            return;
         }
      }

   }

   private static void attemptRetryOnException(String var0, Request var1, VolleyError var2) {
      RetryPolicy var4 = var1.getRetryPolicy();
      int var3 = var1.getTimeoutMs();

      try {
         var4.retry(var2);
      } catch (VolleyError var5) {
         var1.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{var0, Integer.valueOf(var3)}));
         throw var5;
      }

      var1.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{var0, Integer.valueOf(var3)}));
   }

   protected static Map convertHeaders(Header[] var0) {
      TreeMap var2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2.put(var0[var1].getName(), var0[var1].getValue());
      }

      return var2;
   }

   private byte[] entityToBytes(HttpEntity param1) {
      // $FF: Couldn't be decompiled
   }

   private void logSlowRequests(long var1, Request var3, byte[] var4, StatusLine var5) {
      if(DEBUG || var1 > (long)SLOW_REQUEST_THRESHOLD_MS) {
         Object var6;
         if(var4 != null) {
            var6 = Integer.valueOf(var4.length);
         } else {
            var6 = "null";
         }

         VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[]{var3, Long.valueOf(var1), var6, Integer.valueOf(var5.getStatusCode()), Integer.valueOf(var3.getRetryPolicy().getCurrentRetryCount())});
      }

   }

   protected void logError(String var1, String var2, long var3) {
      VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[]{var1, Long.valueOf(SystemClock.elapsedRealtime() - var3), var2});
   }

   public NetworkResponse performRequest(Request param1) {
      // $FF: Couldn't be decompiled
   }
}
