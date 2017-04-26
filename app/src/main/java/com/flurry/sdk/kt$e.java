package com.flurry.sdk;

import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.sh;

public final class kt$e {
   private final Object a;
   private final boolean b;
   private final Class c;

   protected kt$e(sh var1, Object var2) {
      this.a = var2;
      this.b = var1.t();
      this.c = var1.p();
   }

   public final Object a(iz var1) {
      if(this.b && var1.a(iy$a.l)) {
         throw var1.b("Can not map JSON null into type " + this.c.getName() + " (set DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES to \'false\' to allow)");
      } else {
         return this.a;
      }
   }
}
