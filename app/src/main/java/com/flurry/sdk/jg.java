package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jy;

public abstract class jg {
   public jg a() {
      return this;
   }

   public abstract Object a(hj var1, iz var2);

   public Object a(hj var1, iz var2, jy var3) {
      return var3.d(var1, var2);
   }

   public Object a(hj var1, iz var2, Object var3) {
      throw new UnsupportedOperationException();
   }

   public Object b() {
      return null;
   }

   public Object c() {
      return this.b();
   }
}
