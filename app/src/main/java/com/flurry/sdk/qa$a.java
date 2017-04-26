package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.pt;
import java.util.concurrent.atomic.AtomicBoolean;

public final class qa$a extends pt {
   public qa$a() {
      super(AtomicBoolean.class, false);
   }

   public final void a(AtomicBoolean var1, hf var2, jw var3) {
      var2.a(var1.get());
   }
}
