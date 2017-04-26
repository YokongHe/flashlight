package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import java.util.Map;

final class D extends com.inneractive.api.ads.sdk.A {
   D(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   final void a() {
      int var2 = this.a("w");
      int var3 = this.a("h");
      String var6 = this.b("url");
      boolean var4 = this.c("shouldUseCustomClose");
      boolean var5 = this.c("lockOrientation");
      int var1 = var2;
      if(var2 <= 0) {
         var1 = this.b.getMraidWebViewController().mScreenWidth;
      }

      var2 = var3;
      if(var3 <= 0) {
         var2 = this.b.getMraidWebViewController().mScreenHeight;
      }

      this.b.getMraidWebViewController().expand(var6, var1, var2, var4, var5);
   }

   protected final boolean a(IAmraidWebView$MraidPlacementType var1) {
      boolean var2 = false;
      switch(null.a[var1.ordinal()]) {
      default:
         var2 = super.a(var1);
      case 1:
      case 2:
         return var2;
      }
   }
}
