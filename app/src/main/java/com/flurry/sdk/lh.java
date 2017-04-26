package com.flurry.sdk;

import com.flurry.sdk.is;
import com.flurry.sdk.is$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.mq;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;

public class lh extends is$a {
   protected final Object e;

   public lh(String var1, sh var2, qv var3, mq var4, Object var5) {
      super(var1, var2, var3, var4);
      this.e = var5;
   }

   public Object a(iz var1, Object var2) {
      return var1.a((Object)this.e, (is)this, (Object)var2);
   }

   public void b(iz var1, Object var2) {
      this.c.a(var2, this.a(var1, var2));
   }
}
