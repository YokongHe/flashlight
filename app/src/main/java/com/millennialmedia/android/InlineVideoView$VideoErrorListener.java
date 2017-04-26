package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

class InlineVideoView$VideoErrorListener implements OnErrorListener {
   private WeakReference inlineVideoRef;

   public InlineVideoView$VideoErrorListener(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      InlineVideoView var4 = (InlineVideoView)this.inlineVideoRef.get();
      if(var4 != null) {
         var4.onError(var1, var2, var3);
      }

      return true;
   }
}
