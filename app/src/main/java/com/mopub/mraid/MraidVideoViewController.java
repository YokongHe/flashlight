package com.mopub.mraid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController$BaseVideoViewControllerListener;

public class MraidVideoViewController extends BaseVideoViewController {
   private static final float CLOSE_BUTTON_PADDING = 8.0F;
   private static final float CLOSE_BUTTON_SIZE = 50.0F;
   private int mButtonPadding;
   private int mButtonSize;
   private ImageButton mCloseButton;
   private final VideoView mVideoView;

   public MraidVideoViewController(Context var1, Bundle var2, BaseVideoViewController$BaseVideoViewControllerListener var3) {
      super(var1, (Long)null, var3);
      this.mVideoView = new VideoView(var1);
      this.mVideoView.setOnCompletionListener(new OnCompletionListener() {
         public void onCompletion(MediaPlayer var1) {
            MraidVideoViewController.this.mCloseButton.setVisibility(0);
            MraidVideoViewController.this.videoCompleted(true);
         }
      });
      this.mVideoView.setOnErrorListener(new OnErrorListener() {
         public boolean onError(MediaPlayer var1, int var2, int var3) {
            MraidVideoViewController.this.mCloseButton.setVisibility(0);
            MraidVideoViewController.this.videoError(false);
            return false;
         }
      });
      this.mVideoView.setVideoPath(var2.getString("video_url"));
   }

   private void createInterstitialCloseButton() {
      this.mCloseButton = new ImageButton(this.getContext());
      StateListDrawable var1 = new StateListDrawable();
      Drawable var2 = Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(this.getContext());
      var1.addState(new int[]{-16842919}, var2);
      var2 = Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(this.getContext());
      var1.addState(new int[]{16842919}, var2);
      this.mCloseButton.setImageDrawable(var1);
      this.mCloseButton.setBackgroundDrawable((Drawable)null);
      this.mCloseButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MraidVideoViewController.this.getBaseVideoViewControllerListener().onFinish();
         }
      });
      LayoutParams var3 = new LayoutParams(this.mButtonSize, this.mButtonSize);
      var3.addRule(11);
      var3.setMargins(this.mButtonPadding, 0, this.mButtonPadding, 0);
      this.getLayout().addView(this.mCloseButton, var3);
   }

   protected VideoView getVideoView() {
      return this.mVideoView;
   }

   protected void onCreate() {
      super.onCreate();
      this.mButtonSize = Dips.asIntPixels(50.0F, this.getContext());
      this.mButtonPadding = Dips.asIntPixels(8.0F, this.getContext());
      this.createInterstitialCloseButton();
      this.mCloseButton.setVisibility(8);
      this.mVideoView.start();
   }

   protected void onDestroy() {
   }

   protected void onPause() {
   }

   protected void onResume() {
   }
}
