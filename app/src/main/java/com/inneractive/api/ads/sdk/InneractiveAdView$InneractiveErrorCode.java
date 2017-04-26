package com.inneractive.api.ads.sdk;

public enum InneractiveAdView$InneractiveErrorCode {
   CANCELLED("Ad Request Was Cancelled."),
   CONNECTION_ERROR("Network Connection Error."),
   CONNECTION_TIMEOUT("Connection Timed Out."),
   INVALID_INPUT("User Entered Invalid Input."),
   NO_FILL("No Ad Found."),
   SDK_INTERNAL_ERROR("SDK Internal Error."),
   SERVER_INTERNAL_ERROR("Server Internal Error."),
   SERVER_INVALID_RESPONSE("Failed Due To Invalid Server Response."),
   UNKNOWN_APP_ID("Unknown App ID."),
   UNSPECIFIED("Unspecified Error.");

   private final String a;

   private InneractiveAdView$InneractiveErrorCode(String var3) {
      this.a = var3;
   }

   public final String toString() {
      return this.a;
   }
}
