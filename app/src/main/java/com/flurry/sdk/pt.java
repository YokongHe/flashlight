package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.pw;

public abstract class pt extends pw {
   protected pt(Class var1) {
      super(var1);
   }

   protected pt(Class var1, boolean var2) {
      super(var1);
   }

   public void a(Object var1, hf var2, jw var3, jz var4) {
      var4.a(var1, var2);
      this.a(var1, var2, var3);
      var4.d(var1, var2);
   }
}
