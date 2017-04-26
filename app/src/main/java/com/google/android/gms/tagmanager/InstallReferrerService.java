package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
   CampaignTrackingService a;
   Context b;

   public InstallReferrerService() {
      super("InstallReferrerService");
   }

   protected final void onHandleIntent(Intent var1) {
      String var3 = var1.getStringExtra("referrer");
      Context var2;
      if(this.b != null) {
         var2 = this.b;
      } else {
         var2 = this.getApplicationContext();
      }

      com.google.android.gms.tagmanager.m.a(var2, var3);
      if(this.a == null) {
         this.a = new CampaignTrackingService();
      }

      CampaignTrackingService var4 = this.a;
      CampaignTrackingService.a(var2, var1);
   }
}
