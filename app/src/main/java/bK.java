public class bK extends bB implements bW {
   private static final ae a = bh.a(bK.class);

   public bK(byte[] var1) {
      super((short)29189, var1);
   }

   public final String g() {
      a.b((Object)"PDXQueryRetry.getName()");
      String var1 = this.f("name");
      return var1 != null?var1:"";
   }

   public final int h() {
      a.b((Object)"PDXQueryRetry.getCause()");

      try {
         int var1 = this.d("cause");
         return var1;
      } catch (Exception var3) {
         return 0;
      }
   }

   public final String i() {
      a.b((Object)"PDXQueryRetry.getPrompt()");

      String var1;
      try {
         var1 = this.f("prompt");
      } catch (Exception var2) {
         var1 = "";
      }

      return var1 != null?var1:"";
   }
}
