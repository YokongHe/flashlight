package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.AdCache$AdCacheTaskListener;
import com.millennialmedia.android.AdCacheThreadPool;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.HandShake;
import java.lang.ref.WeakReference;

class AdCacheThreadPool$AdCacheTask implements Comparable, Runnable {
   private CachedAd ad;
   private String adName;
   private WeakReference contextRef;
   private WeakReference listenerRef;
   // $FF: synthetic field
   final AdCacheThreadPool this$0;

   AdCacheThreadPool$AdCacheTask(AdCacheThreadPool var1, Context var2, String var3, CachedAd var4, AdCache$AdCacheTaskListener var5) {
      this.this$0 = var1;
      this.contextRef = new WeakReference(var2.getApplicationContext());
      this.adName = var3;
      this.ad = var4;
      if(var5 != null) {
         this.listenerRef = new WeakReference(var5);
      }

   }

   public int compareTo(AdCacheThreadPool$AdCacheTask var1) {
      return this.ad.downloadPriority - var1.ad.downloadPriority;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof AdCacheThreadPool$AdCacheTask)) {
         return false;
      } else {
         AdCacheThreadPool$AdCacheTask var2 = (AdCacheThreadPool$AdCacheTask)var1;
         return this.ad.equals(var2.ad);
      }
   }

   public void run() {
      AdCache$AdCacheTaskListener var4;
      if(this.listenerRef != null) {
         var4 = (AdCache$AdCacheTaskListener)this.listenerRef.get();
      } else {
         var4 = null;
      }

      if(var4 != null) {
         var4.downloadStart(this.ad);
      }

      HandShake.sharedHandShake((Context)this.contextRef.get()).lockAdTypeDownload(this.adName);
      boolean var1 = this.ad.download((Context)this.contextRef.get());
      HandShake.sharedHandShake((Context)this.contextRef.get()).unlockAdTypeDownload(this.adName);
      if(!var1) {
         String var2;
         Context var3;
         String var5;
         label39: {
            var2 = AdCache.getIncompleteDownload((Context)this.contextRef.get(), this.adName);
            if(var2 != null && this.ad.getId().equals(var2)) {
               this.ad.delete((Context)this.contextRef.get());
               var3 = (Context)this.contextRef.get();
               var2 = this.adName;
            } else {
               var3 = (Context)this.contextRef.get();
               var2 = this.adName;
               if(!this.ad.downloadAllOrNothing) {
                  var5 = this.ad.getId();
                  break label39;
               }
            }

            var5 = null;
         }

         AdCache.setIncompleteDownload(var3, var2, var5);
      } else {
         AdCache.setIncompleteDownload((Context)this.contextRef.get(), this.adName, (String)null);
      }

      if(var4 != null) {
         var4.downloadCompleted(this.ad, var1);
      }

   }
}
