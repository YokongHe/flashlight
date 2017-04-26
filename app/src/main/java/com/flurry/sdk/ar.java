package com.flurry.sdk;

public enum ar {
   a(0),
   b(1),
   c(2),
   d(3),
   e(4),
   f(5),
   g(6);

   private final int h;

   private ar(int var3) {
      this.h = var3;
   }

   public static com.flurry.sdk.ar a(int var0) {
      switch(var0) {
      case 0:
         return a;
      case 1:
         return b;
      case 2:
         return c;
      case 3:
         return d;
      case 4:
         return e;
      case 5:
         return f;
      case 6:
         return g;
      default:
         return null;
      }
   }

   public final int a() {
      return this.h;
   }
}
