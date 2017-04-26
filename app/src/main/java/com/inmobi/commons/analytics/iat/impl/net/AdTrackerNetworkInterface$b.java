package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.Log;

final class AdTrackerNetworkInterface$b extends Handler {
   public final void handleMessage(Message var1) {
      switch(var1.what) {
      case 1:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "All goals reported ... De-initializing AdTrackerNetworkInterface!");
         if(AdTrackerNetworkInterface.d() != null) {
            AdTrackerNetworkInterface.e().set(false);
            AdTrackerNetworkInterface.d().quit();
            HandlerThread var2 = AdTrackerNetworkInterface.d();
            AdTrackerNetworkInterface.a((HandlerThread)null);
            var2.interrupt();
            AdTrackerNetworkInterface.a((Handler)null);
            return;
         }
         break;
      default:
         super.handleMessage(var1);
      }

   }
}
