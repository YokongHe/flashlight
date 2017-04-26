package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidView;

class MraidAbstractController {
   private final MraidView mMraidView;

   MraidAbstractController(MraidView var1) {
      this.mMraidView = var1;
   }

   public MraidView getMraidView() {
      return this.mMraidView;
   }
}
