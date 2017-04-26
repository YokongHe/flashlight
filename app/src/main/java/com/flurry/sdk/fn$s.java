package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.fn$f$a;
import com.flurry.sdk.fn$j;
import com.flurry.sdk.fn$m;
import com.flurry.sdk.fn$n;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$t;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.hf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class fn$s extends fn$n {
   private List i;
   private Map j;
   private final boolean k;

   public fn$s(fn$m var1, String var2, boolean var3) {
      super(fn$v.a, var1, var2);
      this.k = var3;
   }

   void a(fn$o var1, hf var2) {
      if(!this.c(var1, var2)) {
         String var4 = fn$o.a(var1);
         var2.d();
         String var3;
         if(this.k) {
            var3 = "error";
         } else {
            var3 = "record";
         }

         var2.a("type", var3);
         this.d(var1, var2);
         fn$o.a(var1, fn$m.c(this.f));
         if(this.e() != null) {
            var2.a("doc", this.e());
         }

         var2.a("fields");
         this.b(var1, var2);
         this.c.a(var2);
         this.a(var2);
         var2.e();
         fn$o.a(var1, var4);
      }
   }

   public fn$f b(String var1) {
      if(this.j == null) {
         throw new fk("Schema fields not set yet");
      } else {
         return (fn$f)this.j.get(var1);
      }
   }

   public List b() {
      if(this.i == null) {
         throw new fk("Schema fields not set yet");
      } else {
         return this.i;
      }
   }

   void b(fn$o var1, hf var2) {
      var2.b();
      Iterator var3 = this.i.iterator();

      while(var3.hasNext()) {
         fn$f var4 = (fn$f)var3.next();
         var2.d();
         var2.a("name", var4.a());
         var2.a("type");
         var4.c().a(var1, var2);
         if(var4.d() != null) {
            var2.a("doc", var4.d());
         }

         if(var4.e() != null) {
            var2.a("default");
            var2.a(var4.e());
         }

         if(var4.f() != fn$f$a.a) {
            var2.a("order", fn$f$a.a(var4.f()));
         }

         if(fn$f.b(var4) != null && fn$f.b(var4).size() != 0) {
            var2.a("aliases");
            var2.b();
            Iterator var5 = fn$f.b(var4).iterator();

            while(var5.hasNext()) {
               var2.b((String)var5.next());
            }

            var2.c();
         }

         fn$f.c(var4).a(var2);
         var2.e();
      }

      var2.c();
   }

   public void c(List var1) {
      if(this.i != null) {
         throw new fk("Fields are already set");
      } else {
         this.j = new HashMap();
         fn$j var3 = new fn$j();
         Iterator var5 = var1.iterator();

         for(int var2 = 0; var5.hasNext(); ++var2) {
            fn$f var4 = (fn$f)var5.next();
            if(fn$f.a(var4) != -1) {
               throw new fk("Field already used: " + var4);
            }

            fn$f.a(var4, var2);
            this.j.put(var4.a(), var4);
            var3.add(var4);
         }

         this.i = var3.a();
         this.d = Integer.MIN_VALUE;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof fn$s)) {
         return false;
      } else {
         fn$s var4 = (fn$s)var1;
         if(!this.c(var4)) {
            return false;
         } else if(!this.a(var4)) {
            return false;
         } else if(!this.c.equals(var4.c)) {
            return false;
         } else {
            Set var8 = (Set)fn.o().get();
            fn$t var5 = new fn$t(this, var1, null);
            if(var8.contains(var5)) {
               return true;
            } else {
               boolean var2 = var8.isEmpty();

               boolean var3;
               try {
                  var8.add(var5);
                  var3 = this.i.equals(((fn$s)var1).i);
               } finally {
                  if(var2) {
                     var8.clear();
                  }

               }

               return var3;
            }
         }
      }
   }

   public boolean h() {
      return this.k;
   }

   int m() {
      Map var4 = (Map)fn.p().get();
      if(var4.containsKey(this)) {
         return 0;
      } else {
         boolean var3 = var4.isEmpty();

         int var1;
         int var2;
         try {
            var4.put(this, this);
            var1 = super.m();
            var2 = this.i.hashCode();
         } finally {
            if(var3) {
               var4.clear();
            }

         }

         return var1 + var2;
      }
   }
}
