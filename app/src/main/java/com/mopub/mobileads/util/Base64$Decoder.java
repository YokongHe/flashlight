package com.mopub.mobileads.util;

import com.mopub.mobileads.util.Base64$Coder;

class Base64$Decoder extends Base64$Coder {
   private static final int[] DECODE;
   private static final int[] DECODE_WEBSAFE;
   private static final int EQUALS = -2;
   private static final int SKIP = -1;
   private final int[] alphabet;
   private int state;
   private int value;

   static {
      int[] var0 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
      DECODE = var0;
      var0 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
      DECODE_WEBSAFE = var0;
   }

   public Base64$Decoder(int var1, byte[] var2) {
      this.output = var2;
      int[] var3;
      if((var1 & 8) == 0) {
         var3 = DECODE;
      } else {
         var3 = DECODE_WEBSAFE;
      }

      this.alphabet = var3;
      this.state = 0;
      this.value = 0;
   }

   public int maxOutputSize(int var1) {
      return var1 * 3 / 4 + 10;
   }

   public boolean process(byte[] var1, int var2, int var3, boolean var4) {
      if(this.state == 6) {
         return false;
      } else {
         int var10 = var3 + var2;
         var3 = this.state;
         int var5 = this.value;
         int var6 = 0;
         byte[] var11 = this.output;
         int[] var12 = this.alphabet;

         int var8;
         while(true) {
            if(var2 >= var10) {
               var8 = var5;
               var5 = var6;
               break;
            }

            int var7 = var6;
            var8 = var5;
            int var9 = var2;
            if(var3 == 0) {
               var7 = var2;

               for(var2 = var5; var7 + 4 <= var10; var7 += 4) {
                  var2 = var12[var1[var7] & 255] << 18 | var12[var1[var7 + 1] & 255] << 12 | var12[var1[var7 + 2] & 255] << 6 | var12[var1[var7 + 3] & 255];
                  if(var2 < 0) {
                     break;
                  }

                  var11[var6 + 2] = (byte)var2;
                  var11[var6 + 1] = (byte)(var2 >> 8);
                  var11[var6] = (byte)(var2 >> 16);
                  var6 += 3;
               }

               var5 = var6;
               var8 = var2;
               if(var7 >= var10) {
                  break;
               }

               var9 = var7;
               var8 = var2;
               var7 = var6;
            }

            var2 = var9 + 1;
            var5 = var12[var1[var9] & 255];
            switch(var3) {
            case 0:
               if(var5 >= 0) {
                  ++var3;
                  var6 = var7;
                  continue;
               }

               if(var5 != -1) {
                  this.state = 6;
                  return false;
               }
               break;
            case 1:
               if(var5 >= 0) {
                  var5 |= var8 << 6;
                  ++var3;
                  var6 = var7;
                  continue;
               }

               if(var5 != -1) {
                  this.state = 6;
                  return false;
               }
               break;
            case 2:
               if(var5 >= 0) {
                  var5 |= var8 << 6;
                  ++var3;
                  var6 = var7;
                  continue;
               }

               if(var5 == -2) {
                  var11[var7] = (byte)(var8 >> 4);
                  var3 = 4;
                  var6 = var7 + 1;
                  var5 = var8;
                  continue;
               }

               if(var5 != -1) {
                  this.state = 6;
                  return false;
               }
               break;
            case 3:
               if(var5 >= 0) {
                  var5 |= var8 << 6;
                  var11[var7 + 2] = (byte)var5;
                  var11[var7 + 1] = (byte)(var5 >> 8);
                  var11[var7] = (byte)(var5 >> 16);
                  var6 = var7 + 3;
                  var3 = 0;
                  continue;
               }

               if(var5 == -2) {
                  var11[var7 + 1] = (byte)(var8 >> 2);
                  var11[var7] = (byte)(var8 >> 10);
                  var6 = var7 + 2;
                  var3 = 5;
                  var5 = var8;
                  continue;
               }

               if(var5 != -1) {
                  this.state = 6;
                  return false;
               }
               break;
            case 4:
               if(var5 == -2) {
                  ++var3;
                  var6 = var7;
                  var5 = var8;
                  continue;
               }

               if(var5 != -1) {
                  this.state = 6;
                  return false;
               }
               break;
            case 5:
               if(var5 != -1) {
                  this.state = 6;
                  return false;
               }
            }

            var6 = var7;
            var5 = var8;
         }

         if(!var4) {
            this.state = var3;
            this.value = var8;
            this.op = var5;
            return true;
         } else {
            var2 = var5;
            switch(var3) {
            case 0:
               break;
            case 1:
               this.state = 6;
               return false;
            case 2:
               var11[var5] = (byte)(var8 >> 4);
               var2 = var5 + 1;
               break;
            case 3:
               var6 = var5 + 1;
               var11[var5] = (byte)(var8 >> 10);
               var2 = var6 + 1;
               var11[var6] = (byte)(var8 >> 2);
               break;
            case 4:
               this.state = 6;
               return false;
            default:
               var2 = var5;
            }

            this.state = var3;
            this.op = var2;
            return true;
         }
      }
   }
}
