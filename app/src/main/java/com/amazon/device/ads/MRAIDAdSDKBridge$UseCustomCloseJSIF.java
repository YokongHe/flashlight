package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$UseCustomCloseJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "UseCustomClose";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$UseCustomCloseJSIF(MRAIDAdSDKBridge var1) {
      super("UseCustomClose");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.setUseCustomClose(JSONUtils.getBooleanFromJSON(var1, "useCustomClose", false));
      return null;
   }
}
