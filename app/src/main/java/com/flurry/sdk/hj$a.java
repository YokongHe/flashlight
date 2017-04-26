package com.flurry.sdk;

public enum hj$a {
   a(true),
   b(false),
   c(false),
   d(false),
   e(false),
   f(false),
   g(false),
   h(false),
   i(true),
   j(true);

   final boolean k;

   private hj$a(boolean var3) {
      this.k = var3;
   }

   public static int a() {
      int var1 = 0;
      hj$a[] var4 = values();
      int var3 = var4.length;

      int var2;
      for(int var0 = 0; var0 < var3; var1 = var2) {
         hj$a var5 = var4[var0];
         var2 = var1;
         if(var5.b()) {
            var2 = var1 | var5.c();
         }

         ++var0;
      }

      return var1;
   }

   public final boolean a(int var1) {
      return (this.c() & var1) != 0;
   }

   public final boolean b() {
      return this.k;
   }

   public final int c() {
      return 1 << this.ordinal();
   }
}
