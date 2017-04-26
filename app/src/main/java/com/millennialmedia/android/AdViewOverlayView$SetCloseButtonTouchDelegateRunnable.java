package com.millennialmedia.android;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;

class AdViewOverlayView$SetCloseButtonTouchDelegateRunnable implements Runnable {
   int bottom;
   private final Button closeButton;
   int left;
   int right;
   int top;

   AdViewOverlayView$SetCloseButtonTouchDelegateRunnable(Button var1, int var2, int var3, int var4, int var5) {
      this.closeButton = var1;
      this.top = var2;
      this.left = var3;
      this.bottom = var4;
      this.right = var5;
   }

   public void run() {
      Rect var1 = new Rect();
      this.closeButton.getHitRect(var1);
      var1.top += this.top;
      var1.right += this.right;
      var1.bottom += this.bottom;
      var1.left += this.left;
      TouchDelegate var2 = new TouchDelegate(var1, this.closeButton);
      if(View.class.isInstance(this.closeButton.getParent())) {
         ((View)this.closeButton.getParent()).setTouchDelegate(var2);
      }

   }
}
