package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$SetResizePropertiesJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "SetResizeProperties";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$SetResizePropertiesJSIF(MRAIDAdSDKBridge var1) {
      super("SetResizeProperties");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.setResizeProperties(JSONUtils.getIntegerFromJSON(var1, "width", 0), JSONUtils.getIntegerFromJSON(var1, "height", 0), JSONUtils.getIntegerFromJSON(var1, "offsetX", 0), JSONUtils.getIntegerFromJSON(var1, "offsetY", 0), JSONUtils.getStringFromJSON(var1, "customClosePosition", (String)null), JSONUtils.getBooleanFromJSON(var1, "allowOffscreen", false));
      return null;
   }
}
