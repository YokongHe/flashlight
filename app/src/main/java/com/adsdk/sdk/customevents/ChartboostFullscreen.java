package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public class ChartboostFullscreen extends CustomEventFullscreen {
   private Activity activity;
   private String locationName = "Default";
   private boolean shouldDisplay;
   private boolean shouldReportAvailability;

   private ChartboostDelegate createListener() {
      return new ChartboostDelegate() {
         public void didCacheInterstitial(String var1) {
            if(ChartboostFullscreen.this.listener != null && ChartboostFullscreen.this.shouldReportAvailability) {
               ChartboostFullscreen.this.shouldReportAvailability = false;
               ChartboostFullscreen.this.listener.onFullscreenLoaded(ChartboostFullscreen.this);
            }

         }

         public void didClickInterstitial(String var1) {
            if(ChartboostFullscreen.this.listener != null) {
               ChartboostFullscreen.this.listener.onFullscreenLeftApplication();
            }

         }

         public void didDismissInterstitial(String var1) {
            if(ChartboostFullscreen.this.listener != null) {
               ChartboostFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void didDisplayInterstitial(String var1) {
            ChartboostFullscreen.this.reportImpression();
            if(ChartboostFullscreen.this.listener != null) {
               ChartboostFullscreen.this.listener.onFullscreenOpened();
            }

            ChartboostFullscreen.this.shouldDisplay = false;
         }

         public void didFailToLoadInterstitial(String var1, CBImpressionError var2) {
            if(ChartboostFullscreen.this.listener != null && ChartboostFullscreen.this.shouldReportAvailability) {
               ChartboostFullscreen.this.shouldReportAvailability = false;
               ChartboostFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public boolean shouldDisplayInterstitial(String var1) {
            return ChartboostFullscreen.this.shouldDisplay;
         }
      };
   }

   public void finish() {
      if(this.activity != null) {
         Chartboost.onPause(this.activity);
         Chartboost.onStop(this.activity);
         Chartboost.onDestroy(this.activity);
      }

      this.activity = null;
      super.finish();
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      String[] var5 = var3.split(";");
      var3 = var5[0];
      String var7 = var5[1];
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.chartboost.sdk.Chartboost");
         Class.forName("com.chartboost.sdk.ChartboostDelegate");
         Class.forName("com.chartboost.sdk.Model.CBError");
         Class.forName("com.chartboost.sdk.CBLocation");
      } catch (ClassNotFoundException var6) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      this.activity = var1;
      Chartboost.startWithAppId(var1, var3, var7);
      Chartboost.setDelegate(this.createListener());
      Chartboost.setAutoCacheAds(false);
      Chartboost.onCreate(var1);
      Chartboost.onStart(var1);
      Chartboost.onResume(var1);
      this.shouldReportAvailability = true;
      Chartboost.cacheInterstitial(this.locationName);
   }

   public void showFullscreen() {
      if(Chartboost.hasInterstitial(this.locationName)) {
         this.shouldDisplay = true;
         Chartboost.showInterstitial(this.locationName);
      }

   }
}
