package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$PlayVideoJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "PlayVideo";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$PlayVideoJSIF(MRAIDAdSDKBridge var1) {
      super("PlayVideo");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.playVideo(JSONUtils.getStringFromJSON(var1, "url", (String)null));
      return null;
   }
}
