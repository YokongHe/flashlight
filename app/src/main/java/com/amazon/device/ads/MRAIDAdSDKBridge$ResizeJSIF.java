package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$ResizeJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "Resize";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$ResizeJSIF(MRAIDAdSDKBridge var1) {
      super("Resize");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.resize();
      return null;
   }
}
