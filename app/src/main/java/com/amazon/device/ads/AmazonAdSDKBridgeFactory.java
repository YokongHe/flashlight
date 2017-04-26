package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AmazonAdSDKBridge;
import com.amazon.device.ads.JavascriptInteractor;

public class AmazonAdSDKBridgeFactory implements AdSDKBridgeFactory {
   public AdSDKBridge createAdSDKBridge(AdControlAccessor var1) {
      return new AmazonAdSDKBridge(var1, new JavascriptInteractor());
   }
}
