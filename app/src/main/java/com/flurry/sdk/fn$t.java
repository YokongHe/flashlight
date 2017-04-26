package com.flurry.sdk;

class fn$t {
   private Object a;
   private Object b;

   private fn$t(Object var1, Object var2) {
      this.a = var1;
      this.b = var2;
   }

   // $FF: synthetic method
   fn$t(Object var1, Object var2, Object var3) {
      this(var1, var2);
   }

   public boolean equals(Object var1) {
      return this.a == ((fn$t)var1).a && this.b == ((fn$t)var1).b;
   }

   public int hashCode() {
      return System.identityHashCode(this.a) + System.identityHashCode(this.b);
   }
}
