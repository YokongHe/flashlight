package com.adsdk.sdk.customevents;

import android.app.Activity;
import android.os.Handler;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyVideoAd;

public class AdColonyFullscreen extends CustomEventFullscreen {
   private static boolean initialized;
   private boolean reported;
   private AdColonyVideoAd videoAd;

   private AdColonyAdListener createListener() {
      return new AdColonyAdListener() {
         public void onAdColonyAdAttemptFinished(AdColonyAd var1) {
            if(!var1.notShown() && !var1.noFill()) {
               if(AdColonyFullscreen.this.listener != null) {
                  AdColonyFullscreen.this.listener.onFullscreenClosed();
                  return;
               }
            } else if(AdColonyFullscreen.this.listener != null && !AdColonyFullscreen.this.reported) {
               AdColonyFullscreen.this.reported = true;
               AdColonyFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public void onAdColonyAdStarted(AdColonyAd var1) {
            AdColonyFullscreen.this.reportImpression();
            if(AdColonyFullscreen.this.listener != null) {
               AdColonyFullscreen.this.listener.onFullscreenOpened();
            }

         }
      };
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      String[] var6 = var3.split(";");
      var3 = var6[0];
      String var5 = var6[1];
      String var8 = var6[2];
      this.listener = var2;
      this.trackingPixel = var4;
      this.reported = false;

      try {
         Class.forName("com.jirbo.adcolony.AdColony");
         Class.forName("com.jirbo.adcolony.AdColonyAd");
         Class.forName("com.jirbo.adcolony.AdColonyAdAvailabilityListener");
         Class.forName("com.jirbo.adcolony.AdColonyAdListener");
         Class.forName("com.jirbo.adcolony.AdColonyVideoAd");
      } catch (ClassNotFoundException var7) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      if(!initialized) {
         AdColony.configure(var1, var3, var5, new String[]{var8});
         initialized = true;
      }

      this.videoAd = (new AdColonyVideoAd()).withListener(this.createListener());
      if(!this.videoAd.isReady()) {
         (new Handler()).postDelayed(new Runnable() {
            public void run() {
               if(AdColonyFullscreen.this.videoAd.isReady()) {
                  if(AdColonyFullscreen.this.listener != null && !AdColonyFullscreen.this.reported) {
                     AdColonyFullscreen.this.reported = true;
                     AdColonyFullscreen.this.listener.onFullscreenLoaded(AdColonyFullscreen.this);
                  }
               } else if(AdColonyFullscreen.this.listener != null && !AdColonyFullscreen.this.reported) {
                  AdColonyFullscreen.this.reported = true;
                  AdColonyFullscreen.this.listener.onFullscreenFailed();
                  return;
               }

            }
         }, 5000L);
      } else {
         if(this.listener != null && !this.reported) {
            this.reported = true;
            this.listener.onFullscreenLoaded(this);
         }

      }
   }

   public void showFullscreen() {
      if(this.videoAd != null && this.videoAd.isReady()) {
         this.videoAd.show();
      }

   }
}
