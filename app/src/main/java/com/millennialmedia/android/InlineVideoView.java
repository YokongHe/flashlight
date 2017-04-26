package com.millennialmedia.android;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.AdViewOverlayView$SavedState;
import com.millennialmedia.android.InlineVideoView$DownloadRunnable;
import com.millennialmedia.android.InlineVideoView$InlineParams;
import com.millennialmedia.android.InlineVideoView$MediaController;
import com.millennialmedia.android.InlineVideoView$TransparentFix;
import com.millennialmedia.android.InlineVideoView$TransparentHandler;
import com.millennialmedia.android.InlineVideoView$VideoCompletionListener;
import com.millennialmedia.android.InlineVideoView$VideoErrorListener;
import com.millennialmedia.android.InlineVideoView$VideoHandler;
import com.millennialmedia.android.InlineVideoView$VideoPreparedListener;
import com.millennialmedia.android.InlineVideoView$VideoTouchListener;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMLayout;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.Utils$ThreadUtils;
import com.millennialmedia.android.VideoAd;
import java.io.Serializable;
import java.lang.ref.WeakReference;

class InlineVideoView extends VideoView implements Serializable {
   private static final String ANCHOR_IN_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=";
   private static final String ANCHOR_OUT_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC";
   private static final String TAG = "InlineVideoView";
   static final int TIME_TO_UPDATE_SEEK_JS = 500;
   private int duration;
   InlineVideoView$InlineParams inlineParams;
   InlineVideoView$MediaController mediaController;
   WeakReference mmLayoutRef;
   InlineVideoView$TransparentFix transFix;
   InlineVideoView$TransparentHandler transparentHandler = new InlineVideoView$TransparentHandler(this);
   Handler videoHandler;

   public InlineVideoView(MMLayout var1) {
      super(var1.getContext());
      this.setId(8832429);
      this.setFocusable(true);
      MMAdImplController.destroyOtherInlineVideo(var1.getContext());
      this.mmLayoutRef = new WeakReference(var1);
   }

   private OnCompletionListener createOnCompletionListener() {
      return new InlineVideoView$VideoCompletionListener(this);
   }

   private OnErrorListener createOnErrorListener() {
      return new InlineVideoView$VideoErrorListener(this);
   }

   private OnPreparedListener createOnPreparedListener() {
      return new InlineVideoView$VideoPreparedListener(this);
   }

   private OnTouchListener createOnTouchListener() {
      return new InlineVideoView$VideoTouchListener(this);
   }

   private Handler createVideoHandler() {
      return new InlineVideoView$VideoHandler(this);
   }

   private void downloadCacheVideo() {
      Utils$ThreadUtils.execute(new InlineVideoView$DownloadRunnable(this));
   }

   private Uri getVideoUri() {
      if(this.hasCachedVideo() && !this.inlineParams.isPlayingStreaming) {
         this.inlineParams.isPlayingStreaming = false;
         return VideoAd.getVideoUri(this.getContext(), this.inlineParams.cachedVideoID);
      } else if(!TextUtils.isEmpty(this.inlineParams.streamVideoURI)) {
         this.inlineParams.isPlayingStreaming = true;
         return Uri.parse(this.inlineParams.streamVideoURI);
      } else {
         return null;
      }
   }

   private boolean hasCachedVideo() {
      return !TextUtils.isEmpty(this.inlineParams.cachedVideoID) && VideoAd.hasVideoFile(this.getContext(), this.inlineParams.cachedVideoID);
   }

   private void initInternalInlineVideo() {
      this.videoHandler = this.createVideoHandler();
      this.setVideoURI(this.getVideoUri());
      this.setBackgroundColor(-16777216);
      this.setClickable(true);
      this.setOnErrorListener(this.createOnErrorListener());
      this.setOnCompletionListener(this.createOnCompletionListener());
      this.setOnPreparedListener(this.createOnPreparedListener());
      this.setOnTouchListener(this.createOnTouchListener());
      if(this.inlineParams.autoPlay) {
         this.seekTo(this.inlineParams.currentPosition);
         this.startInternal();
         if(this.videoHandler != null && !this.videoHandler.hasMessages(2)) {
            this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
         }
      }

      if(this.inlineParams.showControls) {
         this.mediaController = new InlineVideoView$MediaController(this);
         this.setMediaController(this.mediaController);
         this.mediaController.show();
      }

      MMLog.e("InlineVideoView", "Finished inserting inlineVideo player");
   }

