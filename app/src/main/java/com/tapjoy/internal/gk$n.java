package com.tapjoy.internal;

import com.tapjoy.internal.df;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.di;
import com.tapjoy.internal.dj;
import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dq;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$n$a;
import com.tapjoy.internal.gk$o;
import com.tapjoy.internal.gk$x;

public final class gk$n extends dl implements gk$o {
   public static ds b = new df() {
      // $FF: synthetic method
      public final Object a(di var1, dk var2) {
         return new gk$n(var1, var2, (byte)0);
      }
   };
   private static final gk$n c;
   private final dh d;
   private int e;
   private gk$l f;
   private gk$a g;
   private gk$x h;
   private byte i;
   private int j;

   static {
      gk$n var0 = new gk$n();
      c = var0;
      var0.l();
   }

   private gk$n() {
      this.i = -1;
      this.j = -1;
      this.d = dh.a;
   }

   private gk$n(di param1, dk param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   gk$n(di var1, dk var2, byte var3) {
      this(var1, var2);
   }

   private gk$n(dl$a var1) {
      super((byte)0);
      this.i = -1;
      this.j = -1;
      this.d = var1.c();
   }

   // $FF: synthetic method
   gk$n(dl$a var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int a(gk$n var0, int var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static dh a(gk$n var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static gk$a a(gk$n var0, gk$a var1) {
      var0.g = var1;
      return var1;
   }

   // $FF: synthetic method
   static gk$l a(gk$n var0, gk$l var1) {
      var0.f = var1;
      return var1;
   }

   // $FF: synthetic method
   static gk$x a(gk$n var0, gk$x var1) {
      var0.h = var1;
      return var1;
   }

   public static gk$n c() {
      return c;
   }

   public static gk$n$a k() {
      return gk$n$a.f();
   }

   private void l() {
      this.f = gk$l.c();
      this.g = gk$a.c();
      this.h = gk$x.c();
   }

   public final void a(dj var1) {
      this.b();
      if((this.e & 1) == 1) {
         var1.a(1, (dq)this.f);
      }

      if((this.e & 2) == 2) {
         var1.a(2, (dq)this.g);
      }

      if((this.e & 4) == 4) {
         var1.a(3, (dq)this.h);
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
            var2 = dj.b(1, (dq)this.f) + 0;
         }

         var1 = var2;
         if((this.e & 2) == 2) {
            var1 = var2 + dj.b(2, (dq)this.g);
         }

         var2 = var1;
         if((this.e & 4) == 4) {
            var2 = var1 + dj.b(3, (dq)this.h);
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
      } else if(this.i() && !this.h.d()) {
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
         if(!(var1 instanceof gk$n)) {
            return super.equals(var1);
         }

         gk$n var5 = (gk$n)var1;
         boolean var2;
         if(this.e() == var5.e()) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3 = var2;
         if(this.e()) {
            if(var2 && this.f.equals(var5.f)) {
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
            if(var2 && this.g.equals(var5.g)) {
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

         if(!var4 || !this.h.equals(var5.h)) {
            return false;
         }
      }

      return true;
   }

   public final gk$l f() {
      return this.f;
   }

   public final boolean g() {
      return (this.e & 2) == 2;
   }

   public final gk$a h() {
      return this.g;
   }

   public final int hashCode() {
      if(this.a != 0) {
         return this.a;
      } else {
         int var2 = gk$n.class.hashCode() + 779;
         int var1 = var2;
         if(this.e()) {
            var1 = (var2 * 37 + 1) * 53 + this.f.hashCode();
         }

         var2 = var1;
         if(this.g()) {
            var2 = (var1 * 37 + 2) * 53 + this.g.hashCode();
         }

         var1 = var2;
         if(this.i()) {
            var1 = (var2 * 37 + 3) * 53 + this.h.hashCode();
         }

         var1 = var1 * 29 + this.d.hashCode();
         this.a = var1;
         return var1;
      }
   }

   public final boolean i() {
      return (this.e & 4) == 4;
   }

   public final gk$x j() {
      return this.h;
   }
}
