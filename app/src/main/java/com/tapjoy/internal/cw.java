package com.tapjoy.internal;

public final class cw {
   public static RuntimeException a(Throwable var0) {
      Throwable var1 = (Throwable)com.tapjoy.internal.cu.a(var0);
      a(var1, Error.class);
      a(var1, RuntimeException.class);
      throw new RuntimeException(var0);
   }

   private static void a(Throwable var0, Class var1) {
      if(var0 != null && var1.isInstance(var0)) {
         throw (Throwable)var1.cast(var0);
      }
   }
}
