package com.google.android.gms.internal;

import android.content.Context;

public final class bA {
   private static final Object a = new Object();
   private static String b;

   public static String a() {
      Object var0 = a;
      synchronized(var0) {
         String var1 = b;
         return var1;
      }
   }

   public static String a(Context param0, String param1, String param2) {
      // $FF: Couldn't be decompiled
   }
}
