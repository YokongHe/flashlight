package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fx;
import com.flurry.sdk.ga;
import java.util.Arrays;

public class ft$c implements fx, Comparable {
   private fn a;
   private byte[] b;

   protected ft$c() {
   }

   public ft$c(fn var1) {
      this.a(var1);
   }

   public int a(ft$c var1) {
      return ga.a(this.b, 0, this.b.length, var1.b, 0, var1.b.length);
   }

   public fn a() {
      return this.a;
   }

   protected void a(fn var1) {
      this.a = var1;
      this.b = new byte[var1.l()];
   }

   public byte[] b() {
      return this.b;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((ft$c)var1);
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof fx && Arrays.equals(this.b, ((fx)var1).b());
   }

   public int hashCode() {
      return Arrays.hashCode(this.b);
   }

   public String toString() {
      return Arrays.toString(this.b);
   }
}
