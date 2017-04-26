package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public final class bT extends WebViewClient {
   private final String a;
   private boolean b;
   private final com.google.android.gms.internal.bL c;
   private final com.google.android.gms.internal.aY d;

   public bT(com.google.android.gms.internal.aY var1, com.google.android.gms.internal.bL var2, String var3) {
      this.a = b(var3);
      this.b = false;
      this.c = var2;
      this.d = var1;
   }

   private boolean a(String var1) {
      var1 = b(var1);
      if(!TextUtils.isEmpty(var1)) {
         try {
            URI var3 = new URI(var1);
            if("passback".equals(var3.getScheme())) {
               com.google.android.gms.internal.bJ.a("Passback received");
               this.d.b();
               return true;
            }

            if(!TextUtils.isEmpty(this.a)) {
               URI var4 = new URI(this.a);
               var1 = var4.getHost();
               String var2 = var3.getHost();
               String var7 = var4.getPath();
               String var6 = var3.getPath();
               if(com.google.android.gms.internal.cK.a(var1, var2) && com.google.android.gms.internal.cK.a(var7, var6)) {
                  com.google.android.gms.internal.bJ.a("Passback received");
                  this.d.b();
                  return true;
               }
            }
         } catch (URISyntaxException var5) {
            com.google.android.gms.internal.bJ.b(var5.getMessage());
            return false;
         }
      }

      return false;
   }

   private static String b(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         try {
            if(var0.endsWith("/")) {
               String var1 = var0.substring(0, var0.length() - 1);
               return var1;
            }
         } catch (IndexOutOfBoundsException var2) {
            com.google.android.gms.internal.bJ.b(var2.getMessage());
            return var0;
         }
      }

      return var0;
   }

   public final void onLoadResource(WebView var1, String var2) {
      com.google.android.gms.internal.bJ.a("JavascriptAdWebViewClient::onLoadResource: " + var2);
      if(!this.a(var2)) {
         this.c.f().onLoadResource(this.c, var2);
      }

   }

   public final void onPageFinished(WebView var1, String var2) {
      com.google.android.gms.internal.bJ.a("JavascriptAdWebViewClient::onPageFinished: " + var2);
      if(!this.b) {
         this.d.a();
         this.b = true;
      }

   }

   public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      com.google.android.gms.internal.bJ.a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + var2);
      if(this.a(var2)) {
         com.google.android.gms.internal.bJ.a("shouldOverrideUrlLoading: received passback url");
         return true;
      } else {
         return this.c.f().shouldOverrideUrlLoading(this.c, var2);
      }
   }
}
