package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;

interface IAbaseVideoViewListener {
   void onAdWillOpenExternalApp();

   void onClicked();

   void onDismissed();

   void onFailure(com.inneractive.api.ads.sdk.q var1, InneractiveAdView$InneractiveErrorCode var2);

   void onInternalBrowserDismissed();

   void onReady(com.inneractive.api.ads.sdk.q var1);
}
