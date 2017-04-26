package com.amazon.device.ads;

class GooglePlayServices$AdvertisingInfo {
   private String advertisingIdentifier;
   private boolean gpsAvailable = true;
   private boolean limitAdTrackingEnabled;

   static GooglePlayServices$AdvertisingInfo createNotAvailable() {
      return (new GooglePlayServices$AdvertisingInfo()).setGPSAvailable(false);
   }

   private GooglePlayServices$AdvertisingInfo setGPSAvailable(boolean var1) {
      this.gpsAvailable = var1;
      return this;
   }

   String getAdvertisingIdentifier() {
      return this.advertisingIdentifier;
   }

   boolean hasAdvertisingIdentifier() {
      return this.getAdvertisingIdentifier() != null;
   }

   boolean isGPSAvailable() {
      return this.gpsAvailable;
   }

   boolean isLimitAdTrackingEnabled() {
      return this.limitAdTrackingEnabled;
   }

   GooglePlayServices$AdvertisingInfo setAdvertisingIdentifier(String var1) {
      this.advertisingIdentifier = var1;
      return this;
   }

   GooglePlayServices$AdvertisingInfo setLimitAdTrackingEnabled(boolean var1) {
      this.limitAdTrackingEnabled = var1;
      return this;
   }
}
