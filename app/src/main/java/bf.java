public final class bf {
   private String a;
   private Object b;
   private bg c;

   public bf(String var1, bg var2) {
      this.a = var1;
      this.b = new byte[0];
      this.c = var2;
   }

   public bf(String var1, Object var2, bg var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final String a() {
      return this.a;
   }

   public final byte[] b() {
      return this.b instanceof byte[]?(byte[])this.b:"THIS IS NOT A STRING PARAMETER!!!".getBytes();
   }

   public final Object c() {
      return this.b;
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.e();
   }

   public final bg d() {
      return this.c;
   }

   public final bf e() {
      Object var1 = this.b;
      if(this.b instanceof byte[]) {
         byte[] var2 = (byte[])this.b;
         var1 = new byte[var2.length];
         System.arraycopy(var2, 0, var1, 0, var2.length);
      }

      return new bf(this.a, var1, this.c);
   }
}
