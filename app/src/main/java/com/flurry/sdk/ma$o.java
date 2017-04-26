package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;
import java.util.UUID;

final class ma$o extends ma {
   protected ma$o() {
      super(UUID.class);
   }

   // $FF: synthetic method
   public final Object b(String var1, iz var2) {
      return this.c(var1, var2);
   }

   public final UUID c(String var1, iz var2) {
      return UUID.fromString(var1);
   }
}
