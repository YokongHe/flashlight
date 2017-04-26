package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSONUtils {
   public static boolean getBooleanFromJSON(JSONObject var0, String var1, boolean var2) {
      return var0.isNull(var1)?var2:var0.optBoolean(var1, var2);
   }

   public static int getIntegerFromJSON(JSONObject var0, String var1, int var2) {
      return var0.isNull(var1)?var2:var0.optInt(var1, var2);
   }

   public static int getIntegerFromJSONArray(JSONArray var0, int var1, int var2) {
      return var0.isNull(var1)?var2:var0.optInt(var1, var2);
   }

   public static JSONArray getJSONArrayFromJSON(JSONObject var0, String var1) {
      return var0.isNull(var1)?null:var0.optJSONArray(var1);
   }

   public static JSONObject getJSONObjectFromJSONArray(JSONArray var0, int var1) {
      if(var0.isNull(var1)) {
         return null;
      } else {
         try {
            JSONObject var3 = var0.getJSONObject(var1);
            return var3;
         } catch (JSONException var2) {
            return null;
         }
      }
   }

   public static JSONObject getJSONObjectFromString(String var0) {
      try {
         JSONObject var2 = new JSONObject(var0);
         return var2;
      } catch (JSONException var1) {
         return null;
      }
   }

   public static long getLongFromJSON(JSONObject var0, String var1, long var2) {
      return var0.isNull(var1)?var2:var0.optLong(var1, var2);
   }

   public static String getStringFromJSON(JSONObject var0, String var1, String var2) {
      return var0.isNull(var1)?var2:var0.optString(var1, var2);
   }

   public static void put(JSONObject var0, String var1, int var2) {
      try {
         var0.put(var1, var2);
      } catch (JSONException var3) {
         ;
      }
   }

   public static void put(JSONObject var0, String var1, long var2) {
      try {
         var0.put(var1, var2);
      } catch (JSONException var4) {
         ;
      }
   }

   public static void put(JSONObject var0, String var1, String var2) {
      if(var2 != null && !var2.equals("")) {
         try {
            var0.put(var1, var2);
         } catch (JSONException var3) {
            return;
         }
      }

   }

   public static void put(JSONObject var0, String var1, boolean var2) {
      try {
         var0.put(var1, var2);
      } catch (JSONException var3) {
         ;
      }
   }
}
