package org.a.a.d;

public abstract class c extends org.a.a.d.k {
   private final String a;
   private final boolean b;
   private final Boolean c;

   public c(String var1, String var2, boolean var3, org.a.a.c.a var4, org.a.a.c.a var5, Boolean var6) {
      super(var1, var4, var5);
      this.a = var2;
      this.b = var3;
      this.c = var6;
   }

   public final String a() {
      return this.a;
   }

   public final boolean b() {
      return this.b;
   }

   public final Boolean c() {
      return this.c;
   }

   protected final String d() {
      return super.d() + ", tag=" + this.a + ", implicit=" + this.b;
   }
}
