package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$j;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.hf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class fn$w extends fn {
   private final List f;
   private final Map g = new HashMap();

   public fn$w(fn$j var1) {
      super(fn$v.e);
      this.f = var1.a();
      Iterator var4 = var1.iterator();

      for(int var2 = 0; var4.hasNext(); ++var2) {
         fn var3 = (fn)var4.next();
         if(var3.a() == fn$v.e) {
            throw new fk("Nested union: " + this);
         }

         String var5 = var3.g();
         if(var5 == null) {
            throw new fk("Nameless in union:" + this);
         }

         if(this.g.put(var5, Integer.valueOf(var2)) != null) {
            throw new fk("Duplicate in union:" + var5);
         }
      }

   }

   void a(fn$o var1, hf var2) {
      var2.b();
      Iterator var3 = this.f.iterator();

      while(var3.hasNext()) {
         ((fn)var3.next()).a(var1, var2);
      }

      var2.c();
   }

   public void a(String var1, String var2) {
      throw new fk("Can\'t set properties on a union: " + this);
   }

   public Integer e(String var1) {
      return (Integer)this.g.get(var1);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fn$w)) {
            return false;
         }

         fn$w var2 = (fn$w)var1;
         if(!this.c(var2) || !this.f.equals(var2.f) || !this.c.equals(var2.c)) {
            return false;
         }
      }

      return true;
   }

   public List k() {
      return this.f;
   }

   int m() {
      int var1 = super.m();

      for(Iterator var2 = this.f.iterator(); var2.hasNext(); var1 += ((fn)var2.next()).m()) {
         ;
      }

      return var1;
   }
}
