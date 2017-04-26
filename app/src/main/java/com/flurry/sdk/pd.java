package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.pt;
import java.util.Calendar;

@kb
public class pd extends pt {
   public static pd a = new pd();

   public pd() {
      super(Calendar.class);
   }

   public void a(Calendar var1, hf var2, jw var3) {
      var3.a(var1.getTimeInMillis(), var2);
   }
}
