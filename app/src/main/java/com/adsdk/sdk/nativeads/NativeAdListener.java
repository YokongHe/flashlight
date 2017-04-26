package com.adsdk.sdk.nativeads;

import com.adsdk.sdk.nativeads.NativeAd;

public interface NativeAdListener {
   void adClicked();

   void adFailedToLoad();

   void adLoaded(NativeAd var1);

   void impression();
}
