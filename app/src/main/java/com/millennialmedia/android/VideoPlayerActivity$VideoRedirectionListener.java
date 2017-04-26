package com.millennialmedia.android;

import android.net.Uri;
import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.OverlaySettings;
import com.millennialmedia.android.VideoPlayerActivity;
import java.lang.ref.WeakReference;

class VideoPlayerActivity$VideoRedirectionListener extends HttpRedirection$RedirectionListenerImpl {
   WeakReference activityRef;

   public VideoPlayerActivity$VideoRedirectionListener(VideoPlayerActivity var1) {
      if(var1 != null) {
         this.activityRef = new WeakReference(var1);
         if(var1.activity != null) {
            this.creatorAdImplInternalId = var1.activity.creatorAdImplInternalId;
         }
      }

   }

   public OverlaySettings getOverlaySettings() {
      VideoPlayerActivity var1 = (VideoPlayerActivity)this.activityRef.get();
      if(var1 != null && var1.lastOverlayOrientation != null) {
         OverlaySettings var2 = new OverlaySettings();
         var2.orientation = var1.lastOverlayOrientation;
         return var2;
      } else {
         return null;
      }
   }

   public boolean isHandlingMMVideo(Uri var1) {
      final VideoPlayerActivity var2 = (VideoPlayerActivity)this.activityRef.get();
      if(var2 != null) {
         var2.runOnUiThread(new Runnable() {
            public void run() {
               var2.enableButtons();
            }
         });
         if(var1 != null && VideoPlayerActivity.access$000(var2, var1)) {
            var2.processVideoPlayerUri(var1.getHost());
            return true;
         }
      }

      return false;
   }
}
