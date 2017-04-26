package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.is;
import com.flurry.sdk.iz;
import com.flurry.sdk.ks;
import com.flurry.sdk.kt;
import com.flurry.sdk.le;
import com.flurry.sdk.le$a;
import com.flurry.sdk.le$b;
import com.flurry.sdk.le$c;

public final class lf {
   final hj a;
   final iz b;
   final Object[] c;
   private int d;
   private le e;

   public lf(hj var1, iz var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.d = var3;
      this.c = new Object[var3];
   }

   protected final le a() {
      return this.e;
   }

   public final void a(ks var1, String var2, Object var3) {
      this.e = new le$a(this.e, var3, var1, var2);
   }

   public final void a(kt var1, Object var2) {
      this.e = new le$c(this.e, var2, var1);
   }

   public final void a(Object var1, Object var2) {
      this.e = new le$b(this.e, var2, var1);
   }

   public final void a(kt[] var1) {
      int var2 = 0;

      for(int var3 = var1.length; var2 < var3; ++var2) {
         kt var4 = var1[var2];
         if(var4 != null) {
            this.c[var2] = this.b.a((Object)var4.k(), (is)var4, (Object)null);
         }
      }

   }

   public final boolean a(int var1, Object var2) {
      this.c[var1] = var2;
      var1 = this.d - 1;
      this.d = var1;
      return var1 <= 0;
   }

   protected final Object[] a(Object[] var1) {
      if(var1 != null) {
         int var2 = 0;

         for(int var3 = this.c.length; var2 < var3; ++var2) {
            if(this.c[var2] == null) {
               Object var4 = var1[var2];
               if(var4 != null) {
                  this.c[var2] = var4;
               }
            }
         }
      }

      return this.c;
   }
}
