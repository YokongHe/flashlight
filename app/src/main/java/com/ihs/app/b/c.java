package com.ihs.app.b;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.ihs.app.framework.HSApplication;

public final class c {
   private static int a(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         String[] var2 = var0.split("[.]");
         if(var2.length >= 3) {
            for(int var1 = 0; var1 < 3; ++var1) {
               if(var2[var1].length() > 3) {
                  (new StringBuilder("Each number of version must < 1000 : current:")).append(var0).toString();
                  var2[var1] = var2[var1].substring(0, 3);
               }
            }

            return Integer.valueOf(var2[0]).intValue() * 1000 * 1000 * 1000 + 0 + Integer.valueOf(var2[1]).intValue() * 1000 * 1000 + Integer.valueOf(var2[2]).intValue() * 1000;
         }
      }

      return 0;
   }

   public static boolean a() {
      return com.ihs.app.framework.a.b.a().h() == 1 && com.ihs.app.framework.a.b.a().e();
   }

   public static boolean b() {
      return HSApplication.b().a == 1;
   }

   public static boolean c() {
      return d() && com.ihs.app.framework.a.b.a().e();
   }

   public static boolean d() {
      int var1 = HSApplication.b().b;
      int var2 = HSApplication.c().b;
      int var0;
      if(var1 != -1) {
         var0 = var2;
         if(var2 != -1) {
            return var1 > var0;
         }
      }

      var1 = a(HSApplication.b().c);
      var0 = a(HSApplication.c().c);
      return var1 > var0;
   }

   public static int e() {
      if(HSApplication.a() == null) {
         return -1;
      } else {
         PackageManager var1 = HSApplication.a().getPackageManager();

         try {
            int var0 = var1.getPackageInfo(HSApplication.a().getPackageName(), 0).versionCode;
            return var0;
         } catch (NameNotFoundException var2) {
            var2.printStackTrace();
            return -1;
         }
      }
   }

   public static String f() {
      String var5;
      if(HSApplication.a() == null) {
         var5 = null;
         return var5;
      } else {
         PackageManager var1 = HSApplication.a().getPackageManager();

         int var0;
         label30: {
            NameNotFoundException var2;
            label38: {
               try {
                  var5 = var1.getPackageInfo(HSApplication.a().getPackageName(), 0).versionName;
               } catch (NameNotFoundException var4) {
                  var2 = var4;
                  var5 = null;
                  break label38;
               }

               if(var5 == null) {
                  return null;
               }

               try {
                  var0 = var5.length();
                  break label30;
               } catch (NameNotFoundException var3) {
                  var2 = var3;
               }
            }

            var2.printStackTrace();
            return var5;
         }

         if(var0 > 0) {
            return var5;
         } else {
            return null;
         }
      }
   }
}
