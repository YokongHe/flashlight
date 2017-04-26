package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.Preconditions$NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.BaseForwardingNativeAd$NativeEventListener;
import com.mopub.nativeads.CustomEventNative$ImageListener;
import com.mopub.nativeads.NativeAdInterface;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader$ImageContainer;
import com.mopub.volley.toolbox.ImageLoader$ImageListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class BaseForwardingNativeAd implements NativeAdInterface {
   private static final int IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
   static final double MAX_STAR_RATING = 5.0D;
   static final double MIN_STAR_RATING = 0.0D;
   private String mCallToAction;
   private String mClickDestinationUrl;
   private final Map mExtras = new HashMap();
   private String mIconImageUrl;
   private int mImpressionMinTimeViewed = 1000;
   private final Set mImpressionTrackers = new HashSet();
   private boolean mIsOverridingClickTracker;
   private boolean mIsOverridingImpressionTracker;
   private String mMainImageUrl;
   private BaseForwardingNativeAd$NativeEventListener mNativeEventListener;
   private Double mStarRating;
   private String mText;
   private String mTitle;

   static void preCacheImages(Context var0, List var1, final CustomEventNative$ImageListener var2) {
      ImageLoader var6 = Networking.getImageLoader(var0);
      final AtomicInteger var4 = new AtomicInteger(var1.size());
      final AtomicBoolean var3 = new AtomicBoolean(false);
      ImageLoader$ImageListener var8 = new ImageLoader$ImageListener() {
         public void onErrorResponse(VolleyError var1) {
            MoPubLog.d("Failed to download a native ads image:", var1);
            boolean var2x = var3.getAndSet(true);
            var4.decrementAndGet();
            if(!var2x) {
               var2.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
            }

         }

         public void onResponse(ImageLoader$ImageContainer var1, boolean var2x) {
            if(var1.getBitmap() != null && var4.decrementAndGet() == 0 && !var3.get()) {
               var2.onImagesCached();
            }

         }
      };
      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         String var5 = (String)var7.next();
         if(TextUtils.isEmpty(var5)) {
            var3.set(true);
            var2.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
            return;
         }

         var6.get(var5, var8);
      }

   }

   final void addExtra(String var1, Object var2) {
      if(Preconditions$NoThrow.checkNotNull(var1, "addExtra key is not allowed to be null")) {
         this.mExtras.put(var1, var2);
      }
   }

   final void addImpressionTracker(String var1) {
      if(Preconditions$NoThrow.checkNotNull(var1, "impressionTracker url is not allowed to be null")) {
         this.mImpressionTrackers.add(var1);
      }
   }

   public void clear(View var1) {
   }

   public void destroy() {
   }

   public final String getCallToAction() {
      return this.mCallToAction;
   }

   public final String getClickDestinationUrl() {
      return this.mClickDestinationUrl;
   }

   public final Object getExtra(String var1) {
      return !Preconditions$NoThrow.checkNotNull(var1, "getExtra key is not allowed to be null")?null:this.mExtras.get(var1);
   }

   public final Map getExtras() {
      return new HashMap(this.mExtras);
   }

   public final String getIconImageUrl() {
      return this.mIconImageUrl;
   }

   public final int getImpressionMinPercentageViewed() {
      return 50;
   }

   public final int getImpressionMinTimeViewed() {
      return this.mImpressionMinTimeViewed;
   }

   public final Set getImpressionTrackers() {
      return new HashSet(this.mImpressionTrackers);
   }

   public final String getMainImageUrl() {
      return this.mMainImageUrl;
   }

   public final Double getStarRating() {
      return this.mStarRating;
   }

   public final String getText() {
      return this.mText;
   }

   public final String getTitle() {
      return this.mTitle;
   }

   public void handleClick(View var1) {
   }

   public final boolean isOverridingClickTracker() {
      return this.mIsOverridingClickTracker;
   }

   public final boolean isOverridingImpressionTracker() {
      return this.mIsOverridingImpressionTracker;
   }

   protected final void notifyAdClicked() {
      if(this.mNativeEventListener != null) {
         this.mNativeEventListener.onAdClicked();
      }

   }

   protected final void notifyAdImpressed() {
      if(this.mNativeEventListener != null) {
         this.mNativeEventListener.onAdImpressed();
      }

   }

   public void prepare(View var1) {
   }

   public void recordImpression() {
   }

   final void setCallToAction(String var1) {
      this.mCallToAction = var1;
   }

   final void setClickDestinationUrl(String var1) {
      this.mClickDestinationUrl = var1;
   }

   final void setIconImageUrl(String var1) {
      this.mIconImageUrl = var1;
   }

   final void setImpressionMinTimeViewed(int var1) {
      if(var1 >= 0) {
         this.mImpressionMinTimeViewed = var1;
      }

   }

   final void setMainImageUrl(String var1) {
      this.mMainImageUrl = var1;
   }

   public final void setNativeEventListener(BaseForwardingNativeAd$NativeEventListener var1) {
      this.mNativeEventListener = var1;
   }

   final void setOverridingClickTracker(boolean var1) {
      this.mIsOverridingClickTracker = var1;
   }

   final void setOverridingImpressionTracker(boolean var1) {
      this.mIsOverridingImpressionTracker = var1;
   }

   final void setStarRating(Double var1) {
      if(var1 == null) {
         this.mStarRating = null;
      } else if(var1.doubleValue() >= 0.0D && var1.doubleValue() <= 5.0D) {
         this.mStarRating = var1;
      } else {
         MoPubLog.d("Ignoring attempt to set invalid star rating (" + var1 + "). Must be between " + 0.0D + " and 5.0" + ".");
      }
   }

   final void setText(String var1) {
      this.mText = var1;
   }

   final void setTitle(String var1) {
      this.mTitle = var1;
   }
}
