package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$j;
import com.flurry.sdk.fn$m;
import com.flurry.sdk.fn$n;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.fo;
import com.flurry.sdk.hf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class fn$e extends fn$n {
   private final List i;
   private final Map j;

   public fn$e(fn$m var1, String var2, fn$j var3) {
      super(fn$v.b, var1, var2);
      this.i = var3.a();
      this.j = new HashMap();
      Iterator var5 = var3.iterator();

      for(int var4 = 0; var5.hasNext(); ++var4) {
         var2 = (String)var5.next();
         if(this.j.put(fn.g(var2), Integer.valueOf(var4)) != null) {
            throw new fo("Duplicate enum symbol: " + var2);
         }
      }

   }

   void a(fn$o var1, hf var2) {
      if(!this.c(var1, var2)) {
         var2.d();
         var2.a("type", "enum");
         this.d(var1, var2);
         if(this.e() != null) {
            var2.a("doc", this.e());
         }

         var2.f("symbols");
         Iterator var3 = this.i.iterator();

         while(var3.hasNext()) {
            var2.b((String)var3.next());
         }

         var2.c();
         this.c.a(var2);
         this.a(var2);
         var2.e();
      }
   }

   public int c(String var1) {
      return ((Integer)this.j.get(var1)).intValue();
   }

   public List c() {
      return this.i;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fn$e)) {
            return false;
         }

         fn$e var2 = (fn$e)var1;
         if(!this.c(var2) || !this.a(var2) || !this.i.equals(var2.i) || !this.c.equals(var2.c)) {
            return false;
         }
      }

      return true;
   }

   int m() {
      return super.m() + this.i.hashCode();
   }
}
