package com.tapjoy.internal;

import com.tapjoy.internal.df;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.di;
import com.tapjoy.internal.dj;
import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.gk$p$a;
import com.tapjoy.internal.gk$q;

public final class gk$p extends dl implements gk$q {
   public static ds b = new df() {
      // $FF: synthetic method
      public final Object a(di var1, dk var2) {
         return new gk$p(var1, (byte)0);
      }
   };
   private static final gk$p c;
   private final dh d;
   private int e;
   private Object f;
   private Object g;
   private Object h;
   private byte i;
   private int j;

   static {
      gk$p var0 = new gk$p();
      c = var0;
      var0.p();
   }

   private gk$p() {
      this.i = -1;
      this.j = -1;
      this.d = dh.a;
   }

   private gk$p(di param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   gk$p(di var1, byte var2) {
      this(var1);
   }

   private gk$p(dl$a var1) {
      super((byte)0);
      this.i = -1;
      this.j = -1;
      this.d = var1.c();
   }

   // $FF: synthetic method
   gk$p(dl$a var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int a(gk$p var0, int var1) {
      var0.e = var1;
      return var1;
   }

   public static gk$p$a a(gk$p var0) {
      return gk$p$a.g().a(var0);
   }

   // $FF: synthetic method
   static Object a(gk$p var0, Object var1) {
      var0.f = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object b(gk$p var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static Object b(gk$p var0, Object var1) {
      var0.g = var1;
      return var1;
   }

   public static gk$p c() {
      return c;
   }

   // $FF: synthetic method
   static Object c(gk$p var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static Object c(gk$p var0, Object var1) {
      var0.h = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object d(gk$p var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static dh e(gk$p var0) {
      return var0.d;
   }

   public static gk$p$a k() {
      return gk$p$a.g();
   }

   private dh m() {
      Object var1 = this.f;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.f = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private dh n() {
      Object var1 = this.g;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.g = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private dh o() {
      Object var1 = this.h;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.h = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private void p() {
      this.f = "";
      this.g = "";
      this.h = "";
   }

   public final void a(dj var1) {
      this.b();
      if((this.e & 1) == 1) {
         var1.a(1, (dh)this.m());
      }

      if((this.e & 2) == 2) {
         var1.a(2, (dh)this.n());
      }

      if((this.e & 4) == 4) {
         var1.a(3, (dh)this.o());
      }

      var1.b(this.d);
   }

   public final int b() {
      int var1 = this.j;
      if(var1 != -1) {
         return var1;
      } else {
         int var2 = 0;
         if((this.e & 1) == 1) {
            var2 = dj.b(1, (dh)this.m()) + 0;
         }

         var1 = var2;
         if((this.e & 2) == 2) {
            var1 = var2 + dj.b(2, (dh)this.n());
         }

         var2 = var1;
         if((this.e & 4) == 4) {
            var2 = var1 + dj.b(3, (dh)this.o());
         }

         var1 = var2 + this.d.a();
         this.j = var1;
         return var1;
      }
   }

   public final boolean d() {
      byte var1 = this.i;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         this.i = 1;
         return true;
      }
   }

   public final boolean e() {
      return (this.e & 1) == 1;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof gk$p)) {
            return super.equals(var1);
         }

         gk$p var5 = (gk$p)var1;
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
            if(var2 && this.h().equals(var5.h())) {
               var3 = true;
            } else {
               var3 = false;
            }
         }

         boolean var4;
         if(var3 && this.i() == var5.i()) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(!this.i()) {
            return var4;
         }

         if(!var4 || !this.j().equals(var5.j())) {
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

   public final String h() {
      Object var1 = this.g;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.g = var2;
         }

         return var2;
      }
   }

   public final int hashCode() {
      if(this.a != 0) {
         return this.a;
      } else {
         int var2 = gk$p.class.hashCode() + 779;
         int var1 = var2;
         if(this.e()) {
            var1 = (var2 * 37 + 1) * 53 + this.f().hashCode();
         }

         var2 = var1;
         if(this.g()) {
            var2 = (var1 * 37 + 2) * 53 + this.h().hashCode();
         }

         var1 = var2;
         if(this.i()) {
            var1 = (var2 * 37 + 3) * 53 + this.j().hashCode();
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

   public final gk$p$a l() {
      return gk$p$a.g().a(this);
   }
}
