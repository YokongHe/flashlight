package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dv;
import com.tapjoy.internal.gk$t;
import com.tapjoy.internal.gk$u;
import com.tapjoy.internal.gk$v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class gk$u$a extends dl$a implements gk$v {
   private int b;
   private List c = Collections.emptyList();

   // $FF: synthetic method
   static gk$u$a f() {
      return new gk$u$a();
   }

   private gk$u$a g() {
      gk$u$a var1 = new gk$u$a();
      gk$u var2 = this.h();
      if(var2 == gk$u.c()) {
         return var1;
      } else {
         if(!gk$u.a(var2).isEmpty()) {
            if(var1.c.isEmpty()) {
               var1.c = gk$u.a(var2);
               var1.b &= -2;
            } else {
               var1.i();
               var1.c.addAll(gk$u.a(var2));
            }
         }

         var1.a = var1.a.a(gk$u.b(var2));
         return var1;
      }
   }

   private gk$u h() {
      gk$u var2 = new gk$u(this, (byte)0);
      int var1 = this.b;
      if((this.b & 1) == 1) {
         this.c = Collections.unmodifiableList(this.c);
         this.b &= -2;
      }

      gk$u.a(var2, this.c);
      return var2;
   }

   private void i() {
      if((this.b & 1) != 1) {
         this.c = new ArrayList(this.c);
         this.b |= 1;
      }

   }

   // $FF: synthetic method
   public final de$a a() {
      return this.g();
   }

   public final gk$u$a a(Iterable var1) {
      this.i();
      de$a.a(var1, this.c);
      return this;
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
      for(int var1 = 0; var1 < this.c.size(); ++var1) {
         if(!((gk$t)this.c.get(var1)).d()) {
            return false;
         }
      }

      return true;
   }

   public final gk$u e() {
      gk$u var1 = this.h();
      if(!var1.d()) {
         throw new dv();
      } else {
         return var1;
      }
   }
}
