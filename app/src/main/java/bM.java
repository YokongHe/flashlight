public final class bM extends bD implements X {
   private aW a;
   private bd b;
   private int c;

   public bM(String var1, bu var2, aW var3, bd var4) {
      super(var1, (byte)127);
      this.a = var3;
      this.b = var4;
      this.c = var2.c();
      var3.b("audio_id", this.c);
   }

   protected final int a() {
      return this.c;
   }

   protected final byte[] d() {
      return this.a.b();
   }

   protected final bd e() {
      return this.b;
   }
}
