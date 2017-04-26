package com.adsdk.sdk.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.FrameLayout.LayoutParams;
import com.adsdk.sdk.AdManager;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Const;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.banner.BannerAdView;
import com.adsdk.sdk.banner.BannerAdView$BannerAdViewListener;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$MraidListener;
import com.adsdk.sdk.mraid.MraidView$ViewState;
import com.adsdk.sdk.video.MediaController;
import com.adsdk.sdk.video.MediaController$OnPauseListener;
import com.adsdk.sdk.video.MediaController$OnReplayListener;
import com.adsdk.sdk.video.MediaController$OnUnpauseListener;
import com.adsdk.sdk.video.ResourceManager;
import com.adsdk.sdk.video.RichMediaActivity$ResourceHandler;
import com.adsdk.sdk.video.RichMediaActivity$VideoTimeoutTask;
import com.adsdk.sdk.video.SDKVideoView;
import com.adsdk.sdk.video.SDKVideoView$OnStartListener;
import com.adsdk.sdk.video.SDKVideoView$OnTimeEventListener;
import com.adsdk.sdk.video.TrackEvent;
import com.adsdk.sdk.video.TrackerService;
import com.adsdk.sdk.video.VideoData;
import com.adsdk.sdk.video.WebFrame;
import java.util.Iterator;
import java.util.Timer;
import java.util.Vector;

