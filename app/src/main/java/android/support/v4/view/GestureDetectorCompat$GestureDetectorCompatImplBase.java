package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl;
import android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

class GestureDetectorCompat$GestureDetectorCompatImplBase implements GestureDetectorCompat$GestureDetectorCompatImpl {
   private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
   private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
   private static final int LONG_PRESS = 2;
   private static final int SHOW_PRESS = 1;
   private static final int TAP = 3;
   private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
   private boolean mAlwaysInBiggerTapRegion;
   private boolean mAlwaysInTapRegion;
   private MotionEvent mCurrentDownEvent;
   private boolean mDeferConfirmSingleTap;
   private OnDoubleTapListener mDoubleTapListener;
   private int mDoubleTapSlopSquare;
   private float mDownFocusX;
   private float mDownFocusY;
   private final Handler mHandler;
   private boolean mInLongPress;
   private boolean mIsDoubleTapping;
   private boolean mIsLongpressEnabled;
   private float mLastFocusX;
   private float mLastFocusY;
   private final OnGestureListener mListener;
   private int mMaximumFlingVelocity;
   private int mMinimumFlingVelocity;
   private MotionEvent mPreviousUpEvent;
   private boolean mStillDown;
   private int mTouchSlopSquare;
   private VelocityTracker mVelocityTracker;

   public GestureDetectorCompat$GestureDetectorCompatImplBase(Context var1, OnGestureListener var2, Handler var3) {
      if(var3 != null) {
         this.mHandler = new GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(this, var3);
      } else {
         this.mHandler = new GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(this);
      }

      this.mListener = var2;
      if(var2 instanceof OnDoubleTapListener) {
         this.setOnDoubleTapListener((OnDoubleTapListener)var2);
      }

      this.init(var1);
   }

   // $FF: synthetic method
   static MotionEvent access$000(GestureDetectorCompat$GestureDetectorCompatImplBase var0) {
      return var0.mCurrentDownEvent;
   }

   // $FF: synthetic method
   static OnGestureListener access$100(GestureDetectorCompat$GestureDetectorCompatImplBase var0) {
      return var0.mListener;
   }

   // $FF: synthetic method
   static void access$200(GestureDetectorCompat$GestureDetectorCompatImplBase var0) {
      var0.dispatchLongPress();
   }

   // $FF: synthetic method
   static OnDoubleTapListener access$300(GestureDetectorCompat$GestureDetectorCompatImplBase var0) {
      return var0.mDoubleTapListener;
   }

   // $FF: synthetic method
   static boolean access$400(GestureDetectorCompat$GestureDetectorCompatImplBase var0) {
      return var0.mStillDown;
   }

   // $FF: synthetic method
   static boolean access$502(GestureDetectorCompat$GestureDetectorCompatImplBase var0, boolean var1) {
      var0.mDeferConfirmSingleTap = var1;
      return var1;
   }

   private void cancel() {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      this.mIsDoubleTapping = false;
      this.mStillDown = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if(this.mInLongPress) {
         this.mInLongPress = false;
      }

   }

   private void cancelTaps() {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mIsDoubleTapping = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if(this.mInLongPress) {
         this.mInLongPress = false;
      }

   }

   private void dispatchLongPress() {
      this.mHandler.removeMessages(3);
      this.mDeferConfirmSingleTap = false;
      this.mInLongPress = true;
      this.mListener.onLongPress(this.mCurrentDownEvent);
   }

