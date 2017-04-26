public class au {
   private static final ae a = bh.a(au.class);

   public static short a(byte[] var0, int var1) {
      short var2 = (short)(var0[var1] & 255 | (var0[var1 + 1] & 255) << 8);
      if(a.a()) {
         a.a((Object)("Converted [" + var0[var1] + ", " + var0[var1 + 1] + "] to short " + var2));
      }

      return var2;
   }

   public static void a(int var0, byte[] var1, int var2) {
      short var3 = (short)var0;
      short var4 = (short)(var0 >> 16);
      a(var3, var1, var2);
      a(var4, var1, var2 + 2);
      if(a.a()) {
         a.a((Object)("Converted int " + var0 + " to [" + var1[var2] + ", " + var1[var2 + 1] + ", " + var1[var2 + 2] + ", " + var1[var2 + 3] + "]"));
      }

   }

   public static void a(short var0, byte[] var1, int var2) {
      byte var3 = (byte)var0;
      byte var4 = (byte)(var0 >> 8);
      var1[var2] = var3;
      var1[var2 + 1] = var4;
      if(a.a()) {
         a.a((Object)("Converted short " + var0 + " to [" + var1[var2] + ", " + var1[var2 + 1] + "]"));
      }

   }

   public static int b(byte[] var0, int var1) {
      int var2 = a(var0, var1) & '\uffff' | (a(var0, var1 + 2) & '\uffff') << 16;
      if(a.a()) {
         a.a((Object)("Converted [" + var0[var1] + ", " + var0[var1 + 1] + ", " + var0[var1 + 2] + ", " + var0[var1 + 3] + "] to int " + var2));
      }

      return var2;
   }
}
