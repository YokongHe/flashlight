package com.tapjoy.internal;

import com.tapjoy.internal.df;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.di;
import com.tapjoy.internal.dj;
import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.gk$a$a;
import com.tapjoy.internal.gk$b;

public final class gk$a extends dl implements gk$b {
   public static ds b = new df() {
      // $FF: synthetic method
      public final Object a(di var1, dk var2) {
         return new gk$a(var1, (byte)0);
      }
   };
   private static final gk$a c;
   private final dh d;
   private int e;
   private Object f;
   private int g;
   private Object h;
   private Object i;
   private Object j;
   private byte k;
   private int l;

   static {
      gk$a var0 = new gk$a();
      c = var0;
      var0.u();
   }

   private gk$a() {
      this.k = -1;
      this.l = -1;
      this.d = dh.a;
   }

   private gk$a(di param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   gk$a(di var1, byte var2) {
      this(var1);
   }

   private gk$a(dl$a var1) {
      super((byte)0);
      this.k = -1;
      this.l = -1;
      this.d = var1.c();
   }

   // $FF: synthetic method
   gk$a(dl$a var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int a(gk$a var0, int var1) {
      var0.g = var1;
      return var1;
   }

   public static gk$a$a a(gk$a var0) {
      return gk$a$a.i().a(var0);
   }

   // $FF: synthetic method
   static Object a(gk$a var0, Object var1) {
      var0.f = var1;
      return var1;
   }

   // $FF: synthetic method
   static int b(gk$a var0, int var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object b(gk$a var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static Object b(gk$a var0, Object var1) {
      var0.h = var1;
      return var1;
   }

   public static gk$a c() {
      return c;
   }

   // $FF: synthetic method
   static Object c(gk$a var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static Object c(gk$a var0, Object var1) {
      var0.i = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object d(gk$a var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static Object d(gk$a var0, Object var1) {
      var0.j = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object e(gk$a var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static dh f(gk$a var0) {
      return var0.d;
   }

   public static gk$a$a o() {
      return gk$a$a.i();
   }

   private dh q() {
      Object var1 = this.f;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.f = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private dh r() {
      Object var1 = this.h;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.h = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private dh s() {
      Object var1 = this.i;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.i = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private dh t() {
      Object var1 = this.j;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.j = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private void u() {
      this.f = "";
      this.g = 0;
      this.h = "";
      this.i = "";
      this.j = "";
   }

   public final void a(dj var1) {
      this.b();
      if((this.e & 1) == 1) {
         var1.a(1, (dh)this.q());
      }

      if((this.e & 2) == 2) {
         var1.a(2, this.g);
      }

      if((this.e & 4) == 4) {
         var1.a(3, (dh)this.r());
      }

      if((this.e & 8) == 8) {
         var1.a(4, (dh)this.s());
      }

      if((this.e & 16) == 16) {
         var1.a(5, (dh)this.t());
      }

      var1.b(this.d);
   }

   public final int b() {
      int var1 = this.l;
      if(var1 != -1) {
         return var1;
      } else {
         int var2 = 0;
         if((this.e & 1) == 1) {
            var2 = dj.b(1, (dh)this.q()) + 0;
         }

         var1 = var2;
         if((this.e & 2) == 2) {
            var1 = var2 + dj.b(2, this.g);
         }

         var2 = var1;
         if((this.e & 4) == 4) {
            var2 = var1 + dj.b(3, (dh)this.r());
         }

         var1 = var2;
         if((this.e & 8) == 8) {
            var1 = var2 + dj.b(4, (dh)this.s());
         }

         var2 = var1;
         if((this.e & 16) == 16) {
            var2 = var1 + dj.b(5, (dh)this.t());
         }

         var1 = var2 + this.d.a();
         this.l = var1;
         return var1;
      }
   }

   public final boolean d() {
      byte var1 = this.k;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         this.k = 1;
         return true;
      }
   }

   public final boolean e() {
      return (this.e & 1) == 1;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof gk$a)) {
            return super.equals(var1);
         }

         gk$a var5 = (gk$a)var1;
         boolean var2;
         if(this.e() == var5.e()) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3 = var2;
         if(this.e()) {
            if(var2 && this.f().equals(var5.f())) {
               var3 = true;
            } else {
               var3 = false;
            }
         }

         if(var3 && this.g() == var5.g()) {
            var2 = true;
         } else {
            var2 = false;
         }

         var3 = var2;
         if(this.g()) {
            if(var2 && this.g == var5.g) {
               var3 = true;
            } else {
               var3 = false;
            }
         }

         if(var3 && this.i() == var5.i()) {
            var2 = true;
         } else {
            var2 = false;
         }

         var3 = var2;
         if(this.i()) {
            if(var2 && this.j().equals(var5.j())) {
               var3 = true;
            } else {
               var3 = false;
            }
         }

         if(var3 && this.k() == var5.k()) {
            var2 = true;
         } else {
            var2 = false;
         }

         var3 = var2;
         if(this.k()) {
            if(var2 && this.l().equals(var5.l())) {
               var3 = true;
            } else {
               var3 = false;
            }
         }

         boolean var4;
         if(var3 && this.m() == var5.m()) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(!this.m()) {
            return var4;
         }

         if(!var4 || !this.n().equals(var5.n())) {
            return false;
         }
      }

      return true;
   }

   public final String f() {
      Object var1 = this.f;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.f = var2;
         }

         return var2;
      }
   }

   public final boolean g() {
      return (this.e & 2) == 2;
   }

   public final int h() {
      return this.g;
   }

   public final int hashCode() {
      if(this.a != 0) {
         return this.a;
      } else {
         int var2 = gk$a.class.hashCode() + 779;
         int var1 = var2;
         if(this.e()) {
            var1 = (var2 * 37 + 1) * 53 + this.f().hashCode();
         }

         var2 = var1;
         if(this.g()) {
            var2 = (var1 * 37 + 2) * 53 + this.g;
         }

         var1 = var2;
         if(this.i()) {
            var1 = (var2 * 37 + 3) * 53 + this.j().hashCode();
         }

         var2 = var1;
         if(this.k()) {
            var2 = (var1 * 37 + 4) * 53 + this.l().hashCode();
         }

         var1 = var2;
         if(this.m()) {
            var1 = (var2 * 37 + 5) * 53 + this.n().hashCode();
         }

         var1 = var1 * 29 + this.d.hashCode();
         this.a = var1;
         return var1;
      }
   }

   public final boolean i() {
      return (this.e & 4) == 4;
   }

   public final String j() {
      Object var1 = this.h;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.h = var2;
         }

         return var2;
      }
   }

   public final boolean k() {
      return (this.e & 8) == 8;
   }

   public final String l() {
      Object var1 = this.i;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.i = var2;
         }

         return var2;
      }
   }

   public final boolean m() {
      return (this.e & 16) == 16;
   }

   public final String n() {
      Object var1 = this.j;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.j = var2;
         }

         return var2;
      }
   }

   public final gk$a$a p() {
      return gk$a$a.i().a(this);
   }
}
