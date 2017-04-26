package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions$NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.ClientPositioningSource;
import com.mopub.nativeads.ImpressionTracker;
import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.MoPubNativeAdLoadedListener;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubServerPositioning;
import com.mopub.nativeads.NativeAdData;
import com.mopub.nativeads.NativeAdSource;
import com.mopub.nativeads.NativeAdSource$AdSourceListener;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.PlacementData;
import com.mopub.nativeads.PositioningSource;
import com.mopub.nativeads.PositioningSource$PositioningListener;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.ServerPositioningSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

public class MoPubStreamAdPlacer {
   public static final int CONTENT_VIEW_TYPE = 0;
   private static final MoPubNativeAdLoadedListener EMPTY_NATIVE_AD_LOADED_LISTENER = new MoPubNativeAdLoadedListener() {
      public void onAdLoaded(int var1) {
      }

      public void onAdRemoved(int var1) {
      }
   };
   private static final int MAX_VISIBLE_RANGE = 100;
   private static final int RANGE_BUFFER = 10;
   private MoPubNativeAdLoadedListener mAdLoadedListener;
   private MoPubAdRenderer mAdRenderer;
   private final NativeAdSource mAdSource;
   private String mAdUnitId;
   private final Context mContext;
   private boolean mHasPlacedAds;
   private boolean mHasReceivedAds;
   private boolean mHasReceivedPositions;
   private final ImpressionTracker mImpressionTracker;
   private int mItemCount;
   private final WeakHashMap mNativeResponseMap;
   private boolean mNeedsPlacement;
   private PlacementData mPendingPlacementData;
   private PlacementData mPlacementData;
   private final Handler mPlacementHandler;
   private final Runnable mPlacementRunnable;
   private final PositioningSource mPositioningSource;
   private final HashMap mViewMap;
   private int mVisibleRangeEnd;
   private int mVisibleRangeStart;

   public MoPubStreamAdPlacer(Context var1) {
      this(var1, MoPubNativeAdPositioning.serverPositioning());
   }

   public MoPubStreamAdPlacer(Context var1, MoPubNativeAdPositioning$MoPubClientPositioning var2) {
      this(var1, new NativeAdSource(), new ImpressionTracker(var1), new ClientPositioningSource(var2));
   }

   public MoPubStreamAdPlacer(Context var1, MoPubNativeAdPositioning$MoPubServerPositioning var2) {
      this(var1, new NativeAdSource(), new ImpressionTracker(var1), new ServerPositioningSource(var1));
   }

   @VisibleForTesting
   MoPubStreamAdPlacer(Context var1, NativeAdSource var2, ImpressionTracker var3, PositioningSource var4) {
      this.mAdLoadedListener = EMPTY_NATIVE_AD_LOADED_LISTENER;
      Preconditions.checkNotNull(var1, "context is not allowed to be null");
      Preconditions.checkNotNull(var2, "adSource is not allowed to be null");
      Preconditions.checkNotNull(var3, "impressionTracker is not allowed to be null");
      Preconditions.checkNotNull(var4, "positioningSource is not allowed to be null");
      this.mContext = var1;
      this.mImpressionTracker = var3;
      this.mPositioningSource = var4;
      this.mAdSource = var2;
      this.mPlacementData = PlacementData.empty();
      this.mNativeResponseMap = new WeakHashMap();
      this.mViewMap = new HashMap();
      this.mPlacementHandler = new Handler();
      this.mPlacementRunnable = new Runnable() {
         public void run() {
            if(MoPubStreamAdPlacer.this.mNeedsPlacement) {
               MoPubStreamAdPlacer.this.placeAds();
               MoPubStreamAdPlacer.this.mNeedsPlacement = false;
            }
         }
      };
      this.mVisibleRangeStart = 0;
      this.mVisibleRangeEnd = 0;
   }

   private void clearNativeResponse(View var1) {
      if(var1 != null) {
         this.mImpressionTracker.removeView(var1);
         NativeResponse var2 = (NativeResponse)this.mNativeResponseMap.get(var1);
         if(var2 != null) {
            var2.clear(var1);
            this.mNativeResponseMap.remove(var1);
            this.mViewMap.remove(var2);
            return;
         }
      }

   }

