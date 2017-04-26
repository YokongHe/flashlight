package com.flurry.sdk;

import com.flurry.sdk.mu;
import com.flurry.sdk.mv;
import com.flurry.sdk.qr;
import com.flurry.sdk.sh;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class mo extends mu {
   protected final Constructor a;

   public mo(Constructor var1, mv var2, mv[] var3) {
      super(var2, var3);
      if(var1 == null) {
         throw new IllegalArgumentException("Null constructor not allowed");
      } else {
         this.a = var1;
      }
   }

   public final sh a(qr var1) {
      return this.a(var1, this.a.getTypeParameters());
   }

   public final Class a(int var1) {
      Class[] var2 = this.a.getParameterTypes();
      return var1 >= var2.length?null:var2[var1];
   }

   public final Object a(Object var1) {
      return this.a.newInstance(new Object[]{var1});
   }

   public final Object a(Object[] var1) {
      return this.a.newInstance(var1);
   }

   // $FF: synthetic method
   public final AnnotatedElement a() {
      return this.e();
   }

   public final void a(Object var1, Object var2) {
      throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + this.h().getName());
   }

   public final String b() {
      return this.a.getName();
   }

   public final Type b(int var1) {
      Type[] var2 = this.a.getGenericParameterTypes();
      return var1 >= var2.length?null:var2[var1];
   }

   public final Type c() {
      return this.d();
   }

   public final Class d() {
      return this.a.getDeclaringClass();
   }

   public final Constructor e() {
      return this.a;
   }

   public final int f() {
      return this.a.getParameterTypes().length;
   }

   public final Object g() {
      return this.a.newInstance(new Object[0]);
   }

   public final Class h() {
      return this.a.getDeclaringClass();
   }

   public final Member i() {
      return this.a;
   }

   public final String toString() {
      return "[constructor for " + this.b() + ", annotations: " + this.b + "]";
   }
}
