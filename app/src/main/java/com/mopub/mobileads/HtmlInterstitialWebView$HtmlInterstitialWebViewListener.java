package com.mopub.mobileads;

import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.HtmlWebViewListener;
import com.mopub.mobileads.MoPubErrorCode;

class HtmlInterstitialWebView$HtmlInterstitialWebViewListener implements HtmlWebViewListener {
   private final CustomEventInterstitial$CustomEventInterstitialListener mCustomEventInterstitialListener;

   public HtmlInterstitialWebView$HtmlInterstitialWebViewListener(CustomEventInterstitial$CustomEventInterstitialListener var1) {
      this.mCustomEventInterstitialListener = var1;
   }

   public void onClicked() {
      this.mCustomEventInterstitialListener.onInterstitialClicked();
   }

   public void onCollapsed() {
   }

   public void onFailed(MoPubErrorCode var1) {
      this.mCustomEventInterstitialListener.onInterstitialFailed(var1);
   }

   public void onLoaded(BaseHtmlWebView var1) {
      this.mCustomEventInterstitialListener.onInterstitialLoaded();
   }
}
