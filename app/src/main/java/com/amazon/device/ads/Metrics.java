package com.amazon.device.ads;

import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdMetrics;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestException;

class Metrics {
   private static final String LOG_TAG = Metrics.class.getSimpleName();
   private static Metrics instance = new Metrics();
   private MetricsCollector metricsCollector = new MetricsCollector();

   public static Metrics getInstance() {
      return instance;
   }

   private void sendMetrics(final WebRequest var1) {
      ThreadUtils.executeRunnable(new Runnable() {
         public void run() {
            var1.enableLog(true);

            try {
               var1.makeCall();
            } catch (WebRequest$WebRequestException var2) {
               switch(null.$SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[var2.getStatus().ordinal()]) {
               case 1:
                  Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[]{var2.getMessage()});
                  return;
               case 2:
                  Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[]{var2.getMessage()});
                  return;
               case 3:
                  Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[]{var2.getMessage()});
               case 4:
                  Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[]{var2.getMessage()});
                  return;
               default:
               }
            }
         }
      });
   }

   public MetricsCollector getMetricsCollector() {
      return this.metricsCollector;
   }

   public void submitAndResetMetrics(AdController var1) {
      Log.d(LOG_TAG, "METRIC Submit and Reset");
      AdMetrics var2 = new AdMetrics(var1);
      if(var2.canSubmit()) {
         MetricsCollector var3 = this.metricsCollector;
         this.metricsCollector = new MetricsCollector();
         var2.addGlobalMetrics(var3);
         this.sendMetrics(var2.getAaxWebRequestAndResetAdMetrics());
      } else {
         var1.resetMetricsCollector();
      }
   }
}
