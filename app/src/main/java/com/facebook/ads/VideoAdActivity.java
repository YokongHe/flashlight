package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.VideoAdActivity$a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VideoAdActivity extends Activity {
   private static final long CONTROLS_FADE_DELAY = 3000L;
   public static final String MARKET_URI_INTENT_EXTRA = "adMarketUri";
   public static final String URI_INTENT_EXTRA = "adUri";
   public static final String VIDEO_PATH_INTENT_EXTRA = "adVideoPath";
   private List mAllControls;
   private List mBufferingView;
   private ImageButton mCloseButton;
   private int mCurrentPosition = -1;
   private List mEndControls;
   private List mFullPlayingControls;
   private boolean mGoToAppStore = false;
   private Handler mHandler = new Handler();
   private ImageButton mInstallButton;
   private boolean mIsMuted = false;
   private MediaPlayer mMediaPlayer;
   private List mMinPlayingControls;
   private ImageButton mMuteButton;
   private List mPausedControls;
   private View mRootView;
   private ImageButton mSkipButton;
   private VideoAdActivity$a mState;
   private long mTimeOfLastTouch;
   private VideoView mVideoView;
   private Uri marketUri;
   private String path;
   private RelativeLayout relativeLayout;
   private String uniqueId;
   private Uri uri;

   private void activateControlSet(List var1) {
      Iterator var2 = this.mAllControls.iterator();

      while(var2.hasNext()) {
         ImageButton var3 = (ImageButton)var2.next();
         if(var1.contains(var3)) {
            var3.setVisibility(0);
         } else {
            var3.setVisibility(8);
         }
      }

   }

   private void bindModel() {
      this.setState(VideoAdActivity$a.a);
      this.mInstallButton.setBackground(this.getResources().getDrawable(17301633));
      this.mSkipButton.setBackground(this.getResources().getDrawable(17301569));
      this.mMuteButton.setBackground(this.getResources().getDrawable(17301554));
      this.mCloseButton.setBackground(this.getResources().getDrawable(17301560));
      this.mVideoView.setVideoPath(this.path);
   }

   private void configureLayout() {
      this.relativeLayout.addView(this.mRootView);
      this.relativeLayout.addView(this.mInstallButton);
      this.relativeLayout.addView(this.mSkipButton);
      this.relativeLayout.addView(this.mMuteButton);
      this.relativeLayout.addView(this.mCloseButton);
   }

   private void configureViews() {
      this.mAllControls = Arrays.asList(new ImageButton[]{this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton});
      this.mFullPlayingControls = Arrays.asList(new ImageButton[]{this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton});
      this.mMinPlayingControls = Arrays.asList(new ImageButton[]{this.mCloseButton, this.mInstallButton, this.mSkipButton});
      this.mPausedControls = Arrays.asList(new ImageButton[]{this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton});
      this.mEndControls = Arrays.asList(new ImageButton[]{this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton});
      this.mBufferingView = Arrays.asList(new ImageButton[]{this.mInstallButton, this.mCloseButton, this.mSkipButton});
      OnTouchListener var1 = new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            if(var2.getAction() == 0) {
               var1.setAlpha(0.5F);
            } else if(var2.getAction() == 1) {
               var1.setAlpha(1.0F);
            }

            return false;
         }
      };
      this.mInstallButton.setOnTouchListener(var1);
      this.mSkipButton.setOnTouchListener(var1);
      this.mMuteButton.setOnTouchListener(var1);
      this.mCloseButton.setOnTouchListener(var1);
      this.mInstallButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            VideoAdActivity.this.mGoToAppStore = true;
            VideoAdActivity.this.finish();
         }
      });
      this.mSkipButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            VideoAdActivity.this.displayInterstitial();
         }
      });
      this.mMuteButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            VideoAdActivity.this.videoMute();
         }
      });
      this.mCloseButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            VideoAdActivity.this.finish();
         }
      });
      this.mRootView.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            VideoAdActivity.this.pulseControlsFromTouch();
            return false;
         }
      });
      this.mVideoView.setOnPreparedListener(new OnPreparedListener() {
         public void onPrepared(MediaPlayer var1) {
            VideoAdActivity.this.mMediaPlayer = var1;
            if(VideoAdActivity.this.mIsMuted) {
               VideoAdActivity.this.mMediaPlayer.setVolume(0.0F, 0.0F);
            } else {
               VideoAdActivity.this.mMediaPlayer.setVolume(1.0F, 1.0F);
            }

            VideoAdActivity.this.updateVideoPlayerSize();
            if(VideoAdActivity.this.mState != VideoAdActivity$a.d && VideoAdActivity.this.mState != VideoAdActivity$a.e) {
               if(VideoAdActivity.this.mState == VideoAdActivity$a.c) {
                  VideoAdActivity.this.mMediaPlayer.seekTo(VideoAdActivity.this.mCurrentPosition);
                  VideoAdActivity.this.videoPlay();
                  return;
               }

               if(VideoAdActivity.this.mState == VideoAdActivity$a.a) {
                  VideoAdActivity.this.setState(VideoAdActivity$a.b);
                  VideoAdActivity.this.videoPlay();
                  return;
               }
            } else {
               VideoAdActivity.this.mMediaPlayer.seekTo(VideoAdActivity.this.mCurrentPosition);
            }

         }
      });
      this.mVideoView.setOnCompletionListener(new OnCompletionListener() {
         public void onCompletion(MediaPlayer var1) {
            VideoAdActivity.this.setState(VideoAdActivity$a.e);
            VideoAdActivity.this.displayInterstitial();
         }
      });
      this.mVideoView.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            VideoAdActivity.this.pulseControlsFromTouch();
            return false;
         }
      });
   }

   private void displayInterstitial() {
      Intent var1 = new Intent(this, InterstitialAdActivity.class);
      Display var2 = ((WindowManager)this.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics var3 = new DisplayMetrics();
      var2.getMetrics(var3);
      var1.putExtra("displayRotation", var2.getRotation());
      var1.putExtra("displayWidth", var3.widthPixels);
      var1.putExtra("displayHeight", var3.heightPixels);
      var1.putExtra("adInterstitialUniqueId", this.uniqueId);
      com.facebook.ads.a.y.b(this.getIntent()).a(var1);
      this.startActivity(var1);
      this.finish();
   }

   private void getIntentExtras() {
      Bundle var1 = this.getIntent().getExtras();
      this.uri = Uri.parse(var1.getString("adUri"));
      this.marketUri = Uri.parse(var1.getString("adMarketUri"));
      this.path = var1.getString("adVideoPath");
      this.uniqueId = var1.getString("adInterstitialUniqueId");
   }

   private void pulseControlsFromTouch() {
      this.mTimeOfLastTouch = System.currentTimeMillis();
      this.updateControlState();
      this.mHandler.removeCallbacksAndMessages((Object)null);
      this.mHandler.postDelayed(new Runnable() {
         public void run() {
            VideoAdActivity.this.updateControlState();
         }
      }, 3000L);
   }

   private void setButtonPosition() {
      this.mInstallButton.setX(270.0F);
      this.mInstallButton.setY(1400.0F);
      this.mSkipButton.setX(700.0F);
      this.mSkipButton.setY(1400.0F);
      this.mMuteButton.setX(10.0F);
      this.mMuteButton.setY(1160.0F);
      this.mCloseButton.setX(970.0F);
      this.mInstallButton.setScaleX(1.5F);
      this.mInstallButton.setScaleY(1.5F);
      this.mSkipButton.setScaleX(1.5F);
      this.mSkipButton.setScaleY(1.5F);
   }

   private void setState(VideoAdActivity$a var1) {
      if(var1 != this.mState) {
         this.mState = var1;
         this.pulseControlsFromTouch();
      }

   }

   private void updateControlState() {
      this.mInstallButton.setAlpha(1.0F);
      this.mSkipButton.setAlpha(1.0F);
      this.mCloseButton.setAlpha(1.0F);
      this.mVideoView.setAlpha(1.0F);
      switch(null.a[this.mState.ordinal()]) {
      case 1:
         if(System.currentTimeMillis() - this.mTimeOfLastTouch >= 3000L) {
            this.activateControlSet(this.mMinPlayingControls);
            this.mInstallButton.setAlpha(0.5F);
            this.mSkipButton.setAlpha(0.5F);
            this.mCloseButton.setAlpha(0.5F);
            return;
         }

         this.activateControlSet(this.mFullPlayingControls);
         return;
      case 2:
         this.activateControlSet(this.mPausedControls);
         return;
      case 3:
         this.activateControlSet(this.mBufferingView);
         return;
      case 4:
         this.activateControlSet(this.mBufferingView);
         return;
      case 5:
         this.activateControlSet(this.mEndControls);
         this.mMediaPlayer.seekTo((int)((float)this.mMediaPlayer.getDuration() * 0.75F));
         this.mVideoView.setAlpha(1.0F);
         return;
      default:
      }
   }

   private void updateVideoPlayerSize() {
      if(this.mMediaPlayer != null) {
         float var1 = Math.min((float)this.mRootView.getWidth() / (float)this.mMediaPlayer.getVideoWidth(), (float)this.mRootView.getHeight() / (float)this.mMediaPlayer.getVideoHeight());
         int var2 = (int)((float)this.mMediaPlayer.getVideoWidth() * var1);
         int var3 = (int)(var1 * (float)this.mMediaPlayer.getVideoHeight());
         this.mVideoView.getHolder().setFixedSize(var2, var3);
         this.mVideoView.requestLayout();
         this.mVideoView.invalidate();
      }

   }

   private void videoBackground() {
      if(this.mVideoView.isPlaying()) {
         this.mCurrentPosition = this.mVideoView.getCurrentPosition();
      }

      this.mVideoView.pause();
      this.mHandler.removeCallbacksAndMessages((Object)null);
      this.mMediaPlayer = null;
   }

   private void videoMute() {
      if(this.mState != VideoAdActivity$a.a) {
         if(this.mIsMuted) {
            this.mMediaPlayer.setVolume(1.0F, 1.0F);
            this.mMuteButton.setBackground(this.getResources().getDrawable(17301554));
         } else {
            this.mMediaPlayer.setVolume(0.0F, 0.0F);
            this.mMuteButton.setBackground(this.getResources().getDrawable(17301553));
         }

         boolean var1;
         if(!this.mIsMuted) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.mIsMuted = var1;
      }

   }

   private void videoPlay() {
      if(this.mState != VideoAdActivity$a.a && this.mState != VideoAdActivity$a.c) {
         if(this.mState == VideoAdActivity$a.e) {
            this.mVideoView.seekTo(0);
         }

         this.mVideoView.start();
         this.mCurrentPosition = this.mVideoView.getCurrentPosition();
         this.setState(VideoAdActivity$a.c);
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
         public void onGlobalLayout() {
            VideoAdActivity.this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            VideoAdActivity.this.updateVideoPlayerSize();
         }
      });
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      this.getWindow().setFlags(1024, 1024);
      this.relativeLayout = new RelativeLayout(this);
      LayoutParams var2 = new LayoutParams(-1, -1);
      var2.addRule(15);
      this.setContentView(this.relativeLayout, var2);
      this.mVideoView = new VideoView(this);
      this.mVideoView.setLayoutParams(var2);
      this.relativeLayout.addView(this.mVideoView);
      this.mRootView = new View(this);
      this.mInstallButton = new ImageButton(this);
      this.mSkipButton = new ImageButton(this);
      this.mMuteButton = new ImageButton(this);
      this.mCloseButton = new ImageButton(this);
      this.getIntentExtras();
      this.setVolumeControlStream(3);
      this.configureViews();
      this.bindModel();
      this.setButtonPosition();
      this.configureLayout();
   }

   protected void onDestroy() {
      super.onDestroy();
      if(this.mGoToAppStore) {
         ((com.facebook.ads.a.a.c)com.facebook.ads.a.a.b.a(this, this.uri)).d();
      }

   }

   protected void onPause() {
      super.onPause();
      this.videoBackground();
   }

   protected void onResume() {
      super.onResume();
      if(this.mState == VideoAdActivity$a.c && !this.mVideoView.isPlaying()) {
         this.mVideoView.seekTo(this.mCurrentPosition);
         this.mVideoView.start();
      }

      this.pulseControlsFromTouch();
   }

   protected void onStop() {
      super.onStop();
      this.videoBackground();
   }
}
