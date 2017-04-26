package com.flurry.sdk;

import java.util.Arrays;

public final class ha {
   final String a;
   final boolean b;
   final char c;
   final int d;
   private final int[] e;
   private final char[] f;
   private final byte[] g;

   public ha(ha var1, String var2, int var3) {
      this(var1, var2, var1.b, var1.c, var3);
   }

   public ha(ha var1, String var2, boolean var3, char var4, int var5) {
      this.e = new int[128];
      this.f = new char[64];
      this.g = new byte[64];
      this.a = var2;
      byte[] var7 = var1.g;
      System.arraycopy(var7, 0, this.g, 0, var7.length);
      char[] var8 = var1.f;
      System.arraycopy(var8, 0, this.f, 0, var8.length);
      int[] var6 = var1.e;
      System.arraycopy(var6, 0, this.e, 0, var6.length);
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public ha(String var1, String var2, boolean var3, char var4, int var5) {
      byte var6 = 0;
      super();
      this.e = new int[128];
      this.f = new char[64];
      this.g = new byte[64];
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      int var7 = var2.length();
      if(var7 != 64) {
         throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + var7 + ")");
      } else {
         var2.getChars(0, var7, this.f, 0);
         Arrays.fill(this.e, -1);

         char var8;
         for(var5 = var6; var5 < var7; this.e[var8] = var5++) {
            var8 = this.f[var5];
            this.g[var5] = (byte)var8;
         }

         if(var3) {
            this.e[var4] = -2;
         }

      }
   }

   public final int a(int var1, int var2, byte[] var3, int var4) {
      int var7 = var4 + 1;
      var3[var4] = this.g[var1 >> 18 & 63];
      var4 = var7 + 1;
      var3[var7] = this.g[var1 >> 12 & 63];
      if(this.b) {
         byte var6 = (byte)this.c;
         var7 = var4 + 1;
         byte var5;
         if(var2 == 2) {
            var5 = this.g[var1 >> 6 & 63];
         } else {
            var5 = var6;
         }

         var3[var4] = var5;
         var3[var7] = var6;
         return var7 + 1;
      } else if(var2 == 2) {
         var3[var4] = this.g[var1 >> 6 & 63];
         return var4 + 1;
      } else {
         return var4;
      }
   }

   public final int a(int var1, int var2, char[] var3, int var4) {
      int var6 = var4 + 1;
      var3[var4] = this.f[var1 >> 18 & 63];
      var4 = var6 + 1;
      var3[var6] = this.f[var1 >> 12 & 63];
      if(this.b) {
         var6 = var4 + 1;
         char var5;
         if(var2 == 2) {
            var5 = this.f[var1 >> 6 & 63];
         } else {
            var5 = this.c;
         }

         var3[var4] = var5;
         var3[var6] = this.c;
         return var6 + 1;
      } else if(var2 == 2) {
         var3[var4] = this.f[var1 >> 6 & 63];
         return var4 + 1;
      } else {
         return var4;
      }
   }

   public final int a(int var1, byte[] var2, int var3) {
      int var4 = var3 + 1;
      var2[var3] = this.g[var1 >> 18 & 63];
      var3 = var4 + 1;
      var2[var4] = this.g[var1 >> 12 & 63];
      var4 = var3 + 1;
      var2[var3] = this.g[var1 >> 6 & 63];
      var2[var4] = this.g[var1 & 63];
      return var4 + 1;
   }

   public final int a(int var1, char[] var2, int var3) {
      int var4 = var3 + 1;
      var2[var3] = this.f[var1 >> 18 & 63];
      var3 = var4 + 1;
      var2[var4] = this.f[var1 >> 12 & 63];
      var4 = var3 + 1;
      var2[var3] = this.f[var1 >> 6 & 63];
      var2[var4] = this.f[var1 & 63];
      return var4 + 1;
   }

   public final String a(byte[] var1, boolean var2) {
      int var5 = var1.length;
      StringBuilder var8 = new StringBuilder((var5 >> 2) + var5 + (var5 >> 3));
      if(var2) {
         var8.append('\"');
      }

      int var4 = this.c();
      int var3 = 0;

      int var6;
      for(var4 >>= 2; var3 <= var5 - 3; var3 = var6 + 1) {
         int var7 = var3 + 1;
         byte var9 = var1[var3];
         var6 = var7 + 1;
         this.a(var8, (var9 << 8 | var1[var7] & 255) << 8 | var1[var6] & 255);
         --var4;
         var3 = var4;
         if(var4 <= 0) {
            var8.append('\\');
            var8.append('n');
            var3 = this.c() >> 2;
         }

         var4 = var3;
      }

      var6 = var5 - var3;
      if(var6 > 0) {
         var5 = var1[var3] << 16;
         var4 = var5;
         if(var6 == 2) {
            var4 = var5 | (var1[var3 + 1] & 255) << 8;
         }

         this.a(var8, var4, var6);
      }

      if(var2) {
         var8.append('\"');
      }

      return var8.toString();
   }

   public final void a(StringBuilder var1, int var2) {
      var1.append(this.f[var2 >> 18 & 63]);
      var1.append(this.f[var2 >> 12 & 63]);
      var1.append(this.f[var2 >> 6 & 63]);
      var1.append(this.f[var2 & 63]);
   }

   public final void a(StringBuilder var1, int var2, int var3) {
      var1.append(this.f[var2 >> 18 & 63]);
      var1.append(this.f[var2 >> 12 & 63]);
      if(this.b) {
         char var4;
         if(var3 == 2) {
            var4 = this.f[var2 >> 6 & 63];
         } else {
            var4 = this.c;
         }

         var1.append(var4);
         var1.append(this.c);
      } else if(var3 == 2) {
         var1.append(this.f[var2 >> 6 & 63]);
         return;
      }

   }

   public final boolean a() {
      return this.b;
   }

   public final boolean a(char var1) {
      return var1 == this.c;
   }

   public final boolean a(int var1) {
      return var1 == this.c;
   }

   public final char b() {
      return this.c;
   }

   public final int b(char var1) {
      return var1 <= 127?this.e[var1]:-1;
   }

   public final int b(int var1) {
      return var1 <= 127?this.e[var1]:-1;
   }

   public final int c() {
      return this.d;
   }

   public final String toString() {
      return this.a;
   }
}
