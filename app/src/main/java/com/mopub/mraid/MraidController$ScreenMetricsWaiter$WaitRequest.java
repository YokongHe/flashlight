package com.mopub.mraid;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class MraidController$ScreenMetricsWaiter$WaitRequest {
   private final Handler mHandler;
   private Runnable mSuccessRunnable;
   private final View[] mViews;
   int mWaitCount;
   private final Runnable mWaitingRunnable;

   private MraidController$ScreenMetricsWaiter$WaitRequest(Handler var1, View[] var2) {
      this.mWaitingRunnable = new Runnable() {
         public void run() {
            View[] var3 = MraidController$ScreenMetricsWaiter$WaitRequest.this.mViews;
            int var2 = var3.length;

            for(int var1 = 0; var1 < var2; ++var1) {
               final View var4 = var3[var1];
               if(var4.getHeight() <= 0 && var4.getWidth() <= 0) {
                  var4.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                     public boolean onPreDraw() {
                        var4.getViewTreeObserver().removeOnPreDrawListener(this);
                        MraidController$ScreenMetricsWaiter$WaitRequest.this.countDown();
                        return true;
                     }
                  });
               } else {
                  MraidController$ScreenMetricsWaiter$WaitRequest.this.countDown();
               }
            }

         }
      };
      this.mHandler = var1;
      this.mViews = var2;
   }

   // $FF: synthetic method
   MraidController$ScreenMetricsWaiter$WaitRequest(Handler var1, View[] var2, MraidController$ScreenMetricsWaiter$WaitRequest var3) {
      this(var1, var2);
   }

   private void countDown() {
      --this.mWaitCount;
      if(this.mWaitCount == 0 && this.mSuccessRunnable != null) {
         this.mSuccessRunnable.run();
         this.mSuccessRunnable = null;
      }

   }

   void cancel() {
      this.mHandler.removeCallbacks(this.mWaitingRunnable);
      this.mSuccessRunnable = null;
   }

   void start(Runnable var1) {
      this.mSuccessRunnable = var1;
      this.mWaitCount = this.mViews.length;
      this.mHandler.post(this.mWaitingRunnable);
   }
}
