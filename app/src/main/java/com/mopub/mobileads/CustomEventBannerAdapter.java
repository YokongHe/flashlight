package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.Map;
import java.util.TreeMap;

public class CustomEventBannerAdapter implements CustomEventBanner$CustomEventBannerListener {
   public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;
   private Context mContext;
   private CustomEventBanner mCustomEventBanner;
   private final Handler mHandler;
   private boolean mInvalidated;
   private Map mLocalExtras;
   private MoPubView mMoPubView;
   private Map mServerExtras;
   private boolean mStoredAutorefresh;
   private final Runnable mTimeout;

   public CustomEventBannerAdapter(MoPubView var1, String var2, Map var3, long var4, AdReport var6) {
      Preconditions.checkNotNull(var3);
      this.mHandler = new Handler();
      this.mMoPubView = var1;
      this.mContext = var1.getContext();
      this.mTimeout = new Runnable() {
         public void run() {
            MoPubLog.d("Third-party network timed out.");
            CustomEventBannerAdapter.this.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            CustomEventBannerAdapter.this.invalidate();
         }
      };
      MoPubLog.d("Attempting to invoke custom event: " + var2);

      try {
         this.mCustomEventBanner = CustomEventBannerFactory.create(var2);
      } catch (Exception var7) {
         MoPubLog.d("Couldn\'t locate or instantiate custom event: " + var2 + ".");
         this.mMoPubView.loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
         return;
      }

      this.mServerExtras = new TreeMap(var3);
      this.mLocalExtras = this.mMoPubView.getLocalExtras();
      if(this.mMoPubView.getLocation() != null) {
         this.mLocalExtras.put("location", this.mMoPubView.getLocation());
      }

      this.mLocalExtras.put("broadcastIdentifier", Long.valueOf(var4));
      this.mLocalExtras.put("mopub-intent-ad-report", var6);
   }

   private void cancelTimeout() {
      this.mHandler.removeCallbacks(this.mTimeout);
   }

   private int getTimeoutDelayMilliseconds() {
      return this.mMoPubView != null && this.mMoPubView.getAdTimeoutDelay() != null && this.mMoPubView.getAdTimeoutDelay().intValue() >= 0?this.mMoPubView.getAdTimeoutDelay().intValue() * 1000:10000;
   }

   void invalidate() {
      if(this.mCustomEventBanner != null) {
         this.mCustomEventBanner.onInvalidate();
      }

      this.mContext = null;
      this.mCustomEventBanner = null;
      this.mLocalExtras = null;
      this.mServerExtras = null;
      this.mInvalidated = true;
   }

   boolean isInvalidated() {
      return this.mInvalidated;
   }

   void loadAd() {
      if(!this.isInvalidated() && this.mCustomEventBanner != null) {
         if(this.getTimeoutDelayMilliseconds() > 0) {
            this.mHandler.postDelayed(this.mTimeout, (long)this.getTimeoutDelayMilliseconds());
         }

         this.mCustomEventBanner.loadBanner(this.mContext, this, this.mLocalExtras, this.mServerExtras);
      }
   }

   public void onBannerClicked() {
      if(!this.isInvalidated() && this.mMoPubView != null) {
         this.mMoPubView.registerClick();
      }
   }

   public void onBannerCollapsed() {
      if(!this.isInvalidated()) {
         this.mMoPubView.setAutorefreshEnabled(this.mStoredAutorefresh);
         this.mMoPubView.adClosed();
      }
   }

   public void onBannerExpanded() {
      if(!this.isInvalidated()) {
         this.mStoredAutorefresh = this.mMoPubView.getAutorefreshEnabled();
         this.mMoPubView.setAutorefreshEnabled(false);
         this.mMoPubView.adPresentedOverlay();
      }
   }

   public void onBannerFailed(MoPubErrorCode var1) {
      if(!this.isInvalidated() && this.mMoPubView != null) {
         MoPubErrorCode var2 = var1;
         if(var1 == null) {
            var2 = MoPubErrorCode.UNSPECIFIED;
         }

         this.cancelTimeout();
         this.mMoPubView.loadFailUrl(var2);
      }
   }

   public void onBannerLoaded(View var1) {
      if(!this.isInvalidated()) {
         this.cancelTimeout();
         if(this.mMoPubView != null) {
            this.mMoPubView.nativeAdLoaded();
            this.mMoPubView.setAdContentView(var1);
            if(!(var1 instanceof HtmlBannerWebView)) {
               this.mMoPubView.trackNativeImpression();
               return;
            }
         }
      }

   }

   public void onLeaveApplication() {
      this.onBannerClicked();
   }
}
