package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.mopub.common.AdReport;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.HtmlInterstitialWebView$HtmlInterstitialWebViewListener;
import com.mopub.mobileads.HtmlInterstitialWebView$MoPubUriJavascriptFireFinishLoadListener;
import com.mopub.mobileads.HtmlWebViewClient;

public class HtmlInterstitialWebView extends BaseHtmlWebView {
   protected static final String MOPUB_JS_INTERFACE_NAME = "mopubUriInterface";
   private Handler mHandler = new Handler();

   public HtmlInterstitialWebView(Context var1, AdReport var2) {
      super(var1, var2);
   }

   private void postHandlerRunnable(Runnable var1) {
      this.mHandler.post(var1);
   }

   void addMoPubUriJavascriptInterface(final HtmlInterstitialWebView$MoPubUriJavascriptFireFinishLoadListener var1) {
      this.addJavascriptInterface(new Object() {
         @JavascriptInterface
         public final boolean fireFinishLoad() {
            HtmlInterstitialWebView.this.postHandlerRunnable(new Runnable() {
               public void run() {
                  var1.onInterstitialLoaded();
               }
            });
            return true;
         }
      }, "mopubUriInterface");
   }

   @TargetApi(11)
   public void destroy() {
      if(VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
         this.removeJavascriptInterface("mopubUriInterface");
      }

      super.destroy();
   }

   public void init(final CustomEventInterstitial$CustomEventInterstitialListener var1, boolean var2, String var3, String var4) {
      super.init(var2);
      this.setWebViewClient(new HtmlWebViewClient(new HtmlInterstitialWebView$HtmlInterstitialWebViewListener(var1), this, var4, var3));
      this.addMoPubUriJavascriptInterface(new HtmlInterstitialWebView$MoPubUriJavascriptFireFinishLoadListener() {
         public void onInterstitialLoaded() {
            if(!HtmlInterstitialWebView.this.mIsDestroyed) {
               var1.onInterstitialLoaded();
            }

         }
      });
   }
}
