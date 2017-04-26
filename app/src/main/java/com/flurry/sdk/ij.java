package com.flurry.sdk;

public final class ij {
   static final String a = String.valueOf(Long.MIN_VALUE);
   static final char[] b = new char[4000];
   static final char[] c = new char[4000];
   static final byte[] d;
   static final String[] e;
   static final String[] f;
   private static int g = 1000000;
   private static int h = 1000000000;
   private static long i = 10000000000L;
   private static long j = 1000L;
   private static long k = -2147483648L;
   private static long l = 2147483647L;

   static {
      int var6 = 0;

      int var5;
      for(var5 = 0; var6 < 10; ++var6) {
         char var2 = (char)(var6 + 48);
         char var0;
         if(var6 == 0) {
            var0 = 0;
         } else {
            var0 = var2;
         }

         for(int var7 = 0; var7 < 10; ++var7) {
            char var3 = (char)(var7 + 48);
            char var1;
            if(var6 == 0 && var7 == 0) {
               var1 = 0;
            } else {
               var1 = var3;
            }

            for(int var8 = 0; var8 < 10; ++var8) {
               char var4 = (char)(var8 + 48);
               b[var5] = var0;
               b[var5 + 1] = var1;
               b[var5 + 2] = var4;
               c[var5] = var2;
               c[var5 + 1] = var3;
               c[var5 + 2] = var4;
               var5 += 4;
            }
         }
      }

      d = new byte[4000];

      for(var5 = 0; var5 < 4000; ++var5) {
         d[var5] = (byte)c[var5];
      }

      e = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
      f = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
   }

   public static int a(int var0, byte[] var1, int var2) {
      int var4 = var0;
      int var3 = var2;
      if(var0 < 0) {
         if(var0 == Integer.MIN_VALUE) {
            return a((long)var0, var1, var2);
         }

         var1[var2] = 45;
         var4 = -var0;
         var3 = var2 + 1;
      }

      if(var4 < g) {
         if(var4 < 1000) {
            if(var4 < 10) {
               var1[var3] = (byte)(var4 + 48);
               return var3 + 1;
            } else {
               return b(var4, var1, var3);
            }
         } else {
            var0 = var4 / 1000;
            return c(var4 - var0 * 1000, var1, b(var0, var1, var3));
         }
      } else {
         boolean var5;
         if(var4 >= h) {
            var5 = true;
         } else {
            var5 = false;
         }

         var0 = var4;
         var2 = var3;
         if(var5) {
            var0 = var4 - h;
            if(var0 >= h) {
               var0 -= h;
               var1[var3] = 50;
               var2 = var3 + 1;
            } else {
               var1[var3] = 49;
               var2 = var3 + 1;
            }
         }

         var3 = var0 / 1000;
         var4 = var3 / 1000;
         if(var5) {
            var2 = c(var4, var1, var2);
         } else {
            var2 = b(var4, var1, var2);
         }

         return c(var0 - var3 * 1000, var1, c(var3 - var4 * 1000, var1, var2));
      }
   }

   public static int a(int var0, char[] var1, int var2) {
      int var4 = var0;
      int var3 = var2;
      if(var0 < 0) {
         if(var0 == Integer.MIN_VALUE) {
            return a((long)var0, var1, var2);
         }

         var1[var2] = 45;
         var4 = -var0;
         var3 = var2 + 1;
      }

      if(var4 < g) {
         if(var4 < 1000) {
            if(var4 < 10) {
               var1[var3] = (char)(var4 + 48);
               return var3 + 1;
            } else {
               return b(var4, var1, var3);
            }
         } else {
            var0 = var4 / 1000;
            return c(var4 - var0 * 1000, var1, b(var0, var1, var3));
         }
      } else {
         boolean var5;
         if(var4 >= h) {
            var5 = true;
         } else {
            var5 = false;
         }

         var0 = var4;
         var2 = var3;
         if(var5) {
            var0 = var4 - h;
            if(var0 >= h) {
               var0 -= h;
               var1[var3] = 50;
               var2 = var3 + 1;
            } else {
               var1[var3] = 49;
               var2 = var3 + 1;
            }
         }

         var3 = var0 / 1000;
         var4 = var3 / 1000;
         if(var5) {
            var2 = c(var4, var1, var2);
         } else {
            var2 = b(var4, var1, var2);
         }

         return c(var0 - var3 * 1000, var1, c(var3 - var4 * 1000, var1, var2));
      }
   }

