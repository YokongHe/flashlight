package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$OpenJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "Open";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$OpenJSIF(MRAIDAdSDKBridge var1) {
      super("Open");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.open(JSONUtils.getStringFromJSON(var1, "url", (String)null));
      return null;
   }
}
