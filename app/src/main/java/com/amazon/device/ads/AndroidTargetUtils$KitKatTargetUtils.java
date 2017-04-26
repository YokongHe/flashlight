package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.amazon.device.ads.ThreadUtils;

@TargetApi(19)
class AndroidTargetUtils$KitKatTargetUtils {
   public static void enableWebViewDebugging(final boolean var0) {
      ThreadUtils.executeOnMainThread(new Runnable() {
         public final void run() {
            WebView.setWebContentsDebuggingEnabled(var0);
         }
      });
   }
}
