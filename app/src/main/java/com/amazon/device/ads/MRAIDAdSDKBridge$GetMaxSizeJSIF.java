package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$GetMaxSizeJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "GetMaxSize";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$GetMaxSizeJSIF(MRAIDAdSDKBridge var1) {
      super("GetMaxSize");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      return this.bridge.getMaxSize();
   }
}
