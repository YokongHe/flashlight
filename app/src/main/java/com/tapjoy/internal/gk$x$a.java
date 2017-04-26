package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.gk$t;
import com.tapjoy.internal.gk$t$a;
import com.tapjoy.internal.gk$x;
import com.tapjoy.internal.gk$y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class gk$x$a extends dl$a implements gk$y {
   private int b;
   private long c;
   private Object d = "";
   private int e;
   private int f;
   private List g = Collections.emptyList();
   private int h;
   private long i;
   private long j;
   private long k;
   private Object l = "";
   private int m;
   private double n;
   private long o;
   private double p;
   private Object q = "";
   private boolean r;
   private Object s = "";
   private int t;
   private int u;
   private Object v = "";
   private Object w = "";
   private Object x = "";
   private Object y = "";
   private Object z = "";

   // $FF: synthetic method
   static gk$x$a K() {
      return new gk$x$a();
   }

   private gk$x$a L() {
      return (new gk$x$a()).a(this.e());
   }

   private void M() {
      if((this.b & 16) != 16) {
         this.g = new ArrayList(this.g);
         this.b |= 16;
      }

   }

   public final gk$x$a A() {
      this.b &= -1048577;
      this.w = gk$x.c().T();
      return this;
   }

   public final boolean B() {
      return (this.b & 2097152) == 2097152;
   }

   public final String C() {
      Object var1 = this.x;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.x = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }

   public final gk$x$a D() {
      this.b &= -2097153;
      this.x = gk$x.c().V();
      return this;
   }

   public final boolean E() {
      return (this.b & 4194304) == 4194304;
   }

   public final String F() {
      Object var1 = this.y;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.y = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }

   public final gk$x$a G() {
      this.b &= -4194305;
      this.y = gk$x.c().X();
      return this;
   }

   public final boolean H() {
      return (this.b & 8388608) == 8388608;
   }

   public final String I() {
      Object var1 = this.z;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.z = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }

   public final gk$x$a J() {
      this.b &= -8388609;
      this.z = gk$x.c().Z();
      return this;
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.L();
   }

   public final gk$x$a a(double var1) {
      this.b |= 2048;
      this.n = var1;
      return this;
   }

   public final gk$x$a a(int var1) {
      this.b |= 4;
      this.e = var1;
      return this;
   }

   public final gk$x$a a(int var1, gk$t$a var2) {
      this.M();
      this.g.set(var1, var2.e());
      return this;
   }

   public final gk$x$a a(int var1, gk$t var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.M();
         this.g.set(var1, var2);
         return this;
      }
   }

   public final gk$x$a a(long var1) {
      this.b |= 1;
      this.c = var1;
      return this;
   }

   public final gk$x$a a(gk$t$a var1) {
      this.M();
      this.g.add(var1.e());
      return this;
   }

   public final gk$x$a a(gk$x var1) {
      if(var1 == gk$x.c()) {
         return this;
      } else {
         if(var1.e()) {
            this.a(var1.f());
         }

         if(var1.g()) {
            this.b |= 2;
            this.d = gk$x.b(var1);
         }

         if(var1.i()) {
            this.a(var1.j());
         }

         if(var1.k()) {
            this.b(var1.l());
         }

         if(!gk$x.c(var1).isEmpty()) {
            if(this.g.isEmpty()) {
               this.g = gk$x.c(var1);
               this.b &= -17;
            } else {
               this.M();
               this.g.addAll(gk$x.c(var1));
            }
         }

         if(var1.o()) {
            this.e(var1.p());
         }

         if(var1.q()) {
            this.b(var1.r());
         }

         if(var1.s()) {
            this.c(var1.t());
         }

         if(var1.u()) {
            this.d(var1.v());
         }

         if(var1.w()) {
            this.b |= 512;
            this.l = gk$x.d(var1);
         }

         if(var1.y()) {
            this.f(var1.z());
         }

         if(var1.A()) {
            this.a(var1.B());
         }

         if(var1.C()) {
            this.e(var1.D());
         }

         if(var1.E()) {
            this.b(var1.F());
         }

         if(var1.G()) {
            this.b |= 16384;
            this.q = gk$x.e(var1);
         }

         if(var1.I()) {
            this.a(var1.J());
         }

         if(var1.K()) {
            this.b |= 65536;
            this.s = gk$x.f(var1);
         }

         if(var1.M()) {
            this.g(var1.N());
         }

         if(var1.O()) {
            this.h(var1.P());
         }

         if(var1.Q()) {
            this.b |= 524288;
            this.v = gk$x.g(var1);
         }

         if(var1.S()) {
            this.b |= 1048576;
            this.w = gk$x.h(var1);
         }

         if(var1.U()) {
            this.b |= 2097152;
            this.x = gk$x.i(var1);
         }

         if(var1.W()) {
            this.b |= 4194304;
            this.y = gk$x.j(var1);
         }

         if(var1.Y()) {
            this.b |= 8388608;
            this.z = gk$x.k(var1);
         }

         super.a = super.a.a(gk$x.l(var1));
         return this;
      }
   }

   public final gk$x$a a(Iterable var1) {
      this.M();
      de$a.a(var1, this.g);
      return this;
   }

   public final gk$x$a a(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 2;
         this.d = var1;
         return this;
      }
   }

   public final gk$x$a a(boolean var1) {
      this.b |= '耀';
      this.r = var1;
      return this;
   }

   // $FF: synthetic method
   public final dl$a b() {
      return this.L();
   }

   public final gk$x$a b(double var1) {
      this.b |= 8192;
      this.p = var1;
      return this;
   }

   public final gk$x$a b(int var1) {
      this.b |= 8;
      this.f = var1;
      return this;
   }

   public final gk$x$a b(long var1) {
      this.b |= 64;
      this.i = var1;
      return this;
   }

   public final gk$x$a b(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 512;
         this.l = var1;
         return this;
      }
   }

   public final gk$t c(int var1) {
      return (gk$t)this.g.get(var1);
   }

   public final gk$x$a c(long var1) {
      this.b |= 128;
      this.j = var1;
      return this;
   }

   public final gk$x$a c(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 16384;
         this.q = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.L();
   }

   public final gk$x$a d(int var1) {
      this.M();
      this.g.remove(var1);
      return this;
   }

   public final gk$x$a d(long var1) {
      this.b |= 256;
      this.k = var1;
      return this;
   }

   public final gk$x$a d(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 65536;
         this.s = var1;
         return this;
      }
   }

   public final boolean d() {
      for(int var1 = 0; var1 < this.g(); ++var1) {
         if(!this.c(var1).d()) {
            return false;
         }
      }

      return true;
   }

   public final gk$x$a e(int var1) {
      this.b |= 32;
      this.h = var1;
      return this;
   }

   public final gk$x$a e(long var1) {
      this.b |= 4096;
      this.o = var1;
      return this;
   }

   public final gk$x$a e(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 524288;
         this.v = var1;
         return this;
      }
   }

   public final gk$x e() {
      gk$x var4 = new gk$x(this, (byte)0);
      int var3 = this.b;
      byte var2 = 0;
      if((var3 & 1) == 1) {
         var2 = 1;
      }

      gk$x.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$x.a(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$x.a(var4, this.e);
      var1 = var5;
      if((var3 & 8) == 8) {
         var1 = var5 | 8;
      }

      gk$x.b(var4, this.f);
      if((this.b & 16) == 16) {
         this.g = Collections.unmodifiableList(this.g);
         this.b &= -17;
      }

      gk$x.a(var4, this.g);
      var5 = var1;
      if((var3 & 32) == 32) {
         var5 = var1 | 16;
      }

      gk$x.c(var4, this.h);
      var1 = var5;
      if((var3 & 64) == 64) {
         var1 = var5 | 32;
      }

      gk$x.b(var4, this.i);
      var5 = var1;
      if((var3 & 128) == 128) {
         var5 = var1 | 64;
      }

      gk$x.c(var4, this.j);
      var1 = var5;
      if((var3 & 256) == 256) {
         var1 = var5 | 128;
      }

      gk$x.d(var4, this.k);
      var5 = var1;
      if((var3 & 512) == 512) {
         var5 = var1 | 256;
      }

      gk$x.b(var4, this.l);
      var1 = var5;
      if((var3 & 1024) == 1024) {
         var1 = var5 | 512;
      }

      gk$x.d(var4, this.m);
      var5 = var1;
      if((var3 & 2048) == 2048) {
         var5 = var1 | 1024;
      }

      gk$x.a(var4, this.n);
      var1 = var5;
      if((var3 & 4096) == 4096) {
         var1 = var5 | 2048;
      }

      gk$x.e(var4, this.o);
      var5 = var1;
      if((var3 & 8192) == 8192) {
         var5 = var1 | 4096;
      }

      gk$x.b(var4, this.p);
      var1 = var5;
      if((var3 & 16384) == 16384) {
         var1 = var5 | 8192;
      }

      gk$x.c(var4, this.q);
      var5 = var1;
      if((var3 & '耀') == '耀') {
         var5 = var1 | 16384;
      }

      gk$x.a(var4, this.r);
      var1 = var5;
      if((var3 & 65536) == 65536) {
         var1 = var5 | '耀';
      }

      gk$x.d(var4, this.s);
      var5 = var1;
      if((var3 & 131072) == 131072) {
         var5 = var1 | 65536;
      }

      gk$x.e(var4, this.t);
      var1 = var5;
      if((var3 & 262144) == 262144) {
         var1 = var5 | 131072;
      }

      gk$x.f(var4, this.u);
      var5 = var1;
      if((var3 & 524288) == 524288) {
         var5 = var1 | 262144;
      }

      gk$x.e(var4, this.v);
      var1 = var5;
      if((1048576 & var3) == 1048576) {
         var1 = var5 | 524288;
      }

      gk$x.f(var4, this.w);
      var5 = var1;
      if((2097152 & var3) == 2097152) {
         var5 = var1 | 1048576;
      }

      gk$x.g(var4, this.x);
      var1 = var5;
      if((4194304 & var3) == 4194304) {
         var1 = var5 | 2097152;
      }

      gk$x.h(var4, this.y);
      var5 = var1;
      if((var3 & 8388608) == 8388608) {
         var5 = var1 | 4194304;
      }

      gk$x.i(var4, this.z);
      gk$x.g(var4, var5);
      return var4;
   }

   public final gk$x$a f(int var1) {
      this.b |= 1024;
      this.m = var1;
      return this;
   }

   public final gk$x$a f(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 1048576;
         this.w = var1;
         return this;
      }
   }

   public final List f() {
      return Collections.unmodifiableList(this.g);
   }

   public final int g() {
      return this.g.size();
   }

   public final gk$x$a g(int var1) {
      this.b |= 131072;
      this.t = var1;
      return this;
   }

   public final gk$x$a g(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 2097152;
         this.x = var1;
         return this;
      }
   }

   public final gk$x$a h() {
      this.g = Collections.emptyList();
      this.b &= -17;
      return this;
   }

   public final gk$x$a h(int var1) {
      this.b |= 262144;
      this.u = var1;
      return this;
   }

   public final gk$x$a h(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 4194304;
         this.y = var1;
         return this;
      }
   }

   public final gk$x$a i() {
      this.b &= -4097;
      this.o = 0L;
      return this;
   }

   public final gk$x$a i(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 8388608;
         this.z = var1;
         return this;
      }
   }

   public final gk$x$a j() {
      this.b &= -8193;
      this.p = 0.0D;
      return this;
   }

   public final gk$x$a k() {
      this.b &= -16385;
      this.q = gk$x.c().H();
      return this;
   }

   public final gk$x$a l() {
      this.b &= -32769;
      this.r = false;
      return this;
   }

   public final boolean m() {
      return (this.b & 65536) == 65536;
   }

   public final String n() {
      Object var1 = this.s;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.s = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }

   public final gk$x$a o() {
      this.b &= -65537;
      this.s = gk$x.c().L();
      return this;
   }

   public final boolean p() {
      return (this.b & 131072) == 131072;
   }

   public final int q() {
      return this.t;
   }

   public final gk$x$a r() {
      this.b &= -131073;
      this.t = 0;
      return this;
   }

   public final boolean s() {
      return (this.b & 262144) == 262144;
   }

   public final int t() {
      return this.u;
   }

   public final gk$x$a u() {
      this.b &= -262145;
      this.u = 0;
      return this;
   }

   public final boolean v() {
      return (this.b & 524288) == 524288;
   }

   public final String w() {
      Object var1 = this.v;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.v = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }

   public final gk$x$a x() {
      this.b &= -524289;
      this.v = gk$x.c().R();
      return this;
   }

   public final boolean y() {
      return (this.b & 1048576) == 1048576;
   }

   public final String z() {
      Object var1 = this.w;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.w = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }
}
