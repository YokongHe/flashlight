package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.gr$a;

class go$a extends gr$a {
   public fn a;

   public go$a(fn var1, fn var2) {
      super(var1);
      this.a = var2;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof go$a) {
         go$a var2 = (go$a)var1;
         if(this.b == var2.b && this.a == var2.a) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      return super.hashCode() + this.a.hashCode();
   }
}
