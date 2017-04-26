package com.millennialmedia.a.a.b;

import java.math.BigInteger;

public final class i extends Number {
   private final String a;

   public i(String var1) {
      this.a = var1;
   }

   public final double doubleValue() {
      return Double.parseDouble(this.a);
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
