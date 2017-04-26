package com.flurry.sdk;

import com.flurry.sdk.ir;
import com.flurry.sdk.iy;
import com.flurry.sdk.kx;
import com.flurry.sdk.ky$a;
import com.flurry.sdk.qj;
import java.util.HashMap;

public class oe extends ky$a {
   protected HashMap a;

   public kx a(iy var1, ir var2, kx var3) {
      kx var4 = (kx)this.a.get(new qj(var2.b()));
      return var4 == null?var3:var4;
   }
}
