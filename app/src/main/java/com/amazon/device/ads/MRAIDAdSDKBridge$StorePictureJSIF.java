package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$StorePictureJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "StorePictureJSIF";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$StorePictureJSIF(MRAIDAdSDKBridge var1) {
      super("StorePictureJSIF");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.storePicture(JSONUtils.getStringFromJSON(var1, "url", (String)null));
      return null;
   }
}
