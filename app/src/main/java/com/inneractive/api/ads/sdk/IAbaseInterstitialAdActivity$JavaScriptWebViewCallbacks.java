package com.inneractive.api.ads.sdk;

enum IAbaseInterstitialAdActivity$JavaScriptWebViewCallbacks {
   a("javascript:showInterstitial();"),
   b("javascript:if(typeof iaVideoPlayer !== \'undefined\' && typeof iaVideoPlayer.setPlay === \'function\'){iaVideoPlayer.setPlay()}");

   private String c;

   private IAbaseInterstitialAdActivity$JavaScriptWebViewCallbacks(String var3) {
      this.c = var3;
   }

   protected final String a() {
      return this.c;
   }
}
