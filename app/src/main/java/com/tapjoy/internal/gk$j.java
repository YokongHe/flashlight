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
import com.tapjoy.internal.gk$j$a;
import com.tapjoy.internal.gk$k;

public final class gk$j extends dl implements gk$k {
   public static ds b = new df() {
      // $FF: synthetic method
      public final Object a(di var1, dk var2) {
         return new gk$j(var1, (byte)0);
      }
   };
   private static final gk$j c;
   private final dh d;
   private int e;
   private Object f;
   private long g;
   private byte h;
   private int i;

   static {
      gk$j var0 = new gk$j();
      c = var0;
      var0.k();
   }

   private gk$j() {
      this.h = -1;
      this.i = -1;
      this.d = dh.a;
   }

   private gk$j(di param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   gk$j(di var1, byte var2) {
      this(var1);
   }

   private gk$j(dl$a var1) {
      super((byte)0);
      this.h = -1;
      this.i = -1;
      this.d = var1.c();
   }

   // $FF: synthetic method
   gk$j(dl$a var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int a(gk$j var0, int var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static long a(gk$j var0, long var1) {
      var0.g = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object a(gk$j var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static Object a(gk$j var0, Object var1) {
      var0.f = var1;
      return var1;
   }

   // $FF: synthetic method
   static dh b(gk$j var0) {
      return var0.d;
   }

   public static gk$j c() {
      return c;
   }

   public static gk$j$a i() {
      return gk$j$a.f();
   }

   private dh j() {
      Object var1 = this.f;
      if(var1 instanceof String) {
         dh var2 = dh.a((String)var1);
         this.f = var2;
         return var2;
      } else {
         return (dh)var1;
      }
   }

   private void k() {
      this.f = "";
      this.g = 0L;
   }

   public final void a(dj var1) {
      this.b();
      if((this.e & 1) == 1) {
         var1.a(1, (dh)this.j());
      }

      if((this.e & 2) == 2) {
         var1.a(2, this.g);
      }

      var1.b(this.d);
   }

   public final int b() {
      int var1 = this.i;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if((this.e & 1) == 1) {
            var1 = dj.b(1, (dh)this.j()) + 0;
         }

         int var2 = var1;
         if((this.e & 2) == 2) {
            var2 = var1 + dj.b(2, this.g);
         }

         var1 = var2 + this.d.a();
         this.i = var1;
         return var1;
      }
   }

   public final boolean d() {
      byte var1 = this.h;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.e()) {
         this.h = 0;
         return false;
      } else if(!this.g()) {
         this.h = 0;
         return false;
      } else {
         this.h = 1;
         return true;
      }
   }

   public final boolean e() {
      return (this.e & 1) == 1;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof gk$j)) {
            return super.equals(var1);
         }

         gk$j var5 = (gk$j)var1;
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

         boolean var4;
         if(var3 && this.g() == var5.g()) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(!this.g()) {
            return var4;
         }

         if(!var4 || this.g != var5.g) {
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
         int var2 = gk$j.class.hashCode() + 779;
         int var1 = var2;
         if(this.e()) {
            var1 = (var2 * 37 + 1) * 53 + this.f().hashCode();
         }

         var2 = var1;
         if(this.g()) {
            var2 = (var1 * 37 + 2) * 53 + dm.a(this.g);
         }

         var1 = var2 * 29 + this.d.hashCode();
         this.a = var1;
         return var1;
      }
   }
}
