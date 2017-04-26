package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.pt;
import java.util.concurrent.atomic.AtomicLong;

public final class qa$c extends pt {
   public qa$c() {
      super(AtomicLong.class, false);
   }

   public final void a(AtomicLong var1, hf var2, jw var3) {
      var2.a(var1.get());
   }
}
