package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.kt;
import com.flurry.sdk.mq;
import com.flurry.sdk.mt;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;

public class lb extends kt {
   protected final mt i;
   protected final Object j;

   protected lb(lb var1, jg var2) {
      super(var1, var2);
      this.i = var1.i;
      this.j = var1.j;
   }

   public lb(String var1, sh var2, jy var3, qv var4, mt var5, int var6, Object var7) {
      super(var1, var2, var3, var4);
      this.i = var5;
      this.h = var6;
      this.j = var7;
   }

   // $FF: synthetic method
   public kt a(jg var1) {
      return this.b(var1);
   }

   public void a(hj var1, iz var2, Object var3) {
      this.a(var3, this.a(var1, var2));
   }

   public void a(Object var1, Object var2) {
   }

   public lb b(jg var1) {
      return new lb(this, var1);
   }

   public mq b() {
      return this.i;
   }

   public Object k() {
      return this.j;
   }
}
