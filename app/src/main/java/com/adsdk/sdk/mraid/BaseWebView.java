package com.adsdk.sdk.mraid;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.adsdk.sdk.mraid.WebViews;

public class BaseWebView extends WebView {
   public BaseWebView(Context var1) {
      super(var1.getApplicationContext());
      this.enablePlugins(false);
      WebViews.setDisableJSChromeClient(this);
   }

   public void destroy() {
      if(this.getParent() != null && this.getParent() instanceof ViewGroup) {
         ((ViewGroup)this.getParent()).removeView(this);
      }

      super.destroy();
   }

   protected void enablePlugins(boolean param1) {
      // $FF: Couldn't be decompiled
   }
}
