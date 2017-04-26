package com.ihs.app.framework.a2.a1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.ihs.app.framework.HSApplication;
import java.io.File;
import java.io.RandomAccessFile;

public final class a {
   public static void a() {
      int var0 = com.ihs.a.e.j.a(HSApplication.a()).a("key_lib_appframework_version", 0);
      if(var0 <= 0 && var0 <= 0) {
         Context var1 = HSApplication.a();
         File var2 = new File(var1.getFilesDir(), "INSTALLATION");
         if(var2.exists()) {
            try {
               RandomAccessFile var3 = new RandomAccessFile(var2, "r");
               byte[] var4 = new byte[(int)var3.length()];
               var3.readFully(var4);
               var3.close();
               String var10 = new String(var4);
               var2.delete();
               if(!TextUtils.isEmpty(var10)) {
                  com.ihs.a.e.j.a(var1).b("hs.app.application.installation_uuid", var10);
               }
            } catch (Exception var7) {
               ;
            }
         }

         SharedPreferences var5 = var1.getSharedPreferences("iHandySoftVersionControlFirstLaunchVersion", 0);
         SharedPreferences var6 = var1.getSharedPreferences("iHandySoftVersionControlFirstLaunchOSVersion", 0);
         SharedPreferences var8 = var1.getSharedPreferences("iHandySoftVersionControlLastLaunchVersion", 0);
         SharedPreferences var11 = var1.getSharedPreferences("iHandySoftVersionControlLastLaunchOSVersion", 0);
         SharedPreferences var12 = var1.getSharedPreferences("iHSRateAlertUseCount", 0);
         if(var5.getString("iHandySoftVersionControlFirstLaunchVersion", (String)null) != null && var6.getString("iHandySoftVersionControlFirstLaunchOSVersion", (String)null) != null) {
            com.ihs.app.framework.a var13 = new com.ihs.app.framework.a();
            var13.c = com.ihs.a.e.j.a(var1, "iHandySoftVersionControlFirstLaunchVersion").a("iHandySoftVersionControlFirstLaunchVersion", com.ihs.app.b.c.f());
            var13.d = com.ihs.a.e.j.a(var1, "iHandySoftVersionControlFirstLaunchOSVersion").a("iHandySoftVersionControlFirstLaunchVersion", VERSION.RELEASE);
            var13.a = 1;
            com.ihs.a.e.j.a(var1).b("hs.app.application.first_launch_info", var13.toString());
         }

         if(var8.getString("iHandySoftVersionControlLastLaunchVersion", (String)null) != null && var11.getString("iHandySoftVersionControlLastLaunchOSVersion", (String)null) != null && var12.getInt("iHSRateAlertUseCount", -1) != -1) {
            com.ihs.app.framework.a var9 = new com.ihs.app.framework.a();
            var9.c = com.ihs.a.e.j.a(var1, "iHandySoftVersionControlLastLaunchVersion").a("iHandySoftVersionControlLastLaunchVersion", com.ihs.app.b.c.f());
            var9.d = com.ihs.a.e.j.a(var1, "iHandySoftVersionControlLastLaunchOSVersion").a("iHandySoftVersionControlLastLaunchOSVersion", VERSION.RELEASE);
            var9.a = com.ihs.a.e.j.a(var1, "iHSRateAlertUseCount").a("iHSRateAlertUseCount", 1);
            com.ihs.a.e.j.a(var1).b("hs.app.application.last_launch_info", var9.toString());
         }

         com.ihs.a.e.j.b(var1, "iHandySoftVersionControlFirstLaunchVersion");
         com.ihs.a.e.j.b(var1, "iHandySoftVersionControlFirstLaunchOSVersion");
         com.ihs.a.e.j.b(var1, "iHandySoftVersionControlLastLaunchVersion");
         com.ihs.a.e.j.b(var1, "iHandySoftVersionControlLastLaunchOSVersion");
      }
   }

   public static void b() {
      Context var1 = HSApplication.a();
      com.ihs.a.e.j var2 = com.ihs.a.e.j.a(var1);
      if(com.ihs.app.b.c.b()) {
         var2.b("key_lib_appframework_version", 1);
      } else if(com.ihs.app.b.c.d()) {
         int var0 = com.ihs.a.e.j.a(var1).a("key_lib_appframework_version", 0);
         if(var0 <= 0) {
            if(var0 <= 0) {
               com.ihs.app.framework.a.a.b.a();
            }

            var2.b("key_lib_appframework_version", 1);
            return;
         }
      }

   }
}
