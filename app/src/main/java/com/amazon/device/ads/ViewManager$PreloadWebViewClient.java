package com.amazon.device.ads;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.ViewManager;

class ViewManager$PreloadWebViewClient extends WebViewClient {
   private final PreloadCallback callback;
   // $FF: synthetic field
   final ViewManager this$0;

   public ViewManager$PreloadWebViewClient(ViewManager var1, PreloadCallback var2) {
      this.this$0 = var1;
      this.callback = var2;
   }

   public void onPageFinished(WebView var1, String var2) {
      if(this.callback != null) {
         this.callback.onPreloadComplete(var2);
      }

   }
}
