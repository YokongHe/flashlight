package com.flurry.sdk;

import com.flurry.sdk.gq;
import com.flurry.sdk.gq$i;
import java.util.Map;

public class gq$j extends gq {
   public final gq z;

   private gq$j(gq var1, gq... var2) {
      super(gq$i.d, c(var2));
      this.z = var1;
      this.b[0] = this;
   }

   // $FF: synthetic method
   gq$j(gq var1, gq[] var2, Object var3) {
      this(var1, var2);
   }

   private static gq[] c(gq[] var0) {
      gq[] var1 = new gq[var0.length + 1];
      System.arraycopy(var0, 0, var1, 1, var0.length);
      return var1;
   }

   // $FF: synthetic method
   public gq a(Map var1, Map var2) {
      return this.b(var1, var2);
   }

   public gq$j b(Map var1, Map var2) {
      gq$j var3 = new gq$j(this.z, new gq[a(this.b, 1)]);
      a(this.b, 1, var3.b, 1, var1, var2);
      return var3;
   }
}
