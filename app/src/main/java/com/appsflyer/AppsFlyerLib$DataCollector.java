package com.appsflyer;

import android.content.Context;
import com.appsflyer.AppsFlyerLib;

class AppsFlyerLib$DataCollector implements Runnable {
   private String appsFlyerKey;
   private Context context;
   private String eventName;
   private String eventValue;
   private String referrer;

   private AppsFlyerLib$DataCollector(Context var1, String var2, String var3, String var4, String var5) {
      this.context = var1;
      this.appsFlyerKey = var2;
      this.eventName = var3;
      this.eventValue = var4;
      this.referrer = var5;
   }

   // $FF: synthetic method
   AppsFlyerLib$DataCollector(Context var1, String var2, String var3, String var4, String var5, Object var6) {
      this(var1, var2, var3, var4, var5);
   }

   public void run() {
      AppsFlyerLib.access$200(this.context, this.appsFlyerKey, this.eventName, this.eventValue, this.referrer);
   }
}
