package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$GetScreenSizeJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "GetScreenSize";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$GetScreenSizeJSIF(MRAIDAdSDKBridge var1) {
      super("GetScreenSize");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      return this.bridge.getScreenSize();
   }
}
