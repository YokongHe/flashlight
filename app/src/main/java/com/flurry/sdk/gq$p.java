package com.flurry.sdk;

import com.flurry.sdk.gq;
import com.flurry.sdk.gq$g;
import java.util.Map;

public class gq$p extends gq$g {
   public final gq B;
   public final int z;

   public gq$p(int var1, gq var2) {
      super(null);
      this.z = var1;
      this.B = var2;
   }

   // $FF: synthetic method
   public gq a(Map var1, Map var2) {
      return this.b(var1, var2);
   }

   public gq$p b(Map var1, Map var2) {
      return new gq$p(this.z, this.B.a(var1, var2));
   }
}
