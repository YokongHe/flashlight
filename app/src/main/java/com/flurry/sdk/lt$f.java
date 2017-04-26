package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.lt;
import java.util.TimeZone;

public class lt$f extends lt {
   public lt$f() {
      super(TimeZone.class);
   }

   // $FF: synthetic method
   protected Object a(String var1, iz var2) {
      return this.b(var1, var2);
   }

   protected TimeZone b(String var1, iz var2) {
      return TimeZone.getTimeZone(var1);
   }
}
