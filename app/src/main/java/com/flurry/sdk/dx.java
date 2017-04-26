package com.flurry.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.flurry.sdk.eo;

public final class dx {
   private static final String a = dx.class.getSimpleName();

   public static PackageInfo a(Context var0) {
      PackageInfo var1 = null;
      if(var0 != null) {
         try {
            var1 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 20815);
         } catch (NameNotFoundException var2) {
            eo.a(a, "Cannot find package info for package: " + var0.getPackageName());
            return null;
         }
      }

      return var1;
   }

   public static ApplicationInfo b(Context var0) {
      ApplicationInfo var1 = null;
      if(var0 != null) {
         try {
            var1 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
         } catch (NameNotFoundException var2) {
            eo.a(a, "Cannot find application info for package: " + var0.getPackageName());
            return null;
         }
      }

      return var1;
   }

   public static String c(Context var0) {
      PackageInfo var1 = a(var0);
      return var1 != null && var1.packageName != null?var1.packageName:"";
   }

   public static Bundle d(Context var0) {
      ApplicationInfo var1 = b(var0);
      return var1 != null && var1.metaData != null?var1.metaData:Bundle.EMPTY;
   }
}
