package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.kt;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import java.lang.reflect.Field;

public final class kt$a extends kt {
   protected final mp i;
   protected final Field j;

   protected kt$a(kt$a var1, jg var2) {
      super(var1, var2);
      this.i = var1.i;
      this.j = var1.j;
   }

   public kt$a(String var1, sh var2, jy var3, qv var4, mp var5) {
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
         this.j.set(var1, var2);
      } catch (Exception var3) {
         this.a(var3, var2);
      }
   }

   public final kt$a b(jg var1) {
      return new kt$a(this, var1);
   }

   public final mq b() {
      return this.i;
   }
}