public class RichMediaActivity extends Activity {
   public static final int TYPE_BROWSER = 0;
   public static final int TYPE_INTERSTITIAL = 2;
   public static final int TYPE_UNKNOWN = -1;
   public static final int TYPE_VIDEO = 1;
   private LinearLayout buttonsLayout;
   private AdResponse mAd;
   private boolean mCanClose;
   private Runnable mCheckProgressTask = new Runnable() {
      public void run() {
         Log.w("Video playback is being checked");
         if(RichMediaActivity.this.mVideoView.getCurrentPosition() - RichMediaActivity.this.mTimeTest <= 1) {
            Log.w("Video playback too slow. Ending");
            RichMediaActivity.this.finish();
         } else {
            Log.w("Video playback has restarted");
         }
      }
   };
   private VideoView mCustomVideoView;
   private FrameLayout mCustomView;
   private CustomViewCallback mCustomViewCallback;
   private RichMediaActivity$ResourceHandler mHandler;
   protected boolean mInterstitialAutocloseReset;
   private FrameLayout mLoadingView;
   private MediaController mMediaController;
   OnClickListener mOnInterstitialSkipListener = new OnClickListener() {
      public void onClick(View var1) {
         Log.v("###########TRACKING SKIP INTERSTITIAL");
         RichMediaActivity.this.mResult = true;
         RichMediaActivity.this.setResult(-1);
         RichMediaActivity.this.finish();
      }
   };
   SDKVideoView$OnTimeEventListener mOnVideoCanCloseEventListener = new SDKVideoView$OnTimeEventListener() {
      public void onTimeEvent(int var1) {
         Log.d("###########CAN CLOSE VIDEO:" + var1);
         RichMediaActivity.this.mCanClose = true;
         if(RichMediaActivity.this.mSkipButton != null && RichMediaActivity.this.mSkipButton.getVisibility() != 0 && RichMediaActivity.this.mVideoData.showSkipButton) {
            RichMediaActivity.this.mSkipButton.setImageDrawable(RichMediaActivity.this.mResourceManager.getResource(RichMediaActivity.this, -18));
            RichMediaActivity.this.mSkipButton.setVisibility(0);
         }

      }
   };
   OnClickListener mOnVideoClickListener = new OnClickListener() {
      public void onClick(View var1) {
         if(RichMediaActivity.this.mVideoData.videoClickThrough != null) {
            if(RichMediaActivity.this.mVideoData.videoClickTracking != null) {
               Iterator var3 = RichMediaActivity.this.mVideoData.videoClickTracking.iterator();

               while(var3.hasNext()) {
                  String var2 = (String)var3.next();
                  RichMediaActivity.this.trackClick(var2);
               }
            }

            String var4 = RichMediaActivity.this.mVideoData.videoClickThrough.trim();
            RichMediaActivity.this.notifyAdClicked();
            RichMediaActivity.this.mOnVideoCanCloseEventListener.onTimeEvent(0);
            Intent var5 = new Intent("android.intent.action.VIEW", Uri.parse(var4));
            RichMediaActivity.this.startActivity(var5);
         }

      }
   };
   OnCompletionListener mOnVideoCompletionListener = new OnCompletionListener() {
      public void onCompletion(MediaPlayer var1) {
         var1.seekTo(0);
         Log.d("###########TRACKING END VIDEO");
         Vector var4 = RichMediaActivity.this.mVideoData.completeEvents;

         for(int var2 = 0; var2 < var4.size(); ++var2) {
            Log.d("Track url:" + (String)var4.get(var2));
            TrackEvent var3 = new TrackEvent();
            var3.url = (String)var4.get(var2);
            var3.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(var3);
         }

         RichMediaActivity.this.mResult = true;
         RichMediaActivity.this.setResult(-1);
         RichMediaActivity.this.mMediaController.hide();
         RichMediaActivity.this.buttonsLayout.setVisibility(0);
      }
   };
   OnErrorListener mOnVideoErrorListener = new OnErrorListener() {
      public boolean onError(MediaPlayer var1, int var2, int var3) {
         Log.w("Cannot play video/ Error: " + var2 + " Extra: " + var3);
         RichMediaActivity.this.finish();
         return false;
      }
   };
   OnInfoListener mOnVideoInfoListener = new OnInfoListener() {
      public boolean onInfo(MediaPlayer var1, int var2, int var3) {
         Log.i("Info: " + var2 + " Extra: " + var3);
         if(var2 == 703) {
            RichMediaActivity.this.mTimeTest = RichMediaActivity.this.mVideoView.getCurrentPosition();
            (new Handler()).postDelayed(RichMediaActivity.this.mCheckProgressTask, 5000L);
         }

         return false;
      }
   };
   MediaController$OnPauseListener mOnVideoPauseListener = new MediaController$OnPauseListener() {
      public void onVideoPause() {
         Log.d("###########TRACKING PAUSE VIDEO");
         Vector var2 = RichMediaActivity.this.mVideoData.pauseEvents;

         for(int var1 = 0; var1 < var2.size(); ++var1) {
            Log.d("Track url:" + (String)var2.get(var1));
            TrackEvent var3 = new TrackEvent();
            var3.url = (String)var2.get(var1);
            var3.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(var3);
         }

      }
   };
   OnPreparedListener mOnVideoPreparedListener = new OnPreparedListener() {
      public void onPrepared(MediaPlayer var1) {
         Log.d("ADSDK", "RichMediaActivity onPrepared MediaPlayer");
         if(RichMediaActivity.this.mVideoTimeoutTimer != null) {
            RichMediaActivity.this.mVideoTimeoutTimer.cancel();
            RichMediaActivity.this.mVideoTimeoutTimer = null;
         }

         if(RichMediaActivity.this.mLoadingView != null) {
            RichMediaActivity.this.mLoadingView.setVisibility(8);
         }

         RichMediaActivity.this.mMediaController.setVisibility(0);
         RichMediaActivity.this.videoFrame.requestFocus();
      }
   };
   MediaController$OnReplayListener mOnVideoReplayListener = new MediaController$OnReplayListener() {
      public void onVideoReplay() {
         Log.d("###########TRACKING REPLAY VIDEO");
         Vector var2 = RichMediaActivity.this.mVideoData.replayEvents;

         for(int var1 = 0; var1 < var2.size(); ++var1) {
            Log.d("Track url:" + (String)var2.get(var1));
            TrackEvent var3 = new TrackEvent();
            var3.url = (String)var2.get(var1);
            var3.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(var3);
         }

      }
   };
   OnClickListener mOnVideoSkipListener = new OnClickListener() {
      public void onClick(View var1) {
         Log.v("###########TRACKING SKIP VIDEO");
         Vector var4 = RichMediaActivity.this.mVideoData.skipEvents;

         for(int var2 = 0; var2 < var4.size(); ++var2) {
            Log.d("Track url:" + (String)var4.get(var2));
            TrackEvent var3 = new TrackEvent();
            var3.url = (String)var4.get(var2);
            var3.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(var3);
         }

         RichMediaActivity.this.finish();
      }
   };
   SDKVideoView$OnStartListener mOnVideoStartListener = new SDKVideoView$OnStartListener() {
      public void onVideoStart() {
         Log.d("###########TRACKING START VIDEO");
         Vector var2 = RichMediaActivity.this.mVideoData.startEvents;
         var2.addAll(RichMediaActivity.this.mVideoData.impressionEvents);

         for(int var1 = 0; var1 < var2.size(); ++var1) {
            Log.d("Track url:" + (String)var2.get(var1));
            TrackEvent var3 = new TrackEvent();
            var3.url = (String)var2.get(var1);
            var3.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(var3);
         }

         var2.clear();
         RichMediaActivity.this.mVideoData.impressionEvents.clear();
      }
   };
   SDKVideoView$OnTimeEventListener mOnVideoTimeEventListener = new SDKVideoView$OnTimeEventListener() {
      public void onTimeEvent(int var1) {
         Log.d("###########TRACKING TIME VIDEO:" + var1);
         Vector var2 = (Vector)RichMediaActivity.this.mVideoData.timeTrackingEvents.get(Integer.valueOf(var1));
         if(var2 != null) {
            for(var1 = 0; var1 < var2.size(); ++var1) {
               Log.d("Track url:" + (String)var2.get(var1));
               TrackEvent var3 = new TrackEvent();
               var3.url = (String)var2.get(var1);
               var3.timestamp = System.currentTimeMillis();
               TrackerService.requestTrack(var3);
            }
         }

      }
   };
   MediaController$OnUnpauseListener mOnVideoUnpauseListener = new MediaController$OnUnpauseListener() {
      public void onVideoUnpause() {
         Log.d("###########TRACKING UNPAUSE VIDEO");
         Vector var2 = RichMediaActivity.this.mVideoData.resumeEvents;

         for(int var1 = 0; var1 < var2.size(); ++var1) {
            Log.d("Track url:" + (String)var2.get(var1));
            TrackEvent var3 = new TrackEvent();
            var3.url = (String)var2.get(var1);
            var3.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(var3);
         }

      }
   };
   private final OnClickListener mOverlayClickListener = new OnClickListener() {
      public void onClick(View var1) {
         if(RichMediaActivity.this.mVideoData.overlayClickThrough != null) {
            if(RichMediaActivity.this.mVideoData.overlayClickTracking != null) {
               RichMediaActivity.this.trackClick(RichMediaActivity.this.mVideoData.overlayClickTracking);
            }

            String var2 = RichMediaActivity.this.mVideoData.overlayClickThrough.trim();
            RichMediaActivity.this.notifyAdClicked();
            Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
            RichMediaActivity.this.startActivity(var3);
         }

         Log.d("ADSDK", "RichMediaActivity mOverlayClickListener");
      }
   };
   private final SDKVideoView$OnTimeEventListener mOverlayShowListener = new SDKVideoView$OnTimeEventListener() {
      public void onTimeEvent(int var1) {
         Log.d("ADSDK", "RichMediaActivity mOverlayShowListener show after:" + var1);
         if(RichMediaActivity.this.mOverlayView != null) {
            RichMediaActivity.this.mOverlayView.setVisibility(0);
            RichMediaActivity.this.mOverlayView.requestLayout();
         }

      }
   };
   private WebFrame mOverlayView;
   private ResourceManager mResourceManager;
   private boolean mResult;
   private FrameLayout mRootLayout;
   private ImageView mSkipButton;
   protected int mTimeTest;
   private int mType;
   private VideoData mVideoData;
   private int mVideoHeight;
   private int mVideoLastPosition;
   private FrameLayout mVideoLayout;
   private Timer mVideoTimeoutTimer;
   private SDKVideoView mVideoView;
   private int mVideoWidth;
   private WebFrame mWebBrowserView;
   private int mWindowHeight;
   private int mWindowWidth;
   int marginArg = 8;
   DisplayMetrics metrics;
   int paddingArg = 5;
   int skipButtonSizeLand = 40;
   int skipButtonSizePort = 40;
   private Uri uri;
   private FrameLayout videoFrame;
   private boolean wasClicked;

