package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;

final class ma$d extends ma {
   ma$d() {
      super(Character.class);
   }

   // $FF: synthetic method
   public final Object b(String var1, iz var2) {
      return this.c(var1, var2);
   }

   public final Character c(String var1, iz var2) {
      if(var1.length() == 1) {
         return Character.valueOf(var1.charAt(0));
      } else {
         throw var2.a(this.a, var1, "can only convert 1-character Strings");
      }
   }
}
