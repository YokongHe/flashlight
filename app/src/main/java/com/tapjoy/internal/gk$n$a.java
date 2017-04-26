package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dv;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$a$a;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$l$a;
import com.tapjoy.internal.gk$n;
import com.tapjoy.internal.gk$o;
import com.tapjoy.internal.gk$x;
import com.tapjoy.internal.gk$x$a;

public final class gk$n$a extends dl$a implements gk$o {
   private int b;
   private gk$l c = gk$l.c();
   private gk$a d = gk$a.c();
   private gk$x e = gk$x.c();

   // $FF: synthetic method
   static gk$n$a f() {
      return new gk$n$a();
   }

   private gk$n$a g() {
      gk$n$a var1 = new gk$n$a();
      gk$n var2 = this.h();
      if(var2 == gk$n.c()) {
         return var1;
      } else {
         if(var2.e()) {
            gk$l var3 = var2.f();
            if((var1.b & 1) == 1 && var1.c != gk$l.c()) {
               var1.c = gk$l.a(var1.c).a(var3).e();
            } else {
               var1.c = var3;
            }

            var1.b |= 1;
         }

         if(var2.g()) {
            gk$a var4 = var2.h();
            if((var1.b & 2) == 2 && var1.d != gk$a.c()) {
               var1.d = gk$a.a(var1.d).a(var4).e();
            } else {
               var1.d = var4;
            }

            var1.b |= 2;
         }

         if(var2.i()) {
            gk$x var5 = var2.j();
            if((var1.b & 4) == 4 && var1.e != gk$x.c()) {
               var1.e = gk$x.a(var1.e).a(var5).e();
            } else {
               var1.e = var5;
            }

            var1.b |= 4;
         }

         var1.a = var1.a.a(gk$n.a(var2));
         return var1;
      }
   }

   private gk$n h() {
      byte var2 = 1;
      gk$n var4 = new gk$n(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var2 = 0;
      }

      gk$n.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$n.a(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$n.a(var4, this.e);
      gk$n.a(var4, var5);
      return var4;
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.g();
   }

   public final gk$n$a a(gk$a$a var1) {
      gk$a var2 = var1.e();
      if(!var2.d()) {
         throw new dv();
      } else {
         this.d = var2;
         this.b |= 2;
         return this;
      }
   }

   public final gk$n$a a(gk$l$a var1) {
      gk$l var2 = var1.e();
      if(!var2.d()) {
         throw new dv();
      } else {
         this.c = var2;
         this.b |= 1;
         return this;
      }
   }

   public final gk$n$a a(gk$x$a var1) {
      gk$x var2 = var1.e();
      if(!var2.d()) {
         throw new dv();
      } else {
         this.e = var2;
         this.b |= 4;
         return this;
      }
   }

   // $FF: synthetic method
   public final dl$a b() {
      return this.g();
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.g();
   }

   public final boolean d() {
      boolean var1;
      if((this.b & 4) == 4) {
         var1 = true;
      } else {
         var1 = false;
      }

      return !var1 || this.e.d();
   }

   public final gk$n e() {
      gk$n var1 = this.h();
      if(!var1.d()) {
         throw new dv();
      } else {
         return var1;
      }
   }
}
