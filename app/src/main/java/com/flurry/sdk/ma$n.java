package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;

final class ma$n extends ma {
   private static final ma$n b = new ma$n(String.class);
   private static final ma$n c = new ma$n(Object.class);

   private ma$n(Class var1) {
      super(var1);
   }

   public static ma$n a(Class var0) {
      return var0 == String.class?b:(var0 == Object.class?c:new ma$n(var0));
   }

   // $FF: synthetic method
   public final Object b(String var1, iz var2) {
      return this.c(var1, var2);
   }

   public final String c(String var1, iz var2) {
      return var1;
   }
}
