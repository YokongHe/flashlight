package com.flurry.sdk;

import com.flurry.sdk.mq;
import com.flurry.sdk.mv;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class mp extends mq {
   protected final Field a;

   public mp(Field var1, mv var2) {
      super(var2);
      this.a = var1;
   }

   public final mp a(mv var1) {
      return new mp(this.a, var1);
   }

   public final Annotation a(Class var1) {
      return this.b.a(var1);
   }

   // $FF: synthetic method
   public final AnnotatedElement a() {
      return this.e();
   }

   public final void a(Object var1, Object var2) {
      try {
         this.a.set(var1, var2);
      } catch (IllegalAccessException var3) {
         throw new IllegalArgumentException("Failed to setValue() for field " + this.f() + ": " + var3.getMessage(), var3);
      }
   }

   public final void a(Annotation var1) {
      this.b.b(var1);
   }

   public final String b() {
      return this.a.getName();
   }

   public final Type c() {
      return this.a.getGenericType();
   }

   public final Class d() {
      return this.a.getType();
   }

   public final Field e() {
      return this.a;
   }

   public final String f() {
      return this.h().getName() + "#" + this.b();
   }

   public final Class h() {
      return this.a.getDeclaringClass();
   }

   public final Member i() {
      return this.a;
   }

   public final String toString() {
      return "[field " + this.b() + ", annotations: " + this.b + "]";
   }
}
