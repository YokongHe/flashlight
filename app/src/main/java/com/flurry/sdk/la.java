package com.flurry.sdk;

import com.flurry.sdk.iy;
import com.flurry.sdk.kx;
import com.flurry.sdk.lb;
import com.flurry.sdk.md;
import com.flurry.sdk.mo;
import com.flurry.sdk.mu;
import com.flurry.sdk.mw;
import com.flurry.sdk.qy;
import com.flurry.sdk.sh;
import java.lang.reflect.Member;
import java.util.HashMap;

public class la {
   final mw a;
   final boolean b;
   protected mo c;
   protected mu d;
   protected mu e;
   protected mu f;
   protected mu g;
   protected mu h;
   protected mu i;
   protected mu j;
   protected lb[] k = null;

   public la(mw var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public kx a(iy var1) {
      md var2 = new md(var1, this.a.a());
      sh var3;
      if(this.i == null) {
         var3 = null;
      } else {
         var3 = this.a.j().a(this.i.b(0));
      }

      var2.a(this.c, this.i, var3, this.j, this.k);
      var2.a(this.d);
      var2.b(this.e);
      var2.c(this.f);
      var2.d(this.g);
      var2.e(this.h);
      return var2;
   }

   protected mu a(mu var1, mu var2, String var3) {
      if(var2 != null && var2.getClass() == var1.getClass()) {
         throw new IllegalArgumentException("Conflicting " + var3 + " creators: already had " + var2 + ", encountered " + var1);
      } else {
         if(this.b) {
            qy.a((Member)var1.a());
         }

         return var1;
      }
   }

   public void a(mo var1) {
      this.c = var1;
   }

   public void a(mu var1) {
      this.d = this.a(var1, this.d, "String");
   }

   public void a(mu var1, lb[] var2) {
      this.j = this.a(var1, this.j, "property-based");
      if(var2.length > 1) {
         HashMap var7 = new HashMap();
         int var4 = var2.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            String var5 = var2[var3].c();
            Integer var6 = (Integer)var7.put(var5, Integer.valueOf(var3));
            if(var6 != null) {
               throw new IllegalArgumentException("Duplicate creator property \"" + var5 + "\" (index " + var6 + " vs " + var3 + ")");
            }
         }
      }

      this.k = var2;
   }

   public void b(mu var1) {
      this.e = this.a(var1, this.e, "int");
   }

   public void c(mu var1) {
      this.f = this.a(var1, this.f, "long");
   }

   public void d(mu var1) {
      this.g = this.a(var1, this.g, "double");
   }

   public void e(mu var1) {
      this.h = this.a(var1, this.h, "boolean");
   }

   public void f(mu var1) {
      this.i = this.a(var1, this.i, "delegate");
   }
}
