package com.mopub.mobileads;

import com.mopub.mobileads.MoPubErrorCode;

interface CustomEventInterstitialAdapter$CustomEventInterstitialAdapterListener {
   void onCustomEventInterstitialClicked();

   void onCustomEventInterstitialDismissed();

   void onCustomEventInterstitialFailed(MoPubErrorCode var1);

   void onCustomEventInterstitialLoaded();

   void onCustomEventInterstitialShown();
}
