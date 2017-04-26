package com.flurry.sdk;

import com.flurry.sdk.jn$b;

public enum iy$a implements jn$b {
   a(true),
   b(true),
   c(true),
   d(true),
   e(true),
   f(true),
   g(false),
   h(false),
   i(false),
   j(false),
   k(true),
   l(false),
   m(false),
   n(true),
   o(false),
   p(false),
   q(false);

   final boolean r;

   private iy$a(boolean var3) {
      this.r = var3;
   }

   public final boolean a() {
      return this.r;
   }

   public final int b() {
      return 1 << this.ordinal();
   }
}
