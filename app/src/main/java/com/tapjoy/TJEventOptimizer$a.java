package com.tapjoy;

import android.annotation.TargetApi;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TapjoyLog;

final class TJEventOptimizer$a extends WebChromeClient {
   // $FF: synthetic field
   final TJEventOptimizer a;

   private TJEventOptimizer$a(TJEventOptimizer var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   TJEventOptimizer$a(TJEventOptimizer var1, byte var2) {
      this(var1);
   }

   @TargetApi(8)
   public final boolean onConsoleMessage(ConsoleMessage var1) {
      TapjoyLog.d(TJEventOptimizer.b(), "JS CONSOLE: " + var1.message() + " -- From line " + var1.lineNumber() + " of " + var1.sourceId());
      return true;
   }
}
