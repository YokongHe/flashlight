public class ar {
   private static final ae a = bh.a(ar.class);

   public static byte[] a(byte var0, byte var1, short var2, byte[] var3) {
      if(a.b()) {
         a.b((Object)("Building XMode buffer: protocol=" + var0 + " version=" + var1 + " cmd=" + var2 + " payload len:" + var3.length));
         a.a(var3);
      }

      int var4 = var3.length;
      byte[] var5 = new byte[var4 + 8];
      System.arraycopy((new as(var0, var1, var2, var4)).a(), 0, var5, 0, 8);
      System.arraycopy(var3, 0, var5, 8, var4);
      return var5;
   }

   public static byte[] a(byte[] var0, byte[] var1) {
      if(a.b()) {
         a.b((Object)"Appending session ID");
         a.a(var1);
         a.a(var0);
      }

      byte[] var2 = new byte[var0.length + 16];
      System.arraycopy(var1, 0, var2, 0, 16);
      System.arraycopy(var0, 0, var2, 16, var0.length);
      return var2;
   }
}
