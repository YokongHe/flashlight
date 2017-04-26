package com.tapjoy.internal;

import android.os.SystemClock;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.ft;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.gh;
import com.tapjoy.internal.gk$c$a;
import com.tapjoy.internal.gk$i;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

final class gg {
   final fu a;
   final AtomicBoolean b = new AtomicBoolean();
   ScheduledFuture c;
   private final Runnable d = new Runnable() {
      public final void run() {
         // $FF: Couldn't be decompiled
      }
   };
   private final Runnable e = new Runnable() {
      public final void run() {
         fu var1 = gg.this.a;
      }
   };

   gg(fu var1) {
      this.a = var1;
   }

   final void a() {
      if(this.b.get()) {
         if(!Boolean.FALSE.booleanValue()) {
            this.d.run();
            return;
         }

         if(this.c == null || this.c.cancel(false)) {
            this.c = gh.a.schedule(this.d, 3000L, TimeUnit.MILLISECONDS);
         }
      }

   }
}
