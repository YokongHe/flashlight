package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.mobileads.BaseInterstitialActivity;
import com.mopub.mobileads.BaseInterstitialActivity$JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.EventForwardingBroadcastReceiver;
import com.mopub.mobileads.HtmlInterstitialWebView;
import com.mopub.mobileads.HtmlInterstitialWebView$MoPubUriJavascriptFireFinishLoadListener;
import com.mopub.mobileads.MoPubActivity$BroadcastingInterstitialListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;

public class MoPubActivity extends BaseInterstitialActivity {
   private HtmlInterstitialWebView mHtmlInterstitialWebView;

   // $FF: synthetic method
   static HtmlInterstitialWebView access$0(MoPubActivity var0) {
      return var0.mHtmlInterstitialWebView;
   }

   static Intent createIntent(Context var0, String var1, AdReport var2, boolean var3, String var4, String var5, long var6) {
      Intent var8 = new Intent(var0, MoPubActivity.class);
      var8.putExtra("Html-Response-Body", var1);
      var8.putExtra("Scrollable", var3);
      var8.putExtra("Clickthrough-Url", var5);
      var8.putExtra("Redirect-Url", var4);
      var8.putExtra("broadcastIdentifier", var6);
      var8.putExtra("mopub-intent-ad-report", var2);
      var8.addFlags(268435456);
      return var8;
   }

   static void preRenderHtml(Context var0, AdReport var1, final CustomEventInterstitial$CustomEventInterstitialListener var2, String var3) {
      HtmlInterstitialWebView var4 = HtmlInterstitialWebViewFactory.create(var0, var1, var2, false, (String)null, (String)null);
      var4.enablePlugins(false);
      var4.addMoPubUriJavascriptInterface(new HtmlInterstitialWebView$MoPubUriJavascriptFireFinishLoadListener() {
         public void onInterstitialLoaded() {
            var2.onInterstitialLoaded();
         }
      });
      var4.setWebViewClient(new WebViewClient() {
         public boolean shouldOverrideUrlLoading(WebView var1, String var2x) {
            if(var2x.equals("mopub://finishLoad")) {
               var2.onInterstitialLoaded();
            } else if(var2x.equals("mopub://failLoad")) {
               var2.onInterstitialFailed((MoPubErrorCode)null);
            }

            return true;
         }
      });
      var4.loadHtmlResponse(var3);
   }

   public static void start(Context var0, String var1, AdReport var2, boolean var3, String var4, String var5, long var6) {
      Intent var9 = createIntent(var0, var1, var2, var3, var4, var5, var6);

      try {
         var0.startActivity(var9);
      } catch (ActivityNotFoundException var8) {
         Log.d("MoPubActivity", "MoPubActivity not found - did you declare it in AndroidManifest.xml?");
      }
   }

   public View getAdView() {
      Intent var4 = this.getIntent();
      boolean var1 = var4.getBooleanExtra("Scrollable", false);
      String var2 = var4.getStringExtra("Redirect-Url");
      String var3 = var4.getStringExtra("Clickthrough-Url");
      String var5 = var4.getStringExtra("Html-Response-Body");
      this.mHtmlInterstitialWebView = HtmlInterstitialWebViewFactory.create(this.getApplicationContext(), this.mAdReport, new MoPubActivity$BroadcastingInterstitialListener(this), var1, var2, var3);
      this.mHtmlInterstitialWebView.loadHtmlResponse(var5);
      return this.mHtmlInterstitialWebView;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      EventForwardingBroadcastReceiver.broadcastAction(this, this.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.show");
   }

   protected void onDestroy() {
      this.mHtmlInterstitialWebView.loadUrl(BaseInterstitialActivity$JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
      this.mHtmlInterstitialWebView.destroy();
      EventForwardingBroadcastReceiver.broadcastAction(this, this.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.dismiss");
      super.onDestroy();
   }
}