   private NativeAdData createAdData(int var1, NativeResponse var2) {
      Preconditions.checkNotNull(this.mAdUnitId);
      Preconditions.checkNotNull(this.mAdRenderer);
      return new NativeAdData(this.mAdUnitId, this.mAdRenderer, var2);
   }

   private void notifyNeedsPlacement() {
      if(!this.mNeedsPlacement) {
         this.mNeedsPlacement = true;
         this.mPlacementHandler.post(this.mPlacementRunnable);
      }
   }

   private void placeAds() {
      if(this.tryPlaceAdsInRange(this.mVisibleRangeStart, this.mVisibleRangeEnd)) {
         this.tryPlaceAdsInRange(this.mVisibleRangeEnd, this.mVisibleRangeEnd + 10);
      }
   }

   private void placeInitialAds(PlacementData var1) {
      this.removeAdsInRange(0, this.mItemCount);
      this.mPlacementData = var1;
      this.placeAds();
      this.mHasPlacedAds = true;
   }

   private void prepareNativeResponse(NativeResponse var1, View var2) {
      this.mViewMap.put(var1, new WeakReference(var2));
      this.mNativeResponseMap.put(var2, var1);
      if(!var1.isOverridingImpressionTracker()) {
         this.mImpressionTracker.addView(var2, var1);
      }

      var1.prepare(var2);
   }

   private boolean tryPlaceAd(int var1) {
      NativeResponse var2 = this.mAdSource.dequeueAd();
      if(var2 == null) {
         return false;
      } else {
         NativeAdData var3 = this.createAdData(var1, var2);
         this.mPlacementData.placeAd(var1, var3);
         ++this.mItemCount;
         this.mAdLoadedListener.onAdLoaded(var1);
         return true;
      }
   }

   private boolean tryPlaceAdsInRange(int var1, int var2) {
      --var2;

      while(var1 <= var2 && var1 != -1 && var1 < this.mItemCount) {
         int var3 = var2;
         if(this.mPlacementData.shouldPlaceAd(var1)) {
            if(!this.tryPlaceAd(var1)) {
               return false;
            }

            var3 = var2 + 1;
         }

         var1 = this.mPlacementData.nextInsertionPosition(var1);
         var2 = var3;
      }

      return true;
   }

   public void clearAds() {
      this.removeAdsInRange(0, this.mItemCount);
      this.mAdSource.clear();
   }

   public void destroy() {
      this.mPlacementHandler.removeMessages(0);
      this.mAdSource.clear();
      this.mImpressionTracker.destroy();
      this.mPlacementData.clearAds();
   }

   public Object getAdData(int var1) {
      return this.mPlacementData.getPlacedAd(var1);
   }

   public View getAdView(int var1, View var2, ViewGroup var3) {
      NativeAdData var5 = this.mPlacementData.getPlacedAd(var1);
      if(var5 == null) {
         return null;
      } else {
         MoPubAdRenderer var4 = var5.getAdRenderer();
         if(var2 == null) {
            var2 = var4.createAdView(this.mContext, var3);
         }

         NativeResponse var6 = var5.getAd();
         WeakReference var7 = (WeakReference)this.mViewMap.get(var6);
         View var8;
         if(var7 != null) {
            var8 = (View)var7.get();
         } else {
            var8 = null;
         }

         if(!var2.equals(var8)) {
            this.clearNativeResponse(var8);
            this.clearNativeResponse(var2);
            this.prepareNativeResponse(var6, var2);
            var4.renderAdView(var2, var6);
         }

         return var2;
      }
   }

   public int getAdViewType(int var1) {
      return this.isAd(var1)?1:0;
   }

   public int getAdViewTypeCount() {
      return 1;
   }

   public int getAdjustedCount(int var1) {
      return this.mPlacementData.getAdjustedCount(var1);
   }

   public int getAdjustedPosition(int var1) {
      return this.mPlacementData.getAdjustedPosition(var1);
   }

   public int getOriginalCount(int var1) {
      return this.mPlacementData.getOriginalCount(var1);
   }

   public int getOriginalPosition(int var1) {
      return this.mPlacementData.getOriginalPosition(var1);
   }

