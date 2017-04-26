package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class bC {
   private static final ThreadFactory a = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);

      public final Thread newThread(Runnable var1) {
         return new Thread(var1, "AdWorker #" + this.a.getAndIncrement());
      }
   };
   private static final ThreadPoolExecutor b;

   static {
      b = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), a);
   }

   public static void a(final Runnable var0) {
      try {
         b.execute(new Runnable() {
            public final void run() {
               Process.setThreadPriority(10);
               var0.run();
            }
         });
      } catch (RejectedExecutionException var1) {
         com.google.android.gms.internal.bJ.b("Too many background threads already running. Aborting task.  Current pool size: " + b.getPoolSize(), var1);
      }
   }
}
