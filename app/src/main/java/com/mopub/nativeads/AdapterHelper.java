package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions$NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNative$MoPubNativeListener;
import com.mopub.nativeads.NativeAdViewHelper;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.ViewBinder;
import java.lang.ref.WeakReference;

@Deprecated
public final class AdapterHelper {
   private final WeakReference mActivity;
   private final Context mApplicationContext;
   private final int mInterval;
   private final int mStart;

   @Deprecated
   public AdapterHelper(Context var1, int var2, int var3) {
      boolean var5 = true;
      super();
      Preconditions.checkNotNull(var1, "Context cannot be null.");
      Preconditions.checkArgument(var1 instanceof Activity, "Context must be an Activity.");
      boolean var4;
      if(var2 >= 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4, "start position must be non-negative");
      if(var3 >= 2) {
         var4 = var5;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4, "interval must be at least 2");
      this.mActivity = new WeakReference((Activity)var1);
      this.mApplicationContext = var1.getApplicationContext();
      this.mStart = var2;
      this.mInterval = var3;
   }

   private int numberOfAdsSeenUpToPosition(int var1) {
      return var1 <= this.mStart?0:(int)Math.floor((double)(var1 - this.mStart) / (double)this.mInterval) + 1;
   }

   private int numberOfAdsThatCouldFitWithContent(int var1) {
      if(var1 <= this.mStart) {
         return 0;
      } else {
         int var2 = this.mInterval - 1;
         return (var1 - this.mStart) % var2 == 0?(var1 - this.mStart) / var2:(int)Math.floor((double)(var1 - this.mStart) / (double)var2) + 1;
      }
   }

   @Deprecated
   @VisibleForTesting
   final void clearActivityContext() {
      this.mActivity.clear();
   }

   @Deprecated
   public final View getAdView(View var1, ViewGroup var2, NativeResponse var3, ViewBinder var4, MoPubNative$MoPubNativeListener var5) {
      Activity var6 = (Activity)this.mActivity.get();
      if(var6 == null) {
         MoPubLog.w("Weak reference to Activity Context in AdapterHelper became null. Returning empty view.");
         return new View(this.mApplicationContext);
      } else {
         return Preconditions$NoThrow.checkNotNull(var3, "NativeResponse is null. Returning an empty view") && Preconditions$NoThrow.checkNotNull(var4, "ViewBinder is null. Returning empty view")?NativeAdViewHelper.getAdView(var1, var2, var6, var3, var4):new View(var6);
      }
   }

   @Deprecated
   public final boolean isAdPosition(int var1) {
      return var1 >= this.mStart && (var1 - this.mStart) % this.mInterval == 0;
   }

   @Deprecated
   public final int shiftedCount(int var1) {
      return this.numberOfAdsThatCouldFitWithContent(var1) + var1;
   }

   @Deprecated
   public final int shiftedPosition(int var1) {
      return var1 - this.numberOfAdsSeenUpToPosition(var1);
   }
}
