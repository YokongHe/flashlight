package com.adsdk.sdk.customevents;

import android.app.Activity;
import android.os.AsyncTask;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;

public abstract class CustomEventFullscreen {
   protected CustomEventFullscreen$CustomEventFullscreenListener listener;
   protected String trackingPixel;

   public void finish() {
      this.listener = null;
   }

   public abstract void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4);

   protected void reportImpression() {
      (new AsyncTask() {
         protected Void doInBackground(Void... param1) {
            // $FF: Couldn't be decompiled
         }
      }).execute(new Void[0]);
   }

   public abstract void showFullscreen();
}
