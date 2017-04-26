package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$m;
import com.flurry.sdk.fn$n;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.fo;
import java.util.LinkedHashMap;

class fn$o extends LinkedHashMap {
   private String a;

   public fn$o() {
   }

   public fn$o(String var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   static String a(fn$o var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static String a(fn$o var0, String var1) {
      var0.a = var1;
      return var1;
   }

   public fn a(fn$m var1, fn var2) {
      if(this.containsKey(var1)) {
         throw new fo("Can\'t redefine: " + var1);
      } else {
         return (fn)super.put(var1, var2);
      }
   }

   public fn a(Object var1) {
      fn$m var3;
      if(var1 instanceof String) {
         fn$v var2 = (fn$v)fn.e.get((String)var1);
         if(var2 != null) {
            return fn.a(var2);
         }

         var3 = new fn$m((String)var1, this.a);
      } else {
         var3 = (fn$m)var1;
      }

      return (fn)super.get(var3);
   }

   public String a() {
      return this.a;
   }

   public void a(String var1) {
      this.a = var1;
   }

   public boolean a(fn var1) {
      return this.a((Object)((fn$n)var1).f) != null;
   }

   public void b(fn var1) {
      this.a(((fn$n)var1).f, var1);
   }

   // $FF: synthetic method
   public Object get(Object var1) {
      return this.a(var1);
   }

   // $FF: synthetic method
   public Object put(Object var1, Object var2) {
      return this.a((fn$m)var1, (fn)var2);
   }
}
