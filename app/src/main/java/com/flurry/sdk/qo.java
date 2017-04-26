package com.flurry.sdk;

import com.flurry.sdk.qn;
import com.flurry.sdk.sh;

public final class qo extends qn {
   private qo(Class var1, sh var2, sh var3, Object var4, Object var5) {
      super(var1, var2, var3, var4, var5);
   }

   public static qo a(Class var0, sh var1, sh var2) {
      return new qo(var0, var1, var2, (Object)null, (Object)null);
   }

   // $FF: synthetic method
   public final qn a(Object var1) {
      return this.g(var1);
   }

   protected final sh a(Class var1) {
      return new qo(var1, this.a, this.b, this.f, this.g);
   }

   // $FF: synthetic method
   public final qn b(Object var1) {
      return this.h(var1);
   }

   public final sh b(Class var1) {
      return var1 == this.b.p()?this:new qo(this.d, this.a, this.b.f(var1), this.f, this.g);
   }

   // $FF: synthetic method
   public final qn c(Object var1) {
      return this.i(var1);
   }

   public final sh c(Class var1) {
      return var1 == this.b.p()?this:new qo(this.d, this.a, this.b.h(var1), this.f, this.g);
   }

   public final sh d(Class var1) {
      return var1 == this.a.p()?this:new qo(this.d, this.a.f(var1), this.b, this.f, this.g);
   }

   // $FF: synthetic method
   public final sh d(Object var1) {
      return this.i(var1);
   }

   public final sh e(Class var1) {
      return var1 == this.a.p()?this:new qo(this.d, this.a.h(var1), this.b, this.f, this.g);
   }

   // $FF: synthetic method
   public final sh e(Object var1) {
      return this.h(var1);
   }

   // $FF: synthetic method
   public final sh f(Object var1) {
      return this.g(var1);
   }

   public final qo g(Object var1) {
      return new qo(this.d, this.a, this.b, this.f, var1);
   }

   public final qo h(Object var1) {
      return new qo(this.d, this.a, this.b.f(var1), this.f, this.g);
   }

   public final qo i(Object var1) {
      return new qo(this.d, this.a, this.b, var1, this.g);
   }

   public final String toString() {
      return "[map type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
   }
}
