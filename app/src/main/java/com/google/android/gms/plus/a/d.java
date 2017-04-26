package com.google.android.gms.plus.a;

import android.content.Context;
import android.os.IBinder;
import android.view.View;

public final class d {
   private static Context a;
   private static com.google.android.gms.plus.a.a b;

   public static View a(Context param0, int param1, int param2, String param3, int param4) {
      // $FF: Couldn't be decompiled
   }

   private static com.google.android.gms.plus.a.a a(Context var0) {
      com.google.android.gms.internal.cM.a((Object)var0);
      if(b == null) {
         if(a == null) {
            var0 = com.google.android.gms.common.g.c(var0);
            a = var0;
            if(var0 == null) {
               throw new com.google.android.gms.plus.a.e("Could not get remote context.");
            }
         }

         ClassLoader var4 = a.getClassLoader();

         try {
            b = com.google.android.gms.plus.a.b.a((IBinder)var4.loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
         } catch (ClassNotFoundException var1) {
            throw new com.google.android.gms.plus.a.e("Could not load creator class.");
         } catch (InstantiationException var2) {
            throw new com.google.android.gms.plus.a.e("Could not instantiate creator.");
         } catch (IllegalAccessException var3) {
            throw new com.google.android.gms.plus.a.e("Could not access creator.");
         }
      }

      return b;
   }
}
