package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.JavascriptInterface;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerRequestResponseBuilder;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class AdTrackerWebViewLoader$JSInterface {
   @JavascriptInterface
   public String getParams() {
      String var3 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
      String var2 = AdTrackerRequestResponseBuilder.getWebViewRequestParam();
      String var1 = var2;
      if(var3 != null) {
         var1 = var2 + "&referrer=" + var3;
      }

      Log.debug("[InMobi]-[AdTracker]-4.5.2", "Request param for webview" + var1);
      return var1;
   }
}
