package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class FacebookFullscreen extends CustomEventFullscreen {
   private InterstitialAd interstitial;

   private InterstitialAdListener createListener() {
      return new InterstitialAdListener() {
         public void onAdClicked(Ad var1) {
            if(FacebookFullscreen.this.listener != null) {
               FacebookFullscreen.this.listener.onFullscreenLeftApplication();
            }

         }

         public void onAdLoaded(Ad var1) {
            if(FacebookFullscreen.this.listener != null) {
               FacebookFullscreen.this.listener.onFullscreenLoaded(FacebookFullscreen.this);
            }

         }

         public void onError(Ad var1, AdError var2) {
            if(FacebookFullscreen.this.listener != null) {
               FacebookFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public void onInterstitialDismissed(Ad var1) {
            if(FacebookFullscreen.this.listener != null) {
               FacebookFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void onInterstitialDisplayed(Ad var1) {
            FacebookFullscreen.this.reportImpression();
            if(FacebookFullscreen.this.listener != null) {
               FacebookFullscreen.this.listener.onFullscreenOpened();
            }

         }
      };
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.facebook.ads.Ad");
         Class.forName("com.facebook.ads.AdError");
         Class.forName("com.facebook.ads.InterstitialAd");
         Class.forName("com.facebook.ads.InterstitialAdListener");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      this.interstitial = new InterstitialAd(var1, var3);
      this.interstitial.setAdListener(this.createListener());
      this.interstitial.loadAd();
   }

   public void showFullscreen() {
      if(this.interstitial != null && this.interstitial.isAdLoaded()) {
         this.interstitial.show();
      }

   }
}
