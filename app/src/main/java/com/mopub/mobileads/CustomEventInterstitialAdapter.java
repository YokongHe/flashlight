package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.CustomEventInterstitialAdapter$CustomEventInterstitialAdapterListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import java.util.Map;
import java.util.TreeMap;

public class CustomEventInterstitialAdapter implements CustomEventInterstitial$CustomEventInterstitialListener {
   public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;
   private Context mContext;
   private CustomEventInterstitial mCustomEventInterstitial;
   private CustomEventInterstitialAdapter$CustomEventInterstitialAdapterListener mCustomEventInterstitialAdapterListener;
   private final Handler mHandler;
   private boolean mInvalidated;
   private Map mLocalExtras;
   private final MoPubInterstitial mMoPubInterstitial;
   private Map mServerExtras;
   private final Runnable mTimeout;

   public CustomEventInterstitialAdapter(MoPubInterstitial var1, String var2, Map var3, long var4, AdReport var6) {
      Preconditions.checkNotNull(var3);
      this.mHandler = new Handler();
      this.mMoPubInterstitial = var1;
      this.mContext = this.mMoPubInterstitial.getActivity();
      this.mTimeout = new Runnable() {
         public void run() {
            MoPubLog.d("Third-party network timed out.");
            CustomEventInterstitialAdapter.this.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            CustomEventInterstitialAdapter.this.invalidate();
         }
      };
      MoPubLog.d("Attempting to invoke custom event: " + var2);

      try {
         this.mCustomEventInterstitial = CustomEventInterstitialFactory.create(var2);
      } catch (Exception var7) {
         MoPubLog.d("Couldn\'t locate or instantiate custom event: " + var2 + ".");
         this.mMoPubInterstitial.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
         return;
      }

      this.mServerExtras = new TreeMap(var3);
      this.mLocalExtras = this.mMoPubInterstitial.getLocalExtras();
      if(this.mMoPubInterstitial.getLocation() != null) {
         this.mLocalExtras.put("location", this.mMoPubInterstitial.getLocation());
      }

      this.mLocalExtras.put("broadcastIdentifier", Long.valueOf(var4));
      this.mLocalExtras.put("mopub-intent-ad-report", var6);
   }

   private void cancelTimeout() {
      this.mHandler.removeCallbacks(this.mTimeout);
   }

   private int getTimeoutDelayMilliseconds() {
      return this.mMoPubInterstitial != null && this.mMoPubInterstitial.getAdTimeoutDelay() != null && this.mMoPubInterstitial.getAdTimeoutDelay().intValue() >= 0?this.mMoPubInterstitial.getAdTimeoutDelay().intValue() * 1000:30000;
   }

   void invalidate() {
      if(this.mCustomEventInterstitial != null) {
         this.mCustomEventInterstitial.onInvalidate();
      }

      this.mCustomEventInterstitial = null;
      this.mContext = null;
      this.mServerExtras = null;
      this.mLocalExtras = null;
      this.mCustomEventInterstitialAdapterListener = null;
      this.mInvalidated = true;
   }

   boolean isInvalidated() {
      return this.mInvalidated;
   }

   void loadInterstitial() {
      if(!this.isInvalidated() && this.mCustomEventInterstitial != null) {
         if(this.getTimeoutDelayMilliseconds() > 0) {
            this.mHandler.postDelayed(this.mTimeout, (long)this.getTimeoutDelayMilliseconds());
         }

         this.mCustomEventInterstitial.loadInterstitial(this.mContext, this, this.mLocalExtras, this.mServerExtras);
      }
   }

   public void onInterstitialClicked() {
      if(!this.isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
         this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialClicked();
      }
   }

   public void onInterstitialDismissed() {
      if(!this.isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
         this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialDismissed();
      }
   }

   public void onInterstitialFailed(MoPubErrorCode var1) {
      if(!this.isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
         MoPubErrorCode var2 = var1;
         if(var1 == null) {
            var2 = MoPubErrorCode.UNSPECIFIED;
         }

         this.cancelTimeout();
         this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialFailed(var2);
      }
   }

   public void onInterstitialLoaded() {
      if(!this.isInvalidated()) {
         this.cancelTimeout();
         if(this.mCustomEventInterstitialAdapterListener != null) {
            this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialLoaded();
            return;
         }
      }

   }

   public void onInterstitialShown() {
      if(!this.isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
         this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialShown();
      }
   }

   public void onLeaveApplication() {
      this.onInterstitialClicked();
   }

   void setAdapterListener(CustomEventInterstitialAdapter$CustomEventInterstitialAdapterListener var1) {
      this.mCustomEventInterstitialAdapterListener = var1;
   }

   @Deprecated
   void setCustomEventInterstitial(CustomEventInterstitial var1) {
      this.mCustomEventInterstitial = var1;
   }

   void showInterstitial() {
      if(!this.isInvalidated() && this.mCustomEventInterstitial != null) {
         this.mCustomEventInterstitial.showInterstitial();
      }
   }
}
