package com.adsdk.sdk.customevents;

import android.content.Context;
import android.os.AsyncTask;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;

public abstract class CustomEventBanner {
   protected CustomEventBanner$CustomEventBannerListener listener;
   protected String trackingPixel;

   public void destroy() {
      this.listener = null;
   }

   protected void finalize() {
      this.destroy();
      super.finalize();
   }

   public abstract void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, String var3, String var4, int var5, int var6);

   protected void reportImpression() {
      (new AsyncTask() {
         protected Void doInBackground(Void... param1) {
            // $FF: Couldn't be decompiled
         }
      }).execute(new Void[0]);
   }
}
