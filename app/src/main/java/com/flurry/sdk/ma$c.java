package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;
import java.util.Calendar;
import java.util.Date;

final class ma$c extends ma {
   protected ma$c() {
      super(Calendar.class);
   }

   // $FF: synthetic method
   public final Object b(String var1, iz var2) {
      return this.c(var1, var2);
   }

   public final Calendar c(String var1, iz var2) {
      Date var3 = var2.a(var1);
      return var3 == null?null:var2.a(var3);
   }
}
