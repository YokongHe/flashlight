package com.amazon.device.ads;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.amazon.device.ads.AdVideoPlayer$AdVideoPlayerListener;
import com.amazon.device.ads.Log;

final class AdVideoPlayer implements OnCompletionListener, OnErrorListener {
   private static String LOG_TAG = AdVideoPlayer.class.getSimpleName();
   private String contentUrl_;
   private Context context_;
   private LayoutParams layoutParams_ = null;
   private AdVideoPlayer$AdVideoPlayerListener listener_;
   private boolean released_ = false;
   private VideoView videoView_ = null;
   private ViewGroup viewGroup_ = null;

   public AdVideoPlayer(Context var1) {
      this.context_ = var1;
   }

   private void displayPlayerControls() {
      Log.d(LOG_TAG, "in displayPlayerControls");
      MediaController var1 = new MediaController(this.context_);
      this.videoView_.setMediaController(var1);
      var1.setAnchorView(this.videoView_);
      var1.requestFocus();
   }

   private void initializeVideoView() {
      VideoView var1 = new VideoView(this.context_);
      var1.setOnCompletionListener(this);
      var1.setOnErrorListener(this);
      var1.setLayoutParams(this.layoutParams_);
      this.videoView_ = var1;
      this.viewGroup_.addView(this.videoView_);
   }

   private void loadPlayerContent() {
      Uri var1 = Uri.parse(this.contentUrl_);
      this.videoView_.setVideoURI(var1);
   }

   private void removePlayerFromParent() {
      Log.d(LOG_TAG, "in removePlayerFromParent");
      this.viewGroup_.removeView(this.videoView_);
   }

   public final void onCompletion(MediaPlayer var1) {
      this.releasePlayer();
      if(this.listener_ != null) {
         this.listener_.onComplete();
      }

   }

   public final boolean onError(MediaPlayer var1, int var2, int var3) {
      this.removePlayerFromParent();
      if(this.listener_ != null) {
         this.listener_.onError();
      }

      return false;
   }

   public final void playVideo() {
      Log.d(LOG_TAG, "in playVideo");
      this.initializeVideoView();
      this.loadPlayerContent();
      this.startPlaying();
   }

   public final void releasePlayer() {
      Log.d(LOG_TAG, "in releasePlayer");
      if(!this.released_) {
         this.released_ = true;
         this.videoView_.stopPlayback();
         this.removePlayerFromParent();
      }
   }

   public final void setLayoutParams(LayoutParams var1) {
      this.layoutParams_ = var1;
   }

   public final void setListener(AdVideoPlayer$AdVideoPlayerListener var1) {
      this.listener_ = var1;
   }

   public final void setPlayData(String var1) {
      this.released_ = false;
      this.contentUrl_ = var1;
   }

   public final void setViewGroup(ViewGroup var1) {
      this.viewGroup_ = var1;
   }

   public final void startPlaying() {
      Log.d(LOG_TAG, "in startPlaying");
      this.displayPlayerControls();
      this.videoView_.start();
   }
}
