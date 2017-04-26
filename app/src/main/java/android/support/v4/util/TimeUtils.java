package android.support.v4.util;

import java.io.PrintWriter;

public class TimeUtils {
   public static final int HUNDRED_DAY_FIELD_LEN = 19;
   private static final int SECONDS_PER_DAY = 86400;
   private static final int SECONDS_PER_HOUR = 3600;
   private static final int SECONDS_PER_MINUTE = 60;
   private static char[] sFormatStr = new char[24];
   private static final Object sFormatSync = new Object();

   private static int accumField(int var0, int var1, boolean var2, int var3) {
      return var0 <= 99 && (!var2 || var3 < 3)?(var0 > 9 || var2 && var3 >= 2?var1 + 2:(!var2 && var0 <= 0?0:var1 + 1)):var1 + 3;
   }

   public static void formatDuration(long var0, long var2, PrintWriter var4) {
      if(var0 == 0L) {
         var4.print("--");
      } else {
         formatDuration(var0 - var2, var4, 0);
      }
   }

   public static void formatDuration(long var0, PrintWriter var2) {
      formatDuration(var0, var2, 0);
   }

   public static void formatDuration(long var0, PrintWriter var2, int var3) {
      Object var4 = sFormatSync;
      synchronized(var4) {
         var3 = formatDurationLocked(var0, var3);
         var2.print(new String(sFormatStr, 0, var3));
      }
   }

   public static void formatDuration(long var0, StringBuilder var2) {
      Object var4 = sFormatSync;
      synchronized(var4) {
         int var3 = formatDurationLocked(var0, 0);
         var2.append(sFormatStr, 0, var3);
      }
   }

   private static int formatDurationLocked(long var0, int var2) {
      if(sFormatStr.length < var2) {
         sFormatStr = new char[var2];
      }

      char[] var13 = sFormatStr;
      if(var0 == 0L) {
         while(var2 - 1 > 0) {
            var13[0] = 32;
         }

         var13[0] = 48;
         return 1;
      } else {
         byte var3;
         if(var0 > 0L) {
            var3 = 43;
         } else {
            var0 = -var0;
            var3 = 45;
         }

         int var11 = (int)(var0 % 1000L);
         int var6 = (int)Math.floor((double)(var0 / 1000L));
         int var5 = 0;
         int var4 = var6;
         if(var6 > 86400) {
            var5 = var6 / 86400;
            var4 = var6 - 86400 * var5;
         }

         int var7;
         if(var4 > 3600) {
            var6 = var4 / 3600;
            var7 = var6;
            var4 -= var6 * 3600;
         } else {
            var7 = 0;
         }

         int var8;
         if(var4 > 60) {
            var6 = var4 / 60;
            var8 = var6;
            var6 = var4 - var6 * 60;
         } else {
            var8 = 0;
            var6 = var4;
         }

         int var9;
         int var10;
         boolean var12;
         byte var16;
         if(var2 != 0) {
            var4 = accumField(var5, 1, false, 0);
            if(var4 > 0) {
               var12 = true;
            } else {
               var12 = false;
            }

            var4 += accumField(var7, 1, var12, 2);
            if(var4 > 0) {
               var12 = true;
            } else {
               var12 = false;
            }

            var4 += accumField(var8, 1, var12, 2);
            if(var4 > 0) {
               var12 = true;
            } else {
               var12 = false;
            }

            var9 = var4 + accumField(var6, 1, var12, 2);
            if(var9 > 0) {
               var16 = 3;
            } else {
               var16 = 0;
            }

            var10 = accumField(var11, 2, true, var16);
            var4 = 0;
            var9 += var10 + 1;

            while(true) {
               var10 = var4;
               if(var9 >= var2) {
                  break;
               }

               var13[var4] = 32;
               ++var9;
               ++var4;
            }
         } else {
            var10 = 0;
         }

         var13[var10] = (char)var3;
         var9 = var10 + 1;
         boolean var14;
         if(var2 != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         var5 = printField(var13, var5, 'd', var9, false, 0);
         if(var5 != var9) {
            var12 = true;
         } else {
            var12 = false;
         }

         if(var14) {
            var16 = 2;
         } else {
            var16 = 0;
         }

         var5 = printField(var13, var7, 'h', var5, var12, var16);
         if(var5 != var9) {
            var12 = true;
         } else {
            var12 = false;
         }

         if(var14) {
            var16 = 2;
         } else {
            var16 = 0;
         }

         var5 = printField(var13, var8, 'm', var5, var12, var16);
         if(var5 != var9) {
            var12 = true;
         } else {
            var12 = false;
         }

         if(var14) {
            var16 = 2;
         } else {
            var16 = 0;
         }

         var4 = printField(var13, var6, 's', var5, var12, var16);
         byte var15;
         if(var14 && var4 != var9) {
            var15 = 3;
         } else {
            var15 = 0;
         }

         var2 = printField(var13, var11, 'm', var4, true, var15);
         var13[var2] = 115;
         return var2 + 1;
      }
   }

   private static int printField(char[] var0, int var1, char var2, int var3, boolean var4, int var5) {
      int var6;
      if(!var4) {
         var6 = var3;
         if(var1 <= 0) {
            return var6;
         }
      }

      int var7;
      if((!var4 || var5 < 3) && var1 <= 99) {
         var6 = var3;
      } else {
         var7 = var1 / 100;
         var0[var3] = (char)(var7 + 48);
         var6 = var3 + 1;
         var1 -= var7 * 100;
      }

      label42: {
         if((!var4 || var5 < 2) && var1 <= 9) {
            var7 = var6;
            var5 = var1;
            if(var3 == var6) {
               break label42;
            }
         }

         var3 = var1 / 10;
         var0[var6] = (char)(var3 + 48);
         var7 = var6 + 1;
         var5 = var1 - var3 * 10;
      }

      var0[var7] = (char)(var5 + 48);
      var1 = var7 + 1;
      var0[var1] = var2;
      var6 = var1 + 1;
      return var6;
   }
}
