package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Q {
   public final List a;
   public final long b;
   public final List c;
   public final List d;
   public final List e;
   public final String f;
   public final long g;
   public int h;
   public int i;

   public Q(String var1) {
      JSONObject var10 = new JSONObject(var1);
      if(com.google.android.gms.internal.bJ.a(2)) {
         com.google.android.gms.internal.bJ.d("Mediation Response JSON: " + var10.toString(2));
      }

      JSONArray var7 = var10.getJSONArray("ad_networks");
      ArrayList var8 = new ArrayList(var7.length());
      int var3 = -1;

      int var4;
      for(int var2 = 0; var2 < var7.length(); var3 = var4) {
         com.google.android.gms.internal.P var9 = new com.google.android.gms.internal.P(var7.getJSONObject(var2));
         var8.add(var9);
         var4 = var3;
         if(var3 < 0) {
            var4 = var3;
            if(a(var9)) {
               var4 = var2;
            }
         }

         ++var2;
      }

      this.h = var3;
      this.i = var7.length();
      this.a = Collections.unmodifiableList(var8);
      this.f = var10.getString("qdata");
      var10 = var10.optJSONObject("settings");
      if(var10 != null) {
         this.b = var10.optLong("ad_network_timeout_millis", -1L);
         this.c = com.google.android.gms.internal.W.a(var10, "click_urls");
         this.d = com.google.android.gms.internal.W.a(var10, "imp_urls");
         this.e = com.google.android.gms.internal.W.a(var10, "nofill_urls");
         long var5 = var10.optLong("refresh", -1L);
         if(var5 > 0L) {
            var5 *= 1000L;
         } else {
            var5 = -1L;
         }

         this.g = var5;
      } else {
         this.b = -1L;
         this.c = null;
         this.d = null;
         this.e = null;
         this.g = -1L;
      }
   }

   private static boolean a(com.google.android.gms.internal.P var0) {
      Iterator var1 = var0.c.iterator();

      do {
         if(!var1.hasNext()) {
            return false;
         }
      } while(!((String)var1.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));

      return true;
   }
}
