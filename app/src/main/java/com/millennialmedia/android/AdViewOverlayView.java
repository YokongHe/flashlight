package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.AdViewOverlayActivity;
import com.millennialmedia.android.AdViewOverlayView$AdViewOverlayViewMMAdImpl;
import com.millennialmedia.android.AdViewOverlayView$AnimationListener;
import com.millennialmedia.android.AdViewOverlayView$CloseTopDrawable;
import com.millennialmedia.android.AdViewOverlayView$FetchWebViewContentTask;
import com.millennialmedia.android.AdViewOverlayView$NonConfigurationInstance;
import com.millennialmedia.android.AdViewOverlayView$SetCloseButtonTouchDelegateRunnable;
import com.millennialmedia.android.BridgeMMSpeechkit;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMLayout;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.OverlaySettings;
import java.lang.ref.WeakReference;

class AdViewOverlayView extends MMLayout {
   private static final String MRAID_CLOSE_BUTTON_DESRIPTION = "mraidCloseButton";
   private static final String TAG = "AdViewOverlayView";
   private Button mraidCloseButton;
   AdViewOverlayView$CloseTopDrawable mraidCloseDrawable;
   WeakReference overlayActivityRef;
   private ProgressBar progressBar;
   private boolean progressDone;
   OverlaySettings settings;

   AdViewOverlayView(AdViewOverlayActivity var1, OverlaySettings var2) {
      super(var1.activity);
      this.overlayActivityRef = new WeakReference(var1);
      this.adImpl = new AdViewOverlayView$AdViewOverlayViewMMAdImpl(this, var1.activity);
      this.setId(15062);
      this.adImpl.adType = "i";
      this.settings = var2;
      AdViewOverlayView$NonConfigurationInstance var5 = null;
      if(var1.activity instanceof Activity) {
         var5 = (AdViewOverlayView$NonConfigurationInstance)var1.activity.getLastNonConfigurationInstance();
         if(var5 != null) {
            this.progressDone = var5.progressDone;
            this.adImpl.controller = var5.controller;
            this.settings = var5.settings;
            if(this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
               this.addView(this.adImpl.controller.webView);
            }

            MMLog.d("AdViewOverlayView", "Restoring configurationinstance w/ controller= " + var5.controller);
         } else {
            MMLog.d("AdViewOverlayView", "Null configurationinstance ");
         }
      }

      float var3 = var1.activity.getResources().getDisplayMetrics().density;
      LayoutParams var4;
      if(this.settings.height != 0 && this.settings.width != 0) {
         var4 = new LayoutParams((int)((float)this.settings.width * var3), (int)((float)this.settings.height * var3));
      } else {
         var4 = new LayoutParams(-1, -1);
      }

      var4.addRule(13);
      this.setLayoutParams(var4);
      Integer var6 = Integer.valueOf((int)(0.0625F * var3 * (float)this.settings.shouldResizeOverlay));
      this.setPadding(var6.intValue(), var6.intValue(), var6.intValue(), var6.intValue());
      this.mraidCloseButton = this.initMRaidCloseButton(var1.activity, var3);
      if(this.settings.isExpanded() && !this.settings.hasExpandUrl()) {
         this.adImpl.linkForExpansionId = this.settings.creatorAdImplId;
      }

      MMAdImplController.assignAdViewController(this.adImpl);
      if(this.mraidCloseButton != null) {
         this.addView(this.mraidCloseButton);
      }

      if(!this.progressDone && !this.settings.isExpanded() && !this.settings.isFromInterstitial()) {
         this.initProgressBar();
      }

      if(this.settings.getIsTransparent()) {
         if(this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
            this.adImpl.controller.webView.setBackgroundColor(0);
         }

         this.setBackgroundColor(0);
      } else {
         if(this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
            this.adImpl.controller.webView.setBackgroundColor(-1);
         }

         this.setBackgroundColor(-1);
      }

      if(this.settings.enableHardwareAccel() && this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
         this.adImpl.controller.webView.enableHardwareAcceleration();
      }

      if(var5 == null) {
         this.animateView();
      }

      this.setUseCustomClose(this.settings.getUseCustomClose());
   }

   // $FF: synthetic method
   static void access$200(AdViewOverlayView var0) {
      var0.removeProgressBar();
   }

   // $FF: synthetic method
   static Button access$300(AdViewOverlayView var0) {
      return var0.mraidCloseButton;
   }

   // $FF: synthetic method
   static ProgressBar access$400(AdViewOverlayView var0) {
      return var0.progressBar;
   }

   // $FF: synthetic method
   static void access$500(AdViewOverlayView var0) {
      var0.initProgressBar();
   }

   private void animateView() {
      Object var1;
      if(this.settings.getTransition().equals("slideup")) {
         var1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
         MMLog.v("AdViewOverlayView", "Translate up");
      } else if(this.settings.getTransition().equals("slidedown")) {
         var1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
         MMLog.v("AdViewOverlayView", "Translate down");
      } else {
         if(!this.settings.getTransition().equals("explode")) {
            return;
         }

         var1 = new ScaleAnimation(1.1F, 0.9F, 0.1F, 0.9F, 1, 0.5F, 1, 0.5F);
         MMLog.v("AdViewOverlayView", "Explode");
      }

      ((Animation)var1).setDuration(this.settings.getTransitionDurationInMillis());
      this.startAnimation((Animation)var1);
   }

