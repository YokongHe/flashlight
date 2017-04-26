package com.adsdk.sdk.mraid;

enum BaseInterstitialActivity$JavaScriptWebViewCallbacks {
   WEB_VIEW_DID_APPEAR("javascript:webviewDidAppear();"),
   WEB_VIEW_DID_CLOSE("javascript:webviewDidClose();");

   private String mUrl;

   private BaseInterstitialActivity$JavaScriptWebViewCallbacks(String var3) {
      this.mUrl = var3;
   }

   protected final String getUrl() {
      return this.mUrl;
   }
}
