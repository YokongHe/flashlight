package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.millennialmedia.android.MMWebView;
import java.lang.ref.WeakReference;

class MMWebView$WebTouchListener implements OnTouchListener {
   WeakReference webRef;

   MMWebView$WebTouchListener(MMWebView var1) {
      this.webRef = new WeakReference(var1);
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      MMWebView var4 = (MMWebView)this.webRef.get();
      boolean var3;
      if(var2.getAction() == 2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var4 != null?var3 && var4.canScroll():var3;
   }
}
