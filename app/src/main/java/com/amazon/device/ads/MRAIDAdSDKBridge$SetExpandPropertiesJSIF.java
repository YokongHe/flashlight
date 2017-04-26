package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$SetExpandPropertiesJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "SetExpandProperties";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$SetExpandPropertiesJSIF(MRAIDAdSDKBridge var1) {
      super("SetExpandProperties");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.setExpandProperties(JSONUtils.getIntegerFromJSON(var1, "width", 0), JSONUtils.getIntegerFromJSON(var1, "height", 0), JSONUtils.getBooleanFromJSON(var1, "useCustomClose", false));
      return null;
   }
}
