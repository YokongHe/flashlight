package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.pt;

@kb
public final class os$c extends pt {
   static final os$c a = new os$c();

   public os$c() {
      super(Float.class);
   }

   public final void a(Float var1, hf var2, jw var3) {
      var2.a(var1.floatValue());
   }
}
