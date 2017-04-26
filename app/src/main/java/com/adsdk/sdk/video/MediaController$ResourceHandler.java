package com.adsdk.sdk.video;

import android.os.Handler;
import android.os.Message;
import com.adsdk.sdk.video.MediaController;
import java.lang.ref.WeakReference;

class MediaController$ResourceHandler extends Handler {
   private final WeakReference mController;

   public MediaController$ResourceHandler(MediaController var1) {
      this.mController = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      MediaController var2 = (MediaController)this.mController.get();
      if(var2 != null) {
         MediaController.access$0(var2, var1);
      }

   }
}
