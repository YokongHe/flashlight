package com.inmobi.monetization.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.analytics.net.AnalyticsCommon$HttpRequestCallback;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.RequestResponseManager;

public class ConnBroadcastReciever extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      if(var2.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && InternalSDKUtil.checkNetworkAvailibility(var1)) {
         Log.internal("[InMobi]-[Monetization]", "Received CONNECTIVITY BROADCAST");

         try {
            RequestResponseManager var4 = new RequestResponseManager();
            var4.init();
            var4.processClick(var1.getApplicationContext(), (AnalyticsCommon$HttpRequestCallback)null);
         } catch (Exception var3) {
            Log.internal("[InMobi]-[Monetization]", "Connectivity receiver exception", var3);
            return;
         }
      }

   }
}
