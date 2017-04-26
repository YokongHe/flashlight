package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.VisibilityTracker$TrackingInfo;
import com.mopub.nativeads.VisibilityTracker$VisibilityChecker;
import com.mopub.nativeads.VisibilityTracker$VisibilityRunnable;
import com.mopub.nativeads.VisibilityTracker$VisibilityTrackerListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;

class VisibilityTracker {
   @VisibleForTesting
   static final int NUM_ACCESSES_BEFORE_TRIMMING = 50;
   private static final int VISIBILITY_THROTTLE_MILLIS = 100;
   private long mAccessCounter;
   private boolean mIsVisibilityScheduled;
   @VisibleForTesting
   OnPreDrawListener mOnPreDrawListener;
   @VisibleForTesting
   final WeakReference mRootView;
   private final Map mTrackedViews;
   private final ArrayList mTrimmedViews;
   private final VisibilityTracker$VisibilityChecker mVisibilityChecker;
   private final Handler mVisibilityHandler;
   private final VisibilityTracker$VisibilityRunnable mVisibilityRunnable;
   private VisibilityTracker$VisibilityTrackerListener mVisibilityTrackerListener;

   public VisibilityTracker(Context var1) {
      this(var1, new WeakHashMap(10), new VisibilityTracker$VisibilityChecker(), new Handler());
   }

   @VisibleForTesting
   VisibilityTracker(Context var1, Map var2, VisibilityTracker$VisibilityChecker var3, Handler var4) {
      this.mAccessCounter = 0L;
      this.mTrackedViews = var2;
      this.mVisibilityChecker = var3;
      this.mVisibilityHandler = var4;
      this.mVisibilityRunnable = new VisibilityTracker$VisibilityRunnable(this);
      this.mTrimmedViews = new ArrayList(50);
      View var5 = ((Activity)var1).getWindow().getDecorView();
      this.mRootView = new WeakReference(var5);
      ViewTreeObserver var6 = var5.getViewTreeObserver();
      if(!var6.isAlive()) {
         MoPubLog.w("Visibility Tracker was unable to track views because the root view tree observer was not alive");
      } else {
         this.mOnPreDrawListener = new OnPreDrawListener() {
            public boolean onPreDraw() {
               VisibilityTracker.this.scheduleVisibilityCheck();
               return true;
            }
         };
         var6.addOnPreDrawListener(this.mOnPreDrawListener);
      }
   }

   // $FF: synthetic method
   static void access$0(VisibilityTracker var0, boolean var1) {
      var0.mIsVisibilityScheduled = var1;
   }

   // $FF: synthetic method
   static Map access$1(VisibilityTracker var0) {
      return var0.mTrackedViews;
   }

   // $FF: synthetic method
   static VisibilityTracker$VisibilityChecker access$2(VisibilityTracker var0) {
      return var0.mVisibilityChecker;
   }

   // $FF: synthetic method
   static VisibilityTracker$VisibilityTrackerListener access$3(VisibilityTracker var0) {
      return var0.mVisibilityTrackerListener;
   }

   private void trimTrackedViews(long var1) {
      Iterator var3 = this.mTrackedViews.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if(((VisibilityTracker$TrackingInfo)var4.getValue()).mAccessOrder < var1) {
            this.mTrimmedViews.add((View)var4.getKey());
         }
      }

      var3 = this.mTrimmedViews.iterator();

      while(var3.hasNext()) {
         this.removeView((View)var3.next());
      }

      this.mTrimmedViews.clear();
   }

   void addView(View var1, int var2) {
      VisibilityTracker$TrackingInfo var4 = (VisibilityTracker$TrackingInfo)this.mTrackedViews.get(var1);
      VisibilityTracker$TrackingInfo var3 = var4;
      if(var4 == null) {
         var3 = new VisibilityTracker$TrackingInfo();
         this.mTrackedViews.put(var1, var3);
         this.scheduleVisibilityCheck();
      }

      var3.mMinViewablePercent = var2;
      var3.mAccessOrder = (long)(this.mAccessCounter++);
      if(this.mAccessCounter % 50L == 0L) {
         this.trimTrackedViews(this.mAccessCounter - 50L);
      }

   }

   void clear() {
      this.mTrackedViews.clear();
      this.mVisibilityHandler.removeMessages(0);
      this.mIsVisibilityScheduled = false;
   }

   void destroy() {
      this.clear();
      View var1 = (View)this.mRootView.get();
      if(var1 != null && this.mOnPreDrawListener != null) {
         ViewTreeObserver var2 = var1.getViewTreeObserver();
         if(var2.isAlive()) {
            var2.removeOnPreDrawListener(this.mOnPreDrawListener);
         }

         this.mOnPreDrawListener = null;
      }

      this.mVisibilityTrackerListener = null;
   }

   void removeView(View var1) {
      this.mTrackedViews.remove(var1);
   }

   void scheduleVisibilityCheck() {
      if(!this.mIsVisibilityScheduled) {
         this.mIsVisibilityScheduled = true;
         this.mVisibilityHandler.postDelayed(this.mVisibilityRunnable, 100L);
      }
   }

   void setVisibilityTrackerListener(VisibilityTracker$VisibilityTrackerListener var1) {
      this.mVisibilityTrackerListener = var1;
   }
}
