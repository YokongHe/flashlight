package com.mopub.common;

import android.os.AsyncTask;
import com.mopub.common.CacheService;

class CacheService$DiskLruCachePutTask extends AsyncTask {
   private final byte[] mContent;
   private final String mKey;

   CacheService$DiskLruCachePutTask(String var1, byte[] var2) {
      this.mKey = var1;
      this.mContent = var2;
   }

   protected Void doInBackground(Void... var1) {
      CacheService.putToDiskCache(this.mKey, this.mContent);
      return null;
   }
}
