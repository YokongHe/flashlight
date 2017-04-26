package com.flurry.sdk;

import com.flurry.sdk.qq;
import com.flurry.sdk.sh;
import java.util.Collection;

public class qk extends qq {
   protected final sh a;

   protected qk(Class var1, sh var2, Object var3, Object var4) {
      super(var1, var2.hashCode(), var3, var4);
      this.a = var2;
   }

   public qk a(Object var1) {
      return new qk(this.d, this.a, this.f, var1);
   }

   protected sh a(Class var1) {
      return new qk(var1, this.a, this.f, this.g);
   }

   protected String a() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.d.getName());
      if(this.a != null) {
         var1.append('<');
         var1.append(this.a.m());
         var1.append('>');
      }

      return var1.toString();
   }

   public String a(int var1) {
      return var1 == 0?"E":null;
   }

   public boolean a_() {
      return Collection.class.isAssignableFrom(this.d);
   }

   public qk b(Object var1) {
      return new qk(this.d, this.a.f(var1), this.f, this.g);
   }

   public sh b(int var1) {
      return var1 == 0?this.a:null;
   }

   public sh b(Class var1) {
      return var1 == this.a.p()?this:new qk(this.d, this.a.f(var1), this.f, this.g);
   }

   public qk c(Object var1) {
      return new qk(this.d, this.a, var1, this.g);
   }

   public sh c(Class var1) {
      return var1 == this.a.p()?this:new qk(this.d, this.a.h(var1), this.f, this.g);
   }

   // $FF: synthetic method
   public sh d(Object var1) {
      return this.c(var1);
   }

   // $FF: synthetic method
   public sh e(Object var1) {
      return this.b(var1);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         qk var2 = (qk)var1;
         if(this.d != var2.d || !this.a.equals(var2.a)) {
            return false;
         }
      }

      return true;
   }

   // $FF: synthetic method
   public sh f(Object var1) {
      return this.a(var1);
   }

   public boolean f() {
      return true;
   }

   public sh g() {
      return this.a;
   }

   public int h() {
      return 1;
   }

   public boolean i() {
      return true;
   }

   public String toString() {
      return "[collection-like type; class " + this.d.getName() + ", contains " + this.a + "]";
   }
}
