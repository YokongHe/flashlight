package com.mopub.mobileads;

import android.view.View;
import com.mopub.mobileads.MoPubErrorCode;

public interface CustomEventBanner$CustomEventBannerListener {
   void onBannerClicked();

   void onBannerCollapsed();

   void onBannerExpanded();

   void onBannerFailed(MoPubErrorCode var1);

   void onBannerLoaded(View var1);

   void onLeaveApplication();
}
