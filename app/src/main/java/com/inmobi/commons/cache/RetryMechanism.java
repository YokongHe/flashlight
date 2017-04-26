package com.inmobi.commons.cache;

import com.inmobi.commons.cache.RetryMechanism$RetryRunnable;
import com.inmobi.commons.internal.Log;
import java.util.Timer;
import java.util.TimerTask;

public class RetryMechanism {
   private Timer a;
   private int b = 0;
   private int c = 0;
   private int d = 1000;

   public RetryMechanism(int var1, int var2, Timer var3) {
      this.c = var1;
      this.d = var2;
      this.a = var3;
   }

   // $FF: synthetic method
   static int a(RetryMechanism var0) {
      int var1 = var0.b;
      var0.b = var1 + 1;
      return var1;
   }

   private void a(final RetryMechanism$RetryRunnable var1, int var2) {
      this.a.schedule(new TimerTask() {
         public void run() {
            try {
               var1.run();
               var1.completed();
            } catch (Exception var2) {
               RetryMechanism.a(RetryMechanism.this);
               if(RetryMechanism.this.b > RetryMechanism.this.c) {
                  Log.internal("[InMobi]-4.5.2", "Exception occured while running retry mechanism and will the limit for retrying has been reached.");
                  var1.completed();
               } else {
                  Log.internal("[InMobi]-4.5.2", "Exception occured while running retry mechanism and will retry in " + RetryMechanism.this.b * RetryMechanism.this.d + " ms");
                  RetryMechanism.this.a(var1, RetryMechanism.this.b * RetryMechanism.this.d);
               }
            }
         }
      }, (long)var2);
   }

   public void rescheduleTimer(RetryMechanism$RetryRunnable var1) {
      this.b = 0;
      this.a(var1, 0);
   }
}
