package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.LocationService$LocationAwareness;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView$BannerAdListener;
import com.mopub.mobileads.MoPubView$OnAdClickedListener;
import com.mopub.mobileads.MoPubView$OnAdClosedListener;
import com.mopub.mobileads.MoPubView$OnAdFailedListener;
import com.mopub.mobileads.MoPubView$OnAdLoadedListener;
import com.mopub.mobileads.MoPubView$OnAdPresentedOverlayListener;
import com.mopub.mobileads.MoPubView$OnAdWillLoadListener;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import com.mopub.mobileads.factories.CustomEventBannerAdapterFactory;
import java.util.Map;
import java.util.TreeMap;

public class MoPubView extends FrameLayout {
   public static final int DEFAULT_LOCATION_PRECISION = 6;
   protected AdViewController mAdViewController;
   private MoPubView$BannerAdListener mBannerAdListener;
   private Context mContext;
   protected CustomEventBannerAdapter mCustomEventBannerAdapter;
   private MoPubView$OnAdClickedListener mOnAdClickedListener;
   private MoPubView$OnAdClosedListener mOnAdClosedListener;
   private MoPubView$OnAdFailedListener mOnAdFailedListener;
   private MoPubView$OnAdLoadedListener mOnAdLoadedListener;
   private MoPubView$OnAdPresentedOverlayListener mOnAdPresentedOverlayListener;
   private MoPubView$OnAdWillLoadListener mOnAdWillLoadListener;
   private BroadcastReceiver mScreenStateReceiver;
   private int mScreenVisibility;

   public MoPubView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public MoPubView(Context var1, AttributeSet var2) {
      super(var1, var2);
      ManifestUtils.checkWebViewActivitiesDeclared(var1);
      this.mContext = var1;
      this.mScreenVisibility = this.getVisibility();
      this.setHorizontalScrollBarEnabled(false);
      this.setVerticalScrollBarEnabled(false);
      if(WebViewDatabase.getInstance(var1) == null) {
         MoPubLog.e("Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:http://code.google.com/p/android/issues/detail?id=10789");
      } else {
         this.mAdViewController = AdViewControllerFactory.create(var1, this);
         this.registerScreenStateBroadcastReceiver();
      }
   }

   private void registerScreenStateBroadcastReceiver() {
      this.mScreenStateReceiver = new BroadcastReceiver() {
         public void onReceive(Context var1, Intent var2) {
            if(Visibility.isScreenVisible(MoPubView.this.mScreenVisibility) && var2 != null) {
               String var3 = var2.getAction();
               if("android.intent.action.USER_PRESENT".equals(var3)) {
                  MoPubView.this.setAdVisibility(0);
                  return;
               }

               if("android.intent.action.SCREEN_OFF".equals(var3)) {
                  MoPubView.this.setAdVisibility(8);
                  return;
               }
            }

         }
      };
      IntentFilter var1 = new IntentFilter("android.intent.action.SCREEN_OFF");
      var1.addAction("android.intent.action.USER_PRESENT");
      this.mContext.registerReceiver(this.mScreenStateReceiver, var1);
   }

   private void setAdVisibility(int var1) {
      if(this.mAdViewController != null) {
         if(Visibility.isScreenVisible(var1)) {
            this.mAdViewController.unpauseRefresh();
         } else {
            this.mAdViewController.pauseRefresh();
         }
      }
   }

   private void unregisterScreenStateBroadcastReceiver() {
      try {
         this.mContext.unregisterReceiver(this.mScreenStateReceiver);
      } catch (Exception var2) {
         MoPubLog.d("Failed to unregister screen state broadcast receiver (never registered).");
      }
   }

   protected void adClicked() {
      if(this.mBannerAdListener != null) {
         this.mBannerAdListener.onBannerClicked(this);
      } else if(this.mOnAdClickedListener != null) {
         this.mOnAdClickedListener.OnAdClicked(this);
         return;
      }

   }

   protected void adClosed() {
      if(this.mBannerAdListener != null) {
         this.mBannerAdListener.onBannerCollapsed(this);
      } else if(this.mOnAdClosedListener != null) {
         this.mOnAdClosedListener.OnAdClosed(this);
         return;
      }

   }

   protected void adFailed(MoPubErrorCode var1) {
      if(this.mBannerAdListener != null) {
         this.mBannerAdListener.onBannerFailed(this, var1);
      } else if(this.mOnAdFailedListener != null) {
         this.mOnAdFailedListener.OnAdFailed(this);
         return;
      }

   }

