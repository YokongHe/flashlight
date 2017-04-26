public final class aN extends aM {
   protected Boolean a = Boolean.valueOf(false);
   private String e;

   aN(aS var1, String var2) {
      super(var1, var2);
   }

   protected final bc a() {
      bc var1 = super.a();
      a(var1, "RefId", this.e + ".1");
      if(this.a.booleanValue()) {
         a(var1, "Cancel", new Boolean(true));
      }

      return var1;
   }

   final String b() {
      return this.e;
   }

   protected final void c() {
      super.c();
      this.e = this.b.b() + "." + this.d;
   }
}
