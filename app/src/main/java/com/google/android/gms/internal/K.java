package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class K implements com.google.android.gms.internal.I {
   private final com.google.android.gms.internal.J a;

   public K(com.google.android.gms.internal.J var1) {
      this.a = var1;
   }

   private static boolean a(Map var0) {
      return "1".equals(var0.get("custom_close"));
   }

   private static int b(Map var0) {
      String var1 = (String)var0.get("o");
      if(var1 != null) {
         if("p".equalsIgnoreCase(var1)) {
            return com.google.android.gms.internal.bD.c();
         }

         if("l".equalsIgnoreCase(var1)) {
            return com.google.android.gms.internal.bD.b();
         }
      }

      return -1;
   }

   public final void a(com.google.android.gms.internal.bL var1, Map var2) {
      String var4 = (String)var2.get("a");
      if(var4 == null) {
         com.google.android.gms.internal.bJ.e("Action missing from an open GMSG.");
      } else {
         com.google.android.gms.internal.bO var3 = var1.f();
         if("expand".equalsIgnoreCase(var4)) {
            if(var1.i()) {
               com.google.android.gms.internal.bJ.e("Cannot expand WebView that is already expanded.");
               return;
            }

            var3.a(a(var2), b(var2));
            return;
         }

         String var5;
         if("webapp".equalsIgnoreCase(var4)) {
            var5 = (String)var2.get("u");
            if(var5 != null) {
               var3.a(a(var2), b(var2), var5);
               return;
            }

            var3.a(a(var2), b(var2), (String)var2.get("html"), (String)var2.get("baseurl"));
            return;
         }

         if(!"in_app_purchase".equalsIgnoreCase(var4)) {
            var3.a(new com.google.android.gms.internal.cb((String)var2.get("i"), (String)var2.get("u"), (String)var2.get("m"), (String)var2.get("p"), (String)var2.get("c"), (String)var2.get("f"), (String)var2.get("e")));
            return;
         }

         var5 = (String)var2.get("product_id");
         String var6 = (String)var2.get("report_urls");
         if(this.a != null) {
            if(var6 != null && !var6.isEmpty()) {
               String[] var7 = var6.split(" ");
               this.a.a(var5, new ArrayList(Arrays.asList(var7)));
               return;
            }

            this.a.a(var5, new ArrayList());
            return;
         }
      }

   }
}
