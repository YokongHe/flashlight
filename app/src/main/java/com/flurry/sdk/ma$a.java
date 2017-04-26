package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;

final class ma$a extends ma {
   ma$a() {
      super(Boolean.class);
   }

   // $FF: synthetic method
   public final Object b(String var1, iz var2) {
      return this.c(var1, var2);
   }

   public final Boolean c(String var1, iz var2) {
      if("true".equals(var1)) {
         return Boolean.TRUE;
      } else if("false".equals(var1)) {
         return Boolean.FALSE;
      } else {
         throw var2.a(this.a, var1, "value not \'true\' or \'false\'");
      }
   }
}
