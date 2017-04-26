package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class bR extends com.google.android.gms.internal.bO {
   public bR(com.google.android.gms.internal.bL var1, boolean var2) {
      super(var1, var2);
   }

   private static WebResourceResponse a(Context var0, String var1, String var2) {
      HttpURLConnection var6 = (HttpURLConnection)(new URL(var2)).openConnection();

      WebResourceResponse var5;
      try {
         com.google.android.gms.internal.bD.a(var0, var1, true, var6);
         var6.connect();
         var5 = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(com.google.android.gms.internal.bD.a((Readable)(new InputStreamReader(var6.getInputStream()))).getBytes("UTF-8")));
      } finally {
         var6.disconnect();
      }

      return var5;
   }

   public final WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
      try {
         if(!"mraid.js".equalsIgnoreCase((new File(var2)).getName())) {
            return super.shouldInterceptRequest(var1, var2);
         } else if(!(var1 instanceof com.google.android.gms.internal.bL)) {
            com.google.android.gms.internal.bJ.e("Tried to intercept request from a WebView that wasn\'t an AdWebView.");
            return super.shouldInterceptRequest(var1, var2);
         } else {
            com.google.android.gms.internal.bL var3 = (com.google.android.gms.internal.bL)var1;
            var3.f().c();
            if(var3.e().e) {
               com.google.android.gms.internal.bJ.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
               return a(var3.getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            } else if(var3.i()) {
               com.google.android.gms.internal.bJ.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
               return a(var3.getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            } else {
               com.google.android.gms.internal.bJ.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
               WebResourceResponse var5 = a(var3.getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
               return var5;
            }
         }
      } catch (IOException var4) {
         com.google.android.gms.internal.bJ.e("Could not fetching MRAID JS. " + var4.getMessage());
         return super.shouldInterceptRequest(var1, var2);
      }
   }
}
