package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Log;
import org.json.JSONArray;
import org.json.JSONException;

class AAXParameter$JSONArrayParameter extends AAXParameter {
   AAXParameter$JSONArrayParameter(String var1, String var2) {
      super(var1, var2);
   }

   protected JSONArray getFromDebugProperties() {
      return this.parseFromString(DebugProperties.getDebugPropertyAsString(this.getDebugName(), (String)null));
   }

   protected JSONArray parseFromString(String var1) {
      try {
         JSONArray var3 = new JSONArray(var1);
         return var3;
      } catch (JSONException var2) {
         Log.e(AAXParameter.access$100(), "Unable to parse the following value into a JSONArray: %s", new Object[]{this.getName()});
         return null;
      }
   }
}
