package com.smaato.soma.bannerutilities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.VideoChrome;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.ClosingVideoFailed;
import com.smaato.soma.exception.StartingVideoFailedException;
import com.smaato.soma.exception.VideoRootViewNotFoundException;

class VideoChrome$VideoSubView implements OnCompletionListener, OnErrorListener {
   private FrameLayout mNewParent;
   private VideoView mVideoView;
   // $FF: synthetic field
   final VideoChrome this$0;

   VideoChrome$VideoSubView(VideoChrome var1) {
      this.this$0 = var1;
      this.mVideoView = null;
      this.mNewParent = null;
   }

   private FrameLayout findRootLayout(View var1) {
      try {
         Debugger.methodStart(new Object() {
         });
         FrameLayout var4 = (FrameLayout)var1.getRootView().findViewById(16908290);
         return var4;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new VideoRootViewNotFoundException(var3);
      }
   }

   private String getOpenLogMessage(String var1) {
      return "Opening URL " + var1 + " in external browser.";
   }

   public void closeVideo() {
      try {
         Debugger.methodStart(new Object() {
         });
         Debugger.showLog(new LogMessage("VideoSubView", "closeVideo", 1, DebugCategory.DEBUG));
         if(this.mVideoView != null) {
            this.mVideoView.stopPlayback();
            this.mNewParent.removeView(this.mVideoView);
            this.mVideoView = null;
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new ClosingVideoFailed(var3);
      }
   }

   public void onCompletion(MediaPlayer var1) {
      (new CrashReportTemplate() {
         public Void process() {
            VideoChrome$VideoSubView.this.closeVideo();
            return null;
         }
      }).execute();
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            VideoChrome$VideoSubView.this.closeVideo();
            return Boolean.valueOf(false);
         }
      }).execute()).booleanValue();
   }

   public void startVideo(View var1, String var2, final String var3) {
      try {
         Debugger.methodStart(new Object() {
         });
         this.mVideoView = new VideoView(VideoChrome.access$0(this.this$0));
         this.mNewParent = this.findRootLayout(var1);
         this.mNewParent.addView(this.mVideoView);
         this.mVideoView.setVideoURI(Uri.parse(var2));
         this.mVideoView.setOnCompletionListener(this);
         this.mVideoView.setOnErrorListener(this);
         this.mVideoView.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(final View var1, final int var2, final KeyEvent var3) {
               return ((Boolean)(new CrashReportTemplate() {
                  public Boolean process() {
                     if(var1 == null) {
                        return Boolean.valueOf(false);
                     } else if(var2 == 4 && var3.getAction() == 1) {
                        Debugger.showLog(new LogMessage("VideoTest", "Back key pressed", 1, DebugCategory.DEBUG));
                        VideoChrome$VideoSubView.this.closeVideo();
                        return Boolean.valueOf(true);
                     } else {
                        return Boolean.valueOf(false);
                     }
                  }
               }).execute()).booleanValue();
            }
         });
         this.mVideoView.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(final MediaPlayer var1) {
               (new CrashReportTemplate() {
                  public Void process() {
                     var1.start();
                     return null;
                  }
               }).execute();
            }
         });
         var1.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               (new CrashReportTemplate() {
                  public Void process() {
                     Debugger.showLog(new LogMessage("Banner Client", VideoChrome$VideoSubView.this.getOpenLogMessage(var3), 1, DebugCategory.DEBUG));
                     Intent var1 = new Intent("android.intent.action.VIEW", Uri.parse(var3));
                     VideoChrome.access$0(VideoChrome$VideoSubView.this.this$0).startActivity(var1);
                     return null;
                  }
               }).execute();
            }
         });
         this.mVideoView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View var1, final MotionEvent var2) {
               return ((Boolean)(new CrashReportTemplate() {
                  public Boolean process() {
                     if(var2.getAction() == 1) {
                        Debugger.showLog(new LogMessage("Banner Client", VideoChrome$VideoSubView.this.getOpenLogMessage(var3), 1, DebugCategory.DEBUG));
                        Intent var1 = new Intent("android.intent.action.VIEW", Uri.parse(var3));
                        VideoChrome.access$0(VideoChrome$VideoSubView.this.this$0).startActivity(var1);
                     }

                     return Boolean.valueOf(false);
                  }
               }).execute()).booleanValue();
            }
         });
         this.mVideoView.requestFocus();
      } catch (RuntimeException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new StartingVideoFailedException(var5);
      }
   }
}
