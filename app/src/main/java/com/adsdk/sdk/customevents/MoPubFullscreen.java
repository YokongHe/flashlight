package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener;

public class MoPubFullscreen extends CustomEventFullscreen {
   private MoPubInterstitial interstitial;

   private MoPubInterstitial$InterstitialAdListener createListener() {
      return new MoPubInterstitial$InterstitialAdListener() {
         public void onInterstitialClicked(MoPubInterstitial var1) {
            if(MoPubFullscreen.this.listener != null) {
               MoPubFullscreen.this.listener.onFullscreenLeftApplication();
            }

         }

         public void onInterstitialDismissed(MoPubInterstitial var1) {
            if(MoPubFullscreen.this.listener != null) {
               MoPubFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void onInterstitialFailed(MoPubInterstitial var1, MoPubErrorCode var2) {
            if(MoPubFullscreen.this.listener != null) {
               MoPubFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public void onInterstitialLoaded(MoPubInterstitial var1) {
            if(MoPubFullscreen.this.listener != null) {
               MoPubFullscreen.this.listener.onFullscreenLoaded(MoPubFullscreen.this);
            }

         }

         public void onInterstitialShown(MoPubInterstitial var1) {
            MoPubFullscreen.this.reportImpression();
            if(MoPubFullscreen.this.listener != null) {
               MoPubFullscreen.this.listener.onFullscreenOpened();
            }

         }
      };
   }

   public void finish() {
      if(this.interstitial != null) {
         this.interstitial.destroy();
      }

      super.finish();
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.mopub.mobileads.MoPubErrorCode");
         Class.forName("com.mopub.mobileads.MoPubInterstitial");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      this.interstitial = new MoPubInterstitial(var1, var3);
      this.interstitial.setInterstitialAdListener(this.createListener());
      this.interstitial.load();
   }

   public void showFullscreen() {
      if(this.interstitial != null && this.interstitial.isReady()) {
         this.interstitial.show();
      }

   }
}
