package android.support.v4.util;

class ContainerHelpers {
   static final int[] EMPTY_INTS = new int[0];
   static final long[] EMPTY_LONGS = new long[0];
   static final Object[] EMPTY_OBJECTS = new Object[0];

   static int binarySearch(int[] var0, int var1, int var2) {
      int var3 = var1 - 1;
      var1 = 0;

      while(true) {
         if(var1 > var3) {
            var3 = ~var1;
            break;
         }

         int var4 = var1 + var3 >>> 1;
         int var5 = var0[var4];
         if(var5 < var2) {
            var1 = var4 + 1;
         } else {
            var3 = var4;
            if(var5 <= var2) {
               break;
            }

            var3 = var4 - 1;
         }
      }

      return var3;
   }

   static int binarySearch(long[] var0, int var1, long var2) {
      int var4 = var1 - 1;
      var1 = 0;

      while(true) {
         if(var1 > var4) {
            var4 = ~var1;
            break;
         }

         int var5 = var1 + var4 >>> 1;
         long var6 = var0[var5];
         if(var6 < var2) {
            var1 = var5 + 1;
         } else {
            var4 = var5;
            if(var6 <= var2) {
               break;
            }

            var4 = var5 - 1;
         }
      }

      return var4;
   }

   public static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static int idealByteArraySize(int var0) {
      int var1 = 4;

      int var2;
      while(true) {
         var2 = var0;
         if(var1 >= 32) {
            break;
         }

         if(var0 <= (1 << var1) - 12) {
            var2 = (1 << var1) - 12;
            break;
         }

         ++var1;
      }

      return var2;
   }

   public static int idealIntArraySize(int var0) {
      return idealByteArraySize(var0 * 4) / 4;
   }

   public static int idealLongArraySize(int var0) {
      return idealByteArraySize(var0 * 8) / 8;
   }
}
