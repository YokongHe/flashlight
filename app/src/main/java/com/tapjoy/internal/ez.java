package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tapjoy.internal.ex;
import java.util.Locale;
import java.util.UUID;

class ez {
   private static final String a = ez.class.getName();

   static String a(Context var0) {
      SharedPreferences var2 = var0.getSharedPreferences("ThreatMetrixMobileSDK", 0);
      String var1 = var2.getString("ThreatMetrixMobileSDK", (String)null);
      String var3 = var1;
      if(var1 == null) {
         var3 = a;
         var3 = UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.US);
         Editor var4 = var2.edit();
         var4.putString("ThreatMetrixMobileSDK", var3);
         var4.commit();
      }

      return var3;
   }

   private static String a(String var0) {
      String var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = var0;
         if(var0.length() != 32) {
            if(var0.length() < 32) {
               var0 = var0 + ex.b(var0).substring(0, 32 - var0.length());
            } else {
               var0 = ex.b(var0);
            }

            return var0;
         }
      }

      return var1;
   }

   static String a(String var0, String var1, String var2, boolean var3) {
      String var4;
      if(Build.SERIAL == null) {
         var4 = "";
      } else {
         var4 = Build.SERIAL;
      }

      if(var2 != null && !var2.isEmpty() && !var2.equals("000000000000000")) {
         var0 = var4 + var2;
      } else if(var0 != null) {
         var0 = var4 + var0;
      } else {
         var0 = var4 + var1;
      }

      var1 = var0;
      if(var3) {
         var1 = ex.b(var0);
      }

      return a(ex.b(var1));
   }

   static String a(String var0, boolean var1) {
      String var2 = var0;
      if(var1) {
         var2 = ex.b(var0);
      }

      var0 = a;
      (new StringBuilder("using generated ID for LSC:")).append(var2);
      return a(var2);
   }

   static boolean a() {
      boolean var1 = false;
      String var2 = Build.SERIAL;
      boolean var0 = var1;
      if(var2 != null) {
         if(!var2.equals("unknown")) {
            var0 = var1;
            if(!var2.equals("1234567890ABCDEF")) {
               return var0;
            }
         }

         var0 = true;
      }

      return var0;
   }

   static String b(Context var0) {
      String var1 = Secure.getString(var0.getContentResolver(), "android_id");
      String var2;
      if(var1 != null && !var1.equals("9774d56d682e549c")) {
         var2 = var1;
         if(var1.length() >= 15) {
            return var2;
         }
      }

      var2 = a;
      var2 = null;
      return var2;
   }

   static String b(String var0, boolean var1) {
      String var2 = var0;
      if(var0 != null) {
         var2 = var0;
         if(var1) {
            var2 = ex.b(var0);
         }

         var0 = a;
         (new StringBuilder("using ANDROID_ID for TPC:")).append(var2);
      }

      return a(var2);
   }

   static String c(Context var0) {
      String var3;
      try {
         var3 = ((TelephonyManager)var0.getSystemService("phone")).getDeviceId();
         String var1 = a;
         (new StringBuilder("imei: ")).append(var3);
         return var3;
      } catch (SecurityException var2) {
         var3 = a;
         return "";
      }
   }
}
