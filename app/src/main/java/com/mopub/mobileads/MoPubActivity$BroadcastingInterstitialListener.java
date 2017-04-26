package com.mopub.mobileads;

import com.mopub.mobileads.BaseInterstitialActivity$JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.EventForwardingBroadcastReceiver;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MoPubErrorCode;

class MoPubActivity$BroadcastingInterstitialListener implements CustomEventInterstitial$CustomEventInterstitialListener {
   // $FF: synthetic field
   final MoPubActivity this$0;

   MoPubActivity$BroadcastingInterstitialListener(MoPubActivity var1) {
      this.this$0 = var1;
   }

   public void onInterstitialClicked() {
      EventForwardingBroadcastReceiver.broadcastAction(this.this$0, this.this$0.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.click");
   }

   public void onInterstitialDismissed() {
   }

   public void onInterstitialFailed(MoPubErrorCode var1) {
      EventForwardingBroadcastReceiver.broadcastAction(this.this$0, this.this$0.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.fail");
      this.this$0.finish();
   }

   public void onInterstitialLoaded() {
      MoPubActivity.access$0(this.this$0).loadUrl(BaseInterstitialActivity$JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
   }

   public void onInterstitialShown() {
   }

   public void onLeaveApplication() {
   }
}
