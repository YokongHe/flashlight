package com.tapjoy.internal;

final class dw {
   static int a(int var0, int var1) {
      return var0 <= -12 && var1 <= -65?var1 << 8 ^ var0:-1;
   }

   static int a(int var0, int var1, int var2) {
      return var0 <= -12 && var1 <= -65 && var2 <= -65?var1 << 8 ^ var0 ^ var2 << 16:-1;
   }

   public static int a(byte[] var0, int var1, int var2) {
      int var3;
      for(var3 = var1; var3 < var2 && var0[var3] >= 0; ++var3) {
         ;
      }

      var1 = var3;
      byte var6;
      if(var3 >= var2) {
         var6 = 0;
         return var6;
      } else {
         int var5;
         label82:
         do {
            while(true) {
               while(var1 < var2) {
                  var3 = var1 + 1;
                  byte var4 = var0[var1];
                  if(var4 < 0) {
                     if(var4 >= -32) {
                        if(var4 < -16) {
                           if(var3 >= var2 - 1) {
                              return b(var0, var3, var2);
                           }

                           var5 = var3 + 1;
                           var6 = var0[var3];
                           if(var6 > -65 || var4 == -32 && var6 < -96 || var4 == -19 && var6 >= -96) {
                              return -1;
                           }

                           var1 = var5 + 1;
                           continue label82;
                        }

                        if(var3 >= var2 - 2) {
                           return b(var0, var3, var2);
                        }

                        var1 = var3 + 1;
                        byte var7 = var0[var3];
                        if(var7 > -65 || (var4 << 28) + var7 + 112 >> 30 != 0) {
                           return -1;
                        }

                        var3 = var1 + 1;
                        if(var0[var1] > -65) {
                           return -1;
                        }

                        var1 = var3 + 1;
                        if(var0[var3] > -65) {
                           return -1;
                        }
                     } else {
                        var6 = var4;
                        if(var3 >= var2) {
                           return var6;
                        }

                        if(var4 < -62) {
                           return -1;
                        }

                        var1 = var3 + 1;
                        if(var0[var3] > -65) {
                           return -1;
                        }
                     }
                  } else {
                     var1 = var3;
                  }
               }

               return 0;
            }
         } while(var0[var5] <= -65);

         return -1;
      }
   }

   private static int b(byte[] var0, int var1, int var2) {
      byte var3 = var0[var1 - 1];
      switch(var2 - var1) {
      case 0:
         byte var4 = var3;
         if(var3 > -12) {
            var4 = -1;
         }

         return var4;
      case 1:
         return a(var3, var0[var1]);
      case 2:
         return a(var3, var0[var1], var0[var1 + 1]);
      default:
         throw new AssertionError();
      }
   }
}
