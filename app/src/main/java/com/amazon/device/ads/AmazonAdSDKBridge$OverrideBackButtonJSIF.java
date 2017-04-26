package com.amazon.device.ads;

import com.amazon.device.ads.AmazonAdSDKBridge;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import org.json.JSONObject;

class AmazonAdSDKBridge$OverrideBackButtonJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "OverrideBackButton";
   private final AmazonAdSDKBridge bridge;

   public AmazonAdSDKBridge$OverrideBackButtonJSIF(AmazonAdSDKBridge var1) {
      super("OverrideBackButton");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      AmazonAdSDKBridge.access$200(this.bridge, JSONUtils.getBooleanFromJSON(var1, "override", false));
      return null;
   }
}
