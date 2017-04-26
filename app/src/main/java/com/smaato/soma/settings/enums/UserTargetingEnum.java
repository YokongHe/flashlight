package com.smaato.soma.settings.enums;

import com.smaato.soma.settings.enums.BaseUserSettings;

public enum UserTargetingEnum implements BaseUserSettings {
   AGE,
   COUNTRY,
   COUNTRY_CODE,
   GENDER,
   KWS,
   LOCATION,
   ZIP;

   private String value;

   static {
      LOCATION.value = "LOCATION";
      COUNTRY.value = "COUNTRY";
      COUNTRY_CODE.value = "COUNTRY_CODE";
      ZIP.value = "ZIP";
      AGE.value = "AGE";
      GENDER.value = "GENDER";
      KWS.value = "GENDER";
   }

   public final String getValue() {
      return this.value;
   }
}
