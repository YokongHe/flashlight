package com.mopub.nativeads;

import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.NativeResponse;

class NativeAdData {
   private final MoPubAdRenderer adRenderer;
   private final NativeResponse adResponse;
   private final String adUnitId;

   NativeAdData(String var1, MoPubAdRenderer var2, NativeResponse var3) {
      this.adUnitId = var1;
      this.adRenderer = var2;
      this.adResponse = var3;
   }

   NativeResponse getAd() {
      return this.adResponse;
   }

   MoPubAdRenderer getAdRenderer() {
      return this.adRenderer;
   }

   String getAdUnitId() {
      return this.adUnitId;
   }
}
