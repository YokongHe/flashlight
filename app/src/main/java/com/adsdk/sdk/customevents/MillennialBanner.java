package com.adsdk.sdk.customevents;

import android.content.Context;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;

public class MillennialBanner extends CustomEventBanner {
   private MMAdView millenialAdView;

   private RequestListener createAdListener() {
      return new RequestListener() {
         public void MMAdOverlayClosed(MMAd var1) {
            if(MillennialBanner.this.listener != null) {
               MillennialBanner.this.listener.onBannerClosed();
            }

         }

         public void MMAdOverlayLaunched(MMAd var1) {
            if(MillennialBanner.this.listener != null) {
               MillennialBanner.this.listener.onBannerExpanded();
            }

         }

         public void MMAdRequestIsCaching(MMAd var1) {
         }

         public void onSingleTap(MMAd var1) {
         }

         public void requestCompleted(MMAd var1) {
            MillennialBanner.this.reportImpression();
            if(MillennialBanner.this.listener != null) {
               MillennialBanner.this.listener.onBannerLoaded(MillennialBanner.this.millenialAdView);
            }

         }

         public void requestFailed(MMAd var1, MMException var2) {
            if(MillennialBanner.this.listener != null) {
               MillennialBanner.this.listener.onBannerFailed();
            }

         }
      };
   }

   public void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, String var3, String var4, int var5, int var6) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.millennialmedia.android.MMAd");
         Class.forName("com.millennialmedia.android.MMAdView");
         Class.forName("com.millennialmedia.android.MMException");
         Class.forName("com.millennialmedia.android.MMRequest");
         Class.forName("com.millennialmedia.android.MMSDK");
         Class.forName("com.millennialmedia.android.RequestListener");
      } catch (ClassNotFoundException var7) {
         if(this.listener == null) {
            return;
         }

         this.listener.onBannerFailed();
         return;
      }

      this.millenialAdView = new MMAdView(var1);
      this.millenialAdView.setId(MMSDK.getDefaultAdId());
      this.millenialAdView.setWidth(var5);
      this.millenialAdView.setHeight(var6);
      this.millenialAdView.setApid(var3);
      MMRequest var8 = new MMRequest();
      this.millenialAdView.setMMRequest(var8);
      this.millenialAdView.setListener(this.createAdListener());
      this.millenialAdView.getAd();
   }
}
