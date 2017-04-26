package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.mc;
import com.flurry.sdk.mr;
import com.flurry.sdk.qy;
import java.lang.reflect.Method;

public class lq$a extends mc {
   protected final Class a;
   protected final Method b;

   public lq$a(Class var1, mr var2) {
      super(Enum.class);
      this.a = var1;
      this.b = var2.e();
   }

   public Object a(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 != hm.h && var3 != hm.f) {
         throw var2.b(this.a);
      } else {
         String var5 = var1.k();

         try {
            Object var6 = this.b.invoke(this.a, new Object[]{var5});
            return var6;
         } catch (Exception var4) {
            qy.c((Throwable)var4);
            return null;
         }
      }
   }
}
