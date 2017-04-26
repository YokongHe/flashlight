package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.lt$a;
import com.flurry.sdk.lt$b;
import com.flurry.sdk.lt$c;
import com.flurry.sdk.lt$d;
import com.flurry.sdk.lt$e;
import com.flurry.sdk.lt$f;
import com.flurry.sdk.lt$g;
import com.flurry.sdk.lt$h;
import com.flurry.sdk.lt$i;
import com.flurry.sdk.mc;
import java.util.ArrayList;

public abstract class lt extends mc {
   protected lt(Class var1) {
      super(var1);
   }

   public static Iterable d() {
      ArrayList var0 = new ArrayList();
      var0.add(new lt$i());
      var0.add(new lt$h());
      var0.add(new lt$g());
      var0.add(new lt$b());
      var0.add(new lt$e());
      var0.add(new lt$d());
      var0.add(new lt$c());
      var0.add(new lt$f());
      var0.add(new lt$a());
      return var0;
   }

   public final Object a(hj var1, iz var2) {
      Object var3 = null;
      Object var7;
      if(var1.e() != hm.h) {
         if(var1.e() != hm.g) {
            throw var2.b(this.q);
         }

         Object var4 = var1.z();
         var7 = var3;
         if(var4 != null) {
            if(this.q.isAssignableFrom(var4.getClass())) {
               return var4;
            }

            return this.a(var4, var2);
         }
      } else {
         String var6 = var1.k().trim();
         if(var6.length() == 0) {
            var7 = var3;
         } else {
            try {
               var3 = this.a(var6, var2);
            } catch (IllegalArgumentException var5) {
               throw var2.b(this.q, "not a valid textual representation");
            }

            var7 = var3;
            if(var3 != null) {
               return var7;
            }

            throw var2.b(this.q, "not a valid textual representation");
         }
      }

      return var7;
   }

   protected Object a(Object var1, iz var2) {
      throw var2.b("Don\'t know how to convert embedded Object of type " + var1.getClass().getName() + " into " + this.q.getName());
   }

   protected abstract Object a(String var1, iz var2);
}