   @VisibleForTesting
   void handleAdsAvailable() {
      if(this.mHasPlacedAds) {
         this.notifyNeedsPlacement();
      } else {
         if(this.mHasReceivedPositions) {
            this.placeInitialAds(this.mPendingPlacementData);
         }

         this.mHasReceivedAds = true;
      }
   }

   @VisibleForTesting
   void handlePositioningLoad(MoPubNativeAdPositioning$MoPubClientPositioning var1) {
      PlacementData var2 = PlacementData.fromAdPositioning(var1);
      if(this.mHasReceivedAds) {
         this.placeInitialAds(var2);
      } else {
         this.mPendingPlacementData = var2;
      }

      this.mHasReceivedPositions = true;
   }

   public void insertItem(int var1) {
      this.mPlacementData.insertItem(var1);
   }

   public boolean isAd(int var1) {
      return this.mPlacementData.isPlacedAd(var1);
   }

   public void loadAds(String var1) {
      this.loadAds(var1, (RequestParameters)null);
   }

   public void loadAds(String var1, RequestParameters var2) {
      if(Preconditions$NoThrow.checkNotNull(var1, "Cannot load ads with a null ad unit ID")) {
         if(this.mAdRenderer == null) {
            MoPubLog.w("You must call registerAdRenderer before loading ads");
         } else {
            this.mAdUnitId = var1;
            this.mHasPlacedAds = false;
            this.mHasReceivedPositions = false;
            this.mHasReceivedAds = false;
            this.mPositioningSource.loadPositions(var1, new PositioningSource$PositioningListener() {
               public void onFailed() {
                  MoPubLog.d("Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
               }

               public void onLoad(MoPubNativeAdPositioning$MoPubClientPositioning var1) {
                  MoPubStreamAdPlacer.this.handlePositioningLoad(var1);
               }
            });
            this.mAdSource.setAdSourceListener(new NativeAdSource$AdSourceListener() {
               public void onAdsAvailable() {
                  MoPubStreamAdPlacer.this.handleAdsAvailable();
               }
            });
            this.mAdSource.loadAds(this.mContext, var1, var2);
         }
      }
   }

   public void moveItem(int var1, int var2) {
      this.mPlacementData.moveItem(var1, var2);
   }

   public void placeAdsInRange(int var1, int var2) {
      this.mVisibleRangeStart = var1;
      this.mVisibleRangeEnd = Math.min(var2, var1 + 100);
      this.notifyNeedsPlacement();
   }

   public void registerAdRenderer(MoPubAdRenderer var1) {
      if(Preconditions$NoThrow.checkNotNull(var1, "Cannot register a null adRenderer")) {
         this.mAdRenderer = var1;
      }
   }

   public int removeAdsInRange(int var1, int var2) {
      int[] var5 = this.mPlacementData.getPlacedAdPositions();
      int var3 = this.mPlacementData.getAdjustedPosition(var1);
      var2 = this.mPlacementData.getAdjustedPosition(var2);
      ArrayList var6 = new ArrayList();

      for(var1 = var5.length - 1; var1 >= 0; --var1) {
         int var4 = var5[var1];
         if(var4 >= var3 && var4 < var2) {
            var6.add(Integer.valueOf(var4));
            if(var4 < this.mVisibleRangeStart) {
               --this.mVisibleRangeStart;
            }

            --this.mItemCount;
         }
      }

      var1 = this.mPlacementData.clearAdsInRange(var3, var2);
      Iterator var7 = var6.iterator();

      while(var7.hasNext()) {
         var2 = ((Integer)var7.next()).intValue();
         this.mAdLoadedListener.onAdRemoved(var2);
      }

      return var1;
   }

   public void removeItem(int var1) {
      this.mPlacementData.removeItem(var1);
   }

   public void setAdLoadedListener(MoPubNativeAdLoadedListener var1) {
      MoPubNativeAdLoadedListener var2 = var1;
      if(var1 == null) {
         var2 = EMPTY_NATIVE_AD_LOADED_LISTENER;
      }

      this.mAdLoadedListener = var2;
   }

   public void setItemCount(int var1) {
      this.mItemCount = this.mPlacementData.getAdjustedCount(var1);
      if(this.mHasPlacedAds) {
         this.notifyNeedsPlacement();
      }

   }
}
