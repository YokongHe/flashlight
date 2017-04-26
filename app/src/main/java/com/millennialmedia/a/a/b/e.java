package com.millennialmedia.a.a.b;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class e implements Serializable, WildcardType {
   private final Type a;
   private final Type b;

   public e(Type[] var1, Type[] var2) {
      boolean var4 = true;
      super();
      boolean var3;
      if(var2.length <= 1) {
         var3 = true;
      } else {
         var3 = false;
      }

      com.millennialmedia.a.a.b.a.a(var3);
      if(var1.length == 1) {
         var3 = true;
      } else {
         var3 = false;
      }

      com.millennialmedia.a.a.b.a.a(var3);
      if(var2.length == 1) {
         com.millennialmedia.a.a.b.a.a(var2[0]);
         com.millennialmedia.a.a.b.b.e(var2[0]);
         if(var1[0] == Object.class) {
            var3 = var4;
         } else {
            var3 = false;
         }

         com.millennialmedia.a.a.b.a.a(var3);
         this.b = com.millennialmedia.a.a.b.b.a(var2[0]);
         this.a = Object.class;
      } else {
         com.millennialmedia.a.a.b.a.a(var1[0]);
         com.millennialmedia.a.a.b.b.e(var1[0]);
         this.b = null;
         this.a = com.millennialmedia.a.a.b.b.a(var1[0]);
      }
   }

   public final boolean equals(Object var1) {
      return var1 instanceof WildcardType && com.millennialmedia.a.a.b.b.a(this, (Type)((WildcardType)var1));
   }

   public final Type[] getLowerBounds() {
      return this.b != null?new Type[]{this.b}:com.millennialmedia.a.a.b.b.a;
   }

   public final Type[] getUpperBounds() {
      return new Type[]{this.a};
   }

   public final int hashCode() {
      int var1;
      if(this.b != null) {
         var1 = this.b.hashCode() + 31;
      } else {
         var1 = 1;
      }

      return var1 ^ this.a.hashCode() + 31;
   }

   public final String toString() {
      return this.b != null?"? super " + com.millennialmedia.a.a.b.b.c(this.b):(this.a == Object.class?"?":"? extends " + com.millennialmedia.a.a.b.b.c(this.a));
   }
}