   protected void adLoaded() {
      MoPubLog.d("adLoaded");
      if(this.mBannerAdListener != null) {
         this.mBannerAdListener.onBannerLoaded(this);
      } else if(this.mOnAdLoadedListener != null) {
         this.mOnAdLoadedListener.OnAdLoaded(this);
         return;
      }

   }

   protected void adPresentedOverlay() {
      if(this.mBannerAdListener != null) {
         this.mBannerAdListener.onBannerExpanded(this);
      } else if(this.mOnAdPresentedOverlayListener != null) {
         this.mOnAdPresentedOverlayListener.OnAdPresentedOverlay(this);
         return;
      }

   }

   @Deprecated
   protected void adWillLoad(String var1) {
      MoPubLog.d("adWillLoad: " + var1);
      if(this.mOnAdWillLoadListener != null) {
         this.mOnAdWillLoadListener.OnAdWillLoad(this, var1);
      }

   }

   @Deprecated
   public void customEventActionWillBegin() {
      if(this.mAdViewController != null) {
         this.mAdViewController.customEventActionWillBegin();
      }

   }

   @Deprecated
   public void customEventDidFailToLoadAd() {
      if(this.mAdViewController != null) {
         this.mAdViewController.customEventDidFailToLoadAd();
      }

   }

   @Deprecated
   public void customEventDidLoadAd() {
      if(this.mAdViewController != null) {
         this.mAdViewController.customEventDidLoadAd();
      }

   }

   public void destroy() {
      this.unregisterScreenStateBroadcastReceiver();
      this.removeAllViews();
      if(this.mAdViewController != null) {
         this.mAdViewController.cleanup();
         this.mAdViewController = null;
      }

      if(this.mCustomEventBannerAdapter != null) {
         this.mCustomEventBannerAdapter.invalidate();
         this.mCustomEventBannerAdapter = null;
      }

   }

   public void forceRefresh() {
      if(this.mCustomEventBannerAdapter != null) {
         this.mCustomEventBannerAdapter.invalidate();
         this.mCustomEventBannerAdapter = null;
      }

      if(this.mAdViewController != null) {
         this.mAdViewController.forceRefresh();
      }

   }

   public Activity getActivity() {
      return (Activity)this.mContext;
   }

   public AdFormat getAdFormat() {
      return AdFormat.BANNER;
   }

   public int getAdHeight() {
      return this.mAdViewController != null?this.mAdViewController.getAdHeight():0;
   }

   Integer getAdTimeoutDelay() {
      return this.mAdViewController != null?this.mAdViewController.getAdTimeoutDelay():null;
   }

   public String getAdUnitId() {
      return this.mAdViewController != null?this.mAdViewController.getAdUnitId():null;
   }

   AdViewController getAdViewController() {
      return this.mAdViewController;
   }

   public int getAdWidth() {
      return this.mAdViewController != null?this.mAdViewController.getAdWidth():0;
   }

   public boolean getAutorefreshEnabled() {
      if(this.mAdViewController != null) {
         return this.mAdViewController.getAutorefreshEnabled();
      } else {
         MoPubLog.d("Can\'t get autorefresh status for destroyed MoPubView. Returning false.");
         return false;
      }
   }

   public MoPubView$BannerAdListener getBannerAdListener() {
      return this.mBannerAdListener;
   }

   public String getClickTrackingUrl() {
      return this.mAdViewController != null?this.mAdViewController.getClickTrackingUrl():null;
   }

   @Deprecated
   public String getClickthroughUrl() {
      return this.getClickTrackingUrl();
   }

   public String getKeywords() {
      return this.mAdViewController != null?this.mAdViewController.getKeywords():null;
   }

   public Map getLocalExtras() {
      return (Map)(this.mAdViewController != null?this.mAdViewController.getLocalExtras():new TreeMap());
   }

   public Location getLocation() {
      return this.mAdViewController != null?this.mAdViewController.getLocation():null;
   }

   @Deprecated
   public LocationService$LocationAwareness getLocationAwareness() {
      return LocationService$LocationAwareness.fromMoPubLocationAwareness(MoPub.getLocationAwareness());
   }

   @Deprecated
   public int getLocationPrecision() {
      return MoPub.getLocationPrecision();
   }

   public String getResponseString() {
      return this.mAdViewController != null?this.mAdViewController.getResponseString():null;
   }