   private void makeTransparent() {
      if(!this.transparentHandler.hasMessages(4)) {
         this.transparentHandler.sendEmptyMessage(4);
      }

   }

   private void removeFromParent() {
      ViewGroup var1 = (ViewGroup)this.getParent();
      if(var1 != null) {
         var1.removeView(this);
      }

   }

   private void removeKeyboardFocusViewJira1642() {
      ((InputMethodManager)this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.getWindowToken(), 0);
      this.requestFocus();
   }

   private void resumeInternal(boolean var1) {
      if(!this.inlineParams.isCompleted) {
         this.seekTo(this.inlineParams.currentPosition);
         if(var1 || this.inlineParams.autoPlay) {
            this.startInternal();
            if(this.videoHandler != null && !this.videoHandler.hasMessages(2)) {
               this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
            }
         }
      }

   }

   private void setInlineVideoParams(InlineVideoView$InlineParams var1) {
      this.inlineParams = var1;
   }

   boolean adjustVideo(InlineVideoView$InlineParams param1) {
      // $FF: Couldn't be decompiled
   }

   void downloadVideo() {
      VideoAd.downloadVideoFile(this.getContext(), this.inlineParams.cachedVideoURI, this.inlineParams.cachedVideoID);
   }

   public LayoutParams getCustomLayoutParams() {
      if(this.inlineParams.goingFullScreen) {
         return new LayoutParams(-1, -1);
      } else {
         LayoutParams var1 = new LayoutParams((int)(this.inlineParams.scaleFactor * (float)this.inlineParams.width), (int)(this.inlineParams.scaleFactor * (float)this.inlineParams.height));
         var1.topMargin = (int)(this.inlineParams.scaleFactor * (float)this.inlineParams.y);
         var1.leftMargin = (int)(this.inlineParams.scaleFactor * (float)this.inlineParams.x);
         MMLog.d("InlineVideoView", "lp height = " + var1.height);
         return var1;
      }
   }

   String getGsonState() {
      return (new com.millennialmedia.a.a.e()).a((Object)this.inlineParams);
   }

   void handleTransparentMessage(Message var1) {
      switch(var1.what) {
      case 4:
         if(this.isPlaying() && this.getCurrentPosition() > 0) {
            this.transparentHandler.sendEmptyMessageDelayed(5, 100L);
            return;
         }

         this.transparentHandler.sendEmptyMessageDelayed(4, 50L);
         return;
      case 5:
         if(this.isPlaying() && this.getCurrentPosition() > 0) {
            this.setBackgroundColor(0);
            if(this.mmLayoutRef != null && this.mmLayoutRef.get() != null) {
               ((MMLayout)this.mmLayoutRef.get()).removeBlackView();
               return;
            }
         }
      default:
      }
   }

   void initInlineVideo(InlineVideoView$InlineParams var1) {
      synchronized(this){}

      try {
         this.inlineParams = var1;
         if(!TextUtils.isEmpty(this.inlineParams.cachedVideoURI)) {
            this.downloadCacheVideo();
         }

         if(this.isValid()) {
            this.initInternalInlineVideo();
         } else {
            MMLog.e("InlineVideoView", "The videoURI attribute was not specified on the video marker div.");
         }
      } finally {
         ;
      }

   }

   boolean isPlayingStreaming() {
      return this.inlineParams != null && this.inlineParams.isPlayingStreaming;
   }

   boolean isValid() {
      return !TextUtils.isEmpty(this.inlineParams.streamVideoURI) || this.hasCachedVideo();
   }

