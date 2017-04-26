package com.mopub.common.util;

import java.util.concurrent.atomic.AtomicLong;

public class Utils {
   private static final AtomicLong sNextGeneratedId = new AtomicLong(1L);

   public static boolean bitMaskContainsFlag(int var0, int var1) {
      return (var0 & var1) != 0;
   }

   public static long generateUniqueId() {
      long var0;
      long var4;
      do {
         var4 = sNextGeneratedId.get();
         long var2 = var4 + 1L;
         var0 = var2;
         if(var2 > 9223372036854775806L) {
            var0 = 1L;
         }
      } while(!sNextGeneratedId.compareAndSet(var4, var0));

      return var4;
   }

   public static String sha1(String param0) {
      // $FF: Couldn't be decompiled
   }
}
