package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.pt;
import java.util.TimeZone;

public class qf extends pt {
   public static final qf a = new qf();

   public qf() {
      super(TimeZone.class);
   }

   public void a(TimeZone var1, hf var2, jw var3) {
      var2.b(var1.getID());
   }

   public void a(TimeZone var1, hf var2, jw var3, jz var4) {
      var4.a(var1, var2, TimeZone.class);
      this.a(var1, var2, var3);
      var4.d(var1, var2);
   }
}
