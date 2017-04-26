package com.adsdk.sdk.customevents;

import android.content.Context;
import android.widget.FrameLayout;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import com.flurry.android.FlurryAgent;

public class FlurryBanner extends CustomEventBanner implements FlurryAdListener {
   private String adSpace;
   private FrameLayout bannerLayout;
   private Context context;

   public void destroy() {
      FlurryAds.setAdListener((FlurryAdListener)null);
      FlurryAds.removeAd(this.context, this.adSpace, this.bannerLayout);
      FlurryAgent.onEndSession(this.context);
      super.destroy();
   }

   protected void finalize() {
      this.destroy();
      super.finalize();
   }

   public void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, String var3, String var4, int var5, int var6) {
      String[] var8 = var3.split(";");
      if(var8.length != 2) {
         if(this.listener != null) {
            this.listener.onBannerFailed();
         }
      } else {
         this.context = var1;
         this.adSpace = var8[0];
         var3 = var8[1];
         this.listener = var2;
         this.trackingPixel = var4;

         try {
            Class.forName("com.flurry.android.FlurryAdListener");
            Class.forName("com.flurry.android.FlurryAdSize");
            Class.forName("com.flurry.android.FlurryAdType");
            Class.forName("com.flurry.android.FlurryAds");
            Class.forName("com.flurry.android.FlurryAgent");
         } catch (ClassNotFoundException var7) {
            if(this.listener == null) {
               return;
            }

            this.listener.onBannerFailed();
            return;
         }

         FlurryAgent.onStartSession(var1, var3);
         this.bannerLayout = new FrameLayout(var1);
         FlurryAds.setAdListener(this);
         FlurryAds.fetchAd(var1, this.adSpace, this.bannerLayout, FlurryAdSize.BANNER_BOTTOM);
         return;
      }

   }

   public void onAdClicked(String var1) {
   }

   public void onAdClosed(String var1) {
      if(this.listener != null && var1.equals(this.adSpace)) {
         this.listener.onBannerClosed();
      }

   }

   public void onAdOpened(String var1) {
      if(this.listener != null && var1.equals(this.adSpace)) {
         this.listener.onBannerExpanded();
      }

   }

   public void onApplicationExit(String var1) {
   }

   public void onRenderFailed(String var1) {
   }

   public void onRendered(String var1) {
   }

   public void onVideoCompleted(String var1) {
   }

   public boolean shouldDisplayAd(String var1, FlurryAdType var2) {
      return true;
   }

   public void spaceDidFailToReceiveAd(String var1) {
      if(this.listener != null && var1.equals(this.adSpace)) {
         this.listener.onBannerFailed();
      }

   }

   public void spaceDidReceiveAd(String var1) {
      if(var1.equals(this.adSpace)) {
         this.reportImpression();
         FlurryAds.displayAd(this.context, this.adSpace, this.bannerLayout);
         if(this.listener != null) {
            this.listener.onBannerLoaded(this.bannerLayout);
         }
      }

   }
}
