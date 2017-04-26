package com.inmobi.monetization.internal.imai;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;

public class WebviewLoader$MyWebViewClient extends WebViewClient {
   public void onPageFinished(WebView param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void onReceivedError(WebView param1, int param2, String param3, String param4) {
      // $FF: Couldn't be decompiled
   }

   public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
      Log.internal("[InMobi]-[Monetization]", "SSL Error.Webview will proceed " + var3);
      super.onReceivedSslError(var1, var2, var3);
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      Log.internal("[InMobi]-[Monetization]", "Should override " + var2);
      var1.loadUrl(var2);
      return true;
   }
}
