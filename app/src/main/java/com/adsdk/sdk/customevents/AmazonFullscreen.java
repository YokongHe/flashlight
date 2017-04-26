package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.InterstitialAd;

public class AmazonFullscreen extends CustomEventFullscreen {
   private InterstitialAd interstitial;

   private AdListener createListener() {
      return new AdListener() {
         public void onAdCollapsed(Ad var1) {
         }

         public void onAdDismissed(Ad var1) {
            if(AmazonFullscreen.this.listener != null) {
               AmazonFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void onAdExpanded(Ad var1) {
            if(AmazonFullscreen.this.listener != null) {
               AmazonFullscreen.this.listener.onFullscreenLeftApplication();
            }

         }

         public void onAdFailedToLoad(Ad var1, AdError var2) {
            if(AmazonFullscreen.this.listener != null) {
               AmazonFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public void onAdLoaded(Ad var1, AdProperties var2) {
            if(AmazonFullscreen.this.listener != null) {
               AmazonFullscreen.this.listener.onFullscreenLoaded(AmazonFullscreen.this);
            }

         }
      };
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.amazon.device.ads.Ad");
         Class.forName("com.amazon.device.ads.AdError");
         Class.forName("com.amazon.device.ads.AdListener");
         Class.forName("com.amazon.device.ads.AdProperties");
         Class.forName("com.amazon.device.ads.AdRegistration");
         Class.forName("com.amazon.device.ads.InterstitialAd");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      AdRegistration.setAppKey(var3);
      this.interstitial = new InterstitialAd(var1);
      this.interstitial.setListener(this.createListener());
      this.interstitial.loadAd();
   }

   public void showFullscreen() {
      if(this.interstitial != null && this.interstitial.showAd()) {
         this.reportImpression();
         if(this.listener != null) {
            this.listener.onFullscreenOpened();
         }
      }

   }
}
