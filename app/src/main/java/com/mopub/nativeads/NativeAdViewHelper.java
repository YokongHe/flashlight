package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.ImpressionTracker;
import com.mopub.nativeads.MoPubNativeAdRenderer;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.ViewBinder;
import java.util.WeakHashMap;

@Deprecated
class NativeAdViewHelper {
   @VisibleForTesting
   static final WeakHashMap sImpressionTrackerMap = new WeakHashMap();
   private static final WeakHashMap sNativeResponseMap = new WeakHashMap();

   private static void clearNativeResponse(Context var0, View var1) {
      getImpressionTracker(var0).removeView(var1);
      NativeResponse var2 = (NativeResponse)sNativeResponseMap.get(var1);
      if(var2 != null) {
         var2.clear(var1);
      }

   }

   @Deprecated
   static View getAdView(View var0, ViewGroup var1, Context var2, NativeResponse var3, ViewBinder var4) {
      MoPubNativeAdRenderer var5 = new MoPubNativeAdRenderer(var4);
      View var6 = var0;
      if(var0 == null) {
         var6 = var5.createAdView(var2, var1);
      }

      clearNativeResponse(var2, var6);
      if(var3.isDestroyed()) {
         MoPubLog.d("NativeResponse is destroyed, returning hidden view.");
         var6.setVisibility(8);
         return var6;
      } else {
         prepareNativeResponse(var2, var6, var3);
         var5.renderAdView(var6, var3);
         return var6;
      }
   }

   private static ImpressionTracker getImpressionTracker(Context var0) {
      ImpressionTracker var2 = (ImpressionTracker)sImpressionTrackerMap.get(var0);
      ImpressionTracker var1 = var2;
      if(var2 == null) {
         var1 = new ImpressionTracker(var0);
         sImpressionTrackerMap.put(var0, var1);
      }

      return var1;
   }

   private static void prepareNativeResponse(Context var0, View var1, NativeResponse var2) {
      sNativeResponseMap.put(var1, var2);
      if(!var2.isOverridingImpressionTracker()) {
         getImpressionTracker(var0).addView(var1, var2);
      }

      var2.prepare(var1);
   }
}
