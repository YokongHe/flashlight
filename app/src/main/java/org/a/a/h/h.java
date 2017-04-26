package org.a.a.h;

final class h implements org.a.a.h.y {
   // $FF: synthetic field
   final c a;

   private h(c var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   h(c var1, byte var2) {
      this(var1);
   }

   public final org.a.a.d.f a() {
      if(c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.d})) {
         org.a.a.m.d var3 = (org.a.a.m.d) c.a(this.a).b();
         if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.d, org.a.a.m.v.c})) {
            c.b(this.a).a(new h(this.a));
            return (new g(this.a, (byte)0)).a();
         } else {
            c.a(this.a, (org.a.a.h.y)(new h(this.a)));
            return c.a(this.a, var3.g());
         }
      } else {
         org.a.a.m.u var1;
         if(!c.a(this.a).a(new org.a.a.m.v[]{org.a.a.m.v.c})) {
            var1 = c.a(this.a).a();
            throw new b("while parsing a block collection", (org.a.a.c.a) c.d(this.a).a(), "expected <block end>, but found " + var1.c(), var1.f());
         } else {
            var1 = c.a(this.a).b();
            org.a.a.d.m var2 = new org.a.a.d.m(var1.f(), var1.g());
            c.a(this.a, (org.a.a.h.y) c.b(this.a).a());
            c.d(this.a).a();
            return var2;
         }
      }
   }
}
