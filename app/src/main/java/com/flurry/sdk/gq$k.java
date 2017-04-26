package com.flurry.sdk;

import com.flurry.sdk.gq;
import com.flurry.sdk.gq$g;
import java.util.Map;

public class gq$k extends gq$g {
   public final gq B;
   public final gq z;

   private gq$k(gq var1, gq var2) {
      super(null);
      this.z = var1;
      this.B = var2;
   }

   // $FF: synthetic method
   gq$k(gq var1, gq var2, Object var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   public gq a(Map var1, Map var2) {
      return this.b(var1, var2);
   }

   public gq$k b(Map var1, Map var2) {
      return new gq$k(this.z.a(var1, var2), this.B.a(var1, var2));
   }
}
