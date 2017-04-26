package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class gh {
   public static final ScheduledExecutorService a = Executors.newScheduledThreadPool(1);
   public static final CountDownLatch b = new CountDownLatch(1);
   public static final CountDownLatch c = new CountDownLatch(1);
   private static final Runnable d = new Runnable() {
      public final void run() {
         if(com.tapjoy.internal.z.c()) {
            gh.b.countDown();
         } else if(com.tapjoy.internal.z.a()) {
            gh.b.countDown();
         } else {
            gh.a.schedule(this, 300L, TimeUnit.SECONDS);
         }
      }
   };
   private static String e;
   private static boolean f;

   public static void a() {
      a.execute(d);
   }

   public static void a(String var0, boolean var1) {
      e = var0;
      f = var1;
      c.countDown();
   }

   public static String b() {
      return e;
   }

   public static boolean c() {
      return f;
   }
}
