package org.a.a;

public final class g {
   protected final org.a.a.k.a a;
   protected org.a.a.b.b b;
   protected org.a.a.j.c c;
   protected org.a.a.a d;
   private String e;

   public g() {
      this(new b.e(), new org.a.a.j.c(), new a(), new org.a.a.k.a());
   }

   private g(org.a.a.b.b var1, org.a.a.j.c var2, org.a.a.a var3, org.a.a.k.a var4) {
      if(!var1.b()) {
         var1.a(var2.a());
      } else if(!var2.b()) {
         var2.a(var1.a());
      }

      this.b = var1;
      var2.a(var3.b());
      var2.a(var3.a());
      var2.a().a(var3.c());
      var2.a(var3.d());
      this.c = var2;
      this.d = var3;
      this.a = var4;
      this.e = "Yaml:" + System.identityHashCode(this);
   }

   public final Object a(String var1) {
      org.a.a.a.a var2 = new a.a(new org.a.a.h.c(new org.a.a.i.b(var1)), this.a);
      this.b.a(var2);
      return this.b.a(Object.class);
   }

   public final String toString() {
      return this.e;
   }
}
