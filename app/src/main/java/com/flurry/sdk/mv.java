package com.flurry.sdk;

import com.flurry.sdk.qv;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;

public final class mv implements qv {
   protected HashMap a;

   public mv() {
   }

   private mv(HashMap var1) {
      this.a = var1;
   }

   public static mv a(mv var0, mv var1) {
      mv var2;
      if(var0 != null && var0.a != null && !var0.a.isEmpty()) {
         var2 = var0;
         if(var1 != null) {
            var2 = var0;
            if(var1.a != null) {
               var2 = var0;
               if(!var1.a.isEmpty()) {
                  HashMap var7 = new HashMap();
                  Iterator var5 = var1.a.values().iterator();

                  while(var5.hasNext()) {
                     Annotation var3 = (Annotation)var5.next();
                     var7.put(var3.annotationType(), var3);
                  }

                  Iterator var4 = var0.a.values().iterator();

                  while(var4.hasNext()) {
                     Annotation var6 = (Annotation)var4.next();
                     var7.put(var6.annotationType(), var6);
                  }

                  return new mv(var7);
               }
            }
         }
      } else {
         var2 = var1;
      }

      return var2;
   }

   public final int a() {
      return this.a == null?0:this.a.size();
   }

   public final Annotation a(Class var1) {
      return this.a == null?null:(Annotation)this.a.get(var1);
   }

   public final void a(Annotation var1) {
      if(this.a == null || !this.a.containsKey(var1.annotationType())) {
         this.c(var1);
      }

   }

   public final void b(Annotation var1) {
      this.c(var1);
   }

   protected final void c(Annotation var1) {
      if(this.a == null) {
         this.a = new HashMap();
      }

      this.a.put(var1.annotationType(), var1);
   }

   public final String toString() {
      return this.a == null?"[null]":this.a.toString();
   }
}
