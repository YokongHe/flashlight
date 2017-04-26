package com.mopub.mobileads;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebSettings.PluginState;
import com.mopub.common.util.VersionCode;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;

public class BaseWebView extends WebView {
   private static boolean sDeadlockCleared = false;
   protected boolean mIsDestroyed;

   public BaseWebView(Context var1) {
      super(var1.getApplicationContext());
      this.enablePlugins(false);
      WebViews.setDisableJSChromeClient(this);
      if(!sDeadlockCleared) {
         this.clearWebViewDeadlock(this.getContext());
         sDeadlockCleared = true;
      }

   }

   private void clearWebViewDeadlock(Context var1) {
      if(VERSION.SDK_INT == 19) {
         WebView var2 = new WebView(var1.getApplicationContext());
         var2.setBackgroundColor(0);
         var2.loadDataWithBaseURL((String)null, "", "text/html", "UTF-8", (String)null);
         LayoutParams var3 = new LayoutParams();
         var3.width = 1;
         var3.height = 1;
         var3.type = 2005;
         var3.flags = 16777240;
         var3.format = -2;
         var3.gravity = 8388659;
         ((WindowManager)var1.getSystemService("window")).addView(var2, var3);
      }

   }

   public void destroy() {
      this.mIsDestroyed = true;
      Views.removeFromParent(this);
      this.removeAllViews();
      super.destroy();
   }

   protected void enablePlugins(boolean var1) {
      if(!VersionCode.currentApiLevel().isAtLeast(VersionCode.JELLY_BEAN_MR2)) {
         if(var1) {
            this.getSettings().setPluginState(PluginState.ON);
         } else {
            this.getSettings().setPluginState(PluginState.OFF);
         }
      }
   }

   @Deprecated
   void setIsDestroyed(boolean var1) {
      this.mIsDestroyed = var1;
   }
}
