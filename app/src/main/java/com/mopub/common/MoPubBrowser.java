package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
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
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Intents;

public class MoPubBrowser extends Activity {
   public static final String DESTINATION_URL_KEY = "URL";
   private static final int INNER_LAYOUT_ID = 1;
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

   private View getMoPubBrowserView() {
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
      var3.setBackgroundDrawable(Drawables.BACKGROUND.createDrawable(this));
      var2.addView(var3);
      this.mBackButton = this.getButton(Drawables.LEFT_ARROW.createDrawable(this));
      this.mForwardButton = this.getButton(Drawables.RIGHT_ARROW.createDrawable(this));
      this.mRefreshButton = this.getButton(Drawables.REFRESH.createDrawable(this));
      this.mCloseButton = this.getButton(Drawables.CLOSE.createDrawable(this));
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
            if(MoPubBrowser.this.mWebView.canGoBack()) {
               MoPubBrowser.this.mWebView.goBack();
            }

         }
      });
      this.mForwardButton.setBackgroundColor(0);
      this.mForwardButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(MoPubBrowser.this.mWebView.canGoForward()) {
               MoPubBrowser.this.mWebView.goForward();
            }

         }
      });
      this.mRefreshButton.setBackgroundColor(0);
      this.mRefreshButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MoPubBrowser.this.mWebView.reload();
         }
      });
      this.mCloseButton.setBackgroundColor(0);
      this.mCloseButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MoPubBrowser.this.finish();
         }
      });
   }

   private void initializeWebView() {
      WebSettings var1 = this.mWebView.getSettings();
      var1.setJavaScriptEnabled(true);
      var1.setSupportZoom(true);
      var1.setBuiltInZoomControls(true);
      var1.setUseWideViewPort(true);
      this.mWebView.loadUrl(this.getIntent().getStringExtra("URL"));
      this.mWebView.setWebViewClient(new WebViewClient() {
         public void onPageFinished(WebView var1, String var2) {
            super.onPageFinished(var1, var2);
            Drawable var4;
            if(var1.canGoBack()) {
               var4 = Drawables.LEFT_ARROW.createDrawable(MoPubBrowser.this);
            } else {
               var4 = Drawables.UNLEFT_ARROW.createDrawable(MoPubBrowser.this);
            }

            MoPubBrowser.this.mBackButton.setImageDrawable(var4);
            Drawable var3;
            if(var1.canGoForward()) {
               var3 = Drawables.RIGHT_ARROW.createDrawable(MoPubBrowser.this);
            } else {
               var3 = Drawables.UNRIGHT_ARROW.createDrawable(MoPubBrowser.this);
            }

            MoPubBrowser.this.mForwardButton.setImageDrawable(var3);
         }

         public void onPageStarted(WebView var1, String var2, Bitmap var3) {
            super.onPageStarted(var1, var2, var3);
            MoPubBrowser.this.mForwardButton.setImageDrawable(Drawables.UNRIGHT_ARROW.createDrawable(MoPubBrowser.this));
         }

         public void onReceivedError(WebView var1, int var2, String var3, String var4) {
            Toast.makeText(MoPubBrowser.this, "MoPubBrowser error: " + var3, 0).show();
         }

         public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            if(var2 != null) {
               Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
               if(Intents.isDeepLink(var2) && Intents.deviceCanHandleIntent(MoPubBrowser.this, var3)) {
                  MoPubBrowser.this.startActivity(var3);
                  MoPubBrowser.this.finish();
                  return true;
               }
            }

            return false;
         }
      });
      this.mWebView.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView var1, int var2) {
            MoPubBrowser.this.setTitle("Loading...");
            MoPubBrowser.this.setProgress(var2 * 100);
            if(var2 == 100) {
               MoPubBrowser.this.setTitle(var1.getUrl());
            }

         }
      });
   }

   public static void open(Context var0, String var1) {
      MoPubLog.d("Opening url in MoPubBrowser: " + var1);
      Intent var2 = new Intent(var0, MoPubBrowser.class);
      var2.putExtra("URL", var1);
      var2.addFlags(268435456);
      var0.startActivity(var2);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setResult(-1);
      this.getWindow().requestFeature(2);
      this.getWindow().setFeatureInt(2, -1);
      this.setContentView(this.getMoPubBrowserView());
      this.initializeWebView();
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
