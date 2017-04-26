package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.kt;
import com.flurry.sdk.mq;
import com.flurry.sdk.qy;
import java.lang.reflect.Constructor;

public final class kt$b extends kt {
   protected final kt i;
   protected final Constructor j;

   protected kt$b(kt$b var1, jg var2) {
      super(var1, var2);
      this.i = var1.i.a(var2);
      this.j = var1.j;
   }

   public kt$b(kt var1, Constructor var2) {
      super(var1);
      this.i = var1;
      this.j = var2;
   }

   // $FF: synthetic method
   public final kt a(jg var1) {
      return this.b(var1);
   }

   public final void a(hj var1, iz var2, Object var3) {
      Object var4 = null;
      Object var5 = null;
      Object var7;
      if(var1.e() == hm.m) {
         if(this.f == null) {
            var7 = var5;
         } else {
            var7 = this.f.a(var2);
         }
      } else if(this.e != null) {
         var7 = this.d.a(var1, var2, this.e);
      } else {
         label20: {
            try {
               var5 = this.j.newInstance(new Object[]{var3});
            } catch (Exception var6) {
               qy.b(var6, "Failed to instantiate class " + this.j.getDeclaringClass().getName() + ", problem: " + var6.getMessage());
               break label20;
            }

            var4 = var5;
         }

         this.d.a(var1, var2, var4);
         var7 = var4;
      }

      this.a(var3, var7);
   }

   public final void a(Object var1, Object var2) {
      this.i.a(var1, var2);
   }

   public final kt$b b(jg var1) {
      return new kt$b(this, var1);
   }

   public final mq b() {
      return this.i.b();
   }
}
