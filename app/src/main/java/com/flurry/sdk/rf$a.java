package com.flurry.sdk;

final class rf$a {
   final Object a;
   final int b;
   rf$a c;

   public rf$a(Object var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final int a(Object var1, int var2) {
      System.arraycopy(this.a, 0, var1, var2, this.b);
      return this.b + var2;
   }

   public final Object a() {
      return this.a;
   }

   public final void a(rf$a var1) {
      if(this.c != null) {
         throw new IllegalStateException();
      } else {
         this.c = var1;
      }
   }

   public final rf$a b() {
      return this.c;
   }
}
