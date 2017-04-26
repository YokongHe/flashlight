package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import java.util.Map;

final class C extends com.inneractive.api.ads.sdk.A {
   C(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   final void a() {
      this.b.getMraidWebViewController().createCalendarEvent(this.a);
   }

   protected final boolean a(IAmraidWebView$MraidPlacementType var1) {
      return true;
   }
}
