package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.ActivityRecognitionSampler$ActivitySample;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionSampler {
   static HandlerThread a;
   static Looper b;
   static Handler c;
   static List d = new ArrayList();

   static {
      HandlerThread var0 = new HandlerThread("ActivityDetectionSampler");
      a = var0;
      var0.start();
      b = a.getLooper();
      c = new Handler(b) {
         public final void handleMessage(Message var1) {
            switch(var1.what) {
            case 1:
               int var2 = ActivityRecognitionManager.getDetectedActivity();
               if(var2 != -1) {
                  if((long)ActivityRecognitionSampler.d.size() > AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionMaxSize()) {
                     return;
                  }

                  ActivityRecognitionSampler.d.add(new ActivityRecognitionSampler$ActivitySample(var2, System.currentTimeMillis()));
               }

               ActivityRecognitionSampler.b();
               return;
            default:
            }
         }
      };
   }

   private static void b() {
      if(AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled()) {
         Message var0 = c.obtainMessage(1);
         c.sendMessageDelayed(var0, AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionInterval());
      }

   }

   public static List getCollectedList() {
      return AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled()?d:Collections.emptyList();
   }

   public static void start() {
      if(!c.hasMessages(1)) {
         c.sendEmptyMessage(1);
      }
   }

   public static void stop() {
      c.removeMessages(1);
      d.clear();
   }
}
