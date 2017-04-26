package com.flurry.sdk;

import com.flurry.sdk.hl;

public class hx extends hl {
   protected final hx c;
   protected String d;
   protected hx e = null;

   protected hx(int var1, hx var2) {
      this.a = var1;
      this.c = var2;
      this.b = -1;
   }

   private final hx a(int var1) {
      this.a = var1;
      this.b = -1;
      this.d = null;
      return this;
   }

   public static hx g() {
      return new hx(0, (hx)null);
   }

   public final int a(String var1) {
      if(this.a == 2 && this.d == null) {
         this.d = var1;
         return this.b < 0?0:1;
      } else {
         return 4;
      }
   }

   protected final void a(StringBuilder var1) {
      if(this.a == 2) {
         var1.append('{');
         if(this.d != null) {
            var1.append('\"');
            var1.append(this.d);
            var1.append('\"');
         } else {
            var1.append('?');
         }

         var1.append('}');
      } else if(this.a == 1) {
         var1.append('[');
         var1.append(this.f());
         var1.append(']');
      } else {
         var1.append("/");
      }
   }

   public final hx h() {
      hx var1 = this.e;
      if(var1 == null) {
         var1 = new hx(1, this);
         this.e = var1;
         return var1;
      } else {
         return var1.a(1);
      }
   }

   public final hx i() {
      hx var1 = this.e;
      if(var1 == null) {
         var1 = new hx(2, this);
         this.e = var1;
         return var1;
      } else {
         return var1.a(2);
      }
   }

   public final hx j() {
      return this.c;
   }

   public final int k() {
      if(this.a == 2) {
         if(this.d == null) {
            return 5;
         } else {
            this.d = null;
            ++this.b;
            return 2;
         }
      } else if(this.a == 1) {
         int var1 = this.b++;
         return var1 < 0?0:1;
      } else {
         ++this.b;
         return this.b == 0?0:3;
      }
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder(64);
      this.a(var1);
      return var1.toString();
   }
}
