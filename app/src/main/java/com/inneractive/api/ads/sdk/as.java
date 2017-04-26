package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inneractive.api.ads.sdk.IAbaseWebView;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import java.net.URI;

final class as extends WebViewClient {
   private final Context a;
   private IAbaseWebView b;

   as(IAbaseWebView var1) {
      this.b = var1;
      this.a = var1.getContext();
   }

   private boolean a(Context var1, Intent var2, String var3) {
      boolean var4;
      if(!this.b.wasClicked()) {
         var4 = false;
      } else {
         boolean var5 = b(var1, var2, var3);
         var4 = var5;
         if(var5) {
            this.b.getListener().onClicked();
            this.b.onResetClick();
            return var5;
         }
      }

      return var4;
   }

   private boolean a(String var1) {
      if(var1.startsWith("inneractivenativebrowser://")) {
         Uri var2 = Uri.parse(var1);

         String var3;
         try {
            var3 = var2.getQueryParameter("url");
         } catch (UnsupportedOperationException var4) {
            InneractiveAdView$Log.b("Failed to handle url: " + var1);
            return false;
         }

         if("navigate".equals(var2.getHost()) && var3 != null) {
            Intent var5 = new Intent("android.intent.action.VIEW", Uri.parse(var3));
            var5.setFlags(268435456);
            var1 = "Could not handle intent with URI: " + var1 + ". Is this intent supported on your phone?";
            this.a(this.a, var5, var1);
            this.b.getListener().onAdWillOpenExternalApp();
            return true;
         }
      }

      return false;
   }

   private static boolean b(Context var0, Intent var1, String var2) {
      try {
         var0.startActivity(var1);
         return true;
      } catch (Exception var3) {
         if(var2 == null) {
            var2 = "Failed to start the intent";
         }

         InneractiveAdView$Log.a(var2);
         return false;
      }
   }

   public final void onLoadResource(WebView var1, String var2) {
      InneractiveAdView$Log.d("Resources to load: " + var2);
   }

   public final void onPageFinished(WebView var1, String var2) {
      InneractiveAdView$Log.d("onPageFinished - url: " + var2);
      this.b.onAdReadyDOM();
   }

   public final void onPageStarted(WebView var1, String var2, Bitmap var3) {
      InneractiveAdView$Log.d("onPageStarted - url: " + var2);
   }

   public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
      InneractiveAdView$Log.d("Error: " + var3);
      super.onReceivedError(var1, var2, var3, var4);
   }

   public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      boolean var4 = false;
      boolean var3;
      if(!var2.endsWith("inneractive-skip") && !var2.startsWith("iaadfinishedloading") && !var2.contains("mraid")) {
         var3 = false;
      } else {
         var3 = true;
      }

      String var5;
      if(!var3) {
         var3 = false;
      } else {
         Uri var7 = Uri.parse(var2);
         var5 = var7.toString();
         if("mraid".equals(var7.getScheme())) {
            this.b.tryCommand(URI.create(var2));
         } else if(var5.endsWith("inneractive-skip")) {
            InneractiveAdView$Log.a("Should close interstitial");
            this.b.getListener().onDismissed();
         } else if(var5.startsWith("iaadfinishedloading")) {
            if(var5.endsWith("failure")) {
               InneractiveAdView$Log.d("onload = shouldOverride iaadfinishedloading failure");
               this.b.getListener().onFailure(this.b, InneractiveAdView$InneractiveErrorCode.SERVER_INVALID_RESPONSE);
            } else {
               InneractiveAdView$Log.d("onload = shouldOverride iaadfinishedloading success");
               this.b.onAdReadyWindowOnLoad();
            }
         }

         var3 = true;
      }

      if(!var3) {
         if(!var2.startsWith("tel:") && !var2.startsWith("voicemail:") && !var2.startsWith("sms:") && !var2.startsWith("mailto:") && !var2.startsWith("geo:") && !var2.startsWith("google.streetview:")) {
            var3 = false;
         } else {
            var3 = true;
         }

         Intent var8;
         if(!var3) {
            var3 = false;
         } else {
            var8 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
            var8.addFlags(268435456);
            var5 = "Could not handle intent with URI: " + var2 + ". Is this intent supported on your phone?";
            this.a(this.a, var8, var5);
            this.b.getListener().onAdWillOpenExternalApp();
            var3 = true;
         }

         if(!var3 && !this.a(var2)) {
            InneractiveAdView$Log.a("Ad clicked! Here is the click URL: " + var2);
            if(!var2.startsWith("http://") && !var2.startsWith("https://")) {
               var3 = false;
            } else {
               var3 = true;
            }

            if(!var3) {
               var8 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
               if(!com.inneractive.api.ads.sdk.a.a(this.a, var8)) {
                  InneractiveAdView$Log.e("Failed to handle application specific action: " + var2 + ". Check Whether you\'re running in the emulator or another device which does not have the required application.");
                  var3 = var4;
               } else {
                  var3 = true;
               }

               if(var3) {
                  var8 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
                  var8.addFlags(268435456);
                  if(this.a(this.a, var8, "Unable to open intent.")) {
                     return true;
                  }
               }
            }

            InneractiveAdView$Log.d("opening Internal Browser For Url: " + var2);

            try {
               Uri.parse(var2);
            } catch (Exception var6) {
               InneractiveAdView$Log.b("openUrl: Invalid url " + var2);
               var2 = "about:blank";
            }

            InneractiveAdView$Log.a("Here is the final URI to show in browser: " + var2);
            if(this.b.getAdConfig() != null && !this.b.getAdConfig().K()) {
               Context var9 = this.a;
               var8 = com.inneractive.api.ads.sdk.an.k(var2);
            } else {
               var8 = com.inneractive.api.ads.sdk.an.b(this.a, var2);
            }

            if(!this.a(this.a, var8, "Could not handle intent action. . Perhaps you forgot to declare com.inneractive.ads.api.sdk.InneractiveInternalBrowserActivity in your Android manifest file.")) {
               var8 = new Intent("android.intent.action.VIEW", Uri.parse("about:blank"));
               var8.setFlags(268435456);
               this.a(this.a, var8, (String)null);
               return true;
            }
         }
      }

      return true;
   }
}
