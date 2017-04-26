package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidProperty;

class MraidScreenSizeProperty extends MraidProperty {
   private final int mScreenHeight;
   private final int mScreenWidth;

   MraidScreenSizeProperty(int var1, int var2) {
      this.mScreenWidth = var1;
      this.mScreenHeight = var2;
   }

   public static MraidScreenSizeProperty createWithSize(int var0, int var1) {
      return new MraidScreenSizeProperty(var0, var1);
   }

   public String toJsonPair() {
      return "screenSize: { width: " + this.mScreenWidth + ", height: " + this.mScreenHeight + " }";
   }
}
