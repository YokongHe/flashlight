package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMInterstitial;
import com.inmobi.monetization.IMInterstitial$State;
import com.inmobi.monetization.IMInterstitialListener;
import java.util.Map;

public class InMobiFullscreen extends CustomEventFullscreen {
   private static boolean isInitialized;
   private IMInterstitial interstitial;

   private IMInterstitialListener createListener() {
      return new IMInterstitialListener() {
         public void onDismissInterstitialScreen(IMInterstitial var1) {
            if(InMobiFullscreen.this.listener != null) {
               InMobiFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void onInterstitialFailed(IMInterstitial var1, IMErrorCode var2) {
            if(InMobiFullscreen.this.listener != null) {
               InMobiFullscreen.this.listener.onFullscreenFailed();
            }

         }

         public void onInterstitialInteraction(IMInterstitial var1, Map var2) {
            if(InMobiFullscreen.this.listener != null) {
               InMobiFullscreen.this.listener.onFullscreenLeftApplication();
            }

         }

         public void onInterstitialLoaded(IMInterstitial var1) {
            if(InMobiFullscreen.this.listener != null) {
               InMobiFullscreen.this.listener.onFullscreenLoaded(InMobiFullscreen.this);
            }

         }

         public void onLeaveApplication(IMInterstitial var1) {
         }

         public void onShowInterstitialScreen(IMInterstitial var1) {
            InMobiFullscreen.this.reportImpression();
            if(InMobiFullscreen.this.listener != null) {
               InMobiFullscreen.this.listener.onFullscreenOpened();
            }

         }
      };
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.inmobi.commons.InMobi");
         Class.forName("com.inmobi.monetization.IMErrorCode");
         Class.forName("com.inmobi.monetization.IMInterstitial");
         Class.forName("com.inmobi.monetization.IMInterstitialListener");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      if(!isInitialized) {
         InMobi.initialize(var1, var3);
         isInitialized = true;
      }

      this.interstitial = new IMInterstitial(var1, var3);
      this.interstitial.setIMInterstitialListener(this.createListener());
      this.interstitial.loadInterstitial();
   }

   public void showFullscreen() {
      if(this.interstitial.getState() == IMInterstitial$State.READY) {
         this.interstitial.show();
      }

   }
}
