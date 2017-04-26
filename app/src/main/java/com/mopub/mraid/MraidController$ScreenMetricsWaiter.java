package com.mopub.mraid;

import android.os.Handler;
import android.view.View;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController$ScreenMetricsWaiter$WaitRequest;

@VisibleForTesting
class MraidController$ScreenMetricsWaiter {
   private final Handler mHandler = new Handler();
   private MraidController$ScreenMetricsWaiter$WaitRequest mLastWaitRequest;

   void cancelLastRequest() {
      if(this.mLastWaitRequest != null) {
         this.mLastWaitRequest.cancel();
         this.mLastWaitRequest = null;
      }

   }

   MraidController$ScreenMetricsWaiter$WaitRequest waitFor(View... var1) {
      this.mLastWaitRequest = new MraidController$ScreenMetricsWaiter$WaitRequest(this.mHandler, var1, (MraidController$ScreenMetricsWaiter$WaitRequest)null);
      return this.mLastWaitRequest;
   }
}
