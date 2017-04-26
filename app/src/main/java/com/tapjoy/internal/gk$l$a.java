package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$m;

public final class gk$l$a extends dl$a implements gk$m {
   private int b;
   private Object c = "";
   private Object d = "";
   private Object e = "";
   private Object f = "";
   private Object g = "";
   private Object h = "";
   private int i;
   private int j;
   private int k;
   private Object l = "";
   private Object m = "";
   private Object n = "";
   private Object o = "";
   private Object p = "";
   private Object q = "";
   private Object r = "";
   private Object s = "";

   // $FF: synthetic method
   static gk$l$a f() {
      return new gk$l$a();
   }

   private gk$l$a g() {
      return (new gk$l$a()).a(this.e());
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.g();
   }

   public final gk$l$a a(int var1) {
      this.b |= 64;
      this.i = var1;
      return this;
   }

   public final gk$l$a a(gk$l var1) {
      if(var1 == gk$l.c()) {
         return this;
      } else {
         if(var1.e()) {
            this.b |= 1;
            this.c = gk$l.b(var1);
         }

         if(var1.g()) {
            this.b |= 2;
            this.d = gk$l.c(var1);
         }

         if(var1.i()) {
            this.b |= 4;
            this.e = gk$l.d(var1);
         }

         if(var1.k()) {
            this.b |= 8;
            this.f = gk$l.e(var1);
         }

         if(var1.m()) {
            this.b |= 16;
            this.g = gk$l.f(var1);
         }

         if(var1.o()) {
            this.b |= 32;
            this.h = gk$l.g(var1);
         }

         if(var1.q()) {
            this.a(var1.r());
         }

         if(var1.s()) {
            this.b(var1.t());
         }

         if(var1.u()) {
            this.c(var1.v());
         }

         if(var1.w()) {
            this.b |= 512;
            this.l = gk$l.h(var1);
         }

         if(var1.y()) {
            this.b |= 1024;
            this.m = gk$l.i(var1);
         }

         if(var1.A()) {
            this.b |= 2048;
            this.n = gk$l.j(var1);
         }

         if(var1.C()) {
            this.b |= 4096;
            this.o = gk$l.k(var1);
         }

         if(var1.E()) {
            this.b |= 8192;
            this.p = gk$l.l(var1);
         }

         if(var1.G()) {
            this.b |= 16384;
            this.q = gk$l.m(var1);
         }

         if(var1.I()) {
            this.b |= '耀';
            this.r = gk$l.n(var1);
         }

         if(var1.K()) {
            this.b |= 65536;
            this.s = gk$l.o(var1);
         }

         super.a = super.a.a(gk$l.p(var1));
         return this;
      }
   }

   public final gk$l$a a(String var1) {
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

   public final gk$l$a b(int var1) {
      this.b |= 128;
      this.j = var1;
      return this;
   }

   public final gk$l$a b(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 2;
         this.d = var1;
         return this;
      }
   }

   public final gk$l$a c(int var1) {
      this.b |= 256;
      this.k = var1;
      return this;
   }

   public final gk$l$a c(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 4;
         this.e = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.g();
   }

   public final gk$l$a d(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 8;
         this.f = var1;
         return this;
      }
   }

   public final boolean d() {
      return true;
   }

   public final gk$l$a e(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 16;
         this.g = var1;
         return this;
      }
   }

   public final gk$l e() {
      byte var2 = 1;
      gk$l var4 = new gk$l(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var2 = 0;
      }

      gk$l.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$l.b(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$l.c(var4, this.e);
      var1 = var5;
      if((var3 & 8) == 8) {
         var1 = var5 | 8;
      }

      gk$l.d(var4, this.f);
      var5 = var1;
      if((var3 & 16) == 16) {
         var5 = var1 | 16;
      }

      gk$l.e(var4, this.g);
      var1 = var5;
      if((var3 & 32) == 32) {
         var1 = var5 | 32;
      }

      gk$l.f(var4, this.h);
      var5 = var1;
      if((var3 & 64) == 64) {
         var5 = var1 | 64;
      }

      gk$l.a(var4, this.i);
      var1 = var5;
      if((var3 & 128) == 128) {
         var1 = var5 | 128;
      }

      gk$l.b(var4, this.j);
      var5 = var1;
      if((var3 & 256) == 256) {
         var5 = var1 | 256;
      }

      gk$l.c(var4, this.k);
      var1 = var5;
      if((var3 & 512) == 512) {
         var1 = var5 | 512;
      }

      gk$l.g(var4, this.l);
      var5 = var1;
      if((var3 & 1024) == 1024) {
         var5 = var1 | 1024;
      }

      gk$l.h(var4, this.m);
      var1 = var5;
      if((var3 & 2048) == 2048) {
         var1 = var5 | 2048;
      }

      gk$l.i(var4, this.n);
      var5 = var1;
      if((var3 & 4096) == 4096) {
         var5 = var1 | 4096;
      }

      gk$l.j(var4, this.o);
      var1 = var5;
      if((var3 & 8192) == 8192) {
         var1 = var5 | 8192;
      }

      gk$l.k(var4, this.p);
      var5 = var1;
      if((var3 & 16384) == 16384) {
         var5 = var1 | 16384;
      }

      gk$l.l(var4, this.q);
      var1 = var5;
      if((var3 & '耀') == '耀') {
         var1 = var5 | '耀';
      }

      gk$l.m(var4, this.r);
      var5 = var1;
      if((var3 & 65536) == 65536) {
         var5 = var1 | 65536;
      }

      gk$l.n(var4, this.s);
      gk$l.d(var4, var5);
      return var4;
   }

   public final gk$l$a f(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 32;
         this.h = var1;
         return this;
      }
   }

   public final gk$l$a g(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 512;
         this.l = var1;
         return this;
      }
   }

   public final gk$l$a h(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 1024;
         this.m = var1;
         return this;
      }
   }

   public final gk$l$a i(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 2048;
         this.n = var1;
         return this;
      }
   }

   public final gk$l$a j(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 4096;
         this.o = var1;
         return this;
      }
   }

   public final gk$l$a k(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 8192;
         this.p = var1;
         return this;
      }
   }

   public final gk$l$a l(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 16384;
         this.q = var1;
         return this;
      }
   }

   public final gk$l$a m(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= '耀';
         this.r = var1;
         return this;
      }
   }

   public final gk$l$a n(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 65536;
         this.s = var1;
         return this;
      }
   }
}
