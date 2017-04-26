package com.ihandysoft.ad;

public enum b {
   a(0),
   b(1),
   c(2),
   d(3),
   e(100);

   private int f;

   private b(int var3) {
      this.f = var3;
   }

   public static com.ihandysoft.ad.b a(int var0) {
      switch(var0) {
      case 0:
         return a;
      case 1:
         return b;
      case 2:
         return c;
      case 3:
         return d;
      case 100:
         return e;
      default:
         return null;
      }
   }
}
