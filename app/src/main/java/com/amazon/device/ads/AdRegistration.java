package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.Version;

public final class AdRegistration {
   private static final String LOG_TAG = "AdRegistration";

   public static final void enableLogging(boolean var0) {
      Log.enableLoggingWithSetterNotification("AdRegistration", var0);
   }

   public static final void enableTesting(boolean var0) {
      Settings.getInstance().putTransientBoolean("testingEnabled", var0);
      Log.logSetterNotification("AdRegistration", "Test mode", Boolean.valueOf(var0));
   }

   public static final String getVersion() {
      return Version.getSDKVersion();
   }

   public static final void registerApp(Context var0) {
      if(!PermissionChecker.hasInternetPermission(var0)) {
         Log.e("AdRegistration", "Network task cannot commence because the INTERNET permission is missing from the app\'s manifest.");
      } else {
         InternalAdRegistration.getInstance().contextReceived(var0);
         InternalAdRegistration.getInstance().register();
      }
   }

   public static final void setAppKey(String var0) {
      InternalAdRegistration.getInstance().getRegistrationInfo().putAppKey(var0);
   }
}
