package com.adsdk.sdk.customevents;

import android.content.Context;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.google.android.gms.ads.AdView;

public class AdMobBanner extends CustomEventBanner {
   private AdView adView;

   private com.google.android.gms.ads.a createAdListener() {
      return new com.google.android.gms.ads.a() {
         public void onAdClosed() {
            if(AdMobBanner.this.listener != null) {
               AdMobBanner.this.listener.onBannerClosed();
            }

         }

         public void onAdFailedToLoad(int var1) {
            if(AdMobBanner.this.listener != null) {
               AdMobBanner.this.listener.onBannerFailed();
            }

         }

         public void onAdLoaded() {
            AdMobBanner.this.reportImpression();
            if(AdMobBanner.this.listener != null) {
               AdMobBanner.this.listener.onBannerLoaded(AdMobBanner.this.adView);
            }

         }

         public void onAdOpened() {
            if(AdMobBanner.this.listener != null) {
               AdMobBanner.this.listener.onBannerExpanded();
            }

         }
      };
   }

   public void destroy() {
      if(this.adView != null) {
         this.adView.a();
      }

      super.destroy();
   }

   public void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, String var3, String var4, int var5, int var6) {
      this.listener = var2;

      try {
         Class.forName("com.google.android.gms.ads.AdView");
         Class.forName("com.google.android.gms.ads.a");
         Class.forName("com.google.android.gms.ads.b");
         Class.forName("com.google.android.gms.ads.d");
      } catch (ClassNotFoundException var7) {
         if(this.listener == null) {
            return;
         }

         this.listener.onBannerFailed();
         return;
      }

      this.trackingPixel = var4;
      this.adView = new AdView(var1);
      this.adView.a(var3);
      this.adView.a(new com.google.android.gms.ads.d(var5, var6));
      this.adView.a(this.createAdListener());
      com.google.android.gms.ads.b var8 = (new com.google.android.gms.ads.c()).b(com.google.android.gms.ads.b.a).a();
      this.adView.a(var8);
   }
}
