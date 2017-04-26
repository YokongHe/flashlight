package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tapjoy.internal.fv;
import java.io.File;
import java.io.IOException;

public final class ge {
   final com.tapjoy.internal.j A;
   final Context a;
   final SharedPreferences b;
   final com.tapjoy.internal.q c;
   final com.tapjoy.internal.q d;
   final com.tapjoy.internal.m e;
   final com.tapjoy.internal.m f;
   final com.tapjoy.internal.q g;
   final com.tapjoy.internal.m h;
   final com.tapjoy.internal.n i;
   final com.tapjoy.internal.n j;
   final com.tapjoy.internal.n k;
   final com.tapjoy.internal.q l;
   final com.tapjoy.internal.m m;
   final com.tapjoy.internal.k n;
   final com.tapjoy.internal.n o;
   final com.tapjoy.internal.k p;
   final com.tapjoy.internal.q q;
   final com.tapjoy.internal.q r;
   final com.tapjoy.internal.m s;
   final com.tapjoy.internal.m t;
   final com.tapjoy.internal.q u;
   final com.tapjoy.internal.q v;
   final com.tapjoy.internal.q w;
   final com.tapjoy.internal.q x;
   final com.tapjoy.internal.q y;
   final com.tapjoy.internal.q z;

   private ge(Context var1) {
      var1 = var1.getApplicationContext();
      this.a = var1;
      this.b = var1.getSharedPreferences("fiverocks", 0);
      this.c = new com.tapjoy.internal.q(this.b, "sdk");
      this.d = new com.tapjoy.internal.q(this.b, "ir");
      this.e = new com.tapjoy.internal.m(this.b, "fql", 0);
      this.f = new com.tapjoy.internal.m(this.b, "fq", 0);
      this.g = new com.tapjoy.internal.q(this.b, "push");
      this.h = new com.tapjoy.internal.m(this.b, "ss", 0);
      this.i = new com.tapjoy.internal.n(this.b, "std");
      this.j = new com.tapjoy.internal.n(this.b, "slt");
      this.k = new com.tapjoy.internal.n(this.b, "sld");
      this.l = new com.tapjoy.internal.q(this.b, "ptc");
      this.m = new com.tapjoy.internal.m(this.b, "pc", 0);
      this.n = new com.tapjoy.internal.k(this.b, "ptp");
      this.o = new com.tapjoy.internal.n(this.b, "lpt");
      this.p = new com.tapjoy.internal.k(this.b, "plp");
      this.q = new com.tapjoy.internal.q(this.b, "adv");
      this.r = new com.tapjoy.internal.q(this.b, "ui");
      this.s = new com.tapjoy.internal.m(this.b, "ul", -1);
      this.t = new com.tapjoy.internal.m(this.b, "uf", -1);
      this.u = new com.tapjoy.internal.q(this.b, "uv1");
      this.v = new com.tapjoy.internal.q(this.b, "uv2");
      this.w = new com.tapjoy.internal.q(this.b, "uv3");
      this.x = new com.tapjoy.internal.q(this.b, "uv4");
      this.y = new com.tapjoy.internal.q(this.b, "uv5");
      this.z = new com.tapjoy.internal.q(this.b, "idfa");
      this.A = new com.tapjoy.internal.j(this.b, "idfa.optout");
   }

   public static ge a(Context var0) {
      return new ge(var0);
   }

   final Editor a() {
      return this.b.edit();
   }

   public final String b() {
      String var2 = this.b.getString("ir", (String)null);
      if(var2 != null) {
         if(var2.length() <= 0) {
            return null;
         } else {
            return var2;
         }
      } else {
         File var3 = new File(fv.b(this.a), "referrer");
         String var1 = var2;
         if(var3.exists()) {
            try {
               var1 = com.tapjoy.internal.bm.a(var3, com.tapjoy.internal.aq.c);
            } catch (IOException var4) {
               var1 = var2;
            }
         }

         Editor var5 = this.b.edit();
         if(var1 != null) {
            var2 = var1;
         } else {
            var2 = "";
         }

         var5.putString("ir", var2).commit();
         if(var1 != null) {
            var2 = var1;
            if(var1.length() > 0) {
               return var2;
            }
         }

         return null;
      }
   }
}
