package com.mopub.common;

import com.mopub.common.MoPub$LocationAwareness;

public enum LocationService$LocationAwareness {
   DISABLED,
   NORMAL,
   TRUNCATED;

   @Deprecated
   public static LocationService$LocationAwareness fromMoPubLocationAwareness(MoPub$LocationAwareness var0) {
      return var0 == MoPub$LocationAwareness.DISABLED?DISABLED:(var0 == MoPub$LocationAwareness.TRUNCATED?TRUNCATED:NORMAL);
   }

   @Deprecated
   public final MoPub$LocationAwareness getNewLocationAwareness() {
      return this == TRUNCATED?MoPub$LocationAwareness.TRUNCATED:(this == DISABLED?MoPub$LocationAwareness.DISABLED:MoPub$LocationAwareness.NORMAL);
   }
}
