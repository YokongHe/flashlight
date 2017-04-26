package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v4.widget.ViewDragHelper$Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper {
   private static final int BASE_SETTLE_DURATION = 256;
   public static final int DIRECTION_ALL = 3;
   public static final int DIRECTION_HORIZONTAL = 1;
   public static final int DIRECTION_VERTICAL = 2;
   public static final int EDGE_ALL = 15;
   public static final int EDGE_BOTTOM = 8;
   public static final int EDGE_LEFT = 1;
   public static final int EDGE_RIGHT = 2;
   private static final int EDGE_SIZE = 20;
   public static final int EDGE_TOP = 4;
   public static final int INVALID_POINTER = -1;
   private static final int MAX_SETTLE_DURATION = 600;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   private static final String TAG = "ViewDragHelper";
   private static final Interpolator sInterpolator = new Interpolator() {
      public final float getInterpolation(float var1) {
         --var1;
         return var1 * var1 * var1 * var1 * var1 + 1.0F;
      }
   };
   private int mActivePointerId = -1;
   private final ViewDragHelper$Callback mCallback;
   private View mCapturedView;
   private int mDragState;
   private int[] mEdgeDragsInProgress;
   private int[] mEdgeDragsLocked;
   private int mEdgeSize;
   private int[] mInitialEdgesTouched;
   private float[] mInitialMotionX;
   private float[] mInitialMotionY;
   private float[] mLastMotionX;
   private float[] mLastMotionY;
   private float mMaxVelocity;
   private float mMinVelocity;
   private final ViewGroup mParentView;
   private int mPointersDown;
   private boolean mReleaseInProgress;
   private ScrollerCompat mScroller;
   private final Runnable mSetIdleRunnable = new Runnable() {
      public void run() {
         ViewDragHelper.this.setDragState(0);
      }
   };
   private int mTouchSlop;
   private int mTrackingEdges;
   private VelocityTracker mVelocityTracker;

   private ViewDragHelper(Context var1, ViewGroup var2, ViewDragHelper$Callback var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Parent view may not be null");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Callback may not be null");
      } else {
         this.mParentView = var2;
         this.mCallback = var3;
         ViewConfiguration var4 = ViewConfiguration.get(var1);
         this.mEdgeSize = (int)(var1.getResources().getDisplayMetrics().density * 20.0F + 0.5F);
         this.mTouchSlop = var4.getScaledTouchSlop();
         this.mMaxVelocity = (float)var4.getScaledMaximumFlingVelocity();
         this.mMinVelocity = (float)var4.getScaledMinimumFlingVelocity();
         this.mScroller = ScrollerCompat.create(var1, sInterpolator);
      }
   }

   private boolean checkNewEdgeDrag(float var1, float var2, int var3, int var4) {
      var1 = Math.abs(var1);
      var2 = Math.abs(var2);
      if((this.mInitialEdgesTouched[var3] & var4) == var4 && (this.mTrackingEdges & var4) != 0 && (this.mEdgeDragsLocked[var3] & var4) != var4 && (this.mEdgeDragsInProgress[var3] & var4) != var4 && (var1 > (float)this.mTouchSlop || var2 > (float)this.mTouchSlop)) {
         if(var1 < var2 * 0.5F && this.mCallback.onEdgeLock(var4)) {
            int[] var5 = this.mEdgeDragsLocked;
            var5[var3] |= var4;
            return false;
         }

         if((this.mEdgeDragsInProgress[var3] & var4) == 0 && var1 > (float)this.mTouchSlop) {
            return true;
         }
      }

      return false;
   }

   private boolean checkTouchSlop(View var1, float var2, float var3) {
      if(var1 != null) {
         boolean var4;
         if(this.mCallback.getViewHorizontalDragRange(var1) > 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         boolean var5;
         if(this.mCallback.getViewVerticalDragRange(var1) > 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         if(var4 && var5) {
            if(var2 * var2 + var3 * var3 > (float)(this.mTouchSlop * this.mTouchSlop)) {
               return true;
            }
         } else if(var4) {
            if(Math.abs(var2) > (float)this.mTouchSlop) {
               return true;
            }
         } else if(var5 && Math.abs(var3) > (float)this.mTouchSlop) {
            return true;
         }
      }

      return false;
   }

   private float clampMag(float var1, float var2, float var3) {
      float var4 = Math.abs(var1);
      if(var4 < var2) {
         var2 = 0.0F;
      } else {
         if(var4 <= var3) {
            return var1;
         }

         var2 = var3;
         if(var1 <= 0.0F) {
            return -var3;
         }
      }

      return var2;
   }

   private int clampMag(int var1, int var2, int var3) {
      int var4 = Math.abs(var1);
      if(var4 < var2) {
         var2 = 0;
      } else {
         if(var4 <= var3) {
            return var1;
         }

         var2 = var3;
         if(var1 <= 0) {
            return -var3;
         }
      }

      return var2;
   }

   private void clearMotionHistory() {
      if(this.mInitialMotionX != null) {
         Arrays.fill(this.mInitialMotionX, 0.0F);
         Arrays.fill(this.mInitialMotionY, 0.0F);
         Arrays.fill(this.mLastMotionX, 0.0F);
         Arrays.fill(this.mLastMotionY, 0.0F);
         Arrays.fill(this.mInitialEdgesTouched, 0);
         Arrays.fill(this.mEdgeDragsInProgress, 0);
         Arrays.fill(this.mEdgeDragsLocked, 0);
         this.mPointersDown = 0;
      }
   }

   private void clearMotionHistory(int var1) {
      if(this.mInitialMotionX != null) {
         this.mInitialMotionX[var1] = 0.0F;
         this.mInitialMotionY[var1] = 0.0F;
         this.mLastMotionX[var1] = 0.0F;
         this.mLastMotionY[var1] = 0.0F;
         this.mInitialEdgesTouched[var1] = 0;
         this.mEdgeDragsInProgress[var1] = 0;
         this.mEdgeDragsLocked[var1] = 0;
         this.mPointersDown &= ~(1 << var1);
      }
   }

   private int computeAxisDuration(int var1, int var2, int var3) {
      if(var1 == 0) {
         return 0;
      } else {
         int var7 = this.mParentView.getWidth();
         int var8 = var7 / 2;
         float var6 = Math.min(1.0F, (float)Math.abs(var1) / (float)var7);
         float var4 = (float)var8;
         float var5 = (float)var8;
         var6 = this.distanceInfluenceForSnapDuration(var6);
         var2 = Math.abs(var2);
         if(var2 > 0) {
            var1 = Math.round(Math.abs((var6 * var5 + var4) / (float)var2) * 1000.0F) * 4;
         } else {
            var1 = (int)(((float)Math.abs(var1) / (float)var3 + 1.0F) * 256.0F);
         }

         return Math.min(var1, 600);
      }
   }

   private int computeSettleDuration(View var1, int var2, int var3, int var4, int var5) {
      var4 = this.clampMag(var4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
      var5 = this.clampMag(var5, (int)this.mMinVelocity, (int)this.mMaxVelocity);
      int var9 = Math.abs(var2);
      int var10 = Math.abs(var3);
      int var11 = Math.abs(var4);
      int var12 = Math.abs(var5);
      int var13 = var11 + var12;
      int var14 = var9 + var10;
      float var6;
      if(var4 != 0) {
         var6 = (float)var11 / (float)var13;
      } else {
         var6 = (float)var9 / (float)var14;
      }

      float var7;
      if(var5 != 0) {
         var7 = (float)var12 / (float)var13;
      } else {
         var7 = (float)var10 / (float)var14;
      }

      var2 = this.computeAxisDuration(var2, var4, this.mCallback.getViewHorizontalDragRange(var1));
      var3 = this.computeAxisDuration(var3, var5, this.mCallback.getViewVerticalDragRange(var1));
      float var8 = (float)var2;
      return (int)(var7 * (float)var3 + var6 * var8);
   }

   public static ViewDragHelper create(ViewGroup var0, float var1, ViewDragHelper$Callback var2) {
      ViewDragHelper var3 = create(var0, var2);
      var3.mTouchSlop = (int)((float)var3.mTouchSlop * (1.0F / var1));
      return var3;
   }

   public static ViewDragHelper create(ViewGroup var0, ViewDragHelper$Callback var1) {
      return new ViewDragHelper(var0.getContext(), var0, var1);
   }

   private void dispatchViewReleased(float var1, float var2) {
      this.mReleaseInProgress = true;
      this.mCallback.onViewReleased(this.mCapturedView, var1, var2);
      this.mReleaseInProgress = false;
      if(this.mDragState == 1) {
         this.setDragState(0);
      }

   }

   private float distanceInfluenceForSnapDuration(float var1) {
      return (float)Math.sin((double)((float)((double)(var1 - 0.5F) * 0.4712389167638204D)));
   }

   private void dragTo(int var1, int var2, int var3, int var4) {
      int var5 = this.mCapturedView.getLeft();
      int var6 = this.mCapturedView.getTop();
      if(var3 != 0) {
         var1 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, var1, var3);
         this.mCapturedView.offsetLeftAndRight(var1 - var5);
      }

      if(var4 != 0) {
         var2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, var2, var4);
         this.mCapturedView.offsetTopAndBottom(var2 - var6);
      }

      if(var3 != 0 || var4 != 0) {
         this.mCallback.onViewPositionChanged(this.mCapturedView, var1, var2, var1 - var5, var2 - var6);
      }

   }

   private void ensureMotionHistorySizeForId(int var1) {
      if(this.mInitialMotionX == null || this.mInitialMotionX.length <= var1) {
         float[] var2 = new float[var1 + 1];
         float[] var3 = new float[var1 + 1];
         float[] var4 = new float[var1 + 1];
         float[] var5 = new float[var1 + 1];
         int[] var6 = new int[var1 + 1];
         int[] var7 = new int[var1 + 1];
         int[] var8 = new int[var1 + 1];
         if(this.mInitialMotionX != null) {
            System.arraycopy(this.mInitialMotionX, 0, var2, 0, this.mInitialMotionX.length);
            System.arraycopy(this.mInitialMotionY, 0, var3, 0, this.mInitialMotionY.length);
            System.arraycopy(this.mLastMotionX, 0, var4, 0, this.mLastMotionX.length);
            System.arraycopy(this.mLastMotionY, 0, var5, 0, this.mLastMotionY.length);
            System.arraycopy(this.mInitialEdgesTouched, 0, var6, 0, this.mInitialEdgesTouched.length);
            System.arraycopy(this.mEdgeDragsInProgress, 0, var7, 0, this.mEdgeDragsInProgress.length);
            System.arraycopy(this.mEdgeDragsLocked, 0, var8, 0, this.mEdgeDragsLocked.length);
         }

         this.mInitialMotionX = var2;
         this.mInitialMotionY = var3;
         this.mLastMotionX = var4;
         this.mLastMotionY = var5;
         this.mInitialEdgesTouched = var6;
         this.mEdgeDragsInProgress = var7;
         this.mEdgeDragsLocked = var8;
      }

   }

   private boolean forceSettleCapturedViewAt(int var1, int var2, int var3, int var4) {
      int var5 = this.mCapturedView.getLeft();
      int var6 = this.mCapturedView.getTop();
      var1 -= var5;
      var2 -= var6;
      if(var1 == 0 && var2 == 0) {
         this.mScroller.abortAnimation();
         this.setDragState(0);
         return false;
      } else {
         var3 = this.computeSettleDuration(this.mCapturedView, var1, var2, var3, var4);
         this.mScroller.startScroll(var5, var6, var1, var2, var3);
         this.setDragState(2);
         return true;
      }
   }

   private int getEdgesTouched(int var1, int var2) {
      byte var4 = 0;
      if(var1 < this.mParentView.getLeft() + this.mEdgeSize) {
         var4 = 1;
      }

      int var3 = var4;
      if(var2 < this.mParentView.getTop() + this.mEdgeSize) {
         var3 = var4 | 4;
      }

      int var5 = var3;
      if(var1 > this.mParentView.getRight() - this.mEdgeSize) {
         var5 = var3 | 2;
      }

      var1 = var5;
      if(var2 > this.mParentView.getBottom() - this.mEdgeSize) {
         var1 = var5 | 8;
      }

      return var1;
   }

   private void releaseViewForPointerUp() {
      this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
      this.dispatchViewReleased(this.clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
   }

   private void reportNewEdgeDrags(float var1, float var2, int var3) {
      byte var5 = 1;
      if(!this.checkNewEdgeDrag(var1, var2, var3, 1)) {
         var5 = 0;
      }

      int var4 = var5;
      if(this.checkNewEdgeDrag(var2, var1, var3, 4)) {
         var4 = var5 | 4;
      }

      int var7 = var4;
      if(this.checkNewEdgeDrag(var1, var2, var3, 2)) {
         var7 = var4 | 2;
      }

      var4 = var7;
      if(this.checkNewEdgeDrag(var2, var1, var3, 8)) {
         var4 = var7 | 8;
      }

      if(var4 != 0) {
         int[] var6 = this.mEdgeDragsInProgress;
         var6[var3] |= var4;
         this.mCallback.onEdgeDragStarted(var4, var3);
      }

   }

   private void saveInitialMotion(float var1, float var2, int var3) {
      this.ensureMotionHistorySizeForId(var3);
      float[] var4 = this.mInitialMotionX;
      this.mLastMotionX[var3] = var1;
      var4[var3] = var1;
      var4 = this.mInitialMotionY;
      this.mLastMotionY[var3] = var2;
      var4[var3] = var2;
      this.mInitialEdgesTouched[var3] = this.getEdgesTouched((int)var1, (int)var2);
      this.mPointersDown |= 1 << var3;
   }

   private void saveLastMotion(MotionEvent var1) {
      int var5 = MotionEventCompat.getPointerCount(var1);

      for(int var4 = 0; var4 < var5; ++var4) {
         int var6 = MotionEventCompat.getPointerId(var1, var4);
         float var2 = MotionEventCompat.getX(var1, var4);
         float var3 = MotionEventCompat.getY(var1, var4);
         this.mLastMotionX[var6] = var2;
         this.mLastMotionY[var6] = var3;
      }

   }

   public void abort() {
      this.cancel();
      if(this.mDragState == 2) {
         int var1 = this.mScroller.getCurrX();
         int var2 = this.mScroller.getCurrY();
         this.mScroller.abortAnimation();
         int var3 = this.mScroller.getCurrX();
         int var4 = this.mScroller.getCurrY();
         this.mCallback.onViewPositionChanged(this.mCapturedView, var3, var4, var3 - var1, var4 - var2);
      }

      this.setDragState(0);
   }

   protected boolean canScroll(View var1, boolean var2, int var3, int var4, int var5, int var6) {
      if(var1 instanceof ViewGroup) {
         ViewGroup var10 = (ViewGroup)var1;
         int var8 = var1.getScrollX();
         int var9 = var1.getScrollY();

         for(int var7 = var10.getChildCount() - 1; var7 >= 0; --var7) {
            View var11 = var10.getChildAt(var7);
            if(var5 + var8 >= var11.getLeft() && var5 + var8 < var11.getRight() && var6 + var9 >= var11.getTop() && var6 + var9 < var11.getBottom() && this.canScroll(var11, true, var3, var4, var5 + var8 - var11.getLeft(), var6 + var9 - var11.getTop())) {
               return true;
            }
         }
      }

      return var2 && (ViewCompat.canScrollHorizontally(var1, -var3) || ViewCompat.canScrollVertically(var1, -var4));
   }

   public void cancel() {
      this.mActivePointerId = -1;
      this.clearMotionHistory();
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   public void captureChildView(View var1, int var2) {
      if(var1.getParent() != this.mParentView) {
         throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper\'s tracked parent view (" + this.mParentView + ")");
      } else {
         this.mCapturedView = var1;
         this.mActivePointerId = var2;
         this.mCallback.onViewCaptured(var1, var2);
         this.setDragState(1);
      }
   }

   public boolean checkTouchSlop(int var1) {
      boolean var5 = false;
      int var3 = this.mInitialMotionX.length;
      int var2 = 0;

      boolean var4;
      while(true) {
         var4 = var5;
         if(var2 >= var3) {
            break;
         }

         if(this.checkTouchSlop(var1, var2)) {
            var4 = true;
            break;
         }

         ++var2;
      }

      return var4;
   }

   public boolean checkTouchSlop(int var1, int var2) {
      if(this.isPointerDown(var2)) {
         boolean var5;
         if((var1 & 1) == 1) {
            var5 = true;
         } else {
            var5 = false;
         }

         boolean var6;
         if((var1 & 2) == 2) {
            var6 = true;
         } else {
            var6 = false;
         }

         float var3 = this.mLastMotionX[var2] - this.mInitialMotionX[var2];
         float var4 = this.mLastMotionY[var2] - this.mInitialMotionY[var2];
         if(var5 && var6) {
            if(var3 * var3 + var4 * var4 > (float)(this.mTouchSlop * this.mTouchSlop)) {
               return true;
            }
         } else if(var5) {
            if(Math.abs(var3) > (float)this.mTouchSlop) {
               return true;
            }
         } else if(var6 && Math.abs(var4) > (float)this.mTouchSlop) {
            return true;
         }
      }

      return false;
   }

   public boolean continueSettling(boolean var1) {
      if(this.mDragState == 2) {
         boolean var6 = this.mScroller.computeScrollOffset();
         int var2 = this.mScroller.getCurrX();
         int var3 = this.mScroller.getCurrY();
         int var4 = var2 - this.mCapturedView.getLeft();
         int var5 = var3 - this.mCapturedView.getTop();
         if(var4 != 0) {
            this.mCapturedView.offsetLeftAndRight(var4);
         }

         if(var5 != 0) {
            this.mCapturedView.offsetTopAndBottom(var5);
         }

         if(var4 != 0 || var5 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, var2, var3, var4, var5);
         }

         if(var6 && var2 == this.mScroller.getFinalX() && var3 == this.mScroller.getFinalY()) {
            this.mScroller.abortAnimation();
            var6 = this.mScroller.isFinished();
         }

         if(!var6) {
            if(var1) {
               this.mParentView.post(this.mSetIdleRunnable);
            } else {
               this.setDragState(0);
            }
         }
      }

      return this.mDragState == 2;
   }

   public View findTopChildUnder(int var1, int var2) {
      for(int var3 = this.mParentView.getChildCount() - 1; var3 >= 0; --var3) {
         View var4 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(var3));
         if(var1 >= var4.getLeft() && var1 < var4.getRight() && var2 >= var4.getTop() && var2 < var4.getBottom()) {
            return var4;
         }
      }

      return null;
   }

   public void flingCapturedView(int var1, int var2, int var3, int var4) {
      if(!this.mReleaseInProgress) {
         throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
      } else {
         this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), var1, var3, var2, var4);
         this.setDragState(2);
      }
   }

   public int getActivePointerId() {
      return this.mActivePointerId;
   }

   public View getCapturedView() {
      return this.mCapturedView;
   }

   public int getEdgeSize() {
      return this.mEdgeSize;
   }

   public float getMinVelocity() {
      return this.mMinVelocity;
   }

   public int getTouchSlop() {
      return this.mTouchSlop;
   }

   public int getViewDragState() {
      return this.mDragState;
   }

   public boolean isCapturedViewUnder(int var1, int var2) {
      return this.isViewUnder(this.mCapturedView, var1, var2);
   }

   public boolean isEdgeTouched(int var1) {
      boolean var5 = false;
      int var3 = this.mInitialEdgesTouched.length;
      int var2 = 0;

      boolean var4;
      while(true) {
         var4 = var5;
         if(var2 >= var3) {
            break;
         }

         if(this.isEdgeTouched(var1, var2)) {
            var4 = true;
            break;
         }

         ++var2;
      }

      return var4;
   }

   public boolean isEdgeTouched(int var1, int var2) {
      return this.isPointerDown(var2) && (this.mInitialEdgesTouched[var2] & var1) != 0;
   }

   public boolean isPointerDown(int var1) {
      return (this.mPointersDown & 1 << var1) != 0;
   }

   public boolean isViewUnder(View var1, int var2, int var3) {
      return var1 != null && var2 >= var1.getLeft() && var2 < var1.getRight() && var3 >= var1.getTop() && var3 < var1.getBottom();
   }

   public void processTouchEvent(MotionEvent var1) {
      int var6 = 0;
      byte var7 = 0;
      int var9 = MotionEventCompat.getActionMasked(var1);
      int var8 = MotionEventCompat.getActionIndex(var1);
      if(var9 == 0) {
         this.cancel();
      }

      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

      this.mVelocityTracker.addMovement(var1);
      float var2;
      float var3;
      int var12;
      switch(var9) {
      case 0:
         var2 = var1.getX();
         var3 = var1.getY();
         var6 = MotionEventCompat.getPointerId(var1, 0);
         View var11 = this.findTopChildUnder((int)var2, (int)var3);
         this.saveInitialMotion(var2, var3, var6);
         this.tryCaptureViewForDrag(var11, var6);
         var12 = this.mInitialEdgesTouched[var6];
         if((this.mTrackingEdges & var12) != 0) {
            this.mCallback.onEdgeTouched(var12 & this.mTrackingEdges, var6);
            return;
         }
         break;
      case 1:
         if(this.mDragState == 1) {
            this.releaseViewForPointerUp();
         }

         this.cancel();
         return;
      case 2:
         if(this.mDragState == 1) {
            var6 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
            var2 = MotionEventCompat.getX(var1, var6);
            var3 = MotionEventCompat.getY(var1, var6);
            var6 = (int)(var2 - this.mLastMotionX[this.mActivePointerId]);
            var12 = (int)(var3 - this.mLastMotionY[this.mActivePointerId]);
            this.dragTo(this.mCapturedView.getLeft() + var6, this.mCapturedView.getTop() + var12, var6, var12);
            this.saveLastMotion(var1);
            return;
         }

         var8 = MotionEventCompat.getPointerCount(var1);

         for(var6 = var7; var6 < var8; ++var6) {
            var12 = MotionEventCompat.getPointerId(var1, var6);
            var2 = MotionEventCompat.getX(var1, var6);
            var3 = MotionEventCompat.getY(var1, var6);
            float var4 = var2 - this.mInitialMotionX[var12];
            float var5 = var3 - this.mInitialMotionY[var12];
            this.reportNewEdgeDrags(var4, var5, var12);
            if(this.mDragState == 1) {
               break;
            }

            View var10 = this.findTopChildUnder((int)var2, (int)var3);
            if(this.checkTouchSlop(var10, var4, var5) && this.tryCaptureViewForDrag(var10, var12)) {
               break;
            }
         }

         this.saveLastMotion(var1);
         return;
      case 3:
         if(this.mDragState == 1) {
            this.dispatchViewReleased(0.0F, 0.0F);
         }

         this.cancel();
         return;
      case 4:
      default:
         break;
      case 5:
         var6 = MotionEventCompat.getPointerId(var1, var8);
         var2 = MotionEventCompat.getX(var1, var8);
         var3 = MotionEventCompat.getY(var1, var8);
         this.saveInitialMotion(var2, var3, var6);
         if(this.mDragState == 0) {
            this.tryCaptureViewForDrag(this.findTopChildUnder((int)var2, (int)var3), var6);
            var12 = this.mInitialEdgesTouched[var6];
            if((this.mTrackingEdges & var12) != 0) {
               this.mCallback.onEdgeTouched(var12 & this.mTrackingEdges, var6);
               return;
            }
         } else if(this.isCapturedViewUnder((int)var2, (int)var3)) {
            this.tryCaptureViewForDrag(this.mCapturedView, var6);
            return;
         }
         break;
      case 6:
         var12 = MotionEventCompat.getPointerId(var1, var8);
         if(this.mDragState == 1 && var12 == this.mActivePointerId) {
            var8 = MotionEventCompat.getPointerCount(var1);

            while(true) {
               if(var6 >= var8) {
                  var6 = -1;
                  break;
               }

               var9 = MotionEventCompat.getPointerId(var1, var6);
               if(var9 != this.mActivePointerId) {
                  var2 = MotionEventCompat.getX(var1, var6);
                  var3 = MotionEventCompat.getY(var1, var6);
                  if(this.findTopChildUnder((int)var2, (int)var3) == this.mCapturedView && this.tryCaptureViewForDrag(this.mCapturedView, var9)) {
                     var6 = this.mActivePointerId;
                     break;
                  }
               }

               ++var6;
            }

            if(var6 == -1) {
               this.releaseViewForPointerUp();
            }
         }

         this.clearMotionHistory(var12);
         return;
      }

   }

   void setDragState(int var1) {
      if(this.mDragState != var1) {
         this.mDragState = var1;
         this.mCallback.onViewDragStateChanged(var1);
         if(var1 == 0) {
            this.mCapturedView = null;
         }
      }

   }

   public void setEdgeTrackingEnabled(int var1) {
      this.mTrackingEdges = var1;
   }

   public void setMinVelocity(float var1) {
      this.mMinVelocity = var1;
   }

   public boolean settleCapturedViewAt(int var1, int var2) {
      if(!this.mReleaseInProgress) {
         throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
      } else {
         return this.forceSettleCapturedViewAt(var1, var2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
      }
   }

   public boolean shouldInterceptTouchEvent(MotionEvent var1) {
      int var7 = MotionEventCompat.getActionMasked(var1);
      int var6 = MotionEventCompat.getActionIndex(var1);
      if(var7 == 0) {
         this.cancel();
      }

      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

      this.mVelocityTracker.addMovement(var1);
      float var2;
      float var3;
      View var10;
      switch(var7) {
      case 0:
         var2 = var1.getX();
         var3 = var1.getY();
         var6 = MotionEventCompat.getPointerId(var1, 0);
         this.saveInitialMotion(var2, var3, var6);
         var10 = this.findTopChildUnder((int)var2, (int)var3);
         if(var10 == this.mCapturedView && this.mDragState == 2) {
            this.tryCaptureViewForDrag(var10, var6);
         }

         var7 = this.mInitialEdgesTouched[var6];
         if((this.mTrackingEdges & var7) != 0) {
            this.mCallback.onEdgeTouched(var7 & this.mTrackingEdges, var6);
         }
         break;
      case 1:
      case 3:
         this.cancel();
         break;
      case 2:
         var7 = MotionEventCompat.getPointerCount(var1);

         for(var6 = 0; var6 < var7; ++var6) {
            int var8 = MotionEventCompat.getPointerId(var1, var6);
            var2 = MotionEventCompat.getX(var1, var6);
            var3 = MotionEventCompat.getY(var1, var6);
            float var4 = var2 - this.mInitialMotionX[var8];
            float var5 = var3 - this.mInitialMotionY[var8];
            this.reportNewEdgeDrags(var4, var5, var8);
            if(this.mDragState == 1) {
               break;
            }

            View var9 = this.findTopChildUnder((int)var2, (int)var3);
            if(var9 != null && this.checkTouchSlop(var9, var4, var5) && this.tryCaptureViewForDrag(var9, var8)) {
               break;
            }
         }

         this.saveLastMotion(var1);
      case 4:
      default:
         break;
      case 5:
         var7 = MotionEventCompat.getPointerId(var1, var6);
         var2 = MotionEventCompat.getX(var1, var6);
         var3 = MotionEventCompat.getY(var1, var6);
         this.saveInitialMotion(var2, var3, var7);
         if(this.mDragState == 0) {
            var6 = this.mInitialEdgesTouched[var7];
            if((this.mTrackingEdges & var6) != 0) {
               this.mCallback.onEdgeTouched(var6 & this.mTrackingEdges, var7);
            }
         } else if(this.mDragState == 2) {
            var10 = this.findTopChildUnder((int)var2, (int)var3);
            if(var10 == this.mCapturedView) {
               this.tryCaptureViewForDrag(var10, var7);
            }
         }
         break;
      case 6:
         this.clearMotionHistory(MotionEventCompat.getPointerId(var1, var6));
      }

      return this.mDragState == 1;
   }

   public boolean smoothSlideViewTo(View var1, int var2, int var3) {
      this.mCapturedView = var1;
      this.mActivePointerId = -1;
      return this.forceSettleCapturedViewAt(var2, var3, 0, 0);
   }

   boolean tryCaptureViewForDrag(View var1, int var2) {
      if(var1 == this.mCapturedView && this.mActivePointerId == var2) {
         return true;
      } else if(var1 != null && this.mCallback.tryCaptureView(var1, var2)) {
         this.mActivePointerId = var2;
         this.captureChildView(var1, var2);
         return true;
      } else {
         return false;
      }
   }
}
