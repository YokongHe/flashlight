package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.widget.DrawerLayout$AccessibilityDelegate;
import android.support.v4.widget.DrawerLayout$DrawerListener;
import android.support.v4.widget.DrawerLayout$LayoutParams;
import android.support.v4.widget.DrawerLayout$SavedState;
import android.support.v4.widget.DrawerLayout$ViewDragCallback;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class DrawerLayout extends ViewGroup {
   private static final boolean ALLOW_EDGE_LOCK = false;
   private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
   private static final int DEFAULT_SCRIM_COLOR = -1728053248;
   private static final int[] LAYOUT_ATTRS = new int[]{16842931};
   public static final int LOCK_MODE_LOCKED_CLOSED = 1;
   public static final int LOCK_MODE_LOCKED_OPEN = 2;
   public static final int LOCK_MODE_UNLOCKED = 0;
   private static final int MIN_DRAWER_MARGIN = 64;
   private static final int MIN_FLING_VELOCITY = 400;
   private static final int PEEK_DELAY = 160;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   private static final String TAG = "DrawerLayout";
   private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
   private boolean mChildrenCanceledTouch;
   private boolean mDisallowInterceptRequested;
   private int mDrawerState;
   private boolean mFirstLayout;
   private boolean mInLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private final DrawerLayout$ViewDragCallback mLeftCallback;
   private final ViewDragHelper mLeftDragger;
   private DrawerLayout$DrawerListener mListener;
   private int mLockModeLeft;
   private int mLockModeRight;
   private int mMinDrawerMargin;
   private final DrawerLayout$ViewDragCallback mRightCallback;
   private final ViewDragHelper mRightDragger;
   private int mScrimColor;
   private float mScrimOpacity;
   private Paint mScrimPaint;
   private Drawable mShadowLeft;
   private Drawable mShadowRight;
   private CharSequence mTitleLeft;
   private CharSequence mTitleRight;

   public DrawerLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public DrawerLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public DrawerLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mScrimColor = -1728053248;
      this.mScrimPaint = new Paint();
      this.mFirstLayout = true;
      float var4 = this.getResources().getDisplayMetrics().density;
      this.mMinDrawerMargin = (int)(64.0F * var4 + 0.5F);
      var4 *= 400.0F;
      this.mLeftCallback = new DrawerLayout$ViewDragCallback(this, 3);
      this.mRightCallback = new DrawerLayout$ViewDragCallback(this, 5);
      this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
      this.mLeftDragger.setEdgeTrackingEnabled(1);
      this.mLeftDragger.setMinVelocity(var4);
      this.mLeftCallback.setDragger(this.mLeftDragger);
      this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
      this.mRightDragger.setEdgeTrackingEnabled(2);
      this.mRightDragger.setMinVelocity(var4);
      this.mRightCallback.setDragger(this.mRightDragger);
      this.setFocusableInTouchMode(true);
      ViewCompat.setAccessibilityDelegate(this, new DrawerLayout$AccessibilityDelegate(this));
      ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
   }

   // $FF: synthetic method
   static int[] access$100() {
      return LAYOUT_ATTRS;
   }

   // $FF: synthetic method
   static View access$200(DrawerLayout var0) {
      return var0.findVisibleDrawer();
   }

   private View findVisibleDrawer() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         if(this.isDrawerView(var3) && this.isDrawerVisible(var3)) {
            return var3;
         }
      }

      return null;
   }

   static String gravityToString(int var0) {
      return (var0 & 3) == 3?"LEFT":((var0 & 5) == 5?"RIGHT":Integer.toHexString(var0));
   }

   private static boolean hasOpaqueBackground(View var0) {
      boolean var2 = false;
      Drawable var3 = var0.getBackground();
      boolean var1 = var2;
      if(var3 != null) {
         var1 = var2;
         if(var3.getOpacity() == -1) {
            var1 = true;
         }
      }

      return var1;
   }

   private boolean hasPeekingDrawer() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         if(((DrawerLayout$LayoutParams)this.getChildAt(var1).getLayoutParams()).isPeeking) {
            return true;
         }
      }

      return false;
   }

   private boolean hasVisibleDrawer() {
      return this.findVisibleDrawer() != null;
   }

   void cancelChildViewTouch() {
      int var1 = 0;
      if(!this.mChildrenCanceledTouch) {
         long var3 = SystemClock.uptimeMillis();
         MotionEvent var5 = MotionEvent.obtain(var3, var3, 3, 0.0F, 0.0F, 0);

         for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
            this.getChildAt(var1).dispatchTouchEvent(var5);
         }

         var5.recycle();
         this.mChildrenCanceledTouch = true;
      }

   }

   boolean checkDrawerViewAbsoluteGravity(View var1, int var2) {
      return (this.getDrawerViewAbsoluteGravity(var1) & var2) == var2;
   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof DrawerLayout$LayoutParams && super.checkLayoutParams(var1);
   }

   public void closeDrawer(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(var1));
      } else {
         this.closeDrawer(var2);
      }
   }

   public void closeDrawer(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      } else {
         if(this.mFirstLayout) {
            DrawerLayout$LayoutParams var2 = (DrawerLayout$LayoutParams)var1.getLayoutParams();
            var2.onScreen = 0.0F;
            var2.knownOpen = false;
         } else if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            this.mLeftDragger.smoothSlideViewTo(var1, -var1.getWidth(), var1.getTop());
         } else {
            this.mRightDragger.smoothSlideViewTo(var1, this.getWidth(), var1.getTop());
         }

         this.invalidate();
      }
   }

   public void closeDrawers() {
      this.closeDrawers(false);
   }

   void closeDrawers(boolean var1) {
      int var5 = this.getChildCount();
      int var3 = 0;

      boolean var2;
      boolean var4;
      for(var2 = false; var3 < var5; var2 = var4) {
         View var6 = this.getChildAt(var3);
         DrawerLayout$LayoutParams var7 = (DrawerLayout$LayoutParams)var6.getLayoutParams();
         var4 = var2;
         if(this.isDrawerView(var6)) {
            label34: {
               if(var1) {
                  var4 = var2;
                  if(!var7.isPeeking) {
                     break label34;
                  }
               }

               int var8 = var6.getWidth();
               if(this.checkDrawerViewAbsoluteGravity(var6, 3)) {
                  var2 |= this.mLeftDragger.smoothSlideViewTo(var6, -var8, var6.getTop());
               } else {
                  var2 |= this.mRightDragger.smoothSlideViewTo(var6, this.getWidth(), var6.getTop());
               }

               var7.isPeeking = false;
               var4 = var2;
            }
         }

         ++var3;
      }

      this.mLeftCallback.removeCallbacks();
      this.mRightCallback.removeCallbacks();
      if(var2) {
         this.invalidate();
      }

   }

   public void computeScroll() {
      int var3 = this.getChildCount();
      float var1 = 0.0F;

      for(int var2 = 0; var2 < var3; ++var2) {
         var1 = Math.max(var1, ((DrawerLayout$LayoutParams)this.getChildAt(var2).getLayoutParams()).onScreen);
      }

      this.mScrimOpacity = var1;
      if(this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true)) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   void dispatchOnDrawerClosed(View var1) {
      DrawerLayout$LayoutParams var2 = (DrawerLayout$LayoutParams)var1.getLayoutParams();
      if(var2.knownOpen) {
         var2.knownOpen = false;
         if(this.mListener != null) {
            this.mListener.onDrawerClosed(var1);
         }

         if(this.hasWindowFocus()) {
            var1 = this.getRootView();
            if(var1 != null) {
               var1.sendAccessibilityEvent(32);
            }
         }
      }

   }

   void dispatchOnDrawerOpened(View var1) {
      DrawerLayout$LayoutParams var2 = (DrawerLayout$LayoutParams)var1.getLayoutParams();
      if(!var2.knownOpen) {
         var2.knownOpen = true;
         if(this.mListener != null) {
            this.mListener.onDrawerOpened(var1);
         }

         this.sendAccessibilityEvent(32);
      }

   }

   void dispatchOnDrawerSlide(View var1, float var2) {
      if(this.mListener != null) {
         this.mListener.onDrawerSlide(var1, var2);
      }

   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      int var12 = this.getHeight();
      boolean var15 = this.isContentView(var2);
      int var7 = 0;
      byte var10 = 0;
      int var6 = this.getWidth();
      int var13 = var1.save();
      int var8 = var6;
      int var9;
      if(var15) {
         int var14 = this.getChildCount();
         var9 = 0;

         int var18;
         for(var7 = var10; var9 < var14; var7 = var18) {
            label53: {
               View var17 = this.getChildAt(var9);
               if(var17 != var2 && var17.getVisibility() == 0 && hasOpaqueBackground(var17) && this.isDrawerView(var17) && var17.getHeight() >= var12) {
                  if(this.checkDrawerViewAbsoluteGravity(var17, 3)) {
                     var8 = var17.getRight();
                     if(var8 > var7) {
                        var7 = var8;
                     }

                     var18 = var7;
                     var8 = var6;
                     break label53;
                  }

                  int var11 = var17.getLeft();
                  var8 = var11;
                  var18 = var7;
                  if(var11 < var6) {
                     break label53;
                  }
               }

               var8 = var6;
               var18 = var7;
            }

            ++var9;
            var6 = var8;
         }

         var1.clipRect(var7, 0, var6, this.getHeight());
         var8 = var6;
      }

      boolean var16 = super.drawChild(var1, var2, var3);
      var1.restoreToCount(var13);
      if(this.mScrimOpacity > 0.0F && var15) {
         var6 = (int)((float)((this.mScrimColor & -16777216) >>> 24) * this.mScrimOpacity);
         var9 = this.mScrimColor;
         this.mScrimPaint.setColor(var6 << 24 | var9 & 16777215);
         var1.drawRect((float)var7, 0.0F, (float)var8, (float)this.getHeight(), this.mScrimPaint);
      } else {
         float var5;
         if(this.mShadowLeft != null && this.checkDrawerViewAbsoluteGravity(var2, 3)) {
            var6 = this.mShadowLeft.getIntrinsicWidth();
            var7 = var2.getRight();
            var8 = this.mLeftDragger.getEdgeSize();
            var5 = Math.max(0.0F, Math.min((float)var7 / (float)var8, 1.0F));
            this.mShadowLeft.setBounds(var7, var2.getTop(), var6 + var7, var2.getBottom());
            this.mShadowLeft.setAlpha((int)(255.0F * var5));
            this.mShadowLeft.draw(var1);
            return var16;
         }

         if(this.mShadowRight != null && this.checkDrawerViewAbsoluteGravity(var2, 5)) {
            var6 = this.mShadowRight.getIntrinsicWidth();
            var7 = var2.getLeft();
            var8 = this.getWidth();
            var9 = this.mRightDragger.getEdgeSize();
            var5 = Math.max(0.0F, Math.min((float)(var8 - var7) / (float)var9, 1.0F));
            this.mShadowRight.setBounds(var7 - var6, var2.getTop(), var7, var2.getBottom());
            this.mShadowRight.setAlpha((int)(255.0F * var5));
            this.mShadowRight.draw(var1);
            return var16;
         }
      }

      return var16;
   }

   View findDrawerWithGravity(int var1) {
      int var2 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      int var3 = this.getChildCount();

      for(var1 = 0; var1 < var3; ++var1) {
         View var4 = this.getChildAt(var1);
         if((this.getDrawerViewAbsoluteGravity(var4) & 7) == (var2 & 7)) {
            return var4;
         }
      }

      return null;
   }

   View findOpenDrawer() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         if(((DrawerLayout$LayoutParams)var3.getLayoutParams()).knownOpen) {
            return var3;
         }
      }

      return null;
   }

   protected LayoutParams generateDefaultLayoutParams() {
      return new DrawerLayout$LayoutParams(-1, -1);
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return new DrawerLayout$LayoutParams(this.getContext(), var1);
   }

   protected LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof DrawerLayout$LayoutParams?new DrawerLayout$LayoutParams((DrawerLayout$LayoutParams)var1):(var1 instanceof MarginLayoutParams?new DrawerLayout$LayoutParams((MarginLayoutParams)var1):new DrawerLayout$LayoutParams(var1));
   }

   public int getDrawerLockMode(int var1) {
      var1 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      return var1 == 3?this.mLockModeLeft:(var1 == 5?this.mLockModeRight:0);
   }

   public int getDrawerLockMode(View var1) {
      int var2 = this.getDrawerViewAbsoluteGravity(var1);
      return var2 == 3?this.mLockModeLeft:(var2 == 5?this.mLockModeRight:0);
   }

   public CharSequence getDrawerTitle(int var1) {
      var1 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      return var1 == 3?this.mTitleLeft:(var1 == 5?this.mTitleRight:null);
   }

   int getDrawerViewAbsoluteGravity(View var1) {
      return GravityCompat.getAbsoluteGravity(((DrawerLayout$LayoutParams)var1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
   }

   float getDrawerViewOffset(View var1) {
      return ((DrawerLayout$LayoutParams)var1.getLayoutParams()).onScreen;
   }

   boolean isContentView(View var1) {
      return ((DrawerLayout$LayoutParams)var1.getLayoutParams()).gravity == 0;
   }

   public boolean isDrawerOpen(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      return var2 != null?this.isDrawerOpen(var2):false;
   }

   public boolean isDrawerOpen(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return ((DrawerLayout$LayoutParams)var1.getLayoutParams()).knownOpen;
      }
   }

   boolean isDrawerView(View var1) {
      return (GravityCompat.getAbsoluteGravity(((DrawerLayout$LayoutParams)var1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(var1)) & 7) != 0;
   }

   public boolean isDrawerVisible(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      return var2 != null?this.isDrawerVisible(var2):false;
   }

   public boolean isDrawerVisible(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return ((DrawerLayout$LayoutParams)var1.getLayoutParams()).onScreen > 0.0F;
      }
   }

   void moveDrawerToOffset(View var1, float var2) {
      float var3 = this.getDrawerViewOffset(var1);
      int var4 = var1.getWidth();
      int var5 = (int)(var3 * (float)var4);
      var4 = (int)((float)var4 * var2) - var5;
      if(!this.checkDrawerViewAbsoluteGravity(var1, 3)) {
         var4 = -var4;
      }

      var1.offsetLeftAndRight(var4);
      this.setDrawerViewOffset(var1, var2);
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mFirstLayout = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mFirstLayout = true;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var5;
      boolean var6;
      boolean var7;
      boolean var8;
      label37: {
         var5 = false;
         int var4 = MotionEventCompat.getActionMasked(var1);
         var6 = this.mLeftDragger.shouldInterceptTouchEvent(var1);
         var7 = this.mRightDragger.shouldInterceptTouchEvent(var1);
         switch(var4) {
         case 0:
            float var2 = var1.getX();
            float var3 = var1.getY();
            this.mInitialMotionX = var2;
            this.mInitialMotionY = var3;
            if(this.mScrimOpacity > 0.0F && this.isContentView(this.mLeftDragger.findTopChildUnder((int)var2, (int)var3))) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
            break label37;
         case 1:
         case 3:
            this.closeDrawers(true);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
            break;
         case 2:
            if(this.mLeftDragger.checkTouchSlop(3)) {
               this.mLeftCallback.removeCallbacks();
               this.mRightCallback.removeCallbacks();
               var8 = false;
               break label37;
            }
         }

         var8 = false;
      }

      if(var6 | var7 || var8 || this.hasPeekingDrawer() || this.mChildrenCanceledTouch) {
         var5 = true;
      }

      return var5;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4 && this.hasVisibleDrawer()) {
         KeyEventCompat.startTracking(var2);
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      if(var1 == 4) {
         View var3 = this.findVisibleDrawer();
         if(var3 != null && this.getDrawerLockMode(var3) == 0) {
            this.closeDrawers();
         }

         return var3 != null;
      } else {
         return super.onKeyUp(var1, var2);
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.mInLayout = true;
      int var10 = var4 - var2;
      int var11 = this.getChildCount();

      for(var4 = 0; var4 < var11; ++var4) {
         View var15 = this.getChildAt(var4);
         if(var15.getVisibility() != 8) {
            DrawerLayout$LayoutParams var16 = (DrawerLayout$LayoutParams)var15.getLayoutParams();
            if(this.isContentView(var15)) {
               var15.layout(var16.leftMargin, var16.topMargin, var16.leftMargin + var15.getMeasuredWidth(), var16.topMargin + var15.getMeasuredHeight());
            } else {
               int var12 = var15.getMeasuredWidth();
               int var13 = var15.getMeasuredHeight();
               float var6;
               int var7;
               if(this.checkDrawerViewAbsoluteGravity(var15, 3)) {
                  var2 = -var12;
                  var7 = (int)((float)var12 * var16.onScreen) + var2;
                  var6 = (float)(var12 + var7) / (float)var12;
               } else {
                  var7 = var10 - (int)((float)var12 * var16.onScreen);
                  var6 = (float)(var10 - var7) / (float)var12;
               }

               boolean var8;
               if(var6 != var16.onScreen) {
                  var8 = true;
               } else {
                  var8 = false;
               }

               switch(var16.gravity & 112) {
               case 16:
                  int var14 = var5 - var3;
                  int var9 = (var14 - var13) / 2;
                  if(var9 < var16.topMargin) {
                     var2 = var16.topMargin;
                  } else {
                     var2 = var9;
                     if(var9 + var13 > var14 - var16.bottomMargin) {
                        var2 = var14 - var16.bottomMargin - var13;
                     }
                  }

                  var15.layout(var7, var2, var12 + var7, var13 + var2);
                  break;
               case 80:
                  var2 = var5 - var3;
                  var15.layout(var7, var2 - var16.bottomMargin - var15.getMeasuredHeight(), var12 + var7, var2 - var16.bottomMargin);
                  break;
               default:
                  var15.layout(var7, var16.topMargin, var12 + var7, var13 + var16.topMargin);
               }

               if(var8) {
                  this.setDrawerViewOffset(var15, var6);
               }

               byte var17;
               if(var16.onScreen > 0.0F) {
                  var17 = 0;
               } else {
                  var17 = 4;
               }

               if(var15.getVisibility() != var17) {
                  var15.setVisibility(var17);
               }
            }
         }
      }

      this.mInLayout = false;
      this.mFirstLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      int var3;
      int var4;
      int var5;
      int var7;
      label51: {
         label55: {
            short var6 = 300;
            int var9 = MeasureSpec.getMode(var1);
            int var8 = MeasureSpec.getMode(var2);
            var5 = MeasureSpec.getSize(var1);
            var7 = MeasureSpec.getSize(var2);
            if(var9 == 1073741824) {
               var4 = var5;
               if(var8 == 1073741824) {
                  break label55;
               }
            }

            if(!this.isInEditMode()) {
               throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }

            var3 = var5;
            if(var9 != Integer.MIN_VALUE) {
               var3 = var5;
               if(var9 == 0) {
                  var3 = 300;
               }
            }

            var4 = var3;
            if(var8 != Integer.MIN_VALUE) {
               var4 = var3;
               if(var8 == 0) {
                  var4 = var3;
                  var3 = var6;
                  break label51;
               }
            }
         }

         var3 = var7;
      }

      this.setMeasuredDimension(var4, var3);
      int var12 = this.getChildCount();

      for(var5 = 0; var5 < var12; ++var5) {
         View var10 = this.getChildAt(var5);
         if(var10.getVisibility() != 8) {
            DrawerLayout$LayoutParams var11 = (DrawerLayout$LayoutParams)var10.getLayoutParams();
            if(this.isContentView(var10)) {
               var10.measure(MeasureSpec.makeMeasureSpec(var4 - var11.leftMargin - var11.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec(var3 - var11.topMargin - var11.bottomMargin, 1073741824));
            } else {
               if(!this.isDrawerView(var10)) {
                  throw new IllegalStateException("Child " + var10 + " at index " + var5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
               }

               var7 = this.getDrawerViewAbsoluteGravity(var10) & 7;
               if((var7 & 0) != 0) {
                  throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(var7) + " but this DrawerLayout" + " already has a drawer view along that edge");
               }

               var10.measure(getChildMeasureSpec(var1, this.mMinDrawerMargin + var11.leftMargin + var11.rightMargin, var11.width), getChildMeasureSpec(var2, var11.topMargin + var11.bottomMargin, var11.height));
            }
         }
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      DrawerLayout$SavedState var3 = (DrawerLayout$SavedState)var1;
      super.onRestoreInstanceState(var3.getSuperState());
      if(var3.openDrawerGravity != 0) {
         View var2 = this.findDrawerWithGravity(var3.openDrawerGravity);
         if(var2 != null) {
            this.openDrawer(var2);
         }
      }

      this.setDrawerLockMode(var3.lockModeLeft, 3);
      this.setDrawerLockMode(var3.lockModeRight, 5);
   }

   protected Parcelable onSaveInstanceState() {
      DrawerLayout$SavedState var3 = new DrawerLayout$SavedState(super.onSaveInstanceState());
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         View var4 = this.getChildAt(var1);
         if(this.isDrawerView(var4)) {
            DrawerLayout$LayoutParams var5 = (DrawerLayout$LayoutParams)var4.getLayoutParams();
            if(var5.knownOpen) {
               var3.openDrawerGravity = var5.gravity;
               break;
            }
         }
      }

      var3.lockModeLeft = this.mLockModeLeft;
      var3.lockModeRight = this.mLockModeRight;
      return var3;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.mLeftDragger.processTouchEvent(var1);
      this.mRightDragger.processTouchEvent(var1);
      float var2;
      float var3;
      switch(var1.getAction() & 255) {
      case 0:
         var2 = var1.getX();
         var3 = var1.getY();
         this.mInitialMotionX = var2;
         this.mInitialMotionY = var3;
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         return true;
      case 1:
         boolean var5;
         label26: {
            var3 = var1.getX();
            var2 = var1.getY();
            View var6 = this.mLeftDragger.findTopChildUnder((int)var3, (int)var2);
            if(var6 != null && this.isContentView(var6)) {
               var3 -= this.mInitialMotionX;
               var2 -= this.mInitialMotionY;
               int var4 = this.mLeftDragger.getTouchSlop();
               if(var3 * var3 + var2 * var2 < (float)(var4 * var4)) {
                  var6 = this.findOpenDrawer();
                  if(var6 != null) {
                     if(this.getDrawerLockMode(var6) == 2) {
                        var5 = true;
                     } else {
                        var5 = false;
                     }
                     break label26;
                  }
               }
            }

            var5 = true;
         }

         this.closeDrawers(var5);
         this.mDisallowInterceptRequested = false;
         return true;
      case 2:
      default:
         return true;
      case 3:
         this.closeDrawers(true);
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         return true;
      }
   }

   public void openDrawer(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(var1));
      } else {
         this.openDrawer(var2);
      }
   }

   public void openDrawer(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      } else {
         if(this.mFirstLayout) {
            DrawerLayout$LayoutParams var2 = (DrawerLayout$LayoutParams)var1.getLayoutParams();
            var2.onScreen = 1.0F;
            var2.knownOpen = true;
         } else if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            this.mLeftDragger.smoothSlideViewTo(var1, 0, var1.getTop());
         } else {
            this.mRightDragger.smoothSlideViewTo(var1, this.getWidth() - var1.getWidth(), var1.getTop());
         }

         this.invalidate();
      }
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      super.requestDisallowInterceptTouchEvent(var1);
      this.mDisallowInterceptRequested = var1;
      if(var1) {
         this.closeDrawers(true);
      }

   }

   public void requestLayout() {
      if(!this.mInLayout) {
         super.requestLayout();
      }

   }

   public void setDrawerListener(DrawerLayout$DrawerListener var1) {
      this.mListener = var1;
   }

   public void setDrawerLockMode(int var1) {
      this.setDrawerLockMode(var1, 3);
      this.setDrawerLockMode(var1, 5);
   }

   public void setDrawerLockMode(int var1, int var2) {
      var2 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      if(var2 == 3) {
         this.mLockModeLeft = var1;
      } else if(var2 == 5) {
         this.mLockModeRight = var1;
      }

      if(var1 != 0) {
         ViewDragHelper var3;
         if(var2 == 3) {
            var3 = this.mLeftDragger;
         } else {
            var3 = this.mRightDragger;
         }

         var3.cancel();
      }

      View var4;
      switch(var1) {
      case 1:
         var4 = this.findDrawerWithGravity(var2);
         if(var4 != null) {
            this.closeDrawer(var4);
            return;
         }
         break;
      case 2:
         var4 = this.findDrawerWithGravity(var2);
         if(var4 != null) {
            this.openDrawer(var4);
            return;
         }
      }

   }

   public void setDrawerLockMode(int var1, View var2) {
      if(!this.isDrawerView(var2)) {
         throw new IllegalArgumentException("View " + var2 + " is not a drawer with appropriate layout_gravity");
      } else {
         this.setDrawerLockMode(var1, ((DrawerLayout$LayoutParams)var2.getLayoutParams()).gravity);
      }
   }

   public void setDrawerShadow(int var1, int var2) {
      this.setDrawerShadow(this.getResources().getDrawable(var1), var2);
   }

   public void setDrawerShadow(Drawable var1, int var2) {
      var2 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      if((var2 & 3) == 3) {
         this.mShadowLeft = var1;
         this.invalidate();
      }

      if((var2 & 5) == 5) {
         this.mShadowRight = var1;
         this.invalidate();
      }

   }

   public void setDrawerTitle(int var1, CharSequence var2) {
      var1 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      if(var1 == 3) {
         this.mTitleLeft = var2;
      } else if(var1 == 5) {
         this.mTitleRight = var2;
         return;
      }

   }

   void setDrawerViewOffset(View var1, float var2) {
      DrawerLayout$LayoutParams var3 = (DrawerLayout$LayoutParams)var1.getLayoutParams();
      if(var2 != var3.onScreen) {
         var3.onScreen = var2;
         this.dispatchOnDrawerSlide(var1, var2);
      }
   }

   public void setScrimColor(int var1) {
      this.mScrimColor = var1;
      this.invalidate();
   }

   void updateDrawerState(int var1, int var2, View var3) {
      byte var4 = 1;
      int var5 = this.mLeftDragger.getViewDragState();
      int var6 = this.mRightDragger.getViewDragState();
      byte var8 = var4;
      if(var5 != 1) {
         if(var6 == 1) {
            var8 = var4;
         } else if(var5 != 2 && var6 != 2) {
            var8 = 0;
         } else {
            var8 = 2;
         }
      }

      if(var3 != null && var2 == 0) {
         DrawerLayout$LayoutParams var7 = (DrawerLayout$LayoutParams)var3.getLayoutParams();
         if(var7.onScreen == 0.0F) {
            this.dispatchOnDrawerClosed(var3);
         } else if(var7.onScreen == 1.0F) {
            this.dispatchOnDrawerOpened(var3);
         }
      }

      if(var8 != this.mDrawerState) {
         this.mDrawerState = var8;
         if(this.mListener != null) {
            this.mListener.onDrawerStateChanged(var8);
         }
      }

   }
}
