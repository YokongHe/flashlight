public final class aO extends aS {
   protected aI a;
   private String e = null;
   private int f = 1;
   private aN g;
   private String h;
   private String i;
   private int j;

   aO(aN var1, String var2) {
      super(var2, (aS)null, (aO)null, var1.c);
      this.h = var1.b.h;
      this.i = var1.b.i;
      this.j = var1.b.j;
      this.a = null;
      this.b = this;
      this.g = var1;
   }

   aO(String var1, String var2, String var3, int var4, aL var5, String var6) {
      super(var6, (aS)null, (aO)null, var5);
      this.h = var2;
      this.i = var3;
      this.j = var4;
      this.a = null;
      this.e = var1;
      this.b = this;
   }

   protected final bc a() {
      bc var1 = super.a();
      a(var1, "Application", this.h);
      a(var1, "SchemaVersion", this.i);
      a(var1, "RetentionDays", new Integer(this.j));
      return var1;
   }

   public final String b() {
      return this.e;
   }

   protected final void c() {
      super.c();
      if(this.g != null) {
         this.e = this.g.b();
      }

   }

   public final int d() {
      int var1 = this.f;
      this.f = var1 + 1;
      return var1;
   }
}
