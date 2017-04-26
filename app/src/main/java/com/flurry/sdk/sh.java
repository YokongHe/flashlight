package com.flurry.sdk;

import java.lang.reflect.Modifier;

public abstract class sh {
   protected final Class d;
   protected final int e;
   protected Object f;
   protected Object g;

   protected sh(Class var1, int var2) {
      this.d = var1;
      this.e = var1.getName().hashCode() + var2;
      this.f = null;
      this.g = null;
   }

   protected abstract sh a(Class var1);

   public String a(int var1) {
      return null;
   }

   protected void a(Class var1, Class var2) {
      if(!this.d.isAssignableFrom(var1)) {
         throw new IllegalArgumentException("Class " + var1.getName() + " is not assignable to " + this.d.getName());
      }
   }

   public sh b(int var1) {
      return null;
   }

   public abstract sh b(Class var1);

   public boolean b() {
      return false;
   }

   public abstract sh c(Class var1);

   public boolean c() {
      return Modifier.isAbstract(this.d.getModifiers());
   }

   public sh d(Object var1) {
      this.j(var1);
      return this;
   }

   public boolean d() {
      return (this.d.getModifiers() & 1536) == 0 || this.d.isPrimitive();
   }

   public abstract sh e(Object var1);

   public boolean e() {
      return this.h() > 0;
   }

   public abstract boolean equals(Object var1);

   public sh f(Class var1) {
      if(var1 == this.d) {
         return this;
      } else {
         this.a(var1, this.d);
         sh var2 = this.a(var1);
         sh var3 = var2;
         if(this.f != var2.n()) {
            var3 = var2.d(this.f);
         }

         var2 = var3;
         if(this.g != var3.o()) {
            var2 = var3.f(this.g);
         }

         return var2;
      }
   }

   public abstract sh f(Object var1);

   public abstract boolean f();

   public sh g() {
      return null;
   }

   public sh g(Class var1) {
      if(var1 == this.d) {
         return this;
      } else {
         sh var2 = this.a(var1);
         sh var3 = var2;
         if(this.f != var2.n()) {
            var3 = var2.d(this.f);
         }

         var2 = var3;
         if(this.g != var3.o()) {
            var2 = var3.f(this.g);
         }

         return var2;
      }
   }

   public int h() {
      return 0;
   }

   public sh h(Class var1) {
      if(var1 == this.d) {
         return this;
      } else {
         this.a(this.d, var1);
         return this.i(var1);
      }
   }

   public final int hashCode() {
      return this.e;
   }

   protected sh i(Class var1) {
      return this.a(var1);
   }

   public boolean i() {
      return false;
   }

   @Deprecated
   public void j(Object var1) {
      if(var1 != null && this.f != null) {
         throw new IllegalStateException("Trying to reset value handler for type [" + this.toString() + "]; old handler of type " + this.f.getClass().getName() + ", new handler of type " + var1.getClass().getName());
      } else {
         this.f = var1;
      }
   }

   public boolean j() {
      return false;
   }

   public sh k() {
      return null;
   }

   public abstract String m();

   public Object n() {
      return this.f;
   }

   public Object o() {
      return this.g;
   }

   public final Class p() {
      return this.d;
   }

   public boolean q() {
      return Throwable.class.isAssignableFrom(this.d);
   }

   public final boolean r() {
      return this.d.isEnum();
   }

   public final boolean s() {
      return this.d.isInterface();
   }

   public final boolean t() {
      return this.d.isPrimitive();
   }

   public abstract String toString();

   public final boolean u() {
      return Modifier.isFinal(this.d.getModifiers());
   }
}
