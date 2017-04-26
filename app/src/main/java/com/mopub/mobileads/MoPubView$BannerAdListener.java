package com.mopub.mobileads;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

public interface MoPubView$BannerAdListener {
   void onBannerClicked(MoPubView var1);

   void onBannerCollapsed(MoPubView var1);

   void onBannerExpanded(MoPubView var1);

   void onBannerFailed(MoPubView var1, MoPubErrorCode var2);

   void onBannerLoaded(MoPubView var1);
}
