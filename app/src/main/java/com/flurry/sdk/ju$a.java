package com.flurry.sdk;

import com.flurry.sdk.jn$b;

public enum ju$a implements jn$b {
   a(true),
   b(true),
   c(true),
   d(true),
   e(true),
   f(false),
   @Deprecated
   g(true),
   h(false),
   i(true),
   j(false),
   k(false),
   l(false),
   m(true),
   n(true),
   o(false),
   p(true),
   q(true),
   r(false),
   s(false),
   t(false),
   u(false),
   v(true),
   w(true);

   final boolean x;

   private ju$a(boolean var3) {
      this.x = var3;
   }

   public final boolean a() {
      return this.x;
   }

   public final int b() {
      return 1 << this.ordinal();
   }
}
