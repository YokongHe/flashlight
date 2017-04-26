package com.tapjoy.internal;

import com.tapjoy.internal.em;

public enum fc$c {
   a,
   b,
   c,
   d,
   e,
   f,
   g,
   h,
   i,
   j,
   k;

   private final String l;
   private final String m;

   private fc$c() {
      em var3 = em.valueOf(this.name());
      this.l = var3.toString();
      this.m = var3.a();
   }

   static fc$c a(em var0) {
      return valueOf(var0.name());
   }

   public final String a() {
      return this.m;
   }

   final em b() {
      return em.valueOf(this.name());
   }

   public final String toString() {
      return this.l;
   }
}
