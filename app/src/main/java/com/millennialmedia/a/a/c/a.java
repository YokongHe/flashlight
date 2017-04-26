package com.millennialmedia.a.a.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class a {
   final Class a;
   final Type b;
   final int c;

   protected a() {
      Type var1 = this.getClass().getGenericSuperclass();
      if(var1 instanceof Class) {
         throw new RuntimeException("Missing type parameter.");
      } else {
         this.b = com.millennialmedia.a.a.b.b.a(((ParameterizedType)var1).getActualTypeArguments()[0]);
         this.a = com.millennialmedia.a.a.b.b.b(this.b);
         this.c = this.b.hashCode();
      }
   }

   private a(Type var1) {
      this.b = com.millennialmedia.a.a.b.b.a((Type)com.millennialmedia.a.a.b.a.a(var1));
      this.a = com.millennialmedia.a.a.b.b.b(this.b);
      this.c = this.b.hashCode();
   }

   public static com.millennialmedia.a.a.c.a a(Class var0) {
      return new a(var0);
   }

   public static com.millennialmedia.a.a.c.a a(Type var0) {
      return new a(var0);
   }

   public final Class a() {
      return this.a;
   }

   public final Type b() {
      return this.b;
   }

   public final boolean equals(Object var1) {
      return var1 instanceof com.millennialmedia.a.a.c.a && com.millennialmedia.a.a.b.b.a(this.b, ((com.millennialmedia.a.a.c.a)var1).b);
   }

   public final int hashCode() {
      return this.c;
   }

   public final String toString() {
      return com.millennialmedia.a.a.b.b.c(this.b);
   }
}
