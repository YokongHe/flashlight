package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;
import com.flurry.sdk.qw$c;

@kb
final class ly$c extends ly$a {
   public ly$c() {
      super(byte[].class);
   }

   private final byte[] c(hj var1, iz var2) {
      if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
         return null;
      } else if(!var2.a(iy$a.o)) {
         throw var2.b(this.q);
      } else {
         hm var4 = var1.e();
         byte var3;
         if(var4 != hm.i && var4 != hm.j) {
            if(var4 != hm.m) {
               throw var2.b(this.q.getComponentType());
            }

            var3 = 0;
         } else {
            var3 = var1.r();
         }

         return new byte[]{var3};
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final byte[] b(hj var1, iz var2) {
      hm var5 = var1.e();
      if(var5 == hm.h) {
         return var1.a(var2.c());
      } else {
         if(var5 == hm.g) {
            Object var8 = var1.z();
            if(var8 == null) {
               return null;
            }

            if(var8 instanceof byte[]) {
               return (byte[])var8;
            }
         }

         if(!var1.j()) {
            return this.c(var1, var2);
         } else {
            qw$c var6 = var2.h().b();
            byte[] var9 = (byte[])var6.a();
            int var4 = 0;

            while(true) {
               hm var7 = var1.b();
               if(var7 == hm.e) {
                  return (byte[])var6.b(var9, var4);
               }

               byte var3;
               if(var7 != hm.i && var7 != hm.j) {
                  if(var7 != hm.m) {
                     throw var2.b(this.q.getComponentType());
                  }

                  var3 = 0;
               } else {
                  var3 = var1.r();
               }

               if(var4 >= var9.length) {
                  var9 = (byte[])var6.a(var9, var4);
                  var4 = 0;
               }

               var9[var4] = var3;
               ++var4;
            }
         }
      }
   }
}
