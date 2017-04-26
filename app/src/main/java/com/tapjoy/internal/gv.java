package com.tapjoy.internal;

import android.os.SystemClock;

public abstract class gv implements Runnable {
   private final long a = 300L;

   protected abstract boolean a();

   public void run() {
      long var1 = SystemClock.elapsedRealtime();
      long var3 = this.a;

      while(!this.a() && var1 + var3 - SystemClock.elapsedRealtime() > 0L) {
         try {
            Thread.sleep(0L);
         } catch (InterruptedException var6) {
            break;
         }
      }

   }
}
