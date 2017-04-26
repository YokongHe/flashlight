package org.a.a.h;

import java.util.List;
import java.util.Map;

final class l implements org.a.a.h.y {
   // $FF: synthetic field
   final c a;

   private l(c var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   l(c var1, byte var2) {
      this(var1);
   }

   public final org.a.a.d.f a() {
      Integer[] var1 = null;

      while(c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.h})) {
         c.a(this.a).b();
      }

      if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.q})) {
         org.a.a.c.a var2 = c.a(this.a).a().f();
         List var4 = c.c(this.a);
         List var3 = (List)var4.get(0);
         Map var9 = (Map)var4.get(1);
         if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.i})) {
            throw new b((String)null, (org.a.a.c.a)null, "expected \'<document start>\', but found " + c.a(this.a).a().c(), c.a(this.a).a().f());
         } else {
            org.a.a.c.a var5 = c.a(this.a).b().g();
            if(var3 != null) {
               var1 = (Integer[])var3.toArray(new Integer[2]);
            }

            org.a.a.d.e var8 = new org.a.a.d.e(var2, var5, true, var1, var9);
            c.b(this.a).a(new k(this.a, (byte)0));
            c.a(this.a, (org.a.a.h.y)(new j(this.a, (byte)0)));
            return var8;
         }
      } else {
         org.a.a.m.q var6 = (org.a.a.m.q) c.a(this.a).b();
         org.a.a.d.o var7 = new org.a.a.d.o(var6.f(), var6.g());
         if(!c.b(this.a).b()) {
            throw new org.a.a.c.c("Unexpected end of stream. States left: " + c.b(this.a));
         } else if(!c.d(this.a).b()) {
            throw new org.a.a.c.c("Unexpected end of stream. Marks left: " + c.d(this.a));
         } else {
            c.a(this.a, (org.a.a.h.y)null);
            return var7;
         }
      }
   }
}
