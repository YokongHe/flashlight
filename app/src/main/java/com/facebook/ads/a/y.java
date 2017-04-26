package com.facebook.ads.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class y implements com.facebook.ads.a.e {
   private final String a;
   private final String b;
   private final String c;
   private final String d;
   private final String e;
   private final com.facebook.ads.a.g f;
   private final Collection g;
   private final Map h;

   private y(String var1, String var2, String var3, String var4, String var5, com.facebook.ads.a.g var6, Collection var7, Map var8) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
   }

   public static com.facebook.ads.a.y a(Bundle var0) {
      return new com.facebook.ads.a.y(var0.getString("markup"), (String)null, var0.getString("activation_command"), (String)null, var0.getString("native_impression_report_url"), com.facebook.ads.a.g.a, (Collection)null, (Map)null);
   }

   public static com.facebook.ads.a.y a(JSONObject var0) {
      if(var0 == null) {
         return null;
      } else {
         String var2 = var0.optString("markup");
         String var3 = var0.optString("secondary_markup");
         String var4 = var0.optString("activation_command");
         String var5 = var0.optString("secondary_activation_command");
         String var6 = var0.optString("native_impression_report_url");
         com.facebook.ads.a.g var7 = com.facebook.ads.a.g.a(var0.optString("invalidation_behavior"));

         JSONArray var1;
         try {
            var1 = new JSONArray(var0.optString("detection_strings"));
         } catch (JSONException var11) {
            var11.printStackTrace();
            var1 = null;
         }

         Collection var12 = com.facebook.ads.a.h.a(var1);
         var0 = var0.optJSONObject("metadata");
         HashMap var8 = new HashMap();
         if(var0 != null) {
            Iterator var9 = var0.keys();

            while(var9.hasNext()) {
               String var10 = (String)var9.next();
               var8.put(var10, var0.optString(var10));
            }
         }

         return new com.facebook.ads.a.y(var2, var3, var4, var5, var6, var7, var12, var8);
      }
   }

   public static com.facebook.ads.a.y b(Intent var0) {
      return new com.facebook.ads.a.y(var0.getStringExtra("markup"), (String)null, var0.getStringExtra("activation_command"), (String)null, var0.getStringExtra("native_impression_report_url"), com.facebook.ads.a.g.a, (Collection)null, (Map)null);
   }

   public com.facebook.ads.a.g a() {
      return this.f;
   }

   public void a(Intent var1) {
      var1.putExtra("markup", this.a);
      var1.putExtra("activation_command", this.c);
      var1.putExtra("native_impression_report_url", this.e);
   }

   public Collection b() {
      return this.g;
   }

   public String c() {
      return this.a;
   }

   public String d() {
      return this.c;
   }

   public String e() {
      return this.e;
   }

   public String f() {
      return "facebookAd.sendImpression();";
   }

   public boolean g() {
      return this.h.containsKey("preload") && Boolean.valueOf((String)this.h.get("preload")).booleanValue();
   }

   public Map h() {
      return this.h;
   }

   public Bundle i() {
      Bundle var1 = new Bundle();
      var1.putString("markup", this.a);
      var1.putString("native_impression_report_url", this.e);
      return var1;
   }

   public Map j() {
      HashMap var1 = new HashMap();
      var1.put("markup", this.b);
      var1.put("activation_command", this.d);
      var1.put("native_impression_report_url", this.e);
      return var1;
   }
}
