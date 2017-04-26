package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.pw;
import java.util.Date;

public class qb extends pw {
   static final qb a = new qb();

   public qb() {
      super(Object.class);
   }

   public void a(Object var1, hf var2, jw var3) {
      if(var1 instanceof Date) {
         var3.b((Date)var1, var2);
      } else {
         var2.a(var1.toString());
      }
   }
}
