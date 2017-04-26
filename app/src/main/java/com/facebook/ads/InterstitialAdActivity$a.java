package com.facebook.ads;

import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.InterstitialAdActivity;
import java.util.Map;

class InterstitialAdActivity$a extends WebViewClient {
   // $FF: synthetic field
   final InterstitialAdActivity a;

   private InterstitialAdActivity$a(InterstitialAdActivity var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   InterstitialAdActivity$a(InterstitialAdActivity var1, Object var2) {
      this(var1);
   }

   public void onLoadResource(WebView var1, String var2) {
      InterstitialAdActivity.access$200(this.a).f();
   }

   public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
      if(com.facebook.ads.a.p.a()) {
         var2.proceed();
      } else {
         var2.cancel();
      }
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      Uri var4 = Uri.parse(var2);
      if("fbad".equals(var4.getScheme()) && "close".equals(var4.getAuthority())) {
         this.a.finish();
      } else {
         InterstitialAdActivity.access$100(this.a, "com.facebook.ads.interstitial.clicked");
         com.facebook.ads.a.a.a var5 = com.facebook.ads.a.a.b.a(this.a, var4);
         if(var5 != null) {
            try {
               InterstitialAdActivity.access$302(this.a, var5.a());
               InterstitialAdActivity.access$402(this.a, System.currentTimeMillis());
               var5.a((Map)null);
               return true;
            } catch (Exception var3) {
               Log.e(InterstitialAdActivity.access$500(), "Error executing action", var3);
               return true;
            }
         }
      }

      return true;
   }
}
