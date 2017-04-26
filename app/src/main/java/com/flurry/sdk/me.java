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
import com.flurry.sdk.mu;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import java.util.Collection;

@kb
public final class me extends lo implements js {
   protected final sh a;
   protected final jg b;
   protected final boolean c;
   protected final kx d;
   protected jg e;

   public me(sh var1, jg var2, kx var3) {
      super(var1.p());
      this.a = var1;
      this.b = var2;
      this.d = var3;
      this.c = this.a(var2);
   }

   private Collection b(hj var1, iz var2, Collection var3) {
      jg var5 = this.b;

      while(true) {
         hm var4 = var1.b();
         if(var4 == hm.e) {
            return var3;
         }

         String var6;
         if(var4 == hm.m) {
            var6 = null;
         } else {
            var6 = (String)var5.a(var1, var2);
         }

         var3.add(var6);
      }
   }

   private final Collection c(hj var1, iz var2, Collection var3) {
      if(!var2.a(iy$a.o)) {
         throw var2.b(this.a.p());
      } else {
         jg var4 = this.b;
         String var5;
         if(var1.e() == hm.m) {
            var5 = null;
         } else if(var4 == null) {
            var5 = var1.k();
         } else {
            var5 = (String)var4.a(var1, var2);
         }

         var3.add(var5);
         return var3;
      }
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final Object a(hj var1, iz var2, jy var3) {
      return var3.b(var1, var2);
   }

   public final Collection a(hj var1, iz var2, Collection var3) {
      Collection var5;
      if(!var1.j()) {
         var5 = this.c(var1, var2, var3);
      } else {
         if(!this.c) {
            return this.b(var1, var2, var3);
         }

         while(true) {
            hm var4 = var1.b();
            var5 = var3;
            if(var4 == hm.e) {
               break;
            }

            String var6;
            if(var4 == hm.m) {
               var6 = null;
            } else {
               var6 = var1.k();
            }

            var3.add(var6);
         }
      }

      return var5;
   }

   public final void a(iy var1, jc var2) {
      mu var3 = this.d.o();
      if(var3 != null) {
         sh var4 = this.d.l();
         this.e = this.a(var1, var2, var4, new is$a((String)null, var4, (qv)null, var3));
      }

   }

   public final Collection b(hj var1, iz var2) {
      return this.e != null?(Collection)this.d.a(this.e.a(var1, var2)):this.a(var1, var2, (Collection)this.d.m());
   }

   public final jg d() {
      return this.b;
   }
}
