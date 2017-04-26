package com.inneractive.api.ads.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inneractive.api.ads.sdk.IAbaseWebView$a;
import com.inneractive.api.ads.sdk.IAdefines$ApiLevel;
import com.inneractive.api.ads.sdk.IAreflectionHandler$a;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.x$a;
import java.io.IOException;
import java.net.URI;

class IAbaseWebView extends WebView implements x$a {
   static String playerState = "IDLE";
   com.inneractive.api.ads.sdk.a mAdConfig;
   boolean mClicked;
   Context mContext;
   private BroadcastReceiver mScreenStateReceiver;
   IAbaseWebView$a mWebChromeClient;

   IAbaseWebView(Context var1, com.inneractive.api.ads.sdk.a var2) {
      super(var1);
      this.mContext = var1;
      this.mAdConfig = var2;
      this.blockZoomAndScroll();
      WebSettings var4 = this.getSettings();
      var4.setJavaScriptEnabled(true);
      var4.setLoadsImagesAutomatically(true);
      var4.setJavaScriptCanOpenWindowsAutomatically(true);
      this.enablePlugins(true);
      this.setFocusable(true);
      this.setBackgroundColor(0);
      this.setChromeClient(this);

      try {
         if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.i)) {
            (new IAreflectionHandler$a(this, "setWebContentsDebuggingEnabled")).a(Boolean.TYPE, Boolean.valueOf(true)).a();
         }
      } catch (Exception var3) {
         InneractiveAdView$Log.a("Could not set web contents debugging flag");
      }

      this.registerScreenMode();
   }

   private void blockZoomAndScroll() {
      this.setHorizontalScrollBarEnabled(false);
      this.setHorizontalScrollbarOverlay(false);
      this.setVerticalScrollBarEnabled(false);
      this.setVerticalScrollbarOverlay(false);
      this.getSettings().setSupportZoom(false);
   }

   private void registerScreenMode() {
      this.mScreenStateReceiver = new BroadcastReceiver() {
         public final void onReceive(Context var1, Intent var2) {
            InneractiveAdView$Log.d("onReceive. action = " + var2.getAction());
            "android.intent.action.SCREEN_OFF".equals(var2.getAction());
         }
      };
      IntentFilter var1 = new IntentFilter("android.intent.action.SCREEN_OFF");
      var1.addAction("android.intent.action.USER_PRESENT");
      this.mContext.registerReceiver(this.mScreenStateReceiver, var1);
   }

   static void setPlayerState(String var0) {
      playerState = var0;
   }

   private void unregisterScreenMode() {
      try {
         this.mContext.unregisterReceiver(this.mScreenStateReceiver);
      } catch (Exception var2) {
         InneractiveAdView$Log.a("Broadcast receiver was not registered and therfore won\'t be released.");
      }
   }

   public void destroy() {
      this.unregisterScreenMode();
      com.inneractive.api.ads.sdk.an.a((View)this);
      super.destroy();
   }

   protected void enablePlugins(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   com.inneractive.api.ads.sdk.a getAdConfig() {
      return this.mAdConfig;
   }

   public com.inneractive.api.ads.sdk.at getListener() {
      return null;
   }

   String getResponseFromLocalFile(String var1) {
      InneractiveAdView$Log.a("Try to read response from file: " + var1);
      AssetManager var2 = this.mContext.getAssets();

      try {
         var1 = com.inneractive.api.ads.sdk.an.a(var2.open(var1));
         return var1;
      } catch (IOException var3) {
         InneractiveAdView$Log.a("Could not read response from file");
         InneractiveAdView$Log.d(com.inneractive.api.ads.sdk.an.a((Exception)var3));
         return "";
      }
   }

   void invokeJS(String var1) {
      if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.i)) {
         InneractiveAdView$Log.d("Javascript to invoke (KitKat): " + var1.substring(11));

         try {
            ValueCallback var2 = new ValueCallback() {
               // $FF: synthetic method
               public final void onReceiveValue(Object var1) {
                  String var2 = (String)var1;
                  InneractiveAdView$Log.a("Javascript callback (KitKat): " + var2);
               }
            };
            (new IAreflectionHandler$a(this, "evaluateJavascript")).a(String.class, var1).a(ValueCallback.class, var2).a();
         } catch (Exception var3) {
            InneractiveAdView$Log.a("Failed to invoke Javascript (KITKAT)");
         }
      } else {
         InneractiveAdView$Log.a("Javascript to invoke: " + var1);
         super.loadUrl(var1);
      }
   }

   void loadHtmlData(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void loadUrl(String var1) {
      if(var1 != null) {
         if(var1.startsWith("javascript:")) {
            this.invokeJS(var1);
         } else {
            super.loadUrl(var1);
         }
      }
   }

   void onAdReadyDOM() {
   }

   void onAdReadyWindowOnLoad() {
   }

   public void onClickOccurs() {
      this.mClicked = true;
   }

   public void onResetClick() {
      this.mClicked = false;
   }

   protected void onWindowVisibilityChanged(int var1) {
   }

   void performVastAutoclick() {
      if(playerState != null && ("PAUSED".equals(playerState) || "IDLE".equals(playerState))) {
         InneractiveAdView$Log.d("Player state is: " + playerState + ". Simulating manual click.");
         this.post(new Runnable() {
            public final void run() {
               MotionEvent var1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100L, 0, (float)(com.inneractive.api.ads.sdk.an.b(IAbaseWebView.this.mContext) / 2), (float)(com.inneractive.api.ads.sdk.an.a(IAbaseWebView.this.mContext) / 2), 0);
               InneractiveAdView$Log.d(" --> before dipatchTouch");
               IAbaseWebView.this.dispatchTouchEvent(var1);
               InneractiveAdView$Log.d(" --> after dipatchTouch");
               IAbaseWebView.this.post(new Runnable() {
                  // $FF: synthetic field
                  private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

                  public final void run() {
                     InneractiveAdView$Log.d("performVastAutoclick --> 2");
                     MotionEvent var1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100L, 1, (float)(com.inneractive.api.ads.sdk.an.b(IAbaseWebView.this.mContext) / 2), (float)(com.inneractive.api.ads.sdk.an.a(IAbaseWebView.this.mContext) / 2), 0);
                     InneractiveAdView$Log.d("second post delayed --> before dipatchTouch");
                     IAbaseWebView.this.dispatchTouchEvent(var1);
                     InneractiveAdView$Log.d("second post delayed --> after dipatchTouch");
                  }
               });
            }
         });
         if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.b)) {
            InneractiveAdView$Log.d("Player state is: " + playerState + ". Android Version is higher or equal to: GINGERBREAD. Simulating javascript click.");
            this.loadUrl("javascript:(function(){ \n   var playerstate = iaVideoPlayer.getState(); \n   window.console.log(\'PLAYERSTATE = \' + playerstate); \n\tvar iaVastTimeEventListener = function(time) { \nif(playerstate === \'IDLE\'){        window.console.log(\'IDLE case. need to setPlayPause and then play.\'); \n\t\tiaVideoPlayer.setPlayPause(); \n\t\twindow.console.log(\'--> setPlayPause\'); \n\t\tiaVideoPlayer.setPlay(); \n\t\twindow.console.log(\'--> setPlay\'); \n       window.console.log(\'time= \' + time); \n\t\tiaVideoPlayer.removeListener(\'time\', iaVastTimeEventListener); \n\t\twindow.console.log(\'iaVastTimeEventListener IS REMOVED\'); \n\t}};\tiaVideoPlayer.addListener(\'time\', iaVastTimeEventListener); \n})();");
         }
      }

   }

   void setChromeClient(WebView var1) {
      this.mWebChromeClient = new IAbaseWebView$a(this);
      var1.setWebChromeClient(this.mWebChromeClient);
   }

   public void setListener(com.inneractive.api.ads.sdk.at var1) {
   }

   boolean tryCommand(URI var1) {
      return false;
   }

   public boolean wasClicked() {
      return this.mClicked;
   }
}
