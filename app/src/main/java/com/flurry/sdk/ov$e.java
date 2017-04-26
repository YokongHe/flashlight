package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.ov;
import com.flurry.sdk.ov$a;

final class ov$e extends ov {
   private final Class a;
   private final jk b;

   public ov$e(Class var1, jk var2) {
      this.a = var1;
      this.b = var2;
   }

   public final jk a(Class var1) {
      return var1 == this.a?this.b:null;
   }

   public final ov a(Class var1, jk var2) {
      return new ov$a(this.a, this.b, var1, var2);
   }
}
