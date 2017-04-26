package com.tapjoy.internal;

import com.tapjoy.internal.fs;

final class fr {
   static String a(String var0) {
      if(var0 != null && var0.length() != 0) {
         String var1 = var0.trim();
         if(var1 != null) {
            var0 = var1;
            if(var1.length() != 0) {
               return var0;
            }
         }

         return null;
      } else {
         var0 = null;
         return var0;
      }
   }

   static String a(String var0, String var1, String var2) {
      if(var0 == null) {
         fs.a(var1, var2, "must not be null");
         return null;
      } else if(var0.length() == 0) {
         fs.a(var1, var2, "must not be empty");
         return null;
      } else {
         var0 = var0.trim();
         if(var0.length() == 0) {
            fs.a(var1, var2, "must not be blank");
            return null;
         } else {
            return var0;
         }
      }
   }

   public static String b(String var0) {
      if(var0 != null && var0.length() != 0) {
         var0 = var0.trim();
         if(var0.length() != 0) {
            return var0;
         }
      }

      return null;
   }
}
