package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.kt;
import com.flurry.sdk.kx;
import com.flurry.sdk.le;
import com.flurry.sdk.lf;
import com.flurry.sdk.qy;
import java.util.Collection;
import java.util.HashMap;

public final class ld {
   protected final kx a;
   protected final HashMap b;
   protected Object[] c;
   protected final kt[] d;

   public ld(kx var1) {
      Object[] var4 = null;
      super();
      this.a = var1;
      this.b = new HashMap();
      kt[] var6 = var1.k();
      int var3 = var6.length;
      int var2 = 0;

      Object[] var5;
      kt[] var8;
      for(var8 = null; var2 < var3; var4 = var5) {
         kt var7 = var6[var2];
         this.b.put(var7.c(), var7);
         var5 = var4;
         if(var7.a().t()) {
            var5 = var4;
            if(var4 == null) {
               var5 = new Object[var3];
            }

            var5[var2] = qy.f(var7.a().p());
         }

         kt[] var9 = var8;
         if(var7.k() != null) {
            var9 = var8;
            if(var8 == null) {
               var9 = new kt[var3];
            }

            var9[var2] = var7;
         }

         ++var2;
         var8 = var9;
      }

      this.c = var4;
      this.d = var8;
   }

   public final kt a(String var1) {
      return (kt)this.b.get(var1);
   }

   public final lf a(hj var1, iz var2) {
      lf var3 = new lf(var1, var2, this.b.size());
      if(this.d != null) {
         var3.a(this.d);
      }

      return var3;
   }

   public final Object a(lf var1) {
      Object var2 = this.a.a(var1.a(this.c));

      for(le var3 = var1.a(); var3 != null; var3 = var3.a) {
         var3.a(var2);
      }

      return var2;
   }

   public final Collection a() {
      return this.b.values();
   }

   public final void a(kt var1, jg var2) {
      var1 = var1.a(var2);
      this.b.put(var1.c(), var1);
      Object var3 = var2.b();
      if(var3 != null) {
         if(this.c == null) {
            this.c = new Object[this.b.size()];
         }

         this.c[var1.j()] = var3;
      }

   }
}
