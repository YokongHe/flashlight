package com.google.android.gms.internal;

import java.util.Arrays;

public final class dc {
   public static final Object a = new Object();

   public static int a(int[] var0) {
      return var0 != null && var0.length != 0?Arrays.hashCode(var0):0;
   }

   public static int a(Object[] var0) {
      int var3 = 0;
      int var1;
      if(var0 == null) {
         var1 = 0;
      } else {
         var1 = var0.length;
      }

      int var4;
      for(int var2 = 0; var2 < var1; var3 = var4) {
         Object var5 = var0[var2];
         var4 = var3;
         if(var5 != null) {
            var4 = var3 * 31 + var5.hashCode();
         }

         ++var2;
      }

      return var3;
   }

   public static boolean a(int[] var0, int[] var1) {
      return var0 != null && var0.length != 0?Arrays.equals(var0, var1):var1 == null || var1.length == 0;
   }

   public static boolean a(Object[] var0, Object[] var1) {
      boolean var9 = false;
      int var4;
      if(var0 == null) {
         var4 = 0;
      } else {
         var4 = var0.length;
      }

      int var5;
      if(var1 == null) {
         var5 = 0;
      } else {
         var5 = var1.length;
      }

      int var3 = 0;
      int var2 = 0;

      boolean var8;
      while(true) {
         while(var2 < var4 && var0[var2] == null) {
            ++var2;
         }

         while(var3 < var5 && var1[var3] == null) {
            ++var3;
         }

         boolean var6;
         if(var2 >= var4) {
            var6 = true;
         } else {
            var6 = false;
         }

         boolean var7;
         if(var3 >= var5) {
            var7 = true;
         } else {
            var7 = false;
         }

         if(var6 && var7) {
            var8 = true;
            break;
         }

         var8 = var9;
         if(var6 != var7) {
            break;
         }

         var8 = var9;
         if(!var0[var2].equals(var1[var3])) {
            break;
         }

         ++var3;
         ++var2;
      }

      return var8;
   }
}
