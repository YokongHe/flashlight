package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;
import java.lang.reflect.Constructor;

final class ma$l extends ma {
   protected final Constructor b;

   public ma$l(Constructor var1) {
      super(var1.getDeclaringClass());
      this.b = var1;
   }

   public final Object b(String var1, iz var2) {
      return this.b.newInstance(new Object[]{var1});
   }
}
