package com.facebook.ads;

public class AdError {
   public static final AdError INTERNAL_ERROR = new AdError(2001, "Internal Error");
   public static final int INTERNAL_ERROR_CODE = 2001;
   public static final AdError LOAD_TOO_FREQUENTLY = new AdError(1002, "Ad was re-loaded too frequently");
   public static final int LOAD_TOO_FREQUENTLY_ERROR_CODE = 1002;
   @Deprecated
   public static final AdError MISSING_PROPERTIES = new AdError(2002, "Native ad failed to load due to missing properties");
   public static final AdError NETWORK_ERROR = new AdError(1000, "Network Error");
   public static final int NETWORK_ERROR_CODE = 1000;
   public static final AdError NO_FILL = new AdError(1001, "No Fill");
   public static final int NO_FILL_ERROR_CODE = 1001;
   public static final AdError SERVER_ERROR = new AdError(2000, "Server Error");
   public static final int SERVER_ERROR_CODE = 2000;
   private final int errorCode;
   private final String errorMessage;

   public AdError(int var1, String var2) {
      String var3 = var2;
      if(com.facebook.ads.a.ag.a(var2)) {
         var3 = "unknown error";
      }

      this.errorCode = var1;
      this.errorMessage = var3;
   }

   public int getErrorCode() {
      return this.errorCode;
   }

   public String getErrorMessage() {
      return this.errorMessage;
   }
}
