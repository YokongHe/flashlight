package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import java.io.FileOutputStream;
import java.io.IOException;

public class CampaignTrackingService extends IntentService {
   public CampaignTrackingService() {
      super("CampaignIntentService");
   }

   public static void a(Context var0, Intent var1) {
      String var4 = var1.getStringExtra("referrer");

      try {
         FileOutputStream var3 = var0.openFileOutput("gaInstallData", 0);
         var3.write(var4.getBytes());
         var3.close();
         com.google.android.gms.analytics.d.b("Stored campaign information.");
      } catch (IOException var2) {
         com.google.android.gms.analytics.d.a("Error storing install campaign.");
      }
   }

   public void onHandleIntent(Intent var1) {
      a(this, var1);
   }
}
