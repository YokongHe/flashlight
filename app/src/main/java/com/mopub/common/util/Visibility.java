package com.mopub.common.util;

public class Visibility {
   public static boolean hasScreenVisibilityChanged(int var0, int var1) {
      return isScreenVisible(var0) ^ isScreenVisible(var1);
   }

   public static boolean isScreenVisible(int var0) {
      return var0 == 0;
   }
}
