package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.pw;
import java.util.concurrent.atomic.AtomicReference;

public final class qa$d extends pw {
   public qa$d() {
      super(AtomicReference.class, false);
   }

   public final void a(AtomicReference var1, hf var2, jw var3) {
      var3.a(var1.get(), var2);
   }
}
