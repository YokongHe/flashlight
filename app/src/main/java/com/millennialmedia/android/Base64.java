package com.millennialmedia.android;

import java.util.Arrays;

class Base64 {
   private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
   private static final int[] IA;

   static {
      int[] var2 = new int[256];
      IA = var2;
      Arrays.fill(var2, -1);
      int var1 = CA.length;

      for(int var0 = 0; var0 < var1; IA[CA[var0]] = var0++) {
         ;
      }

      IA[61] = 0;
   }

   public static final byte[] decode(String var0) {
      int var1;
      if(var0 != null) {
         var1 = var0.length();
      } else {
         var1 = 0;
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         int var3 = 0;

         int var2;
         int var4;
         for(var2 = 0; var3 < var1; var2 = var4) {
            var4 = var2;
            if(IA[var0.charAt(var3)] < 0) {
               var4 = var2 + 1;
            }

            ++var3;
         }

         if((var1 - var2) % 4 != 0) {
            return null;
         } else {
            var3 = var1;
            var4 = 0;

            int var5;
            while(var3 > 1) {
               int[] var7 = IA;
               var5 = var3 - 1;
               if(var7[var0.charAt(var5)] > 0) {
                  break;
               }

               var3 = var5;
               if(var0.charAt(var5) == 61) {
                  ++var4;
                  var3 = var5;
               }
            }

            int var6 = ((var1 - var2) * 6 >> 3) - var4;
            byte[] var9 = new byte[var6];
            var3 = 0;

            for(var1 = 0; var3 < var6; var1 = var2) {
               var4 = 0;
               byte var8 = 0;
               var2 = var1;

               for(var1 = var8; var1 < 4; ++var2) {
                  var5 = IA[var0.charAt(var2)];
                  if(var5 >= 0) {
                     var4 |= var5 << 18 - var1 * 6;
                  } else {
                     --var1;
                  }

                  ++var1;
               }

               var5 = var3 + 1;
               var9[var3] = (byte)(var4 >> 16);
               var1 = var5;
               if(var5 < var6) {
                  var1 = var5 + 1;
                  var9[var5] = (byte)(var4 >> 8);
                  if(var1 < var6) {
                     var3 = var1 + 1;
                     var9[var1] = (byte)var4;
                     var1 = var3;
                  }
               }

               var3 = var1;
            }

            return var9;
         }
      }
   }

   public static final byte[] decode(byte[] var0) {
      int var4 = var0.length;
      int var2 = 0;

      int var1;
      int var3;
      for(var1 = 0; var2 < var4; var1 = var3) {
         var3 = var1;
         if(IA[var0[var2] & 255] < 0) {
            var3 = var1 + 1;
         }

         ++var2;
      }

      if((var4 - var1) % 4 != 0) {
         return null;
      } else {
         var2 = var4;
         var3 = 0;

         int var5;
         while(var2 > 1) {
            int[] var7 = IA;
            var5 = var2 - 1;
            if(var7[var0[var5] & 255] > 0) {
               break;
            }

            var2 = var5;
            if(var0[var5] == 61) {
               ++var3;
               var2 = var5;
            }
         }

         int var6 = ((var4 - var1) * 6 >> 3) - var3;
         byte[] var9 = new byte[var6];
         var3 = 0;

         for(var1 = 0; var3 < var6; var1 = var2) {
            var4 = 0;
            byte var8 = 0;
            var2 = var1;

            for(var1 = var8; var1 < 4; ++var2) {
               var5 = IA[var0[var2] & 255];
               if(var5 >= 0) {
                  var4 |= var5 << 18 - var1 * 6;
               } else {
                  --var1;
               }

               ++var1;
            }

            var5 = var3 + 1;
            var9[var3] = (byte)(var4 >> 16);
            var1 = var5;
            if(var5 < var6) {
               var1 = var5 + 1;
               var9[var5] = (byte)(var4 >> 8);
               if(var1 < var6) {
                  var3 = var1 + 1;
                  var9[var1] = (byte)var4;
                  var1 = var3;
               }
            }

            var3 = var1;
         }

         return var9;
      }
   }

   public static final char[] encodeToChar(byte[] var0, boolean var1) {
      byte var7 = 0;
      int var5;
      if(var0 != null) {
         var5 = var0.length;
      } else {
         var5 = 0;
      }

      if(var5 == 0) {
         return new char[0];
      } else {
         int var11 = var5 / 3 * 3;
         int var4 = (var5 - 1) / 3 + 1 << 2;
         int var3;
         if(var1) {
            var3 = (var4 - 1) / 76 << 1;
         } else {
            var3 = 0;
         }

         int var12 = var4 + var3;
         char[] var13 = new char[var12];
         var3 = 0;
         var4 = 0;
         int var6 = 0;

         byte var14;
         while(var6 < var11) {
            int var8 = var6 + 1;
            var14 = var0[var6];
            int var9 = var8 + 1;
            byte var10 = var0[var8];
            var8 = var9 + 1;
            var6 = (var10 & 255) << 8 | (var14 & 255) << 16 | var0[var9] & 255;
            var9 = var4 + 1;
            var13[var4] = CA[var6 >>> 18 & 63];
            var4 = var9 + 1;
            var13[var9] = CA[var6 >>> 12 & 63];
            int var15 = var4 + 1;
            var13[var4] = CA[var6 >>> 6 & 63];
            var9 = var15 + 1;
            var13[var15] = CA[var6 & 63];
            var4 = var9;
            var6 = var8;
            if(var1) {
               var15 = var3 + 1;
               var3 = var15;
               var4 = var9;
               var6 = var8;
               if(var15 == 19) {
                  var3 = var15;
                  var4 = var9;
                  var6 = var8;
                  if(var9 < var12 - 2) {
                     var3 = var9 + 1;
                     var13[var9] = 13;
                     var13[var3] = 10;
                     var4 = var3 + 1;
                     var3 = 0;
                     var6 = var8;
                  }
               }
            }
         }

         var4 = var5 - var11;
         if(var4 > 0) {
            var14 = var0[var11];
            var3 = var7;
            if(var4 == 2) {
               var3 = (var0[var5 - 1] & 255) << 2;
            }

            var3 |= (var14 & 255) << 10;
            var13[var12 - 4] = CA[var3 >> 12];
            var13[var12 - 3] = CA[var3 >>> 6 & 63];
            char var2;
            if(var4 == 2) {
               var2 = CA[var3 & 63];
            } else {
               var2 = 61;
            }

            var13[var12 - 2] = var2;
            var13[var12 - 1] = 61;
         }

         return var13;
      }
   }

   public static final String encodeToString(byte[] var0, boolean var1) {
      return new String(encodeToChar(var0, var1));
   }
}
