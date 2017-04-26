package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidActionFactory$MraidJavascriptCommand;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import java.util.Map;

final class O extends com.inneractive.api.ads.sdk.A {
   public O(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   final void a() {
      String var1 = this.b("uri");
      if(var1 != null && !"".equals(var1)) {
         this.b.getMraidWebViewController().displayDownloadImageAlert(var1);
      } else {
         this.b.fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.j, "Image can\'t be stored with null or empty URL");
         InneractiveAdView$Log.a("Mraid Store Picture -Invalid URI ");
      }
   }

   protected final boolean a(IAmraidWebView$MraidPlacementType var1) {
      return true;
   }
}
