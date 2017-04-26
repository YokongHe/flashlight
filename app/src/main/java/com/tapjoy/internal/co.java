package com.tapjoy.internal;

import java.math.BigInteger;

public final class co extends Number {
   private final String a;

   public co(String var1) {
      this.a = var1;
   }

   public final double doubleValue() {
      return Double.parseDouble(this.a);
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof Number)) {
            return false;
         }

         Number var2 = (Number)var1;
         if(var2 instanceof Integer) {
            if(this.intValue() != var2.intValue()) {
               return false;
            }
         } else if(var2 instanceof Long) {
            if(this.longValue() != var2.longValue()) {
               return false;
            }
         } else if(var2 instanceof Float) {
            if(this.floatValue() != var2.floatValue()) {
               return false;
            }
         } else {
            if(!(var2 instanceof Double)) {
               return this.a.equals(var2.toString());
            }

            if(this.doubleValue() != var2.doubleValue()) {
               return false;
            }
         }
      }

      return true;
   }

   public final float floatValue() {
      return Float.parseFloat(this.a);
   }

   public final int intValue() {
      try {
         int var1 = Integer.parseInt(this.a);
         return var1;
      } catch (NumberFormatException var6) {
         long var2;
         try {
            var2 = Long.parseLong(this.a);
         } catch (NumberFormatException var5) {
            return (new BigInteger(this.a)).intValue();
         }

         return (int)var2;
      }
   }

   public final long longValue() {
      try {
         long var1 = Long.parseLong(this.a);
         return var1;
      } catch (NumberFormatException var4) {
         return (new BigInteger(this.a)).longValue();
      }
   }

   public final String toString() {
      return this.a;
   }
}
