package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class CampaignTrackingReceiver extends BroadcastReceiver {
   public final void onReceive(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("referrer");
      if("com.android.vending.INSTALL_REFERRER".equals(var2.getAction()) && var3 != null) {
         var2 = new Intent(var1, CampaignTrackingService.class);
         var2.putExtra("referrer", var3);
         var1.startService(var2);
      }
   }
}
