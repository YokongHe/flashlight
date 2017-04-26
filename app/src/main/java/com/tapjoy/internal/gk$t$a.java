package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dv;
import com.tapjoy.internal.gk$t;
import com.tapjoy.internal.gk$w;

public final class gk$t$a extends dl$a implements gk$w {
   private int b;
   private Object c = "";
   private long d;
   private long e;

   // $FF: synthetic method
   static gk$t$a f() {
      return new gk$t$a();
   }

   private gk$t$a g() {
      return (new gk$t$a()).a(this.h());
   }

   private gk$t h() {
      byte var2 = 1;
      gk$t var4 = new gk$t(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var2 = 0;
      }

      gk$t.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$t.a(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$t.b(var4, this.e);
      gk$t.a(var4, var5);
      return var4;
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.g();
   }

   public final gk$t$a a(long var1) {
      this.b |= 2;
      this.d = var1;
      return this;
   }

   public final gk$t$a a(gk$t var1) {
      if(var1 == gk$t.c()) {
         return this;
      } else {
         if(var1.e()) {
            this.b |= 1;
            this.c = gk$t.b(var1);
         }

         if(var1.g()) {
            this.a(var1.h());
         }

         if(var1.i()) {
            this.b(var1.j());
         }

         super.a = super.a.a(gk$t.c(var1));
         return this;
      }
   }

   public final gk$t$a a(String var1) {
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

   public final gk$t$a b(long var1) {
      this.b |= 4;
      this.e = var1;
      return this;
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

      if(var1) {
         if((this.b & 2) == 2) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(var1) {
            return true;
         }
      }

      return false;
   }

   public final gk$t e() {
      gk$t var1 = this.h();
      if(!var1.d()) {
         throw new dv();
      } else {
         return var1;
      }
   }
}
