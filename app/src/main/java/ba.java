public class ba extends aV {
   private static final ae a = bh.a(ba.class);
   private String b;

   public ba(String var1) {
      super((short)193);
      this.b = var1;
   }

   public ba(byte[] var1) {
      super((short)193);

      try {
         this.b = new String(var1, "UTF-8");
      } catch (Exception var3) {
         a.e("PDXUTF8String() " + var3.getMessage());
         this.b = new String(var1);
      }
   }

   public final String a() {
      return this.b;
   }

   public final byte[] b() {
      try {
         byte[] var1 = super.a(this.b.getBytes("UTF-8"));
         return var1;
      } catch (Exception var2) {
         a.e("PDXUTF8String().toByteArray() " + var2.getMessage());
         return super.a(this.b.getBytes());
      }
   }
}
