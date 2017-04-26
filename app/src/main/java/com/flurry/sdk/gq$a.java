package com.flurry.sdk;

import com.flurry.sdk.gq;
import com.flurry.sdk.gq$i;
import java.util.Map;

public class gq$a extends gq {
   public final String[] A;
   public final gq[] z;

   private gq$a(gq[] var1, String[] var2) {
      super(gq$i.e);
      this.z = var1;
      this.A = var2;
   }

   // $FF: synthetic method
   gq$a(gq[] var1, String[] var2, Object var3) {
      this(var1, var2);
   }

   public gq a(int var1) {
      return this.z[var1];
   }

   // $FF: synthetic method
   public gq a(Map var1, Map var2) {
      return this.b(var1, var2);
   }

   public gq$a b(Map var1, Map var2) {
      gq[] var4 = new gq[this.z.length];

      for(int var3 = 0; var3 < var4.length; ++var3) {
         var4[var3] = this.z[var3].a(var1, var2);
      }

      return new gq$a(var4, this.A);
   }
}
