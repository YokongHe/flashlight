package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dv;
import com.tapjoy.internal.gk$p;
import com.tapjoy.internal.gk$q;

public final class gk$p$a extends dl$a implements gk$q {
   private int b;
   private Object c = "";
   private Object d = "";
   private Object e = "";

   // $FF: synthetic method
   static gk$p$a g() {
      return new gk$p$a();
   }

   private gk$p$a h() {
      return (new gk$p$a()).a(this.f());
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.h();
   }

   public final gk$p$a a(gk$p var1) {
      if(var1 == gk$p.c()) {
         return this;
      } else {
         if(var1.e()) {
            this.b |= 1;
            this.c = gk$p.b(var1);
         }

         if(var1.g()) {
            this.b |= 2;
            this.d = gk$p.c(var1);
         }

         if(var1.i()) {
            this.b |= 4;
            this.e = gk$p.d(var1);
         }

         super.a = super.a.a(gk$p.e(var1));
         return this;
      }
   }

   public final gk$p$a a(String var1) {
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
      return this.h();
   }

   public final gk$p$a b(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 2;
         this.d = var1;
         return this;
      }
   }

   public final gk$p$a c(String var1) {
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
      return this.h();
   }

   public final boolean d() {
      return true;
   }

   public final gk$p e() {
      gk$p var1 = this.f();
      if(!var1.d()) {
         throw new dv();
      } else {
         return var1;
      }
   }

   public final gk$p f() {
      byte var2 = 1;
      gk$p var4 = new gk$p(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var2 = 0;
      }

      gk$p.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$p.b(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$p.c(var4, this.e);
      gk$p.a(var4, var5);
      return var4;
   }
}
