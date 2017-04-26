package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import java.util.Map;

public class HtmlInterstitial extends ResponseBodyInterstitial {
   private String mClickthroughUrl;
   private String mHtmlData;
   private boolean mIsScrollable;
   private String mRedirectUrl;

   protected void extractExtras(Map var1) {
      this.mHtmlData = (String)var1.get("Html-Response-Body");
      this.mIsScrollable = Boolean.valueOf((String)var1.get("Scrollable")).booleanValue();
      this.mRedirectUrl = (String)var1.get("Redirect-Url");
      this.mClickthroughUrl = (String)var1.get("Clickthrough-Url");
   }

   protected void preRenderHtml(CustomEventInterstitial$CustomEventInterstitialListener var1) {
      MoPubActivity.preRenderHtml(this.mContext, this.mAdReport, var1, this.mHtmlData);
   }

   public void showInterstitial() {
      MoPubActivity.start(this.mContext, this.mHtmlData, this.mAdReport, this.mIsScrollable, this.mRedirectUrl, this.mClickthroughUrl, this.mBroadcastIdentifier);
   }
}