   private BannerAdView$BannerAdViewListener createLocalAdListener() {
      return new BannerAdView$BannerAdViewListener() {
         public void onClick() {
            RichMediaActivity.this.notifyAdClicked();
         }

         public void onLoad() {
         }
      };
   }

   private MraidView$MraidListener createMraidListener() {
      return new MraidView$MraidListener() {
         public void onClose(MraidView var1, MraidView$ViewState var2) {
         }

         public void onExpand(MraidView var1) {
            RichMediaActivity.this.notifyAdClicked();
         }

         public void onFailure(MraidView var1) {
         }

         public void onReady(MraidView var1) {
         }
      };
   }

   private void initInterstitialFromBannerView() {
      short var3 = 320;
      FrameLayout var4 = new FrameLayout(this);
      if(this.mAd.getType() == 1 || this.mAd.getType() == 0) {
         float var1 = this.getResources().getDisplayMetrics().density;
         short var2;
         if(this.mAd.isHorizontalOrientationRequested()) {
            var2 = 480;
         } else {
            var2 = 320;
            var3 = 480;
         }

         BannerAdView var5 = new BannerAdView(this, this.mAd, var2, var3, false, this.createLocalAdListener());
         var5.setLayoutParams(new LayoutParams((int)((float)var2 * var1 + 0.5F), (int)((float)var3 * var1 + 0.5F), 17));
         var5.showContent();
         var4.addView(var5);
      }

      if(this.mAd.getType() == 4) {
         MraidView var7 = new MraidView(this);
         var4.addView(var7, new LayoutParams(-1, -1));
         var7.setMraidListener(this.createMraidListener());
         var7.loadHtmlData(this.mAd.getText());
      }

      this.mSkipButton = new ImageView(this);
      this.mSkipButton.setAdjustViewBounds(false);
      int var6;
      if(this.mAd.isHorizontalOrientationRequested()) {
         var6 = (int)TypedValue.applyDimension(1, (float)this.skipButtonSizeLand, this.getResources().getDisplayMetrics());
      } else {
         var6 = (int)TypedValue.applyDimension(1, (float)this.skipButtonSizePort, this.getResources().getDisplayMetrics());
      }

      LayoutParams var8 = new LayoutParams(var6, var6, 53);
      var6 = (int)TypedValue.applyDimension(1, 8.0F, this.getResources().getDisplayMetrics());
      var8.topMargin = var6;
      var8.rightMargin = var6;
      this.mSkipButton.setImageDrawable(this.mResourceManager.getResource(this, -18));
      this.mSkipButton.setOnClickListener(this.mOnInterstitialSkipListener);
      this.mCanClose = true;
      this.mSkipButton.setVisibility(0);
      var4.addView(this.mSkipButton, var8);
      this.mRootLayout.addView(var4);
   }

