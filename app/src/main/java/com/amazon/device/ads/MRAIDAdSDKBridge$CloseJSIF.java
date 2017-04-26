package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$CloseJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "Close";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$CloseJSIF(MRAIDAdSDKBridge var1) {
      super("Close");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.close();
      return null;
   }
}
