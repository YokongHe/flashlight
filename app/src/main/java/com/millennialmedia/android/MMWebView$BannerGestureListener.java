package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.MMWebView;
import java.lang.ref.WeakReference;

class MMWebView$BannerGestureListener extends SimpleOnGestureListener {
   WeakReference webRef;

   public MMWebView$BannerGestureListener(MMWebView var1) {
      this.webRef = new WeakReference(var1);
   }

   public boolean onSingleTapConfirmed(MotionEvent var1) {
      MMWebView var2 = (MMWebView)this.webRef.get();
      if(var2 != null) {
         MMAdView var3 = var2.getMMAdView();
         if(var3 != null) {
            MMSDK$Event.adSingleTap(var3.adImpl);
         }
      }

      return false;
   }
}
