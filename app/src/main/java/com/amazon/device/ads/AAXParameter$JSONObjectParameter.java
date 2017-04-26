package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Log;
import org.json.JSONException;
import org.json.JSONObject;

class AAXParameter$JSONObjectParameter extends AAXParameter {
   AAXParameter$JSONObjectParameter(String var1, String var2) {
      super(var1, var2);
   }

   protected JSONObject getFromDebugProperties() {
      return this.parseFromString(DebugProperties.getDebugPropertyAsString(this.getDebugName(), (String)null));
   }

   protected JSONObject parseFromString(String var1) {
      try {
         JSONObject var3 = new JSONObject(var1);
         return var3;
      } catch (JSONException var2) {
         Log.e(AAXParameter.access$100(), "Unable to parse the following value into a JSONObject: %s", new Object[]{this.getName()});
         return null;
      }
   }
}
