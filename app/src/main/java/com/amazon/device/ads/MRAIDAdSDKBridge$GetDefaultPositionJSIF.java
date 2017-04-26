package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$GetDefaultPositionJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "GetDefaultPosition";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$GetDefaultPositionJSIF(MRAIDAdSDKBridge var1) {
      super("GetDefaultPosition");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      return this.bridge.getDefaultPosition();
   }
}
