package com.tapjoy;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tapjoy.TJWebViewJSInterface;
import com.tapjoy.TapjoyLog;

@TargetApi(19)
final class TJWebViewJSInterface$a extends AsyncTask {
   WebView a;
   // $FF: synthetic field
   final TJWebViewJSInterface b;

   public TJWebViewJSInterface$a(TJWebViewJSInterface var1, WebView var2) {
      this.b = var1;
      this.a = var2;
   }

   // $FF: synthetic method
   protected final void onPostExecute(Object var1) {
      String var3 = (String)var1;
      if(this.a != null) {
         if(!var3.startsWith("javascript:") || VERSION.SDK_INT < 19) {
            this.a.loadUrl(var3);
            return;
         }

         try {
            var3 = var3.replaceFirst("javascript:", "");
            this.a.evaluateJavascript(var3, (ValueCallback)null);
         } catch (Exception var2) {
            TapjoyLog.e("TJWebViewJSInterface", "Exception in evaluateJavascript. Device not supported. " + var2.toString());
            return;
         }
      }

   }
}
