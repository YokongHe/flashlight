package com.flurry.sdk;

import com.flurry.sdk.fl;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$m;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.hf;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

abstract class fn$n extends fn {
   final fn$m f;
   final String g;
   Set h;

   public fn$n(fn$v var1, fn$m var2, String var3) {
      super(var1);
      this.f = var2;
      this.g = var3;
      if(e.containsKey(fn$m.a(var2))) {
         throw new fl("Schemas may not be named after primitives: " + fn$m.a(var2));
      }
   }

   public void a(hf var1) {
      if(this.h != null && this.h.size() != 0) {
         var1.a("aliases");
         var1.b();
         Iterator var2 = this.h.iterator();

         while(var2.hasNext()) {
            var1.b(((fn$m)var2.next()).a(fn$m.c(this.f)));
         }

         var1.c();
      }
   }

   public boolean a(fn$n var1) {
      return this.f.equals(var1.f);
   }

   public boolean c(fn$o var1, hf var2) {
      if(this.equals(var1.a((Object)this.f))) {
         var2.b(this.f.a(var1.a()));
         return true;
      } else {
         if(fn$m.b(this.f) != null) {
            var1.a((fn$m)this.f, (fn)this);
         }

         return false;
      }
   }

   public String d() {
      return fn$m.b(this.f);
   }

   public void d(fn$o var1, hf var2) {
      this.f.a(var1, var2);
   }

   public void d(String var1) {
      if(this.h == null) {
         this.h = new LinkedHashSet();
      }

      this.h.add(new fn$m(var1, fn$m.c(this.f)));
   }

   public String e() {
      return this.g;
   }

   public String f() {
      return fn$m.c(this.f);
   }

   public String g() {
      return fn$m.a(this.f);
   }

   int m() {
      return super.m() + this.f.hashCode();
   }
}
