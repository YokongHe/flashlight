package com.adsdk.sdk.customevents;

import android.app.Activity;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.RequestListener;

public class MillennialFullscreen extends CustomEventFullscreen {
   private MMInterstitial interstitial;
   private boolean wasTapped;

   private RequestListener createListener() {
      return new RequestListener() {
         public void MMAdOverlayClosed(MMAd var1) {
            if(MillennialFullscreen.this.listener != null) {
               MillennialFullscreen.this.listener.onFullscreenClosed();
            }

         }

         public void MMAdOverlayLaunched(MMAd var1) {
            MillennialFullscreen.this.reportImpression();
            if(MillennialFullscreen.this.listener != null) {
               MillennialFullscreen.this.listener.onFullscreenOpened();
            }

         }

         public void MMAdRequestIsCaching(MMAd var1) {
         }

         public void onSingleTap(MMAd var1) {
            if(MillennialFullscreen.this.listener != null && MillennialFullscreen.this.wasTapped) {
               MillennialFullscreen.this.listener.onFullscreenLeftApplication();
            }

            MillennialFullscreen.this.wasTapped = true;
         }

         public void requestCompleted(MMAd var1) {
            if(MillennialFullscreen.this.listener != null) {
               MillennialFullscreen.this.listener.onFullscreenLoaded(MillennialFullscreen.this);
            }

         }

         public void requestFailed(MMAd var1, MMException var2) {
            if(MillennialFullscreen.this.listener != null) {
               MillennialFullscreen.this.listener.onFullscreenFailed();
            }

         }
      };
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      this.trackingPixel = var4;

      try {
         Class.forName("com.millennialmedia.android.MMAd");
         Class.forName("com.millennialmedia.android.MMException");
         Class.forName("com.millennialmedia.android.MMInterstitial");
         Class.forName("com.millennialmedia.android.MMRequest");
         Class.forName("com.millennialmedia.android.RequestListener");
      } catch (ClassNotFoundException var5) {
         if(this.listener == null) {
            return;
         }

         this.listener.onFullscreenFailed();
         return;
      }

      this.interstitial = new MMInterstitial(var1);
      this.interstitial.setListener(this.createListener());
      this.interstitial.setApid(var3);
      MMRequest var6 = new MMRequest();
      this.interstitial.setMMRequest(var6);
      if(!this.interstitial.isAdAvailable()) {
         this.interstitial.fetch();
      } else if(this.listener != null) {
         this.listener.onFullscreenLoaded(this);
         return;
      }

   }

   public void showFullscreen() {
      if(this.interstitial != null && this.interstitial.isAdAvailable()) {
         this.interstitial.display();
      }

   }
}
