package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;

public abstract class g {
   private final String a;
   private Object b;

   protected g(String var1) {
      this.a = var1;
   }

   protected final Object a(Context var1) {
      if(this.b == null) {
         com.google.android.gms.internal.cM.a((Object)var1);
         var1 = com.google.android.gms.common.g.c(var1);
         if(var1 == null) {
            throw new com.google.android.gms.a.h("Could not get remote context.");
         }

         ClassLoader var5 = var1.getClassLoader();

         try {
            this.b = this.a((IBinder)var5.loadClass(this.a).newInstance());
         } catch (ClassNotFoundException var2) {
            throw new com.google.android.gms.a.h("Could not load creator class.");
         } catch (InstantiationException var3) {
            throw new com.google.android.gms.a.h("Could not instantiate creator.");
         } catch (IllegalAccessException var4) {
            throw new com.google.android.gms.a.h("Could not access creator.");
         }
      }

      return this.b;
   }

   protected abstract Object a(IBinder var1);
}
