package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;
import com.flurry.sdk.qw$e;

@kb
final class ly$f extends ly$a {
   public ly$f() {
      super(float[].class);
   }

   private final float[] c(hj var1, iz var2) {
      if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
         return null;
      } else if(!var2.a(iy$a.o)) {
         throw var2.b(this.q);
      } else {
         return new float[]{this.y(var1, var2)};
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final float[] b(hj var1, iz var2) {
      if(!var1.j()) {
         return this.c(var1, var2);
      } else {
         qw$e var7 = var2.h().f();
         float[] var6 = (float[])var7.a();

         int var4;
         int var5;
         for(var4 = 0; var1.b() != hm.e; var4 = var5) {
            float var3 = this.y(var1, var2);
            if(var4 >= var6.length) {
               var6 = (float[])var7.a(var6, var4);
               var4 = 0;
            }

            var5 = var4 + 1;
            var6[var4] = var3;
         }

         return (float[])var7.b(var6, var4);
      }
   }
}
