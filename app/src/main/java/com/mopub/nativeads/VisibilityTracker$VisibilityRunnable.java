package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.VisibilityTracker;
import com.mopub.nativeads.VisibilityTracker$TrackingInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

class VisibilityTracker$VisibilityRunnable implements Runnable {
   private final ArrayList mInvisibleViews;
   private final ArrayList mVisibleViews;
   // $FF: synthetic field
   final VisibilityTracker this$0;

   VisibilityTracker$VisibilityRunnable(VisibilityTracker var1) {
      this.this$0 = var1;
      this.mInvisibleViews = new ArrayList();
      this.mVisibleViews = new ArrayList();
   }

   public void run() {
      VisibilityTracker.access$0(this.this$0, false);
      Iterator var2 = VisibilityTracker.access$1(this.this$0).entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         View var4 = (View)var3.getKey();
         int var1 = ((VisibilityTracker$TrackingInfo)var3.getValue()).mMinViewablePercent;
         if(VisibilityTracker.access$2(this.this$0).isVisible(var4, var1)) {
            this.mVisibleViews.add(var4);
         } else {
            this.mInvisibleViews.add(var4);
         }
      }

      if(VisibilityTracker.access$3(this.this$0) != null) {
         VisibilityTracker.access$3(this.this$0).onVisibilityChanged(this.mVisibleViews, this.mInvisibleViews);
      }

      this.mVisibleViews.clear();
      this.mInvisibleViews.clear();
   }
}
