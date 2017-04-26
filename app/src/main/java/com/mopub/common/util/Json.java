package com.mopub.common.util;

import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Json {
   public static Object getJsonValue(JSONObject var0, String var1, Class var2) {
      if(var0 != null && var1 != null && var2 != null) {
         Object var3 = var0.opt(var1);
         if(var3 == null) {
            MoPubLog.w("Tried to get Json value with key: " + var1 + ", but it was null");
            return null;
         } else if(!var2.isInstance(var3)) {
            MoPubLog.w("Tried to get Json value with key: " + var1 + ", of type: " + var2.toString() + ", its type did not match");
            return null;
         } else {
            return var2.cast(var3);
         }
      } else {
         throw new IllegalArgumentException("Cannot pass any null argument to getJsonValue");
      }
   }

   public static String[] jsonArrayToStringArray(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static Map jsonStringToMap(String var0) {
      HashMap var1 = new HashMap();
      if(TextUtils.isEmpty(var0)) {
         return var1;
      } else {
         JSONObject var4 = (JSONObject)(new JSONTokener(var0)).nextValue();
         Iterator var2 = var4.keys();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.put(var3, var4.getString(var3));
         }

         return var1;
      }
   }

   public static String mapToJsonString(Map var0) {
      if(var0 == null) {
         return "{}";
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("{");
         Iterator var4 = var0.entrySet().iterator();

         for(boolean var1 = true; var4.hasNext(); var1 = false) {
            Entry var3 = (Entry)var4.next();
            if(!var1) {
               var2.append(",");
            }

            var2.append("\"");
            var2.append((String)var3.getKey());
            var2.append("\":\"");
            var2.append((String)var3.getValue());
            var2.append("\"");
         }

         var2.append("}");
         return var2.toString();
      }
   }
}
