package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.WebUtils;

class RegistrationInfo {
   private static final String ADID_ORIGIN_PREF_NAME = "amzn-ad-id-origin";
   private static final String ADID_PREF_NAME = "amzn-ad-id";
   private static final String NEW_SIS_DID_REQUESTED_SETTING = "newSISDIDRequested";
   private static final String NON_ADVERTISING_IDENTIFIER_ORIGIN = "non-advertising-identifier";
   private static final String THIRD_PARTY_APP_NAME = "app";
   private String appKey;
   private String appName = "app";

   public static boolean isAdIdCurrent(AdvertisingIdentifier$Info var0) {
      boolean var2 = isAdIdOriginatedFromNonAdvertisingIdentifier();
      boolean var1 = var2;
      if(var0.hasAdvertisingIdentifier()) {
         if(!var2) {
            String var3 = Settings.getInstance().getString("amzn-ad-id-origin", (String)null);
            return var0.getAdvertisingIdentifier().equals(var3);
         }

         var1 = false;
      }

      return var1;
   }

   public static boolean isAdIdOriginatedFromNonAdvertisingIdentifier() {
      String var0 = Settings.getInstance().getString("amzn-ad-id-origin", (String)null);
      return var0 == null || "non-advertising-identifier".equals(var0);
   }

   protected static void setOrigin(AdvertisingIdentifier$Info var0) {
      if(var0.hasAdvertisingIdentifier()) {
         Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", var0.getAdvertisingIdentifier());
      } else {
         Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", "non-advertising-identifier");
      }
   }

   public String getAdId() {
      return DebugProperties.getDebugPropertyAsString("debug.adid", Settings.getInstance().getString("amzn-ad-id", (String)null));
   }

   public String getAppKey() {
      return DebugProperties.getDebugPropertyAsString("debug.appid", this.appKey);
   }

   public String getAppName() {
      return this.appName;
   }

   public boolean hasAdId() {
      return this.getAdId() != null;
   }

   public boolean isRegisteredWithSIS() {
      return !StringUtils.isNullOrEmpty(this.getAdId());
   }

   public void putAdId(String var1, AdvertisingIdentifier$Info var2) {
      Settings var3 = Settings.getInstance();
      var3.putStringWithNoFlush("amzn-ad-id", var1);
      setOrigin(var2);
      var3.putBooleanWithNoFlush("newSISDIDRequested", false);
      var3.flush();
   }

   public void putAppKey(String var1) {
      if(var1 != null && var1.length() != 0) {
         this.appKey = WebUtils.getURLEncodedString(var1);
      } else {
         throw new IllegalArgumentException("Application Key must not be null or empty.");
      }
   }

   public void putAppName(String var1) {
      this.appName = WebUtils.getURLEncodedString(var1);
   }

   public void requestNewSISDeviceIdentifier() {
      Settings.getInstance().putBoolean("newSISDIDRequested", true);
   }

   public boolean shouldGetNewSISDeviceIdentifer() {
      return Settings.getInstance().getBoolean("newSISDIDRequested", false);
   }

   public boolean shouldGetNewSISRegistration() {
      return !this.isRegisteredWithSIS();
   }
}
