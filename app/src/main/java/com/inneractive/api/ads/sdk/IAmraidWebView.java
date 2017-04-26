package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.JavascriptInterface;
import com.inneractive.api.ads.sdk.IAbaseWebView;
import com.inneractive.api.ads.sdk.IAmraidActionFactory;
import com.inneractive.api.ads.sdk.IAmraidActionFactory$MraidJavascriptCommand;
import com.inneractive.api.ads.sdk.IAmraidWebView$ExpandMode;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import com.inneractive.api.ads.sdk.IAmraidWebView$NativeCloseButtonMode;
import com.inneractive.api.ads.sdk.IAmraidWebView$c;
import com.inneractive.api.ads.sdk.IAmraidWebView$d;
import com.inneractive.api.ads.sdk.IAmraidWebViewController;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveInternalBrowserActivity;
import com.inneractive.api.ads.sdk.InneractiveInternalBrowserActivity$a;
import com.inneractive.api.ads.sdk.x$a;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

final class IAmraidWebView extends IAbaseWebView implements InneractiveInternalBrowserActivity$a {
   boolean mClicked;
   private com.inneractive.api.ads.sdk.x mGestDetector;
   private Handler mHandler;
   private boolean mHasFiredReadyEvent;
   private InneractiveInternalBrowserActivity mInternalBrowserActivity;
   private boolean mIsVisible;
   private IAmraidWebView$c mListenerInfo;
   private IAmraidWebViewController mMraidController;
   private final IAmraidWebView$MraidPlacementType mPlacementType;
   private com.inneractive.api.ads.sdk.as mWebViewClient;

   IAmraidWebView(Context var1, com.inneractive.api.ads.sdk.a var2, IAmraidWebView$MraidPlacementType var3) {
      boolean var4 = false;
      super(var1, var2);
      this.mHasFiredReadyEvent = false;
      this.mPlacementType = var3;
      this.mHandler = new Handler();
      this.mGestDetector = new com.inneractive.api.ads.sdk.x(var1, this, var2);
      this.mGestDetector.a((x$a)this);
      if(this.getVisibility() == 0) {
         var4 = true;
      }

      this.mIsVisible = var4;
      this.addCloseHTML5VideoInterface();
      this.addUriJavascriptInterface();
   }

   private void postHandlerRunnable(Runnable var1) {
      this.mHandler.post(var1);
   }

   final void addCloseHTML5VideoInterface() {
      this.addJavascriptInterface(new Object() {
         @JavascriptInterface
         public final void closeHTML5Video() {
            IAmraidWebView.this.postDelayed(new Runnable() {
               public final void run() {
                  if(IAmraidWebView.this.mWebChromeClient != null) {
                     IAmraidWebView.this.mWebChromeClient.onHideCustomView();
                     InneractiveAdView$Log.a("native closeHTML5VideoInterface started");
                  }

               }
            }, 1000L);
         }
      }, "InneractiveCloseHTML5VideoInterface");
   }

   final void addUriJavascriptInterface() {
      this.addJavascriptInterface(new Object() {
         @JavascriptInterface
         public final boolean receiveJavascriptAdWidth(final String var1) {
            InneractiveAdView$Log.d("workaround ad zoom");
            InneractiveAdView$Log.d("width JS :" + var1);
            if(Integer.parseInt(var1) != 0) {
               InneractiveAdView$Log.d("width WebView: " + String.valueOf(IAmraidWebView.this.getWidth()));
               var1 = String.valueOf(IAmraidWebView.this.getWidth() / Integer.parseInt(var1));
               InneractiveAdView$Log.d("workaround ad zoom: " + var1);
               IAmraidWebView.this.postHandlerRunnable(new Runnable() {
                  public final void run() {
                     IAmraidWebView.this.loadUrl("javascript:document.body.style.zoom=" + var1);
                  }
               });
            }

            return true;
         }
      }, "UriJavascriptInterface");
   }

   final void closeHTML5VideoFullScreenViaJS() {
      this.loadUrl("javascript:(function() { \n\twindow.console.log(\'Exiting HTML5 video full-screen!\'); \n\tvar videos = document.getElementsByTagName(\'video\'); \n\tvar removeListreners = function(video) { \n\t\tvideo.removeEventListener(\'ended\'); \n\t}; \n\t \n\tif (videos.length > 0) { \n\t\tvar video = videos[0]; \n\t\tif (video != null) { \n\t\t\twindow.console.log(\'Got <video> instance! Pausing.\'); \n\t\t\tvideo.pause(); \n\t\t} else { \n\t\t\twindow.console.log(\'video reference is null!\'); \n\t\t} \n\t} \n\tif (typeof InneractiveCloseHTML5VideoInterface !== \'undefined\') {InneractiveCloseHTML5VideoInterface.closeHTML5Video();console.log(\'closing HTML 5 video natively\');} \n})();");
   }

   public final void destroy() {
      this.mMraidController.destroy();
      super.destroy();
   }

   protected final void fireChangeEventForAsset(com.inneractive.api.ads.sdk.R var1) {
      String var2 = "{" + var1.toString() + "}";
      this.injectJavaScript("window.mraidbridge.fireChangeEvent(" + var2 + ");");
      InneractiveAdView$Log.d("Fire changes: " + var2);
   }

