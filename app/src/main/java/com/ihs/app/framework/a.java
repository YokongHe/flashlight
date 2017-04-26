package com.ihs.app.framework;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
   private static String e = "launchId";
   private static String f = "appVersionCode";
   private static String g = "appVersion";
   private static String h = "osVersion";
   public int a;
   public int b;
   public String c;
   public String d;

   static com.ihs.app.framework.a a(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         try {
            JSONObject var3 = new JSONObject(var0);
            com.ihs.app.framework.a var1 = new com.ihs.app.framework.a();
            var1.a = var3.getInt(e);
            var1.b = var3.optInt(f, -1);
            var1.c = var3.getString(g);
            var1.d = var3.getString(h);
            return var1;
         } catch (JSONException var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   public final String toString() {
      try {
         JSONObject var1 = new JSONObject();
         var1.put(e, this.a);
         var1.put(f, this.b);
         var1.put(g, this.c);
         var1.put(h, this.d);
         String var3 = var1.toString();
         return var3;
      } catch (JSONException var2) {
         return "";
      }
   }
}
