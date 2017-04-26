package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import org.json.JSONObject;

class MRAIDAdSDKBridge$GetPlacementTypeJSIF extends JavascriptInteractor$JavascriptMethodExecutor {
   private static final String name = "GetPlacementType";
   private final MRAIDAdSDKBridge bridge;

   public MRAIDAdSDKBridge$GetPlacementTypeJSIF(MRAIDAdSDKBridge var1) {
      super("GetPlacementType");
      this.bridge = var1;
   }

   public JSONObject execute(JSONObject var1) {
      var1 = new JSONObject();
      JSONUtils.put(var1, "placementType", this.bridge.getPlacementType());
      return var1;
   }
}
