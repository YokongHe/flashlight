package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.MoPubEvents$Type;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.BaseForwardingNativeAd$NativeEventListener;
import com.mopub.nativeads.ClickDestinationResolutionListener;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubNative$MoPubNativeEventListener;
import com.mopub.nativeads.NativeAdInterface;
import com.mopub.nativeads.NativeResponse$NativeViewClickListener;
import com.mopub.nativeads.NativeResponse$Parameter;
import com.mopub.nativeads.SpinningProgressView;
import com.mopub.nativeads.UrlResolutionTask;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader$ImageContainer;
import com.mopub.volley.toolbox.ImageLoader$ImageListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NativeResponse {
   private final String mAdUnitId;
   private final Context mContext;
   private final ImageLoader mImageLoader;
   private boolean mIsClicked;
   private boolean mIsDestroyed;
   private final String mMoPubClickTracker;
   private final Set mMoPubImpressionTrackers;
   private MoPubNative$MoPubNativeEventListener mMoPubNativeEventListener;
   private final NativeAdInterface mNativeAd;
   private boolean mRecordedImpression;

   public NativeResponse(Context var1, String var2, String var3, String var4, NativeAdInterface var5, MoPubNative$MoPubNativeEventListener var6) {
      this.mContext = var1.getApplicationContext();
      this.mAdUnitId = var4;
      this.mMoPubNativeEventListener = var6;
      this.mNativeAd = var5;
      this.mNativeAd.setNativeEventListener(new BaseForwardingNativeAd$NativeEventListener() {
         public void onAdClicked() {
            NativeResponse.this.handleClick((View)null);
         }

         public void onAdImpressed() {
            NativeResponse.this.recordImpression((View)null);
         }
      });
      this.mMoPubImpressionTrackers = new HashSet();
      this.mMoPubImpressionTrackers.add(var2);
      this.mMoPubClickTracker = var3;
      this.mImageLoader = Networking.getImageLoader(var1);
   }

   private void loadImageView(String var1, final ImageView var2) {
      if(var2 != null) {
         if(var1 == null) {
            var2.setImageDrawable((Drawable)null);
         } else {
            this.mImageLoader.get(var1, new ImageLoader$ImageListener() {
               public void onErrorResponse(VolleyError var1) {
                  MoPubLog.d("Failed to load image.", var1);
                  var2.setImageDrawable((Drawable)null);
               }

               public void onResponse(ImageLoader$ImageContainer var1, boolean var2x) {
                  if(!var2x) {
                     MoPubLog.d("Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
                  }

                  var2.setImageBitmap(var1.getBitmap());
               }
            });
         }
      }
   }

   private void openClickDestinationUrl(View var1) {
      if(this.getClickDestinationUrl() != null) {
         SpinningProgressView var2 = null;
         if(var1 != null) {
            var2 = new SpinningProgressView(this.mContext);
            var2.addToRoot(var1);
         }

         Iterator var3 = Arrays.asList(new String[]{this.getClickDestinationUrl()}).iterator();
         ClickDestinationResolutionListener var4 = new ClickDestinationResolutionListener(this.mContext, var3, var2);
         UrlResolutionTask.getResolvedUrl((String)var3.next(), var4);
      }
   }

   private void setOnClickListener(View var1, OnClickListener var2) {
      var1.setOnClickListener(var2);
      if(var1 instanceof ViewGroup) {
         ViewGroup var4 = (ViewGroup)var1;

         for(int var3 = 0; var3 < var4.getChildCount(); ++var3) {
            this.setOnClickListener(var4.getChildAt(var3), var2);
         }
      }

   }

   public void clear(View var1) {
      this.setOnClickListener(var1, (OnClickListener)null);
      this.mNativeAd.clear(var1);
   }

   public void destroy() {
      if(!this.isDestroyed()) {
         this.mMoPubNativeEventListener = MoPubNative.EMPTY_EVENT_LISTENER;
         this.mNativeAd.destroy();
         this.mIsDestroyed = true;
      }
   }

   public String getAdUnitId() {
      return this.mAdUnitId;
   }

   public String getCallToAction() {
      return this.mNativeAd.getCallToAction();
   }

   public String getClickDestinationUrl() {
      return this.mNativeAd.getClickDestinationUrl();
   }

   public String getClickTracker() {
      return this.mMoPubClickTracker;
   }

   public Object getExtra(String var1) {
      return this.mNativeAd.getExtra(var1);
   }

   public Map getExtras() {
      return this.mNativeAd.getExtras();
   }

   public String getIconImageUrl() {
      return this.mNativeAd.getIconImageUrl();
   }

   public int getImpressionMinPercentageViewed() {
      return this.mNativeAd.getImpressionMinPercentageViewed();
   }

   public int getImpressionMinTimeViewed() {
      return this.mNativeAd.getImpressionMinTimeViewed();
   }

   public List getImpressionTrackers() {
      HashSet var1 = new HashSet();
      var1.addAll(this.mMoPubImpressionTrackers);
      var1.addAll(this.mNativeAd.getImpressionTrackers());
      return new ArrayList(var1);
   }

   public String getMainImageUrl() {
      return this.mNativeAd.getMainImageUrl();
   }

   @Deprecated
   @VisibleForTesting
   MoPubNative$MoPubNativeEventListener getMoPubNativeEventListener() {
      return this.mMoPubNativeEventListener;
   }

   public boolean getRecordedImpression() {
      return this.mRecordedImpression;
   }

   public Double getStarRating() {
      return this.mNativeAd.getStarRating();
   }

   @Deprecated
   public String getSubtitle() {
      return this.mNativeAd.getText();
   }

   public String getText() {
      return this.mNativeAd.getText();
   }

   public String getTitle() {
      return this.mNativeAd.getTitle();
   }

   public void handleClick(View var1) {
      if(!this.isDestroyed()) {
         if(!this.isClicked()) {
            TrackingRequest.makeTrackingHttpRequest(this.mMoPubClickTracker, this.mContext, MoPubEvents$Type.CLICK_REQUEST);
         }

         this.openClickDestinationUrl(var1);
         this.mNativeAd.handleClick(var1);
         this.mIsClicked = true;
         this.mMoPubNativeEventListener.onNativeClick(var1);
      }
   }

   public boolean isClicked() {
      return this.mIsClicked;
   }

   public boolean isDestroyed() {
      return this.mIsDestroyed;
   }

   public boolean isOverridingClickTracker() {
      return this.mNativeAd.isOverridingClickTracker();
   }

   public boolean isOverridingImpressionTracker() {
      return this.mNativeAd.isOverridingImpressionTracker();
   }

   public void loadExtrasImage(String var1, ImageView var2) {
      Object var3 = this.getExtra(var1);
      if(var3 != null && var3 instanceof String) {
         this.loadImageView((String)var3, var2);
      }

   }

   public void loadIconImage(ImageView var1) {
      this.loadImageView(this.getIconImageUrl(), var1);
   }

   public void loadMainImage(ImageView var1) {
      this.loadImageView(this.getMainImageUrl(), var1);
   }

   public void prepare(View var1) {
      if(!this.isDestroyed()) {
         if(!this.isOverridingClickTracker()) {
            this.setOnClickListener(var1, new NativeResponse$NativeViewClickListener(this));
         }

         this.mNativeAd.prepare(var1);
      }
   }

   public void recordImpression(View var1) {
      if(!this.getRecordedImpression() && !this.isDestroyed()) {
         Iterator var2 = this.getImpressionTrackers().iterator();

         while(var2.hasNext()) {
            TrackingRequest.makeTrackingHttpRequest((String)var2.next(), this.mContext, MoPubEvents$Type.IMPRESSION_REQUEST);
         }

         this.mNativeAd.recordImpression();
         this.mRecordedImpression = true;
         this.mMoPubNativeEventListener.onNativeImpression(var1);
      }
   }

   @Deprecated
   @VisibleForTesting
   void setRecordedImpression(boolean var1) {
      this.mRecordedImpression = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("\n");
      var1.append(NativeResponse$Parameter.TITLE.name).append(":").append(this.getTitle()).append("\n");
      var1.append(NativeResponse$Parameter.TEXT.name).append(":").append(this.getText()).append("\n");
      var1.append(NativeResponse$Parameter.ICON_IMAGE.name).append(":").append(this.getIconImageUrl()).append("\n");
      var1.append(NativeResponse$Parameter.MAIN_IMAGE.name).append(":").append(this.getMainImageUrl()).append("\n");
      var1.append(NativeResponse$Parameter.STAR_RATING.name).append(":").append(this.getStarRating()).append("\n");
      var1.append(NativeResponse$Parameter.IMPRESSION_TRACKER.name).append(":").append(this.getImpressionTrackers()).append("\n");
      var1.append(NativeResponse$Parameter.CLICK_TRACKER.name).append(":").append(this.mMoPubClickTracker).append("\n");
      var1.append(NativeResponse$Parameter.CLICK_DESTINATION.name).append(":").append(this.getClickDestinationUrl()).append("\n");
      var1.append(NativeResponse$Parameter.CALL_TO_ACTION.name).append(":").append(this.getCallToAction()).append("\n");
      var1.append("recordedImpression:").append(this.mRecordedImpression).append("\n");
      var1.append("extras:").append(this.getExtras());
      return var1.toString();
   }
}
