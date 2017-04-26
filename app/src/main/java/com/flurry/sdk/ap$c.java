package com.flurry.sdk;

public enum ap$c {
   a(0),
   b(1),
   c(2);

   private final int d;

   private ap$c(int var3) {
      this.d = var3;
   }

   public static ap$c a(int var0) {
      switch(var0) {
      case 0:
         return a;
      case 1:
         return b;
      case 2:
         return c;
      default:
         return null;
      }
   }
}
