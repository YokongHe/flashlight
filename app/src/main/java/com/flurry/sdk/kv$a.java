package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;

public final class kv$a extends jg {
   final jy a;
   final jg b;

   public kv$a(jy var1, jg var2) {
      this.a = var1;
      this.b = var2;
   }

   public final Object a(hj var1, iz var2) {
      return this.b.a(var1, var2, this.a);
   }

   public final Object a(hj var1, iz var2, jy var3) {
      throw new IllegalStateException("Type-wrapped deserializer\'s deserializeWithType should never get called");
   }
}
