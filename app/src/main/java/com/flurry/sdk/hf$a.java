package com.flurry.sdk;

public enum hf$a {
   a(true),
   b(true),
   c(true),
   d(true),
   e(false),
   f(true),
   g(false);

   final boolean h;
   final int i;

   private hf$a(boolean var3) {
      this.h = var3;
      this.i = 1 << this.ordinal();
   }

   public static int a() {
      int var1 = 0;
      hf$a[] var4 = values();
      int var3 = var4.length;

      int var2;
      for(int var0 = 0; var0 < var3; var1 = var2) {
         hf$a var5 = var4[var0];
         var2 = var1;
         if(var5.b()) {
            var2 = var1 | var5.c();
         }

         ++var0;
      }

      return var1;
   }

   public final boolean b() {
      return this.h;
   }

   public final int c() {
      return this.i;
   }
}
