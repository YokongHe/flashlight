package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

class InlineVideoView$VideoCompletionListener implements OnCompletionListener {
   private WeakReference inlineVideoRef;

   public InlineVideoView$VideoCompletionListener(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public void onCompletion(MediaPlayer var1) {
      InlineVideoView var2 = (InlineVideoView)this.inlineVideoRef.get();
      if(var2 != null) {
         var2.onCompletion(var1);
      }

   }
}
