package com.flurry.android;

public enum FlurryAdSize {
   BANNER_BOTTOM(2),
   BANNER_TOP(1),
   FULLSCREEN(3);

   private int a;

   private FlurryAdSize(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
