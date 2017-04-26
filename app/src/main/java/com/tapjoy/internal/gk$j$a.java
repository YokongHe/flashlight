package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.gk$j;
import com.tapjoy.internal.gk$k;

public final class gk$j$a extends dl$a implements gk$k {
   private int b;
   private Object c = "";
   private long d;

   // $FF: synthetic method
   static gk$j$a f() {
      return new gk$j$a();
   }

   private gk$j$a g() {
      gk$j$a var1 = new gk$j$a();
      gk$j var2 = this.e();
      if(var2 == gk$j.c()) {
         return var1;
      } else {
         if(var2.e()) {
            var1.b |= 1;
            var1.c = gk$j.a(var2);
         }

         if(var2.g()) {
            var1.a(var2.h());
         }

         var1.a = var1.a.a(gk$j.b(var2));
         return var1;
      }
   }

   // $FF: synthetic method
   public final de$a a() {
      return this.g();
   }

   public final gk$j$a a(long var1) {
      this.b |= 2;
      this.d = var1;
      return this;
   }

   public final gk$j$a a(String var1) {
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

   final gk$j e() {
      byte var1 = 1;
      gk$j var4 = new gk$j(this, (byte)0);
      int var3 = this.b;
      if((var3 & 1) != 1) {
         var1 = 0;
      }

      gk$j.a(var4, this.c);
      int var2 = var1;
      if((var3 & 2) == 2) {
         var2 = var1 | 2;
      }

      gk$j.a(var4, this.d);
      gk$j.a(var4, var2);
      return var4;
   }
}
