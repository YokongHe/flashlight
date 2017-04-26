package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;
import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

class InlineVideoView$VideoHandler extends Handler {
   private WeakReference inlineVideoRef;

   public InlineVideoView$VideoHandler(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      switch(var1.what) {
      case 2:
         InlineVideoView var2 = (InlineVideoView)this.inlineVideoRef.get();
         if(var2 != null) {
            if(var2.isPlaying()) {
               var2.updateVideoSeekTime();
            }

            var2.videoHandler.sendMessageDelayed(Message.obtain(var2.videoHandler, 2), 500L);
            return;
         }
      default:
      }
   }
}
