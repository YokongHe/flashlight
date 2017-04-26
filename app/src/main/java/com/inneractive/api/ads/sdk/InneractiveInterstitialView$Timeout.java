package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAdefines;
import com.inneractive.api.ads.sdk.InneractiveAdView$Timeout;
import com.inneractive.api.ads.sdk.InneractiveInterstitialView$Log;

public class InneractiveInterstitialView$Timeout extends InneractiveAdView$Timeout {
   public static int getLoadingTimeout() {
      return com.inneractive.api.ads.sdk.z.a;
   }

   public static void setLoadingTimeout(int var0) {
      if(var0 < IAdefines.i) {
         com.inneractive.api.ads.sdk.m.c = IAdefines.i;
         InneractiveInterstitialView$Log.b("Cannot set " + var0 + " milliseconds as a loading timeout. Minimum timeout value is " + IAdefines.i + " milliseconds. Using the minimum timeout(" + IAdefines.i + " milliseconds).");
      } else if(var0 > IAdefines.j) {
         com.inneractive.api.ads.sdk.m.c = IAdefines.j;
         InneractiveInterstitialView$Log.b("Cannot set " + var0 + " milliseconds as a loading timeout. Maximum timeout value is " + IAdefines.j + " milliseconds. Using the maximum timeout (" + IAdefines.j + " milliseconds).");
      } else {
         com.inneractive.api.ads.sdk.z.a = var0;
         InneractiveInterstitialView$Log.b("Loading timeout configured to be " + var0 + " milliseconds.");
      }
   }
}
