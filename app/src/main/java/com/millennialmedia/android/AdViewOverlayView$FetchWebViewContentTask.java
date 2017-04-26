package com.millennialmedia.android;

import android.os.AsyncTask;
import com.millennialmedia.android.AdViewOverlayActivity;
import com.millennialmedia.android.AdViewOverlayView;
import java.lang.ref.WeakReference;

class AdViewOverlayView$FetchWebViewContentTask extends AsyncTask {
   private WeakReference _overlayViewRef;
   private String baseUrl;
   private boolean cancelVideo;

   public AdViewOverlayView$FetchWebViewContentTask(AdViewOverlayView var1, String var2) {
      this.baseUrl = var2;
      this._overlayViewRef = new WeakReference(var1);
   }

   protected String doInBackground(Void... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(String var1) {
      AdViewOverlayView var2 = (AdViewOverlayView)this._overlayViewRef.get();
      if(var2 != null) {
         if(this.cancelVideo) {
            AdViewOverlayActivity var3 = (AdViewOverlayActivity)var2.overlayActivityRef.get();
            if(var3 != null) {
               var3.finish();
            } else {
               AdViewOverlayView.access$200(var2);
            }
         }

         if(var1 != null && var2.adImpl != null && var2.adImpl.controller != null) {
            var2.adImpl.controller.setWebViewContent(var1, this.baseUrl);
         }
      }

   }

   protected void onPreExecute() {
      AdViewOverlayView var1 = (AdViewOverlayView)this._overlayViewRef.get();
      if(var1 != null && AdViewOverlayView.access$400(var1) == null) {
         AdViewOverlayView.access$500(var1);
      }

      super.onPreExecute();
   }
}
