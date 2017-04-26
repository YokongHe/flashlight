package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.kb;
import com.flurry.sdk.lo;
import com.flurry.sdk.qi;
import com.flurry.sdk.re;
import com.flurry.sdk.sh;
import java.lang.reflect.Array;

@kb
public class lx extends lo {
   protected final sh a;
   protected final boolean b;
   protected final Class c;
   protected final jg d;
   protected final jy e;

   public lx(qi var1, jg var2, jy var3) {
      super(Object[].class);
      this.a = var1;
      this.c = var1.g().p();
      boolean var4;
      if(this.c == Object.class) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.b = var4;
      this.d = var2;
      this.e = var3;
   }

   private final Object[] d(hj var1, iz var2) {
      if(var1.e() == hm.h && var2.a(iy$a.q) && var1.k().length() == 0) {
         return null;
      } else if(!var2.a(iy$a.o)) {
         if(var1.e() == hm.h && this.c == Byte.class) {
            return this.c(var1, var2);
         } else {
            throw var2.b(this.a.p());
         }
      } else {
         Object var3;
         if(var1.e() == hm.m) {
            var3 = null;
         } else if(this.e == null) {
            var3 = this.d.a(var1, var2);
         } else {
            var3 = this.d.a(var1, var2, this.e);
         }

         Object[] var4;
         if(this.b) {
            var4 = new Object[1];
         } else {
            var4 = (Object[])Array.newInstance(this.c, 1);
         }

         var4[0] = var3;
         return var4;
      }
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2, jy var3) {
      return this.b(var1, var2, var3);
   }

   public Object[] b(hj var1, iz var2) {
      if(!var1.j()) {
         return this.d(var1, var2);
      } else {
         re var7 = var2.g();
         Object[] var6 = var7.a();
         jy var8 = this.e;
         int var3 = 0;

         while(true) {
            hm var5 = var1.b();
            if(var5 == hm.e) {
               Object[] var9;
               if(this.b) {
                  var9 = var7.a(var6, var3);
               } else {
                  var9 = var7.a(var6, var3, this.c);
               }

               var2.a(var7);
               return var9;
            }

            Object var10;
            if(var5 == hm.m) {
               var10 = null;
            } else if(var8 == null) {
               var10 = this.d.a(var1, var2);
            } else {
               var10 = this.d.a(var1, var2, var8);
            }

            if(var3 >= var6.length) {
               var6 = var7.a(var6);
               var3 = 0;
            }

            int var4 = var3 + 1;
            var6[var3] = var10;
            var3 = var4;
         }
      }
   }

   public Object[] b(hj var1, iz var2, jy var3) {
      return (Object[])var3.b(var1, var2);
   }

   protected Byte[] c(hj var1, iz var2) {
      byte[] var5 = var1.a(var2.c());
      Byte[] var6 = new Byte[var5.length];
      int var3 = 0;

      for(int var4 = var5.length; var3 < var4; ++var3) {
         var6[var3] = Byte.valueOf(var5[var3]);
      }

      return var6;
   }

   public jg d() {
      return this.d;
   }
}
