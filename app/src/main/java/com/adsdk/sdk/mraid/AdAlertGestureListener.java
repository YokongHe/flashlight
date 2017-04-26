package com.adsdk.sdk.mraid;

import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.adsdk.sdk.mraid.AdAlertGestureListener$ZigZagState;

public class AdAlertGestureListener extends SimpleOnGestureListener {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState;
   private static final float MAXIMUM_THRESHOLD_X_IN_DIPS = 100.0F;
   private static final float MAXIMUM_THRESHOLD_Y_IN_DIPS = 50.0F;
   private static final int MINIMUM_NUMBER_OF_ZIGZAGS_TO_FLAG = 4;
   private float mCurrentThresholdInDips = 100.0F;
   private AdAlertGestureListener$ZigZagState mCurrentZigZagState;
   private boolean mHasCrossedLeftThreshold;
   private boolean mHasCrossedRightThreshold;
   private int mNumberOfZigZags;
   private float mPivotPositionX;
   private float mPreviousPositionX;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState() {
      int[] var0 = $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[AdAlertGestureListener$ZigZagState.values().length];

         try {
            var0[AdAlertGestureListener$ZigZagState.FAILED.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[AdAlertGestureListener$ZigZagState.FINISHED.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[AdAlertGestureListener$ZigZagState.GOING_LEFT.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[AdAlertGestureListener$ZigZagState.GOING_RIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[AdAlertGestureListener$ZigZagState.UNSET.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState = var0;
         return var0;
      }
   }

   AdAlertGestureListener(View var1) {
      this.mCurrentZigZagState = AdAlertGestureListener$ZigZagState.UNSET;
      if(var1 != null && var1.getWidth() > 0) {
         this.mCurrentThresholdInDips = Math.min(100.0F, (float)var1.getWidth() / 3.0F);
      }

   }

   private void incrementNumberOfZigZags() {
      ++this.mNumberOfZigZags;
      if(this.mNumberOfZigZags >= 4) {
         this.mCurrentZigZagState = AdAlertGestureListener$ZigZagState.FINISHED;
      }

   }

   private boolean isMovingLeft(float var1) {
      return var1 < this.mPreviousPositionX;
   }

   private boolean isMovingRight(float var1) {
      return var1 > this.mPreviousPositionX;
   }

   private boolean isTouchOutOfBoundsOnYAxis(float var1, float var2) {
      return Math.abs(var2 - var1) > 50.0F;
   }

   private boolean leftThresholdReached(float var1) {
      if(this.mHasCrossedLeftThreshold) {
         return true;
      } else if(var1 <= this.mPivotPositionX - this.mCurrentThresholdInDips) {
         this.mHasCrossedRightThreshold = false;
         this.mHasCrossedLeftThreshold = true;
         this.incrementNumberOfZigZags();
         return true;
      } else {
         return false;
      }
   }

   private boolean rightThresholdReached(float var1) {
      if(this.mHasCrossedRightThreshold) {
         return true;
      } else if(var1 >= this.mPivotPositionX + this.mCurrentThresholdInDips) {
         this.mHasCrossedLeftThreshold = false;
         this.mHasCrossedRightThreshold = true;
         return true;
      } else {
         return false;
      }
   }

   private void updateInitialState(float var1) {
      if(var1 > this.mPivotPositionX) {
         this.mCurrentZigZagState = AdAlertGestureListener$ZigZagState.GOING_RIGHT;
      }

   }

   private void updateZag(float var1) {
      if(this.leftThresholdReached(var1) && this.isMovingRight(var1)) {
         this.mCurrentZigZagState = AdAlertGestureListener$ZigZagState.GOING_RIGHT;
         this.mPivotPositionX = var1;
      }

   }

   private void updateZig(float var1) {
      if(this.rightThresholdReached(var1) && this.isMovingLeft(var1)) {
         this.mCurrentZigZagState = AdAlertGestureListener$ZigZagState.GOING_LEFT;
         this.mPivotPositionX = var1;
      }

   }

   void finishGestureDetection() {
      this.reset();
   }

   @Deprecated
   AdAlertGestureListener$ZigZagState getCurrentZigZagState() {
      return this.mCurrentZigZagState;
   }

   @Deprecated
   float getMinimumDipsInZigZag() {
      return this.mCurrentThresholdInDips;
   }

   @Deprecated
   int getNumberOfZigzags() {
      return this.mNumberOfZigZags;
   }

   public boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
      if(this.mCurrentZigZagState == AdAlertGestureListener$ZigZagState.FINISHED) {
         return super.onScroll(var1, var2, var3, var4);
      } else if(this.isTouchOutOfBoundsOnYAxis(var1.getY(), var2.getY())) {
         this.mCurrentZigZagState = AdAlertGestureListener$ZigZagState.FAILED;
         return super.onScroll(var1, var2, var3, var4);
      } else {
         switch($SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState()[this.mCurrentZigZagState.ordinal()]) {
         case 1:
            this.mPivotPositionX = var1.getX();
            this.updateInitialState(var2.getX());
            break;
         case 2:
            this.updateZig(var2.getX());
            break;
         case 3:
            this.updateZag(var2.getX());
         }

         this.mPreviousPositionX = var2.getX();
         return super.onScroll(var1, var2, var3, var4);
      }
   }

   void reset() {
      this.mNumberOfZigZags = 0;
      this.mCurrentZigZagState = AdAlertGestureListener$ZigZagState.UNSET;
   }
}
