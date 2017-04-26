package com.flurry.sdk;

import com.flurry.sdk.le;
import java.util.Map;

final class le$b extends le {
   final Object c;

   public le$b(le var1, Object var2, Object var3) {
      super(var1, var2);
      this.c = var3;
   }

   public final void a(Object var1) {
      ((Map)var1).put(this.c, this.b);
   }
}
