import java.io.UnsupportedEncodingException;

public class cH {
   private static final ae a = bh.a(cH.class);

   public static int a(byte[] var0, int var1) {
      return var0[var1] & 255 | (var0[var1 + 1] & 255) << 8;
   }

   public static String a(String var0) {
      int var1 = 0;
      int var3 = var0.length();
      char[] var4 = var0.toCharArray();

      int var2;
      while(true) {
         var2 = var3;
         if(var1 >= var3) {
            break;
         }

         var2 = var3;
         if(var4[var1] != 32) {
            break;
         }

         ++var1;
      }

      while(var1 < var2 && var4[var2 - 1] == 32) {
         --var2;
      }

      return var0.substring(var1, var2);
   }

   public static String a(byte[] var0, int var1, int var2, String var3) {
      try {
         String var4 = new String(var0, var1, var2, var3);
         return var4;
      } catch (UnsupportedEncodingException var5) {
         if(a.d()) {
            a.d(var3 + " character encoding is not available in your VM. Using the default one.");
         }

         return new String(var0, var1, var2);
      }
   }

   public static int b(byte[] var0, int var1) {
      return a(var0, var1) & '\uffff' | (a(var0, var1 + 2) & '\uffff') << 16;
   }

   public static long c(byte[] var0, int var1) {
      return (long)((var0[var1 + 3] & 255) << 24 | (var0[var1 + 2] & 255) << 16 | (var0[var1 + 1] & 255) << 8 | var0[var1] & 255) & 4294967295L;
   }

   public static int d(byte[] var0, int var1) {
      if(a.a()) {
         a.a((Object)"Computing string length");
      }

      int var2;
      for(var2 = var1; var0[var2] != 0; ++var2) {
         ;
      }

      var1 = var2 - var1;
      if(a.a()) {
         a.a((Object)("String length: [" + var1 + "]"));
      }

      return var1;
   }
}
