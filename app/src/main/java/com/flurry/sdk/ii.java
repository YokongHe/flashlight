package com.flurry.sdk;

public final class ii {
   static final String a = String.valueOf(Long.MIN_VALUE).substring(1);
   static final String b = String.valueOf(Long.MAX_VALUE);

   public static double a(String var0, double var1) {
      if(var0 != null) {
         var0 = var0.trim();
         if(var0.length() != 0) {
            try {
               double var3 = c(var0);
               return var3;
            } catch (NumberFormatException var5) {
               return var1;
            }
         }
      }

      return var1;
   }

   public static final int a(String var0) {
      byte var3 = 1;
      char var1 = var0.charAt(0);
      int var5 = var0.length();
      boolean var2;
      if(var1 == 45) {
         var2 = true;
      } else {
         var2 = false;
      }

      int var8;
      if(var2) {
         if(var5 == 1 || var5 > 10) {
            var8 = Integer.parseInt(var0);
            return var8;
         }

         var1 = var0.charAt(1);
         var3 = 2;
      } else if(var5 > 9) {
         return Integer.parseInt(var0);
      }

      if(var1 > 57 || var1 < 48) {
         return Integer.parseInt(var0);
      } else {
         int var4 = var1 - 48;
         int var7 = var4;
         if(var3 < var5) {
            int var6 = var3 + 1;
            var1 = var0.charAt(var3);
            if(var1 > 57 || var1 < 48) {
               return Integer.parseInt(var0);
            }

            var8 = var4 * 10 + (var1 - 48);
            var7 = var8;
            if(var6 < var5) {
               var4 = var6 + 1;
               var1 = var0.charAt(var6);
               if(var1 > 57 || var1 < 48) {
                  return Integer.parseInt(var0);
               }

               var8 = var8 * 10 + (var1 - 48);
               var7 = var8;
               if(var4 < var5) {
                  var7 = var8;

                  while(true) {
                     var8 = var4 + 1;
                     char var9 = var0.charAt(var4);
                     if(var9 > 57 || var9 < 48) {
                        return Integer.parseInt(var0);
                     }

                     var7 = var7 * 10 + (var9 - 48);
                     if(var8 >= var5) {
                        break;
                     }

                     var4 = var8;
                  }
               }
            }
         }

         var8 = var7;
         if(var2) {
            return -var7;
         } else {
            return var8;
         }
      }
   }

   public static final int a(char[] var0, int var1, int var2) {
      int var3 = var0[var1] - 48;
      int var4 = var2 + var1;
      int var5 = var1 + 1;
      var1 = var3;
      if(var5 < var4) {
         var2 = var3 * 10 + (var0[var5] - 48);
         var3 = var5 + 1;
         var1 = var2;
         if(var3 < var4) {
            var2 = var2 * 10 + (var0[var3] - 48);
            ++var3;
            var1 = var2;
            if(var3 < var4) {
               var2 = var2 * 10 + (var0[var3] - 48);
               ++var3;
               var1 = var2;
               if(var3 < var4) {
                  var2 = var2 * 10 + (var0[var3] - 48);
                  ++var3;
                  var1 = var2;
                  if(var3 < var4) {
                     var2 = var2 * 10 + (var0[var3] - 48);
                     ++var3;
                     var1 = var2;
                     if(var3 < var4) {
                        var2 = var2 * 10 + (var0[var3] - 48);
                        ++var3;
                        var1 = var2;
                        if(var3 < var4) {
                           var2 = var2 * 10 + (var0[var3] - 48);
                           ++var3;
                           var1 = var2;
                           if(var3 < var4) {
                              var1 = var2 * 10 + (var0[var3] - 48);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var1;
   }

   public static final boolean a(String var0, boolean var1) {
      String var5;
      if(var1) {
         var5 = a;
      } else {
         var5 = b;
      }

      int var3 = var5.length();
      int var2 = var0.length();
      if(var2 < var3) {
         return true;
      } else if(var2 > var3) {
         return false;
      } else {
         for(var2 = 0; var2 < var3; ++var2) {
            int var4 = var0.charAt(var2) - var5.charAt(var2);
            if(var4 != 0) {
               if(var4 < 0) {
                  return true;
               }

               return false;
            }
         }

         return true;
      }
   }

   public static final boolean a(char[] var0, int var1, int var2, boolean var3) {
      String var6;
      if(var3) {
         var6 = a;
      } else {
         var6 = b;
      }

      int var4 = var6.length();
      if(var2 < var4) {
         return true;
      } else if(var2 > var4) {
         return false;
      } else {
         for(var2 = 0; var2 < var4; ++var2) {
            int var5 = var0[var1 + var2] - var6.charAt(var2);
            if(var5 != 0) {
               if(var5 < 0) {
                  return true;
               }

               return false;
            }
         }

         return true;
      }
   }

   public static final long b(String var0) {
      return var0.length() <= 9?(long)a(var0):Long.parseLong(var0);
   }

   public static final long b(char[] var0, int var1, int var2) {
      var2 -= 9;
      long var3 = (long)a(var0, var1, var2);
      return (long)a(var0, var2 + var1, 9) + var3 * 1000000000L;
   }

   public static final double c(String var0) {
      return "2.2250738585072012e-308".equals(var0)?2.2250738585072014E-308D:Double.parseDouble(var0);
   }
}
