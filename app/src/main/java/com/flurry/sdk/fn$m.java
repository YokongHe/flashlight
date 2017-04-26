package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.hf;

class fn$m {
   private final String a;
   private final String b;
   private final String c;

   public fn$m(String var1, String var2) {
      if(var1 == null) {
         this.c = null;
         this.b = null;
         this.a = null;
      } else {
         int var3 = var1.lastIndexOf(46);
         if(var3 < 0) {
            this.b = var2;
            this.a = fn.g(var1);
         } else {
            this.b = var1.substring(0, var3);
            this.a = fn.g(var1.substring(var3 + 1, var1.length()));
         }

         if(this.b == null) {
            var1 = this.a;
         } else {
            var1 = this.b + "." + this.a;
         }

         this.c = var1;
      }
   }

   // $FF: synthetic method
   static String a(fn$m var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static String b(fn$m var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static String c(fn$m var0) {
      return var0.b;
   }

   public String a(String var1) {
      return this.b != null && !this.b.equals(var1)?this.c:this.a;
   }

   public void a(fn$o var1, hf var2) {
      if(this.a != null) {
         var2.a("name", this.a);
      }

      if(this.b != null) {
         if(!this.b.equals(var1.a())) {
            var2.a("namespace", this.b);
         }

         if(var1.a() == null) {
            var1.a(this.b);
         }
      }

   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fn$m)) {
            return false;
         }

         fn$m var2 = (fn$m)var1;
         if(this.c != null) {
            return this.c.equals(var2.c);
         }

         if(var2.c != null) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.c == null?0:this.c.hashCode();
   }

   public String toString() {
      return this.c;
   }
}
