package com.adsdk.sdk.mraid;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.adsdk.sdk.mraid.AdAlertGestureListener;
import com.adsdk.sdk.mraid.ViewGestureDetector$UserClickListener;

public class ViewGestureDetector extends GestureDetector {
   private AdAlertGestureListener mAdAlertGestureListener;
   private ViewGestureDetector$UserClickListener mUserClickListener;
   private final View mView;

   public ViewGestureDetector(Context var1, View var2) {
      this(var1, var2, new AdAlertGestureListener(var2));
   }

   private ViewGestureDetector(Context var1, View var2, AdAlertGestureListener var3) {
      super(var1, var3);
      this.mAdAlertGestureListener = var3;
      this.mView = var2;
      this.setIsLongpressEnabled(false);
   }

   private boolean isMotionEventInView(MotionEvent var1, View var2) {
      if(var1 != null && var2 != null) {
         float var3 = var1.getX();
         float var4 = var1.getY();
         if(var3 >= 0.0F && var3 <= (float)var2.getWidth() && var4 >= 0.0F && var4 <= (float)var2.getHeight()) {
            return true;
         }
      }

      return false;
   }

   void resetAdFlaggingGesture() {
      this.mAdAlertGestureListener.reset();
   }

   void sendTouchEvent(MotionEvent var1) {
      switch(var1.getAction()) {
      case 0:
         this.onTouchEvent(var1);
         return;
      case 1:
         if(this.mUserClickListener != null) {
            this.mUserClickListener.onUserClick();
         } else {
            Log.d("MoPub", "View\'s onUserClick() is not registered.");
         }

         this.mAdAlertGestureListener.finishGestureDetection();
         return;
      case 2:
         if(this.isMotionEventInView(var1, this.mView)) {
            this.onTouchEvent(var1);
            return;
         }

         this.resetAdFlaggingGesture();
         return;
      default:
      }
   }

   @Deprecated
   void setAdAlertGestureListener(AdAlertGestureListener var1) {
      this.mAdAlertGestureListener = var1;
   }

   void setUserClickListener(ViewGestureDetector$UserClickListener var1) {
      this.mUserClickListener = var1;
   }
}
