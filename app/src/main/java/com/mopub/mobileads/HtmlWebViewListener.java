package com.mopub.mobileads;

import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.MoPubErrorCode;

public interface HtmlWebViewListener {
   void onClicked();

   void onCollapsed();

   void onFailed(MoPubErrorCode var1);

   void onLoaded(BaseHtmlWebView var1);
}
