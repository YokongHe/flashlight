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
import com.tapjoy.internal.gk$t;
import com.tapjoy.internal.gk$u$a;
import com.tapjoy.internal.gk$v;
import java.util.Collections;
import java.util.List;

public final class gk$u extends dl implements gk$v {
   public static ds b = new df() {
      // $FF: synthetic method
      public final Object a(di var1, dk var2) {
         return new gk$u(var1, var2, (byte)0);
      }
   };
   private static final gk$u c;
   private final dh d;
   private List e;
   private byte f;
   private int g;

   static {
      gk$u var0 = new gk$u();
      c = var0;
      var0.e = Collections.emptyList();
   }

   private gk$u() {
      this.f = -1;
      this.g = -1;
      this.d = dh.a;
   }

   private gk$u(di param1, dk param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   gk$u(di var1, dk var2, byte var3) {
      this(var1, var2);
   }

   private gk$u(dl$a var1) {
      super((byte)0);
      this.f = -1;
      this.g = -1;
      this.d = var1.c();
   }

   // $FF: synthetic method
   gk$u(dl$a var1, byte var2) {
      this(var1);
   }

   public static gk$u a(byte[] var0) {
      return (gk$u)b.a(var0);
   }

   // $FF: synthetic method
   static List a(gk$u var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static List a(gk$u var0, List var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static dh b(gk$u var0) {
      return var0.d;
   }

   public static gk$u c() {
      return c;
   }

   public static gk$u$a f() {
      return gk$u$a.f();
   }

   private int g() {
      return this.e.size();
   }

   public final void a(dj var1) {
      this.b();

      for(int var2 = 0; var2 < this.e.size(); ++var2) {
         var1.a(1, (dq)((dq)this.e.get(var2)));
      }

      var1.b(this.d);
   }

   public final int b() {
      int var1 = this.g;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;

         int var2;
         for(var2 = 0; var1 < this.e.size(); ++var1) {
            var2 += dj.b(1, (dq)((dq)this.e.get(var1)));
         }

         var1 = this.d.a() + var2;
         this.g = var1;
         return var1;
      }
   }

   public final boolean d() {
      boolean var2 = false;
      byte var1 = this.f;
      if(var1 == 1) {
         var2 = true;
      } else if(var1 != 0) {
         for(int var3 = 0; var3 < this.g(); ++var3) {
            if(!((gk$t)this.e.get(var3)).d()) {
               this.f = 0;
               return false;
            }
         }

         this.f = 1;
         return true;
      }

      return var2;
   }

   public final List e() {
      return this.e;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof gk$u)) {
            return super.equals(var1);
         }

         gk$u var2 = (gk$u)var1;
         if(!this.e.equals(var2.e)) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      if(this.a != 0) {
         return this.a;
      } else {
         int var2 = gk$u.class.hashCode() + 779;
         int var1 = var2;
         if(this.g() > 0) {
            var1 = (var2 * 37 + 1) * 53 + this.e.hashCode();
         }

         var1 = var1 * 29 + this.d.hashCode();
         this.a = var1;
         return var1;
      }
   }
}
