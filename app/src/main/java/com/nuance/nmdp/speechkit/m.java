package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;

abstract class m extends com.nuance.nmdp.speechkit.p {
   private final String a;
   private final PdxValue$Dictionary b;

   m(.cO var1, String var2, boolean var3, boolean var4, String var5, String var6, PdxValue$Dictionary var7, .d var8) {
      super(var1, var3, var4, var5, var6, var8);
      this.a = var2;
      this.b = var7;
   }

   protected final .J a() {
      return new com.nuance.nmdp.speechkit.h();
   }

   protected final .db a(.cO var1, boolean var2, boolean var3, String var4, String var5, .d var6, .E var7, .E var8, .E var9, .E var10, .J var11, .b var12) {
      return var1.a(this.a, var2, var3, var4, var5, this.b, var7, var8, var9, var10, var11, var6, var12);
   }
}
