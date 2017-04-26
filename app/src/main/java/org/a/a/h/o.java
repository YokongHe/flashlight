package org.a.a.h;

final class o implements org.a.a.h.y {
   // $FF: synthetic field
   final c a;
   private boolean b;

   public o(c var1, boolean var2) {
      this.a = var1;
      this.b = false;
      this.b = var2;
   }

   public final org.a.a.d.f a() {
      org.a.a.m.u var1;
      if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.k})) {
         if(!this.b) {
            if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.j})) {
               var1 = c.a(this.a).a();
               throw new b("while parsing a flow mapping", (org.a.a.c.a) c.d(this.a).a(), "expected \',\' or \'}\', but got " + var1.c(), var1.f());
            }

            c.a(this.a).b();
         }

         if(c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.o})) {
            var1 = c.a(this.a).b();
            if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.t, org.a.a.m.v.j, org.a.a.m.v.k})) {
               c.b(this.a).a(new org.a.a.h.p(this.a, (byte)0));
               return c.f(this.a);
            }

            c.a(this.a, (org.a.a.h.y)(new org.a.a.h.p(this.a, (byte)0)));
            return c.a(this.a, var1.g());
         }

         if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.k})) {
            c.b(this.a).a(new m(this.a, (byte)0));
            return c.f(this.a);
         }
      }

      var1 = c.a(this.a).b();
      org.a.a.d.i var2 = new org.a.a.d.i(var1.f(), var1.g());
      c.a(this.a, (org.a.a.h.y) c.b(this.a).a());
      c.d(this.a).a();
      return var2;
   }
}
