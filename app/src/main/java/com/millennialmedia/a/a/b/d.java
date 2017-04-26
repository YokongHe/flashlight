package com.millennialmedia.a.a.b;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class d implements Serializable, ParameterizedType {
   private final Type a;
   private final Type b;
   private final Type[] c;

   public d(Type var1, Type var2, Type... var3) {
      boolean var6 = true;
      int var4 = 0;
      super();
      if(var2 instanceof Class) {
         Class var7 = (Class)var2;
         boolean var5;
         if(var1 == null && var7.getEnclosingClass() != null) {
            var5 = false;
         } else {
            var5 = true;
         }

         com.millennialmedia.a.a.b.a.a(var5);
         var5 = var6;
         if(var1 != null) {
            if(var7.getEnclosingClass() != null) {
               var5 = var6;
            } else {
               var5 = false;
            }
         }

         com.millennialmedia.a.a.b.a.a(var5);
      }

      if(var1 == null) {
         var1 = null;
      } else {
         var1 = com.millennialmedia.a.a.b.b.a(var1);
      }

      this.a = var1;
      this.b = com.millennialmedia.a.a.b.b.a(var2);

      for(this.c = (Type[])var3.clone(); var4 < this.c.length; ++var4) {
         com.millennialmedia.a.a.b.a.a(this.c[var4]);
         com.millennialmedia.a.a.b.b.e(this.c[var4]);
         this.c[var4] = com.millennialmedia.a.a.b.b.a(this.c[var4]);
      }

   }

   public final boolean equals(Object var1) {
      return var1 instanceof ParameterizedType && com.millennialmedia.a.a.b.b.a(this, (Type)((ParameterizedType)var1));
   }

   public final Type[] getActualTypeArguments() {
      return (Type[])this.c.clone();
   }

   public final Type getOwnerType() {
      return this.a;
   }

   public final Type getRawType() {
      return this.b;
   }

   public final int hashCode() {
      return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ com.millennialmedia.a.a.b.b.a((Object)this.a);
   }

   public final String toString() {
      StringBuilder var2 = new StringBuilder((this.c.length + 1) * 30);
      var2.append(com.millennialmedia.a.a.b.b.c(this.b));
      if(this.c.length == 0) {
         return var2.toString();
      } else {
         var2.append("<").append(com.millennialmedia.a.a.b.b.c(this.c[0]));

         for(int var1 = 1; var1 < this.c.length; ++var1) {
            var2.append(", ").append(com.millennialmedia.a.a.b.b.c(this.c[var1]));
         }

         return var2.append(">").toString();
      }
   }
}
