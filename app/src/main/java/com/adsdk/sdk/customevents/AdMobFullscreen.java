package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;

public class AdMobFullscreen extends CustomEventFullscreen {
   private com.google.android.gms.ads.a adListener;
   private com.google.android.gms.ads.e interstitial;

   private com.google.android.gms.ads.a createAdListener() {
      return new com.google.android.gms.ads.a() {
         public void onAdClosed() {
            if(AdMobFullscreen.this.listener != null) {
               AdMobFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void onAdFailedToLoad(int var1) {
            if(AdMobFullscreen.this.listener != null) {
               AdMobFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public void onAdLeftApplication() {
            if(AdMobFullscreen.this.listener != null) {
               AdMobFullscreen.this.listener.onFullscreenLeftApplication();
            }

         }

         public void onAdLoaded() {
            if(AdMobFullscreen.this.listener != null) {
               AdMobFullscreen.this.listener.onFullscreenLoaded(AdMobFullscreen.this);
            }

         }

         public void onAdOpened() {
            AdMobFullscreen.this.reportImpression();
            if(AdMobFullscreen.this.listener != null) {
               AdMobFullscreen.this.listener.onFullscreenOpened();
            }

         }
      };
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.google.android.gms.ads.a");
         Class.forName("com.google.android.gms.ads.b");
         Class.forName("com.google.android.gms.ads.e");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      this.adListener = this.createAdListener();
      this.interstitial = new com.google.android.gms.ads.e(var1);
      this.interstitial.a(var3);
      this.interstitial.a(this.adListener);
      com.google.android.gms.ads.b var6 = (new com.google.android.gms.ads.c()).a();
      this.interstitial.a(var6);
   }

   public void showFullscreen() {
      if(this.interstitial != null && this.interstitial.a()) {
         this.interstitial.b();
      }

   }
}
