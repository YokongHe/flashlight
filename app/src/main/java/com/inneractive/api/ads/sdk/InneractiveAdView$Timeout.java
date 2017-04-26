package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAdefines;
import com.inneractive.api.ads.sdk.IAnetworkFetcher;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;

public class InneractiveAdView$Timeout {
   public static int getConnectionTimeout() {
      return IAnetworkFetcher.a;
   }

   public static int getLoadingTimeout() {
      return com.inneractive.api.ads.sdk.m.c;
   }

   public static int getSocketTimeout() {
      return IAnetworkFetcher.b;
   }

   public static void setConnectionTimeout(int var0) {
      if(var0 < IAdefines.g) {
         IAnetworkFetcher.a = IAdefines.g;
         InneractiveAdView$Log.b("Cannot set " + Integer.toString(var0) + " milliseconds as a connection timeout. Minimum timeout value is " + Integer.toString(IAdefines.g) + " milliseconds. Using the minimum timeout(" + Integer.toString(IAdefines.g) + " milliseconds).");
      } else if(var0 > IAdefines.l) {
         IAnetworkFetcher.a = IAdefines.l;
         InneractiveAdView$Log.b("Cannot set " + var0 + " milliseconds as a connection timeout. Maximum timeout value is " + IAdefines.l + " milliseconds. Using the maximum timeout (" + IAdefines.l + " milliseconds).");
      } else {
         IAnetworkFetcher.a = var0;
         InneractiveAdView$Log.b("Connection timeout configured to be " + var0 + " milliseconds.");
      }
   }

   public static void setLoadingTimeout(int var0) {
      if(var0 < IAdefines.h) {
         com.inneractive.api.ads.sdk.m.c = IAdefines.h;
         InneractiveAdView$Log.b("Cannot set " + var0 + " milliseconds as a loading timeout. Minimum timeout value is " + IAdefines.h + " milliseconds. Using the minimum timeout(" + IAdefines.h + " milliseconds).");
      } else if(var0 > IAdefines.j) {
         com.inneractive.api.ads.sdk.m.c = IAdefines.j;
         InneractiveAdView$Log.b("Cannot set " + var0 + " milliseconds as a loading timeout. Maximum timeout value is " + IAdefines.j + " milliseconds. Using the maximum timeout (" + IAdefines.j + " milliseconds).");
      } else {
         com.inneractive.api.ads.sdk.m.c = var0;
         InneractiveAdView$Log.b("Loading timeout configured to be " + var0 + " milliseconds.");
      }
   }

   public static void setSocketTimeout(int var0) {
      if(var0 < IAdefines.f) {
         IAnetworkFetcher.b = IAdefines.f;
         InneractiveAdView$Log.b("Cannot set " + var0 + " milliseconds as a socket timeout. Minimum timeout value is " + IAdefines.f + " milliseconds. Using the minimum timeout(" + IAdefines.f + " milliseconds).");
      } else if(var0 > IAdefines.k) {
         IAnetworkFetcher.b = IAdefines.k;
         InneractiveAdView$Log.b("Cannot set " + Integer.toString(var0) + " milliseconds as a socket timeout. Maximum timeout value is " + IAdefines.k + " milliseconds. Using the maximum timeout (" + IAdefines.k + " milliseconds).");
      } else {
         IAnetworkFetcher.b = var0;
         InneractiveAdView$Log.b("Socket timeout configured to be " + var0 + " milliseconds.");
      }
   }
}
