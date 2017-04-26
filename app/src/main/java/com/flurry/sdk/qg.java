package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pw;

@kb
public class qg extends pw {
   public static final qg a = new qg();

   public qg() {
      super(Object.class);
   }

   public void a(Object var1, hf var2, jw var3) {
      var2.b(var1.toString());
   }

   public void a(Object var1, hf var2, jw var3, jz var4) {
      var4.a(var1, var2);
      this.a(var1, var2, var3);
      var4.d(var1, var2);
   }
}
