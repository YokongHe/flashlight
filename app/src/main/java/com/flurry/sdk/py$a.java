package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.pf;

public abstract class py$a extends pf {
   protected final jz e;
   protected final is f;

   protected py$a(Class var1, jz var2, is var3) {
      super(var1);
      this.e = var2;
      this.f = var3;
   }

   public final void a(Object var1, hf var2, jw var3) {
      var2.b();
      this.b(var1, var2, var3);
      var2.c();
   }

   public final void a(Object var1, hf var2, jw var3, jz var4) {
      var4.c(var1, var2);
      this.b(var1, var2, var3);
      var4.f(var1, var2);
   }

   protected abstract void b(Object var1, hf var2, jw var3);
}
