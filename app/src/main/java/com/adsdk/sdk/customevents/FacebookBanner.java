package com.adsdk.sdk.customevents;

import android.content.Context;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class FacebookBanner extends CustomEventBanner {
   private AdView banner;

   private AdListener createListener() {
      return new AdListener() {
         public void onAdClicked(Ad var1) {
            if(FacebookBanner.this.listener != null) {
               FacebookBanner.this.listener.onBannerExpanded();
            }

         }

         public void onAdLoaded(Ad var1) {
            FacebookBanner.this.reportImpression();
            if(FacebookBanner.this.listener != null) {
               FacebookBanner.this.listener.onBannerLoaded(FacebookBanner.this.banner);
            }

         }

         public void onError(Ad var1, AdError var2) {
            if(FacebookBanner.this.listener != null) {
               FacebookBanner.this.listener.onBannerFailed();
            }

         }
      };
   }

   public void destroy() {
      if(this.banner != null) {
         this.banner.destroy();
      }

      super.destroy();
   }

   public void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, String var3, String var4, int var5, int var6) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.facebook.ads.Ad");
         Class.forName("com.facebook.ads.AdError");
         Class.forName("com.facebook.ads.AdListener");
         Class.forName("com.facebook.ads.AdSize");
         Class.forName("com.facebook.ads.AdView");
      } catch (ClassNotFoundException var7) {
         if(this.listener == null) {
            return;
         }

         this.listener.onBannerFailed();
         return;
      }

      this.banner = new AdView(var1, var3, AdSize.BANNER_320_50);
      this.banner.setAdListener(this.createListener());
      this.banner.loadAd();
   }
}
