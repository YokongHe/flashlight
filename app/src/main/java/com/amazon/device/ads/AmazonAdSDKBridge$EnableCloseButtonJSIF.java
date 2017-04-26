package com.amazon.device.ads;

import com.amazon.device.ads.AmazonAdSDKBridge;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import org.json.JSONObject;

class AmazonAdSDKBridge$EnableCloseButtonJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "EnableCloseButton";
   private final AmazonAdSDKBridge bridge;

   public AmazonAdSDKBridge$EnableCloseButtonJSIF(AmazonAdSDKBridge var1) {
      super("EnableCloseButton");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      AmazonAdSDKBridge.access$100(this.bridge, JSONUtils.getBooleanFromJSON(var1, "enable", true));
      return null;
   }
}
