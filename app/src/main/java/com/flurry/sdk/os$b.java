package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.pp;

@kb
public final class os$b extends pp {
   static final os$b a = new os$b();

   public os$b() {
      super(Double.class);
   }

   public final void a(Double var1, hf var2, jw var3) {
      var2.a(var1.doubleValue());
   }
}
