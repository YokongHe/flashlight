package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$SupportsJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "Supports";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$SupportsJSIF(MRAIDAdSDKBridge var1) {
      super("Supports");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      return this.bridge.getSupportedFeatures();
   }
}
