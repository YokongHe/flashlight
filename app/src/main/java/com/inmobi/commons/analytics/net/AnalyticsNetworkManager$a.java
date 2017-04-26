package com.inmobi.commons.analytics.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.internal.Log;

class AnalyticsNetworkManager$a extends Thread {
   // $FF: synthetic field
   final AnalyticsNetworkManager a;

   AnalyticsNetworkManager$a(AnalyticsNetworkManager var1) {
      this.a = var1;
   }

   public void run() {
      Looper.prepare();
      AnalyticsNetworkManager.a(new Handler(new Callback() {
         public boolean handleMessage(Message var1) {
            Log.debug("[InMobi]-[Analytics]-4.5.2", "NetworkManager->handleMessag: msg:" + var1);
            if(var1.what == 1001) {
               if(AnalyticsInitializer.getConfigParams().getAutomaticCapture().isAutoSessionCaptureEnabled() || AnalyticsEventsWrapper.isEventsUser()) {
                  AnalyticsNetworkManager.a(AnalyticsNetworkManager$a.this.a);
                  return true;
               }

               AnalyticsUtils.setStartHandle(false);
            }

            return true;
         }
      }));
      Looper.loop();
   }
}
