package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.HttpRedirection;
import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.MMBaseActivity;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.VideoImage;
import com.millennialmedia.android.VideoPlayerActivity$TransparentHandler;
import com.millennialmedia.android.VideoPlayerActivity$VideoRedirectionListener;
import java.lang.ref.WeakReference;

class VideoPlayerActivity extends MMBaseActivity implements OnCompletionListener, OnErrorListener, OnPreparedListener {
   private static final int CONTROLS_ID = 83756563;
   private static final String END_VIDEO = "endVideo";
   protected static final int MESSAGE_CHECK_PLAYING_VIDEO = 4;
   protected static final int MESSAGE_DELAYED_BUTTON = 3;
   protected static final int MESSAGE_INACTIVITY_ANIMATION = 1;
   protected static final int MESSAGE_ONE_SECOND_CHECK = 2;
   protected static final int MESSAGE_SET_TRANSPARENCY = 5;
   private static final String RESTART_VIDEO = "restartVideo";
   private static final String TAG = "VideoPlayerActivity";
   View blackView;
   protected int currentVideoPosition = 0;
   protected boolean hasBottomBar = true;
   private boolean hasFocus;
   boolean isPaused;
   boolean isUserPausing = false;
   protected boolean isVideoCompleted;
   private boolean isVideoCompletedOnce;
   String lastOverlayOrientation;
   protected VideoView mVideoView;
   Button pausePlay;
   ProgressBar progBar;
   HttpRedirection$RedirectionListenerImpl redirectListenerImpl;
   private boolean shouldSetUri = true;
   VideoPlayerActivity$TransparentHandler transparentHandler = new VideoPlayerActivity$TransparentHandler(this);
   RelativeLayout videoLayout;

   // $FF: synthetic method
   static boolean access$000(VideoPlayerActivity var0, Uri var1) {
      return var0.isActionable(var1);
   }

