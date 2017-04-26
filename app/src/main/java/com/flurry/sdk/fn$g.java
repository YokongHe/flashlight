package com.flurry.sdk;

import com.flurry.sdk.fn$m;
import com.flurry.sdk.fn$n;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.hf;

class fn$g extends fn$n {
   private final int i;

   public fn$g(fn$m var1, String var2, int var3) {
      super(fn$v.f, var1, var2);
      if(var3 < 0) {
         throw new IllegalArgumentException("Invalid fixed size: " + var3);
      } else {
         this.i = var3;
      }
   }

   void a(fn$o var1, hf var2) {
      if(!this.c(var1, var2)) {
         var2.d();
         var2.a("type", "fixed");
         this.d(var1, var2);
         if(this.e() != null) {
            var2.a("doc", this.e());
         }

         var2.a("size", this.i);
         this.c.a(var2);
         this.a(var2);
         var2.e();
      }
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fn$g)) {
            return false;
         }

         fn$g var2 = (fn$g)var1;
         if(!this.c(var2) || !this.a(var2) || this.i != var2.i || !this.c.equals(var2.c)) {
            return false;
         }
      }

      return true;
   }

   public int l() {
      return this.i;
   }

   int m() {
      return super.m() + this.i;
   }
}
