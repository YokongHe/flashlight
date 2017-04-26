package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.gk$f;
import com.tapjoy.internal.gk$g;
import com.tapjoy.internal.gk$i;

public final class gk$f$a extends dl$a implements gk$g {
   private int b;
   private gk$i c;
   private Object d;
   private Object e;

   private gk$f$a() {
      this.c = gk$i.a;
      this.d = "";
      this.e = "";
   }

   // $FF: synthetic method
   static gk$f$a g() {
      return new gk$f$a();
   }

   private gk$f$a h() {
      return (new gk$f$a()).a(this.e());
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.h();
   }

   public final gk$f$a a(gk$f var1) {
      if(var1 == gk$f.c()) {
         return this;
      } else {
         if(var1.e()) {
            this.a(var1.f());
         }

         if(var1.g()) {
            this.b |= 2;
            this.d = gk$f.b(var1);
         }

         if(var1.i()) {
            this.b |= 4;
            this.e = gk$f.c(var1);
         }

         super.a = super.a.a(gk$f.d(var1));
         return this;
      }
   }

   public final gk$f$a a(gk$i var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 1;
         this.c = var1;
         return this;
      }
   }

   public final gk$f$a a(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 2;
         this.d = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final dl$a b() {
      return this.h();
   }

   public final gk$f$a b(String var1) {
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

   public final gk$f e() {
      byte var2 = 1;
      gk$f var4 = new gk$f(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var2 = 0;
      }

      gk$f.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$f.a(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$f.b(var4, this.e);
      gk$f.a(var4, var5);
      return var4;
   }

   public final gk$f$a f() {
      this.b &= -5;
      this.e = gk$f.c().j();
      return this;
   }
}
