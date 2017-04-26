package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.gs;
import com.flurry.sdk.gv;

public abstract class gw implements gv, Comparable {
   public int a(gv var1) {
      return gs.b().a(this, var1, this.a());
   }

   public abstract fn a();

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((gv)var1);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof gv)) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         if(this.a((gv)var1) != 0) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return gs.b().b(this, this.a());
   }

   public String toString() {
      return gs.b().a((Object)this);
   }
}
