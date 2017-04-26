package com.mopub.mobileads;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

public interface MoPubInterstitial$InterstitialAdListener {
   void onInterstitialClicked(MoPubInterstitial var1);

   void onInterstitialDismissed(MoPubInterstitial var1);

   void onInterstitialFailed(MoPubInterstitial var1, MoPubErrorCode var2);

   void onInterstitialLoaded(MoPubInterstitial var1);

   void onInterstitialShown(MoPubInterstitial var1);
}
