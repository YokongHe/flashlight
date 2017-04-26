package com.flurry.sdk;

import com.flurry.sdk.fn;

class gr$a {
   public final fn b;

   public gr$a(fn var1) {
      this.b = var1;
   }

   public boolean equals(Object var1) {
      return var1 instanceof gr$a && this.b == ((gr$a)var1).b;
   }

   public int hashCode() {
      return this.b.hashCode();
   }
}
