package com.adsdk.sdk.mraid;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebViews {
   private static final String LOGTAG = "MoPub - WebViewsUtil";

   public static void onPause(WebView var0) {
      try {
         WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(var0, new Object[0]);
      } catch (Exception var1) {
         ;
      }
   }

   public static void onResume(WebView var0) {
      try {
         WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(var0, new Object[0]);
      } catch (Exception var1) {
         ;
      }
   }

   public static void setDisableJSChromeClient(WebView var0) {
      var0.setWebChromeClient(new WebChromeClient() {
         public boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
            Log.d("MoPub - WebViewsUtil", var3);
            return true;
         }

         public boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
            Log.d("MoPub - WebViewsUtil", var3);
            return true;
         }

         public boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
            Log.d("MoPub - WebViewsUtil", var3);
            return true;
         }

         public boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
            Log.d("MoPub - WebViewsUtil", var3);
            return true;
         }
      });
   }
}
