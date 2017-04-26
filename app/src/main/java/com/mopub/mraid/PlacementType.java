package com.mopub.mraid;

import java.util.Locale;

public enum PlacementType {
   INLINE,
   INTERSTITIAL;

   final String toJavascriptString() {
      return this.toString().toLowerCase(Locale.US);
   }
}
