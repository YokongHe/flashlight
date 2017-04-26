package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jh;
import com.flurry.sdk.jk;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.sh;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class pw extends jk {
   protected final Class k;

   protected pw(sh var1) {
      this.k = var1.p();
   }

   protected pw(Class var1) {
      this.k = var1;
   }

   protected pw(Class var1, boolean var2) {
      this.k = var1;
   }

   public void a(jw var1, Throwable var2, Object var3, int var4) {
      while(var2 instanceof InvocationTargetException && var2.getCause() != null) {
         var2 = var2.getCause();
      }

      if(var2 instanceof Error) {
         throw (Error)var2;
      } else {
         boolean var5;
         if(var1 != null && !var1.a(ju$a.n)) {
            var5 = false;
         } else {
            var5 = true;
         }

         if(var2 instanceof IOException) {
            if(!var5 || !(var2 instanceof jh)) {
               throw (IOException)var2;
            }
         } else if(!var5 && var2 instanceof RuntimeException) {
            throw (RuntimeException)var2;
         }

         throw jh.a(var2, var3, var4);
      }
   }

   public void a(jw var1, Throwable var2, Object var3, String var4) {
      while(var2 instanceof InvocationTargetException && var2.getCause() != null) {
         var2 = var2.getCause();
      }

      if(var2 instanceof Error) {
         throw (Error)var2;
      } else {
         boolean var5;
         if(var1 != null && !var1.a(ju$a.n)) {
            var5 = false;
         } else {
            var5 = true;
         }

         if(var2 instanceof IOException) {
            if(!var5 || !(var2 instanceof jh)) {
               throw (IOException)var2;
            }
         } else if(!var5 && var2 instanceof RuntimeException) {
            throw (RuntimeException)var2;
         }

         throw jh.a(var2, var3, var4);
      }
   }

   public abstract void a(Object var1, hf var2, jw var3);

   protected boolean a(jk var1) {
      return var1 != null && var1.getClass().getAnnotation(kb.class) != null;
   }

   public final Class c() {
      return this.k;
   }
}
