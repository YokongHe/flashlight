package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.unity3d.ads.android.IUnityAdsListener;
import com.unity3d.ads.android.UnityAds;

public class ApplifierFullscreen extends CustomEventFullscreen {
   private static boolean initialized;
   private boolean shouldReportAvailability;

   private IUnityAdsListener createListener() {
      return new IUnityAdsListener() {
         public void onFetchCompleted() {
            if(ApplifierFullscreen.this.listener != null && ApplifierFullscreen.this.shouldReportAvailability) {
               ApplifierFullscreen.this.listener.onFullscreenLoaded(ApplifierFullscreen.this);
            }

         }

         public void onFetchFailed() {
            if(ApplifierFullscreen.this.listener != null && ApplifierFullscreen.this.shouldReportAvailability) {
               ApplifierFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public void onHide() {
            if(ApplifierFullscreen.this.listener != null) {
               ApplifierFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void onShow() {
            ApplifierFullscreen.this.reportImpression();
            if(ApplifierFullscreen.this.listener != null) {
               ApplifierFullscreen.this.listener.onFullscreenOpened();
            }

         }

         public void onVideoCompleted(String var1, boolean var2) {
         }

         public void onVideoStarted() {
         }
      };
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.shouldReportAvailability = true;
      this.trackingPixel = var4;

      try {
         Class.forName("com.unity3d.ads.android.IUnityAdsListener");
         Class.forName("com.unity3d.ads.android.UnityAds");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      if(!initialized) {
         UnityAds.init(var1, var3, this.createListener());
         initialized = true;
      } else {
         if(UnityAds.canShowAds()) {
            this.shouldReportAvailability = false;
            if(this.listener != null) {
               this.listener.onFullscreenLoaded(this);
            }

            UnityAds.setListener(this.createListener());
            return;
         }

         this.shouldReportAvailability = false;
         if(this.listener != null) {
            this.listener.onFullscreenFailed();
            return;
         }
      }

   }

   public void showFullscreen() {
      if(UnityAds.canShow() && UnityAds.canShowAds()) {
         UnityAds.show();
      }

   }
}
