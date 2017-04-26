package com.nuance.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.UUID;

public class l implements .ab {
   private static final .ae a = .bh.a(com.nuance.a.a.a.a.l.class);
   private static .ab b;
   private Context c = null;

   private l() {
   }

   public l(Context var1) {
      this.c = var1;
      var1.getSystemService("phone");
   }

   public static .ab e() {
      synchronized(com.nuance.a.a.a.a.l.class){}

      .ab var0;
      try {
         if(b == null) {
            b = new com.nuance.a.a.a.a.l();
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }

   public final String a() {
      return Build.MODEL;
   }

   public final String b() {
      return Build.DEVICE;
   }

   public final String c() {
      return "Android";
   }

   public final String d() {
      return VERSION.RELEASE;
   }

   public final String f() {
      SharedPreferences var3 = this.c.getSharedPreferences("nuance_sdk_pref", 0);
      String var2 = var3.getString("NUANCE_NMSP_UID", "");
      String var1 = var2;
      if(var2.length() == 0) {
         var1 = UUID.randomUUID().toString();
         var2 = var1;
         if(var1 != null) {
            var2 = var1.replaceAll("-", "");
         }

         Editor var4 = var3.edit();
         var4.putString("NUANCE_NMSP_UID", var2);
         var1 = var2;
         if(!var4.commit()) {
            a.e("Storing nuance sdk uid has failed");
            var1 = var2;
         }
      }

      var2 = var1;
      if(var1 == null) {
         var2 = "";
      }

      return var2;
   }
}
