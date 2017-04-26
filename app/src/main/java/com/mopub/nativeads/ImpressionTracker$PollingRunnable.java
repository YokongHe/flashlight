package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.ImpressionTracker;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.TimestampWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

@VisibleForTesting
class ImpressionTracker$PollingRunnable implements Runnable {
   private final ArrayList mRemovedViews;
   // $FF: synthetic field
   final ImpressionTracker this$0;

   ImpressionTracker$PollingRunnable(ImpressionTracker var1) {
      this.this$0 = var1;
      this.mRemovedViews = new ArrayList();
   }

   public void run() {
      Iterator var1 = ImpressionTracker.access$0(this.this$0).entrySet().iterator();

      View var2;
      while(var1.hasNext()) {
         Entry var3 = (Entry)var1.next();
         var2 = (View)var3.getKey();
         TimestampWrapper var4 = (TimestampWrapper)var3.getValue();
         if(ImpressionTracker.access$1(this.this$0).hasRequiredTimeElapsed(var4.mCreatedTimestamp, ((NativeResponse)var4.mInstance).getImpressionMinTimeViewed())) {
            ((NativeResponse)var4.mInstance).recordImpression(var2);
            this.mRemovedViews.add(var2);
         }
      }

      var1 = this.mRemovedViews.iterator();

      while(var1.hasNext()) {
         var2 = (View)var1.next();
         this.this$0.removeView(var2);
      }

      this.mRemovedViews.clear();
      if(!ImpressionTracker.access$0(this.this$0).isEmpty()) {
         this.this$0.scheduleNextPoll();
      }

   }
}
