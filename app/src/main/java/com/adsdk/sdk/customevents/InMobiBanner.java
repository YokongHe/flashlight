package com.adsdk.sdk.customevents;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import java.util.Map;

public class InMobiBanner extends CustomEventBanner {
   private static boolean isInitialized;
   private IMBanner banner;
   private FrameLayout bannerLayout;
   private boolean reportedClick;

   private IMBannerListener createListener() {
      return new IMBannerListener() {
         public void onBannerInteraction(IMBanner var1, Map var2) {
         }

         public void onBannerRequestFailed(IMBanner var1, IMErrorCode var2) {
            if(InMobiBanner.this.listener != null) {
               InMobiBanner.this.listener.onBannerFailed();
            }

         }

         public void onBannerRequestSucceeded(IMBanner var1) {
            InMobiBanner.this.reportImpression();
            if(InMobiBanner.this.listener != null) {
               InMobiBanner.this.listener.onBannerLoaded(InMobiBanner.this.bannerLayout);
            }

         }

         public void onDismissBannerScreen(IMBanner var1) {
            InMobiBanner.this.reportedClick = false;
            if(InMobiBanner.this.listener != null) {
               InMobiBanner.this.listener.onBannerClosed();
            }

         }

         public void onLeaveApplication(IMBanner var1) {
            if(InMobiBanner.this.listener != null && !InMobiBanner.this.reportedClick) {
               InMobiBanner.this.reportedClick = true;
               InMobiBanner.this.listener.onBannerExpanded();
            }

         }

         public void onShowBannerScreen(IMBanner var1) {
            if(InMobiBanner.this.listener != null && !InMobiBanner.this.reportedClick) {
               InMobiBanner.this.reportedClick = true;
               InMobiBanner.this.listener.onBannerExpanded();
            }

         }
      };
   }

   public void destroy() {
      if(this.bannerLayout != null) {
         this.bannerLayout.removeAllViews();
         this.bannerLayout = null;
      }

      this.banner = null;
      super.destroy();
   }

   public void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, String var3, String var4, int var5, int var6) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.inmobi.commons.InMobi");
         Class.forName("com.inmobi.monetization.IMBanner");
         Class.forName("com.inmobi.monetization.IMBannerListener");
         Class.forName("com.inmobi.monetization.IMErrorCode");
      } catch (ClassNotFoundException var8) {
         if(this.listener == null) {
            return;
         }

         this.listener.onBannerFailed();
         return;
      }

      if(var1 instanceof Activity) {
         this.bannerLayout = new FrameLayout(var1);
         if(!isInitialized) {
            InMobi.initialize(var1, var3);
            isInitialized = true;
         }

         if(var5 >= 728 && var6 >= 90) {
            this.banner = new IMBanner((Activity)var1, var3, 11);
         } else if(var5 >= 300 && var6 >= 250) {
            this.banner = new IMBanner((Activity)var1, var3, 10);
         } else if(var5 >= 468 && var6 >= 60) {
            this.banner = new IMBanner((Activity)var1, var3, 12);
         } else {
            this.banner = new IMBanner((Activity)var1, var3, 15);
         }

         this.banner.setIMBannerListener(this.createListener());
         this.banner.setRefreshInterval(-1);
         float var7 = var1.getResources().getDisplayMetrics().density;
         this.bannerLayout.addView(this.banner, new LayoutParams((int)((float)var5 * var7 + 0.5F), (int)(var7 * (float)var6 + 0.5F)));
         this.banner.loadBanner();
      } else {
         if(this.listener != null) {
            this.listener.onBannerFailed();
         }

      }
   }
}