   void onCompletion(MediaPlayer var1) {
      if(this.videoHandler != null && this.videoHandler.hasMessages(2)) {
         this.videoHandler.removeMessages(2);
      }

      this.inlineParams.isCompleted = true;
      this.inlineParams.currentPosition = this.duration;
      if(this.inlineParams.currentPosition == -1) {
         this.inlineParams.currentPosition = 0;
      }

      this.updateVideoSeekTimeFinal();
   }

   boolean onError(MediaPlayer var1, int var2, int var3) {
      if(this.videoHandler != null && this.videoHandler.hasMessages(2)) {
         this.videoHandler.removeMessages(2);
      }

      MMLayout var4 = (MMLayout)this.mmLayoutRef.get();
      if(var4 == null) {
         MMLog.w("InlineVideoView", "MMLayout weak reference broken");
         return false;
      } else {
         var4.loadUrl("javascript:MMJS.setError(" + String.format("Error while playing, %d - %d", new Object[]{Integer.valueOf(var2), Integer.valueOf(var3)}) + ");");
         return true;
      }
   }

   void onMediaControllerClick(View var1) {
      MMLayout var3 = (MMLayout)this.mmLayoutRef.get();
      if(var3 != null) {
         this.setBackgroundColor(-16777216);
         if(this.isPlaying()) {
            this.inlineParams.currentPosition = this.getCurrentPosition();
         }

         boolean var2;
         Activity var4;
         if(this.inlineParams.goingFullScreen) {
            this.inlineParams.goingFullScreen = false;
            if(this.inlineParams.originalOrientation != 1) {
               var2 = this.isPlaying();
               this.stopPlayback();
               var3.repositionVideoLayout();
               this.resumeInternal(var2);
               return;
            }

            var4 = (Activity)this.getContext();
            if(var4 != null) {
               var4.setRequestedOrientation(1);
            }
         } else {
            this.inlineParams.originalOrientation = this.getContext().getResources().getConfiguration().orientation;
            this.inlineParams.goingFullScreen = true;
            if(this.inlineParams.originalOrientation == 2) {
               var2 = this.isPlaying();
               this.stopPlayback();
               var3.fullScreenVideoLayout();
               this.resumeInternal(var2);
               return;
            }

            var4 = (Activity)this.getContext();
            if(var4 != null) {
               var4.setRequestedOrientation(0);
               return;
            }
         }
      }

   }

