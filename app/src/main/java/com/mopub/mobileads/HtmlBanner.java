package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.factories.HtmlBannerWebViewFactory;
import java.util.Map;

public class HtmlBanner extends CustomEventBanner {
   private HtmlBannerWebView mHtmlBannerWebView;

   private boolean extrasAreValid(Map var1) {
      return var1.containsKey("Html-Response-Body");
   }

   protected void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, Map var3, Map var4) {
      if(this.extrasAreValid(var4)) {
         String var5 = (String)var4.get("Html-Response-Body");
         String var6 = (String)var4.get("Redirect-Url");
         String var7 = (String)var4.get("Clickthrough-Url");
         Boolean var10 = Boolean.valueOf((String)var4.get("Scrollable"));

         AdReport var9;
         try {
            var9 = (AdReport)var3.get("mopub-intent-ad-report");
         } catch (ClassCastException var8) {
            MoPubLog.e("LocalExtras contained an incorrect type.");
            var2.onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
            return;
         }

         this.mHtmlBannerWebView = HtmlBannerWebViewFactory.create(var1, var9, var2, var10.booleanValue(), var6, var7);
         AdViewController.setShouldHonorServerDimensions(this.mHtmlBannerWebView);
         this.mHtmlBannerWebView.loadHtmlResponse(var5);
      } else {
         var2.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
      }
   }

   protected void onInvalidate() {
      if(this.mHtmlBannerWebView != null) {
         this.mHtmlBannerWebView.destroy();
      }

   }
}
