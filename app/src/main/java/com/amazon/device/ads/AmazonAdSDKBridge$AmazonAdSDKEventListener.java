package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AmazonAdSDKBridge;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEvent$SDKEventType;
import com.amazon.device.ads.SDKEventListener;

class AmazonAdSDKBridge$AmazonAdSDKEventListener implements SDKEventListener {
   private final AmazonAdSDKBridge bridge;

   public AmazonAdSDKBridge$AmazonAdSDKEventListener(AmazonAdSDKBridge var1) {
      this.bridge = var1;
   }

   public void onSDKEvent(SDKEvent var1, AdControlAccessor var2) {
      if(var1.getEventType().equals(SDKEvent$SDKEventType.BACK_BUTTON_PRESSED)) {
         AmazonAdSDKBridge.access$000(this.bridge);
      }

   }
}
