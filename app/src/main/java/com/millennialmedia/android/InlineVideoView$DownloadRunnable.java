package com.millennialmedia.android;

import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

class InlineVideoView$DownloadRunnable implements Runnable {
   private WeakReference inlineVideoRef;

   public InlineVideoView$DownloadRunnable(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public void run() {
      InlineVideoView var1 = (InlineVideoView)this.inlineVideoRef.get();
      if(var1 != null) {
         var1.downloadVideo();
      }

   }
}
