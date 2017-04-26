package com.amazon.device.ads;

import android.webkit.WebView;
import com.amazon.device.ads.AdContainer;
import com.amazon.device.ads.AdWebViewClient$AdWebViewClientListener;

class AdContainer$AdContainerAdWebViewClientListener implements AdWebViewClient$AdWebViewClientListener {
   // $FF: synthetic field
   final AdContainer this$0;

   private AdContainer$AdContainerAdWebViewClientListener(AdContainer var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   AdContainer$AdContainerAdWebViewClientListener(AdContainer var1, Object var2) {
      this(var1);
   }

   public void onLoadResource(WebView var1, String var2) {
   }

   public void onPageFinished(WebView var1, String var2) {
      this.this$0.onPageFinished(var1, var2);
   }

   public void onPageStarted(WebView var1, String var2) {
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
   }
}
