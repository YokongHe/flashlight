package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;
import com.flurry.sdk.re;

@kb
final class ly$j extends ly$a {
   public ly$j() {
      super(String[].class);
   }

   private final String[] c(hj var1, iz var2) {
      Object var3 = null;
      if(!var2.a(iy$a.o)) {
         if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
            return null;
         } else {
            throw var2.b(this.q);
         }
      } else {
         String var4;
         if(var1.e() == hm.m) {
            var4 = (String)var3;
         } else {
            var4 = var1.k();
         }

         return new String[]{var4};
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final String[] b(hj var1, iz var2) {
      if(!var1.j()) {
         return this.c(var1, var2);
      } else {
         re var7 = var2.g();
         Object[] var5 = var7.a();
         int var3 = 0;

         while(true) {
            hm var6 = var1.b();
            if(var6 == hm.e) {
               String[] var8 = (String[])var7.a(var5, var3, String.class);
               var2.a(var7);
               return var8;
            }

            String var9;
            if(var6 == hm.m) {
               var9 = null;
            } else {
               var9 = var1.k();
            }

            if(var3 >= var5.length) {
               var5 = var7.a(var5);
               var3 = 0;
            }

            int var4 = var3 + 1;
            var5[var3] = var9;
            var3 = var4;
         }
      }
   }
}
