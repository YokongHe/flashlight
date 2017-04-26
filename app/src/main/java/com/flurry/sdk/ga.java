package com.flurry.sdk;

import com.flurry.sdk.ga$a;
import com.flurry.sdk.ga$b;

public class ga {
   private static final ThreadLocal a = new ThreadLocal() {
      protected final ga$a a() {
         return new ga$a();
      }

      // $FF: synthetic method
      protected final Object initialValue() {
         return this.a();
      }
   };
   private static final ThreadLocal b = new ThreadLocal() {
      protected final ga$b a() {
         return new ga$b();
      }

      // $FF: synthetic method
      protected final Object initialValue() {
         return this.a();
      }
   };

   public static int a(double var0, byte[] var2, int var3) {
      long var6 = Double.doubleToRawLongBits(var0);
      int var4 = (int)(var6 & -1L);
      int var5 = (int)(var6 >>> 32 & -1L);
      var2[var3] = (byte)(var4 & 255);
      var2[var3 + 4] = (byte)(var5 & 255);
      var2[var3 + 5] = (byte)(var5 >>> 8 & 255);
      var2[var3 + 1] = (byte)(var4 >>> 8 & 255);
      var2[var3 + 2] = (byte)(var4 >>> 16 & 255);
      var2[var3 + 6] = (byte)(var5 >>> 16 & 255);
      var2[var3 + 7] = (byte)(var5 >>> 24 & 255);
      var2[var3 + 3] = (byte)(var4 >>> 24 & 255);
      return 8;
   }

   public static int a(float var0, byte[] var1, int var2) {
      int var3 = Float.floatToRawIntBits(var0);
      var1[var2] = (byte)(var3 & 255);
      var1[var2 + 1] = (byte)(var3 >>> 8 & 255);
      var1[var2 + 2] = (byte)(var3 >>> 16 & 255);
      var1[var2 + 3] = (byte)(var3 >>> 24 & 255);
      return 4;
   }

   public static int a(int var0, byte[] var1, int var2) {
      int var3 = var0 << 1 ^ var0 >> 31;
      if((var3 & -128) != 0) {
         label18: {
            int var4 = var2 + 1;
            var1[var2] = (byte)((var3 | 128) & 255);
            int var5 = var3 >>> 7;
            var3 = var4;
            var0 = var5;
            if(var5 > 127) {
               var0 = var4 + 1;
               var1[var4] = (byte)((var5 | 128) & 255);
               var3 = var5 >>> 7;
               if(var3 <= 127) {
                  break label18;
               }

               var4 = var0 + 1;
               var1[var0] = (byte)((var3 | 128) & 255);
               var5 = var3 >>> 7;
               var3 = var4;
               var0 = var5;
               if(var5 > 127) {
                  var0 = var4 + 1;
                  var1[var4] = (byte)((var5 | 128) & 255);
                  var3 = var5 >>> 7;
                  break label18;
               }
            }

            var4 = var0;
            var0 = var3;
            var3 = var4;
         }
      } else {
         var0 = var2;
      }

      var1[var0] = (byte)var3;
      return var0 + 1 - var2;
   }

   public static int a(long var0, byte[] var2, int var3) {
      var0 = var0 >> 63 ^ var0 << 1;
      int var4;
      if((-128L & var0) != 0L) {
         int var6 = var3 + 1;
         var2[var3] = (byte)((int)((128L | var0) & 255L));
         long var7 = var0 >>> 7;
         var4 = var6;
         var0 = var7;
         if(var7 > 127L) {
            int var5 = var6 + 1;
            var2[var6] = (byte)((int)((128L | var7) & 255L));
            var7 >>>= 7;
            var4 = var5;
            var0 = var7;
            if(var7 > 127L) {
               var6 = var5 + 1;
               var2[var5] = (byte)((int)((128L | var7) & 255L));
               var7 >>>= 7;
               var4 = var6;
               var0 = var7;
               if(var7 > 127L) {
                  var5 = var6 + 1;
                  var2[var6] = (byte)((int)((128L | var7) & 255L));
                  var7 >>>= 7;
                  var4 = var5;
                  var0 = var7;
                  if(var7 > 127L) {
                     var6 = var5 + 1;
                     var2[var5] = (byte)((int)((128L | var7) & 255L));
                     var7 >>>= 7;
                     var4 = var6;
                     var0 = var7;
                     if(var7 > 127L) {
                        var5 = var6 + 1;
                        var2[var6] = (byte)((int)((128L | var7) & 255L));
                        var7 >>>= 7;
                        var4 = var5;
                        var0 = var7;
                        if(var7 > 127L) {
                           var6 = var5 + 1;
                           var2[var5] = (byte)((int)((128L | var7) & 255L));
                           var7 >>>= 7;
                           var4 = var6;
                           var0 = var7;
                           if(var7 > 127L) {
                              var5 = var6 + 1;
                              var2[var6] = (byte)((int)((128L | var7) & 255L));
                              var7 >>>= 7;
                              var4 = var5;
                              var0 = var7;
                              if(var7 > 127L) {
                                 var4 = var5 + 1;
                                 var2[var5] = (byte)((int)((128L | var7) & 255L));
                                 var0 = var7 >>> 7;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         var4 = var3;
      }

      var2[var4] = (byte)((int)var0);
      return var4 + 1 - var3;
   }

   public static int a(boolean var0, byte[] var1, int var2) {
      byte var3;
      if(var0) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1[var2] = var3;
      return 1;
   }

   public static int a(byte[] var0, int var1, int var2, byte[] var3, int var4, int var5) {
      int var7 = var4;

      for(int var6 = var1; var6 < var1 + var2 && var7 < var4 + var5; ++var7) {
         int var8 = var0[var6] & 255;
         int var9 = var3[var7] & 255;
         if(var8 != var9) {
            return var8 - var9;
         }

         ++var6;
      }

      return var2 - var5;
   }
}
