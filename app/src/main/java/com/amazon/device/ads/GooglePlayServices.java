package com.amazon.device.ads;

import com.amazon.device.ads.GooglePlayServices$AdvertisingInfo;
import com.amazon.device.ads.GooglePlayServicesAdapter;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.ReflectionUtils;
import com.amazon.device.ads.Settings;

class GooglePlayServices {
   private static final String GPS_AVAILABLE_SETTING = "gps-available";
   private static final String LOG_TAG = GooglePlayServices.class.getSimpleName();

   private boolean isGPSAvailable() {
      return Settings.getInstance().getBoolean("gps-available", true);
   }

   private boolean isGPSAvailableSet() {
      return Settings.getInstance().containsKey("gps-available");
   }

   private void setGooglePlayServicesAvailable(boolean var1) {
      Settings.getInstance().putTransientBoolean("gps-available", var1);
   }

   protected GooglePlayServicesAdapter createGooglePlayServicesAdapter() {
      return new GooglePlayServicesAdapter();
   }

   public GooglePlayServices$AdvertisingInfo getAdvertisingIdentifierInfo() {
      if(!this.isGPSAvailable()) {
         Log.v(LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.");
         return GooglePlayServices$AdvertisingInfo.createNotAvailable();
      } else if(!this.isGPSAvailableSet() && !ReflectionUtils.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
         Log.v(LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.");
         this.setGooglePlayServicesAvailable(false);
         return GooglePlayServices$AdvertisingInfo.createNotAvailable();
      } else {
         GooglePlayServices$AdvertisingInfo var1 = this.createGooglePlayServicesAdapter().getAdvertisingIdentifierInfo();
         this.setGooglePlayServicesAvailable(var1.isGPSAvailable());
         return var1;
      }
   }
}
