package com.amazon.device.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.ViewManager$AdWebChromeClient;
import com.amazon.device.ads.ViewManager$PreloadWebViewClient;
import com.amazon.device.ads.WebViewFactory;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ViewManager {
   private static final String CONTENT_DESCRIPTION_NEW_WEBVIEW = "newWebView";
   private static final String CONTENT_DESCRIPTION_ORIGINAL_WEBVIEW = "originalWebView";
   private static final String CONTENT_DESCRIPTION_PRELOADED_WEBVIEW = "preloadedWebView";
   private static final String LOGTAG = ViewManager.class.getSimpleName();
   private final ConnectionInfo connectionInfo;
   private WebView currentWebView;
   private boolean disableHardwareAcceleration;
   private final Set javascriptInterfaceNames;
   private OnKeyListener keyListener;
   private final ViewGroup parent;
   private WebView preloadedWebView;
   private WebView stashedWebView;
   private WebViewClient webViewClient;
   private int webViewHeight;

   public ViewManager(ViewGroup var1) {
      this(var1, new ConnectionInfo());
   }

   ViewManager(ViewGroup var1, ConnectionInfo var2) {
      this.webViewHeight = -1;
      this.disableHardwareAcceleration = false;
      this.javascriptInterfaceNames = new HashSet();
      this.parent = var1;
      this.connectionInfo = var2;
   }

   // $FF: synthetic method
   static String access$100() {
      return LOGTAG;
   }

   private void destroyWebViews(final WebView... var1) {
      ThreadUtils.executeOnMainThread(new Runnable() {
         public void run() {
            WebView[] var3 = var1;
            int var2 = var3.length;

            for(int var1x = 0; var1x < var2; ++var1x) {
               WebView var4 = var3[var1x];
               if(var4 != null) {
                  if(var4.getParent() != null) {
                     ((ViewGroup)var4.getParent()).removeView(var4);
                  }

                  try {
                     var4.destroy();
                  } catch (IllegalArgumentException var5) {
                     Log.w("Caught an IllegalArgumentException while destroying a WebView: %s", var5.getMessage());
                  }
               }
            }

         }
      });
   }

   private WebView getCurrentWebView() {
      if(this.currentWebView == null) {
         WebView var1 = this.createWebView(this.getContext(this.parent));
         if(!this.validateWebView(var1)) {
            throw new IllegalStateException("Could not create WebView");
         }

         var1.setContentDescription("originalWebView");
         this.setWebView(var1, false);
      }

      return this.currentWebView;
   }

   private WebView getPreloadedWebView() {
      if(this.preloadedWebView == null) {
         this.preloadedWebView = this.createWebView(this.parent.getContext());
         this.preloadedWebView.setContentDescription("preloadedWebView");
      }

      return this.preloadedWebView;
   }

   private boolean isInitialized() {
      return this.currentWebView != null;
   }

   public void addJavascriptInterface(Object var1, boolean var2, String var3) {
      Log.d(LOGTAG, "Add JavaScript Interface %s", new Object[]{var3});
      this.javascriptInterfaceNames.add(var3);
      if(var2) {
         this.getPreloadedWebView().addJavascriptInterface(var1, var3);
      } else {
         this.getCurrentWebView().addJavascriptInterface(var1, var3);
      }
   }

   void addViewToParent(WebView var1) {
      this.parent.addView(var1);
   }

   WebView createWebView(Context var1) {
      WebView var2 = WebViewFactory.getInstance().createWebView(var1);
      if(!WebViewFactory.setJavaScriptEnabledForWebView(true, var2, LOGTAG)) {
         return null;
      } else {
         WebViewFactory.setVideoPlaybackProperties(var2, this.connectionInfo);
         var2.setScrollContainer(false);
         var2.setBackgroundColor(0);
         var2.setVerticalScrollBarEnabled(false);
         var2.setHorizontalScrollBarEnabled(false);
         var2.setWebChromeClient(new ViewManager$AdWebChromeClient(this, null));
         var2.getSettings().setDomStorageEnabled(true);
         if(this.disableHardwareAcceleration) {
            AndroidTargetUtils.disableHardwareAcceleration(var2);
         }

         return var2;
      }
   }

   public void destroy() {
      this.destroyWebViews(new WebView[]{this.currentWebView, this.stashedWebView, this.preloadedWebView});
      this.currentWebView = null;
      this.stashedWebView = null;
      this.preloadedWebView = null;
   }

   public void disableHardwareAcceleration(boolean var1) {
      this.disableHardwareAcceleration = var1;
   }

   Context getContext(View var1) {
      return var1.getContext();
   }

   public void initialize() {
      if(this.connectionInfo == null) {
         throw new IllegalStateException("The connection info must be set in the view manager.");
      } else {
         this.getCurrentWebView();
      }
   }

   public boolean isCurrentView(View var1) {
      return var1.equals(this.currentWebView);
   }

   public void listenForKey(OnKeyListener var1) {
      this.keyListener = var1;
      this.getCurrentWebView().requestFocus();
      this.getCurrentWebView().setOnKeyListener(this.keyListener);
   }

   public void loadData(String var1, String var2, String var3) {
      this.loadData(var1, var2, var3, false, (PreloadCallback)null);
   }

   public void loadData(String var1, String var2, String var3, boolean var4, PreloadCallback var5) {
      if(var4) {
         if(var5 != null) {
            this.getPreloadedWebView().setWebViewClient(new ViewManager$PreloadWebViewClient(this, var5));
         }

         this.getPreloadedWebView().loadData(var1, var2, var3);
      } else {
         this.getCurrentWebView().loadData(var1, var2, var3);
      }
   }

   public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5) {
      this.loadDataWithBaseURL(var1, var2, var3, var4, var5, false, (PreloadCallback)null);
   }

   public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5, boolean var6, PreloadCallback var7) {
      if(var6) {
         if(var7 != null) {
            this.getPreloadedWebView().setWebViewClient(new ViewManager$PreloadWebViewClient(this, var7));
         }

         this.getPreloadedWebView().loadDataWithBaseURL(var1, var2, var3, var4, var5);
      } else {
         this.getCurrentWebView().loadDataWithBaseURL(var1, var2, var3, var4, var5);
      }
   }

   public void loadUrl(String var1) {
      this.loadUrl(var1, false, (PreloadCallback)null);
   }

   public void loadUrl(String var1, boolean var2, PreloadCallback var3) {
      if(var2) {
         if(var3 != null) {
            this.getPreloadedWebView().setWebViewClient(new ViewManager$PreloadWebViewClient(this, var3));
         }

         this.getPreloadedWebView().loadUrl(var1);
      } else {
         Log.d(LOGTAG, "Loading URL: " + var1);
         this.getCurrentWebView().loadUrl(var1);
      }
   }

   public boolean popView() {
      if(this.stashedWebView != null) {
         WebView var1 = this.stashedWebView;
         this.stashedWebView = null;
         this.setWebView(var1, true);
         return true;
      } else {
         return false;
      }
   }

   public void removePreviousInterfaces() {
      if(this.currentWebView != null) {
         if(AndroidTargetUtils.isAtLeastAndroidAPI(11)) {
            Iterator var1 = this.javascriptInterfaceNames.iterator();

            while(var1.hasNext()) {
               String var2 = (String)var1.next();
               AndroidTargetUtils.removeJavascriptInterface(this.currentWebView, var2);
            }
         } else {
            this.setWebView(this.createWebView(this.parent.getContext()), true);
            this.currentWebView.setContentDescription("originalWebView");
         }
      }

      this.javascriptInterfaceNames.clear();
   }

   public void setHeight(int var1) {
      this.webViewHeight = var1;
      if(this.isInitialized()) {
         this.setWebViewLayoutParams(this.getCurrentWebView(), -1, this.webViewHeight);
      }

   }

   void setWebView(WebView var1, boolean var2) {
      WebView var3 = this.currentWebView;
      if(var3 != null) {
         var3.setOnKeyListener((OnKeyListener)null);
         var3.setWebViewClient(new WebViewClient());
         this.parent.removeView(var3);
         if(var2) {
            this.destroyWebViews(new WebView[]{var3});
         }
      }

      var1.setWebViewClient(this.webViewClient);
      this.currentWebView = var1;
      this.setWebViewLayoutParams(this.currentWebView, -1, this.webViewHeight);
      this.addViewToParent(this.currentWebView);
      if(this.keyListener != null) {
         this.listenForKey(this.keyListener);
      }

   }

   public void setWebViewClient(WebViewClient var1) {
      this.webViewClient = var1;
      if(this.isInitialized()) {
         this.getCurrentWebView().setWebViewClient(this.webViewClient);
      }

   }

   protected void setWebViewLayoutParams(WebView var1, int var2, int var3) {
      if(var1.getLayoutParams() == null) {
         var1.setLayoutParams(new LayoutParams(var2, var3));
      } else {
         var1.getLayoutParams().width = var2;
         var1.getLayoutParams().height = var3;
      }
   }

   public void stashView() {
      if(this.stashedWebView != null) {
         this.destroyWebViews(new WebView[]{this.stashedWebView});
      }

      this.stashedWebView = this.currentWebView;
      WebView var1;
      if(this.preloadedWebView == null) {
         var1 = this.createWebView(this.parent.getContext());
         var1.setContentDescription("newWebView");
      } else {
         var1 = this.preloadedWebView;
         this.preloadedWebView = this.createWebView(this.parent.getContext());
      }

      this.setWebView(var1, false);
   }

   boolean validateWebView(WebView var1) {
      return var1 != null;
   }
}
