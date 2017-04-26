package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;

public final class af {
   public static int a(Context var0) {
      return b(var0.getPackageManager(), var0.getPackageName());
   }

   public static String a(PackageManager var0, String var1) {
      try {
         String var3 = var0.getPackageInfo(var1, 0).versionName;
         return var3;
      } catch (NameNotFoundException var2) {
         return null;
      }
   }

   public static int b(PackageManager var0, String var1) {
      try {
         int var2 = var0.getPackageInfo(var1, 0).versionCode;
         return var2;
      } catch (NameNotFoundException var3) {
         return 0;
      }
   }

   @SuppressLint({"NewApi"})
   public static long c(PackageManager var0, String var1) {
      if(VERSION.SDK_INT >= 9) {
         long var2;
         try {
            var2 = var0.getPackageInfo(var1, 0).firstInstallTime;
         } catch (NameNotFoundException var4) {
            return 0L;
         }

         if(var2 > 0L) {
            return var2;
         }
      }

      return 0L;
   }

   public static String d(PackageManager var0, String var1) {
      try {
         String var3 = com.tapjoy.internal.cv.b(var0.getApplicationInfo(var1, 0).sourceDir);
         return var3;
      } catch (NameNotFoundException var2) {
         return null;
      }
   }

   public static Signature[] e(PackageManager var0, String var1) {
      try {
         Signature[] var3 = var0.getPackageInfo(var1, 64).signatures;
         return var3;
      } catch (NameNotFoundException var2) {
         return null;
      }
   }
}
