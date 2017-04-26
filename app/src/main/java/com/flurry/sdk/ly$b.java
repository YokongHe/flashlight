package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;
import com.flurry.sdk.qw$b;

@kb
final class ly$b extends ly$a {
   public ly$b() {
      super(boolean[].class);
   }

   private final boolean[] c(hj var1, iz var2) {
      if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
         return null;
      } else if(!var2.a(iy$a.o)) {
         throw var2.b(this.q);
      } else {
         return new boolean[]{this.n(var1, var2)};
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final boolean[] b(hj var1, iz var2) {
      if(!var1.j()) {
         return this.c(var1, var2);
      } else {
         qw$b var7 = var2.h().a();
         boolean[] var6 = (boolean[])var7.a();

         int var3;
         int var4;
         for(var3 = 0; var1.b() != hm.e; var3 = var4) {
            boolean var5 = this.n(var1, var2);
            if(var3 >= var6.length) {
               var6 = (boolean[])var7.a(var6, var3);
               var3 = 0;
            }

            var4 = var3 + 1;
            var6[var3] = var5;
         }

         return (boolean[])var7.b(var6, var3);
      }
   }
}
