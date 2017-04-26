package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask;
import com.mopub.common.DownloadTask$DownloadTaskListener;
import com.mopub.common.HttpClient;
import com.mopub.common.HttpResponses;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.MoPubEvents$Type;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Streams;
import com.mopub.common.util.VersionCode;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController$BaseVideoViewControllerListener;
import com.mopub.mobileads.VastVideoToolbar;
import com.mopub.mobileads.util.vast.VastCompanionAd;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;
import com.mopub.network.TrackingRequest;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class VastVideoViewController extends BaseVideoViewController implements DownloadTask$DownloadTaskListener {
   static final int DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON = 5000;
   private static final float FIRST_QUARTER_MARKER = 0.25F;
   static final int MAX_VIDEO_DURATION_FOR_CLOSE_BUTTON = 16000;
   private static final int MAX_VIDEO_RETRIES = 1;
   private static final float MID_POINT_MARKER = 0.5F;
   private static final int MOPUB_BROWSER_REQUEST_CODE = 1;
   static final int START_MARK_THRESHOLD = 2000;
   private static final float THIRD_QUARTER_MARKER = 0.75F;
   static final String VAST_VIDEO_CONFIGURATION = "vast_video_configuration";
   private static final long VIDEO_PROGRESS_TIMER_CHECKER_DELAY = 50L;
   private static final int VIDEO_VIEW_FILE_PERMISSION_ERROR = Integer.MIN_VALUE;
   private final OnTouchListener mClickThroughListener;
   private final ImageView mCompanionAdImageView;
   private boolean mCompletionTrackerFired;
   private final Handler mHandler = new Handler();
   private boolean mIsFinalMarkHit;
   private boolean mIsFirstMarkHit;
   private boolean mIsSecondMarkHit;
   private boolean mIsStartMarkHit;
   private boolean mIsThirdMarkHit;
   private boolean mIsVideoFinishedPlaying;
   private boolean mIsVideoProgressShouldBeChecked = false;
   private int mSeekerPositionOnPause = -1;
   private int mShowCloseButtonDelay = 5000;
   private boolean mShowCloseButtonEventFired;
   private final VastCompanionAd mVastCompanionAd;
   private final VastVideoConfiguration mVastVideoConfiguration;
   private final VastVideoToolbar mVastVideoToolbar;
   private boolean mVideoError;
   private final Runnable mVideoProgressCheckerRunnable;
   private int mVideoRetries = 0;
   private final VideoView mVideoView;

   VastVideoViewController(Context var1, Bundle var2, long var3, BaseVideoViewController$BaseVideoViewControllerListener var5) {
      super(var1, Long.valueOf(var3), var5);
      Serializable var6 = var2.getSerializable("vast_video_configuration");
      if(var6 != null && var6 instanceof VastVideoConfiguration) {
         this.mVastVideoConfiguration = (VastVideoConfiguration)var6;
         if(this.mVastVideoConfiguration.getDiskMediaFileUrl() == null) {
            throw new IllegalStateException("VastVideoConfiguration does not have a video disk path");
         } else {
            this.mVastCompanionAd = this.mVastVideoConfiguration.getVastCompanionAd();
            this.mClickThroughListener = new OnTouchListener() {
               public boolean onTouch(View var1, MotionEvent var2) {
                  if(var2.getAction() == 1 && VastVideoViewController.this.shouldAllowClickThrough()) {
                     VastVideoViewController.this.handleClick(VastVideoViewController.this.mVastVideoConfiguration.getClickTrackers(), VastVideoViewController.this.mVastVideoConfiguration.getClickThroughUrl());
                  }

                  return true;
               }
            };
            this.createVideoBackground(var1);
            this.mVideoView = this.createVideoView(var1);
            this.mVideoView.requestFocus();
            this.mVastVideoToolbar = this.createVastVideoToolBar(var1);
            this.getLayout().addView(this.mVastVideoToolbar);
            this.mCompanionAdImageView = this.createCompanionAdImageView(var1);
            this.mVideoProgressCheckerRunnable = this.createVideoProgressCheckerRunnable();
         }
      } else {
         throw new IllegalStateException("VastVideoConfiguration is invalid");
      }
   }

   private ImageView createCompanionAdImageView(Context var1) {
      RelativeLayout var2 = new RelativeLayout(var1);
      var2.setGravity(17);
      LayoutParams var3 = new LayoutParams(-1, -1);
      var3.addRule(3, this.mVastVideoToolbar.getId());
      this.getLayout().addView(var2, var3);
      ImageView var4 = new ImageView(var1);
      var4.setVisibility(4);
      var2.addView(var4, new LayoutParams(-1, -1));
      return var4;
   }

   private VastVideoToolbar createVastVideoToolBar(Context var1) {
      VastVideoToolbar var2 = new VastVideoToolbar(var1);
      var2.setCloseButtonOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            if(var2.getAction() == 1) {
               VastVideoViewController.this.getBaseVideoViewControllerListener().onFinish();
            }

            return true;
         }
      });
      var2.setLearnMoreButtonOnTouchListener(this.mClickThroughListener);
      return var2;
   }

   private void createVideoBackground(Context var1) {
      GradientDrawable var2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.argb(0, 0, 0, 0), Color.argb(255, 0, 0, 0)});
      LayerDrawable var3 = new LayerDrawable(new Drawable[]{Drawables.THATCHED_BACKGROUND.createDrawable(var1), var2});
      this.getLayout().setBackgroundDrawable(var3);
   }

   private Runnable createVideoProgressCheckerRunnable() {
      return new Runnable() {
         public void run() {
            float var2 = (float)VastVideoViewController.this.mVideoView.getDuration();
            float var1 = (float)VastVideoViewController.this.mVideoView.getCurrentPosition();
            if(var2 > 0.0F) {
               var2 = var1 / var2;
               if(!VastVideoViewController.this.mIsStartMarkHit && var1 >= 2000.0F) {
                  VastVideoViewController.this.mIsStartMarkHit = true;
                  TrackingRequest.makeTrackingHttpRequest((Iterable)VastVideoViewController.this.mVastVideoConfiguration.getStartTrackers(), VastVideoViewController.this.getContext());
               }

               if(!VastVideoViewController.this.mIsFirstMarkHit && var2 > 0.25F) {
                  VastVideoViewController.this.mIsFirstMarkHit = true;
                  TrackingRequest.makeTrackingHttpRequest((Iterable)VastVideoViewController.this.mVastVideoConfiguration.getFirstQuartileTrackers(), VastVideoViewController.this.getContext());
               }

               if(!VastVideoViewController.this.mIsSecondMarkHit && var2 > 0.5F) {
                  VastVideoViewController.this.mIsSecondMarkHit = true;
                  TrackingRequest.makeTrackingHttpRequest((Iterable)VastVideoViewController.this.mVastVideoConfiguration.getMidpointTrackers(), VastVideoViewController.this.getContext());
               }

               if(!VastVideoViewController.this.mIsThirdMarkHit && var2 > 0.75F) {
                  VastVideoViewController.this.mIsThirdMarkHit = true;
                  VastVideoViewController.this.mIsFinalMarkHit = true;
                  TrackingRequest.makeTrackingHttpRequest((Iterable)VastVideoViewController.this.mVastVideoConfiguration.getThirdQuartileTrackers(), VastVideoViewController.this.getContext());
               }

               if(VastVideoViewController.this.isLongVideo(VastVideoViewController.this.mVideoView.getDuration())) {
                  VastVideoViewController.this.mVastVideoToolbar.updateCountdownWidget(VastVideoViewController.this.mShowCloseButtonDelay - VastVideoViewController.this.mVideoView.getCurrentPosition());
               }

               if(VastVideoViewController.this.shouldBeInteractable()) {
                  VastVideoViewController.this.makeVideoInteractable();
               }
            }

            VastVideoViewController.this.mVastVideoToolbar.updateDurationWidget(VastVideoViewController.this.mVideoView.getDuration() - VastVideoViewController.this.mVideoView.getCurrentPosition());
            if(VastVideoViewController.this.mIsVideoProgressShouldBeChecked) {
               VastVideoViewController.this.mHandler.postDelayed(VastVideoViewController.this.mVideoProgressCheckerRunnable, 50L);
            }

         }
      };
   }

   private VideoView createVideoView(final Context var1) {
      final VideoView var2 = new VideoView(var1);
      var2.setOnPreparedListener(new OnPreparedListener() {
         public void onPrepared(MediaPlayer var1) {
            if(VastVideoViewController.this.mVideoView.getDuration() < 16000) {
               VastVideoViewController.this.mShowCloseButtonDelay = VastVideoViewController.this.mVideoView.getDuration();
            }

         }
      });
      var2.setOnTouchListener(this.mClickThroughListener);
      var2.setOnCompletionListener(new OnCompletionListener() {
         public void onCompletion(MediaPlayer var1x) {
            VastVideoViewController.this.stopProgressChecker();
            VastVideoViewController.this.makeVideoInteractable();
            VastVideoViewController.this.videoCompleted(false);
            VastVideoViewController.this.mIsVideoFinishedPlaying = true;
            if(!VastVideoViewController.this.mVideoError && VastVideoViewController.this.mIsFinalMarkHit && !VastVideoViewController.this.mCompletionTrackerFired) {
               TrackingRequest.makeTrackingHttpRequest((Iterable)VastVideoViewController.this.mVastVideoConfiguration.getCompleteTrackers(), var1);
               VastVideoViewController.this.mCompletionTrackerFired = true;
            }

            var2.setVisibility(8);
            if(VastVideoViewController.this.mCompanionAdImageView.getDrawable() != null) {
               VastVideoViewController.this.mCompanionAdImageView.setVisibility(0);
            }

         }
      });
      var2.setOnErrorListener(new OnErrorListener() {
         public boolean onError(MediaPlayer var1, int var2, int var3) {
            if(VastVideoViewController.this.retryMediaPlayer(var1, var2, var3)) {
               return true;
            } else {
               VastVideoViewController.this.stopProgressChecker();
               VastVideoViewController.this.makeVideoInteractable();
               VastVideoViewController.this.videoError(false);
               VastVideoViewController.this.mVideoError = true;
               return false;
            }
         }
      });
      var2.setVideoPath(this.mVastVideoConfiguration.getDiskMediaFileUrl());
      return var2;
   }

   private void downloadCompanionAd() {
      if(this.mVastCompanionAd != null) {
         try {
            HttpGet var1 = HttpClient.initializeHttpGet(this.mVastCompanionAd.getImageUrl(), this.getContext());
            AsyncTasks.safeExecuteOnExecutor(new DownloadTask(this), new HttpUriRequest[]{var1});
         } catch (Exception var2) {
            MoPubLog.d("Failed to download companion ad", var2);
            return;
         }
      }

   }

   private boolean isLongVideo(int var1) {
      return var1 >= 16000;
   }

   private void makeVideoInteractable() {
      this.mShowCloseButtonEventFired = true;
      this.mVastVideoToolbar.makeInteractable();
   }

   private boolean shouldAllowClickThrough() {
      return this.mShowCloseButtonEventFired;
   }

   private boolean shouldBeInteractable() {
      return !this.mShowCloseButtonEventFired && this.mVideoView.getCurrentPosition() > this.mShowCloseButtonDelay;
   }

   private void startProgressChecker() {
      if(!this.mIsVideoProgressShouldBeChecked) {
         this.mIsVideoProgressShouldBeChecked = true;
         this.mHandler.post(this.mVideoProgressCheckerRunnable);
      }

   }

   private void stopProgressChecker() {
      if(this.mIsVideoProgressShouldBeChecked) {
         this.mIsVideoProgressShouldBeChecked = false;
         this.mHandler.removeCallbacks(this.mVideoProgressCheckerRunnable);
      }

   }

   public boolean backButtonEnabled() {
      return this.mShowCloseButtonEventFired;
   }

   @Deprecated
   @VisibleForTesting
   ImageView getCompanionAdImageView() {
      return this.mCompanionAdImageView;
   }

   @Deprecated
   @VisibleForTesting
   boolean getIsVideoProgressShouldBeChecked() {
      return this.mIsVideoProgressShouldBeChecked;
   }

   @Deprecated
   @VisibleForTesting
   int getShowCloseButtonDelay() {
      return this.mShowCloseButtonDelay;
   }

   @Deprecated
   @VisibleForTesting
   boolean getVideoError() {
      return this.mVideoError;
   }

   @Deprecated
   @VisibleForTesting
   int getVideoRetries() {
      return this.mVideoRetries;
   }

   protected VideoView getVideoView() {
      return this.mVideoView;
   }

   @VisibleForTesting
   void handleClick(List var1, String var2) {
      TrackingRequest.makeTrackingHttpRequest((Iterable)var1, this.getContext(), (MoPubEvents$Type)MoPubEvents$Type.CLICK_REQUEST);
      if(var2 != null) {
         this.broadcastAction("com.mopub.action.interstitial.click");
         if(Intents.isNativeBrowserScheme(var2)) {
            try {
               Intent var6 = Intents.intentForNativeBrowserScheme(var2);
               Intents.startActivity(this.getContext(), var6);
            } catch (UrlParseException var3) {
               MoPubLog.d(var3.getMessage());
            } catch (IntentNotResolvableException var4) {
               MoPubLog.d("Could not handle intent for URI: " + var2 + ". " + var4.getMessage());
            }
         } else {
            Bundle var5 = new Bundle();
            var5.putString("URL", var2);
            this.getBaseVideoViewControllerListener().onStartActivityForResult(MoPubBrowser.class, 1, var5);
         }
      }
   }

   @Deprecated
   @VisibleForTesting
   boolean isShowCloseButtonEventFired() {
      return this.mShowCloseButtonEventFired;
   }

   @Deprecated
   @VisibleForTesting
   boolean isVideoFinishedPlaying() {
      return this.mIsVideoFinishedPlaying;
   }

   void onActivityResult(int var1, int var2, Intent var3) {
      if(var1 == 1 && var2 == -1) {
         this.getBaseVideoViewControllerListener().onFinish();
      }

   }

   public void onComplete(String var1, DownloadResponse var2) {
      if(var2 != null && var2.getStatusCode() == 200) {
         Bitmap var7 = HttpResponses.asBitmap(var2);
         if(var7 != null) {
            int var3 = Dips.dipsToIntPixels((float)var7.getWidth(), this.getContext());
            int var4 = Dips.dipsToIntPixels((float)var7.getHeight(), this.getContext());
            int var5 = this.mCompanionAdImageView.getMeasuredWidth();
            int var6 = this.mCompanionAdImageView.getMeasuredHeight();
            if(var3 < var5 && var4 < var6) {
               this.mCompanionAdImageView.getLayoutParams().width = var3;
               this.mCompanionAdImageView.getLayoutParams().height = var4;
            }

            this.mCompanionAdImageView.setImageBitmap(var7);
            this.mCompanionAdImageView.setOnClickListener(new OnClickListener() {
               public void onClick(View var1) {
                  if(VastVideoViewController.this.mVastCompanionAd != null) {
                     VastVideoViewController.this.handleClick(VastVideoViewController.this.mVastCompanionAd.getClickTrackers(), VastVideoViewController.this.mVastCompanionAd.getClickThroughUrl());
                  }

               }
            });
         }
      }

   }

   protected void onCreate() {
      super.onCreate();
      this.getBaseVideoViewControllerListener().onSetRequestedOrientation(0);
      this.downloadCompanionAd();
      TrackingRequest.makeTrackingHttpRequest((Iterable)this.mVastVideoConfiguration.getImpressionTrackers(), this.getContext(), (MoPubEvents$Type)MoPubEvents$Type.IMPRESSION_REQUEST);
      this.broadcastAction("com.mopub.action.interstitial.show");
   }

   protected void onDestroy() {
      this.stopProgressChecker();
      this.broadcastAction("com.mopub.action.interstitial.dismiss");
   }

   protected void onPause() {
      this.stopProgressChecker();
      this.mSeekerPositionOnPause = this.mVideoView.getCurrentPosition();
      this.mVideoView.pause();
   }

   protected void onResume() {
      this.mVideoRetries = 0;
      this.startProgressChecker();
      this.mVideoView.seekTo(this.mSeekerPositionOnPause);
      if(!this.mIsVideoFinishedPlaying) {
         this.mVideoView.start();
      }

   }

   boolean retryMediaPlayer(MediaPlayer var1, int var2, int var3) {
      if(VersionCode.currentApiLevel().isBelow(VersionCode.JELLY_BEAN) && var2 == 1 && var3 == Integer.MIN_VALUE && this.mVideoRetries <= 0) {
         Object var5 = null;

         label127: {
            label136: {
               FileInputStream var4;
               label125: {
                  try {
                     ((MediaPlayer)var1).reset();
                     var4 = new FileInputStream(new File(this.mVastVideoConfiguration.getDiskMediaFileUrl()));
                     break label125;
                  } catch (Exception var16) {
                     ;
                  } finally {
                     ;
                  }

                  var1 = null;
                  break label136;
               }

               try {
                  ((MediaPlayer)var1).setDataSource(var4.getFD());
                  ((MediaPlayer)var1).prepareAsync();
                  this.mVideoView.start();
                  break label127;
               } catch (Exception var14) {
                  var1 = var14;
               } finally {
                  Streams.closeStream(var4);
                  ++this.mVideoRetries;
                  throw var1;
               }

            }

            Streams.closeStream((Closeable)var1);
            ++this.mVideoRetries;
            return false;
         }

      } else {
         return false;
      }
   }

   @Deprecated
   @VisibleForTesting
   void setCloseButtonVisible(boolean var1) {
      this.mShowCloseButtonEventFired = var1;
   }

   @Deprecated
   @VisibleForTesting
   void setFinalMarkHit() {
      this.mIsFinalMarkHit = true;
   }

   @Deprecated
   @VisibleForTesting
   void setVideoError() {
      this.mVideoError = true;
   }
}
