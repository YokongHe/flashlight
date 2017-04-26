package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveInterstitialView;

public interface InneractiveInterstitialView$InneractiveInterstitialAdListener {
   void inneractiveAdWillOpenExternalApp(InneractiveAdView var1);

   void inneractiveDefaultInterstitialLoaded(InneractiveInterstitialView var1);

   void inneractiveInternalBrowserDismissed(InneractiveAdView var1);

   void inneractiveInterstitialClicked(InneractiveInterstitialView var1);

   void inneractiveInterstitialDismissed(InneractiveInterstitialView var1);

   void inneractiveInterstitialFailed(InneractiveInterstitialView var1, InneractiveAdView$InneractiveErrorCode var2);

   void inneractiveInterstitialLoaded(InneractiveInterstitialView var1);

   void inneractiveInterstitialShown(InneractiveInterstitialView var1);
}
