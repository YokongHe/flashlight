package com.flurry.sdk;

import com.flurry.sdk.mq;
import com.flurry.sdk.mu;
import com.flurry.sdk.mv;
import com.flurry.sdk.qs;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class mt extends mq {
   protected final mu a;
   protected final Type c;
   protected final int d;

   public mt(mu var1, Type var2, mv var3, int var4) {
      super(var3);
      this.a = var1;
      this.c = var2;
      this.d = var4;
   }

   public final mt a(mv var1) {
      return var1 == this.b?this:this.a.a(this.d, var1);
   }

   public final Annotation a(Class var1) {
      return this.b.a(var1);
   }

   public final AnnotatedElement a() {
      return null;
   }

   public final void a(Object var1, Object var2) {
      throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + this.h().getName());
   }

   public final String b() {
      return "";
   }

   public final Type c() {
      return this.c;
   }

   public final Class d() {
      return this.c instanceof Class?(Class)this.c:qs.a().a(this.c).p();
   }

   public final Type e() {
      return this.c;
   }

   public final mu f() {
      return this.a;
   }

   public final int g() {
      return this.d;
   }

   public final Class h() {
      return this.a.h();
   }

   public final Member i() {
      return this.a.i();
   }

   public final String toString() {
      return "[parameter #" + this.g() + ", annotations: " + this.b + "]";
   }
}
