package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.pp;

@kb
public final class os$a extends pp {
   final boolean a;

   public os$a(boolean var1) {
      super(Boolean.class);
      this.a = var1;
   }

   public final void a(Boolean var1, hf var2, jw var3) {
      var2.a(var1.booleanValue());
   }
}
