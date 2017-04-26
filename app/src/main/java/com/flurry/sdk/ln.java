package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is$a;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.js;
import com.flurry.sdk.jy;
import com.flurry.sdk.kb;
import com.flurry.sdk.kx;
import com.flurry.sdk.lo;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import java.util.Collection;

@kb
public class ln extends lo implements js {
   protected final sh a;
   protected final jg b;
   protected final jy c;
   protected final kx d;
   protected jg e;

   public ln(sh var1, jg var2, jy var3, kx var4) {
      super(var1.p());
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   private final Collection b(hj var1, iz var2, Collection var3) {
      if(!var2.a(iy$a.o)) {
         throw var2.b(this.a.p());
      } else {
         jg var4 = this.b;
         jy var5 = this.c;
         Object var6;
         if(var1.e() == hm.m) {
            var6 = null;
         } else if(var5 == null) {
            var6 = var4.a(var1, var2);
         } else {
            var6 = var4.a(var1, var2, var5);
         }

         var3.add(var6);
         return var3;
      }
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Object a(hj var1, iz var2, jy var3) {
      return var3.b(var1, var2);
   }

   public Collection a(hj var1, iz var2, Collection var3) {
      Collection var4;
      if(!var1.j()) {
         var4 = this.b(var1, var2, var3);
      } else {
         jg var5 = this.b;
         jy var6 = this.c;

         while(true) {
            hm var7 = var1.b();
            var4 = var3;
            if(var7 == hm.e) {
               break;
            }

            Object var8;
            if(var7 == hm.m) {
               var8 = null;
            } else if(var6 == null) {
               var8 = var5.a(var1, var2);
            } else {
               var8 = var5.a(var1, var2, var6);
            }

            var3.add(var8);
         }
      }

      return var4;
   }

   public void a(iy var1, jc var2) {
      if(this.d.i()) {
         sh var3 = this.d.l();
         if(var3 == null) {
            throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.d.getClass().getName() + ") returned true for \'canCreateUsingDelegate()\', but null for \'getDelegateType()\'");
         }

         this.e = this.a(var1, var2, var3, new is$a((String)null, var3, (qv)null, this.d.o()));
      }

   }

   public Collection b(hj var1, iz var2) {
      if(this.e != null) {
         return (Collection)this.d.a(this.e.a(var1, var2));
      } else {
         if(var1.e() == hm.h) {
            String var3 = var1.k();
            if(var3.length() == 0) {
               return (Collection)this.d.a(var3);
            }
         }

         return this.a(var1, var2, (Collection)this.d.m());
      }
   }

   public jg d() {
      return this.b;
   }
}
