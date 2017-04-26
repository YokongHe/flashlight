package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;

final class T extends com.inneractive.api.ads.sdk.R {
   private final IAmraidWebView$MraidPlacementType a;

   T(IAmraidWebView$MraidPlacementType var1) {
      this.a = var1;
   }

   final String a() {
      return "placementType: \'" + this.a.toString().toLowerCase() + "\'";
   }
}
