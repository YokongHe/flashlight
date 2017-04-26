package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.oi;

final class oo$b extends oi {
   protected final oi p;
   protected final Class q;

   protected oo$b(oi var1, Class var2) {
      super(var1);
      this.p = var1;
      this.q = var2;
   }

   public final oi a(jk var1) {
      return new oo$b(this.p.a(var1), this.q);
   }

   public final void a(Object var1, hf var2, jw var3) {
      Class var4 = var3.a();
      if(var4 == null || this.q.isAssignableFrom(var4)) {
         this.p.a(var1, var2, var3);
      }

   }
}
