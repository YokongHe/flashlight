package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pf;
import com.flurry.sdk.py$a;

@kb
public final class py$i extends py$a {
   public py$i() {
      this((jz)null);
   }

   public py$i(jz var1) {
      super(short[].class, var1, (is)null);
   }

   public final pf a(jz var1) {
      return new py$i(var1);
   }

   public final void a(short[] var1, hf var2, jw var3) {
      int var4 = 0;

      for(int var5 = var1.length; var4 < var5; ++var4) {
         var2.b(var1[var4]);
      }

   }

   // $FF: synthetic method
   public final void b(Object var1, hf var2, jw var3) {
      this.a((short[])var1, var2, var3);
   }
}
