package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.rz;

public final class rx extends rz {
   protected final Object c;

   public rx(Object var1) {
      this.c = var1;
   }

   public final double a(double var1) {
      if(this.c instanceof Number) {
         var1 = ((Number)this.c).doubleValue();
      }

      return var1;
   }

   public final void a(hf var1, jw var2) {
      if(this.c == null) {
         var1.f();
      } else {
         var1.a(this.c);
      }
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         rx var2 = (rx)var1;
         if(this.c != null) {
            return this.c.equals(var2.c);
         }

         if(var2.c != null) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return this.c.hashCode();
   }

   public final String n() {
      return this.c == null?"null":this.c.toString();
   }

   public final String toString() {
      return String.valueOf(this.c);
   }
}
