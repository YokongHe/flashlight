package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fw;

public class ft$b implements fw {
   private fn a;
   private String b;

   public ft$b(fn var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public fn a() {
      return this.a;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof fw && this.b.equals(var1.toString());
   }

   public int hashCode() {
      return this.b.hashCode();
   }

   public String toString() {
      return this.b;
   }
}