   public boolean getTesting() {
      if(this.mAdViewController != null) {
         return this.mAdViewController.getTesting();
      } else {
         MoPubLog.d("Can\'t get testing status for destroyed MoPubView. Returning false.");
         return false;
      }
   }

   @Deprecated
   public boolean isFacebookSupported() {
      return false;
   }

   public void loadAd() {
      if(this.mAdViewController != null) {
         this.mAdViewController.loadAd();
      }

   }

   protected void loadCustomEvent(String var1, Map var2) {
      if(this.mAdViewController != null) {
         if(TextUtils.isEmpty(var1)) {
            MoPubLog.d("Couldn\'t invoke custom event because the server did not specify one.");
            this.loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
         } else {
            if(this.mCustomEventBannerAdapter != null) {
               this.mCustomEventBannerAdapter.invalidate();
            }

            MoPubLog.d("Loading custom event adapter.");
            this.mCustomEventBannerAdapter = CustomEventBannerAdapterFactory.create(this, var1, var2, this.mAdViewController.getBroadcastIdentifier(), this.mAdViewController.getAdReport());
            this.mCustomEventBannerAdapter.loadAd();
         }
      }
   }

   protected void loadFailUrl(MoPubErrorCode var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.loadFailUrl(var1);
      }

   }

   protected void nativeAdLoaded() {
      if(this.mAdViewController != null) {
         this.mAdViewController.scheduleRefreshTimerIfEnabled();
      }

      this.adLoaded();
   }

   protected void onWindowVisibilityChanged(int var1) {
      if(Visibility.hasScreenVisibilityChanged(this.mScreenVisibility, var1)) {
         this.mScreenVisibility = var1;
         this.setAdVisibility(this.mScreenVisibility);
      }

   }

   protected void registerClick() {
      if(this.mAdViewController != null) {
         this.mAdViewController.registerClick();
         this.adClicked();
      }

   }

   public void setAdContentView(View var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.setAdContentView(var1);
      }

   }

   public void setAdUnitId(String var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.setAdUnitId(var1);
      }

   }

   public void setAutorefreshEnabled(boolean var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.forceSetAutorefreshEnabled(var1);
      }

   }

   public void setBannerAdListener(MoPubView$BannerAdListener var1) {
      this.mBannerAdListener = var1;
   }

   @Deprecated
   public void setClickthroughUrl(String var1) {
   }

   @Deprecated
   public void setFacebookSupported(boolean var1) {
   }

   public void setKeywords(String var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.setKeywords(var1);
      }

   }

   public void setLocalExtras(Map var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.setLocalExtras(var1);
      }

   }

   public void setLocation(Location var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.setLocation(var1);
      }

   }

   @Deprecated
   public void setLocationAwareness(LocationService$LocationAwareness var1) {
      MoPub.setLocationAwareness(var1.getNewLocationAwareness());
   }

   @Deprecated
   public void setLocationPrecision(int var1) {
      MoPub.setLocationPrecision(var1);
   }

   @Deprecated
   public void setOnAdClickedListener(MoPubView$OnAdClickedListener var1) {
      this.mOnAdClickedListener = var1;
   }

   @Deprecated
   public void setOnAdClosedListener(MoPubView$OnAdClosedListener var1) {
      this.mOnAdClosedListener = var1;
   }

   @Deprecated
   public void setOnAdFailedListener(MoPubView$OnAdFailedListener var1) {
      this.mOnAdFailedListener = var1;
   }

   @Deprecated
   public void setOnAdLoadedListener(MoPubView$OnAdLoadedListener var1) {
      this.mOnAdLoadedListener = var1;
   }

   @Deprecated
   public void setOnAdPresentedOverlayListener(MoPubView$OnAdPresentedOverlayListener var1) {
      this.mOnAdPresentedOverlayListener = var1;
   }

   @Deprecated
   public void setOnAdWillLoadListener(MoPubView$OnAdWillLoadListener var1) {
      this.mOnAdWillLoadListener = var1;
   }

   public void setTesting(boolean var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.setTesting(var1);
      }

   }

   public void setTimeout(int var1) {
      if(this.mAdViewController != null) {
         this.mAdViewController.setTimeout(var1);
      }

   }

   protected void trackNativeImpression() {
      MoPubLog.d("Tracking impression for native adapter.");
      if(this.mAdViewController != null) {
         this.mAdViewController.trackImpression();
      }

   }
}
