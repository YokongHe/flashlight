package com.amazon.device.ads;

public enum AdProperties$AdType {
   IMAGE_BANNER("Image Banner"),
   INTERSTITIAL("Interstitial", "i"),
   MRAID_1("MRAID 1.0"),
   MRAID_2("MRAID 2.0");

   private final String adTypeMetricTag;
   private final String type;

   private AdProperties$AdType(String var3) {
      this(var3, (String)null);
   }

   private AdProperties$AdType(String var3, String var4) {
      this.type = var3;
      this.adTypeMetricTag = var4;
   }

   final String getAdTypeMetricTag() {
      return this.adTypeMetricTag;
   }

   public final String toString() {
      return this.type;
   }
}
