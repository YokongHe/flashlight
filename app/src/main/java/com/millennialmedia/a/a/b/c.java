package com.millennialmedia.a.a.b;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class c implements Serializable, GenericArrayType {
   private final Type a;

   public c(Type var1) {
      this.a = b.a(var1);
   }

   public final boolean equals(Object var1) {
      return var1 instanceof GenericArrayType && b.a(this, (Type)((GenericArrayType)var1));
   }

   public final Type getGenericComponentType() {
      return this.a;
   }

   public final int hashCode() {
      return this.a.hashCode();
   }

   public final String toString() {
      return b.c(this.a) + "[]";
   }
}
