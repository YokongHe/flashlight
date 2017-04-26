package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.pt;
import java.math.BigDecimal;
import java.math.BigInteger;

@kb
public final class os$g extends pt {
   public static final os$g a = new os$g();

   public os$g() {
      super(Number.class);
   }

   public final void a(Number var1, hf var2, jw var3) {
      if(var1 instanceof BigDecimal) {
         var2.a((BigDecimal)var1);
      } else if(var1 instanceof BigInteger) {
         var2.a((BigInteger)var1);
      } else if(var1 instanceof Integer) {
         var2.b(var1.intValue());
      } else if(var1 instanceof Long) {
         var2.a(var1.longValue());
      } else if(var1 instanceof Double) {
         var2.a(var1.doubleValue());
      } else if(var1 instanceof Float) {
         var2.a(var1.floatValue());
      } else if(!(var1 instanceof Byte) && !(var1 instanceof Short)) {
         var2.e(var1.toString());
      } else {
         var2.b(var1.intValue());
      }
   }
}
