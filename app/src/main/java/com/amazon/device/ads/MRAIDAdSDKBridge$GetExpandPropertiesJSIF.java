package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$GetExpandPropertiesJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "GetExpandProperties";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$GetExpandPropertiesJSIF(MRAIDAdSDKBridge var1) {
      super("GetExpandProperties");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      return this.bridge.getExpandProperties();
   }
}
