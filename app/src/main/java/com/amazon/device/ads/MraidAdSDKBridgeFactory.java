package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.MRAIDAdSDKBridge;

class MraidAdSDKBridgeFactory implements AdSDKBridgeFactory {
   public AdSDKBridge createAdSDKBridge(AdControlAccessor var1) {
      return new MRAIDAdSDKBridge(var1, new JavascriptInteractor());
   }
}
