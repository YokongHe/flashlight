package com.adsdk.sdk.video;

import android.os.Handler;
import android.os.Message;
import com.adsdk.sdk.video.RichMediaActivity;
import java.lang.ref.WeakReference;

class RichMediaActivity$ResourceHandler extends Handler {
   WeakReference richMediaActivity;

   public RichMediaActivity$ResourceHandler(RichMediaActivity var1) {
      this.richMediaActivity = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      RichMediaActivity var2 = (RichMediaActivity)this.richMediaActivity.get();
      if(var2 != null) {
         var2.handleMessage(var1);
      }

   }
}
