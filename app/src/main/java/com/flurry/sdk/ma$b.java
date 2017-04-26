package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;

final class ma$b extends ma {
   ma$b() {
      super(Byte.class);
   }

   // $FF: synthetic method
   public final Object b(String var1, iz var2) {
      return this.c(var1, var2);
   }

   public final Byte c(String var1, iz var2) {
      int var3 = this.a(var1);
      if(var3 >= -128 && var3 <= 127) {
         return Byte.valueOf((byte)var3);
      } else {
         throw var2.a(this.a, var1, "overflow, value can not be represented as 8-bit value");
      }
   }
}
