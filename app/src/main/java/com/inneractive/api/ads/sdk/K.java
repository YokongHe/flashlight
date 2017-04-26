package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidActionFactory$MraidJavascriptCommand;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import java.util.Map;

final class K extends com.inneractive.api.ads.sdk.A {
   public K(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   final void a() {
      String var1 = this.b("uri");
      if(var1 != null && !"".equals(var1)) {
         this.b.getMraidWebViewController().displayVideo(var1);
      } else {
         this.b.fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.i, "Video can\'t be played with null or empty URL");
      }
   }

   protected final boolean a(IAmraidWebView$MraidPlacementType var1) {
      switch(null.a[var1.ordinal()]) {
      case 1:
         return true;
      case 2:
         return false;
      default:
         return super.a(var1);
      }
   }
}
