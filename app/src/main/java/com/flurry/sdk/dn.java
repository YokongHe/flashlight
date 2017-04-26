package com.flurry.sdk;

import com.flurry.sdk.dj;
import com.flurry.sdk.dl;
import com.flurry.sdk.dp;
import com.flurry.sdk.eo;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

public class dn {
   private static final String a = dn.class.getSimpleName();
   private static dn b;

   public static dn a() {
      synchronized(dn.class){}

      dn var0;
      try {
         if(b == null) {
            b = new dn();
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }

   public int b() {
      int var1 = ((Integer)dp.a().a("AgentVersion")).intValue();
      eo.a(4, a, "getAgentVersion() = " + var1);
      return var1;
   }

   int c() {
      return ((Integer)dp.a().a("ReleaseMajorVersion")).intValue();
   }

   int d() {
      return ((Integer)dp.a().a("ReleaseMinorVersion")).intValue();
   }

   int e() {
      return ((Integer)dp.a().a("ReleasePatchVersion")).intValue();
   }

   String f() {
      return (String)dp.a().a("ReleaseBetaVersion");
   }

   public String g() {
      String var1;
      if(this.f().length() > 0) {
         var1 = ".";
      } else {
         var1 = "";
      }

      return String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", new Object[]{Integer.valueOf(this.b()), Integer.valueOf(this.c()), Integer.valueOf(this.d()), Integer.valueOf(this.e()), var1, this.f()});
   }

   public String h() {
      String var1 = null;
      dj var2 = dl.a().c();
      if(var2 != null) {
         var1 = var2.j();
      }

      return var1;
   }

   public String i() {
      String var1 = null;
      dj var2 = dl.a().c();
      if(var2 != null) {
         var1 = var2.k();
      }

      return var1;
   }

   public String j() {
      String var1 = null;
      dj var2 = dl.a().c();
      if(var2 != null) {
         var1 = var2.l();
      }

      return var1;
   }

   public boolean k() {
      dj var1 = dl.a().c();
      return var1 != null?var1.o():true;
   }

   public Map l() {
      dj var1 = dl.a().c();
      return var1 != null?var1.p():Collections.emptyMap();
   }
}
