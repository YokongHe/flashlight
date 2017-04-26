package com.mopub.mobileads.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection$MethodBuilder;

public class WebViews {
   @TargetApi(11)
   public static void onPause(WebView var0) {
      if(VERSION.SDK_INT >= 11) {
         var0.onPause();
      } else {
         try {
            (new Reflection$MethodBuilder(var0, "onPause")).setAccessible().execute();
         } catch (Exception var1) {
            ;
         }
      }
   }

   @TargetApi(11)
   public static void onResume(WebView var0) {
      if(VERSION.SDK_INT >= 11) {
         var0.onResume();
      } else {
         try {
            (new Reflection$MethodBuilder(var0, "onResume")).setAccessible().execute();
         } catch (Exception var1) {
            ;
         }
      }
   }

   public static void setDisableJSChromeClient(WebView var0) {
      var0.setWebChromeClient(new WebChromeClient() {
         public boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
            MoPubLog.d(var3);
            var4.confirm();
            return true;
         }

         public boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
            MoPubLog.d(var3);
            var4.confirm();
            return true;
         }

         public boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
            MoPubLog.d(var3);
            var4.confirm();
            return true;
         }

         public boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
            MoPubLog.d(var3);
            var5.confirm();
            return true;
         }
      });
   }
}
