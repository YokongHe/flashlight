package com.mopub.mobileads;

import android.app.Activity;
import android.location.Location;
import com.mopub.common.LocationService$LocationAwareness;
import com.mopub.common.MoPub;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.CustomEventInterstitialAdapter$CustomEventInterstitialAdapterListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener;
import com.mopub.mobileads.MoPubInterstitial$InterstitialState;
import com.mopub.mobileads.MoPubInterstitial$MoPubInterstitialListener;
import com.mopub.mobileads.MoPubInterstitial$MoPubInterstitialView;
import com.mopub.mobileads.MoPubView$BannerAdListener;
import java.util.Map;

public class MoPubInterstitial implements CustomEventInterstitialAdapter$CustomEventInterstitialAdapterListener {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$mopub$mobileads$MoPubInterstitial$InterstitialState;
   private Activity mActivity;
   private String mAdUnitId;
   private MoPubInterstitial$InterstitialState mCurrentInterstitialState;
   private CustomEventInterstitialAdapter mCustomEventInterstitialAdapter;
   private MoPubInterstitial$InterstitialAdListener mInterstitialAdListener;
   private MoPubInterstitial$MoPubInterstitialView mInterstitialView;
   private boolean mIsDestroyed;
   private MoPubInterstitial$MoPubInterstitialListener mListener;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$mopub$mobileads$MoPubInterstitial$InterstitialState() {
      int[] var0 = $SWITCH_TABLE$com$mopub$mobileads$MoPubInterstitial$InterstitialState;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[MoPubInterstitial$InterstitialState.values().length];

         try {
            var0[MoPubInterstitial$InterstitialState.CUSTOM_EVENT_AD_READY.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[MoPubInterstitial$InterstitialState.NOT_READY.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$mopub$mobileads$MoPubInterstitial$InterstitialState = var0;
         return var0;
      }
   }

   public MoPubInterstitial(Activity var1, String var2) {
      this.mActivity = var1;
      this.mAdUnitId = var2;
      this.mInterstitialView = new MoPubInterstitial$MoPubInterstitialView(this, this.mActivity);
      this.mInterstitialView.setAdUnitId(this.mAdUnitId);
      this.mCurrentInterstitialState = MoPubInterstitial$InterstitialState.NOT_READY;
   }

   // $FF: synthetic method
   static CustomEventInterstitialAdapter access$0(MoPubInterstitial var0) {
      return var0.mCustomEventInterstitialAdapter;
   }

   // $FF: synthetic method
   static void access$1(MoPubInterstitial var0, CustomEventInterstitialAdapter var1) {
      var0.mCustomEventInterstitialAdapter = var1;
   }

   // $FF: synthetic method
   static MoPubInterstitial$InterstitialAdListener access$2(MoPubInterstitial var0) {
      return var0.mInterstitialAdListener;
   }

   private void resetCurrentInterstitial() {
      this.mCurrentInterstitialState = MoPubInterstitial$InterstitialState.NOT_READY;
      if(this.mCustomEventInterstitialAdapter != null) {
         this.mCustomEventInterstitialAdapter.invalidate();
         this.mCustomEventInterstitialAdapter = null;
      }

      this.mIsDestroyed = false;
   }

   private void showCustomEventInterstitial() {
      if(this.mCustomEventInterstitialAdapter != null) {
         this.mCustomEventInterstitialAdapter.showInterstitial();
      }

   }

   @Deprecated
   public void customEventActionWillBegin() {
      if(this.mInterstitialView != null) {
         this.mInterstitialView.registerClick();
      }

   }

   @Deprecated
   public void customEventDidFailToLoadAd() {
      if(this.mInterstitialView != null) {
         this.mInterstitialView.loadFailUrl(MoPubErrorCode.UNSPECIFIED);
      }

   }

   @Deprecated
   public void customEventDidLoadAd() {
      if(this.mInterstitialView != null) {
         this.mInterstitialView.trackImpression();
      }

   }

   public void destroy() {
      this.mIsDestroyed = true;
      if(this.mCustomEventInterstitialAdapter != null) {
         this.mCustomEventInterstitialAdapter.invalidate();
         this.mCustomEventInterstitialAdapter = null;
      }

      this.mInterstitialView.setBannerAdListener((MoPubView$BannerAdListener)null);
      this.mInterstitialView.destroy();
   }

   public void forceRefresh() {
      this.resetCurrentInterstitial();
      this.mInterstitialView.forceRefresh();
   }

   public Activity getActivity() {
      return this.mActivity;
   }

   Integer getAdTimeoutDelay() {
      return this.mInterstitialView.getAdTimeoutDelay();
   }

   public MoPubInterstitial$InterstitialAdListener getInterstitialAdListener() {
      return this.mInterstitialAdListener;
   }

   public String getKeywords() {
      return this.mInterstitialView.getKeywords();
   }

   @Deprecated
   public MoPubInterstitial$MoPubInterstitialListener getListener() {
      return this.mListener;
   }

   public Map getLocalExtras() {
      return this.mInterstitialView.getLocalExtras();
   }

   public Location getLocation() {
      return this.mInterstitialView.getLocation();
   }

   @Deprecated
   public LocationService$LocationAwareness getLocationAwareness() {
      return LocationService$LocationAwareness.fromMoPubLocationAwareness(MoPub.getLocationAwareness());
   }

   @Deprecated
   public int getLocationPrecision() {
      return MoPub.getLocationPrecision();
   }

   MoPubInterstitial$MoPubInterstitialView getMoPubInterstitialView() {
      return this.mInterstitialView;
   }

   public boolean getTesting() {
      return this.mInterstitialView.getTesting();
   }

   boolean isDestroyed() {
      return this.mIsDestroyed;
   }

   @Deprecated
   public boolean isFacebookSupported() {
      return false;
   }

   public boolean isReady() {
      return this.mCurrentInterstitialState.isReady();
   }

   public void load() {
      this.resetCurrentInterstitial();
      this.mInterstitialView.loadAd();
   }

   public void onCustomEventInterstitialClicked() {
      if(!this.isDestroyed()) {
         this.mInterstitialView.registerClick();
         if(this.mInterstitialAdListener != null) {
            this.mInterstitialAdListener.onInterstitialClicked(this);
            return;
         }
      }

   }

   public void onCustomEventInterstitialDismissed() {
      if(!this.isDestroyed()) {
         this.mCurrentInterstitialState = MoPubInterstitial$InterstitialState.NOT_READY;
         if(this.mInterstitialAdListener != null) {
            this.mInterstitialAdListener.onInterstitialDismissed(this);
            return;
         }
      }

   }

   public void onCustomEventInterstitialFailed(MoPubErrorCode var1) {
      if(!this.isDestroyed()) {
         this.mCurrentInterstitialState = MoPubInterstitial$InterstitialState.NOT_READY;
         this.mInterstitialView.loadFailUrl(var1);
      }
   }

   public void onCustomEventInterstitialLoaded() {
      if(!this.mIsDestroyed) {
         this.mCurrentInterstitialState = MoPubInterstitial$InterstitialState.CUSTOM_EVENT_AD_READY;
         if(this.mInterstitialAdListener != null) {
            this.mInterstitialAdListener.onInterstitialLoaded(this);
            return;
         }

         if(this.mListener != null) {
            this.mListener.OnInterstitialLoaded();
            return;
         }
      }

   }

   public void onCustomEventInterstitialShown() {
      if(!this.isDestroyed()) {
         this.mInterstitialView.trackImpression();
         if(this.mInterstitialAdListener != null) {
            this.mInterstitialAdListener.onInterstitialShown(this);
            return;
         }
      }

   }

   @Deprecated
   public void setFacebookSupported(boolean var1) {
   }

   public void setInterstitialAdListener(MoPubInterstitial$InterstitialAdListener var1) {
      this.mInterstitialAdListener = var1;
   }

   @Deprecated
   void setInterstitialView(MoPubInterstitial$MoPubInterstitialView var1) {
      this.mInterstitialView = var1;
   }

   public void setKeywords(String var1) {
      this.mInterstitialView.setKeywords(var1);
   }

   @Deprecated
   public void setListener(MoPubInterstitial$MoPubInterstitialListener var1) {
      this.mListener = var1;
   }

   public void setLocalExtras(Map var1) {
      this.mInterstitialView.setLocalExtras(var1);
   }

   @Deprecated
   public void setLocationAwareness(LocationService$LocationAwareness var1) {
      MoPub.setLocationAwareness(var1.getNewLocationAwareness());
   }

   @Deprecated
   public void setLocationPrecision(int var1) {
      MoPub.setLocationPrecision(var1);
   }

   public void setTesting(boolean var1) {
      this.mInterstitialView.setTesting(var1);
   }

   public boolean show() {
      switch($SWITCH_TABLE$com$mopub$mobileads$MoPubInterstitial$InterstitialState()[this.mCurrentInterstitialState.ordinal()]) {
      case 1:
         this.showCustomEventInterstitial();
         return true;
      default:
         return false;
      }
   }
}
