package com.mopub.mobileads;

import com.mopub.mobileads.MoPubErrorCode;

public interface CustomEventInterstitial$CustomEventInterstitialListener {
   void onInterstitialClicked();

   void onInterstitialDismissed();

   void onInterstitialFailed(MoPubErrorCode var1);

   void onInterstitialLoaded();

   void onInterstitialShown();

   void onLeaveApplication();
}
