package com.mopub.mraid;

import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import java.util.Map;

class MraidInterstitial extends ResponseBodyInterstitial {
   private String mHtmlData;

   protected void extractExtras(Map var1) {
      this.mHtmlData = (String)var1.get("Html-Response-Body");
   }

   protected void preRenderHtml(CustomEventInterstitial$CustomEventInterstitialListener var1) {
      MraidActivity.preRenderHtml(this.mContext, var1, this.mHtmlData);
   }

   public void showInterstitial() {
      MraidActivity.start(this.mContext, this.mAdReport, this.mHtmlData, this.mBroadcastIdentifier);
   }
}
