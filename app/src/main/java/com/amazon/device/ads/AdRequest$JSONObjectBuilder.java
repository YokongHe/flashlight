package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.StringUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class AdRequest$JSONObjectBuilder {
   private AAXParameter[] aaxParameters;
   private Map advancedOptions;
   private final JSONObject json = new JSONObject();
   private AAXParameter$ParameterData parameterData;

   void build() {
      AAXParameter[] var3 = this.aaxParameters;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         AAXParameter var4 = var3[var1];
         this.putIntoJSON(var4, var4.getValue(this.parameterData));
      }

      if(this.advancedOptions != null) {
         Iterator var5 = this.advancedOptions.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            if(!StringUtils.isNullOrWhiteSpace((String)var6.getValue())) {
               this.putIntoJSON((String)var6.getKey(), var6.getValue());
            }
         }
      }

   }

   JSONObject getJSON() {
      return this.json;
   }

   AAXParameter$ParameterData getParameterData() {
      return this.parameterData;
   }

   void putIntoJSON(AAXParameter var1, Object var2) {
      this.putIntoJSON(var1.getName(), var2);
   }

   void putIntoJSON(String var1, Object var2) {
      if(var2 != null) {
         try {
            this.json.put(var1, var2);
         } catch (JSONException var4) {
            Log.d(AdRequest.access$000(), "Could not add parameter to JSON %s: %s", new Object[]{var1, var2});
            return;
         }
      }

   }

   AdRequest$JSONObjectBuilder setAAXParameters(AAXParameter[] var1) {
      this.aaxParameters = var1;
      return this;
   }

   AdRequest$JSONObjectBuilder setAdvancedOptions(Map var1) {
      this.advancedOptions = var1;
      return this;
   }

   AdRequest$JSONObjectBuilder setParameterData(AAXParameter$ParameterData var1) {
      this.parameterData = var1;
      return this;
   }
}
