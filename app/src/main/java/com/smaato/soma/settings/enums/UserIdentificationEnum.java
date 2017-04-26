package com.smaato.soma.settings.enums;

import com.smaato.soma.settings.enums.BaseUserSettings;

public enum UserIdentificationEnum implements BaseUserSettings {
   CARRIER,
   CARRIER_CODE,
   COPPA,
   EMAIL,
   FACEBOOK_ATTRIBUTION_ID,
   GOOGLE_ADVERTISING_ID,
   IMEI;

   private String value;

   static {
      FACEBOOK_ATTRIBUTION_ID.value = "FACEBOOK_ATTRIBUTION_ID";
      GOOGLE_ADVERTISING_ID.value = "GOOGLE_ADVERTISING_ID";
      CARRIER.value = "CARRIER";
      CARRIER_CODE.value = "CARRIER_CODE";
      IMEI.value = "IMEI";
      EMAIL.value = "EMAIL";
      COPPA.value = "COPPA";
   }

   public final String getValue() {
      return this.value;
   }
}
