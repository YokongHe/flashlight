package com.flurry.sdk;

final class nd$a {
   public final Object a;
   public final nd$a b;
   public final String c;
   public final boolean d;
   public final boolean e;

   public nd$a(Object var1, nd$a var2, String var3, boolean var4, boolean var5) {
      this.a = var1;
      this.b = var2;
      if(var3 == null) {
         var3 = null;
      } else if(var3.length() == 0) {
         var3 = null;
      }

      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   // $FF: synthetic method
   static nd$a a(nd$a var0, nd$a var1) {
      return var0.b(var1);
   }

   private nd$a b(nd$a var1) {
      return this.b == null?this.a(var1):this.a(this.b.b(var1));
   }

   public final nd$a a() {
      nd$a var1 = this;

      nd$a var2;
      while(true) {
         if(!var1.e) {
            var2 = var1;
            if(var1.b != null) {
               nd$a var3 = var1.b.a();
               var2 = var1;
               if(var3 != var1.b) {
                  return var1.a(var3);
               }
            }
            break;
         }

         if(var1.b == null) {
            var2 = null;
            break;
         }

         var1 = var1.b;
      }

      return var2;
   }

   public final nd$a a(nd$a var1) {
      return var1 == this.b?this:new nd$a(this.a, var1, this.c, this.d, this.e);
   }

   public final nd$a a(Object var1) {
      return var1 == this.a?this:new nd$a(var1, this.b, this.c, this.d, this.e);
   }

   public final nd$a b() {
      nd$a var1;
      if(this.b == null) {
         var1 = null;
      } else {
         var1 = this.b.b();
      }

      nd$a var2 = var1;
      if(this.d) {
         var2 = this.a(var1);
      }

      return var2;
   }

   public final nd$a c() {
      if(this.b == null) {
         return this;
      } else {
         nd$a var1 = this.b.c();
         return this.c != null?(var1.c == null?this.a((nd$a)null):this.a(var1)):(var1.c != null?var1:(this.d == var1.d?this.a(var1):(this.d?this.a((nd$a)null):var1)));
      }
   }

   public final String toString() {
      String var2 = this.a.toString() + "[visible=" + this.d + "]";
      String var1 = var2;
      if(this.b != null) {
         var1 = var2 + ", " + this.b.toString();
      }

      return var1;
   }
}
