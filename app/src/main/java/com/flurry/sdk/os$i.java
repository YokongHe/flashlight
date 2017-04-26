package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.pt;
import java.sql.Time;

@kb
public final class os$i extends pt {
   public os$i() {
      super(Time.class);
   }

   public final void a(Time var1, hf var2, jw var3) {
      var2.b(var1.toString());
   }
}
