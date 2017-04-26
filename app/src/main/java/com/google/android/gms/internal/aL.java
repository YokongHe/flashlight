package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class aL extends com.google.android.gms.internal.aN {
   private String a;
   private Context b;
   private String c;
   private ArrayList d;

   public aL(String var1, ArrayList var2, Context var3, String var4) {
      this.c = var1;
      this.d = var2;
      this.a = var4;
      this.b = var3;
   }

   private String a(String var1, HashMap var2) {
      String var8 = this.b.getPackageName();

      String var7;
      try {
         var7 = this.b.getPackageManager().getPackageInfo(var8, 0).versionName;
      } catch (NameNotFoundException var11) {
         com.google.android.gms.internal.bJ.b("Error to retrieve app version", var11);
         var7 = "";
      }

      long var3 = SystemClock.elapsedRealtime();
      long var5 = com.google.android.gms.internal.bw.c().a();

      String var10;
      for(Iterator var9 = var2.keySet().iterator(); var9.hasNext(); var1 = var1.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{var10}), String.format("$1%s$2", new Object[]{var2.get(var10)}))) {
         var10 = (String)var9.next();
      }

      return var1.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{com.google.android.gms.internal.bw.a})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{var8})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.a})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{var7})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(var3 - var5)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
   }

   private void b() {
      try {
         this.b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke((Object)null, new Object[]{this.b, this.c, "", Boolean.valueOf(true)});
      } catch (ClassNotFoundException var2) {
         com.google.android.gms.internal.bJ.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      } catch (NoSuchMethodException var3) {
         com.google.android.gms.internal.bJ.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      } catch (Exception var4) {
         com.google.android.gms.internal.bJ.b("Fail to report a conversion.", var4);
      }
   }

   public final String a() {
      return this.c;
   }

   public final void a(int var1) {
      if(var1 == 1) {
         this.b();
      }

      HashMap var2 = new HashMap();
      var2.put("status", String.valueOf(var1));
      var2.put("sku", this.c);
      Iterator var3 = this.d.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         (new com.google.android.gms.internal.bH(this.b, this.a, this.a(var4, var2))).e();
      }

   }

   public final void b(int var1) {
      byte var2 = 1;
      if(var1 == 0) {
         this.b();
      }

      HashMap var3 = new HashMap();
      var3.put("google_play_status", String.valueOf(var1));
      var3.put("sku", this.c);
      byte var6;
      if(var1 == 0) {
         var6 = var2;
      } else if(var1 == 1) {
         var6 = 2;
      } else if(var1 == 4) {
         var6 = 3;
      } else {
         var6 = 0;
      }

      var3.put("status", String.valueOf(var6));
      Iterator var4 = this.d.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         (new com.google.android.gms.internal.bH(this.b, this.a, this.a(var5, var3))).e();
      }

   }
}
