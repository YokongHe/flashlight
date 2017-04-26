package com.facebook.ads.a;

import android.content.Context;
import com.facebook.ads.AdError;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class l {
   private final int a;
   private final int b;
   private final int c;
   private final List d;
   private final AdError e;

   private l(int var1, int var2, int var3, List var4, AdError var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public static com.facebook.ads.a.l a(Context var0, JSONObject var1) {
      int var2 = 0;
      int var3 = var1.optInt("refresh", 0);
      int var4 = var1.optInt("refresh_threshold", 20);
      int var5 = var1.optInt("min_viewability_percentage", 10);
      JSONObject var7 = var1.optJSONObject("reason");
      AdError var12;
      if(var7 != null) {
         var12 = new AdError(var7.optInt("code", 2000), var7.optString("message", AdError.SERVER_ERROR.getErrorMessage()));
      } else {
         var12 = null;
      }

      int var6 = var1.optInt("ad_type");
      ArrayList var8 = new ArrayList();
      JSONArray var9 = var1.optJSONArray("ads");
      AdError var10;
      if(var9 != null && var9.length() > 0) {
         for(; var2 < var9.length(); ++var2) {
            var1 = var9.optJSONObject(var2);
            if(var1 != null) {
               Object var11;
               if(var6 == com.facebook.ads.a.o.a.a()) {
                  var11 = com.facebook.ads.a.y.a(var1.optJSONObject("data"));
               } else if(var6 == com.facebook.ads.a.o.b.a()) {
                  var11 = com.facebook.ads.a.aa.a(var1.optJSONObject("metadata"));
               } else {
                  var11 = null;
               }

               if(var11 != null && !com.facebook.ads.a.h.a(var0, (com.facebook.ads.a.e)var11)) {
                  var8.add(var11);
               }
            }
         }

         if(var8.isEmpty()) {
            var10 = AdError.NO_FILL;
            return new com.facebook.ads.a.l(var3 * 1000, var4 * 1000, var5, var8, var10);
         }
      }

      var10 = var12;
      return new com.facebook.ads.a.l(var3 * 1000, var4 * 1000, var5, var8, var10);
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   public int c() {
      return this.c;
   }

   public com.facebook.ads.a.e d() {
      return this.d != null && !this.d.isEmpty()?(com.facebook.ads.a.e)this.d.get(0):null;
   }

   public AdError e() {
      return this.e;
   }
}
