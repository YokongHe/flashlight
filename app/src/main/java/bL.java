public final class bL extends bD implements X {
   private aW a;

   public bL(String var1, aW var2, byte var3) {
      super(var1);
      if(var3 == 1) {
         super.a((byte)6);
      } else if(var3 == 2) {
         super.a((byte)7);
      } else {
         super.a((byte)8);
      }

      this.a = var2;
   }

   protected final byte[] a() {
      return this.a.b();
   }
}
