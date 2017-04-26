package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.pt;
import java.util.concurrent.atomic.AtomicInteger;

public final class qa$b extends pt {
   public qa$b() {
      super(AtomicInteger.class, false);
   }

   public final void a(AtomicInteger var1, hf var2, jw var3) {
      var2.b(var1.get());
   }
}
