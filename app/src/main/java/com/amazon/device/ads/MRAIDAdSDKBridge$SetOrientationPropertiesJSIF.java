package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$SetOrientationPropertiesJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "SetOrientationProperties";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$SetOrientationPropertiesJSIF(MRAIDAdSDKBridge var1) {
      super("SetOrientationProperties");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.setOrientationProperties(JSONUtils.getBooleanFromJSON(var1, "allowOrientationChange", false), JSONUtils.getStringFromJSON(var1, "forceOrientation", (String)null));
      return null;
   }
}
