package com.inmobi.commons.analytics.db;

import com.inmobi.commons.analytics.db.AnalyticsFunctions;
import com.inmobi.commons.internal.Log;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class AnalyticsEventsQueue extends Vector {
   private static AnalyticsEventsQueue a;
   private static final long serialVersionUID = -1291938489149189478L;
   private AtomicBoolean b = new AtomicBoolean(false);

   // $FF: synthetic method
   static void a(AnalyticsEventsQueue var0, AnalyticsFunctions var1) {
      var1.processFunction();
   }

   private void a(AnalyticsFunctions var1) {
      var1.processFunction();
   }

   public static AnalyticsEventsQueue getInstance() {
      synchronized(AnalyticsEventsQueue.class){}

      AnalyticsEventsQueue var0;
      try {
         if(a == null) {
            a = new AnalyticsEventsQueue();
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   public boolean isEmpty() {
      // $FF: Couldn't be decompiled
   }

   public void processFunctions() {
      synchronized(this){}

      try {
         if(!this.b.get()) {
            this.b.set(true);
            (new Thread() {
               public void run() {
                  while(true) {
                     try {
                        if(!AnalyticsEventsQueue.this.isEmpty()) {
                           AnalyticsEventsQueue.a(AnalyticsEventsQueue.this, (AnalyticsFunctions)AnalyticsEventsQueue.this.remove(0));
                           continue;
                        }
                     } catch (Exception var2) {
                        Log.internal("[InMobi]-[Analytics]-4.5.2", "Exception processing function", var2);
                     }

                     return;
                  }
               }
            }).start();
         }
      } finally {
         ;
      }

   }
}
