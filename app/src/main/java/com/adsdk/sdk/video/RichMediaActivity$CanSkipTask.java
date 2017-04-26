package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.RichMediaActivity;
import java.util.TimerTask;

class RichMediaActivity$CanSkipTask extends TimerTask {
   private final RichMediaActivity mActivity;
   // $FF: synthetic field
   final RichMediaActivity this$0;

   public RichMediaActivity$CanSkipTask(RichMediaActivity var1, RichMediaActivity var2) {
      this.this$0 = var1;
      this.mActivity = var2;
   }

   public void run() {
      Log.v("###########TRACKING CAN CLOSE INTERSTITIAL");
      RichMediaActivity.access$13(this.mActivity, true);
      if(RichMediaActivity.access$14(this.mActivity) != null) {
         this.mActivity.runOnUiThread(new Runnable() {
            public void run() {
               RichMediaActivity.access$14(RichMediaActivity$CanSkipTask.this.mActivity).setVisibility(0);
            }
         });
      }

   }
}
