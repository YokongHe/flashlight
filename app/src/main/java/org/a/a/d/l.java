package org.a.a.d;

public final class l extends k {
   private final String a;
   private final Character b;
   private final String c;
   private final h d;

   public l(String var1, String var2, h var3, String var4, org.a.a.c.a var5, org.a.a.c.a var6, Character var7) {
      super(var1, var5, var6);
      this.a = var2;
      this.d = var3;
      this.c = var4;
      this.b = var7;
   }

   public final String a() {
      return this.a;
   }

   public final boolean a(g var1) {
      return g.f == var1;
   }

   public final Character b() {
      return this.b;
   }

   public final String c() {
      return this.c;
   }

   protected final String d() {
      return super.d() + ", tag=" + this.a + ", " + this.d + ", value=" + this.c;
   }

   public final h h() {
      return this.d;
   }
}
