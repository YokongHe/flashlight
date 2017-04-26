package com.mopub.mobileads;

enum BaseInterstitialActivity$JavaScriptWebViewCallbacks {
   WEB_VIEW_DID_APPEAR("webviewDidAppear();"),
   WEB_VIEW_DID_CLOSE("webviewDidClose();");

   private String mJavascript;

   private BaseInterstitialActivity$JavaScriptWebViewCallbacks(String var3) {
      this.mJavascript = var3;
   }

   protected final String getJavascript() {
      return this.mJavascript;
   }

   protected final String getUrl() {
      return "javascript:" + this.mJavascript;
   }
}
