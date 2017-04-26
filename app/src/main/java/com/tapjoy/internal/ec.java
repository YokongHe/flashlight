package com.tapjoy.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;

class ec {
   private static final String a = ec.class.getSimpleName();

   static String a(Context var0) {
      ApplicationInfo var2 = var0.getApplicationInfo();
      if(var2 != null) {
         String var3 = var2.sourceDir;
         String var1 = a;
         (new StringBuilder("sourceDir: ")).append(var3);
         return a(var3);
      } else {
         return null;
      }
   }

   private static String a(String param0) {
      // $FF: Couldn't be decompiled
   }
}
