package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.GpsHelper$GpsHelperListener;
import java.lang.ref.WeakReference;

class GpsHelper$FetchAdvertisingInfoTask extends AsyncTask {
   private WeakReference mContextWeakReference;
   private WeakReference mGpsHelperListenerWeakReference;

   public GpsHelper$FetchAdvertisingInfoTask(Context var1, GpsHelper$GpsHelperListener var2) {
      this.mContextWeakReference = new WeakReference(var1);
      this.mGpsHelperListenerWeakReference = new WeakReference(var2);
   }

   protected Void doInBackground(Void... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(Void var1) {
      GpsHelper$GpsHelperListener var2 = (GpsHelper$GpsHelperListener)this.mGpsHelperListenerWeakReference.get();
      if(var2 != null) {
         var2.onFetchAdInfoCompleted();
      }

   }
}
