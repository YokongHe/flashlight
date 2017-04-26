package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dv;
import com.tapjoy.internal.gk$c;
import com.tapjoy.internal.gk$d;
import com.tapjoy.internal.gk$e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class gk$d$a extends dl$a implements gk$e {
   private int b;
   private List c = Collections.emptyList();

   // $FF: synthetic method
   static gk$d$a g() {
      return new gk$d$a();
   }

   private gk$d$a h() {
      gk$d$a var1 = new gk$d$a();
      gk$d var2 = this.i();
      if(var2 == gk$d.c()) {
         return var1;
      } else {
         if(!gk$d.a(var2).isEmpty()) {
            if(var1.c.isEmpty()) {
               var1.c = gk$d.a(var2);
               var1.b &= -2;
            } else {
               var1.j();
               var1.c.addAll(gk$d.a(var2));
            }
         }

         var1.a = var1.a.a(gk$d.b(var2));
         return var1;
      }
   }

   private gk$d i() {
      gk$d var2 = new gk$d(this, (byte)0);
      int var1 = this.b;
      if((this.b & 1) == 1) {
         this.c = Collections.unmodifiableList(this.c);
         this.b &= -2;
      }

      gk$d.a(var2, this.c);
      return var2;
   }

   private void j() {
      if((this.b & 1) != 1) {
         this.c = new ArrayList(this.c);
         this.b |= 1;
      }

   }

   // $FF: synthetic method
   public final de$a a() {
      return this.h();
   }

   public final gk$d$a a(gk$c var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.j();
         this.c.add(var1);
         return this;
      }
   }

   // $FF: synthetic method
   public final dl$a b() {
      return this.h();
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.h();
   }

   public final boolean d() {
      for(int var1 = 0; var1 < this.f(); ++var1) {
         if(!((gk$c)this.c.get(var1)).d()) {
            return false;
         }
      }

      return true;
   }

   public final gk$d e() {
      gk$d var1 = this.i();
      if(!var1.d()) {
         throw new dv();
      } else {
         return var1;
      }
   }

   public final int f() {
      return this.c.size();
   }
}
