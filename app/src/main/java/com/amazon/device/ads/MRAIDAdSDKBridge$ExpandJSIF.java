package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$ExpandJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "Expand";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$ExpandJSIF(MRAIDAdSDKBridge var1) {
      super("Expand");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.expand(JSONUtils.getStringFromJSON(var1, "url", (String)null));
      return null;
   }
}
