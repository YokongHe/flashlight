package com.adsdk.sdk.mraid;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class AdViewController {
   static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
   static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
   private static WeakHashMap sViewShouldHonorServerDimensions = new WeakHashMap();
   private boolean mAutoRefreshEnabled = true;
   private Context mContext;
   private Handler mHandler;
   private boolean mIsDestroyed;
   private boolean mIsFacebookSupported = true;
   private boolean mIsLoading;
   private boolean mIsTesting;
   private String mKeywords;
   private Map mLocalExtras = new HashMap();
   private Location mLocation;
   private Runnable mRefreshRunnable;
   private String mUrl;

   private void cancelRefreshTimer() {
      this.mHandler.removeCallbacks(this.mRefreshRunnable);
   }

   private boolean isNetworkAvailable() {
      if(this.mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
         return true;
      } else {
         NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
         return var1 != null && var1.isConnected();
      }
   }

   protected static void setShouldHonorServerDimensions(View var0) {
      sViewShouldHonorServerDimensions.put(var0, Boolean.valueOf(true));
   }

   void cleanup() {
      if(!this.mIsDestroyed) {
         this.setAutorefreshEnabled(false);
         this.cancelRefreshTimer();
         this.mIsDestroyed = true;
      }
   }

   @Deprecated
   public void customEventActionWillBegin() {
      this.registerClick();
   }

   @Deprecated
   public void customEventDidLoadAd() {
      this.setNotLoading();
      this.trackImpression();
      this.scheduleRefreshTimerIfEnabled();
   }

   void fetchAd(String var1) {
   }

   void forceRefresh() {
      this.setNotLoading();
      this.loadAd();
   }

   public boolean getAutorefreshEnabled() {
      return this.mAutoRefreshEnabled;
   }

   public String getKeywords() {
      return this.mKeywords;
   }

   Map getLocalExtras() {
      return this.mLocalExtras != null?new HashMap(this.mLocalExtras):new HashMap();
   }

   public Location getLocation() {
      return this.mLocation;
   }

   public boolean getTesting() {
      return this.mIsTesting;
   }

   boolean isDestroyed() {
      return this.mIsDestroyed;
   }

   public boolean isFacebookSupported() {
      return this.mIsFacebookSupported;
   }

   public void loadAd() {
      if(!this.isNetworkAvailable()) {
         Log.d("MoPub", "Can\'t load an ad because there is no network connectivity.");
         this.scheduleRefreshTimerIfEnabled();
      }

   }

   void loadNonJavascript(String var1) {
      if(var1 != null) {
         Log.d("MoPub", "Loading url: " + var1);
         if(!this.mIsLoading) {
            this.mUrl = var1;
            this.mIsLoading = true;
            this.fetchAd(this.mUrl);
            return;
         }
      }

   }

   void registerClick() {
   }

   public void reload() {
      Log.d("MoPub", "Reload ad: " + this.mUrl);
      this.loadNonJavascript(this.mUrl);
   }

   void scheduleRefreshTimerIfEnabled() {
   }

   public void setAutorefreshEnabled(boolean var1) {
      this.mAutoRefreshEnabled = var1;
      if(this.mAutoRefreshEnabled) {
         this.scheduleRefreshTimerIfEnabled();
      } else {
         this.cancelRefreshTimer();
      }
   }

   public void setFacebookSupported(boolean var1) {
      this.mIsFacebookSupported = var1;
   }

   void setFailUrl(String var1) {
   }

   public void setKeywords(String var1) {
      this.mKeywords = var1;
   }

   void setLocalExtras(Map var1) {
      HashMap var2;
      if(var1 != null) {
         var2 = new HashMap(var1);
      } else {
         var2 = new HashMap();
      }

      this.mLocalExtras = var2;
   }

   public void setLocation(Location var1) {
      this.mLocation = var1;
   }

   void setNotLoading() {
      this.mIsLoading = false;
   }

   public void setTesting(boolean var1) {
      this.mIsTesting = var1;
   }

   public void setTimeout(int var1) {
   }

   void trackImpression() {
   }
}
