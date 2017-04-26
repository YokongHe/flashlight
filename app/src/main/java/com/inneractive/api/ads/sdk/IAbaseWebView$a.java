package com.inneractive.api.ads.sdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.inneractive.api.ads.sdk.IAbaseWebView;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;

final class IAbaseWebView$a extends WebChromeClient {
   IAbaseWebView$a(IAbaseWebView var1) {
   }

   public final boolean onConsoleMessage(ConsoleMessage var1) {
      InneractiveAdView$Log.d("onConsoleMessage: " + var1.message());
      return true;
   }

   public final boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      InneractiveAdView$Log.d("onJsAlert: " + var3);
      if(var3 != null) {
         int var5 = var3.indexOf("playerState");
         if(var5 >= 0) {
            IAbaseWebView.setPlayerState(var3.substring(var5 + 11, var3.length()));
            InneractiveAdView$Log.a("Player State:" + IAbaseWebView.playerState);
            var4.confirm();
         } else {
            IAbaseWebView.setPlayerState((String)null);
         }
      }

      return true;
   }

   public final boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
      InneractiveAdView$Log.d("onJsBeforeUnload: " + var3);
      return true;
   }

   public final boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
      InneractiveAdView$Log.d("onJsConfirm: " + var3);
      return true;
   }

   public final boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
      InneractiveAdView$Log.d("onJsPrompt: " + var3);
      return true;
   }
}
