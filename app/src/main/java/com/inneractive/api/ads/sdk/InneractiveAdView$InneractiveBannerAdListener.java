package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;

public interface InneractiveAdView$InneractiveBannerAdListener {
   void inneractiveAdWillOpenExternalApp(InneractiveAdView var1);

   void inneractiveBannerClicked(InneractiveAdView var1);

   void inneractiveBannerCollapsed(InneractiveAdView var1);

   void inneractiveBannerExpanded(InneractiveAdView var1);

   void inneractiveBannerFailed(InneractiveAdView var1, InneractiveAdView$InneractiveErrorCode var2);

   void inneractiveBannerLoaded(InneractiveAdView var1);

   void inneractiveBannerResized(InneractiveAdView var1);

   void inneractiveDefaultBannerLoaded(InneractiveAdView var1);

   void inneractiveInternalBrowserDismissed(InneractiveAdView var1);
}
