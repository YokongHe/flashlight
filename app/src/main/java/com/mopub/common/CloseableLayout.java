package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.CloseableLayout$ClosePosition;
import com.mopub.common.CloseableLayout$OnCloseListener;
import com.mopub.common.CloseableLayout$UnsetPressedState;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

public class CloseableLayout extends FrameLayout {
   @VisibleForTesting
   static final float CLOSE_BUTTON_PADDING_DP = 8.0F;
   @VisibleForTesting
   static final float CLOSE_BUTTON_SIZE_DP = 30.0F;
   static final float CLOSE_REGION_SIZE_DP = 50.0F;
   private final Rect mClosableLayoutRect = new Rect();
   private boolean mCloseBoundChanged;
   private final Rect mCloseButtonBounds = new Rect();
   private final int mCloseButtonPadding;
   private final int mCloseButtonSize;
   private final StateListDrawable mCloseDrawable = new StateListDrawable();
   private CloseableLayout$ClosePosition mClosePosition;
   private final Rect mCloseRegionBounds = new Rect();
   private final int mCloseRegionSize;
   private final Rect mInsetCloseRegionBounds = new Rect();
   private CloseableLayout$OnCloseListener mOnCloseListener;
   private final int mTouchSlop;
   private CloseableLayout$UnsetPressedState mUnsetPressedState;

   public CloseableLayout(Context var1) {
      super(var1);
      this.mClosePosition = CloseableLayout$ClosePosition.TOP_RIGHT;
      this.mCloseDrawable.addState(SELECTED_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(var1));
      this.mCloseDrawable.addState(EMPTY_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(var1));
      this.mCloseDrawable.setState(EMPTY_STATE_SET);
      this.mCloseDrawable.setCallback(this);
      this.mTouchSlop = ViewConfiguration.get(var1).getScaledTouchSlop();
      this.mCloseRegionSize = Dips.asIntPixels(50.0F, var1);
      this.mCloseButtonSize = Dips.asIntPixels(30.0F, var1);
      this.mCloseButtonPadding = Dips.asIntPixels(8.0F, var1);
      this.setWillNotDraw(false);
   }

   // $FF: synthetic method
   static void access$0(CloseableLayout var0, boolean var1) {
      var0.setClosePressed(var1);
   }

   private void applyCloseBoundsWithSize(CloseableLayout$ClosePosition var1, int var2, Rect var3, Rect var4) {
      Gravity.apply(var1.getGravity(), var2, var2, var3, var4);
   }

   private void applyCloseButtonBounds(CloseableLayout$ClosePosition var1, Rect var2, Rect var3) {
      this.applyCloseBoundsWithSize(var1, this.mCloseButtonSize, var2, var3);
   }

   private void performClose() {
      this.playSoundEffect(0);
      if(this.mOnCloseListener != null) {
         this.mOnCloseListener.onClose();
      }

   }

   private void setClosePressed(boolean var1) {
      if(var1 != this.isClosePressed()) {
         StateListDrawable var3 = this.mCloseDrawable;
         int[] var2;
         if(var1) {
            var2 = SELECTED_STATE_SET;
         } else {
            var2 = EMPTY_STATE_SET;
         }

         var3.setState(var2);
         this.invalidate(this.mCloseRegionBounds);
      }
   }

   public void applyCloseRegionBounds(CloseableLayout$ClosePosition var1, Rect var2, Rect var3) {
      this.applyCloseBoundsWithSize(var1, this.mCloseRegionSize, var2, var3);
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if(this.mCloseBoundChanged) {
         this.mCloseBoundChanged = false;
         this.mClosableLayoutRect.set(0, 0, this.getWidth(), this.getHeight());
         this.applyCloseRegionBounds(this.mClosePosition, this.mClosableLayoutRect, this.mCloseRegionBounds);
         this.mInsetCloseRegionBounds.set(this.mCloseRegionBounds);
         this.mInsetCloseRegionBounds.inset(this.mCloseButtonPadding, this.mCloseButtonPadding);
         this.applyCloseButtonBounds(this.mClosePosition, this.mInsetCloseRegionBounds, this.mCloseButtonBounds);
         this.mCloseDrawable.setBounds(this.mCloseButtonBounds);
      }

      if(this.mCloseDrawable.isVisible()) {
         this.mCloseDrawable.draw(var1);
      }

   }

   @VisibleForTesting
   Rect getCloseBounds() {
      return this.mCloseRegionBounds;
   }

   @VisibleForTesting
   boolean isClosePressed() {
      return this.mCloseDrawable.getState() == SELECTED_STATE_SET;
   }

   @VisibleForTesting
   public boolean isCloseVisible() {
      return this.mCloseDrawable.isVisible();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      return var1.getAction() != 0?false:this.pointInCloseBounds((int)var1.getX(), (int)var1.getY(), 0);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.mCloseBoundChanged = true;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(!this.pointInCloseBounds((int)var1.getX(), (int)var1.getY(), this.mTouchSlop)) {
         this.setClosePressed(false);
         super.onTouchEvent(var1);
         return false;
      } else {
         switch(var1.getAction()) {
         case 0:
            this.setClosePressed(true);
            break;
         case 1:
            if(this.isClosePressed()) {
               if(this.mUnsetPressedState == null) {
                  this.mUnsetPressedState = new CloseableLayout$UnsetPressedState(this, (CloseableLayout$UnsetPressedState)null);
               }

               this.postDelayed(this.mUnsetPressedState, (long)ViewConfiguration.getPressedStateDuration());
               this.performClose();
            }
         case 2:
         default:
            break;
         case 3:
            this.setClosePressed(false);
         }

         return true;
      }
   }

   @VisibleForTesting
   boolean pointInCloseBounds(int var1, int var2, int var3) {
      return var1 >= this.mCloseRegionBounds.left - var3 && var2 >= this.mCloseRegionBounds.top - var3 && var1 < this.mCloseRegionBounds.right + var3 && var2 < this.mCloseRegionBounds.bottom + var3;
   }

   @VisibleForTesting
   void setCloseBoundChanged(boolean var1) {
      this.mCloseBoundChanged = var1;
   }

   @VisibleForTesting
   void setCloseBounds(Rect var1) {
      this.mCloseRegionBounds.set(var1);
   }

   public void setClosePosition(CloseableLayout$ClosePosition var1) {
      Preconditions.checkNotNull(var1);
      this.mClosePosition = var1;
      this.mCloseBoundChanged = true;
      this.invalidate();
   }

   public void setCloseVisible(boolean var1) {
      if(this.mCloseDrawable.setVisible(var1, false)) {
         this.invalidate(this.mCloseRegionBounds);
      }

   }

   public void setOnCloseListener(CloseableLayout$OnCloseListener var1) {
      this.mOnCloseListener = var1;
   }
}
