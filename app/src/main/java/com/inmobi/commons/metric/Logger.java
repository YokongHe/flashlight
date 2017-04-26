package com.inmobi.commons.metric;

import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger$MetricsCallback;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.metric.Queuer;
import com.inmobi.commons.metric.Storage;
import com.inmobi.commons.metric.Storage$PreProcessor;

public class Logger {
   private MetricConfigParams a = new MetricConfigParams();
   private Integer b = Integer.valueOf(2147483646);
   private Storage c = null;
   private Queuer d = new Queuer();
   private Logger$MetricsCallback e = null;

   public Logger(int var1, String var2) {
      this.c = new Storage(var1, var2, this.d, this.a);
   }

   public Logger(int var1, String var2, Storage$PreProcessor var3) {
      this.c = new Storage(var1, var2, this.d, this.a, var3);
   }

   protected void finalize() {
      this.c.saveToLatest();
      super.finalize();
   }

   public void logEvent(EventLog var1) {
      this.c.readNumberOfEventsAndTimeStampFromPersistent();
      if(this.e != null) {
         this.e.dataCollected(var1);
      }

      this.d.log(var1);
      if(this.d.a() >= (long)this.a.getDumpThreshhold()) {
         this.c.saveLocalCache();
      }

      if(this.c.getEvents() >= (long)this.a.getMaxInQueue() || this.c.getTimestamp() + (long)this.a.getNextRetryInterval() <= System.currentTimeMillis() / 1000L) {
         (new Thread(new Runnable() {
            public void run() {
               Logger.this.c.sendFile();
            }
         })).start();
      }

   }

   public void setCallback(Logger$MetricsCallback var1) {
      this.e = var1;
      this.c.setCallback(var1);
   }

   public void setMetricConfigParams(MetricConfigParams var1) {
      if(var1 != null) {
         this.a = var1;
         this.c.a = var1;
      }

   }

   public boolean startNewSample() {
      Integer var1 = this.b;
      synchronized(var1) {
         Integer var2 = this.b;
         this.b = Integer.valueOf(this.b.intValue() + 1);
         if(this.b.intValue() >= this.a.getSamplingFactor()) {
            this.b = Integer.valueOf(0);
            return true;
         }
      }

      return false;
   }
}
