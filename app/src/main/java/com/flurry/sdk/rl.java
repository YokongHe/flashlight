package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.rv;
import java.math.BigInteger;

public final class rl extends rv {
   protected final BigInteger c;

   public rl(BigInteger var1) {
      this.c = var1;
   }

   public static rl a(BigInteger var0) {
      return new rl(var0);
   }

   public final void a(hf var1, jw var2) {
      var1.a(this.c);
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         if(((rl)var1).c != this.c) {
            return false;
         }
      }

      return true;
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
