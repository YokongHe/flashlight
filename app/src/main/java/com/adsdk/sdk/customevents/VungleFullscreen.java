package com.adsdk.sdk.customevents;

import android.app.Activity;
import android.os.Handler;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.vungle.publisher.EventListener;
import com.vungle.publisher.VunglePub;

public class VungleFullscreen extends CustomEventFullscreen {
   private boolean alreadyReportedAdLoadStatus;
   private VunglePub vunglePub;

   private EventListener createListener() {
      return new EventListener() {
         public void onAdEnd(boolean var1) {
            if(VungleFullscreen.this.listener != null) {
               if(var1) {
                  VungleFullscreen.this.listener.onFullscreenLeftApplication();
               }

               VungleFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void onAdStart() {
            VungleFullscreen.this.reportImpression();
            if(VungleFullscreen.this.listener != null) {
               VungleFullscreen.this.listener.onFullscreenOpened();
            }

         }

         public void onAdUnavailable(String var1) {
            if(VungleFullscreen.this.listener != null && !VungleFullscreen.this.alreadyReportedAdLoadStatus) {
               VungleFullscreen.this.listener.onFullscreenFailed();
               VungleFullscreen.this.alreadyReportedAdLoadStatus = true;
            }

         }

         public void onCachedAdAvailable() {
            if(VungleFullscreen.this.listener != null && !VungleFullscreen.this.alreadyReportedAdLoadStatus) {
               VungleFullscreen.this.listener.onFullscreenLoaded(VungleFullscreen.this);
               VungleFullscreen.this.alreadyReportedAdLoadStatus = true;
            }

         }

         public void onVideoView(boolean var1, int var2, int var3) {
         }
      };
   }

   public void finish() {
      super.finish();
      this.vunglePub.setEventListener((EventListener)null);
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.alreadyReportedAdLoadStatus = false;
      this.trackingPixel = var4;

      try {
         Class.forName("com.vungle.publisher.EventListener");
         Class.forName("com.vungle.publisher.VunglePub");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      this.vunglePub = VunglePub.getInstance();
      this.vunglePub.init(var1, var3);
      this.vunglePub.setEventListener(this.createListener());
      if(!this.vunglePub.isCachedAdAvailable()) {
         (new Handler()).postDelayed(new Runnable() {
            public void run() {
               if(VungleFullscreen.this.vunglePub.isCachedAdAvailable()) {
                  if(VungleFullscreen.this.listener != null && !VungleFullscreen.this.alreadyReportedAdLoadStatus) {
                     VungleFullscreen.this.listener.onFullscreenLoaded(VungleFullscreen.this);
                     VungleFullscreen.this.alreadyReportedAdLoadStatus = true;
                  }
               } else if(VungleFullscreen.this.listener != null && !VungleFullscreen.this.alreadyReportedAdLoadStatus) {
                  VungleFullscreen.this.listener.onFullscreenFailed();
                  VungleFullscreen.this.alreadyReportedAdLoadStatus = true;
                  return;
               }

            }
         }, 5000L);
      } else {
         if(this.listener != null) {
            this.listener.onFullscreenLoaded(this);
         }

      }
   }

   public void showFullscreen() {
      if(this.vunglePub != null && this.vunglePub.isCachedAdAvailable()) {
         this.vunglePub.playAd();
      }

   }
}
