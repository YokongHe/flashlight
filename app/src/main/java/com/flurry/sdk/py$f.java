package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pf;
import com.flurry.sdk.py$a;

@kb
public final class py$f extends py$a {
   public py$f() {
      this((jz)null);
   }

   public py$f(jz var1) {
      super(float[].class, var1, (is)null);
   }

   public final pf a(jz var1) {
      return new py$f(var1);
   }

   public final void a(float[] var1, hf var2, jw var3) {
      int var4 = 0;

      for(int var5 = var1.length; var4 < var5; ++var4) {
         var2.a(var1[var4]);
      }

   }

   // $FF: synthetic method
   public final void b(Object var1, hf var2, jw var3) {
      this.a((float[])var1, var2, var3);
   }
}
