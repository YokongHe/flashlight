package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.GooglePlayServices;
import com.amazon.device.ads.GooglePlayServices$AdvertisingInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;

class AdvertisingIdentifier {
   private static final String GPS_ADVERTISING_IDENTIFIER_SETTING = "gpsAdId";
   private static final String LOG_TAG = AdvertisingIdentifier.class.getSimpleName();
   private static final String TRANSITION_MIGRATE = "migrate";
   private static final String TRANSITION_RESET = "reset";
   private static final String TRANSITION_REVERT = "revert";
   private static final String TRANSITION_SETTING = "adIdTransistion";
   private GooglePlayServices$AdvertisingInfo gpsAdvertisingInfo;
   private boolean shouldSetCurrentAdvertisingIdentifier = true;

   private void determineTransition() {
      String var1 = null;
      if(this.isTransitionMigrated()) {
         var1 = "migrate";
      } else if(this.isTransitionReset()) {
         var1 = "reset";
      } else if(this.isTransitionReverted()) {
         var1 = "revert";
      }

      if(var1 != null) {
         setTransition(var1);
      } else {
         Log.d(LOG_TAG, "No transition detected.");
      }
   }

   static String getAndClearTransition() {
      Settings var0 = Settings.getInstance();
      String var1 = var0.getString("adIdTransistion", (String)null);
      var0.remove("adIdTransistion");
      return var1;
   }

   private static String getCurrentGPSAID() {
      return Settings.getInstance().getString("gpsAdId", "");
   }

   private boolean hasCurrentGPSAID() {
      return !StringUtils.isNullOrEmpty(getCurrentGPSAID());
   }

   private boolean isTransitionMigrated() {
      return InternalAdRegistration.getInstance().getRegistrationInfo().hasAdId() && RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier() && !this.hasCurrentGPSAID() && this.getGPSAdvertisingInfo().hasAdvertisingIdentifier();
   }

   private boolean isTransitionReset() {
      return this.hasCurrentGPSAID() && this.getGPSAdvertisingInfo().hasAdvertisingIdentifier() && !getCurrentGPSAID().equals(this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
   }

   private boolean isTransitionReverted() {
      return this.hasCurrentGPSAID() && !this.getGPSAdvertisingInfo().hasAdvertisingIdentifier();
   }

   private static void setCurrentGPSAID(String var0) {
      Settings.getInstance().putString("gpsAdId", var0);
   }

   private static void setTransition(String var0) {
      Log.d(LOG_TAG, "Transition: %s", new Object[]{var0});
      Settings.getInstance().putString("adIdTransistion", var0);
   }

   protected void fetchGooglePlayServicesAdvertisingIdentifierInfo() {
      this.gpsAdvertisingInfo = (new GooglePlayServices()).getAdvertisingIdentifierInfo();
   }

   AdvertisingIdentifier$Info getAdvertisingIdentifierInfo() {
      if(ThreadUtils.isOnMainThread()) {
         Log.e(LOG_TAG, "You must obtain the advertising indentifier information on a background thread.");
         return AdvertisingIdentifier$Info.access$000(new AdvertisingIdentifier$Info(), false);
      } else {
         this.fetchGooglePlayServicesAdvertisingIdentifierInfo();
         if(this.shouldSetCurrentAdvertisingIdentifier) {
            this.determineTransition();
         }

         AdvertisingIdentifier$Info var1 = new AdvertisingIdentifier$Info();
         if(this.getGPSAdvertisingInfo().hasAdvertisingIdentifier()) {
            AdvertisingIdentifier$Info.access$100(var1, this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
            AdvertisingIdentifier$Info.access$200(var1, this.getGPSAdvertisingInfo().isLimitAdTrackingEnabled());
            if(this.shouldSetCurrentAdvertisingIdentifier) {
               setCurrentGPSAID(this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
            }
         }

         RegistrationInfo var2 = InternalAdRegistration.getInstance().getRegistrationInfo();
         if(RegistrationInfo.isAdIdCurrent(var1)) {
            AdvertisingIdentifier$Info.access$300(var1, var2.getAdId());
            return var1;
         } else {
            var2.requestNewSISDeviceIdentifier();
            return var1;
         }
      }
   }

   protected GooglePlayServices$AdvertisingInfo getGPSAdvertisingInfo() {
      return this.gpsAdvertisingInfo;
   }

   AdvertisingIdentifier setShouldSetCurrentAdvertisingIdentifier(boolean var1) {
      this.shouldSetCurrentAdvertisingIdentifier = var1;
      return this;
   }
}
