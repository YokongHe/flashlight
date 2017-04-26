public final class aT extends aV {
   private String a;

   public aT(String var1) {
      super((short)22);
      this.a = var1;
   }

   public aT(byte[] var1) {
      super((short)22);
      this.a = new String(var1);
   }

   public final String a() {
      return this.a;
   }

   public final byte[] b() {
      return super.a(this.a.getBytes());
   }
}
