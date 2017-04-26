package com.adsdk.sdk.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.adsdk.sdk.Log;

public class InAppWebView extends Activity {
   public static final String URL_EXTRA = "extra_url";

   @SuppressLint({"SetJavaScriptEnabled"})
   private void initializeWebView(Intent var1) {
      WebView var2 = new WebView(this);
      this.setContentView(var2);
      WebSettings var3 = var2.getSettings();
      var3.setJavaScriptEnabled(true);
      var3.setSupportZoom(true);
      var3.setBuiltInZoomControls(true);
      var3.setUseWideViewPort(true);
      var2.setWebViewClient(new WebViewClient() {
         public void onReceivedError(WebView var1, int var2, String var3, String var4) {
            Toast.makeText((Activity)var1.getContext(), "MRAID error: " + var3, 0).show();
         }

         public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            if(var2 == null) {
               return false;
            } else {
               String var3 = Uri.parse(var2).getHost();
               if((var2.startsWith("http:") || var2.startsWith("https:")) && !"play.google.com".equals(var3) && !"market.android.com".equals(var3) && !var2.endsWith(".apk")) {
                  var1.loadUrl(var2);
                  return true;
               } else {
                  try {
                     InAppWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
                  } catch (ActivityNotFoundException var4) {
                     Log.w("MoPub", "Unable to start activity for " + var2 + ". Ensure that your phone can handle this intent.");
                  }

                  InAppWebView.this.finish();
                  return true;
               }
            }
         }
      });
      var2.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView var1, int var2) {
            Activity var3 = (Activity)var1.getContext();
            var3.setTitle("Loading...");
            var3.setProgress(var2 * 100);
            if(var2 == 100) {
               var3.setTitle(var1.getUrl());
            }

         }
      });
      var2.loadUrl(var1.getStringExtra("REDIRECT_URI"));
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().requestFeature(2);
      this.getWindow().setFeatureInt(2, -1);
      this.initializeWebView(this.getIntent());
   }
}
