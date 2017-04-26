package com.amazon.device.ads;

class NumberUtils {
   public static final long convertToMillisecondsFromNanoseconds(long var0) {
      return var0 / 1000000L;
   }

   public static final long convertToNsFromS(long var0) {
      return 1000000000L * var0;
   }

   public static int parseInt(String var0, int var1) {
      try {
         int var2 = Integer.parseInt(var0);
         return var2;
      } catch (NumberFormatException var3) {
         return var1;
      }
   }
}
