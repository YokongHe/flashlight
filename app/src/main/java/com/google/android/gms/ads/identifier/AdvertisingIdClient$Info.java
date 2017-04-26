package com.google.android.gms.ads.identifier;

public final class AdvertisingIdClient$Info {
   private final String kw;
   private final boolean kx;

   public AdvertisingIdClient$Info(String var1, boolean var2) {
      this.kw = var1;
      this.kx = var2;
   }

   public final String getId() {
      return this.kw;
   }

   public final boolean isLimitAdTrackingEnabled() {
      return this.kx;
   }
}
