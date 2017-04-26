package com.flurry.sdk;

import java.util.Arrays;

public final class sk {
   static final int[] a;
   static final int[] b;
   static final int[] c;
   static final int[] d;
   static final int[] e;
   static final int[] f;
   static final int[] g;
   private static final char[] h;
   private static final byte[] i;

   static {
      char[] var2 = "0123456789ABCDEF".toCharArray();
      h = var2;
      int var1 = var2.length;
      i = new byte[var1];

      int var0;
      for(var0 = 0; var0 < var1; ++var0) {
         i[var0] = (byte)h[var0];
      }

      int[] var4 = new int[256];

      for(var0 = 0; var0 < 32; ++var0) {
         var4[var0] = -1;
      }

      var4[34] = 1;
      var4[92] = 1;
      a = var4;
      var4 = new int[var4.length];
      System.arraycopy(a, 0, var4, 0, a.length);

      for(var1 = 128; var1 < 256; ++var1) {
         byte var3;
         if((var1 & 224) == 192) {
            var3 = 2;
         } else if((var1 & 240) == 224) {
            var3 = 3;
         } else if((var1 & 248) == 240) {
            var3 = 4;
         } else {
            var3 = -1;
         }

         var4[var1] = var3;
      }

      b = var4;
      var4 = new int[256];
      Arrays.fill(var4, -1);

      for(var0 = 33; var0 < 256; ++var0) {
         if(Character.isJavaIdentifierPart((char)var0)) {
            var4[var0] = 0;
         }
      }

      var4[64] = 0;
      var4[35] = 0;
      var4[42] = 0;
      var4[45] = 0;
      var4[43] = 0;
      c = var4;
      var4 = new int[256];
      System.arraycopy(c, 0, var4, 0, c.length);
      Arrays.fill(var4, 128, 128, 0);
      d = var4;
      e = new int[256];
      System.arraycopy(b, 128, e, 128, 128);
      Arrays.fill(e, 0, 32, -1);
      e[9] = 0;
      e[10] = 10;
      e[13] = 13;
      e[42] = 42;
      var4 = new int[128];

      for(var0 = 0; var0 < 32; ++var0) {
         var4[var0] = -1;
      }

      var4[34] = 34;
      var4[92] = 92;
      var4[8] = 98;
      var4[9] = 116;
      var4[12] = 102;
      var4[10] = 110;
      var4[13] = 114;
      f = var4;
      var4 = new int[128];
      g = var4;
      Arrays.fill(var4, -1);

      for(var0 = 0; var0 < 10; g[var0 + 48] = var0++) {
         ;
      }

      for(var0 = 0; var0 < 6; ++var0) {
         g[var0 + 97] = var0 + 10;
         g[var0 + 65] = var0 + 10;
      }

   }

   public static int a(int var0) {
      return var0 > 127?-1:g[var0];
   }

   public static void a(StringBuilder var0, String var1) {
      int[] var7 = f;
      int var4 = var7.length;
      int var3 = 0;

      for(int var5 = var1.length(); var3 < var5; ++var3) {
         char var2 = var1.charAt(var3);
         if(var2 < var4 && var7[var2] != 0) {
            var0.append('\\');
            int var6 = var7[var2];
            if(var6 < 0) {
               var0.append('u');
               var0.append('0');
               var0.append('0');
               var6 = -(var6 + 1);
               var0.append(h[var6 >> 4]);
               var0.append(h[var6 & 15]);
            } else {
               var0.append((char)var6);
            }
         } else {
            var0.append(var2);
         }
      }

   }

   public static final int[] a() {
      return a;
   }

   public static final int[] b() {
      return b;
   }

   public static final int[] c() {
      return c;
   }

   public static final int[] d() {
      return d;
   }

   public static final int[] e() {
      return e;
   }

   public static final int[] f() {
      return f;
   }

   public static char[] g() {
      return (char[])h.clone();
   }

   public static byte[] h() {
      return (byte[])i.clone();
   }
}
