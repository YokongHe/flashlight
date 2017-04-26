package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.hf;

class fn$a extends fn {
   private final fn f;

   public fn$a(fn var1) {
      super(fn$v.c);
      this.f = var1;
   }

   void a(fn$o var1, hf var2) {
      var2.d();
      var2.a("type", "array");
      var2.a("items");
      this.f.a(var1, var2);
      this.c.a(var2);
      var2.e();
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fn$a)) {
            return false;
         }

         fn$a var2 = (fn$a)var1;
         if(!this.c(var2) || !this.f.equals(var2.f) || !this.c.equals(var2.c)) {
            return false;
         }
      }

      return true;
   }

   public fn i() {
      return this.f;
   }

   int m() {
      return super.m() + this.f.m();
   }
}
