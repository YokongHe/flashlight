package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;
import com.flurry.sdk.qw$g;

@kb
final class ly$h extends ly$a {
   public ly$h() {
      super(long[].class);
   }

   private final long[] c(hj var1, iz var2) {
      if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
         return null;
      } else if(!var2.a(iy$a.o)) {
         throw var2.b(this.q);
      } else {
         return new long[]{this.w(var1, var2)};
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final long[] b(hj var1, iz var2) {
      if(!var1.j()) {
         return this.c(var1, var2);
      } else {
         qw$g var8 = var2.h().e();
         long[] var7 = (long[])var8.a();

         int var3;
         int var4;
         for(var3 = 0; var1.b() != hm.e; var3 = var4) {
            long var5 = this.w(var1, var2);
            if(var3 >= var7.length) {
               var7 = (long[])var8.a(var7, var3);
               var3 = 0;
            }

            var4 = var3 + 1;
            var7[var3] = var5;
         }

         return (long[])var8.b(var7, var3);
      }
   }
}
