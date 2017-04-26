package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.ImpressionTracker$PollingRunnable;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.TimestampWrapper;
import com.mopub.nativeads.VisibilityTracker;
import com.mopub.nativeads.VisibilityTracker$VisibilityChecker;
import com.mopub.nativeads.VisibilityTracker$VisibilityTrackerListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

class ImpressionTracker {
   private static final int PERIOD = 250;
   private final Handler mPollHandler;
   private final ImpressionTracker$PollingRunnable mPollingRunnable;
   private final Map mPollingViews;
   private final Map mTrackedViews;
   private final VisibilityTracker$VisibilityChecker mVisibilityChecker;
   private final VisibilityTracker mVisibilityTracker;
   private VisibilityTracker$VisibilityTrackerListener mVisibilityTrackerListener;

   ImpressionTracker(Context var1) {
      this(new WeakHashMap(), new WeakHashMap(), new VisibilityTracker$VisibilityChecker(), new VisibilityTracker(var1), new Handler());
   }

   @VisibleForTesting
   ImpressionTracker(Map var1, Map var2, VisibilityTracker$VisibilityChecker var3, VisibilityTracker var4, Handler var5) {
      this.mTrackedViews = var1;
      this.mPollingViews = var2;
      this.mVisibilityChecker = var3;
      this.mVisibilityTracker = var4;
      this.mVisibilityTrackerListener = new VisibilityTracker$VisibilityTrackerListener() {
         public void onVisibilityChanged(List var1, List var2) {
            Iterator var6 = var1.iterator();

            while(true) {
               while(var6.hasNext()) {
                  View var3 = (View)var6.next();
                  NativeResponse var4 = (NativeResponse)ImpressionTracker.this.mTrackedViews.get(var3);
                  if(var4 == null) {
                     ImpressionTracker.this.removeView(var3);
                  } else {
                     TimestampWrapper var5 = (TimestampWrapper)ImpressionTracker.this.mPollingViews.get(var3);
                     if(var5 == null || !var4.equals(var5.mInstance)) {
                        ImpressionTracker.this.mPollingViews.put(var3, new TimestampWrapper(var4));
                     }
                  }
               }

               var6 = var2.iterator();

               while(var6.hasNext()) {
                  View var7 = (View)var6.next();
                  ImpressionTracker.this.mPollingViews.remove(var7);
               }

               ImpressionTracker.this.scheduleNextPoll();
               return;
            }
         }
      };
      this.mVisibilityTracker.setVisibilityTrackerListener(this.mVisibilityTrackerListener);
      this.mPollHandler = var5;
      this.mPollingRunnable = new ImpressionTracker$PollingRunnable(this);
   }

   // $FF: synthetic method
   static VisibilityTracker$VisibilityChecker access$1(ImpressionTracker var0) {
      return var0.mVisibilityChecker;
   }

   private void removePollingView(View var1) {
      this.mPollingViews.remove(var1);
   }

   void addView(View var1, NativeResponse var2) {
      if(this.mTrackedViews.get(var1) != var2) {
         this.removeView(var1);
         if(!var2.getRecordedImpression() && !var2.isDestroyed()) {
            this.mTrackedViews.put(var1, var2);
            this.mVisibilityTracker.addView(var1, var2.getImpressionMinPercentageViewed());
            return;
         }
      }

   }

   void clear() {
      this.mTrackedViews.clear();
      this.mPollingViews.clear();
      this.mVisibilityTracker.clear();
      this.mPollHandler.removeMessages(0);
   }

   void destroy() {
      this.clear();
      this.mVisibilityTracker.destroy();
      this.mVisibilityTrackerListener = null;
   }

   @Deprecated
   @VisibleForTesting
   VisibilityTracker$VisibilityTrackerListener getVisibilityTrackerListener() {
      return this.mVisibilityTrackerListener;
   }

   void removeView(View var1) {
      this.mTrackedViews.remove(var1);
      this.removePollingView(var1);
      this.mVisibilityTracker.removeView(var1);
   }

   @VisibleForTesting
   void scheduleNextPoll() {
      if(!this.mPollHandler.hasMessages(0)) {
         this.mPollHandler.postDelayed(this.mPollingRunnable, 250L);
      }
   }
}
