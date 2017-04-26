package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidWebView;
import java.util.Map;

final class M extends com.inneractive.api.ads.sdk.A {
   M(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   final void a() {
      boolean var1 = this.c("allowOrientationChange");
      String var2 = this.b("forceOrientation");
      this.b.getMraidWebViewController().setOrientationProperties(var1, var2);
   }
}
