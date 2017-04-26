package com.flurry.sdk;

import com.flurry.sdk.mu;
import com.flurry.sdk.mv;
import com.flurry.sdk.qr;
import com.flurry.sdk.sh;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class mr extends mu {
   protected final Method a;
   protected Class[] c;

   public mr(Method var1, mv var2, mv[] var3) {
      super(var2, var3);
      this.a = var1;
   }

   public final mr a(mv var1) {
      return new mr(this.a, var1, this.d);
   }

   public final mr a(Method var1) {
      return new mr(var1, this.b, this.d);
   }

   public final sh a(qr var1) {
      return this.a(var1, this.a.getTypeParameters());
   }

   public final Class a(int var1) {
      Class[] var2 = this.a.getParameterTypes();
      return var1 >= var2.length?null:var2[var1];
   }

   public final Object a(Object var1) {
      return this.a.invoke((Object)null, new Object[]{var1});
   }

   public final Object a(Object[] var1) {
      return this.a.invoke((Object)null, var1);
   }

   // $FF: synthetic method
   public final AnnotatedElement a() {
      return this.e();
   }

   public final void a(Object var1, Object var2) {
      try {
         this.a.invoke(var1, new Object[]{var2});
      } catch (IllegalAccessException var3) {
         throw new IllegalArgumentException("Failed to setValue() with method " + this.n() + ": " + var3.getMessage(), var3);
      } catch (InvocationTargetException var4) {
         throw new IllegalArgumentException("Failed to setValue() with method " + this.n() + ": " + var4.getMessage(), var4);
      }
   }

   public final String b() {
      return this.a.getName();
   }

   public final Type b(int var1) {
      Type[] var2 = this.a.getGenericParameterTypes();
      return var1 >= var2.length?null:var2[var1];
   }

   public final Type c() {
      return this.a.getGenericReturnType();
   }

   public final Class d() {
      return this.a.getReturnType();
   }

   public final Method e() {
      return this.a;
   }

   public final int f() {
      return this.l().length;
   }

   public final Object g() {
      return this.a.invoke((Object)null, new Object[0]);
   }

   public final Class h() {
      return this.a.getDeclaringClass();
   }

   public final Member i() {
      return this.a;
   }

   public final Type[] l() {
      return this.a.getGenericParameterTypes();
   }

   public final Class[] m() {
      if(this.c == null) {
         this.c = this.a.getParameterTypes();
      }

      return this.c;
   }

   public final String n() {
      return this.h().getName() + "#" + this.b() + "(" + this.f() + " params)";
   }

   public final String toString() {
      return "[method " + this.b() + ", annotations: " + this.b + "]";
   }
}
