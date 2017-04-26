package com.flurry.sdk;

import com.flurry.sdk.jz;
import com.flurry.sdk.pw;

public abstract class pf extends pw {
   protected pf(Class var1) {
      super(var1);
   }

   protected pf(Class var1, boolean var2) {
      super(var1, var2);
   }

   public abstract pf a(jz var1);

   public pf b(jz var1) {
      return var1 == null?this:this.a(var1);
   }
}
