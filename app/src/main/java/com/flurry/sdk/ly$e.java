package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;
import com.flurry.sdk.qw$d;

@kb
final class ly$e extends ly$a {
   public ly$e() {
      super(double[].class);
   }

   private final double[] c(hj var1, iz var2) {
      if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
         return null;
      } else if(!var2.a(iy$a.o)) {
         throw var2.b(this.q);
      } else {
         return new double[]{this.A(var1, var2)};
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final double[] b(hj var1, iz var2) {
      if(!var1.j()) {
         return this.c(var1, var2);
      } else {
         qw$d var8 = var2.h().g();
         double[] var7 = (double[])var8.a();

         int var5;
         int var6;
         for(var5 = 0; var1.b() != hm.e; var5 = var6) {
            double var3 = this.A(var1, var2);
            if(var5 >= var7.length) {
               var7 = (double[])var8.a(var7, var5);
               var5 = 0;
            }

            var6 = var5 + 1;
            var7[var5] = var3;
         }

         return (double[])var8.b(var7, var5);
      }
   }
}
