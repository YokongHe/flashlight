package com.flurry.sdk;

import com.flurry.sdk.ks;
import com.flurry.sdk.le;

final class le$a extends le {
   final ks c;
   final String d;

   public le$a(le var1, Object var2, ks var3, String var4) {
      super(var1, var2);
      this.c = var3;
      this.d = var4;
   }

   public final void a(Object var1) {
      this.c.a(var1, this.d, this.b);
   }
}
