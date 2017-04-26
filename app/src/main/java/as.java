public class as {
   private static final ae d = bh.a(as.class);
   public byte a;
   public short b;
   public int c;
   private byte e;

   public as(byte var1, byte var2, short var3, int var4) {
      if(d.b()) {
         d.b((Object)("Constructing XModeMsgHeader(protocol=" + var1 + ", version=" + var2 + ", cmd=" + var3 + ", len=" + var4 + ")"));
      }

      this.a = var1;
      this.e = var2;
      this.b = var3;
      this.c = var4;
   }

   public as(byte[] var1) {
      if(d.b()) {
         d.b((Object)"Constructing XModeMsgHeader(byte[])");
         d.a(var1);
      }

      this.a = var1[0];
      this.e = var1[1];
      this.b = au.a(var1, 2);
      this.c = au.b(var1, 4);
   }

   public final byte[] a() {
      if(d.b()) {
         d.b((Object)"XModeMsgHeader.getBytes()");
      }

      byte[] var1 = new byte[8];
      var1[0] = this.a;
      var1[1] = this.e;
      au.a((short)this.b, var1, 2);
      au.a((int)this.c, var1, 4);
      if(d.b()) {
         d.a((Object)"Generated: ");
         d.a(var1);
      }

      return var1;
   }
}
