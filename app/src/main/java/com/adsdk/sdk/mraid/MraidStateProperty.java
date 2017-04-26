package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidProperty;
import com.adsdk.sdk.mraid.MraidView$ViewState;

class MraidStateProperty extends MraidProperty {
   private final MraidView$ViewState mViewState;

   MraidStateProperty(MraidView$ViewState var1) {
      this.mViewState = var1;
   }

   public static MraidStateProperty createWithViewState(MraidView$ViewState var0) {
      return new MraidStateProperty(var0);
   }

   public String toJsonPair() {
      return "state: \'" + this.mViewState.toString().toLowerCase() + "\'";
   }
}