   private void initRootLayout() {
      this.mRootLayout = new FrameLayout(this);
      this.mRootLayout.setBackgroundColor(-16777216);
   }

   private void initVideoView() {
      this.mVideoData = this.mAd.getVideoData();
      this.setRequestedOrientation(this.mVideoData.orientation);
      int var2;
      if(this.mVideoData.orientation == 0) {
         if(this.mWindowWidth < this.mWindowHeight) {
            var2 = this.mWindowWidth;
            this.mWindowWidth = this.mWindowHeight;
            this.mWindowHeight = var2;
         }
      } else if(this.mWindowHeight < this.mWindowWidth) {
         var2 = this.mWindowHeight;
         this.mWindowHeight = this.mWindowWidth;
         this.mWindowWidth = var2;
      }

      this.mVideoWidth = this.mVideoData.width;
      this.mVideoHeight = this.mVideoData.height;
      if(this.mVideoWidth <= 0) {
         this.mVideoWidth = this.mWindowWidth;
         this.mVideoHeight = this.mWindowHeight;
      } else {
         DisplayMetrics var3 = this.getResources().getDisplayMetrics();
         this.mVideoWidth = (int)TypedValue.applyDimension(1, (float)this.mVideoWidth, var3);
         this.mVideoHeight = (int)TypedValue.applyDimension(1, (float)this.mVideoHeight, var3);
         if(this.mVideoWidth > this.mWindowWidth) {
            this.mVideoWidth = this.mWindowWidth;
         }

         if(this.mVideoHeight > this.mWindowHeight) {
            this.mVideoHeight = this.mWindowHeight;
         }
      }

      Log.d("Video size (" + this.mVideoWidth + "," + this.mVideoHeight + ")");
      this.mVideoLayout = new FrameLayout(this);
      this.videoFrame = new FrameLayout(this);
      this.mVideoView = new SDKVideoView(this, this.mVideoWidth, this.mVideoHeight, this.mVideoData.display);
      this.videoFrame.addView(this.mVideoView, new LayoutParams(-1, -1));
      this.mVideoLayout.addView(this.videoFrame, new LayoutParams(-2, -2, 17));
      LayoutParams var5;
      if(this.mVideoData.showHtmlOverlay) {
         this.mOverlayView = new WebFrame(this, false, false, false);
         this.mOverlayView.setEnableZoom(false);
         this.mOverlayView.setOnClickListener(this.mOverlayClickListener);
         this.mOverlayView.setBackgroundColor(0);
         if(this.mVideoData.showHtmlOverlayAfter > 0) {
            this.mOverlayView.setVisibility(8);
            this.mVideoView.setOnTimeEventListener(this.mVideoData.showHtmlOverlayAfter, this.mOverlayShowListener);
         }

         if(this.mVideoData.htmlOverlayType == 0) {
            this.mOverlayView.loadUrl(this.mVideoData.htmlOverlayUrl);
         } else {
            this.mOverlayView.setMarkup(this.mVideoData.htmlOverlayMarkup);
         }

         float var1 = this.getResources().getDisplayMetrics().density;
         var5 = new LayoutParams((int)((float)this.mVideoData.overlayWidth * var1 + 0.5F), (int)(var1 * (float)this.mVideoData.overlayHeight + 0.5F));
         var5.gravity = 81;
         this.mVideoLayout.addView(this.mOverlayView, var5);
      }

      this.mMediaController = new MediaController(this, this.mVideoData);
      this.mVideoView.setMediaController(this.mMediaController);
      if(!this.mVideoData.pauseEvents.isEmpty()) {
         this.mMediaController.setOnPauseListener(this.mOnVideoPauseListener);
      }

      if(!this.mVideoData.resumeEvents.isEmpty()) {
         this.mMediaController.setOnUnpauseListener(this.mOnVideoUnpauseListener);
      }

      if(!this.mVideoData.replayEvents.isEmpty()) {
         this.mMediaController.setOnReplayListener(this.mOnVideoReplayListener);
      }

      this.videoFrame.addView(this.mMediaController, new LayoutParams(-2, -2, 85));
      if(this.mVideoData.showSkipButton) {
         this.mSkipButton = new ImageView(this);
         this.mSkipButton.setAdjustViewBounds(false);
         if(this.mAd.isHorizontalOrientationRequested()) {
            var2 = (int)TypedValue.applyDimension(1, (float)this.skipButtonSizeLand, this.getResources().getDisplayMetrics());
         } else {
            var2 = (int)TypedValue.applyDimension(1, (float)this.skipButtonSizePort, this.getResources().getDisplayMetrics());
         }

         var5 = new LayoutParams(var2, var2, 53);
         if(this.mVideoData.orientation == 1) {
            var2 = (int)TypedValue.applyDimension(1, 8.0F, this.getResources().getDisplayMetrics());
            var5.topMargin = var2;
            var5.rightMargin = var2;
         } else {
            var2 = (int)TypedValue.applyDimension(1, 10.0F, this.getResources().getDisplayMetrics());
            var5.topMargin = var2;
            var5.rightMargin = var2;
         }

         if(this.mVideoData.skipButtonImage != null && this.mVideoData.skipButtonImage.length() > 0) {
            this.mResourceManager.fetchResource(this, this.mVideoData.skipButtonImage, -18);
         } else {
            this.mSkipButton.setImageDrawable(this.mResourceManager.getResource(this, -18));
         }

         this.mSkipButton.setOnClickListener(this.mOnVideoSkipListener);
         if(this.mVideoData.showSkipButtonAfter > 0) {
            this.mCanClose = false;
            this.mSkipButton.setVisibility(8);
         } else {
            this.mCanClose = true;
            this.mSkipButton.setVisibility(0);
         }

         this.mVideoLayout.addView(this.mSkipButton, var5);
      } else {
         this.mCanClose = false;
      }

      if(this.mVideoData.showSkipButtonAfter > 0) {
         this.mVideoView.setOnTimeEventListener(this.mVideoData.showSkipButtonAfter, this.mOnVideoCanCloseEventListener);
      }

      var5 = new LayoutParams(-2, -2, 17);
      this.mLoadingView = new FrameLayout(this);
      TextView var4 = new TextView(this);
      var4.setText(Const.LOADING);
      this.mLoadingView.addView(var4, var5);
      this.mVideoLayout.addView(this.mLoadingView, new LayoutParams(-1, -1, 17));
      this.buttonsLayout = new LinearLayout(this);
      this.buttonsLayout.setOrientation(1);
      Button var6 = new Button(this);
      var6.setText("Click here");
      var6.setTextColor(-16777216);
      var6.setTextSize(18.0F);
      var6.setTypeface((Typeface)null, 1);
      var6.setBackgroundColor(-270014231);
      var6.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            RichMediaActivity.this.mVideoView.performClick();
         }
      });
      var6.setMinimumWidth((int)TypedValue.applyDimension(1, 205.0F, this.getResources().getDisplayMetrics()));
      this.buttonsLayout.addView(var6, new android.widget.LinearLayout.LayoutParams(-2, -2));
      View var8 = new View(this);
      android.widget.LinearLayout.LayoutParams var7 = new android.widget.LinearLayout.LayoutParams(-1, -2);
      var7.height = 4;
      var8.setBackgroundColor(-12303292);
      this.buttonsLayout.addView(var8, var7);
      var6 = new Button(this);
      var6.setText("↻");
      var6.setTypeface((Typeface)null, 1);
      var6.setTextColor(-16777216);
      var6.setBackgroundColor(-270014231);
      var6.setTextSize(18.0F);
      var6.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            RichMediaActivity.this.replayVideo();
            RichMediaActivity.this.mMediaController.show();
            RichMediaActivity.this.buttonsLayout.setVisibility(4);
         }
      });
      this.buttonsLayout.addView(var6, new android.widget.LinearLayout.LayoutParams(-1, -2));
      this.buttonsLayout.setVisibility(4);
      this.mVideoLayout.addView(this.buttonsLayout, new LayoutParams(-2, -2, 17));
      if(this.mVideoData.videoClickThrough != null) {
         this.mVideoView.setOnClickListener(this.mOnVideoClickListener);
      }

      this.mVideoView.setOnPreparedListener(this.mOnVideoPreparedListener);
      this.mVideoView.setOnCompletionListener(this.mOnVideoCompletionListener);
      this.mVideoView.setOnErrorListener(this.mOnVideoErrorListener);
      this.mVideoView.setOnInfoListener(this.mOnVideoInfoListener);
      if(!this.mVideoData.startEvents.isEmpty() || !this.mVideoData.impressionEvents.isEmpty()) {
         this.mVideoView.setOnStartListener(this.mOnVideoStartListener);
      }

      if(!this.mVideoData.timeTrackingEvents.isEmpty()) {
         Iterator var9 = this.mVideoData.timeTrackingEvents.keySet().iterator();

         while(var9.hasNext()) {
            var2 = ((Integer)var9.next()).intValue();
            this.mVideoView.setOnTimeEventListener(var2, this.mOnVideoTimeEventListener);
         }
      }

      this.mVideoLastPosition = 0;
      String var10 = this.mVideoData.videoUrl;
      this.mVideoView.setVideoPath(var10);
   }

   private void initWebBrowserView(boolean var1) {
      this.mWebBrowserView = new WebFrame(this, true, true, var1);
      this.mRootLayout.addView(this.mWebBrowserView);
   }

   private void notifyAdClicked() {
      this.wasClicked = true;
      AdManager.notifyAdClick(this.mAd);
   }

   @TargetApi(9)
   private void setOrientation() {
      if(this.mAd.isHorizontalOrientationRequested()) {
         this.setRequestedOrientation(6);
      } else {
         this.setRequestedOrientation(7);
      }
   }

   private void setOrientationOldApi() {
      if(this.mAd.isHorizontalOrientationRequested()) {
         this.setRequestedOrientation(0);
      } else {
         this.setRequestedOrientation(1);
      }
   }

   private void trackClick(String var1) {
      TrackEvent var2 = new TrackEvent();
      var2.url = var1;
      var2.timestamp = System.currentTimeMillis();
      TrackerService.requestTrack(var2);
   }

   public void finish() {
      if(this.mAd != null) {
         Log.d("Finish Activity type:" + this.mType + " ad Type:" + this.mAd.getType());
         switch(this.mType) {
         case 1:
            if(this.mAd.getType() != 3) {
               break;
            }
         case 2:
            AdManager.closeRunningAd(this.mAd, this.mResult);
         }
      }

      super.finish();
   }

   public int getDipSize(int var1) {
      return (int)TypedValue.applyDimension(1, (float)var1, this.getResources().getDisplayMetrics());
   }

   public FrameLayout getRootLayout() {
      return this.mRootLayout;
   }

   public void goBack() {
      if(this.mCustomView != null) {
         Log.d("Closing custom view on back key pressed");
         this.onHideCustomView();
      } else {
         switch(this.mType) {
         case 0:
            break;
         case 1:
            if(!this.mCanClose) {
               return;
            }
            break;
         case 2:
            this.mResult = true;
            this.setResult(-1);
            break;
         default:
            return;
         }

         this.finish();
      }
   }

   public void handleMessage(Message var1) {
      switch(var1.what) {
      case 100:
         switch(var1.arg1) {
         case -18:
            if(this.mSkipButton != null) {
               this.mSkipButton.setImageDrawable(this.mResourceManager.getResource(this, -18));
               return;
            }
            break;
         default:
            return;
         }
      default:
      }
   }

   public void navigate(String var1) {
      this.notifyAdClicked();
      switch(this.mType) {
      case 0:
         this.mWebBrowserView.loadUrl(var1);
         return;
      default:
         Intent var2 = new Intent(this, RichMediaActivity.class);
         var2.setData(Uri.parse(var1));
         this.startActivity(var2);
      }
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      Log.d("RichMediaActivity onConfigurationChanged");
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onDestroy() {
      this.mMediaController = null;
      if(this.mResourceManager != null) {
         this.mResourceManager.releaseInstance();
      }

      if(this.mVideoView != null) {
         this.mVideoView.destroy();
      }

      Log.d("RichMediaActivity onDestroy");
      super.onDestroy();
      Log.d("RichMediaActivity onDestroy done");
   }

   public void onHideCustomView() {
      Log.d("onHideCustomView Hidding Custom View");
      if(this.mCustomView != null) {
         this.mCustomView.setVisibility(8);
         this.mCustomView = null;
         if(this.mCustomVideoView != null) {
            try {
               Log.d("onHideCustomView stop video");
               this.mCustomVideoView.stopPlayback();
            } catch (Exception var2) {
               Log.d("Couldn\'t stop custom video view");
            }

            this.mCustomVideoView = null;
         }
      }

      Log.d("onHideCustomView calling callback");
      this.mCustomViewCallback.onCustomViewHidden();
      this.mRootLayout.setVisibility(0);
      this.setContentView(this.mRootLayout);
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4) {
         this.goBack();
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   protected void onPause() {
      Log.d("RichMediaActivity onPause");
      super.onPause();
      switch(this.mType) {
      case 1:
         this.mVideoLastPosition = this.mVideoView.getCurrentPosition();
         this.mVideoView.stopPlayback();
         this.mRootLayout.removeView(this.mVideoLayout);
         if(this.mVideoTimeoutTimer != null) {
            this.mVideoTimeoutTimer.cancel();
            this.mVideoTimeoutTimer = null;
         }
      default:
         Log.d("RichMediaActivity onPause done");
      }
   }

   protected void onResume() {
      if(this.wasClicked) {
         this.mResult = true;
         this.setResult(-1);
         this.finish();
      }

      Log.d("RichMediaActivity onResume");
      super.onResume();
      switch(this.mType) {
      case 1:
         this.mRootLayout.addView(this.mVideoLayout);
         this.mVideoView.seekTo(this.mVideoLastPosition);
         this.mVideoView.start();
         if(this.mVideoTimeoutTimer == null) {
            RichMediaActivity$VideoTimeoutTask var1 = new RichMediaActivity$VideoTimeoutTask(this, this);
            this.mVideoTimeoutTimer = new Timer();
            this.mVideoTimeoutTimer.schedule(var1, 1200000L);
         }
      default:
         Log.d("RichMediaActivity onResume done");
      }
   }

   public void onShowCustomView(View var1, CustomViewCallback var2) {
      Log.d(" onShowCustomView");
      if(var1 instanceof FrameLayout) {
         this.mCustomView = (FrameLayout)var1;
         this.mCustomViewCallback = var2;
         if(this.mCustomView.getFocusedChild() instanceof VideoView) {
            Log.d(" onShowCustomView Starting Video View");
            this.mCustomVideoView = (VideoView)this.mCustomView.getFocusedChild();
            this.mCustomVideoView.setOnCompletionListener(new OnCompletionListener() {
               public void onCompletion(MediaPlayer var1) {
                  Log.d(" onCompletion Video");
                  RichMediaActivity.this.onHideCustomView();
               }
            });
            this.mCustomVideoView.start();
         }

         this.mRootLayout.setVisibility(8);
         this.mCustomView.setVisibility(0);
         this.setContentView(this.mCustomView);
      }

   }

   public void playVideo() {
      Log.d("RichMediaActivity play video:" + this.mType);
      switch(this.mType) {
      case 1:
         if(this.mMediaController != null) {
            this.mMediaController.replay();
            return;
         }
      default:
      }
   }

   public void replayVideo() {
      if(this.mMediaController != null) {
         this.mMediaController.replay();
      }

   }
}
