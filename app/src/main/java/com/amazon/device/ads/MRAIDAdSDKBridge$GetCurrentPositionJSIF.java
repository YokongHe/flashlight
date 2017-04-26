package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$GetCurrentPositionJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "GetCurrentPosition";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$GetCurrentPositionJSIF(MRAIDAdSDKBridge var1) {
      super("GetCurrentPosition");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      return this.bridge.getCurrentPosition();
   }
}
