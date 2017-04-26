package com.mopub.mraid;

enum MraidOrientation {
   LANDSCAPE(0),
   NONE(-1),
   PORTRAIT(1);

   private final int mActivityInfoOrientation;

   private MraidOrientation(int var3) {
      this.mActivityInfoOrientation = var3;
   }

   final int getActivityInfoOrientation() {
      return this.mActivityInfoOrientation;
   }
}
