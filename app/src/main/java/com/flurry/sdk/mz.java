package com.flurry.sdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class mz {
   static final Class[] a = new Class[0];
   final String b;
   final Class[] c;

   public mz(String var1, Class[] var2) {
      this.b = var1;
      Class[] var3 = var2;
      if(var2 == null) {
         var3 = a;
      }

      this.c = var3;
   }

   public mz(Constructor var1) {
      this("", var1.getParameterTypes());
   }

   public mz(Method var1) {
      this(var1.getName(), var1.getParameterTypes());
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         mz var6 = (mz)var1;
         if(!this.b.equals(var6.b)) {
            return false;
         }

         Class[] var7 = var6.c;
         int var3 = this.c.length;
         if(var7.length != var3) {
            return false;
         }

         for(int var2 = 0; var2 < var3; ++var2) {
            Class var4 = var7[var2];
            Class var5 = this.c[var2];
            if(var4 != var5 && !var4.isAssignableFrom(var5) && !var5.isAssignableFrom(var4)) {
               return false;
            }
         }
      }

      return true;
   }

   public final int hashCode() {
      return this.b.hashCode() + this.c.length;
   }

   public final String toString() {
      return this.b + "(" + this.c.length + "-args)";
   }
}
