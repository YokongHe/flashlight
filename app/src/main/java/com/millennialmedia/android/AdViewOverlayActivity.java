package com.millennialmedia.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.AdViewOverlayView;
import com.millennialmedia.android.BridgeMMMedia$Audio;
import com.millennialmedia.android.MMBaseActivity;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.OverlaySettings;

class AdViewOverlayActivity extends MMBaseActivity {
   private static final String TAG = "AdViewOverlayActivity";
   private AdViewOverlayView adViewOverlayView;
   boolean hasFocus;
   boolean isPaused;
   private OverlaySettings settings;

   private void lockOrientation() {
      if(this.activity.getRequestedOrientation() == 0) {
         this.setRequestedOrientation(0);
      } else if(this.activity.getRequestedOrientation() == 8) {
         this.setRequestedOrientation(8);
      } else if(this.activity.getRequestedOrientation() == 9) {
         this.setRequestedOrientation(9);
      } else {
         this.setRequestedOrientation(1);
      }
   }

   private void setRequestedOrientation(String var1) {
      if("landscape".equalsIgnoreCase(var1)) {
         this.setRequestedOrientation(0);
      } else if("portrait".equalsIgnoreCase(var1)) {
         this.setRequestedOrientation(1);
         return;
      }

   }

   public void finish() {
      if(this.adViewOverlayView != null) {
         if(!this.adViewOverlayView.attachWebViewToLink()) {
            this.adViewOverlayView.killWebView();
         }

         this.adViewOverlayView.removeSelfAndAll();
      }

      this.adViewOverlayView = null;
      super.finish();
   }

   public void onConfigurationChanged(Configuration var1) {
      if(this.adViewOverlayView != null) {
         this.adViewOverlayView.inlineConfigChange();
      }

      super.onConfigurationChanged(var1);
   }

   protected void onCreate(Bundle var1) {
      this.setTheme(16973840);
      super.onCreate(var1);
      this.requestWindowFeature(1);
      this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.getWindow().clearFlags(1024);
      this.getWindow().addFlags(2048);
      this.getWindow().addFlags(16777216);
      Intent var3 = this.getIntent();
      this.settings = (OverlaySettings)var3.getParcelableExtra("settings");
      if(this.settings == null) {
         this.settings = new OverlaySettings();
      }

      this.settings.log();
      if(this.settings.orientation != null) {
         this.setRequestedOrientation(this.settings.orientation);
      }

      if(this.settings.allowOrientationChange) {
         this.unlockScreenOrientation();
      } else {
         this.lockOrientation();
      }

      if(var3 != null) {
         Uri var4 = var3.getData();
         if(var4 != null) {
            MMLog.v("AdViewOverlayActivity", String.format("Path: %s", new Object[]{var4.getLastPathSegment()}));
         }
      }

      RelativeLayout var5 = new RelativeLayout(this.activity);
      LayoutParams var2 = new LayoutParams(-2, -2);
      var2.addRule(13);
      var5.setId(885394873);
      var5.setLayoutParams(var2);
      this.adViewOverlayView = new AdViewOverlayView(this, this.settings);
      var5.addView(this.adViewOverlayView);
      this.setContentView(var5);
      if(this.getLastNonConfigurationInstance() == null) {
         if(this.settings.isExpanded()) {
            if(this.adViewOverlayView.adImpl != null && this.adViewOverlayView.adImpl.controller != null && this.adViewOverlayView.adImpl.controller.webView != null) {
               this.adViewOverlayView.adImpl.controller.webView.setMraidExpanded();
            }

            if(this.settings.hasExpandUrl()) {
               this.adViewOverlayView.getWebContent(this.settings.urlToLoad);
            }
         } else if(!this.settings.isExpanded()) {
            this.adViewOverlayView.loadWebContent(this.settings.content, this.settings.adUrl);
         }
      }

      this.settings.orientation = null;
   }

   protected void onDestroy() {
      super.onDestroy();
      MMLog.d("AdViewOverlayActivity", "Overlay onDestroy");
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4 && var2.getRepeatCount() == 0 && this.adViewOverlayView != null) {
         this.adViewOverlayView.finishOverlayWithAnimation();
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   protected void onPause() {
      this.isPaused = true;
      MMLog.d("AdViewOverlayActivity", "Overlay onPause");
      BridgeMMMedia$Audio var1 = BridgeMMMedia$Audio.sharedAudio(this.activity);
      if(var1 != null) {
         synchronized(this) {
            var1.stop();
         }
      }

      if(this.adViewOverlayView != null) {
         this.adViewOverlayView.pauseVideo();
         if(this.adViewOverlayView.adImpl != null && this.adViewOverlayView.adImpl.controller != null && this.adViewOverlayView.adImpl.controller.webView != null) {
            this.adViewOverlayView.adImpl.controller.webView.onPauseWebView();
         }
      }

      this.setResult(0);
      super.onPause();
   }

   protected void onRestoreInstanceState(Bundle var1) {
      super.onRestoreInstanceState(var1);
   }

   protected void onResume() {
      this.isPaused = false;
      MMLog.d("AdViewOverlayActivity", "Overlay onResume");
      if(this.adViewOverlayView != null) {
         if(this.hasFocus) {
            this.adViewOverlayView.resumeVideo();
         }

         this.adViewOverlayView.addBlackView();
         if(this.adViewOverlayView.adImpl != null && this.adViewOverlayView.adImpl.controller != null && this.adViewOverlayView.adImpl.controller.webView != null) {
            this.adViewOverlayView.adImpl.controller.webView.onResumeWebView();
         }
      }

      super.onResume();
   }

   public Object onRetainNonConfigurationInstance() {
      return this.adViewOverlayView != null?this.adViewOverlayView.getNonConfigurationInstance():null;
   }

   protected void onSaveInstanceState(Bundle var1) {
      if(this.adViewOverlayView != null) {
         var1.putInt("adViewId", this.adViewOverlayView.getId());
      }

      super.onSaveInstanceState(var1);
   }

   protected void onStop() {
      super.onStop();
   }

   public void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      this.hasFocus = var1;
      if(!this.isPaused && var1) {
         this.adViewOverlayView.resumeVideo();
      }

   }

   void setAllowOrientationChange(boolean var1) {
      this.settings.allowOrientationChange = var1;
      if(var1) {
         this.unlockScreenOrientation();
      } else {
         this.lockOrientation();
      }
   }

   void setRequestedOrientationLandscape() {
      this.settings.orientation = "landscape";
      this.settings.allowOrientationChange = false;
      this.setRequestedOrientation(0);
   }

   void setRequestedOrientationPortrait() {
      this.settings.orientation = "portrait";
      this.settings.allowOrientationChange = false;
      this.setRequestedOrientation(1);
   }

   void unlockScreenOrientation() {
      this.setRequestedOrientation(-1);
   }
}
