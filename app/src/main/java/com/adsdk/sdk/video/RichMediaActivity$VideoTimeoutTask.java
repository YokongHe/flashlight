package com.adsdk.sdk.video;

import android.app.Activity;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.RichMediaActivity;
import java.util.TimerTask;

class RichMediaActivity$VideoTimeoutTask extends TimerTask {
   private final Activity mActivity;
   // $FF: synthetic field
   final RichMediaActivity this$0;

   public RichMediaActivity$VideoTimeoutTask(RichMediaActivity var1, Activity var2) {
      this.this$0 = var1;
      this.mActivity = var2;
   }

   public void run() {
      Log.v("###########TRACKING VIDEO TIMEOUT");
      this.mActivity.runOnUiThread(new Runnable() {
         public void run() {
            RichMediaActivity$VideoTimeoutTask.this.mActivity.finish();
         }
      });
   }
}
