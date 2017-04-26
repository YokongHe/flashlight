package com.inmobi.commons.cache;

import com.inmobi.commons.cache.MapBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONMapBuilder implements MapBuilder {
   private void a(JSONObject var1, Map var2) {
      Iterator var3 = var1.keys();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();

         try {
            Object var5 = var1.get(var4);
            if(var5 instanceof JSONObject) {
               HashMap var6 = new HashMap();
               var2.put(var4, var6);
               this.a((JSONObject)var5, var6);
            } else {
               var2.put(var4, var5);
            }
         } catch (JSONException var7) {
            ;
         }
      }

   }

   public Map buildMap(String var1) {
      JSONObject var3 = new JSONObject(var1);
      HashMap var2 = new HashMap();
      this.a(var3, var2);
      return var2;
   }
}
