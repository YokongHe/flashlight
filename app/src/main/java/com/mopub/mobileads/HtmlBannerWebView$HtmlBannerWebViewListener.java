package com.mopub.mobileads;

import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener;
import com.mopub.mobileads.HtmlWebViewListener;
import com.mopub.mobileads.MoPubErrorCode;

class HtmlBannerWebView$HtmlBannerWebViewListener implements HtmlWebViewListener {
   private final CustomEventBanner$CustomEventBannerListener mCustomEventBannerListener;

   public HtmlBannerWebView$HtmlBannerWebViewListener(CustomEventBanner$CustomEventBannerListener var1) {
      this.mCustomEventBannerListener = var1;
   }

   public void onClicked() {
      this.mCustomEventBannerListener.onBannerClicked();
   }

   public void onCollapsed() {
      this.mCustomEventBannerListener.onBannerCollapsed();
   }

   public void onFailed(MoPubErrorCode var1) {
      this.mCustomEventBannerListener.onBannerFailed(var1);
   }

   public void onLoaded(BaseHtmlWebView var1) {
      this.mCustomEventBannerListener.onBannerLoaded(var1);
   }
}
