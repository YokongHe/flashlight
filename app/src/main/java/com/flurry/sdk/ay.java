package com.flurry.sdk;

public enum ay {
   a(0),
   b(1),
   c(2),
   d(3);

   private final int e;

   private ay(int var3) {
      this.e = var3;
   }

   public static com.flurry.sdk.ay a(int var0) {
      switch(var0) {
      case 0:
         return a;
      case 1:
         return b;
      case 2:
         return c;
      case 3:
         return d;
      default:
         return null;
      }
   }

   public final int a() {
      return this.e;
   }
}
