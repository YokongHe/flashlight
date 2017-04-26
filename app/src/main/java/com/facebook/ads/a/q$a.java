package com.facebook.ads.a;

import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;
import java.util.UUID;

class q$a extends WebViewClient {
   // $FF: synthetic field
   final com.facebook.ads.a.q a;

   private q$a(com.facebook.ads.a.q var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   q$a(com.facebook.ads.a.q var1, Object var2) {
      this(var1);
   }

   public void onLoadResource(WebView var1, String var2) {
      com.facebook.ads.a.q.e(this.a).f();
   }

   public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
      if(com.facebook.ads.a.p.a()) {
         var2.proceed();
      } else {
         var2.cancel();
      }
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      if(com.facebook.ads.a.q.f(this.a) != null) {
         com.facebook.ads.a.q.f(this.a).onAdClicked(com.facebook.ads.a.q.d(this.a));
      }

      Uri var4 = Uri.parse(var2);
      com.facebook.ads.a.a.a var5 = com.facebook.ads.a.a.b.a(this.a.getContext(), var4);
      Map var6 = ((com.facebook.ads.a.y)com.facebook.ads.a.q.e(this.a).a()).j();
      var6.put("adInterstitialUniqueId", UUID.randomUUID().toString());
      if(var5 != null) {
         try {
            com.facebook.ads.a.q.a(this.a, var5.a());
            com.facebook.ads.a.q.a(this.a, System.currentTimeMillis());
            var5.a(var6);
         } catch (Exception var3) {
            Log.e(com.facebook.ads.a.q.d(), "Error executing action", var3);
         }
      }

      return true;
   }
}
