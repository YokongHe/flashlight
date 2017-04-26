package com.smaato.soma.internal.views;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.views.CustomWebView$OnSwipeTouchListener;

final class CustomWebView$OnSwipeTouchListener$GestureListener extends SimpleOnGestureListener {
   boolean lastWasLeft;
   boolean lastWasRight;
   // $FF: synthetic field
   final CustomWebView$OnSwipeTouchListener this$1;

   private CustomWebView$OnSwipeTouchListener$GestureListener(CustomWebView$OnSwipeTouchListener var1) {
      this.this$1 = var1;
      this.lastWasLeft = false;
      this.lastWasRight = false;
   }

   // $FF: synthetic method
   CustomWebView$OnSwipeTouchListener$GestureListener(CustomWebView$OnSwipeTouchListener var1, CustomWebView$OnSwipeTouchListener$GestureListener var2) {
      this(var1);
   }

   // $FF: synthetic method
   static CustomWebView$OnSwipeTouchListener access$1(CustomWebView$OnSwipeTouchListener$GestureListener var0) {
      return var0.this$1;
   }

   public final boolean onDown(MotionEvent var1) {
      return true;
   }

   public final boolean onScroll(MotionEvent var1, MotionEvent var2, final float var3, float var4) {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            // $FF: Couldn't be decompiled
         }
      }).execute()).booleanValue();
   }
}
