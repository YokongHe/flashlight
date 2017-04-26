package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$b;

public final class gk$a$a extends dl$a implements gk$b {
   private int b;
   private Object c = "";
   private int d;
   private Object e = "";
   private Object f = "";
   private Object g = "";

   // $FF: synthetic method
   static gk$a$a i() {
      return new gk$a$a();
   }

   private gk$a$a j() {
      return (new gk$a$a()).a(this.e());
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.j();
   }

   public final gk$a$a a(int var1) {
      this.b |= 2;
      this.d = var1;
      return this;
   }

   public final gk$a$a a(gk$a var1) {
      if(var1 == gk$a.c()) {
         return this;
      } else {
         if(var1.e()) {
            this.b |= 1;
            this.c = gk$a.b(var1);
         }

         if(var1.g()) {
            this.a(var1.h());
         }

         if(var1.i()) {
            this.b |= 4;
            this.e = gk$a.c(var1);
         }

         if(var1.k()) {
            this.b |= 8;
            this.f = gk$a.d(var1);
         }

         if(var1.m()) {
            this.b |= 16;
            this.g = gk$a.e(var1);
         }

         super.a = super.a.a(gk$a.f(var1));
         return this;
      }
   }

   public final gk$a$a a(String var1) {
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
      return this.j();
   }

   public final gk$a$a b(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 4;
         this.e = var1;
         return this;
      }
   }

   public final gk$a$a c(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 8;
         this.f = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.j();
   }

   public final gk$a$a d(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 16;
         this.g = var1;
         return this;
      }
   }

   public final boolean d() {
      return true;
   }

   public final gk$a e() {
      byte var2 = 1;
      gk$a var4 = new gk$a(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var2 = 0;
      }

      gk$a.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$a.a(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$a.b(var4, this.e);
      var1 = var5;
      if((var3 & 8) == 8) {
         var1 = var5 | 8;
      }

      gk$a.c(var4, this.f);
      var5 = var1;
      if((var3 & 16) == 16) {
         var5 = var1 | 16;
      }

      gk$a.d(var4, this.g);
      gk$a.b(var4, var5);
      return var4;
   }

   public final boolean f() {
      return (this.b & 4) == 4;
   }

   public final String g() {
      Object var1 = this.e;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.e = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }

   public final gk$a$a h() {
      this.b &= -5;
      this.e = gk$a.c().j();
      return this;
   }
}
