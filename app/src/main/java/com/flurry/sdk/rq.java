package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.ij;
import com.flurry.sdk.jw;
import com.flurry.sdk.rv;

public final class rq extends rv {
   protected final double c;

   public rq(double var1) {
      this.c = var1;
   }

   public static rq b(double var0) {
      return new rq(var0);
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

         if(((rq)var1).c != this.c) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      long var2 = Double.doubleToLongBits(this.c);
      int var1 = (int)var2;
      return (int)(var2 >> 32) ^ var1;
   }

   public final int k() {
      return (int)this.c;
   }

   public final long l() {
      return (long)this.c;
   }

   public final double m() {
      return this.c;
   }

   public final String n() {
      return ij.a(this.c);
   }
}
