package com.millennialmedia.android;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.millennialmedia.android.AdViewOverlayView;
import com.millennialmedia.android.MMLog;
import java.lang.ref.WeakReference;

class AdViewOverlayView$AnimationListener implements AnimationListener {
   private WeakReference overlayRef;

   public AdViewOverlayView$AnimationListener(AdViewOverlayView var1) {
      this.overlayRef = new WeakReference(var1);
   }

   public void onAnimationEnd(Animation var1) {
      AdViewOverlayView var2 = (AdViewOverlayView)this.overlayRef.get();
      if(var2 != null) {
         Activity var3 = (Activity)var2.getContext();
         MMLog.d("AdViewOverlayView", "Finishing overlay this is in w/ anim finishOverLayWithAnim()");
         var3.finish();
      }

   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
      AdViewOverlayView var2 = (AdViewOverlayView)this.overlayRef.get();
      if(var2 != null && AdViewOverlayView.access$300(var2) != null) {
         AdViewOverlayView.access$300(var2).setVisibility(8);
      }

   }
}
