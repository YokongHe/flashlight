package com.ihandysoft.ad.b;

public final class b {
   public static int a(Object var0) {
      if(var0 != null) {
         if(var0 instanceof String) {
            return Integer.parseInt((String)var0);
         }

         if(var0 instanceof Number) {
            return ((Number)var0).intValue();
         }

         if(!(var0 instanceof Boolean)) {
            throw new IllegalArgumentException();
         }

         if(((Boolean)var0).booleanValue()) {
            return 1;
         }
      }

      return 0;
   }

   public static float b(Object var0) {
      if(var0 != null) {
         if(var0 instanceof String) {
            return Float.parseFloat((String)var0);
         }

         if(var0 instanceof Number) {
            return ((Number)var0).floatValue();
         }

         if(!(var0 instanceof Boolean)) {
            throw new IllegalArgumentException();
         }

         if(((Boolean)var0).booleanValue()) {
            return 1.0F;
         }
      }

      return 0.0F;
   }

   public static boolean c(Object var0) {
      if(var0 != null) {
         if(var0 instanceof String) {
            String var2 = ((String)var0).trim();
            if(var2.length() != 0) {
               char var1 = var2.charAt(0);
               if(var1 == 116 || var1 == 84 || var1 == 89 || var1 == 121) {
                  return true;
               }

               if(var1 >= 49 && var1 <= 57) {
                  return true;
               }
            }
         } else {
            if(var0 instanceof Boolean) {
               return ((Boolean)var0).booleanValue();
            }

            if(!(var0 instanceof Number)) {
               throw new IllegalArgumentException();
            }

            if(((Number)var0).doubleValue() == 0.0D) {
               return true;
            }
         }
      }

      return false;
   }
}
