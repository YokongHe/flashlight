package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$CreateCalendarEventJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "CreateCalendarEvent";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$CreateCalendarEventJSIF(MRAIDAdSDKBridge var1) {
      super("CreateCalendarEvent");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      this.bridge.createCalendarEvent(JSONUtils.getStringFromJSON(var1, "description", (String)null), JSONUtils.getStringFromJSON(var1, "location", (String)null), JSONUtils.getStringFromJSON(var1, "summary", (String)null), JSONUtils.getStringFromJSON(var1, "start", (String)null), JSONUtils.getStringFromJSON(var1, "end", (String)null));
      return null;
   }
}
