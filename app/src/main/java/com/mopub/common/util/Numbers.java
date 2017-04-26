package com.mopub.common.util;

public class Numbers {
   public static Double parseDouble(Object var0) {
      if(var0 instanceof Number) {
         return Double.valueOf(((Number)var0).doubleValue());
      } else if(var0 instanceof String) {
         try {
            Double var1 = Double.valueOf((String)var0);
            return var1;
         } catch (NumberFormatException var2) {
            throw new ClassCastException("Unable to parse " + var0 + " as double.");
         }
      } else {
         throw new ClassCastException("Unable to parse " + var0 + " as double.");
      }
   }
}
