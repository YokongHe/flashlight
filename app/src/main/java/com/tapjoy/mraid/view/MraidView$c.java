package com.tapjoy.mraid.view;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.tapjoy.mraid.view.MraidView;

final class MraidView$c extends SimpleOnGestureListener {
   // $FF: synthetic field
   final MraidView a;

   MraidView$c(MraidView var1) {
      this.a = var1;
   }

   public final boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
      return true;
   }
}
