package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.MoPubEvents$Type;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.AdLoader;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.WebViewAdUrlGenerator;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.AdRequest;
import com.mopub.network.AdRequest$Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError$Reason;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class AdViewController {
   static final double BACKOFF_FACTOR = 1.5D;
   static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
   static final int MAX_REFRESH_TIME_MILLISECONDS = 600000;
   static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
   private static final LayoutParams WRAP_AND_CENTER_LAYOUT_PARAMS = new LayoutParams(-2, -2, 17);
   private static final WeakHashMap sViewShouldHonorServerDimensions = new WeakHashMap();
   private AdRequest mActiveRequest;
   private final AdRequest$Listener mAdListener;
   private AdResponse mAdResponse;
   private String mAdUnitId;
   private boolean mAdWasLoaded;
   private boolean mAutoRefreshEnabled = true;
   private int mBackoffPower = 1;
   private final long mBroadcastIdentifier;
   private final Context mContext;
   private Handler mHandler;
   private boolean mIsDestroyed;
   private boolean mIsLoading;
   private boolean mIsTesting;
   private String mKeywords;
   private Map mLocalExtras = new HashMap();
   private Location mLocation;
   private MoPubView mMoPubView;
   private boolean mPreviousAutoRefreshSetting = true;
   private final Runnable mRefreshRunnable;
   private Integer mRefreshTimeMillis;
   private int mTimeoutMilliseconds;
   private String mUrl;
   private final WebViewAdUrlGenerator mUrlGenerator;

   public AdViewController(Context var1, MoPubView var2) {
      this.mContext = var1;
      this.mMoPubView = var2;
      this.mTimeoutMilliseconds = -1;
      this.mBroadcastIdentifier = Utils.generateUniqueId();
      this.mUrlGenerator = new WebViewAdUrlGenerator(var1, MraidNativeCommandHandler.isStorePictureSupported(this.mContext));
      this.mAdListener = new AdRequest$Listener() {
         public void onErrorResponse(VolleyError var1) {
            AdViewController.this.onAdLoadError(var1);
         }

         public void onSuccess(AdResponse var1) {
            AdViewController.this.onAdLoadSuccess(var1);
         }
      };
      this.mRefreshRunnable = new Runnable() {
         public void run() {
            AdViewController.this.internalLoadAd();
         }
      };
      this.mRefreshTimeMillis = Integer.valueOf('\uea60');
      this.mHandler = new Handler();
   }

   private void cancelRefreshTimer() {
      this.mHandler.removeCallbacks(this.mRefreshRunnable);
   }

   private LayoutParams getAdLayoutParams(View var1) {
      Integer var2 = null;
      Integer var3;
      if(this.mAdResponse != null) {
         var3 = this.mAdResponse.getWidth();
         var2 = this.mAdResponse.getHeight();
      } else {
         var3 = null;
      }

      return var3 != null && var2 != null && getShouldHonorServerDimensions(var1) && var3.intValue() > 0 && var2.intValue() > 0?new LayoutParams(Dips.asIntPixels((float)var3.intValue(), this.mContext), Dips.asIntPixels((float)var2.intValue(), this.mContext), 17):WRAP_AND_CENTER_LAYOUT_PARAMS;
   }

   private static boolean getShouldHonorServerDimensions(View var0) {
      return sViewShouldHonorServerDimensions.get(var0) != null;
   }

   private void internalLoadAd() {
      this.mAdWasLoaded = true;
      if(TextUtils.isEmpty(this.mAdUnitId)) {
         MoPubLog.d("Can\'t load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
      } else if(!this.isNetworkAvailable()) {
         MoPubLog.d("Can\'t load an ad because there is no network connectivity.");
         this.scheduleRefreshTimerIfEnabled();
      } else {
         this.loadNonJavascript(this.generateAdUrl());
      }
   }

   private boolean isNetworkAvailable() {
      if(this.mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
         return true;
      } else {
         NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
         return var1 != null && var1.isConnected();
      }
   }

   private void setAutorefreshEnabled(boolean var1) {
      boolean var2;
      if(this.mAdWasLoaded && this.mAutoRefreshEnabled != var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var2) {
         String var3;
         if(var1) {
            var3 = "enabled";
         } else {
            var3 = "disabled";
         }

         MoPubLog.d("Refresh " + var3 + " for ad unit (" + this.mAdUnitId + ").");
      }

      this.mAutoRefreshEnabled = var1;
      if(this.mAdWasLoaded && this.mAutoRefreshEnabled) {
         this.scheduleRefreshTimerIfEnabled();
      } else if(!this.mAutoRefreshEnabled) {
         this.cancelRefreshTimer();
         return;
      }

   }

   public static void setShouldHonorServerDimensions(View var0) {
      sViewShouldHonorServerDimensions.put(var0, Boolean.valueOf(true));
   }

   void adDidFail(MoPubErrorCode var1) {
      MoPubLog.i("Ad failed to load.");
      this.setNotLoading();
      this.scheduleRefreshTimerIfEnabled();
      this.getMoPubView().adFailed(var1);
   }

   void cleanup() {
      if(!this.mIsDestroyed) {
         if(this.mActiveRequest != null) {
            this.mActiveRequest.cancel();
            this.mActiveRequest = null;
         }

         this.setAutorefreshEnabled(false);
         this.cancelRefreshTimer();
         this.mMoPubView = null;
         this.mIsDestroyed = true;
      }
   }

   @Deprecated
   public void customEventActionWillBegin() {
      this.registerClick();
   }

   @Deprecated
   public void customEventDidFailToLoadAd() {
      this.loadFailUrl(MoPubErrorCode.UNSPECIFIED);
   }

   @Deprecated
   public void customEventDidLoadAd() {
      this.setNotLoading();
      this.trackImpression();
      this.scheduleRefreshTimerIfEnabled();
   }

   void fetchAd(String var1) {
      AdRequest var2 = new AdRequest(var1, this.mMoPubView.getAdFormat(), this.mAdListener);
      Networking.getRequestQueue(this.mContext).add(var2);
      this.mActiveRequest = var2;
   }

   void forceRefresh() {
      this.setNotLoading();
      this.loadAd();
   }

   void forceSetAutorefreshEnabled(boolean var1) {
      this.mPreviousAutoRefreshSetting = var1;
      this.setAutorefreshEnabled(var1);
   }

   String generateAdUrl() {
      return this.mUrlGenerator.withAdUnitId(this.mAdUnitId).withKeywords(this.mKeywords).withLocation(this.mLocation).generateUrlString(Constants.HOST);
   }

   @Deprecated
   Object getAdConfiguration() {
      return null;
   }

   public int getAdHeight() {
      return this.mAdResponse != null && this.mAdResponse.getHeight() != null?this.mAdResponse.getHeight().intValue():0;
   }

   public AdReport getAdReport() {
      return this.mAdUnitId != null && this.mAdResponse != null?new AdReport(this.mAdUnitId, ClientMetadata.getInstance(this.mContext), this.mAdResponse):null;
   }

   Integer getAdTimeoutDelay() {
      return this.mAdResponse == null?null:this.mAdResponse.getAdTimeoutMillis();
   }

   public String getAdUnitId() {
      return this.mAdUnitId;
   }

   public int getAdWidth() {
      return this.mAdResponse != null && this.mAdResponse.getWidth() != null?this.mAdResponse.getWidth().intValue():0;
   }

   public boolean getAutorefreshEnabled() {
      return this.mAutoRefreshEnabled;
   }

   public long getBroadcastIdentifier() {
      return this.mBroadcastIdentifier;
   }

   @Deprecated
   public String getClickTrackingUrl() {
      return this.mAdResponse == null?null:this.mAdResponse.getClickTrackingUrl();
   }

   public String getKeywords() {
      return this.mKeywords;
   }

   Map getLocalExtras() {
      return this.mLocalExtras != null?new TreeMap(this.mLocalExtras):new TreeMap();
   }

   public Location getLocation() {
      return this.mLocation;
   }

   public MoPubView getMoPubView() {
      return this.mMoPubView;
   }

   @Deprecated
   public String getRedirectUrl() {
      return this.mAdResponse == null?null:this.mAdResponse.getRedirectUrl();
   }

   @Deprecated
   public String getResponseString() {
      return this.mAdResponse == null?null:this.mAdResponse.getStringBody();
   }

   public boolean getTesting() {
      return this.mIsTesting;
   }

   boolean isDestroyed() {
      return this.mIsDestroyed;
   }

   @Deprecated
   public boolean isFacebookSupported() {
      return false;
   }

   public void loadAd() {
      this.mBackoffPower = 1;
      this.internalLoadAd();
   }

   void loadFailUrl(MoPubErrorCode var1) {
      this.mIsLoading = false;
      StringBuilder var2 = new StringBuilder("MoPubErrorCode: ");
      String var3;
      if(var1 == null) {
         var3 = "";
      } else {
         var3 = var1.toString();
      }

      Log.v("MoPub", var2.append(var3).toString());
      if(this.mAdResponse == null) {
         var3 = "";
      } else {
         var3 = this.mAdResponse.getFailoverUrl();
      }

      if(!TextUtils.isEmpty(var3)) {
         MoPubLog.d("Loading failover url: " + var3);
         this.loadNonJavascript(var3);
      } else {
         this.adDidFail(MoPubErrorCode.NO_FILL);
      }
   }

   void loadNonJavascript(String var1) {
      if(var1 != null) {
         MoPubLog.d("Loading url: " + var1);
         if(!this.mIsLoading) {
            this.mUrl = var1;
            this.mIsLoading = true;
            this.fetchAd(this.mUrl);
            return;
         }

         if(!TextUtils.isEmpty(this.mAdUnitId)) {
            MoPubLog.i("Already loading an ad for " + this.mAdUnitId + ", wait to finish.");
            return;
         }
      }

   }

   @VisibleForTesting
   void onAdLoadError(VolleyError var1) {
      MoPubErrorCode var2 = MoPubErrorCode.UNSPECIFIED;
      if(var1 instanceof MoPubNetworkError) {
         MoPubNetworkError var3 = (MoPubNetworkError)var1;
         if(var3.getReason() == MoPubNetworkError$Reason.NO_FILL || var3.getReason() == MoPubNetworkError$Reason.WARMING_UP) {
            var2 = MoPubErrorCode.NO_FILL;
         }
      }

      MoPubErrorCode var4 = var2;
      if(var1.networkResponse != null) {
         var4 = var2;
         if(var1.networkResponse.statusCode >= 400) {
            ++this.mBackoffPower;
            var4 = MoPubErrorCode.SERVER_ERROR;
         }
      }

      this.setNotLoading();
      this.adDidFail(var4);
   }

   @VisibleForTesting
   void onAdLoadSuccess(AdResponse var1) {
      this.mBackoffPower = 1;
      this.mAdResponse = var1;
      int var2;
      if(this.mAdResponse.getAdTimeoutMillis() == null) {
         var2 = this.mTimeoutMilliseconds;
      } else {
         var2 = this.mAdResponse.getAdTimeoutMillis().intValue();
      }

      this.mTimeoutMilliseconds = var2;
      Integer var3 = this.mAdResponse.getRefreshTimeMillis();
      if(var3 != null) {
         this.mRefreshTimeMillis = var3;
      }

      this.setNotLoading();
      AdLoader var4 = AdLoader.fromAdResponse(this.mAdResponse, this);
      if(var4 != null) {
         var4.load();
      }

      this.scheduleRefreshTimerIfEnabled();
   }

   void pauseRefresh() {
      this.mPreviousAutoRefreshSetting = this.mAutoRefreshEnabled;
      this.setAutorefreshEnabled(false);
   }

   void registerClick() {
      if(this.mAdResponse != null) {
         TrackingRequest.makeTrackingHttpRequest(this.mAdResponse.getClickTrackingUrl(), this.mContext, MoPubEvents$Type.CLICK_REQUEST);
      }

   }

   public void reload() {
      MoPubLog.d("Reload ad: " + this.mUrl);
      this.loadNonJavascript(this.mUrl);
   }

   void scheduleRefreshTimerIfEnabled() {
      this.cancelRefreshTimer();
      if(this.mAutoRefreshEnabled && this.mRefreshTimeMillis != null && this.mRefreshTimeMillis.intValue() > 0) {
         this.mHandler.postDelayed(this.mRefreshRunnable, Math.min(600000L, (long)this.mRefreshTimeMillis.intValue() * (long)Math.pow(1.5D, (double)this.mBackoffPower)));
      }

   }

   void setAdContentView(final View var1) {
      this.mHandler.post(new Runnable() {
         public void run() {
            MoPubView var1x = AdViewController.this.getMoPubView();
            if(var1x != null) {
               var1x.removeAllViews();
               var1x.addView(var1, AdViewController.this.getAdLayoutParams(var1));
            }
         }
      });
   }

   public void setAdUnitId(String var1) {
      this.mAdUnitId = var1;
   }

   @Deprecated
   public void setClickthroughUrl(String var1) {
   }

   @Deprecated
   public void setFacebookSupported(boolean var1) {
   }

   @Deprecated
   void setFailUrl(String var1) {
   }

   public void setKeywords(String var1) {
      this.mKeywords = var1;
   }

   void setLocalExtras(Map var1) {
      TreeMap var2;
      if(var1 != null) {
         var2 = new TreeMap(var1);
      } else {
         var2 = new TreeMap();
      }

      this.mLocalExtras = var2;
   }

   public void setLocation(Location var1) {
      this.mLocation = var1;
   }

   void setNotLoading() {
      this.mIsLoading = false;
      if(this.mActiveRequest != null) {
         if(!this.mActiveRequest.isCanceled()) {
            this.mActiveRequest.cancel();
         }

         this.mActiveRequest = null;
      }

   }

   public void setTesting(boolean var1) {
      this.mIsTesting = var1;
   }

   public void setTimeout(int var1) {
      this.mTimeoutMilliseconds = var1;
   }

   void trackImpression() {
      if(this.mAdResponse != null) {
         TrackingRequest.makeTrackingHttpRequest(this.mAdResponse.getImpressionTrackingUrl(), this.mContext, MoPubEvents$Type.IMPRESSION_REQUEST);
      }

   }

   void unpauseRefresh() {
      this.setAutorefreshEnabled(this.mPreviousAutoRefreshSetting);
   }
}
