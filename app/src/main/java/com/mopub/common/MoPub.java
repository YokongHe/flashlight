package com.mopub.common;

import com.mopub.common.MoPub$LocationAwareness;

public class MoPub {
   private static final int DEFAULT_LOCATION_PRECISION = 6;
   public static final String SDK_VERSION = "3.4.0";
   private static volatile MoPub$LocationAwareness sLocationLocationAwareness;
   private static volatile int sLocationPrecision;

   static {
      sLocationLocationAwareness = MoPub$LocationAwareness.NORMAL;
      sLocationPrecision = 6;
   }

   public static MoPub$LocationAwareness getLocationAwareness() {
      return sLocationLocationAwareness;
   }

   public static int getLocationPrecision() {
      return sLocationPrecision;
   }

   public static void setLocationAwareness(MoPub$LocationAwareness var0) {
      sLocationLocationAwareness = var0;
   }

   public static void setLocationPrecision(int var0) {
      sLocationPrecision = Math.min(Math.max(0, var0), 6);
   }
}
