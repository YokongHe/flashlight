package com.amazon.device.ads;

import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdError$ErrorCode;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.InterstitialAd;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.RelativePosition;

class InterstitialAd$InterstitialAdControlCallback implements AdControlCallback {
   private AdProperties adProperties;
   // $FF: synthetic field
   final InterstitialAd this$0;

   InterstitialAd$InterstitialAdControlCallback(InterstitialAd var1) {
      this.this$0 = var1;
   }

   public int adClosing() {
      this.this$0.handleDismissed();
      return 1;
   }

   public boolean isAdReady(boolean var1) {
      return this.this$0.isReadyToLoad();
   }

   public void onAdEvent(AdEvent var1) {
   }

   public void onAdFailed(AdError var1) {
      if(AdError$ErrorCode.NETWORK_TIMEOUT.equals(var1.getCode())) {
         InterstitialAd.access$302(this.this$0, (AdController)null);
      }

      this.this$0.callOnAdFailedOnMainThread(var1);
   }

   public void onAdLoaded(AdProperties var1) {
      this.adProperties = var1;
      InterstitialAd.access$100(this.this$0);
      InterstitialAd.access$200(this.this$0).enableNativeCloseButton(true, RelativePosition.TOP_RIGHT);
      InterstitialAd.access$200(this.this$0).render();
   }

   public void onAdRendered() {
      this.this$0.callOnAdLoadedOnMainThread(this.adProperties);
   }

   public void postAdRendered() {
      InterstitialAd.access$400(this.this$0).startMetric(Metrics$MetricType.AD_LOADED_TO_AD_SHOW_TIME);
   }
}
