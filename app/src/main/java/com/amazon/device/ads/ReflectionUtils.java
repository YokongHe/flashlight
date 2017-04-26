package com.amazon.device.ads;

class ReflectionUtils {
   public static boolean isClassAvailable(String var0) {
      try {
         Class.forName(var0);
         return true;
      } catch (ClassNotFoundException var1) {
         return false;
      }
   }
}
