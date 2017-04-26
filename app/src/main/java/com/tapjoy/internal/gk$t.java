package com.tapjoy.internal;

import com.tapjoy.internal.df;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.di;
import com.tapjoy.internal.dj;
import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dm;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.gk$t$a;
import com.tapjoy.internal.gk$w;

public final class gk$t extends dl implements gk$w {
   public static ds b = new df() {
      // $FF: synthetic method
      public final Object a(di var1, dk var2) {
         return new gk$t(var1, (byte)0);
      }
   };
   private static final gk$t c;
   private final dh d;
   private int e;
   private Object f;
   private long g;
   private long h;
   private byte i;
   private int j;

   static {
      gk$t var0 = new gk$t();
      c = var0;
      var0.m();
   }

   private gk$t() {
      this.i = -1;
      this.j = -1;
      this.d = dh.a;
   }

   private gk$t(di param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   gk$t(di var1, byte var2) {
      this(var1);
   }

   private gk$t(dl$a var1) {
      super((byte)0);
      this.i = -1;
      this.j = -1;
      this.d = var1.c();
   }

   // $FF: synthetic method
   gk$t(dl$a var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int a(gk$t var0, int var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static long a(gk$t var0, long var1) {
      var0.g = var1;
      return var1;
   }

   public static gk$t$a a(gk$t var0) {
      return gk$t$a.f().a(var0);
   }

   // $FF: synthetic method
   static Object a(gk$t var0, Object var1) {
      var0.f = var1;
      return var1;
   }

   // $FF: synthetic method
   static long b(gk$t var0, long var1) {
      var0.h = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object b(gk$t var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static dh c(gk$t var0) {
      return var0.d;
   }

   public static gk$t c() {
      return c;
   }

   public static gk$t$a k() {
      return gk$t$a.f();
   }

   private dh l() {
      Object var1 = this.f;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.f = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private void m() {
      this.f = "";
      this.g = 0L;
      this.h = 0L;
   }

   public final void a(dj var1) {
      this.b();
      if((this.e & 1) == 1) {
         var1.a(1, (dh)this.l());
      }

      if((this.e & 2) == 2) {
         var1.a(2, this.g);
      }

      if((this.e & 4) == 4) {
         var1.a(3, this.h);
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
            var2 = dj.b(1, (dh)this.l()) + 0;
         }

         var1 = var2;
         if((this.e & 2) == 2) {
            var1 = var2 + dj.b(2, this.g);
         }

         var2 = var1;
         if((this.e & 4) == 4) {
            var2 = var1 + dj.b(3, this.h);
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
      } else if(!this.e()) {
         this.i = 0;
         return false;
      } else if(!this.g()) {
         this.i = 0;
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
         if(!(var1 instanceof gk$t)) {
            return super.equals(var1);
         }

         gk$t var5 = (gk$t)var1;
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

         boolean var4;
         if(var3 && this.i() == var5.i()) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(!this.i()) {
            return var4;
         }

         if(!var4 || this.h != var5.h) {
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

   public final long h() {
      return this.g;
   }

   public final int hashCode() {
      if(this.a != 0) {
         return this.a;
      } else {
         int var2 = gk$t.class.hashCode() + 779;
         int var1 = var2;
         if(this.e()) {
            var1 = (var2 * 37 + 1) * 53 + this.f().hashCode();
         }

         var2 = var1;
         if(this.g()) {
            var2 = (var1 * 37 + 2) * 53 + dm.a(this.g);
         }

         var1 = var2;
         if(this.i()) {
            var1 = (var2 * 37 + 3) * 53 + dm.a(this.h);
         }

         var1 = var1 * 29 + this.d.hashCode();
         this.a = var1;
         return var1;
      }
   }

   public final boolean i() {
      return (this.e & 4) == 4;
   }

   public final long j() {
      return this.h;
   }
}
