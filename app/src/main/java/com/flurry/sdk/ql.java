package com.flurry.sdk;

import com.flurry.sdk.qk;
import com.flurry.sdk.sh;

public final class ql extends qk {
   private ql(Class var1, sh var2, Object var3, Object var4) {
      super(var1, var2, var3, var4);
   }

   public static ql a(Class var0, sh var1) {
      return new ql(var0, var1, (Object)null, (Object)null);
   }

   // $FF: synthetic method
   public final qk a(Object var1) {
      return this.g(var1);
   }

   protected final sh a(Class var1) {
      return new ql(var1, this.a, (Object)null, (Object)null);
   }

   // $FF: synthetic method
   public final qk b(Object var1) {
      return this.h(var1);
   }

   public final sh b(Class var1) {
      return var1 == this.a.p()?this:new ql(this.d, this.a.f(var1), this.f, this.g);
   }

   // $FF: synthetic method
   public final qk c(Object var1) {
      return this.i(var1);
   }

   public final sh c(Class var1) {
      return var1 == this.a.p()?this:new ql(this.d, this.a.h(var1), this.f, this.g);
   }

   // $FF: synthetic method
   public final sh d(Object var1) {
      return this.i(var1);
   }

   // $FF: synthetic method
   public final sh e(Object var1) {
      return this.h(var1);
   }

   // $FF: synthetic method
   public final sh f(Object var1) {
      return this.g(var1);
   }

   public final ql g(Object var1) {
      return new ql(this.d, this.a, this.f, var1);
   }

   public final ql h(Object var1) {
      return new ql(this.d, this.a.f(var1), this.f, this.g);
   }

   public final ql i(Object var1) {
      return new ql(this.d, this.a, var1, this.g);
   }

   public final String toString() {
      return "[collection type; class " + this.d.getName() + ", contains " + this.a + "]";
   }
}
