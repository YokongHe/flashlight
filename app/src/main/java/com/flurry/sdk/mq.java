package com.flurry.sdk;

import com.flurry.sdk.mm;
import com.flurry.sdk.mv;
import com.flurry.sdk.qy;
import java.lang.reflect.Member;

public abstract class mq extends mm {
   protected final mv b;

   protected mq(mv var1) {
      this.b = var1;
   }

   public abstract void a(Object var1, Object var2);

   public abstract Class h();

   public abstract Member i();

   protected mv j() {
      return this.b;
   }

   public final void k() {
      qy.a(this.i());
   }
}