   protected final void fireChangeEventForAssets(ArrayList var1) {
      String var2 = var1.toString();
      if(var2.length() >= 2) {
         var2 = "{" + var2.substring(1, var2.length() - 1) + "}";
         this.injectJavaScript("window.mraidbridge.fireChangeEvent(" + var2 + ");");
         InneractiveAdView$Log.d("Fire changes: " + var2);
      }
   }

   protected final void fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand var1, String var2) {
      String var3 = var1.a();
      this.injectJavaScript("window.mraidbridge.fireErrorEvent(\'" + var3 + "\', \'" + var2 + "\');");
   }

   protected final void fireNativeCommandCompleteEvent(String var1) {
      this.injectJavaScript("window.mraidbridge.nativeCallComplete(\'" + var1 + "\');");
   }

   protected final void fireReadyEvent() {
      this.injectJavaScript("window.mraidbridge.fireReadyEvent();");
   }

   protected final InneractiveInternalBrowserActivity getBrowserController() {
      return this.mInternalBrowserActivity;
   }

   final boolean getIsVisible() {
      return this.mIsVisible;
   }

   public final com.inneractive.api.ads.sdk.at getListener() {
      return IAmraidWebView$c.access$100(this.mListenerInfo);
   }

   protected final IAmraidWebViewController getMraidWebViewController() {
      return this.mMraidController;
   }

   final IAmraidWebView$d getOnCloseButtonStateChangeListener() {
      return IAmraidWebView$c.access$200(this.mListenerInfo);
   }

   final com.inneractive.api.ads.sdk.as getmWebViewClient() {
      return this.mWebViewClient;
   }

   final void initialize(IAmraidWebView$ExpandMode var1, IAmraidWebView$NativeCloseButtonMode var2) {
      this.setScrollContainer(false);
      this.setOnTouchListener(new OnTouchListener() {
         public final boolean onTouch(View var1, MotionEvent var2) {
            IAmraidWebView.this.mGestDetector.a(var2);
            switch(var2.getAction()) {
            case 0:
            case 1:
               if(var1 != null && !var1.hasFocus()) {
                  var1.requestFocus();
               }
            default:
               return false;
            }
         }
      });
      this.mInternalBrowserActivity = new InneractiveInternalBrowserActivity();
      InneractiveInternalBrowserActivity.a((InneractiveInternalBrowserActivity$a)this);
      this.mMraidController = new IAmraidWebViewController(this, var1, var2);
      this.mListenerInfo = new IAmraidWebView$c();
      this.mWebViewClient = new com.inneractive.api.ads.sdk.as(this);
      this.setWebViewClient(this.mWebViewClient);
   }

   protected final void injectJavaScript(String var1) {
      if(var1 != null) {
         super.loadUrl("javascript:" + var1);
      }

   }

   final void onAdReadyDOM() {
      boolean var1;
      if(this.getVisibility() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.mIsVisible = var1;
      this.fireChangeEventForAsset(com.inneractive.api.ads.sdk.X.a(this.mIsVisible));
   }

   final void onAdReadyWindowOnLoad() {
      boolean var1;
      if(this.getVisibility() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.mIsVisible = var1;
      this.fireChangeEventForAsset(com.inneractive.api.ads.sdk.X.a(this.mIsVisible));
      if(!this.mHasFiredReadyEvent) {
         this.mMraidController.initializeJavaScriptState();
         this.fireChangeEventForAsset(new com.inneractive.api.ads.sdk.T(this.mPlacementType));
         this.injectJavaScript("window.mraidbridge.fireReadyEvent();");
         if(this.getListener() != null) {
            this.getListener().onReady(this);
         }
      }

      this.mHasFiredReadyEvent = true;
   }

   public final void onApplicationInBackground() {
      if(this.getListener() != null) {
         this.getListener().onAdWillOpenExternalApp();
      }

   }

   public final void onInternalBrowserDismissed() {
      if(this.getListener() != null) {
         this.getListener().onInternalBrowserDismissed();
      }

   }

   protected final void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      boolean var3;
      if(var2 == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(var3 != this.mIsVisible) {
         this.mIsVisible = var3;
         if(this.mHasFiredReadyEvent) {
            this.fireChangeEventForAsset(com.inneractive.api.ads.sdk.X.a(this.mIsVisible));
         }
      }

   }

   public final void setListener(com.inneractive.api.ads.sdk.at var1) {
      IAmraidWebView$c.access$102(this.mListenerInfo, var1);
   }

   final void setOnCloseButtonStateChange(IAmraidWebView$d var1) {
      IAmraidWebView$c.access$202(this.mListenerInfo, var1);
   }

   final boolean tryCommand(URI var1) {
      String var2 = var1.getHost();
      List var3 = URLEncodedUtils.parse(var1, "UTF-8");
      HashMap var5 = new HashMap();
      Iterator var7 = var3.iterator();

      while(var7.hasNext()) {
         NameValuePair var4 = (NameValuePair)var7.next();
         var5.put(var4.getName(), var4.getValue());
      }

      com.inneractive.api.ads.sdk.A var6 = IAmraidActionFactory.a(var2, var5, this);
      if(var6 == null) {
         this.fireNativeCommandCompleteEvent(var2);
         return false;
      } else if(var6.a(this.mPlacementType) && !this.wasClicked()) {
         return false;
      } else {
         var6.a();
         this.fireNativeCommandCompleteEvent(var2);
         return true;
      }
   }
}
