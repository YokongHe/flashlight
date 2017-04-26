public final class at {
   private static byte[] a = new byte[64];
   private static String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

   static {
      for(int var1 = 0; var1 < 64; ++var1) {
         byte var0 = (byte)b.charAt(var1);
         a[var1] = var0;
      }

   }

   public static String a(byte[] var0) {
      int var7 = var0.length;
      byte[] var8 = new byte[(var7 + 2) / 3 << 2];
      byte var2 = 0;
      int var4 = 0;
      int var1 = 0;

      int var3;
      byte var5;
      for(var3 = 0; var3 < var7 + 0; var2 = var5) {
         var5 = var0[var3];
         ++var4;
         int var6;
         int var9;
         switch(var4) {
         case 1:
            var6 = var1 + 1;
            var8[var1] = a[var5 >> 2 & 63];
            var9 = var4;
            var1 = var6;
            break;
         case 2:
            var6 = var1 + 1;
            var8[var1] = a[var2 << 4 & 48 | var5 >> 4 & 15];
            var9 = var4;
            var1 = var6;
            break;
         case 3:
            var4 = var1 + 1;
            var8[var1] = a[var2 << 2 & 60 | var5 >> 6 & 3];
            var8[var4] = a[var5 & 63];
            var1 = var4 + 1;
            var9 = 0;
            break;
         default:
            var9 = var4;
         }

         ++var3;
         var4 = var9;
      }

      switch(var4) {
      case 1:
         var3 = var1 + 1;
         var8[var1] = a[var2 << 4 & 48];
         var8[var3] = 61;
         var8[var3 + 1] = 61;
         break;
      case 2:
         var8[var1] = a[var2 << 2 & 60];
         var8[var1 + 1] = 61;
      }

      return new String(var8);
   }
}
