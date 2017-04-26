package com.nexage.android.a;

public final class d {
   public static int a = 2;
   static int[] b = new int[10];
   static String[] c = new String[10];
   private static int d = 0;

   public static void a(int var0, String var1) {
      if(d < 10) {
         b[d] = var0;
         String[] var2 = c;
         var0 = d;
         d = var0 + 1;
         var2[var0] = var1;
      }

   }
}
