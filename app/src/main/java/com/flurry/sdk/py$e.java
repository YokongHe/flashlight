package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pf;
import com.flurry.sdk.py$a;

@kb
public final class py$e extends py$a {
   public py$e() {
      super(double[].class, (jz)null, (is)null);
   }

   public final pf a(jz var1) {
      return this;
   }

   public final void a(double[] var1, hf var2, jw var3) {
      int var4 = 0;

      for(int var5 = var1.length; var4 < var5; ++var4) {
         var2.a(var1[var4]);
      }

   }

   // $FF: synthetic method
   public final void b(Object var1, hf var2, jw var3) {
      this.a((double[])var1, var2, var3);
   }
}
