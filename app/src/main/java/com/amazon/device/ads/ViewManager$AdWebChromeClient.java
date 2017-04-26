package com.amazon.device.ads;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.ViewManager;

class ViewManager$AdWebChromeClient extends WebChromeClient {
   // $FF: synthetic field
   final ViewManager this$0;

   private ViewManager$AdWebChromeClient(ViewManager var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   ViewManager$AdWebChromeClient(ViewManager var1, Object var2) {
      this(var1);
   }

   public boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      Log.d(ViewManager.access$100(), var3);
      return false;
   }
}