   private void init(Context var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Context must not be null");
      } else if(this.mListener == null) {
         throw new IllegalArgumentException("OnGestureListener must not be null");
      } else {
         this.mIsLongpressEnabled = true;
         ViewConfiguration var4 = ViewConfiguration.get(var1);
         int var2 = var4.getScaledTouchSlop();
         int var3 = var4.getScaledDoubleTapSlop();
         this.mMinimumFlingVelocity = var4.getScaledMinimumFlingVelocity();
         this.mMaximumFlingVelocity = var4.getScaledMaximumFlingVelocity();
         this.mTouchSlopSquare = var2 * var2;
         this.mDoubleTapSlopSquare = var3 * var3;
      }
   }

   private boolean isConsideredDoubleTap(MotionEvent var1, MotionEvent var2, MotionEvent var3) {
      if(this.mAlwaysInBiggerTapRegion && var3.getEventTime() - var2.getEventTime() <= (long)DOUBLE_TAP_TIMEOUT) {
         int var4 = (int)var1.getX() - (int)var3.getX();
         int var5 = (int)var1.getY() - (int)var3.getY();
         if(var4 * var4 + var5 * var5 < this.mDoubleTapSlopSquare) {
            return true;
         }
      }

      return false;
   }

   public boolean isLongpressEnabled() {
      return this.mIsLongpressEnabled;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var10 = var1.getAction();
      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

      this.mVelocityTracker.addMovement(var1);
      boolean var6;
      if((var10 & 255) == 6) {
         var6 = true;
      } else {
         var6 = false;
      }

      int var7;
      if(var6) {
         var7 = MotionEventCompat.getActionIndex(var1);
      } else {
         var7 = -1;
      }

      int var9 = MotionEventCompat.getPointerCount(var1);
      int var8 = 0;
      float var2 = 0.0F;

      float var3;
      float var4;
      float var5;
      for(var3 = 0.0F; var8 < var9; var3 = var4) {
         var5 = var2;
         var4 = var3;
         if(var7 != var8) {
            var4 = var3 + MotionEventCompat.getX(var1, var8);
            var5 = var2 + MotionEventCompat.getY(var1, var8);
         }

         ++var8;
         var2 = var5;
      }

      int var15;
      if(var6) {
         var15 = var9 - 1;
      } else {
         var15 = var9;
      }

      var3 /= (float)var15;
      var2 /= (float)var15;
      boolean var11;
      switch(var10 & 255) {
      case 0:
         label119: {
            if(this.mDoubleTapListener != null) {
               var11 = this.mHandler.hasMessages(3);
               if(var11) {
                  this.mHandler.removeMessages(3);
               }

               if(this.mCurrentDownEvent != null && this.mPreviousUpEvent != null && var11 && this.isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, var1)) {
                  this.mIsDoubleTapping = true;
                  var6 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(var1);
                  break label119;
               }

               this.mHandler.sendEmptyMessageDelayed(3, (long)DOUBLE_TAP_TIMEOUT);
            }

            var6 = false;
         }

         this.mLastFocusX = var3;
         this.mDownFocusX = var3;
         this.mLastFocusY = var2;
         this.mDownFocusY = var2;
         if(this.mCurrentDownEvent != null) {
            this.mCurrentDownEvent.recycle();
         }

         this.mCurrentDownEvent = MotionEvent.obtain(var1);
         this.mAlwaysInTapRegion = true;
         this.mAlwaysInBiggerTapRegion = true;
         this.mStillDown = true;
         this.mInLongPress = false;
         this.mDeferConfirmSingleTap = false;
         if(this.mIsLongpressEnabled) {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT + (long)LONGPRESS_TIMEOUT);
         }

         this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT);
         return var6 | this.mListener.onDown(var1);
      case 1:
         this.mStillDown = false;
         MotionEvent var13 = MotionEvent.obtain(var1);
         if(this.mIsDoubleTapping) {
            var11 = this.mDoubleTapListener.onDoubleTapEvent(var1) | false;
         } else if(this.mInLongPress) {
            this.mHandler.removeMessages(3);
            this.mInLongPress = false;
            var11 = false;
         } else if(this.mAlwaysInTapRegion) {
            boolean var12 = this.mListener.onSingleTapUp(var1);
            var11 = var12;
            if(this.mDeferConfirmSingleTap) {
               var11 = var12;
               if(this.mDoubleTapListener != null) {
                  this.mDoubleTapListener.onSingleTapConfirmed(var1);
                  var11 = var12;
               }
            }
         } else {
            VelocityTracker var14 = this.mVelocityTracker;
            var15 = MotionEventCompat.getPointerId(var1, 0);
            var14.computeCurrentVelocity(1000, (float)this.mMaximumFlingVelocity);
            var2 = VelocityTrackerCompat.getYVelocity(var14, var15);
            var3 = VelocityTrackerCompat.getXVelocity(var14, var15);
            if(Math.abs(var2) <= (float)this.mMinimumFlingVelocity && Math.abs(var3) <= (float)this.mMinimumFlingVelocity) {
               var11 = false;
            } else {
               var11 = this.mListener.onFling(this.mCurrentDownEvent, var1, var3, var2);
            }
         }

         if(this.mPreviousUpEvent != null) {
            this.mPreviousUpEvent.recycle();
         }

         this.mPreviousUpEvent = var13;
         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
         }

         this.mIsDoubleTapping = false;
         this.mDeferConfirmSingleTap = false;
         this.mHandler.removeMessages(1);
         this.mHandler.removeMessages(2);
         return var11;
      case 2:
         if(this.mInLongPress) {
            break;
         }

         var4 = this.mLastFocusX - var3;
         var5 = this.mLastFocusY - var2;
         if(this.mIsDoubleTapping) {
            return this.mDoubleTapListener.onDoubleTapEvent(var1) | false;
         }

         if(this.mAlwaysInTapRegion) {
            var15 = (int)(var3 - this.mDownFocusX);
            var7 = (int)(var2 - this.mDownFocusY);
            var15 = var15 * var15 + var7 * var7;
            if(var15 > this.mTouchSlopSquare) {
               var11 = this.mListener.onScroll(this.mCurrentDownEvent, var1, var4, var5);
               this.mLastFocusX = var3;
               this.mLastFocusY = var2;
               this.mAlwaysInTapRegion = false;
               this.mHandler.removeMessages(3);
               this.mHandler.removeMessages(1);
               this.mHandler.removeMessages(2);
            } else {
               var11 = false;
            }

            if(var15 > this.mTouchSlopSquare) {
               this.mAlwaysInBiggerTapRegion = false;
            }

            return var11;
         }

         if(Math.abs(var4) < 1.0F && Math.abs(var5) < 1.0F) {
            break;
         }

         var11 = this.mListener.onScroll(this.mCurrentDownEvent, var1, var4, var5);
         this.mLastFocusX = var3;
         this.mLastFocusY = var2;
         return var11;
      case 3:
         this.cancel();
         return false;
      case 4:
      default:
         break;
      case 5:
         this.mLastFocusX = var3;
         this.mDownFocusX = var3;
         this.mLastFocusY = var2;
         this.mDownFocusY = var2;
         this.cancelTaps();
         return false;
      case 6:
         this.mLastFocusX = var3;
         this.mDownFocusX = var3;
         this.mLastFocusY = var2;
         this.mDownFocusY = var2;
         this.mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumFlingVelocity);
         var7 = MotionEventCompat.getActionIndex(var1);
         var15 = MotionEventCompat.getPointerId(var1, var7);
         var2 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, var15);
         var3 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, var15);

         for(var15 = 0; var15 < var9; ++var15) {
            if(var15 != var7) {
               var8 = MotionEventCompat.getPointerId(var1, var15);
               var4 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, var8);
               if(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, var8) * var3 + var4 * var2 < 0.0F) {
                  this.mVelocityTracker.clear();
                  return false;
               }
            }
         }
      }

      return false;
   }

   public void setIsLongpressEnabled(boolean var1) {
      this.mIsLongpressEnabled = var1;
   }

   public void setOnDoubleTapListener(OnDoubleTapListener var1) {
      this.mDoubleTapListener = var1;
   }
}
