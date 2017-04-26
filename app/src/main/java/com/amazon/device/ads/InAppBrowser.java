package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.amazon.device.ads.AdActivity$IAdActivityAdapter;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.InAppBrowser$LoadButtonsTask;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebUtils;
import com.amazon.device.ads.WebViewFactory;
import java.util.concurrent.atomic.AtomicBoolean;

class InAppBrowser implements AdActivity$IAdActivityAdapter {
   protected static final int BUTTON_SIZE_DP = 50;
   private static final String CONTENT_DESCRIPTION_BACK_BUTTON = "inAppBrowserBackButton";
   private static final String CONTENT_DESCRIPTION_BUTTON_LAYOUT = "inAppBrowserButtonLayout";
   private static final String CONTENT_DESCRIPTION_CLOSE_BUTTON = "inAppBrowserCloseButton";
   private static final String CONTENT_DESCRIPTION_FORWARD_BUTTON = "inAppBrowserForwardButton";
   private static final String CONTENT_DESCRIPTION_HORZ_RULE = "inAppBrowserHorizontalRule";
   private static final String CONTENT_DESCRIPTION_MAIN_LAYOUT = "inAppBrowserMainLayout";
   private static final String CONTENT_DESCRIPTION_OPEN_EXT_BRWSR_BUTTON = "inAppBrowserOpenExternalBrowserButton";
   private static final String CONTENT_DESCRIPTION_REFRESH_BUTTON = "inAppBrowserRefreshButton";
   private static final String CONTENT_DESCRIPTION_RELATIVE_LAYOUT = "inAppBrowserRelativeLayout";
   private static final String CONTENT_DESCRIPTION_WEB_VIEW = "inAppBrowserWebView";
   protected static final int HORIZONTAL_RULE_SIZE_DP = 3;
   protected static final String LOG_TAG = InAppBrowser.class.getSimpleName();
   protected static final String SHOW_OPEN_EXTERNAL_BROWSER_BTN = "extra_open_btn";
   protected static final String URL_EXTRA = "extra_url";
   private Activity activity;
   private ImageButton browserBackButton;
   private ImageButton browserForwardButton;
   private final AtomicBoolean buttonsCreated = new AtomicBoolean(false);
   private ImageButton closeButton;
   private ImageButton openExternalBrowserButton;
   private ImageButton refreshButton;
   private boolean showOpenExternalBrowserButton;
   private WebView webView;

   // $FF: synthetic method
   static void access$1000(InAppBrowser var0, Intent var1) {
      var0.initializeButtons(var1);
   }

   // $FF: synthetic method
   static AtomicBoolean access$1100(InAppBrowser var0) {
      return var0.buttonsCreated;
   }

   // $FF: synthetic method
   static ImageButton access$300(InAppBrowser var0) {
      return var0.browserBackButton;
   }

   // $FF: synthetic method
   static ImageButton access$302(InAppBrowser var0, ImageButton var1) {
      var0.browserBackButton = var1;
      return var1;
   }

