package com.mopub.common;

import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.CacheService$DiskLruCacheGetListener;

class CacheService$DiskLruCacheGetTask extends AsyncTask {
   private final CacheService$DiskLruCacheGetListener mDiskLruCacheGetListener;
   private final String mKey;

   CacheService$DiskLruCacheGetTask(String var1, CacheService$DiskLruCacheGetListener var2) {
      this.mDiskLruCacheGetListener = var2;
      this.mKey = var1;
   }

   protected byte[] doInBackground(Void... var1) {
      return CacheService.getFromDiskCache(this.mKey);
   }

   protected void onCancelled() {
      if(this.mDiskLruCacheGetListener != null) {
         this.mDiskLruCacheGetListener.onComplete(this.mKey, (byte[])null);
      }

   }

   protected void onPostExecute(byte[] var1) {
      if(this.isCancelled()) {
         this.onCancelled();
      } else if(this.mDiskLruCacheGetListener != null) {
         this.mDiskLruCacheGetListener.onComplete(this.mKey, var1);
         return;
      }

   }
}
