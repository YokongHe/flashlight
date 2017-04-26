public class bD {
   private String a;
   private byte b;

   public bD(String var1) {
      this.a = var1;
   }

   public bD(String var1, byte var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void a(byte var1) {
      this.b = var1;
   }

   public final String b() {
      return this.a;
   }

   public final byte c() {
      return this.b;
   }
}
