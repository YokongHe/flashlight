package org.a.a.h;

final class e implements org.a.a.h.y {
   // $FF: synthetic field
   final c a;

   private e(c var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   e(c var1, byte var2) {
      this(var1);
   }

   public final org.a.a.d.f a() {
      org.a.a.m.u var1;
      if(c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.o})) {
         var1 = c.a(this.a).b();
         if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.o, org.a.a.m.v.t, org.a.a.m.v.c})) {
            c.b(this.a).a(new org.a.a.h.f(this.a, (byte)0));
            return c.e(this.a);
         } else {
            c.a(this.a, (org.a.a.h.y)(new org.a.a.h.f(this.a, (byte)0)));
            return c.a(this.a, var1.g());
         }
      } else if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.c})) {
         var1 = c.a(this.a).a();
         throw new b("while parsing a block mapping", (org.a.a.c.a) c.d(this.a).a(), "expected <block end>, but found " + var1.c(), var1.f());
      } else {
         var1 = c.a(this.a).b();
         org.a.a.d.i var2 = new org.a.a.d.i(var1.f(), var1.g());
         c.a(this.a, (org.a.a.h.y) c.b(this.a).a());
         c.d(this.a).a();
         return var2;
      }
   }
}
