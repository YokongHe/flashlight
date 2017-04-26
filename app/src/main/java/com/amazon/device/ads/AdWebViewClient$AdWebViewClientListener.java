package com.amazon.device.ads;

import android.webkit.WebView;

interface AdWebViewClient$AdWebViewClientListener {
   void onLoadResource(WebView var1, String var2);

   void onPageFinished(WebView var1, String var2);

   void onPageStarted(WebView var1, String var2);

   void onReceivedError(WebView var1, int var2, String var3, String var4);
}
