package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class bG {
   public static void a(Context var0, WebSettings var1) {
      var1.setAppCachePath(var0.getCacheDir().getAbsolutePath());
      var1.setAppCacheMaxSize(0L);
      var1.setAppCacheEnabled(true);
      var1.setDatabasePath(var0.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
      var1.setDatabaseEnabled(true);
      var1.setDomStorageEnabled(true);
      var1.setDisplayZoomControls(false);
      var1.setBuiltInZoomControls(true);
      var1.setSupportZoom(true);
   }
}
