package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jy;
import com.flurry.sdk.kb;
import com.flurry.sdk.lz;
import com.flurry.sdk.re;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@kb
public class mj extends lz {
   private static final Object[] a = new Object[0];

   public mj() {
      super(Object.class);
   }

   public Object a(hj var1, iz var2) {
      switch(null.a[var1.e().ordinal()]) {
      case 1:
         return this.c(var1, var2);
      case 2:
      case 4:
      default:
         throw var2.b(Object.class);
      case 3:
         return this.b(var1, var2);
      case 5:
         return this.c(var1, var2);
      case 6:
         return var1.z();
      case 7:
         return var1.k();
      case 8:
         if(var2.a(iy$a.h)) {
            return var1.v();
         }

         return var1.p();
      case 9:
         if(var2.a(iy$a.g)) {
            return var1.y();
         }

         return Double.valueOf(var1.x());
      case 10:
         return Boolean.TRUE;
      case 11:
         return Boolean.FALSE;
      case 12:
         return null;
      }
   }

   public Object a(hj var1, iz var2, jy var3) {
      hm var4 = var1.e();
      switch(null.a[var4.ordinal()]) {
      case 1:
      case 3:
      case 5:
         return var3.d(var1, var2);
      case 2:
      case 4:
      default:
         throw var2.b(Object.class);
      case 6:
         return var1.z();
      case 7:
         return var1.k();
      case 8:
         if(var2.a(iy$a.h)) {
            return var1.v();
         }

         return Integer.valueOf(var1.t());
      case 9:
         if(var2.a(iy$a.g)) {
            return var1.y();
         }

         return Double.valueOf(var1.x());
      case 10:
         return Boolean.TRUE;
      case 11:
         return Boolean.FALSE;
      case 12:
         return null;
      }
   }

   protected Object b(hj var1, iz var2) {
      if(var2.a(iy$a.i)) {
         return this.d(var1, var2);
      } else if(var1.b() == hm.e) {
         return new ArrayList(4);
      } else {
         re var9 = var2.g();
         Object[] var8 = var9.a();
         int var3 = 0;
         int var4 = 0;

         int var5;
         int var6;
         Object[] var7;
         do {
            Object var10 = this.a(var1, var2);
            var5 = var4 + 1;
            if(var3 >= var8.length) {
               var7 = var9.a(var8);
               var3 = 0;
            } else {
               var7 = var8;
            }

            var6 = var3 + 1;
            var7[var3] = var10;
            var4 = var5;
            var3 = var6;
            var8 = var7;
         } while(var1.b() != hm.e);

         ArrayList var11 = new ArrayList(var5 + (var5 >> 3) + 1);
         var9.a(var7, var6, (List)var11);
         return var11;
      }
   }

   protected Object c(hj var1, iz var2) {
      hm var4 = var1.e();
      hm var3 = var4;
      if(var4 == hm.b) {
         var3 = var1.b();
      }

      if(var3 != hm.f) {
         return new LinkedHashMap(4);
      } else {
         String var9 = var1.k();
         var1.b();
         Object var10 = this.a(var1, var2);
         LinkedHashMap var8;
         if(var1.b() != hm.f) {
            var8 = new LinkedHashMap(4);
            var8.put(var9, var10);
            return var8;
         } else {
            String var5 = var1.k();
            var1.b();
            Object var6 = this.a(var1, var2);
            if(var1.b() != hm.f) {
               var8 = new LinkedHashMap(4);
               var8.put(var9, var10);
               var8.put(var5, var6);
               return var8;
            } else {
               LinkedHashMap var7 = new LinkedHashMap();
               var7.put(var9, var10);
               var7.put(var5, var6);

               do {
                  var9 = var1.k();
                  var1.b();
                  var7.put(var9, this.a(var1, var2));
               } while(var1.b() != hm.c);

               return var7;
            }
         }
      }
   }

   protected Object[] d(hj var1, iz var2) {
      if(var1.b() == hm.e) {
         return a;
      } else {
         re var7 = var2.g();
         Object[] var5 = var7.a();
         int var3 = 0;

         int var4;
         Object[] var6;
         do {
            Object var8 = this.a(var1, var2);
            if(var3 >= var5.length) {
               var6 = var7.a(var5);
               var3 = 0;
            } else {
               var6 = var5;
            }

            var4 = var3 + 1;
            var6[var3] = var8;
            var3 = var4;
            var5 = var6;
         } while(var1.b() != hm.e);

         return var7.a(var6, var4);
      }
   }
}
