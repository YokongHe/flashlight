package com.flurry.sdk;

import com.flurry.sdk.hb;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.jh;
import com.flurry.sdk.kb;
import com.flurry.sdk.ly$a;

@kb
final class ly$d extends ly$a {
   public ly$d() {
      super(char[].class);
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final char[] b(hj var1, iz var2) {
      hm var5 = var1.e();
      if(var5 == hm.h) {
         char[] var9 = var1.l();
         int var3 = var1.n();
         int var4 = var1.m();
         char[] var8 = new char[var4];
         System.arraycopy(var9, var3, var8, 0, var4);
         return var8;
      } else if(var1.j()) {
         StringBuilder var10 = new StringBuilder(64);

         while(true) {
            hm var6 = var1.b();
            if(var6 == hm.e) {
               return var10.toString().toCharArray();
            }

            if(var6 != hm.h) {
               throw var2.b(Character.TYPE);
            }

            String var11 = var1.k();
            if(var11.length() != 1) {
               throw jh.a(var1, "Can not convert a JSON String of length " + var11.length() + " into a char element of char array");
            }

            var10.append(var11.charAt(0));
         }
      } else {
         if(var5 == hm.g) {
            Object var7 = var1.z();
            if(var7 == null) {
               return null;
            }

            if(var7 instanceof char[]) {
               return (char[])var7;
            }

            if(var7 instanceof String) {
               return ((String)var7).toCharArray();
            }

            if(var7 instanceof byte[]) {
               return hb.a().a((byte[])var7, false).toCharArray();
            }
         }

         throw var2.b(this.q);
      }
   }
}
