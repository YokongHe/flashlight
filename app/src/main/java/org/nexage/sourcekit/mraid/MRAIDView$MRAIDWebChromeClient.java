package org.nexage.sourcekit.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import org.nexage.sourcekit.mraid.MRAIDView;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;

class MRAIDView$MRAIDWebChromeClient extends WebChromeClient {
   // $FF: synthetic field
   final MRAIDView this$0;

   private MRAIDView$MRAIDWebChromeClient(MRAIDView var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   MRAIDView$MRAIDWebChromeClient(MRAIDView var1, MRAIDView$MRAIDWebChromeClient var2) {
      this(var1);
   }

   private boolean handlePopups(JsResult var1) {
      if(MRAIDView.areJavascriptPromptsAndAlertsAllowed()) {
         return false;
      } else {
         var1.cancel();
         return true;
      }
   }

   public boolean onConsoleMessage(ConsoleMessage var1) {
      if(var1 != null && var1.message() != null) {
         if(!var1.message().contains("Uncaught ReferenceError")) {
            StringBuilder var3 = new StringBuilder(String.valueOf(var1.message()));
            String var2;
            if(var1.sourceId() == null) {
               var2 = "";
            } else {
               var2 = " at " + var1.sourceId();
            }

            MRAIDLog.i("JS console", var3.append(var2).append(":").append(var1.lineNumber()).toString());
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      MRAIDLog.d("JS alert", var3);
      return this.handlePopups(var4);
   }

   public boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
      MRAIDLog.d("JS confirm", var3);
      return this.handlePopups(var4);
   }

   public boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
      MRAIDLog.d("JS prompt", var3);
      return this.handlePopups(var5);
   }
}
