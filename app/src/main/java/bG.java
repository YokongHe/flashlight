public class bG extends bB implements bV {
   private static final ae a = bh.a(bG.class);

   public bG(byte[] var1) {
      super((short)29186, var1);
   }

   public final int g() {
      a.b((Object)"PDXQueryError.getError()");
      return this.d("error");
   }

   public final String h() {
      a.b((Object)"PDXQueryError.getDescription()");
      String var1 = this.f("description");
      return var1 != null?var1:"";
   }
}
