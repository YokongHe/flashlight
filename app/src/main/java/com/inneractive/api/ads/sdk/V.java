package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAbaseWebView$IAviewState;

final class V extends com.inneractive.api.ads.sdk.R {
   private final IAbaseWebView$IAviewState a;

   private V(IAbaseWebView$IAviewState var1) {
      this.a = var1;
   }

   static com.inneractive.api.ads.sdk.V a(IAbaseWebView$IAviewState var0) {
      return new com.inneractive.api.ads.sdk.V(var0);
   }

   final String a() {
      return "state: \'" + this.a.toString().toLowerCase() + "\'";
   }
}
