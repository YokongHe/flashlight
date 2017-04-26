package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;

public class fp extends fk {
   private Object a;
   private fn b;

   public fp(fn var1, Object var2) {
      super("Not in union " + var1 + ": " + var2);
      this.b = var1;
      this.a = var2;
   }
}
