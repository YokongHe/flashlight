package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

class InlineVideoView$VideoPreparedListener implements OnPreparedListener {
   private WeakReference inlineVideoRef;

   public InlineVideoView$VideoPreparedListener(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public void onPrepared(MediaPlayer var1) {
      InlineVideoView var2 = (InlineVideoView)this.inlineVideoRef.get();
      if(var2 != null) {
         var2.onPrepared(var1);
      }

   }
}
