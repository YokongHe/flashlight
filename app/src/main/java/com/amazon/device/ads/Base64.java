package com.amazon.device.ads;

import com.amazon.device.ads.StringUtils;

class Base64 {
   private static final String ENCODE_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

   public static byte[] decode(String var0) {
      int var2 = 0;
      if(StringUtils.isNullOrWhiteSpace(var0)) {
         throw new IllegalArgumentException("Encoded String must not be null or white space");
      } else {
         int var4 = getDecodedLength(var0);
         if(var4 <= 0) {
            throw new IllegalArgumentException("Encoded String decodes to zero bytes");
         } else {
            byte[] var7 = new byte[var4];

            for(int var1 = 0; var2 < var0.length() && var1 < var4 && (var2 % 4 != 0 || var0.length() >= var2 + 4); ++var2) {
               int var5 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(var0.charAt(var2));
               if(var5 == -1) {
                  break;
               }

               int var3;
               switch(var2 % 4) {
               case 0:
                  var7[var1] = (byte)(var5 << 2);
                  break;
               case 1:
                  var3 = var1 + 1;
                  var7[var1] |= (byte)(var5 >> 4 & 3);
                  var1 = var3;
                  if(var3 < var4) {
                     var7[var3] = (byte)(var5 << 4);
                     var1 = var3;
                  }
                  break;
               case 2:
                  var3 = var1 + 1;
                  var7[var1] |= (byte)(var5 >> 2 & 15);
                  var1 = var3;
                  if(var3 < var4) {
                     var7[var3] = (byte)(var5 << 6);
                     var1 = var3;
                  }
                  break;
               case 3:
                  var3 = var1 + 1;
                  byte var6 = var7[var1];
                  var7[var1] = (byte)((byte)(var5 & 63) | var6);
                  var1 = var3;
               }
            }

            return var7;
         }
      }
   }

   private static int getDecodedLength(String var0) {
      int var2 = var0.indexOf("=");
      int var1 = 0;
      if(var2 >= 0) {
         var1 = var0.length() - var2;
      }

      return (var0.length() + 3) / 4 * 3 - var1;
   }
}
