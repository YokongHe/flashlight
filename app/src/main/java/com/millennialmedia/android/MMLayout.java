package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.BridgeMMMedia$Audio;
import com.millennialmedia.android.BridgeMMSpeechkit;
import com.millennialmedia.android.InlineVideoView;
import com.millennialmedia.android.InlineVideoView$InlineParams;
import com.millennialmedia.android.InlineVideoView$TransparentFix;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMLayout$LayoutGestureListener;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;

abstract class MMLayout extends RelativeLayout implements InlineVideoView$TransparentFix, MMAd {
   static final String BOTTOM_CENTER = "bottom-center";
   static final String BOTTOM_LEFT = "bottom-left";
   static final String BOTTOM_RIGHT = "bottom-right";
   static final String CENTER = "center";
   private static final int CLOSE_AREA_SIZE = 50;
   public static final String KEY_HEIGHT = "height";
   public static final String KEY_WIDTH = "width";
   private static final String TAG = "MMLayout";
   static final String TOP_CENTER = "top-center";
   static final String TOP_LEFT = "top-left";
   static final String TOP_RIGHT = "top-right";
   private static boolean appInit;
   MMAdImpl adImpl;
   View blackView;
   View closeAreaView;
   private GestureDetector diagnosticDetector;
   String goalId;
   RelativeLayout inlineVideoLayout;
   InlineVideoView inlineVideoView;
   boolean isResizing;

   protected MMLayout(Context var1) {
      super(var1);
      this.initLayout(var1);
   }

