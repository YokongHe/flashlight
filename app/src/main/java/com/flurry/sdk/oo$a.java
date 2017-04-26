package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.oi;

final class oo$a extends oi {
   protected final oi p;
   protected final Class[] q;

   protected oo$a(oi var1, Class[] var2) {
      super(var1);
      this.p = var1;
      this.q = var2;
   }

   public final oi a(jk var1) {
      return new oo$a(this.p.a(var1), this.q);
   }

   public final void a(Object var1, hf var2, jw var3) {
      Class var6 = var3.a();
      if(var6 != null) {
         int var4 = 0;

         int var5;
         for(var5 = this.q.length; var4 < var5 && !this.q[var4].isAssignableFrom(var6); ++var4) {
            ;
         }

         if(var4 == var5) {
            return;
         }
      }

      this.p.a(var1, var2, var3);
   }
}
