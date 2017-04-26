package com.tapjoy.internal;

import com.tapjoy.internal.dm$a;
import com.tapjoy.internal.dm$b;

public enum gk$i implements dm$a {
   a(0),
   b(1),
   c(2);

   private static dm$b d;
   private final int e;

   static {
      d = new dm$b() {
      };
   }

   private gk$i(int var3) {
      this.e = var3;
   }

   public static gk$i a(int var0) {
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

   public final int a() {
      return this.e;
   }
}
