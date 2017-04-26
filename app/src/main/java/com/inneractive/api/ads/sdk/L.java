package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import java.util.Map;

final class L extends com.inneractive.api.ads.sdk.A {
   L(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   final void a() {
      int var2 = this.a("w");
      int var3 = this.a("h");
      int var4 = this.a("offsetX");
      int var5 = this.a("offsetY");
      boolean var6 = this.c("allowOffscreen");
      String var7 = this.b("customClosePosition");
      int var1 = var2;
      if(var2 <= 0) {
         var1 = this.b.getMraidWebViewController().mScreenWidth;
      }

      var2 = var3;
      if(var3 <= 0) {
         var2 = this.b.getMraidWebViewController().mScreenHeight;
      }

      this.b.getMraidWebViewController().resize(var1, var2, var4, var5, var6, var7);
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
