package com.flurry.sdk;

final class re$a {
   final Object[] a;
   re$a b;

   public re$a(Object[] var1) {
      this.a = var1;
   }

   public final void a(re$a var1) {
      if(this.b != null) {
         throw new IllegalStateException();
      } else {
         this.b = var1;
      }
   }

   public final Object[] a() {
      return this.a;
   }

   public final re$a b() {
      return this.b;
   }
}
