package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;

public enum IMErrorCode {
   DO_MONETIZE("Please load a mediation network"),
   DO_NOTHING("No Ads"),
   INTERNAL_ERROR("An error occurred while fetching the ad"),
   INVALID_REQUEST("Invalid ad request"),
   NETWORK_ERROR("Ad network failed to retrieve ad"),
   NO_FILL("The ad request was successful, but no ad was returned");

   private String a;

   private IMErrorCode(String var3) {
      this.a = var3;
   }

   static IMErrorCode a(AdErrorCode var0) {
      IMErrorCode var1 = INTERNAL_ERROR;
      switch(null.a[var0.ordinal()]) {
      case 1:
      case 2:
      case 3:
      case 4:
         var1 = INVALID_REQUEST;
         break;
      case 5:
      case 6:
         var1 = INTERNAL_ERROR;
         break;
      case 7:
         var1 = NO_FILL;
         break;
      case 8:
         var1 = NETWORK_ERROR;
         break;
      case 9:
         var1 = DO_MONETIZE;
         break;
      case 10:
         var1 = DO_NOTHING;
         break;
      default:
         var1 = INTERNAL_ERROR;
      }

      var1.a = var0.toString();
      return var1;
   }

   public final void setMessage(String var1) {
      this.a = var1;
   }

   public final String toString() {
      return this.a;
   }
}
