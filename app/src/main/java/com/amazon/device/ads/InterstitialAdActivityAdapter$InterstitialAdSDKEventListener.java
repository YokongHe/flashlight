package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.InterstitialAdActivityAdapter;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEvent$SDKEventType;
import com.amazon.device.ads.SDKEventListener;

class InterstitialAdActivityAdapter$InterstitialAdSDKEventListener implements SDKEventListener {
   // $FF: synthetic field
   final InterstitialAdActivityAdapter this$0;

   InterstitialAdActivityAdapter$InterstitialAdSDKEventListener(InterstitialAdActivityAdapter var1) {
      this.this$0 = var1;
   }

   public void onSDKEvent(SDKEvent var1, AdControlAccessor var2) {
      if(var1.getEventType().equals(SDKEvent$SDKEventType.CLOSED) && !InterstitialAdActivityAdapter.access$000(this.this$0).isFinishing()) {
         InterstitialAdActivityAdapter.access$102(this.this$0, (AdController)null);
         InterstitialAdActivityAdapter.access$000(this.this$0).finish();
      }

   }
}
