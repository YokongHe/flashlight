package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.AdCache$AdCacheTaskListener;
import com.millennialmedia.android.AdCacheThreadPool$AdCacheTask;
import com.millennialmedia.android.CachedAd;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AdCacheThreadPool {
   private static AdCacheThreadPool sharedThreadPool;
   private ThreadPoolExecutor executor;
   private PriorityBlockingQueue queue;

   private AdCacheThreadPool() {
      TimeUnit var1 = TimeUnit.SECONDS;
      PriorityBlockingQueue var2 = new PriorityBlockingQueue(32);
      this.queue = var2;
      this.executor = new ThreadPoolExecutor(1, 2, 30L, var1, var2);
   }

   static AdCacheThreadPool sharedThreadPool() {
      synchronized(AdCacheThreadPool.class){}

      AdCacheThreadPool var0;
      try {
         if(sharedThreadPool == null) {
            sharedThreadPool = new AdCacheThreadPool();
         }

         var0 = sharedThreadPool;
      } finally {
         ;
      }

      return var0;
   }

   final boolean startDownloadTask(Context var1, String var2, CachedAd var3, AdCache$AdCacheTaskListener var4) {
      boolean var5;
      label56: {
         synchronized(this){}
         if(var1 != null && var3 != null) {
            boolean var7 = false;

            try {
               var7 = true;
               AdCacheThreadPool$AdCacheTask var9 = new AdCacheThreadPool$AdCacheTask(this, var1, var2, var3, var4);
               if(!this.queue.contains(var9)) {
                  if(!var3.isOnDisk(var1)) {
                     this.executor.execute(var9);
                     var7 = false;
                     break label56;
                  }

                  var7 = false;
               } else {
                  var7 = false;
               }
            } finally {
               if(var7) {
                  ;
               }
            }
         }

         var5 = false;
         return var5;
      }

      var5 = true;
      return var5;
   }
}
