package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jh;
import com.flurry.sdk.jw;
import com.flurry.sdk.mr;
import com.flurry.sdk.po;
import java.lang.reflect.Method;
import java.util.Map;

public class of {
   protected final Method a;
   protected final po b;

   public of(mr var1, po var2) {
      this.a = var1.e();
      this.b = var2;
   }

   public void a(jw var1) {
      this.b.a(var1);
   }

   public void a(Object var1, hf var2, jw var3) {
      var1 = this.a.invoke(var1, new Object[0]);
      if(var1 != null) {
         if(!(var1 instanceof Map)) {
            throw new jh("Value returned by \'any-getter\' (" + this.a.getName() + "()) not java.util.Map but " + var1.getClass().getName());
         } else {
            this.b.b((Map)var1, var2, var3);
         }
      }
   }
}
