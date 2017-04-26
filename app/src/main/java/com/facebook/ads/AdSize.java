package com.facebook.ads;

public enum AdSize {
   BANNER_320_50(320, 50),
   BANNER_HEIGHT_50(-1, 50),
   BANNER_HEIGHT_90(-1, 90),
   INTERSTITIAL(0, 0),
   RECTANGLE_HEIGHT_250(-1, 250);

   private final int height;
   private final int width;

   private AdSize(int var3, int var4) {
      this.width = var3;
      this.height = var4;
   }

   public final int getHeight() {
      return this.height;
   }

   public final int getWidth() {
      return this.width;
   }
}
