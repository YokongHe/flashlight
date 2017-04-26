package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;
import java.lang.reflect.Method;

final class ma$m extends ma {
   final Method b;

   public ma$m(Method var1) {
      super(var1.getDeclaringClass());
      this.b = var1;
   }

   public final Object b(String var1, iz var2) {
      return this.b.invoke((Object)null, new Object[]{var1});
   }
}
