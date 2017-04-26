package com.mopub.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Request$Priority;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;

public class ClearCacheRequest extends Request {
   private final Cache mCache;
   private final Runnable mCallback;

   public ClearCacheRequest(Cache var1, Runnable var2) {
      super(0, (String)null, (Response$ErrorListener)null);
      this.mCache = var1;
      this.mCallback = var2;
   }

   protected void deliverResponse(Object var1) {
   }

   public Request$Priority getPriority() {
      return Request$Priority.IMMEDIATE;
   }

   public boolean isCanceled() {
      this.mCache.clear();
      if(this.mCallback != null) {
         (new Handler(Looper.getMainLooper())).postAtFrontOfQueue(this.mCallback);
      }

      return true;
   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      return null;
   }
}
