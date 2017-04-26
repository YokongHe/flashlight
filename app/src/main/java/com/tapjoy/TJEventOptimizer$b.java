package com.tapjoy;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TapjoyLog;

final class TJEventOptimizer$b extends WebViewClient {
   // $FF: synthetic field
   final TJEventOptimizer a;

   private TJEventOptimizer$b(TJEventOptimizer var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   TJEventOptimizer$b(TJEventOptimizer var1, byte var2) {
      this(var1);
   }

   public final void onPageFinished(WebView var1, String var2) {
      TapjoyLog.d(TJEventOptimizer.b(), "boostrap html loaded successfully");
   }

   public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
      super.onReceivedError(var1, var2, var3, var4);
      TapjoyLog.e(TJEventOptimizer.b(), "error:" + var3);
   }
}
