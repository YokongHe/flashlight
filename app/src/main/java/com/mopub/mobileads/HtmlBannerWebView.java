package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView$HtmlBannerWebViewListener;
import com.mopub.mobileads.HtmlWebViewClient;

public class HtmlBannerWebView extends BaseHtmlWebView {
   public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";

   public HtmlBannerWebView(Context var1, AdReport var2) {
      super(var1, var2);
   }

   public void init(CustomEventBanner$CustomEventBannerListener var1, boolean var2, String var3, String var4) {
      super.init(var2);
      this.setWebViewClient(new HtmlWebViewClient(new HtmlBannerWebView$HtmlBannerWebViewListener(var1), this, var4, var3));
   }
}
