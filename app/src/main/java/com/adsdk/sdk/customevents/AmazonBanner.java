package com.adsdk.sdk.customevents;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdSize;

public class AmazonBanner extends CustomEventBanner {
   private AdLayout banner;

   private AdListener createListener() {
      return new AdListener() {
         public void onAdCollapsed(Ad var1) {
            if(AmazonBanner.this.listener != null) {
               AmazonBanner.this.listener.onBannerClosed();
            }

         }

         public void onAdDismissed(Ad var1) {
         }

         public void onAdExpanded(Ad var1) {
            if(AmazonBanner.this.listener != null) {
               AmazonBanner.this.listener.onBannerExpanded();
            }

         }

         public void onAdFailedToLoad(Ad var1, AdError var2) {
            if(AmazonBanner.this.listener != null) {
               AmazonBanner.this.listener.onBannerFailed();
            }

         }

         public void onAdLoaded(Ad var1, AdProperties var2) {
            AmazonBanner.this.reportImpression();
            if(AmazonBanner.this.listener != null) {
               AmazonBanner.this.listener.onBannerLoaded(AmazonBanner.this.banner);
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
         Class.forName("com.amazon.device.ads.Ad");
         Class.forName("com.amazon.device.ads.AdError");
         Class.forName("com.amazon.device.ads.AdLayout");
         Class.forName("com.amazon.device.ads.AdListener");
         Class.forName("com.amazon.device.ads.AdProperties");
         Class.forName("com.amazon.device.ads.AdRegistration");
         Class.forName("com.amazon.device.ads.AdSize");
      } catch (ClassNotFoundException var7) {
         if(this.listener == null) {
            return;
         }

         this.listener.onBannerFailed();
         return;
      }

      if(var1 instanceof Activity) {
         AdRegistration.setAppKey(var3);
         this.banner = new AdLayout((Activity)var1, new AdSize(var5, var6));
         this.banner.setListener(this.createListener());
         this.banner.setLayoutParams(new LayoutParams(-1, -1));
         this.banner.loadAd();
      } else {
         if(this.listener != null) {
            this.listener.onBannerFailed();
         }

      }
   }
}
