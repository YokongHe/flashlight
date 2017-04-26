package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.ov;
import com.flurry.sdk.ov$c;
import com.flurry.sdk.ov$f;

final class ov$a extends ov {
   private final Class a;
   private final Class b;
   private final jk c;
   private final jk d;

   public ov$a(Class var1, jk var2, Class var3, jk var4) {
      this.a = var1;
      this.c = var2;
      this.b = var3;
      this.d = var4;
   }

   public final jk a(Class var1) {
      return var1 == this.a?this.c:(var1 == this.b?this.d:null);
   }

   public final ov a(Class var1, jk var2) {
      return new ov$c(new ov$f[]{new ov$f(this.a, this.c), new ov$f(this.b, this.d)});
   }
}
