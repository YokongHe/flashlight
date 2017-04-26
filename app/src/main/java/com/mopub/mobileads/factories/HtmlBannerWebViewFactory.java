package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView;

public class HtmlBannerWebViewFactory {
   protected static HtmlBannerWebViewFactory instance = new HtmlBannerWebViewFactory();

   public static HtmlBannerWebView create(Context var0, AdReport var1, CustomEventBanner$CustomEventBannerListener var2, boolean var3, String var4, String var5) {
      return instance.internalCreate(var0, var1, var2, var3, var4, var5);
   }

   @Deprecated
   public static void setInstance(HtmlBannerWebViewFactory var0) {
      instance = var0;
   }

   public HtmlBannerWebView internalCreate(Context var1, AdReport var2, CustomEventBanner$CustomEventBannerListener var3, boolean var4, String var5, String var6) {
      HtmlBannerWebView var7 = new HtmlBannerWebView(var1, var2);
      var7.init(var3, var4, var5, var6);
      return var7;
   }
}
