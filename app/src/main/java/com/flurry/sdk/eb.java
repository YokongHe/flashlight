package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;

public class eb {
   private static final String a = eb.class.getSimpleName();
   private static String b;
   private static String c;

   public static String a() {
      synchronized(eb.class){}

      String var0;
      try {
         if(!TextUtils.isEmpty(b)) {
            var0 = b;
         } else if(!TextUtils.isEmpty(c)) {
            var0 = c;
         } else {
            var0 = b();
            c = var0;
         }
      } finally {
         ;
      }

      return var0;
   }

   public static void a(String var0) {
      b = var0;
   }

   private static String b() {
      try {
         Context var0 = do.a().b();
         PackageInfo var2 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0);
         if(var2.versionName != null) {
            return var2.versionName;
         }

         if(var2.versionCode != 0) {
            String var3 = Integer.toString(var2.versionCode);
            return var3;
         }
      } catch (Throwable var1) {
         eo.a(6, a, "", var1);
      }

      return "Unknown";
   }
}