   private void initBottomBar(RelativeLayout var1) {
      RelativeLayout var2 = new RelativeLayout(this.activity);
      var2.setId(83756563);
      var2.setBackgroundColor(-16777216);
      LayoutParams var3 = new LayoutParams(-1, -2);
      var2.setLayoutParams(var3);
      var3.addRule(12);
      Button var4 = new Button(this.activity);
      this.pausePlay = new Button(this.activity);
      Button var5 = new Button(this.activity);
      var4.setBackgroundResource(17301541);
      if(this.mVideoView.isPlaying()) {
         this.pausePlay.setBackgroundResource(17301539);
      } else {
         this.pausePlay.setBackgroundResource(17301540);
      }

      var5.setBackgroundResource(17301560);
      LayoutParams var6 = new LayoutParams(-2, -2);
      LayoutParams var7 = new LayoutParams(-2, -2);
      LayoutParams var8 = new LayoutParams(-2, -2);
      var6.addRule(14);
      var2.addView(this.pausePlay, var6);
      var8.addRule(0, this.pausePlay.getId());
      var2.addView(var4);
      var7.addRule(11);
      var2.addView(var5, var7);
      var4.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(VideoPlayerActivity.this.mVideoView != null) {
               VideoPlayerActivity.this.mVideoView.seekTo(0);
            }

         }
      });
      this.pausePlay.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(VideoPlayerActivity.this.mVideoView != null) {
               if(!VideoPlayerActivity.this.mVideoView.isPlaying()) {
                  if(VideoPlayerActivity.this.isVideoCompleted) {
                     VideoPlayerActivity.this.playVideo(0);
                  } else if(VideoPlayerActivity.this.isUserPausing && !VideoPlayerActivity.this.isVideoCompleted) {
                     VideoPlayerActivity.this.resumeVideo();
                  } else {
                     VideoPlayerActivity.this.playVideo(VideoPlayerActivity.this.currentVideoPosition);
                  }

                  VideoPlayerActivity.this.pausePlay.setBackgroundResource(17301539);
                  return;
               }

               VideoPlayerActivity.this.pauseVideoByUser();
               VideoPlayerActivity.this.pausePlay.setBackgroundResource(17301540);
            }

         }
      });
      var5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(VideoPlayerActivity.this.mVideoView != null) {
               VideoPlayerActivity.this.shouldSetUri = true;
               VideoPlayerActivity.this.dismiss();
            }

         }
      });
      var1.addView(var2, var3);
   }

   private void initRedirectListener() {
      this.redirectListenerImpl = new VideoPlayerActivity$VideoRedirectionListener(this);
   }

   private void initVideoListeners() {
      this.mVideoView.setOnCompletionListener(this);
      this.mVideoView.setOnPreparedListener(this);
      this.mVideoView.setOnErrorListener(this);
   }

   private void initWindow() {
      this.requestWindowFeature(1);
      this.getWindow().clearFlags(2048);
      this.getWindow().addFlags(1024);
   }

   private boolean isActionSupported(String var1) {
      return var1 != null && (var1.equalsIgnoreCase("restartVideo") || var1.equalsIgnoreCase("endVideo"));
   }

   private boolean isActionable(Uri var1) {
      if(var1.getScheme().equalsIgnoreCase("mmsdk")) {
         if(this.isActionSupported(var1.getHost())) {
            return true;
         }

         MMLog.v("VideoPlayerActivity", String.format("Unrecognized mmsdk:// URI %s.", new Object[]{var1}));
      }

      return false;
   }

   private void makeTransparent() {
      if(!this.transparentHandler.hasMessages(4)) {
         this.transparentHandler.sendEmptyMessage(4);
      }

   }

   private void startVideo(int var1) {
      this.mVideoView.requestFocus();
      this.mVideoView.seekTo(var1);
      if(((PowerManager)this.getSystemService("power")).isScreenOn()) {
         if(this.progBar != null) {
            this.progBar.bringToFront();
            this.progBar.setVisibility(0);
         }

         if(this.pausePlay != null) {
            this.pausePlay.setBackgroundResource(17301539);
         }

         this.mVideoView.start();
         this.makeTransparent();
      }

   }

   protected boolean canFadeButtons() {
      return !this.isVideoCompleted;
   }

   protected void dismiss() {
      MMLog.d("VideoPlayerActivity", "Video ad player closed");
      if(this.mVideoView != null) {
         if(this.mVideoView.isPlaying()) {
            this.mVideoView.stopPlayback();
         }

         this.mVideoView = null;
      }

      this.finish();
   }

   void dispatchButtonClick(String var1) {
      if(var1 != null) {
         MMLog.d("VideoPlayerActivity", String.format("Button Click with URL: %s", new Object[]{var1}));
         this.redirectListenerImpl.url = var1;
         this.redirectListenerImpl.weakContext = new WeakReference(this.activity);
         if(!this.redirectListenerImpl.isHandlingMMVideo(Uri.parse(var1))) {
            HttpRedirection.startActivityFromUri(this.redirectListenerImpl);
            return;
         }
      }

   }

   protected void enableButtons() {
   }

   protected void endVideo() {
      MMLog.d("VideoPlayerActivity", "End Video.");
      if(this.mVideoView != null) {
         this.shouldSetUri = true;
         this.dismiss();
      }

   }

   protected void errorPlayVideo(String var1) {
      Toast.makeText(this.activity, "Sorry. There was a problem playing the video", 1).show();
      if(this.mVideoView != null) {
         this.mVideoView.stopPlayback();
      }

   }

   void handleTransparentMessage(Message var1) {
      switch(var1.what) {
      case 4:
         if(this.mVideoView != null && this.mVideoView.isPlaying() && this.mVideoView.getCurrentPosition() > 0) {
            this.mVideoView.setBackgroundColor(0);
            this.transparentHandler.sendEmptyMessageDelayed(5, 100L);
            return;
         }

         this.transparentHandler.sendEmptyMessageDelayed(4, 50L);
         return;
      case 5:
         if(this.mVideoView != null && this.mVideoView.isPlaying() && this.mVideoView.getCurrentPosition() > 0) {
            this.blackView.setVisibility(4);
            this.progBar.setVisibility(4);
            return;
         }
      default:
      }
   }

   protected RelativeLayout initLayout() {
      RelativeLayout var1 = new RelativeLayout(this.activity);
      var1.setId(400);
      var1.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
      var1.setBackgroundColor(-16777216);
      this.videoLayout = new RelativeLayout(this.activity);
      this.videoLayout.setBackgroundColor(-16777216);
      this.videoLayout.setId(410);
      LayoutParams var2 = new LayoutParams(-1, -2);
      LayoutParams var3 = new LayoutParams(-1, -1);
      var3.addRule(13);
      var2.addRule(13);
      this.mVideoView = new VideoView(this.activity);
      this.mVideoView.setId(411);
      this.mVideoView.getHolder().setFormat(-2);
      this.mVideoView.setBackgroundColor(-16777216);
      this.initVideoListeners();
      this.videoLayout.addView(this.mVideoView, var3);
      this.blackView = new View(this.activity);
      this.blackView.setBackgroundColor(-16777216);
      var3 = new LayoutParams(-1, -1);
      var1.addView(this.videoLayout, var2);
      if(this.hasBottomBar) {
         var3.addRule(2, 83756563);
         this.initBottomBar(var1);
      }

      this.blackView.setLayoutParams(var3);
      var1.addView(this.blackView);
      this.progBar = new ProgressBar(this.activity);
      this.progBar.setIndeterminate(true);
      var2 = new LayoutParams(-2, -2);
      var2.addRule(13);
      this.progBar.setLayoutParams(var2);
      var1.addView(this.progBar);
      this.progBar.setVisibility(4);
      return var1;
   }

   protected void initSavedInstance(Bundle var1) {
      if(var1 != null) {
         this.isVideoCompleted = var1.getBoolean("videoCompleted");
         this.isVideoCompletedOnce = var1.getBoolean("videoCompletedOnce");
         this.currentVideoPosition = var1.getInt("videoPosition");
         this.hasBottomBar = var1.getBoolean("hasBottomBar");
         this.shouldSetUri = var1.getBoolean("shouldSetUri");
      }

   }

   protected boolean isPlayable() {
      return this.mVideoView != null && !this.mVideoView.isPlaying() && !this.isVideoCompleted;
   }

   protected void logButtonEvent(VideoImage var1) {
      MMLog.d("VideoPlayerActivity", "Cached video button event logged");

      for(int var2 = 0; var2 < var1.eventLoggingUrls.length; ++var2) {
         MMSDK$Event.logEvent(var1.eventLoggingUrls[var2]);
      }

   }

   public void onCompletion(MediaPlayer var1) {
      this.isVideoCompletedOnce = true;
      this.isVideoCompleted = true;
      if(this.pausePlay != null && !this.mVideoView.isPlaying()) {
         this.pausePlay.setBackgroundResource(17301540);
      }

      MMLog.v("VideoPlayerActivity", "Video player on complete");
   }

   public void onCreate(Bundle var1) {
      this.setTheme(16973829);
      super.onCreate(var1);
      MMLog.d("VideoPlayerActivity", "Setting up the video player");
      this.initWindow();
      this.initSavedInstance(var1);
      this.initRedirectListener();
      this.setContentView(this.initLayout());
   }

   public void onDestroy() {
      super.onDestroy();
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      return false;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return var1 == 4 && var2.getRepeatCount() == 0 && !this.isVideoCompletedOnce?true:super.onKeyDown(var1, var2);
   }

   protected void onPause() {
      super.onPause();
      this.isPaused = true;
      MMLog.v("VideoPlayerActivity", "VideoPlayer - onPause");
      this.pauseVideo();
   }

   public void onPrepared(MediaPlayer var1) {
      MMLog.d("VideoPlayerActivity", "Video Prepared");
   }

   protected void onRestoreInstanceState(Bundle var1) {
      this.currentVideoPosition = var1.getInt("currentVideoPosition");
      this.isVideoCompleted = var1.getBoolean("isVideoCompleted");
      this.isVideoCompletedOnce = var1.getBoolean("isVideoCompletedOnce");
      this.hasBottomBar = var1.getBoolean("hasBottomBar", this.hasBottomBar);
      this.shouldSetUri = var1.getBoolean("shouldSetUri", this.shouldSetUri);
      this.isUserPausing = var1.getBoolean("isUserPausing", this.isUserPausing);
      this.isPaused = var1.getBoolean("isPaused", this.isPaused);
      super.onRestoreInstanceState(var1);
   }

   protected void onResume() {
      super.onResume();
      this.blackView.bringToFront();
      this.blackView.setVisibility(0);
      this.isPaused = false;
      MMLog.v("VideoPlayerActivity", "VideoPlayer - onResume");
      if(this.hasFocus && !this.isUserPausing) {
         this.resumeVideo();
      }

   }

   protected void onSaveInstanceState(Bundle var1) {
      var1.putInt("currentVideoPosition", this.currentVideoPosition);
      var1.putBoolean("isVideoCompleted", this.isVideoCompleted);
      var1.putBoolean("isVideoCompletedOnce", this.isVideoCompletedOnce);
      var1.putBoolean("hasBottomBar", this.hasBottomBar);
      var1.putBoolean("shouldSetUri", this.shouldSetUri);
      var1.putBoolean("isUserPausing", this.isUserPausing);
      var1.putBoolean("isPaused", this.isPaused);
      super.onSaveInstanceState(var1);
   }

   public void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      this.hasFocus = var1;
      if(!this.isPaused && var1 && !this.isUserPausing) {
         this.resumeVideo();
      }

   }

   protected void pauseVideo() {
      if(this.mVideoView != null && this.mVideoView.isPlaying()) {
         this.currentVideoPosition = this.mVideoView.getCurrentPosition();
         this.mVideoView.pause();
         MMLog.v("VideoPlayerActivity", "Video paused");
      }

   }

   protected void pauseVideoByUser() {
      this.isUserPausing = true;
      this.pauseVideo();
   }

   protected void playVideo(int param1) {
      // $FF: Couldn't be decompiled
   }

   void processVideoPlayerUri(final String var1) {
      this.runOnUiThread(new Runnable() {
         public void run() {
            if(var1.equalsIgnoreCase("restartVideo")) {
               VideoPlayerActivity.this.restartVideo();
            } else if(var1.equalsIgnoreCase("endVideo")) {
               VideoPlayerActivity.this.endVideo();
               return;
            }

         }
      });
   }

   protected void restartVideo() {
      MMLog.d("VideoPlayerActivity", "Restart Video.");
      if(this.mVideoView != null) {
         this.playVideo(0);
      }

   }

   protected void resumeVideo() {
      if(this.isPlayable()) {
         this.playVideo(this.currentVideoPosition);
      }

   }

   protected void setButtonAlpha(ImageButton var1, float var2) {
      AlphaAnimation var3 = new AlphaAnimation(var2, var2);
      var3.setDuration(0L);
      var3.setFillEnabled(true);
      var3.setFillBefore(true);
      var3.setFillAfter(true);
      var1.startAnimation(var3);
   }
}
