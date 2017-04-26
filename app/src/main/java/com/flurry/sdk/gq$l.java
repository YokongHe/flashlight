package com.flurry.sdk;

import com.flurry.sdk.gq;
import com.flurry.sdk.gq$i;
import java.util.HashMap;

public class gq$l extends gq {
   private gq$l(gq... var1) {
      super(gq$i.b, c(var1));
      this.b[0] = this;
   }

   // $FF: synthetic method
   gq$l(gq[] var1, Object var2) {
      this(var1);
   }

   private static gq[] c(gq[] var0) {
      gq[] var1 = new gq[a(var0, 0) + 1];
      a(var0, 0, var1, 1, new HashMap(), new HashMap());
      return var1;
   }
}
