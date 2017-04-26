package com.tapjoy.internal;

import java.nio.CharBuffer;

public final class dc {
   private static long a(Readable var0, Appendable var1) {
      CharBuffer var5 = CharBuffer.allocate(2048);
      long var3 = 0L;

      while(true) {
         int var2 = var0.read(var5);
         if(var2 == -1) {
            return var3;
         }

         var5.flip();
         var1.append(var5, 0, var2);
         var3 += (long)var2;
      }
   }

   public static String a(Readable var0) {
      StringBuilder var1 = new StringBuilder();
      a(var0, var1);
      return var1.toString();
   }
}
