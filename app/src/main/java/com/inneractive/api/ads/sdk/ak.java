package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.widget.VideoView;
import com.inneractive.api.ads.sdk.ak$a;

final class ak extends VideoView {
   private String a;

   public ak(Context var1, Intent var2, final ak$a var3) {
      super(var1);
      this.setOnCompletionListener(new OnCompletionListener() {
         // $FF: synthetic field
         private ak$a a = var3;

         public final void onCompletion(MediaPlayer var1) {
            if(this.a != null) {
               this.a.onVideoCompleted(true);
            }

         }
      });
      this.setOnErrorListener(new OnErrorListener() {
         // $FF: synthetic field
         private ak$a a = var3;

         public final boolean onError(MediaPlayer var1, int var2, int var3) {
            if(this.a != null) {
               this.a.onVideoError(false);
            }

            return false;
         }
      });
      this.a = var2.getStringExtra("video_url");
      this.setVideoPath(this.a);
   }
}
