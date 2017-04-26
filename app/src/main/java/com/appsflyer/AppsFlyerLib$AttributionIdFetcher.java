package com.appsflyer;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

class AppsFlyerLib$AttributionIdFetcher implements Runnable {
   private static final String AF_ATTRIBUTION_ID_URI = "https://api.appsflyer.com/install_data/v2/";
   private static AtomicInteger currentRequestsCounter = new AtomicInteger(0);
   private String appsFlyerDevKey;
   private WeakReference ctxReference = null;

   public AppsFlyerLib$AttributionIdFetcher(Context var1, String var2) {
      this.ctxReference = new WeakReference(var1);
      this.appsFlyerDevKey = var2;
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
