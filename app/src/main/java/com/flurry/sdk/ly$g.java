package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;
import com.flurry.sdk.qw$f;

@kb
final class ly$g extends ly$a {
   public ly$g() {
      super(int[].class);
   }

   private final int[] c(hj var1, iz var2) {
      if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
         return null;
      } else if(!var2.a(iy$a.o)) {
         throw var2.b(this.q);
      } else {
         return new int[]{this.t(var1, var2)};
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final int[] b(hj var1, iz var2) {
      if(!var1.j()) {
         return this.c(var1, var2);
      } else {
         qw$f var7 = var2.h().d();
         int[] var6 = (int[])var7.a();

         int var3;
         int var4;
         for(var3 = 0; var1.b() != hm.e; var3 = var4) {
            int var5 = this.t(var1, var2);
            if(var3 >= var6.length) {
               var6 = (int[])var7.a(var6, var3);
               var3 = 0;
            }

            var4 = var3 + 1;
            var6[var3] = var5;
         }

         return (int[])var7.b(var6, var3);
      }
   }
}
