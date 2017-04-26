package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.kt;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import java.lang.reflect.Method;

public final class kt$d extends kt {
   protected final mr i;
   protected final Method j;

   protected kt$d(kt$d var1, jg var2) {
      super(var1, var2);
      this.i = var1.i;
      this.j = var1.j;
   }

   public kt$d(String var1, sh var2, jy var3, qv var4, mr var5) {
      super(var1, var2, var3, var4);
      this.i = var5;
      this.j = var5.e();
   }

   // $FF: synthetic method
   public final kt a(jg var1) {
      return this.b(var1);
   }

   public final void a(hj var1, iz var2, Object var3) {
      this.a(var3, this.a(var1, var2));
   }

   public final void a(Object var1, Object var2) {
      try {
         this.j.invoke(var1, new Object[]{var2});
      } catch (Exception var3) {
         this.a(var3, var2);
      }
   }

   public final kt$d b(jg var1) {
      return new kt$d(this, var1);
   }

   public final mq b() {
      return this.i;
   }
}
