package com.adsdk.sdk.banner;

import com.adsdk.sdk.banner.AdView;
import java.util.TimerTask;

class ReloadTask extends TimerTask {
   private final AdView mWebView;

   public ReloadTask(AdView var1) {
      this.mWebView = var1;
   }

   public void run() {
      this.mWebView.loadNextAd();
   }
}
