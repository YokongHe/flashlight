package com.mopub.nativeads;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;

class VisibilityTracker$VisibilityChecker {
   private final Rect mClipRect = new Rect();

   boolean hasRequiredTimeElapsed(long var1, int var3) {
      return SystemClock.uptimeMillis() - var1 >= (long)var3;
   }

   boolean isVisible(View var1, int var2) {
      if(var1 != null && var1.getVisibility() == 0 && var1.getParent() != null && var1.getGlobalVisibleRect(this.mClipRect)) {
         long var3 = (long)this.mClipRect.height();
         long var5 = (long)this.mClipRect.width();
         long var7 = (long)var1.getHeight() * (long)var1.getWidth();
         if(var7 > 0L && var3 * var5 * 100L >= var7 * (long)var2) {
            return true;
         }
      }

      return false;
   }
}