   @Deprecated
   protected MMLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.initLayout(var1);
   }

   private void initInlineVideoTransparentFix() {
      if(this.blackView != null) {
         ViewParent var1 = this.blackView.getParent();
         if(var1 != null && var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.blackView);
            this.blackView = null;
         }
      }

      this.blackView = new View(this.getContext());
      this.blackView.setBackgroundColor(-16777216);
      LayoutParams var2 = new LayoutParams(-1, -1);
      this.blackView.setLayoutParams(var2);
      if(this.inlineVideoLayout != null && this.blackView.getParent() == null) {
         this.inlineVideoLayout.addView(this.blackView);
      }

   }

   private void internalSetCloseArea(String var1) {
      if(this.closeAreaView == null) {
         this.closeAreaView = new View(this.getContext());
         float var2 = this.getContext().getResources().getDisplayMetrics().density;
         LayoutParams var3 = new LayoutParams((int)(50.0F * var2), (int)(var2 * 50.0F));
         if("top-right".equals(var1)) {
            var3.addRule(11);
         } else if("top-center".equals(var1)) {
            var3.addRule(14);
         } else if("bottom-left".equals(var1)) {
            var3.addRule(12);
         } else if("bottom-center".equals(var1)) {
            var3.addRule(12);
            var3.addRule(14);
         } else if("bottom-right".equals(var1)) {
            var3.addRule(12);
            var3.addRule(11);
         } else if("center".equals(var1)) {
            var3.addRule(13);
         }

         this.closeAreaView.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               MMLayout.this.closeAreaTouched();
            }
         });
         this.addView(this.closeAreaView, var3);
      }

   }

   public void addBlackView() {
      this.initInlineVideoTransparentFix();
      if(this.blackView != null) {
         this.blackView.setVisibility(0);
      }

   }

   void addInlineVideo() {
      if(this.inlineVideoLayout != null && this.inlineVideoLayout.getParent() != null) {
         ((ViewGroup)this.inlineVideoLayout.getParent()).removeView(this.inlineVideoLayout);
      }

      this.inlineVideoLayout = new RelativeLayout(this.getContext());
      this.inlineVideoLayout.setId(892934232);
      if(this.inlineVideoView.getParent() != null) {
         ((ViewGroup)this.inlineVideoView.getParent()).removeView(this.inlineVideoView);
      }

      this.inlineVideoLayout.addView(this.inlineVideoView);
      if(this.blackView != null) {
         if(this.blackView.getParent() == null) {
            this.inlineVideoLayout.addView(this.blackView);
         }

         this.blackView.bringToFront();
      }

      this.addView(this.inlineVideoLayout, this.inlineVideoView.getCustomLayoutParams());
   }

   boolean adjustVideo(final InlineVideoView$InlineParams var1) {
      MMSDK.runOnUiThread(new Runnable() {
         public void run() {
            if(MMLayout.this.inlineVideoView != null) {
               MMLayout.this.inlineVideoView.adjustVideo(var1);
            }

         }
      });
      return false;
   }

   void closeAreaTouched() {
   }

   protected void finalize() {
      if(this.getId() == -1) {
         this.adImpl.isFinishing = true;
         MMLog.d("MMLayout", "finalize() for " + this.adImpl);
      }

   }

   void fullScreenVideoLayout() {
   }

   public String getApid() {
      return this.adImpl.getApid();
   }

   public boolean getIgnoresDensityScaling() {
      return this.adImpl.getIgnoresDensityScaling();
   }

   public RequestListener getListener() {
      return this.adImpl.getListener();
   }

   public MMRequest getMMRequest() {
      return this.adImpl.getMMRequest();
   }

   void initInlineVideo(InlineVideoView$InlineParams var1) {
      if(this.inlineVideoView != null) {
         ViewGroup var2 = (ViewGroup)this.inlineVideoView.getParent();
         if(var2 != null) {
            var2.removeView(this.inlineVideoView);
         }

         if(this.inlineVideoView.isPlaying()) {
            this.inlineVideoView.stopPlayback();
         }

         this.inlineVideoView = null;
      }

      this.inlineVideoView = new InlineVideoView(this);
      this.inlineVideoView.initInlineVideo(var1);
      LayoutParams var3 = new LayoutParams(-1, -1);
      var3.addRule(13, -1);
      this.inlineVideoView.setLayoutParams(var3);
      this.addInlineVideo();
   }

   protected final void initLayout(Context var1) {
      try {
         MMLog.i("MMLayout", "Initializing MMLayout.");
         MMSDK.checkPermissions(var1);
         MMSDK.checkActivity(var1);
      } catch (Exception var3) {
         MMLog.e("MMLayout", "There was an exception initializing the MMAdView. ", var3);
         var3.printStackTrace();
      }

      this.diagnosticDetector = new GestureDetector(var1.getApplicationContext(), new MMLayout$LayoutGestureListener(this));
      if(!appInit) {
         MMLog.d("MMLayout", "********** Millennial Device Id *****************");
         MMLog.d("MMLayout", MMSDK.getMMdid(var1));
         MMLog.d("MMLayout", "Use the above identifier to register this device and receive test ads. Test devices can be registered and administered through your account at http://mmedia.com.");
         MMLog.d("MMLayout", "*************************************************");
         AdCache.cleanCache(var1);
         appInit = true;
      }

   }

   boolean isVideoPlayingStreaming() {
      return this.inlineVideoView != null && this.inlineVideoView.isPlayingStreaming();
   }

   void loadUrl(String var1) {
      if(MMSDK.isConnected(this.getContext())) {
         if(this.adImpl.controller != null) {
            this.adImpl.controller.loadUrl(var1);
         }

      } else {
         MMLog.e("MMLayout", "No network available, can\'t load overlay.");
      }
   }

   void loadWebContent(String var1, String var2) {
      if(MMSDK.isConnected(this.getContext())) {
         if(this.adImpl.controller != null) {
            this.adImpl.controller.loadWebContent(var1, var2);
         }

      } else {
         MMLog.e("MMLayout", "No network available, can\'t load overlay.");
      }
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(!this.isInEditMode()) {
         MMLog.d("MMLayout", "onAttachedToWindow for " + this.adImpl);
         if(this.getId() == -1) {
            MMLog.w("MMLayout", "MMAd missing id from getId(). Performance will be affected for configuration changes.");
         }

         if(!this.isResizing) {
            MMAdImplController.assignAdViewController(this.adImpl);
         }

         if(this.inlineVideoLayout != null) {
            this.inlineVideoLayout.bringToFront();
         }

         if(this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
            this.adImpl.controller.webView.enableSendingSize();
         }
      }

   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      MMLog.d("MMLayout", "onDetachedFromWindow for" + this.adImpl);
      Context var1 = this.getContext();
      if(this.adImpl.adType == "i" && var1 != null && var1 instanceof Activity && ((Activity)var1).isFinishing()) {
         this.adImpl.isFinishing = true;
      }

      if(!this.isResizing) {
         MMAdImplController.removeAdViewController(this.adImpl);
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      Bundle var5 = (Bundle)var1;
      long var2 = this.adImpl.internalId;
      this.adImpl.internalId = var5.getLong("MMAdImplId");
      this.adImpl.linkForExpansionId = var5.getLong("MMAdImplLinkedId");
      MMLog.d("MMLayout", "onRestoreInstanceState replacing adImpl-" + var2 + " with " + this.adImpl + " id=" + this.getId());
      String var4 = var5.getString("inlineVideoViewGson");
      if(var4 != null) {
         this.initInlineVideo(InlineVideoView$InlineParams.getInlineParams(var4));
      }

      super.onRestoreInstanceState(var5.getParcelable("super"));
   }

   protected Parcelable onSaveInstanceState() {
      super.onSaveInstanceState();
      MMLog.d("MMLayout", "onSaveInstanceState saving - " + this.adImpl + " id=" + this.getId());
      Bundle var1 = new Bundle();
      var1.putParcelable("super", super.onSaveInstanceState());
      var1.putLong("MMAdImplId", this.adImpl.internalId);
      var1.putLong("MMAdImplLinkedId", this.adImpl.linkForExpansionId);
      if(this.inlineVideoView != null) {
         if(this.inlineVideoView.isPlaying()) {
            this.inlineVideoView.inlineParams.currentPosition = this.inlineVideoView.getCurrentPosition();
         }

         var1.putString("inlineVideoViewGson", this.inlineVideoView.getGsonState());
      }

      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.diagnosticDetector.onTouchEvent(var1) || !this.isClickable() || super.onTouchEvent(var1);
   }

   @Deprecated
   public void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      if(var1) {
         if(this.inlineVideoView != null) {
            this.inlineVideoView.resumeVideo();
         }
      } else if(this.inlineVideoView != null) {
         this.inlineVideoView.pauseVideo();
      }

      MMLog.d("MMLayout", String.format("Window Focus Changed. For %s, Window in focus?: %b Controllers: %s", new Object[]{this.adImpl, Boolean.valueOf(var1), MMAdImplController.controllersToString()}));
      if(this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
         if(var1) {
            this.adImpl.controller.webView.onResumeWebView();
            this.adImpl.controller.webView.setMraidViewableVisible();
         } else {
            BridgeMMSpeechkit.releaseSpeechKit();
            this.adImpl.controller.webView.setMraidViewableHidden();
            this.adImpl.controller.webView.onPauseWebView();
         }
      }

      if(!var1 && this.getContext() instanceof Activity) {
         Activity var2 = (Activity)this.getContext();
         if(var2 == null || var2.isFinishing() && this.adImpl != null) {
            this.adImpl.isFinishing = true;
            if(this.adImpl.controller != null && this.adImpl.controller.webView != null) {
               this.adImpl.controller.webView.setMraidHidden();
               MMAdImplController.removeAdViewController(this.adImpl);
            }
         }
      }

      BridgeMMMedia$Audio var4 = BridgeMMMedia$Audio.sharedAudio(this.getContext());
      if(var4 != null) {
         synchronized(this) {
            var4.stop();
         }
      }

   }

   void pauseVideo() {
      if(this.inlineVideoView != null) {
         this.inlineVideoView.pauseVideo();
      }

   }

   void playVideo() {
      if(this.inlineVideoView != null) {
         this.inlineVideoView.playVideo();
      }

   }

   public void removeBlackView() {
      if(this.blackView != null) {
         this.blackView.setVisibility(4);
      }

   }

   void removeCloseTouchDelegate() {
      if(this.closeAreaView != null && this.closeAreaView.getParent() != null && this.closeAreaView.getParent() instanceof ViewGroup) {
         ((ViewGroup)this.closeAreaView.getParent()).removeView(this.closeAreaView);
         this.closeAreaView = null;
      }

   }

   void removeVideo() {
      if(this.inlineVideoView != null) {
         this.inlineVideoView.removeVideo();
         this.inlineVideoView = null;
      }

   }

   void repositionVideoLayout() {
   }

   void resumeVideo() {
      if(this.inlineVideoView != null) {
         this.inlineVideoView.resumeVideo();
      }

   }

   public void setApid(String var1) {
      this.adImpl.setApid(var1);
   }

   void setCloseArea(final String var1) {
      this.post(new Runnable() {
         public void run() {
            MMLayout.this.internalSetCloseArea(var1);
         }
      });
   }

   public void setIgnoresDensityScaling(boolean var1) {
      this.adImpl.setIgnoresDensityScaling(var1);
   }

   public void setListener(RequestListener var1) {
      this.adImpl.setListener(var1);
   }

   public void setMMRequest(MMRequest var1) {
      this.adImpl.setMMRequest(var1);
   }

   void setMediaPlaybackRequiresUserGesture(boolean var1) {
      try {
         WebView.class.getMethod("setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}).invoke(this, new Object[]{Boolean.valueOf(var1)});
      } catch (Exception var3) {
         ;
      }
   }

   void setVideoSource(String var1) {
      if(this.inlineVideoView != null) {
         this.inlineVideoView.setVideoSource(var1);
      }

   }

   void stopVideo() {
      if(this.inlineVideoView != null) {
         this.inlineVideoView.stopVideo();
      }

   }
}
