package com.ihs.app.b;

import android.content.Intent;
import android.net.Uri;
import com.ihs.app.framework.HSApplication;

public final class b {
   public static String a() {
      return com.ihs.a.b.b.a("Google", new String[]{"libCommons", "Market", "DefaultMarket"}).trim();
   }

   public static void a(String var0, String var1) {
      String var2 = c(var0);
      String var3 = b(var0);
      if(var2 != null && var3 != null && com.ihs.app.b.a.a(var3)) {
         Uri var5 = Uri.parse(var2 + var1);
         Intent var6 = new Intent("android.intent.action.VIEW");
         var6.setData(var5);
         var6.setFlags(268435456);
         HSApplication.a().startActivity(var6);
      } else {
         var0 = d(var0);
         if(var0 != null) {
            Intent var4 = new Intent("android.intent.action.VIEW", Uri.parse(var0 + var1));
            var4.setFlags(268435456);
            HSApplication.a().startActivity(var4);
            return;
         }
      }

   }

   public static boolean a(String var0) {
      if(var0 != null) {
         var0.trim();
         String var1 = b(var0);
         if(var1 != null && com.ihs.app.b.a.a(var1) && c(var0) != null) {
            return true;
         }
      }

      return false;
   }

   public static String b() {
      com.ihs.a.e.j var2 = com.ihs.a.e.j.a(HSApplication.a(), HSApplication.a().getPackageName());
      String var1 = var2.a((String)"original_market", (String)null);
      String var0 = var1;
      if(var1 == null) {
         var2.b("original_market", a());
         var0 = a();
      }

      return var0;
   }

   private static String b(String var0) {
      String var1 = com.ihs.a.b.b.b(new String[]{"libCommons", "Market", "Markets", var0, "AppPackage"});
      (new StringBuilder("getMarketPackageName(")).append(var0).append(") = ").append(var1).toString();
      return var1;
   }

   private static String c(String var0) {
      String var1 = com.ihs.a.b.b.b(new String[]{"libCommons", "Market", "Markets", var0, "AppUrl"});
      (new StringBuilder("getMarketAppUrl(")).append(var0).append(") = ").append(var1).toString();
      return var1;
   }

   public static void c() {
      String var0 = HSApplication.a().getPackageName();
      String var1 = a();
      if(com.ihs.app.b.a.a(b(var1))) {
         Uri var3 = Uri.parse(c(var1) + var0);
         Intent var4 = new Intent("android.intent.action.VIEW");
         var4.setData(var3);
         var4.setFlags(268435456);
         HSApplication.a().startActivity(var4);
      } else {
         Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(d(var1) + var0));
         var2.setFlags(268435456);
         HSApplication.a().startActivity(var2);
      }
   }

   private static String d(String var0) {
      String var1 = com.ihs.a.b.b.b(new String[]{"libCommons", "Market", "Markets", var0, "WebUrl"});
      (new StringBuilder("getMarketWebUrl(")).append(var0).append(") = ").append(var1).toString();
      return var1;
   }
}
