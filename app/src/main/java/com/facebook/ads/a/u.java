package com.facebook.ads.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class u {
   private final String a;
   private final String b;
   private final String c;
   private final List d;
   private final String e;
   private final String f;

   private u(String var1, String var2, String var3, List var4, String var5, String var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public static com.facebook.ads.a.u a(JSONObject var0) {
      if(var0 == null) {
         return null;
      } else {
         String var2 = var0.optString("package");
         String var3 = var0.optString("appsite");
         String var4 = var0.optString("appsite_url");
         JSONArray var5 = var0.optJSONArray("key_hashes");
         ArrayList var6 = new ArrayList();
         if(var5 != null) {
            for(int var1 = 0; var1 < var5.length(); ++var1) {
               var6.add(var5.optString(var1));
            }
         }

         return new com.facebook.ads.a.u(var2, var3, var4, var6, var0.optString("market_uri"), var0.optString("fallback_url"));
      }
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }
}
