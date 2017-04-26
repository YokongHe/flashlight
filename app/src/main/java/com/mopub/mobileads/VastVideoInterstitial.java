package com.mopub.mobileads;

import com.mopub.common.CacheService;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.mobileads.util.vast.VastManager;
import com.mopub.mobileads.util.vast.VastManager$VastManagerListener;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;
import java.util.Map;

class VastVideoInterstitial extends ResponseBodyInterstitial implements VastManager$VastManagerListener {
   private CustomEventInterstitial$CustomEventInterstitialListener mCustomEventInterstitialListener;
   private VastManager mVastManager;
   private String mVastResponse;
   private VastVideoConfiguration mVastVideoConfiguration;

   protected void extractExtras(Map var1) {
      this.mVastResponse = (String)var1.get("Html-Response-Body");
   }

   @Deprecated
   String getVastResponse() {
      return this.mVastResponse;
   }

   public void onInvalidate() {
      if(this.mVastManager != null) {
         this.mVastManager.cancel();
      }

      super.onInvalidate();
   }

   public void onVastVideoConfigurationPrepared(VastVideoConfiguration var1) {
      if(var1 == null) {
         this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
      } else {
         this.mVastVideoConfiguration = var1;
         this.mCustomEventInterstitialListener.onInterstitialLoaded();
      }
   }

   protected void preRenderHtml(CustomEventInterstitial$CustomEventInterstitialListener var1) {
      this.mCustomEventInterstitialListener = var1;
      if(!CacheService.initializeDiskCache(this.mContext)) {
         this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
      } else {
         this.mVastManager = VastManagerFactory.create(this.mContext);
         this.mVastManager.prepareVastVideoConfiguration(this.mVastResponse, this);
      }
   }

   @Deprecated
   void setVastManager(VastManager var1) {
      this.mVastManager = var1;
   }

   public void showInterstitial() {
      MraidVideoPlayerActivity.startVast(this.mContext, this.mVastVideoConfiguration, this.mBroadcastIdentifier);
   }
}
