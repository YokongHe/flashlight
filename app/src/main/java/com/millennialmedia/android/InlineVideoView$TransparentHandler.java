package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;
import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

class InlineVideoView$TransparentHandler extends Handler {
   private WeakReference inlineVideoRef;

   public InlineVideoView$TransparentHandler(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      InlineVideoView var2 = (InlineVideoView)this.inlineVideoRef.get();
      if(var2 != null) {
         var2.handleTransparentMessage(var1);
      }

   }
}
