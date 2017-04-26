package com.adsdk.sdk.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import com.adsdk.sdk.mraid.Drawables;

public class MraidBrowser extends Activity {
   public static final int INNER_LAYOUT_ID = 1;
   public static final String URL_EXTRA = "extra_url";
   private ImageButton mBackButton;
   private ImageButton mCloseButton;
   private ImageButton mForwardButton;
   private ImageButton mRefreshButton;
   private WebView mWebView;

   private void enableCookies() {
      CookieSyncManager.createInstance(this);
      CookieSyncManager.getInstance().startSync();
   }

   private ImageButton getButton(Drawable var1) {
      ImageButton var2 = new ImageButton(this);
      LayoutParams var3 = new LayoutParams(-2, -2, 1.0F);
      var3.gravity = 16;
      var2.setLayoutParams(var3);
      var2.setImageDrawable(var1);
      return var2;
   }

   private View getMraidBrowserView() {
      LinearLayout var1 = new LinearLayout(this);
      var1.setLayoutParams(new LayoutParams(-1, -1));
      var1.setOrientation(1);
      RelativeLayout var2 = new RelativeLayout(this);
      var2.setLayoutParams(new LayoutParams(-1, -2));
      var1.addView(var2);
      LinearLayout var3 = new LinearLayout(this);
      var3.setId(1);
      android.widget.RelativeLayout.LayoutParams var4 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
      var4.addRule(12);
      var3.setLayoutParams(var4);
      var3.setBackgroundDrawable(Drawables.BACKGROUND.decodeImage(this));
      var2.addView(var3);
      this.mBackButton = this.getButton(Drawables.LEFT_ARROW.decodeImage(this));
      this.mForwardButton = this.getButton(Drawables.RIGHT_ARROW.decodeImage(this));
      this.mRefreshButton = this.getButton(Drawables.REFRESH.decodeImage(this));
      this.mCloseButton = this.getButton(Drawables.CLOSE.decodeImage(this));
      var3.addView(this.mBackButton);
      var3.addView(this.mForwardButton);
      var3.addView(this.mRefreshButton);
      var3.addView(this.mCloseButton);
      this.mWebView = new WebView(this);
      android.widget.RelativeLayout.LayoutParams var5 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
      var5.addRule(2, 1);
      this.mWebView.setLayoutParams(var5);
      var2.addView(this.mWebView);
      return var1;
   }

   private void initializeButtons() {
      this.mBackButton.setBackgroundColor(0);
      this.mBackButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(MraidBrowser.this.mWebView.canGoBack()) {
               MraidBrowser.this.mWebView.goBack();
            }

         }
      });
      this.mForwardButton.setBackgroundColor(0);
      this.mForwardButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(MraidBrowser.this.mWebView.canGoForward()) {
               MraidBrowser.this.mWebView.goForward();
            }

         }
      });
      this.mRefreshButton.setBackgroundColor(0);
      this.mRefreshButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MraidBrowser.this.mWebView.reload();
         }
      });
      this.mCloseButton.setBackgroundColor(0);
      this.mCloseButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MraidBrowser.this.finish();
         }
      });
   }

   @SuppressLint({"SetJavaScriptEnabled"})
   private void initializeWebView(Intent var1) {
      WebSettings var2 = this.mWebView.getSettings();
      var2.setJavaScriptEnabled(true);
      var2.setSupportZoom(true);
      var2.setBuiltInZoomControls(true);
      var2.setUseWideViewPort(true);
      this.mWebView.loadUrl(var1.getStringExtra("extra_url"));
      this.mWebView.setWebViewClient(new WebViewClient() {
         public void onPageFinished(WebView var1, String var2) {
            super.onPageFinished(var1, var2);
            BitmapDrawable var4;
            if(var1.canGoBack()) {
               var4 = Drawables.LEFT_ARROW.decodeImage(MraidBrowser.this);
            } else {
               var4 = Drawables.UNLEFT_ARROW.decodeImage(MraidBrowser.this);
            }

            MraidBrowser.this.mBackButton.setImageDrawable(var4);
            BitmapDrawable var3;
            if(var1.canGoForward()) {
               var3 = Drawables.RIGHT_ARROW.decodeImage(MraidBrowser.this);
            } else {
               var3 = Drawables.UNRIGHT_ARROW.decodeImage(MraidBrowser.this);
            }

            MraidBrowser.this.mForwardButton.setImageDrawable(var3);
         }

         public void onPageStarted(WebView var1, String var2, Bitmap var3) {
            super.onPageStarted(var1, var2, var3);
            MraidBrowser.this.mForwardButton.setImageDrawable(Drawables.UNRIGHT_ARROW.decodeImage(MraidBrowser.this));
         }

         public void onReceivedError(WebView var1, int var2, String var3, String var4) {
            Toast.makeText((Activity)var1.getContext(), "MRAID error: " + var3, 0).show();
         }

         public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            if(var2 != null) {
               String var4 = Uri.parse(var2).getHost();
               if(!var2.startsWith("http:") && !var2.startsWith("https:") || "play.google.com".equals(var4) || "market.android.com".equals(var4)) {
                  try {
                     MraidBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
                  } catch (ActivityNotFoundException var3) {
                     Log.w("MoPub", "Unable to start activity for " + var2 + ". Ensure that your phone can handle this intent.");
                  }

                  MraidBrowser.this.finish();
                  return true;
               }
            }

            return false;
         }
      });
      this.mWebView.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView var1, int var2) {
            Activity var3 = (Activity)var1.getContext();
            var3.setTitle("Loading...");
            var3.setProgress(var2 * 100);
            if(var2 == 100) {
               var3.setTitle(var1.getUrl());
            }

         }
      });
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().requestFeature(2);
      this.getWindow().setFeatureInt(2, -1);
      this.setContentView(this.getMraidBrowserView());
      this.initializeWebView(this.getIntent());
      this.initializeButtons();
      this.enableCookies();
   }

   protected void onPause() {
      super.onPause();
      CookieSyncManager.getInstance().stopSync();
   }

   protected void onResume() {
      super.onResume();
      CookieSyncManager.getInstance().startSync();
   }
}
