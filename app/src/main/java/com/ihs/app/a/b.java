package com.ihs.app.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.ihs.app.framework.HSApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class b {
   private static com.ihs.a.a.b.a a = new com.ihs.a.a.b.a();
   private static com.ihs.a.a.b.b b = new com.ihs.a.a.b.b();
   private static com.ihs.app.a.c c;

   public static void a() {
      Object var3 = null;
      Context var1 = HSApplication.a();
      b.a(var1);
      a.a(var1);
      com.ihs.a.a.a.a.a();
      com.ihs.a.a.a.a.a(var1);
      com.ihs.a.a.a.a.b(var1);
      Map var2;
      if(c == null) {
         var2 = null;
      } else {
         var2 = c.a();
      }

      HashMap var4 = new HashMap();
      int var0 = com.ihs.app.framework.a.b.a().h();
      String var5;
      if(var0 < 5) {
         var5 = "0-4";
      } else if(var0 >= 5 && var0 < 10) {
         var5 = "5-9";
      } else if(var0 >= 10 && var0 < 50) {
         var5 = "10-49";
      } else if(var0 >= 50 && var0 < 100) {
         var5 = "50-99";
      } else {
         var5 = "100+";
      }

      var4.put("UsageCount", var5);
      var0 = (int)com.ihs.app.framework.a.b.a().g();
      if(var0 <= 300) {
         var5 = "0-5min";
      } else if(var0 > 300 && var0 <= 600) {
         var5 = "5-10min";
      } else if(var0 > 600 && var0 <= 1800) {
         var5 = "10-30min";
      } else if(var0 > 1800 && var0 <= 3600) {
         var5 = "30-60min";
      } else {
         var5 = "1hour+";
      }

      var4.put("UsageTime", var5);
      var4.put("Firmware", VERSION.RELEASE);
      if(var2 != null) {
         var4.putAll(var2);
      }

      a("App_Opened", (Map)var4);
      HashMap var6 = new HashMap();
      var6.put("CurrentMarket", com.ihs.app.b.b.a());
      var6.put("Market", com.ihs.app.b.b.b());
      String var7 = com.ihs.app.b.b.b();
      if(TextUtils.isEmpty(var7)) {
         var5 = (String)var3;
      } else {
         var0 = var7.indexOf("-");
         var5 = (String)var3;
         if(var0 >= 0) {
            var5 = var7.substring(0, var0);
         }
      }

      var6.put("MarketGroup", var5);
      var6.put("Location", Locale.getDefault().getCountry());
      a("MarketInfo", (Map)var6);
      if(com.ihs.app.b.a.a()) {
         var5 = "SD Card";
      } else {
         var5 = "PhoneMemory";
      }

      a("App_Install_Location", new String[]{"Location", var5});
      var5 = com.ihs.a.b.b.c();
      if(!TextUtils.isEmpty(var5)) {
         a("RestrictedUserInfo", new String[]{var5});
      }

   }

   public static void a(com.ihs.app.a.c var0) {
      c = var0;
   }

   public static void a(String var0) {
      a(var0, (Map)(new HashMap()));
   }

   public static void a(String var0, Map var1) {
      HashMap var3 = new HashMap();
      if(com.ihs.app.b.c.a()) {
         var3.put("UserType", "NewUser");
      } else {
         var3.put("UserType", "OldUser");
      }

      var3.put("UserSegment", com.ihs.a.b.b.a("NormalUser", new String[]{"SegmentName"}));
      com.ihs.app.a.a.a(var0, var3, var1);
      if(var1 != null && var1.size() > 0) {
         int var2 = var3.size();
         Iterator var5 = var1.entrySet().iterator();

         for(var2 = 10 - var2; var5.hasNext() && var2 > 0; --var2) {
            Entry var4 = (Entry)var5.next();
            var3.put(var4.getKey(), var4.getValue());
         }

         if(var5.hasNext()) {
            Assert.assertEquals("Flurry Event params >10", 1, 2);
         }
      }

      b.a(var0, var3);
   }

   public static void a(String var0, String... var1) {
      HashMap var5 = new HashMap();
      if(var1 != null) {
         int var3 = var1.length;
         int var2 = var3;
         if(var3 % 2 != 0) {
            var2 = var3 - 1;
         }

         var3 = 0;

         while(var3 < var2) {
            int var4 = var3 + 1;
            String var6 = var1[var3];
            var3 = var4 + 1;
            var5.put(var6, var1[var4]);
         }
      }

      a(var0, (Map)var5);
   }

   public static void b() {
      Map var0;
      if(c == null) {
         var0 = null;
      } else {
         var0 = c.b();
      }

      a("App_Closed", var0);
      b.a();
      a.a();
   }
}
