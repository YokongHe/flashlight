package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.rv;
import java.math.BigDecimal;

public final class rp extends rv {
   protected final BigDecimal c;

   public rp(BigDecimal var1) {
      this.c = var1;
   }

   public static rp a(BigDecimal var0) {
      return new rp(var0);
   }

   public final void a(hf var1, jw var2) {
      var1.a(this.c);
   }

   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if(var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if(var1 != null) {
            var2 = var3;
            if(var1.getClass() == this.getClass()) {
               return ((rp)var1).c.equals(this.c);
            }
         }
      }

      return var2;
   }

   public final int hashCode() {
      return this.c.hashCode();
   }

   public final int k() {
      return this.c.intValue();
   }

   public final long l() {
      return this.c.longValue();
   }

   public final double m() {
      return this.c.doubleValue();
   }

   public final String n() {
      return this.c.toString();
   }
}
