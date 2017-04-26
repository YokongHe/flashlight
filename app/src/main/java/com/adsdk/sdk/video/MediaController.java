package com.adsdk.sdk.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController.MediaPlayerControl;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.AutoResizeTextView;
import com.adsdk.sdk.video.MediaController$OnPauseListener;
import com.adsdk.sdk.video.MediaController$OnReplayListener;
import com.adsdk.sdk.video.MediaController$OnUnpauseListener;
import com.adsdk.sdk.video.MediaController$ResourceHandler;
import com.adsdk.sdk.video.VideoData;
import java.util.Formatter;
import java.util.Locale;

@SuppressLint({"ViewConstructor"})
public class MediaController extends FrameLayout {
   private static final int SHOW_PROGRESS = 2;
   private Context mContext;
   StringBuilder mFormatBuilder;
   Formatter mFormatter;
   private MediaController$ResourceHandler mHandler = new MediaController$ResourceHandler(this);
   private TextView mLeftTime;
   private MediaController$OnPauseListener mOnPauseListener;
   private MediaController$OnReplayListener mOnReplayListener;
   private MediaController$OnUnpauseListener mOnUnpauseListener;
   private MediaPlayerControl mPlayer;
   private boolean mShowing;
   private VideoData mVideoData;

   public MediaController(Context var1, VideoData var2) {
      super(var1);
      this.setVisibility(8);
      this.mShowing = true;
      this.mContext = var1;
      this.mVideoData = var2;
      if(this.mVideoData == null) {
         throw new IllegalArgumentException("Video info cannot be null");
      } else {
         this.mFormatBuilder = new StringBuilder();
         this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
         this.mLeftTime = new AutoResizeTextView(this.mContext);
         this.mLeftTime.setGravity(17);
         this.mLeftTime.setTextSize(14.0F);
         this.mLeftTime.setTextColor(-1);
         int var3 = (int)TypedValue.applyDimension(1, 4.0F, this.getResources().getDisplayMetrics());
         this.mLeftTime.setPadding(var3, 0, var3, 0);
         GradientDrawable var4 = new GradientDrawable();
         var4.setCornerRadius((float)((int)TypedValue.applyDimension(1, 6.0F, this.getResources().getDisplayMetrics())));
         var4.setColor(-16777216);
         this.setBackgroundDrawable(var4);
         this.addView(this.mLeftTime, new LayoutParams(-1, -1));
         Log.d("MediaController created");
      }
   }

   // $FF: synthetic method
   static void access$0(MediaController var0, Message var1) {
      var0.handleMessage(var1);
   }

   private void doPauseResume() {
      if(this.mPlayer != null) {
         if(this.mPlayer.isPlaying()) {
            this.mPlayer.pause();
            if(this.mOnPauseListener != null) {
               this.mOnPauseListener.onVideoPause();
               return;
            }
         } else {
            this.mPlayer.start();
            if(this.mOnUnpauseListener != null) {
               this.mOnUnpauseListener.onVideoUnpause();
               return;
            }
         }
      }

   }

   private void handleMessage(Message var1) {
      switch(var1.what) {
      case 2:
         this.refreshProgress();
         return;
      default:
      }
   }

   private void refreshProgress() {
      if(this.mShowing) {
         int var1 = this.setProgress();
         if(this.mPlayer != null && this.mPlayer.isPlaying()) {
            this.mHandler.removeMessages(2);
            Message var2 = this.mHandler.obtainMessage(2);
            this.mHandler.sendMessageDelayed(var2, (long)(1000 - var1 % 1000));
         }
      }

   }

   private int setProgress() {
      int var1;
      if(this.mPlayer == null) {
         var1 = 0;
      } else {
         int var2 = this.mPlayer.getCurrentPosition();
         int var3 = this.mPlayer.getDuration();
         var1 = var2;
         if(this.mLeftTime != null) {
            this.mLeftTime.setText("-" + this.stringForTime(var3 - var2));
            return var2;
         }
      }

      return var1;
   }

   private String stringForTime(int var1) {
      int var3 = var1 / 1000;
      var1 = var3 % 60;
      int var2 = var3 / 60 % 60;
      var3 /= 3600;
      this.mFormatBuilder.setLength(0);
      return var3 > 0?this.mFormatter.format("%d:%02d:%02d", new Object[]{Integer.valueOf(var3), Integer.valueOf(var2), Integer.valueOf(var1)}).toString():(var2 > 0?this.mFormatter.format("%02d:%02d", new Object[]{Integer.valueOf(var2), Integer.valueOf(var1)}).toString():this.mFormatter.format("0:%02d", new Object[]{Integer.valueOf(var1)}).toString());
   }

   public void hide() {
      Log.d("HIDE");
      if(this.mShowing) {
         Log.d("Hide change visibility");
         this.mHandler.removeMessages(2);
         this.setVisibility(8);
         this.mShowing = false;
      }

   }

   public boolean isShowing() {
      return this.mShowing;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 != 4 && var1 != 24 && var1 != 25 && var1 != 82 && var1 != 5 && var1 != 6) {
         if(var1 == 79 || var1 == 85) {
            this.doPauseResume();
            return true;
         }

         if(var1 == 86 && this.mPlayer != null && this.mPlayer.isPlaying()) {
            this.mPlayer.pause();
            if(this.mOnPauseListener != null) {
               this.mOnPauseListener.onVideoPause();
            }
         }
      }

      return super.onKeyDown(var1, var2);
   }

   public void onPause() {
      this.show();
   }

   public void onStart() {
      this.refreshProgress();
   }

   public void replay() {
      if(this.mPlayer != null) {
         this.mPlayer.seekTo(0);
         this.mPlayer.start();
      }

      this.refreshProgress();
      if(this.mOnReplayListener != null) {
         this.mOnReplayListener.onVideoReplay();
      }

   }

   public void setMediaPlayer(MediaPlayerControl var1) {
      this.mPlayer = var1;
   }

   public void setOnPauseListener(MediaController$OnPauseListener var1) {
      this.mOnPauseListener = var1;
   }

   public void setOnReplayListener(MediaController$OnReplayListener var1) {
      this.mOnReplayListener = var1;
   }

   public void setOnUnpauseListener(MediaController$OnUnpauseListener var1) {
      this.mOnUnpauseListener = var1;
   }

   public void show() {
      if(!this.mShowing) {
         this.setVisibility(0);
         this.mShowing = true;
         Log.d("Change Visibility");
      }

      this.refreshProgress();
   }
}
