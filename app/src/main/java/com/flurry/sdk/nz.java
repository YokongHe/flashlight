package com.flurry.sdk;

import com.flurry.sdk.ip;
import com.flurry.sdk.iy;
import com.flurry.sdk.qj;
import com.flurry.sdk.sh;
import java.util.HashMap;

public class nz extends ip {
   protected final HashMap a;

   public sh a(iy var1, sh var2) {
      Class var3 = var2.p();
      var3 = (Class)this.a.get(new qj(var3));
      return var3 == null?null:var2.f(var3);
   }

   public sh b(iy var1, sh var2) {
      return null;
   }
}