   void onPrepared(MediaPlayer var1) {
      if(this.inlineParams.autoPlay) {
         this.makeTransparent();
      }

      this.seekTo(this.inlineParams.currentPosition);
      if(!this.inlineParams.autoPlay && this.inlineParams.isInitialPlayBack) {
         this.inlineParams.isInitialPlayBack = false;
      } else {
         this.getHeight();
      }

      this.duration = this.getDuration();
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(!(var1 instanceof AdViewOverlayView$SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         AdViewOverlayView$SavedState var2 = (AdViewOverlayView$SavedState)var1;
         super.onRestoreInstanceState(var2.getSuperState());
         this.inlineParams.inflateFromGson(var2.gson);
      }
   }

   public Parcelable onSaveInstanceState() {
      AdViewOverlayView$SavedState var1 = new AdViewOverlayView$SavedState(super.onSaveInstanceState());
      if(this.isPlaying()) {
         this.inlineParams.currentPosition = this.getCurrentPosition();
      }

      var1.gson = this.getGsonState();
      return var1;
   }

   boolean onTouch(View var1, MotionEvent var2) {
      if(var2.getAction() == 1) {
         MMLayout var3 = (MMLayout)this.mmLayoutRef.get();
         if(var3 == null) {
            MMLog.w("InlineVideoView", "MMLayout weak reference broken");
            return false;
         }

         if(!TextUtils.isEmpty(this.inlineParams.touchCallBack)) {
            var3.loadUrl(String.format("javascript:" + this.inlineParams.touchCallBack + "(%f,%f)", new Object[]{Float.valueOf(var2.getX()), Float.valueOf(var2.getY())}));
         }

         if(this.inlineParams.showControls && this.mediaController != null && !this.mediaController.isShowing()) {
            this.mediaController.show();
            return true;
         }
      }

      return true;
   }

   void pauseVideo() {
      if(this.videoHandler != null && this.videoHandler.hasMessages(2)) {
         this.videoHandler.removeMessages(2);
      }

      if(this.isPlaying()) {
         this.inlineParams.currentPosition = this.getCurrentPosition();
         this.pause();
      }

   }

   void playVideo() {
      if(!this.isPlaying()) {
         if(this.inlineParams.isStopped && this.getVideoUri() != null) {
            this.inlineParams.isStopped = false;
            this.setVideoURI(this.getVideoUri());
            this.seekTo(0);
         } else if(this.inlineParams.isCompleted) {
            this.seekTo(0);
         }

         this.inlineParams.isCompleted = false;
         this.startInternal();
      }

      if(this.videoHandler != null && !this.videoHandler.hasMessages(2)) {
         this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
      }

   }

   void removeVideo() {
      if(this.videoHandler != null && this.videoHandler.hasMessages(2)) {
         this.videoHandler.removeMessages(2);
      }

      if(this.isPlaying()) {
         this.stopPlayback();
      }

      this.setOnCompletionListener((OnCompletionListener)null);
      this.setOnErrorListener((OnErrorListener)null);
      this.setOnPreparedListener((OnPreparedListener)null);
      this.setOnTouchListener((OnTouchListener)null);
      this.removeFromParent();
   }

   void resumeVideo() {
      if(!this.isPlaying() && !this.inlineParams.isCompleted) {
         this.startInternal();
         if(this.videoHandler != null && !this.videoHandler.hasMessages(2)) {
            this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
         }
      }

   }

   void setAdjustVideoParams(InlineVideoView$InlineParams var1) {
      this.inlineParams.x = var1.x;
      this.inlineParams.y = var1.y;
      this.inlineParams.width = var1.width;
      this.inlineParams.height = var1.height;
   }

   void setVideoSource(String var1) {
      if(this.isPlaying()) {
         this.stopPlayback();
      }

      this.inlineParams.currentPosition = 0;
      this.setBackgroundColor(-16777216);
      this.setVideoURI(Uri.parse(var1));
      this.startInternal();
   }

   public void start() {
      this.makeTransparent();
      this.removeKeyboardFocusViewJira1642();
      super.start();
   }

   public void startInternal() {
      if(((PowerManager)this.getContext().getSystemService("power")).isScreenOn()) {
         this.start();
      }

   }

   public void stopPlayback() {
      if(this.videoHandler != null && this.videoHandler.hasMessages(2)) {
         this.videoHandler.removeMessages(2);
      }

      if(this.isPlaying()) {
         this.inlineParams.currentPosition = 0;
      }

      super.stopPlayback();
   }

   void stopVideo() {
      if(this.videoHandler != null && this.videoHandler.hasMessages(2)) {
         this.videoHandler.removeMessages(2);
      }

      if(this.isPlaying()) {
         this.inlineParams.isStopped = true;
         this.inlineParams.currentPosition = 0;
         if(this.mmLayoutRef != null && this.mmLayoutRef.get() != null) {
            ((MMLayout)this.mmLayoutRef.get()).addBlackView();
         }

         this.stopPlayback();
      }

   }

   public String toString() {
      return this.inlineParams.toString();
   }

   void updateVideoSeekTime() {
      int var1 = this.getCurrentPosition();
      if(var1 >= 0) {
         MMLog.d("InlineVideoView", "Time is " + var1);
         this.updateVideoSeekTime(Math.floor((double)((float)var1 / 1000.0F)));
      }

   }

   void updateVideoSeekTime(double var1) {
      MMLayout var3 = (MMLayout)this.mmLayoutRef.get();
      if(var3 == null) {
         MMLog.w("InlineVideoView", "MMLayout weak reference broken");
      }

      var3.loadUrl("javascript:MMJS.inlineVideo.updateVideoSeekTime(" + var1 + ");");
   }

   void updateVideoSeekTimeFinal() {
      if(this.duration > 0) {
         MMLog.d("InlineVideoView", "Time is " + this.duration);
         this.updateVideoSeekTime(Math.ceil((double)((float)this.duration / 1000.0F)));
      }

   }
}
