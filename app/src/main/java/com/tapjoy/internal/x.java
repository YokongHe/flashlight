package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

public final class x {
   private static Handler a;

   public static Handler a() {
      synchronized(com.tapjoy.internal.x.class){}

      Handler var0;
      try {
         if(a == null) {
            a = new Handler(Looper.getMainLooper());
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   public static com.tapjoy.internal.bf a(final Handler var0) {
      return new com.tapjoy.internal.bf() {
         public final boolean a(Runnable var1) {
            return var0.post(var1);
         }
      };
   }
}
