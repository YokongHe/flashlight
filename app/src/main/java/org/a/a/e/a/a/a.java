package org.a.a.e.a.a;

public final class a {
   private static final String a;
   private static char[] b;
   private static byte[] c;

   static {
      byte var3 = 0;
      a = System.getProperty("line.separator");
      b = new char[64];
      char var0 = 65;

      int var1;
      for(var1 = 0; var0 <= 90; ++var1) {
         b[var1] = var0++;
      }

      for(var0 = 97; var0 <= 122; ++var1) {
         b[var1] = var0++;
      }

      for(var0 = 48; var0 <= 57; ++var1) {
         b[var1] = var0++;
      }

      b[var1] = 43;
      b[var1 + 1] = 47;
      c = new byte[128];
      var1 = 0;

      while(true) {
         int var2 = var3;
         if(var1 >= c.length) {
            while(var2 < 64) {
               c[b[var2]] = (byte)var2;
               ++var2;
            }

            return;
         }

         c[var1] = -1;
         ++var1;
      }
   }

   public static byte[] a(char[] var0) {
      byte var3 = 0;
      int var2 = var0.length;
      int var1 = var2;
      if(var2 % 4 != 0) {
         throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
      } else {
         while(var1 > 0 && var0[var1 + 0 - 1] == 61) {
            --var1;
         }

         int var5 = var1 * 3 / 4;
         byte[] var10 = new byte[var5];
         int var6 = var1 + 0;
         var2 = 0;
         var1 = var3;

         while(var1 < var6) {
            int var11 = var1 + 1;
            char var7 = var0[var1];
            var1 = var11 + 1;
            char var8 = var0[var11];
            char var12;
            if(var1 < var6) {
               var12 = var0[var1];
               ++var1;
            } else {
               var12 = 65;
            }

            char var4;
            if(var1 < var6) {
               var4 = var0[var1];
               ++var1;
            } else {
               var4 = 65;
            }

            if(var7 <= 127 && var8 <= 127 && var12 <= 127 && var4 <= 127) {
               byte var9 = c[var7];
               byte var15 = c[var8];
               byte var14 = c[var12];
               byte var13 = c[var4];
               if(var9 >= 0 && var15 >= 0 && var14 >= 0 && var13 >= 0) {
                  var11 = var2 + 1;
                  var10[var2] = (byte)(var9 << 2 | var15 >>> 4);
                  if(var11 < var5) {
                     var2 = var11 + 1;
                     var10[var11] = (byte)((var15 & 15) << 4 | var14 >>> 2);
                  } else {
                     var2 = var11;
                  }

                  if(var2 < var5) {
                     var11 = var2 + 1;
                     var10[var2] = (byte)((var14 & 3) << 6 | var13);
                     var2 = var11;
                  }
                  continue;
               }

               throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }

            throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
         }

         return var10;
      }
   }
}