   // $FF: synthetic method
   static ImageButton access$400(InAppBrowser var0, String var1, int var2, int var3, int var4, int var5) {
      return var0.createButton(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   static ImageButton access$500(InAppBrowser var0) {
      return var0.browserForwardButton;
   }

   // $FF: synthetic method
   static ImageButton access$502(InAppBrowser var0, ImageButton var1) {
      var0.browserForwardButton = var1;
      return var1;
   }

   // $FF: synthetic method
   static ImageButton access$600(InAppBrowser var0) {
      return var0.closeButton;
   }

   // $FF: synthetic method
   static ImageButton access$602(InAppBrowser var0, ImageButton var1) {
      var0.closeButton = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean access$700(InAppBrowser var0) {
      return var0.showOpenExternalBrowserButton;
   }

   // $FF: synthetic method
   static ImageButton access$800(InAppBrowser var0) {
      return var0.openExternalBrowserButton;
   }

   // $FF: synthetic method
   static ImageButton access$802(InAppBrowser var0, ImageButton var1) {
      var0.openExternalBrowserButton = var1;
      return var1;
   }

   // $FF: synthetic method
   static ImageButton access$900(InAppBrowser var0) {
      return var0.refreshButton;
   }

   // $FF: synthetic method
   static ImageButton access$902(InAppBrowser var0, ImageButton var1) {
      var0.refreshButton = var1;
      return var1;
   }

   private ImageButton createButton(String var1, int var2, int var3, int var4, int var5) {
      ImageButton var6 = new ImageButton(this.activity);
      var6.setImageBitmap(BitmapFactory.decodeFile(var1));
      LayoutParams var7 = new LayoutParams(var4, var5);
      var7.addRule(var2, var3);
      var7.addRule(12);
      var6.setLayoutParams(var7);
      var6.setBackgroundColor(0);
      var6.setScaleType(ScaleType.FIT_CENTER);
      return var6;
   }

   private void enableCookies() {
      CookieSyncManager.createInstance(this.activity);
      CookieSyncManager.getInstance().startSync();
   }

   @SuppressLint({"InlinedApi"})
   private void initialize(Intent var1) {
      DisplayMetrics var6 = new DisplayMetrics();
      this.getMetrics(var6);
      float var2 = var6.density;
      int var4 = (int)(50.0F * var2 + 0.5F);
      int var5 = (int)(var2 * 3.0F + 0.5F);
      byte var3;
      if(this.showOpenExternalBrowserButton) {
         var3 = 5;
      } else {
         var3 = 4;
      }

      int var11 = Math.min(var6.widthPixels / var3, var4 * 2);
      RelativeLayout var12 = this.createRelativeLayout(this.activity);
      var12.setContentDescription("inAppBrowserButtonLayout");
      var12.setId(10280);
      LayoutParams var7 = new LayoutParams(-1, var4 + var5);
      var7.addRule(12);
      var12.setLayoutParams(var7);
      var12.setBackgroundColor(-986896);
      ThreadUtils.executeAsyncTask(new InAppBrowser$LoadButtonsTask(this, var1, var12, var11, var4), new Void[0]);
      View var8 = new View(this.activity);
      var8.setContentDescription("inAppBrowserHorizontalRule");
      var8.setBackgroundColor(-3355444);
      var7 = new LayoutParams(-1, var5);
      var7.addRule(10);
      var8.setLayoutParams(var7);
      var12.addView(var8);
      this.webView = WebViewFactory.getInstance().createWebView(this.activity);
      this.webView.getSettings().setUserAgentString(InternalAdRegistration.getInstance().getDeviceInfo().getUserAgentString() + "-inAppBrowser");
      this.webView.setContentDescription("inAppBrowserWebView");
      LayoutParams var9 = new LayoutParams(-1, -1);
      var9.addRule(2, var12.getId());
      this.webView.setLayoutParams(var9);
      RelativeLayout var10 = new RelativeLayout(this.activity);
      var10.setContentDescription("inAppBrowserRelativeLayout");
      var10.setLayoutParams(new LayoutParams(-1, -2));
      var10.addView(this.webView);
      var10.addView(var12);
      LinearLayout var13 = new LinearLayout(this.activity);
      var13.setContentDescription("inAppBrowserMainLayout");
      var13.setOrientation(1);
      var13.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
      var13.addView(var10);
      this.activity.setContentView(var13);
   }

   private void initializeButtons(Intent var1) {
      this.browserBackButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(InAppBrowser.this.webView.canGoBack()) {
               InAppBrowser.this.webView.goBack();
            }

         }
      });
      this.browserForwardButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(InAppBrowser.this.webView.canGoForward()) {
               InAppBrowser.this.webView.goForward();
            }

         }
      });
      this.refreshButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            InAppBrowser.this.webView.reload();
         }
      });
      this.closeButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            InAppBrowser.this.activity.finish();
         }
      });
      if(this.showOpenExternalBrowserButton) {
         final String var2 = var1.getStringExtra("extra_url");
         this.openExternalBrowserButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               String var2x = InAppBrowser.this.webView.getUrl();
               String var3 = var2x;
               if(var2x == null) {
                  Log.w(InAppBrowser.LOG_TAG, "The current URL is null. Reverting to the original URL for external browser.");
                  var3 = var2;
               }

               WebUtils.launchActivityForIntentLink(var3, InAppBrowser.this.webView.getContext());
            }
         });
      }

   }

   private void initializeWebView(Intent var1) {
      WebViewFactory.setJavaScriptEnabledForWebView(true, this.webView, LOG_TAG);
      this.webView.loadUrl(var1.getStringExtra("extra_url"));
      this.webView.setWebViewClient(new WebViewClient() {
         public void onReceivedError(WebView var1, int var2, String var3, String var4) {
            Log.w(InAppBrowser.LOG_TAG, "InApp Browser error: %s", new Object[]{var3});
         }

         public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            if(!StringUtils.isNullOrWhiteSpace(var2)) {
               String var3 = WebUtils.getScheme(var2);
               if(!var3.equals("http") && !var3.equals("https")) {
                  return WebUtils.launchActivityForIntentLink(var2, InAppBrowser.this.activity);
               }
            }

            return false;
         }
      });
      this.webView.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView var1, int var2) {
            Activity var3 = (Activity)var1.getContext();
            var3.setTitle("Loading...");
            var3.setProgress(var2 * 100);
            if(var2 == 100) {
               var3.setTitle(var1.getUrl());
            }

            InAppBrowser.this.updateNavigationButtons(var1);
         }
      });
   }

   private void updateNavigationButtons(WebView var1) {
      if(this.browserBackButton != null && this.browserForwardButton != null) {
         if(var1.canGoBack()) {
            AndroidTargetUtils.setImageButtonAlpha(this.browserBackButton, 255);
         } else {
            AndroidTargetUtils.setImageButtonAlpha(this.browserBackButton, 102);
         }

         if(!var1.canGoForward()) {
            AndroidTargetUtils.setImageButtonAlpha(this.browserForwardButton, 102);
            return;
         }

         AndroidTargetUtils.setImageButtonAlpha(this.browserForwardButton, 255);
      }

   }

   protected boolean canPauseWebViewTimers() {
      return this.webView != null && this.getShouldPauseWebViewTimers();
   }

   protected boolean canResumeWebViewTimers() {
      return this.webView != null && this.getShouldPauseWebViewTimers();
   }

   RelativeLayout createRelativeLayout(Activity var1) {
      return new RelativeLayout(var1);
   }

   void getMetrics(DisplayMetrics var1) {
      ((WindowManager)this.activity.getSystemService("window")).getDefaultDisplay().getMetrics(var1);
   }

   protected boolean getShouldPauseWebViewTimers() {
      return Settings.getInstance().getBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", false);
   }

   public boolean onBackPressed() {
      return false;
   }

   public void onConfigurationChanged(android.content.res.Configuration var1) {
      DisplayMetrics var4 = new DisplayMetrics();
      this.getMetrics(var4);
      int var3 = (int)(var4.density * 50.0F + 0.5F);
      byte var2;
      if(this.showOpenExternalBrowserButton) {
         var2 = 5;
      } else {
         var2 = 4;
      }

      int var6 = Math.min(var4.widthPixels / var2, var3 * 2);
      Log.d(LOG_TAG, "Width: " + var4.widthPixels + " ButtonWidth: " + var6);
      LayoutParams var5 = new LayoutParams(var6, var3);
      if(this.browserBackButton != null) {
         var5.addRule(9);
         var5.addRule(12);
         this.browserBackButton.setLayoutParams(var5);
      }

      if(this.browserForwardButton != null) {
         var5 = new LayoutParams(var6, var3);
         var5.addRule(1, this.browserBackButton.getId());
         var5.addRule(12);
         this.browserForwardButton.setLayoutParams(var5);
      }

      if(this.closeButton != null) {
         var5 = new LayoutParams(var6, var3);
         var5.addRule(11);
         var5.addRule(12);
         this.closeButton.setLayoutParams(var5);
      }

      if(this.openExternalBrowserButton != null) {
         var5 = new LayoutParams(var6, var3);
         var5.addRule(1, this.browserForwardButton.getId());
         var5.addRule(12);
         this.openExternalBrowserButton.setLayoutParams(var5);
         if(this.refreshButton != null) {
            var5 = new LayoutParams(var6, var3);
            var5.addRule(1, this.openExternalBrowserButton.getId());
            var5.addRule(12);
            this.refreshButton.setLayoutParams(var5);
         }
      } else if(this.refreshButton != null) {
         var5 = new LayoutParams(var6, var3);
         var5.addRule(1, this.browserForwardButton.getId());
         var5.addRule(12);
         this.refreshButton.setLayoutParams(var5);
         return;
      }

   }

   public void onCreate() {
      this.activity.getWindow().requestFeature(2);
      this.activity.getWindow().setFeatureInt(2, -1);
      Intent var1 = this.activity.getIntent();
      this.showOpenExternalBrowserButton = var1.getBooleanExtra("extra_open_btn", false);
      this.initialize(var1);
      this.initializeWebView(var1);
      this.enableCookies();
   }

   public void onPause() {
      Log.d(LOG_TAG, "onPause");
      this.pauseWebView();
      if(this.canPauseWebViewTimers()) {
         this.webView.pauseTimers();
      }

      CookieSyncManager.getInstance().stopSync();
   }

   public void onResume() {
      Log.d(LOG_TAG, "onResume");
      this.resumeWebView();
      if(this.canResumeWebViewTimers()) {
         this.webView.resumeTimers();
      }

      CookieSyncManager.getInstance().startSync();
   }

   public void onStop() {
   }

   void pauseWebView() {
      this.webView.onPause();
   }

   public void preOnCreate() {
   }

   void resumeWebView() {
      this.webView.onResume();
   }

   public void setActivity(Activity var1) {
      this.activity = var1;
   }
}
