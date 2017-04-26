package com.tapjoy.internal;

import android.os.SystemClock;
import com.tapjoy.internal.fi;

public final class z {
   private static String a = "pool.ntp.org";
   private static long b = 20000L;
   private static volatile boolean c = false;
   private static volatile String d;
   private static volatile long e;
   private static volatile long f;
   private static volatile long g;
   private static volatile long h;
   private static volatile long i;

   static {
      long var0 = SystemClock.elapsedRealtime();
      a(false, "System", System.currentTimeMillis(), var0, Long.MAX_VALUE);
   }

   public static long a(long var0) {
      return h + var0;
   }

   private static void a(boolean var0, String var1, long var2, long var4, long var6) {
      synchronized(com.tapjoy.internal.z.class){}

      try {
         c = var0;
         d = var1;
         e = var2;
         f = var4;
         g = var6;
         h = e - f;
         i = SystemClock.elapsedRealtime() + h - System.currentTimeMillis();
      } finally {
         ;
      }

   }

   public static boolean a() {
      String var2 = a;
      long var0 = b;
      fi var3 = new fi();
      if(var3.a(var2, (int)var0)) {
         a(true, "SNTP", var3.a, var3.b, var3.c / 2L);
         return true;
      } else {
         return false;
      }
   }

   public static long b() {
      return SystemClock.elapsedRealtime() + h;
   }

   public static boolean c() {
      return c;
   }
}
