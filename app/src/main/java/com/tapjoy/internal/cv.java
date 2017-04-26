package com.tapjoy.internal;

public final class cv {
   public static String a(String var0) {
      String var1 = var0;
      if(var0 == null) {
         var1 = "";
      }

      return var1;
   }

   public static String b(String var0) {
      String var1 = var0;
      if(c(var0)) {
         var1 = null;
      }

      return var1;
   }

   public static boolean c(String var0) {
      return var0 == null || var0.length() == 0;
   }
}
