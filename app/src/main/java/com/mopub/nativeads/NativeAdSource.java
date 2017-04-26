package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubNative$MoPubNativeNetworkListener;
import com.mopub.nativeads.NativeAdSource$AdSourceListener;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.TimestampWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NativeAdSource {
   private static final int CACHE_LIMIT = 3;
   private static final int DEFAULT_RETRY_TIME_MILLISECONDS = 1000;
   private static final int EXPIRATION_TIME_MILLISECONDS = 900000;
   private static final double EXPONENTIAL_BACKOFF_FACTOR = 2.0D;
   private static final int MAXIMUM_RETRY_TIME_MILLISECONDS = 300000;
   private NativeAdSource$AdSourceListener mAdSourceListener;
   private MoPubNative mMoPubNative;
   private final MoPubNative$MoPubNativeNetworkListener mMoPubNativeNetworkListener;
   private final List mNativeAdCache;
   private final Handler mReplenishCacheHandler;
   private final Runnable mReplenishCacheRunnable;
   @VisibleForTesting
   boolean mRequestInFlight;
   private RequestParameters mRequestParameters;
   @VisibleForTesting
   boolean mRetryInFlight;
   @VisibleForTesting
   int mRetryTimeMilliseconds;
   @VisibleForTesting
   int mSequenceNumber;

   NativeAdSource() {
      this(new ArrayList(3), new Handler());
   }

   @VisibleForTesting
   NativeAdSource(List var1, Handler var2) {
      this.mNativeAdCache = var1;
      this.mReplenishCacheHandler = var2;
      this.mReplenishCacheRunnable = new Runnable() {
         public void run() {
            NativeAdSource.this.mRetryInFlight = false;
            NativeAdSource.this.replenishCache();
         }
      };
      this.mMoPubNativeNetworkListener = new MoPubNative$MoPubNativeNetworkListener() {
         public void onNativeFail(NativeErrorCode var1) {
            NativeAdSource.this.mRequestInFlight = false;
            if(NativeAdSource.this.mRetryTimeMilliseconds >= 300000) {
               NativeAdSource.this.resetRetryTime();
            } else {
               NativeAdSource.this.updateRetryTime();
               NativeAdSource.this.mRetryInFlight = true;
               NativeAdSource.this.mReplenishCacheHandler.postDelayed(NativeAdSource.this.mReplenishCacheRunnable, (long)NativeAdSource.this.mRetryTimeMilliseconds);
            }
         }

         public void onNativeLoad(NativeResponse var1) {
            if(NativeAdSource.this.mMoPubNative != null) {
               NativeAdSource.this.mRequestInFlight = false;
               NativeAdSource var2 = NativeAdSource.this;
               ++var2.mSequenceNumber;
               NativeAdSource.this.resetRetryTime();
               NativeAdSource.this.mNativeAdCache.add(new TimestampWrapper(var1));
               if(NativeAdSource.this.mNativeAdCache.size() == 1 && NativeAdSource.this.mAdSourceListener != null) {
                  NativeAdSource.this.mAdSourceListener.onAdsAvailable();
               }

               NativeAdSource.this.replenishCache();
            }
         }
      };
      this.mSequenceNumber = 0;
      this.mRetryTimeMilliseconds = 1000;
   }

   void clear() {
      if(this.mMoPubNative != null) {
         this.mMoPubNative.destroy();
         this.mMoPubNative = null;
      }

      this.mRequestParameters = null;
      Iterator var1 = this.mNativeAdCache.iterator();

      while(var1.hasNext()) {
         ((NativeResponse)((TimestampWrapper)var1.next()).mInstance).destroy();
      }

      this.mNativeAdCache.clear();
      this.mReplenishCacheHandler.removeMessages(0);
      this.mRequestInFlight = false;
      this.mSequenceNumber = 0;
      this.resetRetryTime();
   }

   NativeResponse dequeueAd() {
      long var1 = SystemClock.uptimeMillis();
      if(!this.mRequestInFlight && !this.mRetryInFlight) {
         this.mReplenishCacheHandler.post(this.mReplenishCacheRunnable);
      }

      while(!this.mNativeAdCache.isEmpty()) {
         TimestampWrapper var3 = (TimestampWrapper)this.mNativeAdCache.remove(0);
         if(var1 - var3.mCreatedTimestamp < 900000L) {
            return (NativeResponse)var3.mInstance;
         }
      }

      return null;
   }

   @Deprecated
   @VisibleForTesting
   MoPubNative$MoPubNativeNetworkListener getMoPubNativeNetworkListener() {
      return this.mMoPubNativeNetworkListener;
   }

   void loadAds(Context var1, String var2, RequestParameters var3) {
      this.loadAds(var3, new MoPubNative(var1, var2, this.mMoPubNativeNetworkListener));
   }

   @VisibleForTesting
   void loadAds(RequestParameters var1, MoPubNative var2) {
      this.clear();
      this.mRequestParameters = var1;
      this.mMoPubNative = var2;
      this.replenishCache();
   }

   @VisibleForTesting
   void replenishCache() {
      if(!this.mRequestInFlight && this.mMoPubNative != null && this.mNativeAdCache.size() < 3) {
         this.mRequestInFlight = true;
         this.mMoPubNative.makeRequest(this.mRequestParameters, Integer.valueOf(this.mSequenceNumber));
      }

   }

   @VisibleForTesting
   void resetRetryTime() {
      this.mRetryTimeMilliseconds = 1000;
   }

   void setAdSourceListener(NativeAdSource$AdSourceListener var1) {
      this.mAdSourceListener = var1;
   }

   @Deprecated
   @VisibleForTesting
   void setMoPubNative(MoPubNative var1) {
      this.mMoPubNative = var1;
   }

   @VisibleForTesting
   void updateRetryTime() {
      this.mRetryTimeMilliseconds = (int)((double)this.mRetryTimeMilliseconds * 2.0D);
      if(this.mRetryTimeMilliseconds > 300000) {
         this.mRetryTimeMilliseconds = 300000;
      }

   }
}
