package com.inmobi.commons.thirdparty;

public class Base62 {
   public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public static final int BASE = 62;

   private static int a(int var0, int var1) {
      return (int)Math.pow((double)BASE, (double)var1) * var0;
   }

   private static int a(char[] var0) {
      int var2 = 0;

      for(int var1 = var0.length - 1; var1 >= 0; --var1) {
         var2 += a("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(var0[var1]), var1);
      }

      return var2;
   }

   private static long a(long var0, StringBuilder var2) {
      var2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int)(var0 % (long)BASE)));
      return var0 / (long)BASE;
   }

   public static String fromBase10(long param0) {
      // $FF: Couldn't be decompiled
   }

   public static int toBase10(String var0) {
      return a((new StringBuilder(var0)).reverse().toString().toCharArray());
   }
}
