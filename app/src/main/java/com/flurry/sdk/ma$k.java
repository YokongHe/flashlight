package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;

final class ma$k extends ma {
   ma$k() {
      super(Integer.class);
   }

   // $FF: synthetic method
   public final Object b(String var1, iz var2) {
      return this.c(var1, var2);
   }

   public final Short c(String var1, iz var2) {
      int var3 = this.a(var1);
      if(var3 >= -32768 && var3 <= 32767) {
         return Short.valueOf((short)var3);
      } else {
         throw var2.a(this.a, var1, "overflow, value can not be represented as 16-bit value");
      }
   }
}
