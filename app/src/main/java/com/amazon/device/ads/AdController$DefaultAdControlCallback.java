package com.amazon.device.ads;

import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.Log;

class AdController$DefaultAdControlCallback implements AdControlCallback {
   // $FF: synthetic field
   final AdController this$0;

   AdController$DefaultAdControlCallback(AdController var1) {
      this.this$0 = var1;
   }

   public int adClosing() {
      Log.d("AdController", "DefaultAdControlCallback adClosing called");
      return 1;
   }

   public boolean isAdReady(boolean var1) {
      Log.d("AdController", "DefaultAdControlCallback isAdReady called");
      return this.this$0.getAdState().equals(AdState.READY_TO_LOAD) || this.this$0.getAdState().equals(AdState.SHOWING);
   }

   public void onAdEvent(AdEvent var1) {
      Log.d("AdController", "DefaultAdControlCallback onAdEvent called");
   }

   public void onAdFailed(AdError var1) {
      Log.d("AdController", "DefaultAdControlCallback onAdFailed called");
   }

   public void onAdLoaded(AdProperties var1) {
      Log.d("AdController", "DefaultAdControlCallback onAdLoaded called");
   }

   public void onAdRendered() {
      Log.d("AdController", "DefaultAdControlCallback onAdRendered called");
   }

   public void postAdRendered() {
      Log.d("AdController", "DefaultAdControlCallback postAdRendered called");
   }
}
