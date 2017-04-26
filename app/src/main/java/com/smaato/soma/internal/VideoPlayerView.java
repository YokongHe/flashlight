package com.smaato.soma.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import android.widget.FrameLayout.LayoutParams;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.VideoInterface;
import com.smaato.soma.VideoInterface$VideoState;
import com.smaato.soma.VideoListener;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.StartingVideoFailed;
import com.smaato.soma.exception.VideoPlayerInstantiationException;

public class VideoPlayerView extends FrameLayout implements VideoInterface {
   private static final String TAG = "SOMA";
   Context mContext = null;
   ReceivedBannerInterface mLastReceivedBanner = null;
   ProgressBar mProgress = null;
   VideoInterface mSOMAVideo = null;
   VideoInterface$VideoState mState;
   VideoView mVideo = null;
   VideoListener mVideoListener;

   public VideoPlayerView(final Context var1) {
      super(var1);
      this.mState = VideoInterface$VideoState.EMPTY;
      this.mVideoListener = new VideoListener() {
         public void onVideoFinished(VideoInterface var1) {
         }

         public void onVideoPrepared(VideoInterface var1) {
            try {
               var1.start();
            } catch (RuntimeException var2) {
               throw var2;
            } catch (Exception var3) {
               throw new StartingVideoFailed(var3);
            }
         }
      };
      (new CrashReportTemplate() {
         public Void process() {
            VideoPlayerView.this.initVideoBanner(var1);
            return null;
         }
      }).execute();
   }

   public VideoPlayerView(final Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mState = VideoInterface$VideoState.EMPTY;
      this.mVideoListener = new VideoListener() {
         public void onVideoFinished(VideoInterface var1) {
         }

         public void onVideoPrepared(VideoInterface var1) {
            try {
               var1.start();
            } catch (RuntimeException var2) {
               throw var2;
            } catch (Exception var3) {
               throw new StartingVideoFailed(var3);
            }
         }
      };
      (new CrashReportTemplate() {
         public Void process() {
            VideoPlayerView.this.initVideoBanner(var1);
            return null;
         }
      }).execute();
   }

   public VideoPlayerView(final Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mState = VideoInterface$VideoState.EMPTY;
      this.mVideoListener = new VideoListener() {
         public void onVideoFinished(VideoInterface var1) {
         }

         public void onVideoPrepared(VideoInterface var1) {
            try {
               var1.start();
            } catch (RuntimeException var2) {
               throw var2;
            } catch (Exception var3) {
               throw new StartingVideoFailed(var3);
            }
         }
      };
      (new CrashReportTemplate() {
         public Void process() {
            VideoPlayerView.this.initVideoBanner(var1);
            return null;
         }
      }).execute();
   }

   private void initVideoBanner(Context var1) {
      try {
         Debugger.methodStart(new Object() {
         });
         this.mContext = var1;
         this.mSOMAVideo = this;
         this.mVideo = new VideoView(var1);
         LayoutParams var2 = new LayoutParams(-1, -1);
         var2.gravity = 17;
         this.mVideo.setLayoutParams(var2);
         this.mVideo.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer var1) {
               (new CrashReportTemplate() {
                  public Void process() {
                     VideoPlayerView.this.mProgress.setEnabled(false);
                     VideoPlayerView.this.mProgress.setVisibility(8);
                     VideoPlayerView.this.mState = VideoInterface$VideoState.STOPPED;
                     VideoPlayerView.this.mVideoListener.onVideoPrepared(VideoPlayerView.this.mSOMAVideo);
                     Debugger.showLog(new LogMessage("SOMA", "Starting Video", 1, DebugCategory.VERVOSE));
                     return null;
                  }
               }).execute();
            }
         });
         this.mVideo.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer var1) {
               (new CrashReportTemplate() {
                  public Void process() {
                     VideoPlayerView.this.mState = VideoInterface$VideoState.FINISHED;
                     VideoPlayerView.this.mVideoListener.onVideoFinished(VideoPlayerView.this.mSOMAVideo);
                     return null;
                  }
               }).execute();
            }
         });
         this.mVideo.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer var1, final int var2, int var3) {
               return ((Boolean)(new CrashReportTemplate() {
                  public Boolean process() {
                     VideoPlayerView.this.mProgress.setEnabled(false);
                     VideoPlayerView.this.mProgress.setVisibility(8);
                     Log.v("SOMA", "Video error: " + var2);
                     return Boolean.valueOf(false);
                  }
               }).execute()).booleanValue();
            }
         });
         this.mVideo.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View var1, MotionEvent var2) {
               return ((Boolean)(new CrashReportTemplate() {
                  public Boolean process() {
                     if(VideoPlayerView.this.mLastReceivedBanner != null) {
                        VideoPlayerView.this.mLastReceivedBanner.openLandingPage(VideoPlayerView.this.mContext);
                     }

                     Log.v("SOMA", "Video clicked");
                     return Boolean.valueOf(true);
                  }
               }).execute()).booleanValue();
            }
         });
         this.addView(this.mVideo);
         this.mProgress = new ProgressBar(var1);
         LayoutParams var5 = new LayoutParams(-2, -2, 17);
         this.mProgress.setLayoutParams(var5);
         this.mProgress.setIndeterminate(true);
         this.addView(this.mProgress);
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new VideoPlayerInstantiationException(var4);
      }
   }

   public void downloadFinished(final ReceivedBannerInterface var1) {
      (new CrashReportTemplate() {
         public Void process() {
            VideoPlayerView.this.mLastReceivedBanner = var1;
            Log.v("SOMA", "Video url download finished (loading video)");
            VideoPlayerView.this.mVideo.setVideoPath(var1.getMediaFile());
            return null;
         }
      }).execute();
   }

   public void downloadStarted() {
      (new CrashReportTemplate() {
         public Void process() {
            Log.v("SOMA", "Video download started");
            VideoPlayerView.this.mProgress.setEnabled(true);
            return null;
         }
      }).execute();
   }

   public VideoInterface$VideoState getState() {
      return this.mState;
   }

   public void pause() {
      (new CrashReportTemplate() {
         public Void process() {
            VideoPlayerView.this.mVideo.pause();
            VideoPlayerView.this.mState = VideoInterface$VideoState.PAUSED;
            return null;
         }
      }).execute();
   }

   public void setVideoListener(VideoListener var1) {
      this.mVideoListener = var1;
   }

   public void start() {
      (new CrashReportTemplate() {
         public Void process() {
            VideoPlayerView.this.mVideo.start();
            VideoPlayerView.this.mState = VideoInterface$VideoState.RUNNING;
            return null;
         }
      }).execute();
   }

   public void stop() {
      (new CrashReportTemplate() {
         public Void process() {
            VideoPlayerView.this.mVideo.stopPlayback();
            VideoPlayerView.this.mState = VideoInterface$VideoState.STOPPED;
            return null;
         }
      }).execute();
   }
}
