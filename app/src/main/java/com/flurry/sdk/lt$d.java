package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.lt;
import java.util.Locale;

public class lt$d extends lt {
   public lt$d() {
      super(Locale.class);
   }

   // $FF: synthetic method
   protected Object a(String var1, iz var2) {
      return this.b(var1, var2);
   }

   protected Locale b(String var1, iz var2) {
      int var3 = var1.indexOf(95);
      if(var3 < 0) {
         return new Locale(var1);
      } else {
         String var4 = var1.substring(0, var3);
         var1 = var1.substring(var3 + 1);
         var3 = var1.indexOf(95);
         return var3 < 0?new Locale(var4, var1):new Locale(var4, var1.substring(0, var3), var1.substring(var3 + 1));
      }
   }
}
