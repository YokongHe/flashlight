package com.surpax.ledflashlight;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
   // $FF: synthetic method
   static List a(Context var0) {
      return c(var0);
   }

   public static List a(Context var0, String var1) {
      String var2 = var0.getSharedPreferences(var1, 0).getString(var1, (String)null);
      return (List)(var2 != null && var2.length() != 0?Arrays.asList(var2.split(",")):new ArrayList());
   }

   public static Map a(Map param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static void a(Context var0, String var1, List var2) {
      String var7;
      if(var2 == null) {
         var7 = null;
      } else {
         StringBuilder var4 = new StringBuilder();
         Iterator var8 = var2.iterator();

         String var5;
         for(boolean var3 = false; var8.hasNext(); var4.append(var5)) {
            var5 = (String)var8.next();
            if(var3) {
               var4.append(",");
            } else {
               var3 = true;
            }
         }

         var7 = var4.toString();
      }

      Editor var6 = var0.getSharedPreferences(var1, 0).edit();
      var6.putString(var1, var7);
      var6.commit();
   }

   private static void a(Context var0, String var1, Map var2) {
      String var3 = var0.getSharedPreferences("WidgetEvents", 0).getString("WidgetEvents", "");

      JSONArray var7;
      try {
         var7 = new JSONArray(var3);
      } catch (JSONException var5) {
         var7 = new JSONArray();
      }

      HashMap var4 = new HashMap();
      var4.put(var1, new JSONObject(var2));
      var7.put(new JSONObject(var4));
      Editor var6 = var0.getSharedPreferences("WidgetEvents", 0).edit();
      var6.putString("WidgetEvents", var7.toString());
      var6.commit();
   }

   public static String b(Map var0, String var1) {
      if(var0.containsKey(var1)) {
         Object var2 = var0.get(var1);
         if(var2 instanceof String) {
            return (String)var2;
         } else if(var2 instanceof Map) {
            var0 = (Map)var2;
            var1 = Locale.getDefault().getLanguage();
            return var0.containsKey(var1)?(String)var0.get(var1):(String)var0.get("en");
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static void b(Context var0) {
      Editor var1 = var0.getSharedPreferences("WidgetEvents", 0).edit();
      var1.clear();
      var1.commit();
   }

   public static void b(Context var0, String var1) {
      HashMap var2 = new HashMap();
      var2.put("WidgetName", var1);
      a(var0, "Widget_Added_New", (Map)var2);
   }

   private static List c(Context var0) {
      String var11 = var0.getSharedPreferences("WidgetEvents", 0).getString("WidgetEvents", "");

      JSONArray var12;
      try {
         var12 = new JSONArray(var11);
      } catch (JSONException var10) {
         var12 = new JSONArray();
      }

      ArrayList var3 = new ArrayList();

      for(int var1 = 0; var1 < var12.length(); ++var1) {
         JSONObject var6 = var12.optJSONObject(var1);
         HashMap var4 = new HashMap();
         String var5 = var6.names().optString(0);
         var6 = var6.optJSONObject(var5);
         HashMap var7 = new HashMap();
         if(var6 != null) {
            JSONArray var8 = var6.names();

            for(int var2 = 0; var2 < var8.length(); ++var2) {
               String var9 = var8.optString(var2);
               var7.put(var9, var6.optString(var9));
            }
         }

         var4.put(var5, var7);
         var3.add(var4);
      }

      return var3;
   }

   public static void c(Context var0, String var1) {
      HashMap var2 = new HashMap();
      var2.put("WidgetName", var1);
      a(var0, "Widget_Deleted_New", (Map)var2);
   }

   public static void d(Context var0, String var1) {
      HashMap var2 = new HashMap();
      var2.put("WidgetName", var1);
      a(var0, "Widget_Clicked_New", (Map)var2);
   }
}
