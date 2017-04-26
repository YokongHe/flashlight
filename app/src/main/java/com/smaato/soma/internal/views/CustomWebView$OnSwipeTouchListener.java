package com.smaato.soma.internal.views;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.smaato.soma.internal.views.CustomWebView;
import com.smaato.soma.internal.views.CustomWebView$OnSwipeTouchListener$GestureListener;

public class CustomWebView$OnSwipeTouchListener implements OnTouchListener {
   // $FF: synthetic field
   final CustomWebView this$0;

   public CustomWebView$OnSwipeTouchListener(CustomWebView var1, Context var2) {
      this.this$0 = var1;
      CustomWebView.access$1(var1, new GestureDetector(var2, new CustomWebView$OnSwipeTouchListener$GestureListener(this, (CustomWebView$OnSwipeTouchListener$GestureListener)null)));
   }

   // $FF: synthetic method
   static CustomWebView access$0(CustomWebView$OnSwipeTouchListener var0) {
      return var0.this$0;
   }

   public void onSwipeLeft() {
   }

   public void onSwipeRight() {
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      return false;
   }
}
