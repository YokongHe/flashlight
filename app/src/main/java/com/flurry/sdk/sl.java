package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.ho;
import com.flurry.sdk.hs;
import com.flurry.sdk.sl$a;
import com.flurry.sdk.sl$b;

public class sl implements ho {
   protected hs a = new sl$a();
   protected hs b = new sl$b();
   protected boolean c = true;
   protected int d = 0;

   public void a(hf var1) {
      var1.a(' ');
   }

   public void a(hf var1, int var2) {
      if(!this.b.a()) {
         --this.d;
      }

      if(var2 > 0) {
         this.b.a(var1, this.d);
      } else {
         var1.a(' ');
      }

      var1.a('}');
   }

   public void b(hf var1) {
      var1.a('{');
      if(!this.b.a()) {
         ++this.d;
      }

   }

   public void b(hf var1, int var2) {
      if(!this.a.a()) {
         --this.d;
      }

      if(var2 > 0) {
         this.a.a(var1, this.d);
      } else {
         var1.a(' ');
      }

      var1.a(']');
   }

   public void c(hf var1) {
      var1.a(',');
      this.b.a(var1, this.d);
   }

   public void d(hf var1) {
      if(this.c) {
         var1.c(" : ");
      } else {
         var1.a(':');
      }
   }

   public void e(hf var1) {
      if(!this.a.a()) {
         ++this.d;
      }

      var1.a('[');
   }

   public void f(hf var1) {
      var1.a(',');
      this.a.a(var1, this.d);
   }

   public void g(hf var1) {
      this.a.a(var1, this.d);
   }

   public void h(hf var1) {
      this.b.a(var1, this.d);
   }
}
