package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;

final class or$a extends jk {
   protected final jz a;
   protected final jk b;

   public or$a(jz var1, jk var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void a(Object var1, hf var2, jw var3) {
      this.b.a(var1, var2, var3, this.a);
   }

   public final void a(Object var1, hf var2, jw var3, jz var4) {
      this.b.a(var1, var2, var3, var4);
   }

   public final Class c() {
      return Object.class;
   }
}
