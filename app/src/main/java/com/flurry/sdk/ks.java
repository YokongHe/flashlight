package com.flurry.sdk;

import com.flurry.sdk.hg;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.mr;
import com.flurry.sdk.sh;
import java.io.IOException;
import java.lang.reflect.Method;

public final class ks {
   protected final is a;
   protected final Method b;
   protected final sh c;
   protected jg d;

   public ks(is var1, mr var2, sh var3, jg var4) {
      this(var1, var2.e(), var3, var4);
   }

   public ks(is var1, Method var2, sh var3, jg var4) {
      this.a = var1;
      this.c = var3;
      this.b = var2;
      this.d = var4;
   }

   private String d() {
      return this.b.getDeclaringClass().getName();
   }

   public final is a() {
      return this.a;
   }

   public final ks a(jg var1) {
      return new ks(this.a, this.b, this.c, var1);
   }

   public final Object a(hj var1, iz var2) {
      return var1.e() == hm.m?null:this.d.a(var1, var2);
   }

   public final void a(hj var1, iz var2, Object var3, String var4) {
      this.a(var3, var4, this.a(var1, var2));
   }

   protected final void a(Exception var1, String var2, Object var3) {
      if(var1 instanceof IllegalArgumentException) {
         String var6;
         if(var3 == null) {
            var6 = "[NULL]";
         } else {
            var6 = var3.getClass().getName();
         }

         StringBuilder var5 = (new StringBuilder("Problem deserializing \"any\" property \'")).append(var2);
         var5.append("\' of class " + this.d() + " (expected type: ").append(this.c);
         var5.append("; actual type: ").append(var6).append(")");
         var6 = var1.getMessage();
         if(var6 != null) {
            var5.append(", problem: ").append(var6);
         } else {
            var5.append(" (no error message provided)");
         }

         throw new jh(var5.toString(), (hg)null, var1);
      } else if(var1 instanceof IOException) {
         throw (IOException)var1;
      } else {
         Object var4 = var1;
         if(var1 instanceof RuntimeException) {
            throw (RuntimeException)var1;
         } else {
            while(((Throwable)var4).getCause() != null) {
               var4 = ((Throwable)var4).getCause();
            }

            throw new jh(((Throwable)var4).getMessage(), (hg)null, (Throwable)var4);
         }
      }
   }

   public final void a(Object var1, String var2, Object var3) {
      try {
         this.b.invoke(var1, new Object[]{var2, var3});
      } catch (Exception var4) {
         this.a(var4, var2, var3);
      }
   }

   public final boolean b() {
      return this.d != null;
   }

   public final sh c() {
      return this.c;
   }

   public final String toString() {
      return "[any property on class " + this.d() + "]";
   }
}
