package com.mopub.common;

public enum CloseableLayout$ClosePosition {
   BOTTOM_CENTER(81),
   BOTTOM_LEFT(83),
   BOTTOM_RIGHT(85),
   CENTER(17),
   TOP_CENTER(49),
   TOP_LEFT(51),
   TOP_RIGHT(53);

   private final int mGravity;

   private CloseableLayout$ClosePosition(int var3) {
      this.mGravity = var3;
   }

   final int getGravity() {
      return this.mGravity;
   }
}
