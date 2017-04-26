package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jh;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.pw;

public class oy extends pw {
   public oy() {
      super(Object.class);
   }

   protected void a(Object var1) {
      throw new jh("No serializer found for class " + var1.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS) )");
   }

   public void a(Object var1, hf var2, jw var3) {
      if(var3.a(ju$a.m)) {
         this.a(var1);
      }

      var2.d();
      var2.e();
   }

   public final void a(Object var1, hf var2, jw var3, jz var4) {
      if(var3.a(ju$a.m)) {
         this.a(var1);
      }

      var4.b(var1, var2);
      var4.e(var1, var2);
   }
}
