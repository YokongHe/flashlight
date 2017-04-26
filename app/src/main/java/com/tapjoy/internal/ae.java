package com.tapjoy.internal;

public final class ae {
   public static Object a(com.tapjoy.internal.bg var0) {
      int var1 = 1;

      while(true) {
         try {
            Object var2 = var0.call();
            return var2;
         } catch (OutOfMemoryError var3) {
            if(var1 >= 10) {
               throw var3;
            }

            System.gc();
            ++var1;
         }
      }
   }
}
