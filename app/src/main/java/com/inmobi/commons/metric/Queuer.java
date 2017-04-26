package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;

public class Queuer {
   private StringBuffer a = new StringBuffer();
   private long b = 0L;

   long a() {
      return this.b;
   }

   public String get() {
      Log.internal("[InMobi]-4.5.2", "Reading from queue");
      StringBuffer var1 = this.a;
      synchronized(var1) {
         String var2 = this.a.toString();
         return var2;
      }
   }

   public void log(EventLog var1) {
      StringBuffer var2 = this.a;
      synchronized(var2) {
         this.a.append(var1.toString()).append(',');
         ++this.b;
      }
   }

   public void reset() {
      Log.internal("[InMobi]-4.5.2", "Resetting queue");
      StringBuffer var1 = this.a;
      synchronized(var1) {
         this.a = new StringBuffer();
         this.b = 0L;
      }
   }
}
