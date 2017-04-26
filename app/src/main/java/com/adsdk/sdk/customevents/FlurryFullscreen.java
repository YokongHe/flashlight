package com.adsdk.sdk.customevents;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import com.flurry.android.FlurryAgent;

public class FlurryFullscreen extends CustomEventFullscreen implements FlurryAdListener {
   private String adSpace;
   private Context context;
   private FrameLayout layout;

   public void finish() {
      FlurryAds.setAdListener((FlurryAdListener)null);
      FlurryAds.removeAd(this.context, this.adSpace, this.layout);
      FlurryAgent.onEndSession(this.context);
      super.finish();
   }

   public void loadFullscreen(Activity var1, CustomEventFullscreen$CustomEventFullscreenListener var2, String var3, String var4) {
      this.listener = var2;
      String[] var6 = var3.split(";");
      if(var6.length != 2) {
         if(this.listener != null) {
            this.listener.onFullscreenFailed();
         }
      } else {
         this.context = var1;
         this.adSpace = var6[0];
         String var7 = var6[1];
         this.trackingPixel = var4;

         try {
            Class.forName("com.flurry.android.FlurryAdListener");
            Class.forName("com.flurry.android.FlurryAdSize");
            Class.forName("com.flurry.android.FlurryAdType");
            Class.forName("com.flurry.android.FlurryAds");
            Class.forName("com.flurry.android.FlurryAgent");
         } catch (ClassNotFoundException var5) {
            if(this.listener == null) {
               return;
            }

            this.listener.onFullscreenFailed();
            return;
         }

         this.layout = new FrameLayout(this.context);
         FlurryAgent.onStartSession(var1, var7);
         FlurryAds.setAdListener(this);
         FlurryAds.fetchAd(this.context, this.adSpace, this.layout, FlurryAdSize.FULLSCREEN);
         return;
      }

   }

   public void onAdClicked(String var1) {
   }

   public void onAdClosed(String var1) {
      if(this.listener != null && var1.equals(this.adSpace)) {
         this.listener.onFullscreenClosed();
      }

   }

   public void onAdOpened(String var1) {
      if(var1.equals(this.adSpace)) {
         this.reportImpression();
         if(this.listener != null) {
            this.listener.onFullscreenOpened();
         }
      }

   }

   public void onApplicationExit(String var1) {
      if(this.listener != null && var1.equals(this.adSpace)) {
         this.listener.onFullscreenLeftApplication();
      }

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

   public void showFullscreen() {
      FlurryAds.displayAd(this.context, this.adSpace, this.layout);
   }

   public void spaceDidFailToReceiveAd(String var1) {
      if(this.listener != null) {
         this.listener.onFullscreenFailed();
      }

   }

   public void spaceDidReceiveAd(String var1) {
      if(this.listener != null && var1.equals(this.adSpace)) {
         this.listener.onFullscreenLoaded(this);
      }

   }
}
