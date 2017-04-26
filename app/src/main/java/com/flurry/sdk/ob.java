package com.flurry.sdk;

import com.flurry.sdk.ir;
import com.flurry.sdk.is;
import com.flurry.sdk.iy;
import com.flurry.sdk.jl;
import com.flurry.sdk.jm;
import com.flurry.sdk.qj;
import com.flurry.sdk.sh;
import java.util.HashMap;

public class ob implements jm {
   protected HashMap a = null;

   public jl a(sh var1, iy var2, ir var3, is var4) {
      return this.a == null?null:(jl)this.a.get(new qj(var1.p()));
   }

   public ob a(Class var1, jl var2) {
      if(this.a == null) {
         this.a = new HashMap();
      }

      this.a.put(new qj(var1), var2);
      return this;
   }
}
