package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$GetResizePropertiesJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "GetResizeProperties";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$GetResizePropertiesJSIF(MRAIDAdSDKBridge var1) {
      super("GetResizeProperties");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      return this.bridge.getResizeProperties();
   }
}
