package com.inmobi.monetization.internal;

public enum AdErrorCode {
   ADREQUEST_CANCELLED("Stop loading invoked on the ad"),
   AD_CLICK_IN_PROGRESS("Ad click is in progress, cannot load new ad"),
   AD_DOWNLOAD_IN_PROGRESS("Ad download is in progress, cannot load new ad"),
   AD_RENDERING_TIMEOUT("Failed to render ad"),
   DO_MONETIZE("Please load a mediation network"),
   DO_NOTHING("No Ads"),
   INTERNAL_ERROR("An error occurred while fetching the ad"),
   INVALID_APP_ID("Invalid App Id"),
   INVALID_REQUEST("Invalid ad request"),
   NETWORK_ERROR("Ad network failed to retrieve ad"),
   NO_FILL("The ad request was successful, but no ad was returned");

   private String a;

   private AdErrorCode(String var3) {
      this.a = var3;
   }

   public final void setMessage(String var1) {
      this.a = var1;
   }

   public final String toString() {
      return this.a;
   }
}
