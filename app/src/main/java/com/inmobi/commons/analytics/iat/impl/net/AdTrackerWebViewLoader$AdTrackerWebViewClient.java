package com.inmobi.commons.analytics.iat.impl.net;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerWebViewLoader;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerWebViewLoader$a;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public final class AdTrackerWebViewLoader$AdTrackerWebViewClient extends WebViewClient {
   // $FF: synthetic field
   final AdTrackerWebViewLoader a;

   protected AdTrackerWebViewLoader$AdTrackerWebViewClient(AdTrackerWebViewLoader var1) {
      this.a = var1;
   }

   public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
      super.onReceivedError(var1, var2, var3, var4);
      Handler var5 = AdTrackerNetworkInterface.c();
      if(var5 != null && var5.hasMessages(9)) {
         var5.removeMessages(9);
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Webview Received Error");
         Message var6 = Message.obtain();
         var6.what = 10;
         var6.arg2 = var2;
         var6.obj = AdTrackerWebViewLoader.c(this.a);
         var5.sendMessage(var6);
      }

   }

   @TargetApi(8)
   public final void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
      super.onReceivedSslError(var1, var2, var3);
      Handler var4 = AdTrackerNetworkInterface.c();
      if(var4.hasMessages(9)) {
         var4.removeMessages(9);
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Webview Received SSL Error");
         Message var5 = Message.obtain();
         var5.what = 10;
         var5.arg2 = var3.getPrimaryError();
         var5.obj = AdTrackerWebViewLoader.c(this.a);
         var4.sendMessage(var5);
      }

   }

   public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      Handler var4 = AdTrackerNetworkInterface.c();
      if(var4.hasMessages(9)) {
         var4.removeMessages(9);
         AdTrackerWebViewLoader.b(this.a, System.currentTimeMillis() - AdTrackerWebViewLoader.b(this.a));
         if(var2.contains("iat")) {
            String var5 = var2.substring(7);
            AdTrackerWebViewLoader$a var8 = AdTrackerWebViewLoader.a(this.a, var5);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "errcode", Integer.toString(AdTrackerWebViewLoader$a.a(var8)));
            Message var6 = Message.obtain();
            var6.what = 10;
            var6.arg2 = AdTrackerWebViewLoader$a.a(var8);
            var6.obj = AdTrackerWebViewLoader.c(this.a);
            Bundle var7 = new Bundle();
            var7.putString("appId", AdTrackerWebViewLoader.d(this.a));
            var6.setData(var7);
            if(5000 == AdTrackerWebViewLoader$a.a(var8)) {
               int var3 = AdTrackerWebViewLoader.b(this.a, AdTrackerWebViewLoader$a.b(var8));
               if(6000 == var3) {
                  var6.what = 8;
                  var6.arg2 = (int)AdTrackerWebViewLoader.e(this.a);
               } else {
                  var6.arg2 = var3;
               }
            }

            var4.sendMessage(var6);
         }
      }

      var1.loadUrl(var2);
      return true;
   }
}
