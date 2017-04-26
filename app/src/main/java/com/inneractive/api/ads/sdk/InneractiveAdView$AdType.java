package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.InneractiveAdView$InternalAdType;

public enum InneractiveAdView$AdType {
   Banner,
   Rectangle;

   private final InneractiveAdView$InternalAdType a;

   static {
      Banner = new InneractiveAdView$AdType("Banner", 0, InneractiveAdView$InternalAdType.a);
      Rectangle = new InneractiveAdView$AdType("Rectangle", 1, InneractiveAdView$InternalAdType.b);
   }

   private InneractiveAdView$AdType(InneractiveAdView$InternalAdType var3) {
      this.a = var3;
   }

   // $FF: synthetic method
   static InneractiveAdView$InternalAdType a(InneractiveAdView$AdType var0) {
      return var0.a;
   }
}
