package com.flurry.sdk;

import com.flurry.sdk.qq;
import com.flurry.sdk.sh;
import java.util.Map;

public class qn extends qq {
   protected final sh a;
   protected final sh b;

   protected qn(Class var1, sh var2, sh var3, Object var4, Object var5) {
      super(var1, var2.hashCode() ^ var3.hashCode(), var4, var5);
      this.a = var2;
      this.b = var3;
   }

   public qn a(Object var1) {
      return new qn(this.d, this.a, this.b, this.f, var1);
   }

   protected sh a(Class var1) {
      return new qn(var1, this.a, this.b, this.f, this.g);
   }

   protected String a() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.d.getName());
      if(this.a != null) {
         var1.append('<');
         var1.append(this.a.m());
         var1.append(',');
         var1.append(this.b.m());
         var1.append('>');
      }

      return var1.toString();
   }

   public String a(int var1) {
      return var1 == 0?"K":(var1 == 1?"V":null);
   }

   public qn b(Object var1) {
      return new qn(this.d, this.a, this.b.f(var1), this.f, this.g);
   }

   public sh b(int var1) {
      return var1 == 0?this.a:(var1 == 1?this.b:null);
   }

   public sh b(Class var1) {
      return var1 == this.b.p()?this:new qn(this.d, this.a, this.b.f(var1), this.f, this.g);
   }

   public qn c(Object var1) {
      return new qn(this.d, this.a, this.b, var1, this.g);
   }

   public sh c(Class var1) {
      return var1 == this.b.p()?this:new qn(this.d, this.a, this.b.h(var1), this.f, this.g);
   }

   public sh d(Class var1) {
      return var1 == this.a.p()?this:new qn(this.d, this.a.f(var1), this.b, this.f, this.g);
   }

   // $FF: synthetic method
   public sh d(Object var1) {
      return this.c(var1);
   }

   public sh e(Class var1) {
      return var1 == this.a.p()?this:new qn(this.d, this.a.h(var1), this.b, this.f, this.g);
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

         qn var2 = (qn)var1;
         if(this.d != var2.d || !this.a.equals(var2.a) || !this.b.equals(var2.b)) {
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
      return this.b;
   }

   public int h() {
      return 2;
   }

   public boolean j() {
      return true;
   }

   public sh k() {
      return this.a;
   }

   public boolean l() {
      return Map.class.isAssignableFrom(this.d);
   }

   public String toString() {
      return "[map-like type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
   }
}
