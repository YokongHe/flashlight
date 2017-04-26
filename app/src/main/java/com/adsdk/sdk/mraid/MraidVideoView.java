package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.adsdk.sdk.mraid.BaseVideoView;
import com.adsdk.sdk.mraid.BaseVideoView$BaseVideoViewListener;

class MraidVideoView extends BaseVideoView {
   public MraidVideoView(Context var1, Intent var2, final BaseVideoView$BaseVideoViewListener var3) {
      super(var1);
      this.setOnCompletionListener(new OnCompletionListener() {
         public void onCompletion(MediaPlayer var1) {
            if(var3 != null) {
               var3.videoCompleted(true);
            }

         }
      });
      this.setOnErrorListener(new OnErrorListener() {
         public boolean onError(MediaPlayer var1, int var2, int var3x) {
            if(var3 != null) {
               var3.videoError(false);
            }

            return false;
         }
      });
      this.setVideoPath(var2.getStringExtra("video_url"));
   }
}
