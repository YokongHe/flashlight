package com.tapjoy.internal;

import android.os.Looper;

public final class fs {
   public static boolean a;

   public static void a(String var0) {
      if(a) {
         com.tapjoy.internal.ad.a(4, "Tapjoy", var0, (Throwable)null);
      }

   }

   public static void a(String var0, String var1, String var2) {
      if(a) {
         com.tapjoy.internal.ad.a("Tapjoy", "{}: {} {}", new Object[]{var0, var1, var2});
      }

   }

   public static void a(String var0, Object... var1) {
      if(a) {
         com.tapjoy.internal.ad.a(4, "Tapjoy", var0, (Object[])var1);
      }

   }

   public static boolean a(Object var0, String var1) {
      if(var0 == null) {
         if(a) {
            b(var1);
         }

         return false;
      } else {
         return true;
      }
   }

   public static boolean a(boolean var0, String var1) {
      if(a && !var0) {
         b(var1);
         throw new IllegalStateException(var1);
      } else {
         return var0;
      }
   }

   public static void b(String var0) {
      if(a) {
         com.tapjoy.internal.ad.a(6, "Tapjoy", var0, (Throwable)null);
      }

   }

   public static void b(String var0, Object... var1) {
      if(a) {
         com.tapjoy.internal.ad.a("Tapjoy", var0, var1);
      }

   }

   static boolean c(String var0) {
      boolean var1;
      if(Looper.myLooper() == Looper.getMainLooper()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return a(var1, var0 + ": Must be called on the main/ui thread");
   }
}
