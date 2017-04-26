package com.tapjoy.internal;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tapjoy.internal.eo;

class fg extends WebChromeClient {
   private final eo a;
   private final String b = fg.class.getName();

   public fg(eo var1) {
      this.a = var1;
   }

   public boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      String var5 = this.b;
      (new StringBuilder("onJsAlert() -")).append(var3);
      this.a.getString(var3);
      var4.confirm();
      return true;
   }
}
