package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pw;

@kb
public final class py$c extends pw {
   public py$c() {
      super(byte[].class);
   }

   public final void a(byte[] var1, hf var2, jw var3) {
      var2.a(var1);
   }

   public final void a(byte[] var1, hf var2, jw var3, jz var4) {
      var4.a(var1, var2);
      var2.a(var1);
      var4.d(var1, var2);
   }
}
