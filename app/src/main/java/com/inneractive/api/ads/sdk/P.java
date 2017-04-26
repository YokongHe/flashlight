package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidWebView;
import java.util.Map;

final class P extends com.inneractive.api.ads.sdk.A {
   P(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   final void a() {
      boolean var1 = this.c("shouldUseCustomClose");
      this.b.getMraidWebViewController().useCustomClose(var1);
   }
}
