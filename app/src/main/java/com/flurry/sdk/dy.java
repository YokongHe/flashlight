package com.flurry.sdk;

import android.os.Looper;
import com.flurry.sdk.do;

public class dy {
   private static final String a = dy.class.getSimpleName();
   private static byte[] b;

   public static byte[] a() {
      synchronized(dy.class){}
      boolean var2 = false;

      byte[] var0;
      label58: {
         try {
            var2 = true;
            if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
               throw new IllegalStateException("Must be called from a background thread!");
            }

            if(b != null) {
               var0 = b;
               var2 = false;
               break label58;
            }

            if(do.a().b().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
               b();
               var0 = b;
               var2 = false;
               break label58;
            }

            var2 = false;
         } finally {
            if(var2) {
               ;
            }
         }

         var0 = null;
      }

      return var0;
   }

   private static void b() {
      // $FF: Couldn't be decompiled
   }
}