   public static int a(long var0, byte[] var2, int var3) {
      int var4;
      int var5;
      int var6;
      long var8;
      if(var0 < 0L) {
         if(var0 > k) {
            var5 = a((int)var0, var2, var3);
            return var5;
         }

         if(var0 == Long.MIN_VALUE) {
            var6 = a.length();
            var4 = 0;

            while(true) {
               var5 = var3;
               if(var4 >= var6) {
                  return var5;
               }

               var2[var3] = (byte)a.charAt(var4);
               ++var4;
               ++var3;
            }
         }

         var2[var3] = 45;
         var8 = -var0;
         var4 = var3 + 1;
      } else {
         var8 = var0;
         var4 = var3;
         if(var0 <= l) {
            return a((int)var0, var2, var3);
         }
      }

      var6 = var4 + b(var8);

      for(var3 = var6; var8 > l; var8 = var0) {
         var3 -= 3;
         var0 = var8 / j;
         c((int)(var8 - j * var0), var2, var3);
      }

      int var7;
      for(var5 = (int)var8; var5 >= 1000; var5 = var7) {
         var3 -= 3;
         var7 = var5 / 1000;
         c(var5 - var7 * 1000, var2, var3);
      }

      b(var5, var2, var4);
      return var6;
   }

   public static int a(long var0, char[] var2, int var3) {
      int var4;
      long var8;
      if(var0 < 0L) {
         if(var0 > k) {
            return a((int)var0, var2, var3);
         }

         if(var0 == Long.MIN_VALUE) {
            var4 = a.length();
            a.getChars(0, var4, var2, var3);
            return var3 + var4;
         }

         var2[var3] = 45;
         var8 = -var0;
         var4 = var3 + 1;
      } else {
         var8 = var0;
         var4 = var3;
         if(var0 <= l) {
            return a((int)var0, var2, var3);
         }
      }

      int var6 = var4 + b(var8);

      for(var3 = var6; var8 > l; var8 = var0) {
         var3 -= 3;
         var0 = var8 / j;
         c((int)(var8 - j * var0), var2, var3);
      }

      int var5;
      int var7;
      for(var5 = (int)var8; var5 >= 1000; var5 = var7) {
         var3 -= 3;
         var7 = var5 / 1000;
         c(var5 - var7 * 1000, var2, var3);
      }

      b(var5, var2, var4);
      return var6;
   }

   public static String a(double var0) {
      return Double.toString(var0);
   }

   public static String a(int var0) {
      if(var0 < e.length) {
         if(var0 >= 0) {
            return e[var0];
         }

         int var1 = -var0 - 1;
         if(var1 < f.length) {
            return f[var1];
         }
      }

      return Integer.toString(var0);
   }

   public static String a(long var0) {
      return var0 <= 2147483647L && var0 >= -2147483648L?a((int)var0):Long.toString(var0);
   }

   private static int b(int var0, byte[] var1, int var2) {
      var0 <<= 2;
      char[] var5 = b;
      int var3 = var0 + 1;
      char var4 = var5[var0];
      var0 = var2;
      if(var4 != 0) {
         var1[var2] = (byte)var4;
         var0 = var2 + 1;
      }

      var4 = b[var3];
      var2 = var0;
      if(var4 != 0) {
         var1[var0] = (byte)var4;
         var2 = var0 + 1;
      }

      var1[var2] = (byte)b[var3 + 1];
      return var2 + 1;
   }

   private static int b(int var0, char[] var1, int var2) {
      var0 <<= 2;
      char[] var5 = b;
      int var4 = var0 + 1;
      char var3 = var5[var0];
      var0 = var2;
      if(var3 != 0) {
         var1[var2] = var3;
         var0 = var2 + 1;
      }

      var3 = b[var4];
      var2 = var0;
      if(var3 != 0) {
         var1[var0] = var3;
         var2 = var0 + 1;
      }

      var1[var2] = b[var4 + 1];
      return var2 + 1;
   }

   private static int b(long var0) {
      int var2 = 10;

      for(long var3 = i; var0 >= var3 && var2 != 19; var3 = (var3 << 1) + (var3 << 3)) {
         ++var2;
      }

      return var2;
   }

   private static int c(int var0, byte[] var1, int var2) {
      int var4 = var0 << 2;
      var0 = var2 + 1;
      byte[] var5 = d;
      int var3 = var4 + 1;
      var1[var2] = var5[var4];
      var2 = var0 + 1;
      var1[var0] = d[var3];
      var1[var2] = d[var3 + 1];
      return var2 + 1;
   }

   private static int c(int var0, char[] var1, int var2) {
      int var4 = var0 << 2;
      var0 = var2 + 1;
      char[] var5 = c;
      int var3 = var4 + 1;
      var1[var2] = var5[var4];
      var2 = var0 + 1;
      var1[var0] = c[var3];
      var1[var2] = c[var3 + 1];
      return var2 + 1;
   }
}
