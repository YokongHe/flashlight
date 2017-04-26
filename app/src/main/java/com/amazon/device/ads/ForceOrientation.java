package com.amazon.device.ads;

import java.util.Locale;

enum ForceOrientation {
   LANDSCAPE,
   NONE,
   PORTRAIT;

   public final String toString() {
      return this.name().toLowerCase(Locale.US);
   }
}
