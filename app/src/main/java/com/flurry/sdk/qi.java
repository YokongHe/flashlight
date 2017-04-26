package com.flurry.sdk;

import com.flurry.sdk.qq;
import com.flurry.sdk.qs;
import com.flurry.sdk.sh;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

public final class qi extends qq {
   protected final sh a;
   protected final Object b;

   private qi(sh var1, Object var2, Object var3, Object var4) {
      super(var2.getClass(), var1.hashCode(), var3, var4);
      this.a = var1;
      this.b = var2;
   }

   public static qi a(sh var0, Object var1, Object var2) {
      return new qi(var0, Array.newInstance(var0.p(), 0), (Object)null, (Object)null);
   }

   public final qi a(Object var1) {
      return var1 == this.g?this:new qi(this.a, this.b, this.f, var1);
   }

   protected final sh a(Class var1) {
      if(!var1.isArray()) {
         throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + this.toString() + " to class " + var1.getName());
      } else {
         var1 = var1.getComponentType();
         return a(qs.a().a((Type)var1), this.f, this.g);
      }
   }

   protected final String a() {
      return this.d.getName();
   }

   public final String a(int var1) {
      return var1 == 0?"E":null;
   }

   public final qi b(Object var1) {
      return var1 == this.a.o()?this:new qi(this.a.f(var1), this.b, this.f, this.g);
   }

   public final sh b(int var1) {
      return var1 == 0?this.a:null;
   }

   public final sh b(Class var1) {
      return var1 == this.a.p()?this:a(this.a.f(var1), this.f, this.g);
   }

   public final boolean b() {
      return true;
   }

   public final qi c(Object var1) {
      return var1 == this.f?this:new qi(this.a, this.b, var1, this.g);
   }

   public final sh c(Class var1) {
      return var1 == this.a.p()?this:a(this.a.h(var1), this.f, this.g);
   }

   public final boolean c() {
      return false;
   }

   // $FF: synthetic method
   public final sh d(Object var1) {
      return this.c(var1);
   }

   public final boolean d() {
      return true;
   }

   // $FF: synthetic method
   public final sh e(Object var1) {
      return this.b(var1);
   }

   public final boolean e() {
      return this.a.e();
   }

   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if(var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if(var1 != null) {
            var2 = var3;
            if(var1.getClass() == this.getClass()) {
               qi var4 = (qi)var1;
               return this.a.equals(var4.a);
            }
         }
      }

      return var2;
   }

   // $FF: synthetic method
   public final sh f(Object var1) {
      return this.a(var1);
   }

   public final boolean f() {
      return true;
   }

   public final sh g() {
      return this.a;
   }

   public final int h() {
      return 1;
   }

   public final String toString() {
      return "[array type, component type: " + this.a + "]";
   }
}
