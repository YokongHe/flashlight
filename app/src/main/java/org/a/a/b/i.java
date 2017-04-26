package org.a.a.b;

public final class i implements d {
   // $FF: synthetic field
   final e a;

   protected i(e var1) {
      this.a = var1;
   }

   private d b(org.a.a.g.d var1) {
      var1.b(this.a.b(var1));
      return (d)this.a.a.get(var1.a());
   }

   public final Object a(org.a.a.g.d var1) {
      try {
         Object var2 = this.b(var1).a(var1);
         return var2;
      } catch (Exception var3) {
         throw new org.a.a.b.j((String)null, (org.a.a.c.a)null, "Can\'t construct a java object for " + var1.d() + "; exception=" + var3.getMessage(), var1.f(), var3);
      }
   }

   public final void a(org.a.a.g.d var1, Object var2) {
      try {
         this.b(var1).a(var1, var2);
      } catch (Exception var3) {
         throw new org.a.a.b.j((String)null, (org.a.a.c.a)null, "Can\'t construct a second step for a java object for " + var1.d() + "; exception=" + var3.getMessage(), var1.f(), var3);
      }
   }
}
