package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;
import com.millennialmedia.android.VideoPlayerActivity;
import java.lang.ref.WeakReference;

class VideoPlayerActivity$TransparentHandler extends Handler {
   private WeakReference activityRef;

   public VideoPlayerActivity$TransparentHandler(VideoPlayerActivity var1) {
      this.activityRef = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      VideoPlayerActivity var2 = (VideoPlayerActivity)this.activityRef.get();
      if(var2 != null) {
         var2.handleTransparentMessage(var1);
      }

   }
}
