package com.ihs.app.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.os.Build.VERSION;
import com.ihs.app.framework.HSApplication;
import java.util.List;

public final class a {
   public static boolean a() {
      Context var2 = HSApplication.a();
      if(VERSION.SDK_INT > 7) {
         label53: {
            PackageManager var3 = var2.getPackageManager();

            int var0;
            try {
               var0 = var3.getPackageInfo(var2.getPackageName(), 0).applicationInfo.flags;
            } catch (NameNotFoundException var5) {
               break label53;
            }

            if((var0 & 262144) != 262144) {
               return false;
            }

            return true;
         }
      }

      boolean var1;
      try {
         String var6 = var2.getFilesDir().getAbsolutePath();
         if(var6.startsWith("/data/")) {
            return false;
         }

         if(var6.contains("/mnt/")) {
            return true;
         }

         var1 = var6.contains(Environment.getExternalStorageDirectory().getPath());
      } catch (Throwable var4) {
         return false;
      }

      if(var1) {
         return true;
      } else {
         return false;
      }
   }

   public static boolean a(String var0) {
      List var4 = HSApplication.a().getPackageManager().getInstalledPackages(8192);
      int var2 = var4.size();
      int var1 = 0;

      boolean var3;
      while(true) {
         if(var1 >= var2) {
            var3 = false;
            break;
         }

         if(((PackageInfo)var4.get(var1)).packageName.equalsIgnoreCase(var0)) {
            var3 = true;
            break;
         }

         ++var1;
      }

      (new StringBuilder("isAppInstalled(")).append(var0).append(") = ").append(var3).toString();
      return var3;
   }
}
