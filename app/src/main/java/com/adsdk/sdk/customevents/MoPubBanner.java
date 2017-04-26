package com.adsdk.sdk.customevents;

import android.content.Context;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView$BannerAdListener;

public class MoPubBanner extends CustomEventBanner {
   private MoPubView banner;
   private boolean reportedClick;

   private MoPubView$BannerAdListener createListener() {
      return new MoPubView$BannerAdListener() {
         public void onBannerClicked(MoPubView var1) {
            if(MoPubBanner.this.listener != null && !MoPubBanner.this.reportedClick) {
               MoPubBanner.this.reportedClick = true;
               MoPubBanner.this.listener.onBannerExpanded();
            }

         }

         public void onBannerCollapsed(MoPubView var1) {
            if(MoPubBanner.this.listener != null) {
               MoPubBanner.this.reportedClick = false;
               MoPubBanner.this.listener.onBannerClosed();
            }

         }

         public void onBannerExpanded(MoPubView var1) {
            if(MoPubBanner.this.listener != null && !MoPubBanner.this.reportedClick) {
               MoPubBanner.this.reportedClick = true;
               MoPubBanner.this.listener.onBannerExpanded();
            }

         }

         public void onBannerFailed(MoPubView var1, MoPubErrorCode var2) {
            if(MoPubBanner.this.listener != null) {
               MoPubBanner.this.listener.onBannerFailed();
            }

         }

         public void onBannerLoaded(MoPubView var1) {
            MoPubBanner.this.reportImpression();
            if(MoPubBanner.this.listener != null) {
               MoPubBanner.this.listener.onBannerLoaded(MoPubBanner.this.banner);
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
         Class.forName("com.mopub.mobileads.MoPubView");
         Class.forName("com.mopub.mobileads.MoPubErrorCode");
      } catch (ClassNotFoundException var7) {
         if(this.listener == null) {
            return;
         }

         this.listener.onBannerFailed();
         return;
      }

      this.banner = new MoPubView(var1);
      this.banner.setAdUnitId(var3);
      this.banner.setAutorefreshEnabled(false);
      this.banner.setBannerAdListener(this.createListener());
      this.banner.loadAd();
   }
}
