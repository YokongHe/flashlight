package com.flurry.sdk;

import com.flurry.sdk.ii;
import com.flurry.sdk.iz;
import com.flurry.sdk.jl;

public abstract class ma extends jl {
   protected final Class a;

   protected ma(Class var1) {
      this.a = var1;
   }

   protected int a(String var1) {
      return Integer.parseInt(var1);
   }

   public Class a() {
      return this.a;
   }

   public final Object a(String var1, iz var2) {
      Object var3;
      if(var1 == null) {
         var3 = null;
      } else {
         Object var4;
         try {
            var4 = this.b(var1, var2);
         } catch (Exception var5) {
            throw var2.a(this.a, var1, "not a valid representation: " + var5.getMessage());
         }

         var3 = var4;
         if(var4 == null) {
            throw var2.a(this.a, var1, "not a valid representation");
         }
      }

      return var3;
   }

   protected long b(String var1) {
      return Long.parseLong(var1);
   }

   protected abstract Object b(String var1, iz var2);

   protected double c(String var1) {
      return ii.c(var1);
   }
}
