package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.HtmlInterstitialWebView;

public class HtmlInterstitialWebViewFactory {
   protected static HtmlInterstitialWebViewFactory instance = new HtmlInterstitialWebViewFactory();

   public static HtmlInterstitialWebView create(Context var0, AdReport var1, CustomEventInterstitial$CustomEventInterstitialListener var2, boolean var3, String var4, String var5) {
      return instance.internalCreate(var0, var1, var2, var3, var4, var5);
   }

   @Deprecated
   public static void setInstance(HtmlInterstitialWebViewFactory var0) {
      instance = var0;
   }

   public HtmlInterstitialWebView internalCreate(Context var1, AdReport var2, CustomEventInterstitial$CustomEventInterstitialListener var3, boolean var4, String var5, String var6) {
      HtmlInterstitialWebView var7 = new HtmlInterstitialWebView(var1, var2);
      var7.init(var3, var4, var5, var6);
      return var7;
   }
}
