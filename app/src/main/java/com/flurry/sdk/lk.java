package com.flurry.sdk;

import com.flurry.sdk.hh;
import com.flurry.sdk.hj;
import com.flurry.sdk.hj$b;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jy;
import com.flurry.sdk.lz;
import com.flurry.sdk.rj;
import com.flurry.sdk.rs;
import com.flurry.sdk.rw;

abstract class lk extends lz {
   public lk(Class var1) {
      super(var1);
   }

   protected final rw a(hj var1, iz var2, rs var3) {
      rw var6 = var3.c();
      hm var5 = var1.e();
      hm var4 = var5;
      if(var5 == hm.b) {
         var4 = var1.b();
      }

      for(; var4 == hm.f; var4 = var1.b()) {
         String var9 = var1.g();
         Object var8;
         switch(null.a[var1.b().ordinal()]) {
         case 1:
            var8 = this.a(var1, var2, var3);
            break;
         case 2:
            var8 = this.b(var1, var2, var3);
            break;
         case 3:
            var8 = var3.a(var1.k());
            break;
         default:
            var8 = this.c(var1, var2, var3);
         }

         hh var7 = var6.a((String)var9, (hh)var8);
         if(var7 != null) {
            this.a(var9, var6, var7, (hh)var8);
         }
      }

      return var6;
   }

   public Object a(hj var1, iz var2, jy var3) {
      return var3.d(var1, var2);
   }

   protected void a(String var1, rw var2, hh var3, hh var4) {
   }

   protected final rj b(hj var1, iz var2, rs var3) {
      rj var4 = var3.b();

      while(true) {
         switch(null.a[var1.b().ordinal()]) {
         case 1:
            var4.a((hh)this.a(var1, var2, var3));
            break;
         case 2:
            var4.a((hh)this.b(var1, var2, var3));
            break;
         case 3:
            var4.a((hh)var3.a(var1.k()));
            break;
         case 4:
            return var4;
         default:
            var4.a(this.c(var1, var2, var3));
         }
      }
   }

   protected final hh c(hj var1, iz var2, rs var3) {
      switch(null.a[var1.e().ordinal()]) {
      case 1:
         return this.a(var1, var2, var3);
      case 2:
         return this.b(var1, var2, var3);
      case 3:
         return var3.a(var1.k());
      case 4:
      default:
         throw var2.b(this.f());
      case 5:
         return this.a(var1, var2, var3);
      case 6:
         Object var5 = var1.z();
         if(var5 == null) {
            return var3.a();
         } else {
            if(var5.getClass() == byte[].class) {
               return var3.a((byte[])var5);
            }

            return var3.a(var5);
         }
      case 7:
         hj$b var4 = var1.q();
         if(var4 != hj$b.c && !var2.a(iy$a.h)) {
            if(var4 == hj$b.a) {
               return var3.a(var1.t());
            }

            return var3.a(var1.u());
         }

         return var3.a(var1.v());
      case 8:
         if(var1.q() != hj$b.f && !var2.a(iy$a.g)) {
            return var3.a(var1.x());
         }

         return var3.a(var1.y());
      case 9:
         return var3.a(true);
      case 10:
         return var3.a(false);
      case 11:
         return var3.a();
      }
   }
}