   private LayoutParams getCloseAreaParams(float var1) {
      int var2 = (int)(50.0F * var1 + 0.5F);
      LayoutParams var3 = new LayoutParams(var2, var2);
      var3.addRule(11);
      var3.addRule(10);
      return var3;
   }

   private Button initMRaidCloseButton(Context var1, float var2) {
      Button var4 = new Button(var1);
      var4.setId(301);
      var4.setContentDescription("mraidCloseButton");
      this.mraidCloseDrawable = new AdViewOverlayView$CloseTopDrawable(true, var2);
      var4.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MMLog.v("AdViewOverlayView", "Close button clicked.");
            AdViewOverlayView.this.finishOverlayWithAnimation();
         }
      });
      LayoutParams var3 = this.getCloseAreaParams(var2);
      var4.setLayoutParams(var3);
      var4.post(new AdViewOverlayView$SetCloseButtonTouchDelegateRunnable(var4, var3.topMargin, var3.leftMargin, var3.bottomMargin, var3.rightMargin));
      return var4;
   }

   private void initProgressBar() {
      AdViewOverlayActivity var1 = (AdViewOverlayActivity)this.overlayActivityRef.get();
      if(var1 != null) {
         this.progressBar = new ProgressBar(var1.activity);
         this.progressBar.setIndeterminate(true);
         this.progressBar.setVisibility(0);
         LayoutParams var2 = new LayoutParams(-2, -2);
         var2.addRule(13);
         this.addView(this.progressBar, var2);
      }

   }

   private void removeProgressBar() {
      if(!this.progressDone && this.progressBar != null) {
         this.progressDone = true;
         this.progressBar.setVisibility(8);
         this.removeView(this.progressBar);
         this.progressBar = null;
      }

   }

   void addInlineVideo() {
      super.addInlineVideo();
      this.bringMraidCloseToFront();
   }

   boolean attachWebViewToLink() {
      return this.adImpl != null && this.adImpl.linkForExpansionId != 0L && MMAdImplController.attachWebViewFromOverlay(this.adImpl);
   }

   void bringMraidCloseToFront() {
      if(this.mraidCloseButton != null) {
         this.mraidCloseButton.bringToFront();
      }

   }

   void closeAreaTouched() {
      this.post(new Runnable() {
         public void run() {
            AdViewOverlayView.this.finishOverlayWithAnimation();
         }
      });
   }

   void finishOverlayWithAnimation() {
      MMLog.d("AdViewOverlayView", "Ad overlay closed");
      if((Activity)this.getContext() != null) {
         AlphaAnimation var1 = new AlphaAnimation(1.0F, 0.0F);
         var1.setAnimationListener(new AdViewOverlayView$AnimationListener(this));
         var1.setFillEnabled(true);
         var1.setFillBefore(true);
         var1.setFillAfter(true);
         var1.setDuration(400L);
         this.startAnimation(var1);
      }
   }

   void fullScreenVideoLayout() {
      this.removeView(this.inlineVideoLayout);
      this.addView(this.inlineVideoLayout, new LayoutParams(-1, -1));
      this.bringMraidCloseToFront();
   }

   Object getNonConfigurationInstance() {
      AdViewOverlayView$NonConfigurationInstance var1 = new AdViewOverlayView$NonConfigurationInstance(null);
      if(this.adImpl != null) {
         MMLog.d("AdViewOverlayView", "Saving getNonConfigurationInstance for " + this.adImpl);
         if(this.adImpl.controller != null && this.adImpl.controller.webView != null) {
            this.adImpl.controller.webView.removeFromParent();
         }

         var1.controller = this.adImpl.controller;
      }

      var1.progressDone = this.progressDone;
      var1.settings = this.settings;
      return var1;
   }

   void getWebContent(String var1) {
      (new AdViewOverlayView$FetchWebViewContentTask(this, var1)).execute(new Void[0]);
   }

   void injectJS(String var1) {
      if(this.adImpl.controller != null) {
         this.adImpl.controller.loadUrl(var1);
      }

   }

   void inlineConfigChange() {
      if(this.inlineVideoView != null && this.inlineVideoLayout != null) {
         this.inlineVideoLayout.setLayoutParams(this.inlineVideoView.getCustomLayoutParams());
         this.bringMraidCloseToFront();
      }

   }

   void killWebView() {
      BridgeMMSpeechkit.releaseSpeechKit();
      if(this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
         this.adImpl.controller.webView.clearFocus();
         this.adImpl.controller.webView.setMraidViewableHidden();
         if(this.adImpl.adType == "i") {
            this.adImpl.controller.webView.setMraidHidden();
         }

         this.adImpl.controller.webView.onPauseWebView();
      }

   }

   void removeSelfAndAll() {
      this.removeAllViews();
      ViewParent var1 = this.getParent();
      if(var1 != null && var1 instanceof ViewGroup) {
         ((ViewGroup)var1).removeView(this);
      }

   }

   void repositionVideoLayout() {
      this.removeView(this.inlineVideoLayout);
      this.addView(this.inlineVideoLayout, this.inlineVideoView.getCustomLayoutParams());
      this.bringMraidCloseToFront();
   }

   void setUseCustomClose(boolean var1) {
      this.settings.setUseCustomClose(var1);
      Button var3 = this.mraidCloseButton;
      AdViewOverlayView$CloseTopDrawable var2;
      if(var1) {
         var2 = null;
      } else {
         var2 = this.mraidCloseDrawable;
      }

      var3.setBackgroundDrawable(var2);
   }
}
