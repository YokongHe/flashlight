package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.gk$r;
import com.tapjoy.internal.gk$s;

public final class gk$r$a extends dl$a implements gk$s {
   private int b;
   private Object c = "";
   private int d = 1;
   private double e;
   private Object f = "";
   private Object g = "";
   private Object h = "";
   private Object i = "";
   private Object j = "";
   private int k;
   private long l;
   private Object m = "";
   private Object n = "";

   // $FF: synthetic method
   static gk$r$a f() {
      return new gk$r$a();
   }

   private gk$r$a g() {
      return (new gk$r$a()).a(this.e());
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.g();
   }

   public final gk$r$a a(double var1) {
      this.b |= 4;
      this.e = var1;
      return this;
   }

   public final gk$r$a a(gk$r var1) {
      if(var1 == gk$r.c()) {
         return this;
      } else {
         if(var1.e()) {
            this.b |= 1;
            this.c = gk$r.b(var1);
         }

         int var2;
         if(var1.g()) {
            var2 = var1.h();
            this.b |= 2;
            this.d = var2;
         }

         if(var1.i()) {
            this.a(var1.j());
         }

         if(var1.k()) {
            this.b |= 8;
            this.f = gk$r.c(var1);
         }

         if(var1.m()) {
            this.b |= 16;
            this.g = gk$r.d(var1);
         }

         if(var1.o()) {
            this.b |= 32;
            this.h = gk$r.e(var1);
         }

         if(var1.q()) {
            this.b |= 64;
            this.i = gk$r.f(var1);
         }

         if(var1.s()) {
            this.b |= 128;
            this.j = gk$r.g(var1);
         }

         if(var1.u()) {
            var2 = var1.v();
            this.b |= 256;
            this.k = var2;
         }

         if(var1.w()) {
            long var3 = var1.x();
            this.b |= 512;
            this.l = var3;
         }

         if(var1.y()) {
            this.b |= 1024;
            this.m = gk$r.h(var1);
         }

         if(var1.A()) {
            this.b |= 2048;
            this.n = gk$r.i(var1);
         }

         super.a = super.a.a(gk$r.j(var1));
         return this;
      }
   }

   public final gk$r$a a(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 1;
         this.c = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final dl$a b() {
      return this.g();
   }

   public final gk$r$a b(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 8;
         this.f = var1;
         return this;
      }
   }

   public final gk$r$a c(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 1024;
         this.m = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.g();
   }

   public final boolean d() {
      boolean var1;
      if((this.b & 1) == 1) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final gk$r e() {
      byte var2 = 1;
      gk$r var4 = new gk$r(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var2 = 0;
      }

      gk$r.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$r.a(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$r.a(var4, this.e);
      var1 = var5;
      if((var3 & 8) == 8) {
         var1 = var5 | 8;
      }

      gk$r.b(var4, this.f);
      var5 = var1;
      if((var3 & 16) == 16) {
         var5 = var1 | 16;
      }

      gk$r.c(var4, this.g);
      var1 = var5;
      if((var3 & 32) == 32) {
         var1 = var5 | 32;
      }

      gk$r.d(var4, this.h);
      var5 = var1;
      if((var3 & 64) == 64) {
         var5 = var1 | 64;
      }

      gk$r.e(var4, this.i);
      var1 = var5;
      if((var3 & 128) == 128) {
         var1 = var5 | 128;
      }

      gk$r.f(var4, this.j);
      var5 = var1;
      if((var3 & 256) == 256) {
         var5 = var1 | 256;
      }

      gk$r.b(var4, this.k);
      var1 = var5;
      if((var3 & 512) == 512) {
         var1 = var5 | 512;
      }

      gk$r.a(var4, this.l);
      var5 = var1;
      if((var3 & 1024) == 1024) {
         var5 = var1 | 1024;
      }

      gk$r.g(var4, this.m);
      var1 = var5;
      if((var3 & 2048) == 2048) {
         var1 = var5 | 2048;
      }

      gk$r.h(var4, this.n);
      gk$r.c(var4, var1);
      return var4;
   }
}
