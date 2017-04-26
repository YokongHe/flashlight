package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.BaseForwardingNativeAd$NativeEventListener;
import java.util.Map;
import java.util.Set;

interface NativeAdInterface {
   void clear(View var1);

   void destroy();

   String getCallToAction();

   String getClickDestinationUrl();

   Object getExtra(String var1);

   Map getExtras();

   String getIconImageUrl();

   int getImpressionMinPercentageViewed();

   int getImpressionMinTimeViewed();

   Set getImpressionTrackers();

   String getMainImageUrl();

   Double getStarRating();

   String getText();

   String getTitle();

   void handleClick(View var1);

   boolean isOverridingClickTracker();

   boolean isOverridingImpressionTracker();

   void prepare(View var1);

   void recordImpression();

   void setNativeEventListener(BaseForwardingNativeAd$NativeEventListener var1);
}
