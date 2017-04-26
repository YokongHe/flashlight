package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager$Decor;
import android.support.v4.view.ViewPager$ItemInfo;
import android.support.v4.view.ViewPager$LayoutParams;
import android.support.v4.view.ViewPager$MyAccessibilityDelegate;
import android.support.v4.view.ViewPager$OnAdapterChangeListener;
import android.support.v4.view.ViewPager$OnPageChangeListener;
import android.support.v4.view.ViewPager$PageTransformer;
import android.support.v4.view.ViewPager$PagerObserver;
import android.support.v4.view.ViewPager$SavedState;
import android.support.v4.view.ViewPager$ViewPositionComparator;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
   private static final int CLOSE_ENOUGH = 2;
   private static final Comparator COMPARATOR = new Comparator() {
      public final int compare(ViewPager$ItemInfo var1, ViewPager$ItemInfo var2) {
         return var1.position - var2.position;
      }
   };
   private static final boolean DEBUG = false;
   private static final int DEFAULT_GUTTER_SIZE = 16;
   private static final int DEFAULT_OFFSCREEN_PAGES = 1;
   private static final int DRAW_ORDER_DEFAULT = 0;
   private static final int DRAW_ORDER_FORWARD = 1;
   private static final int DRAW_ORDER_REVERSE = 2;
   private static final int INVALID_POINTER = -1;
   private static final int[] LAYOUT_ATTRS = new int[]{16842931};
   private static final int MAX_SETTLE_DURATION = 600;
   private static final int MIN_DISTANCE_FOR_FLING = 25;
   private static final int MIN_FLING_VELOCITY = 400;
   public static final int SCROLL_STATE_DRAGGING = 1;
   public static final int SCROLL_STATE_IDLE = 0;
   public static final int SCROLL_STATE_SETTLING = 2;
   private static final String TAG = "ViewPager";
   private static final boolean USE_CACHE = false;
   private static final Interpolator sInterpolator = new Interpolator() {
      public final float getInterpolation(float var1) {
         --var1;
         return var1 * var1 * var1 * var1 * var1 + 1.0F;
      }
   };
   private static final ViewPager$ViewPositionComparator sPositionComparator = new ViewPager$ViewPositionComparator();
   private int mActivePointerId = -1;
   private PagerAdapter mAdapter;
   private ViewPager$OnAdapterChangeListener mAdapterChangeListener;
   private int mBottomPageBounds;
   private boolean mCalledSuper;
   private int mChildHeightMeasureSpec;
   private int mChildWidthMeasureSpec;
   private int mCloseEnough;
   private int mCurItem;
   private int mDecorChildCount;
   private int mDefaultGutterSize;
   private int mDrawingOrder;
   private ArrayList mDrawingOrderedChildren;
   private final Runnable mEndScrollRunnable = new Runnable() {
      public void run() {
         ViewPager.this.setScrollState(0);
         ViewPager.this.populate();
      }
   };
   private int mExpectedAdapterCount;
   private long mFakeDragBeginTime;
   private boolean mFakeDragging;
   private boolean mFirstLayout = true;
   private float mFirstOffset = -3.4028235E38F;
   private int mFlingDistance;
   private int mGutterSize;
   private boolean mIgnoreGutter;
   private boolean mInLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private ViewPager$OnPageChangeListener mInternalPageChangeListener;
   private boolean mIsBeingDragged;
   private boolean mIsUnableToDrag;
   private final ArrayList mItems = new ArrayList();
   private float mLastMotionX;
   private float mLastMotionY;
   private float mLastOffset = Float.MAX_VALUE;
   private EdgeEffectCompat mLeftEdge;
   private Drawable mMarginDrawable;
   private int mMaximumVelocity;
   private int mMinimumVelocity;
   private boolean mNeedCalculatePageOffsets = false;
   private ViewPager$PagerObserver mObserver;
   private int mOffscreenPageLimit = 1;
   private ViewPager$OnPageChangeListener mOnPageChangeListener;
   private int mPageMargin;
   private ViewPager$PageTransformer mPageTransformer;
   private boolean mPopulatePending;
   private Parcelable mRestoredAdapterState = null;
   private ClassLoader mRestoredClassLoader = null;
   private int mRestoredCurItem = -1;
   private EdgeEffectCompat mRightEdge;
   private int mScrollState = 0;
   private Scroller mScroller;
   private boolean mScrollingCacheEnabled;
   private Method mSetChildrenDrawingOrderEnabled;
   private final ViewPager$ItemInfo mTempItem = new ViewPager$ItemInfo();
   private final Rect mTempRect = new Rect();
   private int mTopPageBounds;
   private int mTouchSlop;
   private VelocityTracker mVelocityTracker;

   public ViewPager(Context var1) {
      super(var1);
      this.initViewPager();
   }

   public ViewPager(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initViewPager();
   }

   // $FF: synthetic method
   static PagerAdapter access$200(ViewPager var0) {
      return var0.mAdapter;
   }

   // $FF: synthetic method
   static int access$300(ViewPager var0) {
      return var0.mCurItem;
   }

   // $FF: synthetic method
   static int[] access$400() {
      return LAYOUT_ATTRS;
   }

   private void calculatePageOffsets(ViewPager$ItemInfo var1, int var2, ViewPager$ItemInfo var3) {
      int var10 = this.mAdapter.getCount();
      int var7 = this.getClientWidth();
      float var5;
      if(var7 > 0) {
         var5 = (float)this.mPageMargin / (float)var7;
      } else {
         var5 = 0.0F;
      }

      float var4;
      float var6;
      int var8;
      int var9;
      if(var3 != null) {
         var7 = var3.position;
         if(var7 < var1.position) {
            var4 = var3.offset + var3.widthFactor + var5;
            ++var7;

            for(var8 = 0; var7 <= var1.position && var8 < this.mItems.size(); var7 = var9 + 1) {
               var3 = (ViewPager$ItemInfo)this.mItems.get(var8);

               while(true) {
                  var9 = var7;
                  var6 = var4;
                  if(var7 <= var3.position) {
                     break;
                  }

                  var9 = var7;
                  var6 = var4;
                  if(var8 >= this.mItems.size() - 1) {
                     break;
                  }

                  ++var8;
                  var3 = (ViewPager$ItemInfo)this.mItems.get(var8);
               }

               while(var9 < var3.position) {
                  var6 += this.mAdapter.getPageWidth(var9) + var5;
                  ++var9;
               }

               var3.offset = var6;
               var4 = var6 + var3.widthFactor + var5;
            }
         } else if(var7 > var1.position) {
            var8 = this.mItems.size() - 1;
            var4 = var3.offset;
            --var7;

            while(var7 >= var1.position && var8 >= 0) {
               var3 = (ViewPager$ItemInfo)this.mItems.get(var8);

               while(true) {
                  var9 = var7;
                  var6 = var4;
                  if(var7 >= var3.position) {
                     break;
                  }

                  var9 = var7;
                  var6 = var4;
                  if(var8 <= 0) {
                     break;
                  }

                  --var8;
                  var3 = (ViewPager$ItemInfo)this.mItems.get(var8);
               }

               while(var9 > var3.position) {
                  var6 -= this.mAdapter.getPageWidth(var9) + var5;
                  --var9;
               }

               var4 = var6 - (var3.widthFactor + var5);
               var3.offset = var4;
               var7 = var9 - 1;
            }
         }
      }

      var9 = this.mItems.size();
      var6 = var1.offset;
      var7 = var1.position - 1;
      if(var1.position == 0) {
         var4 = var1.offset;
      } else {
         var4 = -3.4028235E38F;
      }

      this.mFirstOffset = var4;
      if(var1.position == var10 - 1) {
         var4 = var1.offset + var1.widthFactor - 1.0F;
      } else {
         var4 = Float.MAX_VALUE;
      }

      this.mLastOffset = var4;
      var8 = var2 - 1;

      for(var4 = var6; var8 >= 0; --var8) {
         for(var3 = (ViewPager$ItemInfo)this.mItems.get(var8); var7 > var3.position; --var7) {
            var4 -= this.mAdapter.getPageWidth(var7) + var5;
         }

         var4 -= var3.widthFactor + var5;
         var3.offset = var4;
         if(var3.position == 0) {
            this.mFirstOffset = var4;
         }

         --var7;
      }

      var4 = var1.offset + var1.widthFactor + var5;
      var8 = var1.position + 1;
      var7 = var2 + 1;

      for(var2 = var8; var7 < var9; ++var7) {
         for(var1 = (ViewPager$ItemInfo)this.mItems.get(var7); var2 < var1.position; ++var2) {
            var4 += this.mAdapter.getPageWidth(var2) + var5;
         }

         if(var1.position == var10 - 1) {
            this.mLastOffset = var1.widthFactor + var4 - 1.0F;
         }

         var1.offset = var4;
         var4 += var1.widthFactor + var5;
         ++var2;
      }

      this.mNeedCalculatePageOffsets = false;
   }

   private void completeScroll(boolean var1) {
      boolean var2;
      if(this.mScrollState == 2) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var2) {
         this.setScrollingCacheEnabled(false);
         this.mScroller.abortAnimation();
         int var3 = this.getScrollX();
         int var4 = this.getScrollY();
         int var5 = this.mScroller.getCurrX();
         int var6 = this.mScroller.getCurrY();
         if(var3 != var5 || var4 != var6) {
            this.scrollTo(var5, var6);
         }
      }

      this.mPopulatePending = false;
      byte var10 = 0;
      boolean var9 = var2;

      for(int var8 = var10; var8 < this.mItems.size(); ++var8) {
         ViewPager$ItemInfo var7 = (ViewPager$ItemInfo)this.mItems.get(var8);
         if(var7.scrolling) {
            var7.scrolling = false;
            var9 = true;
         }
      }

      if(var9) {
         if(!var1) {
            this.mEndScrollRunnable.run();
            return;
         }

         ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
      }

   }

   private int determineTargetPage(int var1, float var2, int var3, int var4) {
      if(Math.abs(var4) > this.mFlingDistance && Math.abs(var3) > this.mMinimumVelocity) {
         if(var3 <= 0) {
            ++var1;
         }
      } else {
         float var5;
         if(var1 >= this.mCurItem) {
            var5 = 0.4F;
         } else {
            var5 = 0.6F;
         }

         var1 = (int)(var5 + (float)var1 + var2);
      }

      var3 = var1;
      if(this.mItems.size() > 0) {
         ViewPager$ItemInfo var6 = (ViewPager$ItemInfo)this.mItems.get(0);
         ViewPager$ItemInfo var7 = (ViewPager$ItemInfo)this.mItems.get(this.mItems.size() - 1);
         var3 = Math.max(var6.position, Math.min(var1, var7.position));
      }

      return var3;
   }

   private void enableLayers(boolean var1) {
      int var4 = this.getChildCount();

      for(int var2 = 0; var2 < var4; ++var2) {
         byte var3;
         if(var1) {
            var3 = 2;
         } else {
            var3 = 0;
         }

         ViewCompat.setLayerType(this.getChildAt(var2), var3, (Paint)null);
      }

   }

   private void endDrag() {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   private Rect getChildRectInPagerCoordinates(Rect var1, View var2) {
      if(var1 == null) {
         var1 = new Rect();
      }

      if(var2 == null) {
         var1.set(0, 0, 0, 0);
         return var1;
      } else {
         var1.left = var2.getLeft();
         var1.right = var2.getRight();
         var1.top = var2.getTop();
         var1.bottom = var2.getBottom();

         ViewGroup var4;
         for(ViewParent var3 = var2.getParent(); var3 instanceof ViewGroup && var3 != this; var3 = var4.getParent()) {
            var4 = (ViewGroup)var3;
            var1.left += var4.getLeft();
            var1.right += var4.getRight();
            var1.top += var4.getTop();
            var1.bottom += var4.getBottom();
         }

         return var1;
      }
   }

   private int getClientWidth() {
      return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
   }

   private ViewPager$ItemInfo infoForCurrentScrollPosition() {
      int var5 = this.getClientWidth();
      float var1;
      if(var5 > 0) {
         var1 = (float)this.getScrollX() / (float)var5;
      } else {
         var1 = 0.0F;
      }

      float var2;
      if(var5 > 0) {
         var2 = (float)this.mPageMargin / (float)var5;
      } else {
         var2 = 0.0F;
      }

      float var4 = 0.0F;
      float var3 = 0.0F;
      int var7 = -1;
      var5 = 0;
      boolean var6 = true;
      ViewPager$ItemInfo var9 = null;

      ViewPager$ItemInfo var10;
      while(true) {
         var10 = var9;
         if(var5 >= this.mItems.size()) {
            break;
         }

         ViewPager$ItemInfo var8 = (ViewPager$ItemInfo)this.mItems.get(var5);
         if(!var6 && var8.position != var7 + 1) {
            var8 = this.mTempItem;
            var8.offset = var4 + var3 + var2;
            var8.position = var7 + 1;
            var8.widthFactor = this.mAdapter.getPageWidth(var8.position);
            --var5;
         }

         var3 = var8.offset;
         var4 = var8.widthFactor;
         if(!var6) {
            var10 = var9;
            if(var1 < var3) {
               break;
            }
         }

         if(var1 < var4 + var3 + var2 || var5 == this.mItems.size() - 1) {
            var10 = var8;
            break;
         }

         var7 = var8.position;
         var4 = var8.widthFactor;
         var6 = false;
         ++var5;
         var9 = var8;
      }

      return var10;
   }

   private boolean isGutterDrag(float var1, float var2) {
      return var1 < (float)this.mGutterSize && var2 > 0.0F || var1 > (float)(this.getWidth() - this.mGutterSize) && var2 < 0.0F;
   }

   private void onSecondaryPointerUp(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionIndex(var1);
      if(MotionEventCompat.getPointerId(var1, var2) == this.mActivePointerId) {
         byte var3;
         if(var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.mLastMotionX = MotionEventCompat.getX(var1, var3);
         this.mActivePointerId = MotionEventCompat.getPointerId(var1, var3);
         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
         }
      }

   }

   private boolean pageScrolled(int var1) {
      boolean var6 = false;
      if(this.mItems.size() == 0) {
         this.mCalledSuper = false;
         this.onPageScrolled(0, 0.0F, 0);
         if(!this.mCalledSuper) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
         }
      } else {
         ViewPager$ItemInfo var7 = this.infoForCurrentScrollPosition();
         int var4 = this.getClientWidth();
         int var5 = this.mPageMargin;
         float var2 = (float)this.mPageMargin / (float)var4;
         int var3 = var7.position;
         var2 = ((float)var1 / (float)var4 - var7.offset) / (var7.widthFactor + var2);
         var1 = (int)((float)(var5 + var4) * var2);
         this.mCalledSuper = false;
         this.onPageScrolled(var3, var2, var1);
         if(!this.mCalledSuper) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
         }

         var6 = true;
      }

      return var6;
   }

   private boolean performDrag(float var1) {
      boolean var6 = true;
      boolean var9 = false;
      boolean var8 = false;
      float var2 = this.mLastMotionX;
      this.mLastMotionX = var1;
      float var3 = (float)this.getScrollX() + (var2 - var1);
      int var7 = this.getClientWidth();
      var1 = (float)var7 * this.mFirstOffset;
      var2 = (float)var7;
      float var4 = this.mLastOffset;
      ViewPager$ItemInfo var10 = (ViewPager$ItemInfo)this.mItems.get(0);
      ViewPager$ItemInfo var11 = (ViewPager$ItemInfo)this.mItems.get(this.mItems.size() - 1);
      boolean var5;
      if(var10.position != 0) {
         var1 = var10.offset * (float)var7;
         var5 = false;
      } else {
         var5 = true;
      }

      if(var11.position != this.mAdapter.getCount() - 1) {
         var2 = var11.offset * (float)var7;
         var6 = false;
      } else {
         var2 *= var4;
      }

      if(var3 < var1) {
         var2 = var1;
         if(var5) {
            var8 = this.mLeftEdge.onPull(Math.abs(var1 - var3) / (float)var7);
            var2 = var1;
         }
      } else if(var3 > var2) {
         var8 = var9;
         if(var6) {
            var8 = this.mRightEdge.onPull(Math.abs(var3 - var2) / (float)var7);
         }
      } else {
         var2 = var3;
      }

      this.mLastMotionX += var2 - (float)((int)var2);
      this.scrollTo((int)var2, this.getScrollY());
      this.pageScrolled((int)var2);
      return var8;
   }

   private void recomputeScrollPosition(int var1, int var2, int var3, int var4) {
      float var5;
      ViewPager$ItemInfo var10;
      if(var2 > 0 && !this.mItems.isEmpty()) {
         int var6 = this.getPaddingLeft();
         int var7 = this.getPaddingRight();
         int var8 = this.getPaddingLeft();
         int var9 = this.getPaddingRight();
         var5 = (float)this.getScrollX() / (float)(var2 - var8 - var9 + var4);
         var2 = (int)((float)(var1 - var6 - var7 + var3) * var5);
         this.scrollTo(var2, this.getScrollY());
         if(!this.mScroller.isFinished()) {
            var3 = this.mScroller.getDuration();
            var4 = this.mScroller.timePassed();
            var10 = this.infoForPosition(this.mCurItem);
            this.mScroller.startScroll(var2, 0, (int)(var10.offset * (float)var1), 0, var3 - var4);
         }
      } else {
         var10 = this.infoForPosition(this.mCurItem);
         if(var10 != null) {
            var5 = Math.min(var10.offset, this.mLastOffset);
         } else {
            var5 = 0.0F;
         }

         var1 = (int)(var5 * (float)(var1 - this.getPaddingLeft() - this.getPaddingRight()));
         if(var1 != this.getScrollX()) {
            this.completeScroll(false);
            this.scrollTo(var1, this.getScrollY());
            return;
         }
      }

   }

   private void removeNonDecorViews() {
      int var2;
      for(int var1 = 0; var1 < this.getChildCount(); var1 = var2 + 1) {
         var2 = var1;
         if(!((ViewPager$LayoutParams)this.getChildAt(var1).getLayoutParams()).isDecor) {
            this.removeViewAt(var1);
            var2 = var1 - 1;
         }
      }

   }

   private void requestParentDisallowInterceptTouchEvent(boolean var1) {
      ViewParent var2 = this.getParent();
      if(var2 != null) {
         var2.requestDisallowInterceptTouchEvent(var1);
      }

   }

   private void scrollToItem(int var1, boolean var2, int var3, boolean var4) {
      ViewPager$ItemInfo var7 = this.infoForPosition(var1);
      int var6;
      if(var7 != null) {
         float var5 = (float)this.getClientWidth();
         var6 = (int)(Math.max(this.mFirstOffset, Math.min(var7.offset, this.mLastOffset)) * var5);
      } else {
         var6 = 0;
      }

      if(var2) {
         this.smoothScrollTo(var6, 0, var3);
         if(var4 && this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(var1);
         }

         if(var4 && this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(var1);
         }

      } else {
         if(var4 && this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(var1);
         }

         if(var4 && this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(var1);
         }

         this.completeScroll(false);
         this.scrollTo(var6, 0);
         this.pageScrolled(var6);
      }
   }

   private void setScrollState(int var1) {
      if(this.mScrollState != var1) {
         this.mScrollState = var1;
         if(this.mPageTransformer != null) {
            boolean var2;
            if(var1 != 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.enableLayers(var2);
         }

         if(this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(var1);
            return;
         }
      }

   }

   private void setScrollingCacheEnabled(boolean var1) {
      if(this.mScrollingCacheEnabled != var1) {
         this.mScrollingCacheEnabled = var1;
      }

   }

   private void sortChildDrawingOrder() {
      if(this.mDrawingOrder != 0) {
         if(this.mDrawingOrderedChildren == null) {
            this.mDrawingOrderedChildren = new ArrayList();
         } else {
            this.mDrawingOrderedChildren.clear();
         }

         int var2 = this.getChildCount();

         for(int var1 = 0; var1 < var2; ++var1) {
            View var3 = this.getChildAt(var1);
            this.mDrawingOrderedChildren.add(var3);
         }

         Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
      }

   }

   public void addFocusables(ArrayList var1, int var2, int var3) {
      int var5 = var1.size();
      int var6 = this.getDescendantFocusability();
      if(var6 != 393216) {
         for(int var4 = 0; var4 < this.getChildCount(); ++var4) {
            View var7 = this.getChildAt(var4);
            if(var7.getVisibility() == 0) {
               ViewPager$ItemInfo var8 = this.infoForChild(var7);
               if(var8 != null && var8.position == this.mCurItem) {
                  var7.addFocusables(var1, var2, var3);
               }
            }
         }
      }

      if((var6 != 262144 || var5 == var1.size()) && this.isFocusable() && ((var3 & 1) != 1 || !this.isInTouchMode() || this.isFocusableInTouchMode()) && var1 != null) {
         var1.add(this);
      }
   }

   ViewPager$ItemInfo addNewItem(int var1, int var2) {
      ViewPager$ItemInfo var3 = new ViewPager$ItemInfo();
      var3.position = var1;
      var3.object = this.mAdapter.instantiateItem((ViewGroup)this, var1);
      var3.widthFactor = this.mAdapter.getPageWidth(var1);
      if(var2 >= 0 && var2 < this.mItems.size()) {
         this.mItems.add(var2, var3);
         return var3;
      } else {
         this.mItems.add(var3);
         return var3;
      }
   }

   public void addTouchables(ArrayList var1) {
      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         View var3 = this.getChildAt(var2);
         if(var3.getVisibility() == 0) {
            ViewPager$ItemInfo var4 = this.infoForChild(var3);
            if(var4 != null && var4.position == this.mCurItem) {
               var3.addTouchables(var1);
            }
         }
      }

   }

   public void addView(View var1, int var2, LayoutParams var3) {
      if(!this.checkLayoutParams(var3)) {
         var3 = this.generateLayoutParams(var3);
      }

      ViewPager$LayoutParams var4 = (ViewPager$LayoutParams)var3;
      var4.isDecor |= var1 instanceof ViewPager$Decor;
      if(this.mInLayout) {
         if(var4 != null && var4.isDecor) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
         } else {
            var4.needsMeasure = true;
            this.addViewInLayout(var1, var2, var3);
         }
      } else {
         super.addView(var1, var2, var3);
      }
   }

   public boolean arrowScroll(int var1) {
      View var6 = this.findFocus();
      View var5;
      if(var6 == this) {
         var5 = null;
      } else {
         label86: {
            if(var6 != null) {
               ViewParent var9 = var6.getParent();

               boolean var2;
               while(true) {
                  if(!(var9 instanceof ViewGroup)) {
                     var2 = false;
                     break;
                  }

                  if(var9 == this) {
                     var2 = true;
                     break;
                  }

                  var9 = var9.getParent();
               }

               if(!var2) {
                  StringBuilder var7 = new StringBuilder();
                  var7.append(var6.getClass().getSimpleName());

                  for(var9 = var6.getParent(); var9 instanceof ViewGroup; var9 = var9.getParent()) {
                     var7.append(" => ").append(var9.getClass().getSimpleName());
                  }

                  Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + var7.toString());
                  var5 = null;
                  break label86;
               }
            }

            var5 = var6;
         }
      }

      boolean var4;
      label95: {
         var6 = FocusFinder.getInstance().findNextFocus(this, var5, var1);
         if(var6 != null && var6 != var5) {
            int var3;
            int var8;
            if(var1 == 17) {
               var8 = this.getChildRectInPagerCoordinates(this.mTempRect, var6).left;
               var3 = this.getChildRectInPagerCoordinates(this.mTempRect, var5).left;
               if(var5 != null && var8 >= var3) {
                  var4 = this.pageLeft();
               } else {
                  var4 = var6.requestFocus();
               }
               break label95;
            }

            if(var1 == 66) {
               var8 = this.getChildRectInPagerCoordinates(this.mTempRect, var6).left;
               var3 = this.getChildRectInPagerCoordinates(this.mTempRect, var5).left;
               if(var5 != null && var8 <= var3) {
                  var4 = this.pageRight();
               } else {
                  var4 = var6.requestFocus();
               }
               break label95;
            }
         } else {
            if(var1 == 17 || var1 == 1) {
               var4 = this.pageLeft();
               break label95;
            }

            if(var1 == 66 || var1 == 2) {
               var4 = this.pageRight();
               break label95;
            }
         }

         var4 = false;
      }

      if(var4) {
         this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(var1));
      }

      return var4;
   }

   public boolean beginFakeDrag() {
      if(this.mIsBeingDragged) {
         return false;
      } else {
         this.mFakeDragging = true;
         this.setScrollState(1);
         this.mLastMotionX = 0.0F;
         this.mInitialMotionX = 0.0F;
         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         } else {
            this.mVelocityTracker.clear();
         }

         long var1 = SystemClock.uptimeMillis();
         MotionEvent var3 = MotionEvent.obtain(var1, var1, 0, 0.0F, 0.0F, 0);
         this.mVelocityTracker.addMovement(var3);
         var3.recycle();
         this.mFakeDragBeginTime = var1;
         return true;
      }
   }

   protected boolean canScroll(View var1, boolean var2, int var3, int var4, int var5) {
      if(var1 instanceof ViewGroup) {
         ViewGroup var9 = (ViewGroup)var1;
         int var7 = var1.getScrollX();
         int var8 = var1.getScrollY();

         for(int var6 = var9.getChildCount() - 1; var6 >= 0; --var6) {
            View var10 = var9.getChildAt(var6);
            if(var4 + var7 >= var10.getLeft() && var4 + var7 < var10.getRight() && var5 + var8 >= var10.getTop() && var5 + var8 < var10.getBottom() && this.canScroll(var10, true, var3, var4 + var7 - var10.getLeft(), var5 + var8 - var10.getTop())) {
               return true;
            }
         }
      }

      if(!var2 || !ViewCompat.canScrollHorizontally(var1, -var3)) {
         return false;
      } else {
         return true;
      }
   }

   public boolean canScrollHorizontally(int var1) {
      if(this.mAdapter != null) {
         int var2 = this.getClientWidth();
         int var3 = this.getScrollX();
         if(var1 < 0) {
            if(var3 > (int)((float)var2 * this.mFirstOffset)) {
               return true;
            }
         } else if(var1 > 0 && var3 < (int)((float)var2 * this.mLastOffset)) {
            return true;
         }
      }

      return false;
   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof ViewPager$LayoutParams && super.checkLayoutParams(var1);
   }

   public void computeScroll() {
      if(!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
         int var1 = this.getScrollX();
         int var2 = this.getScrollY();
         int var3 = this.mScroller.getCurrX();
         int var4 = this.mScroller.getCurrY();
         if(var1 != var3 || var2 != var4) {
            this.scrollTo(var3, var4);
            if(!this.pageScrolled(var3)) {
               this.mScroller.abortAnimation();
               this.scrollTo(0, var4);
            }
         }

         ViewCompat.postInvalidateOnAnimation(this);
      } else {
         this.completeScroll(true);
      }
   }

   void dataSetChanged() {
      int var7 = this.mAdapter.getCount();
      this.mExpectedAdapterCount = var7;
      boolean var1;
      if(this.mItems.size() < this.mOffscreenPageLimit * 2 + 1 && this.mItems.size() < var7) {
         var1 = true;
      } else {
         var1 = false;
      }

      int var2 = this.mCurItem;
      boolean var3 = false;
      byte var5 = 0;
      boolean var4 = var1;
      int var9 = var2;
      boolean var10 = var3;

      int var11;
      for(var11 = var5; var11 < this.mItems.size(); var4 = var3) {
         int var12;
         label56: {
            ViewPager$ItemInfo var8 = (ViewPager$ItemInfo)this.mItems.get(var11);
            int var13 = this.mAdapter.getItemPosition(var8.object);
            if(var13 != -1) {
               if(var13 == -2) {
                  this.mItems.remove(var11);
                  var12 = var11 - 1;
                  var3 = var10;
                  if(!var10) {
                     this.mAdapter.startUpdate((ViewGroup)this);
                     var3 = true;
                  }

                  this.mAdapter.destroyItem((ViewGroup)this, var8.position, var8.object);
                  if(this.mCurItem == var8.position) {
                     var2 = Math.max(0, Math.min(this.mCurItem, var7 - 1));
                     var1 = var3;
                     var3 = true;
                  } else {
                     var2 = var9;
                     boolean var14 = true;
                     var1 = var3;
                     var3 = var14;
                  }
                  break label56;
               }

               if(var8.position != var13) {
                  if(var8.position == this.mCurItem) {
                     var9 = var13;
                  }

                  var8.position = var13;
                  boolean var6 = true;
                  var12 = var11;
                  var1 = var10;
                  var2 = var9;
                  var3 = var6;
                  break label56;
               }
            }

            var12 = var11;
            var1 = var10;
            var2 = var9;
            var3 = var4;
         }

         var11 = var12 + 1;
         var10 = var1;
         var9 = var2;
      }

      if(var10) {
         this.mAdapter.finishUpdate((ViewGroup)this);
      }

      Collections.sort(this.mItems, COMPARATOR);
      if(var4) {
         var11 = this.getChildCount();

         for(var2 = 0; var2 < var11; ++var2) {
            ViewPager$LayoutParams var16 = (ViewPager$LayoutParams)this.getChildAt(var2).getLayoutParams();
            if(!var16.isDecor) {
               var16.widthFactor = 0.0F;
            }
         }

         this.setCurrentItemInternal(var9, false, true);
         this.requestLayout();
      }

   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      return super.dispatchKeyEvent(var1) || this.executeKeyEvent(var1);
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      boolean var5 = false;
      boolean var4;
      if(var1.getEventType() == 4096) {
         var4 = super.dispatchPopulateAccessibilityEvent(var1);
      } else {
         int var3 = this.getChildCount();
         int var2 = 0;

         while(true) {
            var4 = var5;
            if(var2 >= var3) {
               break;
            }

            View var6 = this.getChildAt(var2);
            if(var6.getVisibility() == 0) {
               ViewPager$ItemInfo var7 = this.infoForChild(var6);
               if(var7 != null && var7.position == this.mCurItem && var6.dispatchPopulateAccessibilityEvent(var1)) {
                  return true;
               }
            }

            ++var2;
         }
      }

      return var4;
   }

   float distanceInfluenceForSnapDuration(float var1) {
      return (float)Math.sin((double)((float)((double)(var1 - 0.5F) * 0.4712389167638204D)));
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      boolean var3 = false;
      boolean var2 = false;
      int var4 = ViewCompat.getOverScrollMode(this);
      if(var4 != 0 && (var4 != 1 || this.mAdapter == null || this.mAdapter.getCount() <= 1)) {
         this.mLeftEdge.finish();
         this.mRightEdge.finish();
      } else {
         int var9;
         if(!this.mLeftEdge.isFinished()) {
            var9 = var1.save();
            int var8 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            var4 = this.getWidth();
            var1.rotate(270.0F);
            var1.translate((float)(-var8 + this.getPaddingTop()), this.mFirstOffset * (float)var4);
            this.mLeftEdge.setSize(var8, var4);
            var2 = this.mLeftEdge.draw(var1) | false;
            var1.restoreToCount(var9);
         }

         var3 = var2;
         if(!this.mRightEdge.isFinished()) {
            var4 = var1.save();
            var9 = this.getWidth();
            int var5 = this.getHeight();
            int var6 = this.getPaddingTop();
            int var7 = this.getPaddingBottom();
            var1.rotate(90.0F);
            var1.translate((float)(-this.getPaddingTop()), -(this.mLastOffset + 1.0F) * (float)var9);
            this.mRightEdge.setSize(var5 - var6 - var7, var9);
            var3 = var2 | this.mRightEdge.draw(var1);
            var1.restoreToCount(var4);
         }
      }

      if(var3) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      Drawable var1 = this.mMarginDrawable;
      if(var1 != null && var1.isStateful()) {
         var1.setState(this.getDrawableState());
      }

   }

   public void endFakeDrag() {
      if(!this.mFakeDragging) {
         throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      } else {
         VelocityTracker var4 = this.mVelocityTracker;
         var4.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
         int var1 = (int)VelocityTrackerCompat.getXVelocity(var4, this.mActivePointerId);
         this.mPopulatePending = true;
         int var2 = this.getClientWidth();
         int var3 = this.getScrollX();
         ViewPager$ItemInfo var5 = this.infoForCurrentScrollPosition();
         this.setCurrentItemInternal(this.determineTargetPage(var5.position, ((float)var3 / (float)var2 - var5.offset) / var5.widthFactor, var1, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, var1);
         this.endDrag();
         this.mFakeDragging = false;
      }
   }

   public boolean executeKeyEvent(KeyEvent var1) {
      if(var1.getAction() == 0) {
         switch(var1.getKeyCode()) {
         case 21:
            return this.arrowScroll(17);
         case 22:
            return this.arrowScroll(66);
         case 61:
            if(VERSION.SDK_INT >= 11) {
               if(KeyEventCompat.hasNoModifiers(var1)) {
                  return this.arrowScroll(2);
               }

               if(KeyEventCompat.hasModifiers(var1, 1)) {
                  return this.arrowScroll(1);
               }
            }
         }
      }

      return false;
   }

   public void fakeDragBy(float var1) {
      if(!this.mFakeDragging) {
         throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      } else {
         this.mLastMotionX += var1;
         float var3 = (float)this.getScrollX() - var1;
         int var6 = this.getClientWidth();
         var1 = (float)var6;
         float var5 = this.mFirstOffset;
         float var2 = (float)var6;
         float var4 = this.mLastOffset;
         ViewPager$ItemInfo var9 = (ViewPager$ItemInfo)this.mItems.get(0);
         ViewPager$ItemInfo var10 = (ViewPager$ItemInfo)this.mItems.get(this.mItems.size() - 1);
         if(var9.position != 0) {
            var1 = var9.offset * (float)var6;
         } else {
            var1 *= var5;
         }

         if(var10.position != this.mAdapter.getCount() - 1) {
            var2 = var10.offset * (float)var6;
         } else {
            var2 *= var4;
         }

         if(var3 >= var1) {
            if(var3 > var2) {
               var1 = var2;
            } else {
               var1 = var3;
            }
         }

         this.mLastMotionX += var1 - (float)((int)var1);
         this.scrollTo((int)var1, this.getScrollY());
         this.pageScrolled((int)var1);
         long var7 = SystemClock.uptimeMillis();
         MotionEvent var11 = MotionEvent.obtain(this.mFakeDragBeginTime, var7, 2, this.mLastMotionX, 0.0F, 0);
         this.mVelocityTracker.addMovement(var11);
         var11.recycle();
      }
   }

   protected LayoutParams generateDefaultLayoutParams() {
      return new ViewPager$LayoutParams();
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return new ViewPager$LayoutParams(this.getContext(), var1);
   }

   protected LayoutParams generateLayoutParams(LayoutParams var1) {
      return this.generateDefaultLayoutParams();
   }

   public PagerAdapter getAdapter() {
      return this.mAdapter;
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      int var3 = var2;
      if(this.mDrawingOrder == 2) {
         var3 = var1 - 1 - var2;
      }

      return ((ViewPager$LayoutParams)((View)this.mDrawingOrderedChildren.get(var3)).getLayoutParams()).childIndex;
   }

   public int getCurrentItem() {
      return this.mCurItem;
   }

   public int getOffscreenPageLimit() {
      return this.mOffscreenPageLimit;
   }

   public int getPageMargin() {
      return this.mPageMargin;
   }

   ViewPager$ItemInfo infoForAnyChild(View var1) {
      while(true) {
         ViewParent var2 = var1.getParent();
         if(var2 != this) {
            if(var2 != null && var2 instanceof View) {
               var1 = (View)var2;
               continue;
            }

            return null;
         }

         return this.infoForChild(var1);
      }
   }

   ViewPager$ItemInfo infoForChild(View var1) {
      for(int var2 = 0; var2 < this.mItems.size(); ++var2) {
         ViewPager$ItemInfo var3 = (ViewPager$ItemInfo)this.mItems.get(var2);
         if(this.mAdapter.isViewFromObject(var1, var3.object)) {
            return var3;
         }
      }

      return null;
   }

   ViewPager$ItemInfo infoForPosition(int var1) {
      for(int var2 = 0; var2 < this.mItems.size(); ++var2) {
         ViewPager$ItemInfo var3 = (ViewPager$ItemInfo)this.mItems.get(var2);
         if(var3.position == var1) {
            return var3;
         }
      }

      return null;
   }

   void initViewPager() {
      this.setWillNotDraw(false);
      this.setDescendantFocusability(262144);
      this.setFocusable(true);
      Context var2 = this.getContext();
      this.mScroller = new Scroller(var2, sInterpolator);
      ViewConfiguration var3 = ViewConfiguration.get(var2);
      float var1 = var2.getResources().getDisplayMetrics().density;
      this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(var3);
      this.mMinimumVelocity = (int)(400.0F * var1);
      this.mMaximumVelocity = var3.getScaledMaximumFlingVelocity();
      this.mLeftEdge = new EdgeEffectCompat(var2);
      this.mRightEdge = new EdgeEffectCompat(var2);
      this.mFlingDistance = (int)(25.0F * var1);
      this.mCloseEnough = (int)(2.0F * var1);
      this.mDefaultGutterSize = (int)(16.0F * var1);
      ViewCompat.setAccessibilityDelegate(this, new ViewPager$MyAccessibilityDelegate(this));
      if(ViewCompat.getImportantForAccessibility(this) == 0) {
         ViewCompat.setImportantForAccessibility(this, 1);
      }

   }

   public boolean isFakeDragging() {
      return this.mFakeDragging;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mFirstLayout = true;
   }

   protected void onDetachedFromWindow() {
      this.removeCallbacks(this.mEndScrollRunnable);
      super.onDetachedFromWindow();
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
         int var8 = this.getScrollX();
         int var9 = this.getWidth();
         float var4 = (float)this.mPageMargin / (float)var9;
         ViewPager$ItemInfo var12 = (ViewPager$ItemInfo)this.mItems.get(0);
         float var2 = var12.offset;
         int var10 = this.mItems.size();
         int var6 = var12.position;
         int var11 = ((ViewPager$ItemInfo)this.mItems.get(var10 - 1)).position;

         for(int var7 = 0; var6 < var11; ++var6) {
            while(var6 > var12.position && var7 < var10) {
               ArrayList var13 = this.mItems;
               ++var7;
               var12 = (ViewPager$ItemInfo)var13.get(var7);
            }

            float var3;
            if(var6 == var12.position) {
               var3 = (var12.offset + var12.widthFactor) * (float)var9;
               var2 = var12.offset + var12.widthFactor + var4;
            } else {
               float var5 = this.mAdapter.getPageWidth(var6);
               var3 = (var2 + var5) * (float)var9;
               var2 += var5 + var4;
            }

            if((float)this.mPageMargin + var3 > (float)var8) {
               this.mMarginDrawable.setBounds((int)var3, this.mTopPageBounds, (int)((float)this.mPageMargin + var3 + 0.5F), this.mBottomPageBounds);
               this.mMarginDrawable.draw(var1);
            }

            if(var3 > (float)(var8 + var9)) {
               break;
            }
         }
      }

   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var7;
      label79: {
         var7 = var1.getAction() & 255;
         if(var7 != 3 && var7 != 1) {
            if(var7 == 0) {
               break label79;
            }

            if(this.mIsBeingDragged) {
               return true;
            }

            if(!this.mIsUnableToDrag) {
               break label79;
            }
         } else {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            if(this.mVelocityTracker != null) {
               this.mVelocityTracker.recycle();
               this.mVelocityTracker = null;
            }
         }

         return false;
      }

      float var2;
      switch(var7) {
      case 0:
         var2 = var1.getX();
         this.mInitialMotionX = var2;
         this.mLastMotionX = var2;
         var2 = var1.getY();
         this.mInitialMotionY = var2;
         this.mLastMotionY = var2;
         this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
         this.mIsUnableToDrag = false;
         this.mScroller.computeScrollOffset();
         if(this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            this.populate();
            this.mIsBeingDragged = true;
            this.requestParentDisallowInterceptTouchEvent(true);
            this.setScrollState(1);
         } else {
            this.completeScroll(false);
            this.mIsBeingDragged = false;
         }
         break;
      case 2:
         var7 = this.mActivePointerId;
         if(var7 != -1) {
            var7 = MotionEventCompat.findPointerIndex(var1, var7);
            float var3 = MotionEventCompat.getX(var1, var7);
            var2 = var3 - this.mLastMotionX;
            float var5 = Math.abs(var2);
            float var4 = MotionEventCompat.getY(var1, var7);
            float var6 = Math.abs(var4 - this.mInitialMotionY);
            if(var2 != 0.0F && !this.isGutterDrag(this.mLastMotionX, var2) && this.canScroll(this, false, (int)var2, (int)var3, (int)var4)) {
               this.mLastMotionX = var3;
               this.mLastMotionY = var4;
               this.mIsUnableToDrag = true;
               return false;
            }

            if(var5 > (float)this.mTouchSlop && 0.5F * var5 > var6) {
               this.mIsBeingDragged = true;
               this.requestParentDisallowInterceptTouchEvent(true);
               this.setScrollState(1);
               if(var2 > 0.0F) {
                  var2 = this.mInitialMotionX + (float)this.mTouchSlop;
               } else {
                  var2 = this.mInitialMotionX - (float)this.mTouchSlop;
               }

               this.mLastMotionX = var2;
               this.mLastMotionY = var4;
               this.setScrollingCacheEnabled(true);
            } else if(var6 > (float)this.mTouchSlop) {
               this.mIsUnableToDrag = true;
            }

            if(this.mIsBeingDragged && this.performDrag(var3)) {
               ViewCompat.postInvalidateOnAnimation(this);
            }
         }
         break;
      case 6:
         this.onSecondaryPointerUp(var1);
      }

      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

      this.mVelocityTracker.addMovement(var1);
      return this.mIsBeingDragged;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var12 = this.getChildCount();
      int var14 = var4 - var2;
      int var13 = var5 - var3;
      var3 = this.getPaddingLeft();
      var2 = this.getPaddingTop();
      int var7 = this.getPaddingRight();
      var4 = this.getPaddingBottom();
      int var15 = this.getScrollX();
      int var8 = 0;

      int var9;
      View var17;
      ViewPager$LayoutParams var18;
      for(int var10 = 0; var10 < var12; var3 = var9) {
         label53: {
            var17 = this.getChildAt(var10);
            if(var17.getVisibility() != 8) {
               var18 = (ViewPager$LayoutParams)var17.getLayoutParams();
               if(var18.isDecor) {
                  var5 = var18.gravity;
                  int var16 = var18.gravity;
                  int var11;
                  switch(var5 & 7) {
                  case 1:
                     var5 = Math.max((var14 - var17.getMeasuredWidth()) / 2, var3);
                     var9 = var3;
                     break;
                  case 2:
                  case 4:
                  default:
                     var5 = var3;
                     var9 = var3;
                     break;
                  case 3:
                     var9 = var17.getMeasuredWidth();
                     var5 = var3;
                     var9 += var3;
                     break;
                  case 5:
                     var9 = var17.getMeasuredWidth();
                     var5 = var7 + var17.getMeasuredWidth();
                     var11 = var14 - var7 - var9;
                     var7 = var5;
                     var9 = var3;
                     var5 = var11;
                  }

                  switch(var16 & 112) {
                  case 16:
                     var11 = Math.max((var13 - var17.getMeasuredHeight()) / 2, var2);
                     var3 = var2;
                     var2 = var4;
                     var4 = var11;
                     break;
                  case 48:
                     var11 = var17.getMeasuredHeight();
                     var3 = var4;
                     var11 += var2;
                     var4 = var2;
                     var2 = var3;
                     var3 = var11;
                     break;
                  case 80:
                     var11 = var13 - var4 - var17.getMeasuredHeight();
                     var16 = var17.getMeasuredHeight();
                     var3 = var2;
                     var2 = var4 + var16;
                     var4 = var11;
                     break;
                  default:
                     var11 = var2;
                     var3 = var2;
                     var2 = var4;
                     var4 = var11;
                  }

                  var5 += var15;
                  var17.layout(var5, var4, var17.getMeasuredWidth() + var5, var17.getMeasuredHeight() + var4);
                  ++var8;
                  var5 = var7;
                  var4 = var9;
                  var7 = var2;
                  var2 = var8;
                  break label53;
               }
            }

            var5 = var8;
            var8 = var2;
            var9 = var3;
            var2 = var5;
            var5 = var7;
            var7 = var4;
            var3 = var8;
            var4 = var9;
         }

         ++var10;
         var9 = var4;
         var8 = var2;
         var2 = var3;
         var4 = var7;
         var7 = var5;
      }

      var7 = var14 - var3 - var7;

      for(var5 = 0; var5 < var12; ++var5) {
         var17 = this.getChildAt(var5);
         if(var17.getVisibility() != 8) {
            var18 = (ViewPager$LayoutParams)var17.getLayoutParams();
            if(!var18.isDecor) {
               ViewPager$ItemInfo var19 = this.infoForChild(var17);
               if(var19 != null) {
                  float var6 = (float)var7;
                  var9 = (int)(var19.offset * var6) + var3;
                  if(var18.needsMeasure) {
                     var18.needsMeasure = false;
                     var6 = (float)var7;
                     var17.measure(MeasureSpec.makeMeasureSpec((int)(var18.widthFactor * var6), 1073741824), MeasureSpec.makeMeasureSpec(var13 - var2 - var4, 1073741824));
                  }

                  var17.layout(var9, var2, var17.getMeasuredWidth() + var9, var17.getMeasuredHeight() + var2);
               }
            }
         }
      }

      this.mTopPageBounds = var2;
      this.mBottomPageBounds = var13 - var4;
      this.mDecorChildCount = var8;
      if(this.mFirstLayout) {
         this.scrollToItem(this.mCurItem, false, 0, false);
      }

      this.mFirstLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(getDefaultSize(0, var1), getDefaultSize(0, var2));
      var1 = this.getMeasuredWidth();
      this.mGutterSize = Math.min(var1 / 10, this.mDefaultGutterSize);
      var1 = var1 - this.getPaddingLeft() - this.getPaddingRight();
      var2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
      int var12 = this.getChildCount();

      int var4;
      int var5;
      View var13;
      ViewPager$LayoutParams var14;
      for(int var6 = 0; var6 < var12; var2 = var5) {
         var13 = this.getChildAt(var6);
         var4 = var1;
         var5 = var2;
         if(var13.getVisibility() != 8) {
            var14 = (ViewPager$LayoutParams)var13.getLayoutParams();
            var4 = var1;
            var5 = var2;
            if(var14 != null) {
               var4 = var1;
               var5 = var2;
               if(var14.isDecor) {
                  var4 = var14.gravity & 7;
                  int var7 = var14.gravity & 112;
                  int var9 = Integer.MIN_VALUE;
                  var5 = Integer.MIN_VALUE;
                  boolean var15;
                  if(var7 != 48 && var7 != 80) {
                     var15 = false;
                  } else {
                     var15 = true;
                  }

                  boolean var8;
                  if(var4 != 3 && var4 != 5) {
                     var8 = false;
                  } else {
                     var8 = true;
                  }

                  if(var15) {
                     var4 = 1073741824;
                  } else {
                     var4 = var9;
                     if(var8) {
                        var5 = 1073741824;
                        var4 = var9;
                     }
                  }

                  if(var14.width != -2) {
                     var9 = 1073741824;
                     if(var14.width != -1) {
                        var4 = var14.width;
                     } else {
                        var4 = var1;
                     }
                  } else {
                     var9 = var4;
                     var4 = var1;
                  }

                  int var10;
                  label72: {
                     if(var14.height != -2) {
                        var10 = 1073741824;
                        var5 = var10;
                        if(var14.height != -1) {
                           int var11 = var14.height;
                           var5 = var10;
                           var10 = var11;
                           break label72;
                        }
                     }

                     var10 = var2;
                  }

                  var13.measure(MeasureSpec.makeMeasureSpec(var4, var9), MeasureSpec.makeMeasureSpec(var10, var5));
                  if(var15) {
                     var5 = var2 - var13.getMeasuredHeight();
                     var4 = var1;
                  } else {
                     var4 = var1;
                     var5 = var2;
                     if(var8) {
                        var4 = var1 - var13.getMeasuredWidth();
                        var5 = var2;
                     }
                  }
               }
            }
         }

         ++var6;
         var1 = var4;
      }

      this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(var1, 1073741824);
      this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(var2, 1073741824);
      this.mInLayout = true;
      this.populate();
      this.mInLayout = false;
      var4 = this.getChildCount();

      for(var2 = 0; var2 < var4; ++var2) {
         var13 = this.getChildAt(var2);
         if(var13.getVisibility() != 8) {
            var14 = (ViewPager$LayoutParams)var13.getLayoutParams();
            if(var14 == null || !var14.isDecor) {
               float var3 = (float)var1;
               var13.measure(MeasureSpec.makeMeasureSpec((int)(var14.widthFactor * var3), 1073741824), this.mChildHeightMeasureSpec);
            }
         }
      }

   }

   protected void onPageScrolled(int var1, float var2, int var3) {
      int var4;
      View var13;
      if(this.mDecorChildCount > 0) {
         int var9 = this.getScrollX();
         var4 = this.getPaddingLeft();
         int var5 = this.getPaddingRight();
         int var10 = this.getWidth();
         int var11 = this.getChildCount();

         int var6;
         for(int var8 = 0; var8 < var11; var5 = var6) {
            var13 = this.getChildAt(var8);
            ViewPager$LayoutParams var14 = (ViewPager$LayoutParams)var13.getLayoutParams();
            int var7;
            if(var14.isDecor) {
               int var12;
               switch(var14.gravity & 7) {
               case 1:
                  var6 = Math.max((var10 - var13.getMeasuredWidth()) / 2, var4);
                  var7 = var4;
                  var4 = var5;
                  var5 = var7;
                  break;
               case 2:
               case 4:
               default:
                  var6 = var4;
                  var7 = var5;
                  var5 = var4;
                  var4 = var7;
                  break;
               case 3:
                  var6 = var13.getWidth();
                  var7 = var6 + var4;
                  var6 = var4;
                  var4 = var5;
                  var5 = var7;
                  break;
               case 5:
                  var6 = var10 - var5 - var13.getMeasuredWidth();
                  var12 = var13.getMeasuredWidth();
                  var7 = var4;
                  var4 = var5 + var12;
                  var5 = var7;
               }

               var12 = var6 + var9 - var13.getLeft();
               var6 = var4;
               var7 = var5;
               if(var12 != 0) {
                  var13.offsetLeftAndRight(var12);
                  var7 = var5;
                  var6 = var4;
               }
            } else {
               var6 = var5;
               var7 = var4;
            }

            ++var8;
            var4 = var7;
         }
      }

      if(this.mOnPageChangeListener != null) {
         this.mOnPageChangeListener.onPageScrolled(var1, var2, var3);
      }

      if(this.mInternalPageChangeListener != null) {
         this.mInternalPageChangeListener.onPageScrolled(var1, var2, var3);
      }

      if(this.mPageTransformer != null) {
         var3 = this.getScrollX();
         var4 = this.getChildCount();

         for(var1 = 0; var1 < var4; ++var1) {
            var13 = this.getChildAt(var1);
            if(!((ViewPager$LayoutParams)var13.getLayoutParams()).isDecor) {
               var2 = (float)(var13.getLeft() - var3) / (float)this.getClientWidth();
               this.mPageTransformer.transformPage(var13, var2);
            }
         }
      }

      this.mCalledSuper = true;
   }

   protected boolean onRequestFocusInDescendants(int var1, Rect var2) {
      byte var5 = -1;
      int var4 = this.getChildCount();
      int var3;
      if((var1 & 2) != 0) {
         var5 = 1;
         var3 = 0;
      } else {
         var3 = var4 - 1;
         var4 = -1;
      }

      for(; var3 != var4; var3 += var5) {
         View var6 = this.getChildAt(var3);
         if(var6.getVisibility() == 0) {
            ViewPager$ItemInfo var7 = this.infoForChild(var6);
            if(var7 != null && var7.position == this.mCurItem && var6.requestFocus(var1, var2)) {
               return true;
            }
         }
      }

      return false;
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(!(var1 instanceof ViewPager$SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         ViewPager$SavedState var2 = (ViewPager$SavedState)var1;
         super.onRestoreInstanceState(var2.getSuperState());
         if(this.mAdapter != null) {
            this.mAdapter.restoreState(var2.adapterState, var2.loader);
            this.setCurrentItemInternal(var2.position, false, true);
         } else {
            this.mRestoredCurItem = var2.position;
            this.mRestoredAdapterState = var2.adapterState;
            this.mRestoredClassLoader = var2.loader;
         }
      }
   }

   public Parcelable onSaveInstanceState() {
      ViewPager$SavedState var1 = new ViewPager$SavedState(super.onSaveInstanceState());
      var1.position = this.mCurItem;
      if(this.mAdapter != null) {
         var1.adapterState = this.mAdapter.saveState();
      }

      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(var1 != var3) {
         this.recomputeScrollPosition(var1, var3, this.mPageMargin, this.mPageMargin);
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var7 = false;
      if(this.mFakeDragging) {
         return true;
      } else if(var1.getAction() == 0 && var1.getEdgeFlags() != 0) {
         return false;
      } else if(this.mAdapter != null && this.mAdapter.getCount() != 0) {
         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         }

         this.mVelocityTracker.addMovement(var1);
         boolean var6 = var7;
         float var2;
         boolean var9;
         int var11;
         switch(var1.getAction() & 255) {
         case 0:
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            this.populate();
            var2 = var1.getX();
            this.mInitialMotionX = var2;
            this.mLastMotionX = var2;
            var2 = var1.getY();
            this.mInitialMotionY = var2;
            this.mLastMotionY = var2;
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            var6 = var7;
            break;
         case 1:
            var6 = var7;
            if(this.mIsBeingDragged) {
               VelocityTracker var13 = this.mVelocityTracker;
               var13.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
               var11 = (int)VelocityTrackerCompat.getXVelocity(var13, this.mActivePointerId);
               this.mPopulatePending = true;
               int var12 = this.getClientWidth();
               int var8 = this.getScrollX();
               ViewPager$ItemInfo var14 = this.infoForCurrentScrollPosition();
               this.setCurrentItemInternal(this.determineTargetPage(var14.position, ((float)var8 / (float)var12 - var14.offset) / var14.widthFactor, var11, (int)(MotionEventCompat.getX(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId)) - this.mInitialMotionX)), true, true, var11);
               this.mActivePointerId = -1;
               this.endDrag();
               var9 = this.mLeftEdge.onRelease();
               var6 = this.mRightEdge.onRelease() | var9;
            }
            break;
         case 2:
            if(!this.mIsBeingDragged) {
               var11 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
               var2 = MotionEventCompat.getX(var1, var11);
               float var4 = Math.abs(var2 - this.mLastMotionX);
               float var3 = MotionEventCompat.getY(var1, var11);
               float var5 = Math.abs(var3 - this.mLastMotionY);
               if(var4 > (float)this.mTouchSlop && var4 > var5) {
                  this.mIsBeingDragged = true;
                  this.requestParentDisallowInterceptTouchEvent(true);
                  if(var2 - this.mInitialMotionX > 0.0F) {
                     var2 = this.mInitialMotionX + (float)this.mTouchSlop;
                  } else {
                     var2 = this.mInitialMotionX - (float)this.mTouchSlop;
                  }

                  this.mLastMotionX = var2;
                  this.mLastMotionY = var3;
                  this.setScrollState(1);
                  this.setScrollingCacheEnabled(true);
                  ViewParent var10 = this.getParent();
                  if(var10 != null) {
                     var10.requestDisallowInterceptTouchEvent(true);
                  }
               }
            }

            var6 = var7;
            if(this.mIsBeingDragged) {
               var6 = this.performDrag(MotionEventCompat.getX(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId))) | false;
            }
            break;
         case 3:
            var6 = var7;
            if(this.mIsBeingDragged) {
               this.scrollToItem(this.mCurItem, true, 0, false);
               this.mActivePointerId = -1;
               this.endDrag();
               var9 = this.mLeftEdge.onRelease();
               var6 = this.mRightEdge.onRelease() | var9;
            }
         case 4:
            break;
         case 5:
            var11 = MotionEventCompat.getActionIndex(var1);
            this.mLastMotionX = MotionEventCompat.getX(var1, var11);
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, var11);
            var6 = var7;
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
            this.mLastMotionX = MotionEventCompat.getX(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId));
            var6 = var7;
            break;
         default:
            var6 = var7;
         }

         if(var6) {
            ViewCompat.postInvalidateOnAnimation(this);
         }

         return true;
      } else {
         return false;
      }
   }

   boolean pageLeft() {
      if(this.mCurItem > 0) {
         this.setCurrentItem(this.mCurItem - 1, true);
         return true;
      } else {
         return false;
      }
   }

   boolean pageRight() {
      if(this.mAdapter != null && this.mCurItem < this.mAdapter.getCount() - 1) {
         this.setCurrentItem(this.mCurItem + 1, true);
         return true;
      } else {
         return false;
      }
   }

   void populate() {
      this.populate(this.mCurItem);
   }

   void populate(int var1) {
      byte var6;
      ViewPager$ItemInfo var15;
      if(this.mCurItem != var1) {
         byte var5;
         if(this.mCurItem < var1) {
            var5 = 66;
         } else {
            var5 = 17;
         }

         var15 = this.infoForPosition(this.mCurItem);
         this.mCurItem = var1;
         var6 = var5;
      } else {
         var15 = null;
         var6 = 2;
      }

      if(this.mAdapter == null) {
         this.sortChildDrawingOrder();
      } else {
         if(this.mPopulatePending) {
            this.sortChildDrawingOrder();
            return;
         }

         if(this.getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup)this);
            var1 = this.mOffscreenPageLimit;
            int var12 = Math.max(0, this.mCurItem - var1);
            int var10 = this.mAdapter.getCount();
            int var11 = Math.min(var10 - 1, var1 + this.mCurItem);
            if(var10 != this.mExpectedAdapterCount) {
               String var25;
               try {
                  var25 = this.getResources().getResourceName(this.getId());
               } catch (NotFoundException var18) {
                  var25 = Integer.toHexString(this.getId());
               }

               throw new IllegalStateException("The application\'s PagerAdapter changed the adapter\'s contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + var10 + " Pager id: " + var25 + " Pager class: " + this.getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }

            ViewPager$ItemInfo var14;
            label217: {
               for(var1 = 0; var1 < this.mItems.size(); ++var1) {
                  var14 = (ViewPager$ItemInfo)this.mItems.get(var1);
                  if(var14.position >= this.mCurItem) {
                     if(var14.position == this.mCurItem) {
                        break label217;
                     }
                     break;
                  }
               }

               var14 = null;
            }

            ViewPager$ItemInfo var16;
            if(var14 == null && var10 > 0) {
               var16 = this.addNewItem(this.mCurItem, var1);
            } else {
               var16 = var14;
            }

            int var19;
            if(var16 != null) {
               int var9 = var1 - 1;
               if(var9 >= 0) {
                  var14 = (ViewPager$ItemInfo)this.mItems.get(var9);
               } else {
                  var14 = null;
               }

               int var13 = this.getClientWidth();
               float var3;
               if(var13 <= 0) {
                  var3 = 0.0F;
               } else {
                  var3 = 2.0F - var16.widthFactor + (float)this.getPaddingLeft() / (float)var13;
               }

               var19 = this.mCurItem;
               float var4 = 0.0F;
               int var8 = var19 - 1;
               int var7 = var1;

               float var2;
               for(ViewPager$ItemInfo var17 = var14; var8 >= 0; var7 = var19) {
                  if(var4 >= var3 && var8 < var12) {
                     if(var17 == null) {
                        break;
                     }

                     var14 = var17;
                     var1 = var9;
                     var2 = var4;
                     var19 = var7;
                     if(var8 == var17.position) {
                        var14 = var17;
                        var1 = var9;
                        var2 = var4;
                        var19 = var7;
                        if(!var17.scrolling) {
                           this.mItems.remove(var9);
                           this.mAdapter.destroyItem((ViewGroup)this, var8, var17.object);
                           var1 = var9 - 1;
                           var19 = var7 - 1;
                           if(var1 >= 0) {
                              var14 = (ViewPager$ItemInfo)this.mItems.get(var1);
                              var2 = var4;
                           } else {
                              var14 = null;
                              var2 = var4;
                           }
                        }
                     }
                  } else if(var17 != null && var8 == var17.position) {
                     var2 = var4 + var17.widthFactor;
                     var1 = var9 - 1;
                     if(var1 >= 0) {
                        var14 = (ViewPager$ItemInfo)this.mItems.get(var1);
                        var19 = var7;
                     } else {
                        var14 = null;
                        var19 = var7;
                     }
                  } else {
                     var2 = var4 + this.addNewItem(var8, var9 + 1).widthFactor;
                     var19 = var7 + 1;
                     if(var9 >= 0) {
                        var14 = (ViewPager$ItemInfo)this.mItems.get(var9);
                        var1 = var9;
                     } else {
                        var14 = null;
                        var1 = var9;
                     }
                  }

                  --var8;
                  var17 = var14;
                  var9 = var1;
                  var4 = var2;
               }

               var2 = var16.widthFactor;
               var1 = var7 + 1;
               if(var2 < 2.0F) {
                  if(var1 < this.mItems.size()) {
                     var14 = (ViewPager$ItemInfo)this.mItems.get(var1);
                  } else {
                     var14 = null;
                  }

                  if(var13 <= 0) {
                     var3 = 0.0F;
                  } else {
                     var3 = (float)this.getPaddingRight() / (float)var13 + 2.0F;
                  }

                  var19 = this.mCurItem;
                  ++var19;

                  for(; var19 < var10; ++var19) {
                     if(var2 >= var3 && var19 > var11) {
                        if(var14 == null) {
                           break;
                        }

                        if(var19 == var14.position && !var14.scrolling) {
                           this.mItems.remove(var1);
                           this.mAdapter.destroyItem((ViewGroup)this, var19, var14.object);
                           if(var1 < this.mItems.size()) {
                              var14 = (ViewPager$ItemInfo)this.mItems.get(var1);
                           } else {
                              var14 = null;
                           }
                        }
                     } else if(var14 != null && var19 == var14.position) {
                        var4 = var14.widthFactor;
                        ++var1;
                        if(var1 < this.mItems.size()) {
                           var14 = (ViewPager$ItemInfo)this.mItems.get(var1);
                        } else {
                           var14 = null;
                        }

                        var2 += var4;
                     } else {
                        var14 = this.addNewItem(var19, var1);
                        ++var1;
                        var4 = var14.widthFactor;
                        if(var1 < this.mItems.size()) {
                           var14 = (ViewPager$ItemInfo)this.mItems.get(var1);
                        } else {
                           var14 = null;
                        }

                        var2 += var4;
                     }
                  }
               }

               this.calculatePageOffsets(var16, var7, var15);
            }

            PagerAdapter var20 = this.mAdapter;
            var1 = this.mCurItem;
            Object var22;
            if(var16 != null) {
               var22 = var16.object;
            } else {
               var22 = null;
            }

            var20.setPrimaryItem((ViewGroup)this, var1, var22);
            this.mAdapter.finishUpdate((ViewGroup)this);
            var19 = this.getChildCount();

            for(var1 = 0; var1 < var19; ++var1) {
               View var21 = this.getChildAt(var1);
               ViewPager$LayoutParams var23 = (ViewPager$LayoutParams)var21.getLayoutParams();
               var23.childIndex = var1;
               if(!var23.isDecor && var23.widthFactor == 0.0F) {
                  var15 = this.infoForChild(var21);
                  if(var15 != null) {
                     var23.widthFactor = var15.widthFactor;
                     var23.position = var15.position;
                  }
               }
            }

            this.sortChildDrawingOrder();
            if(this.hasFocus()) {
               View var24 = this.findFocus();
               if(var24 != null) {
                  var14 = this.infoForAnyChild(var24);
               } else {
                  var14 = null;
               }

               if(var14 == null || var14.position != this.mCurItem) {
                  for(var1 = 0; var1 < this.getChildCount(); ++var1) {
                     var24 = this.getChildAt(var1);
                     var15 = this.infoForChild(var24);
                     if(var15 != null && var15.position == this.mCurItem && var24.requestFocus(var6)) {
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   public void removeView(View var1) {
      if(this.mInLayout) {
         this.removeViewInLayout(var1);
      } else {
         super.removeView(var1);
      }
   }

   public void setAdapter(PagerAdapter var1) {
      if(this.mAdapter != null) {
         this.mAdapter.unregisterDataSetObserver(this.mObserver);
         this.mAdapter.startUpdate((ViewGroup)this);

         for(int var2 = 0; var2 < this.mItems.size(); ++var2) {
            ViewPager$ItemInfo var4 = (ViewPager$ItemInfo)this.mItems.get(var2);
            this.mAdapter.destroyItem((ViewGroup)this, var4.position, var4.object);
         }

         this.mAdapter.finishUpdate((ViewGroup)this);
         this.mItems.clear();
         this.removeNonDecorViews();
         this.mCurItem = 0;
         this.scrollTo(0, 0);
      }

      PagerAdapter var5 = this.mAdapter;
      this.mAdapter = var1;
      this.mExpectedAdapterCount = 0;
      if(this.mAdapter != null) {
         if(this.mObserver == null) {
            this.mObserver = new ViewPager$PagerObserver(this, null);
         }

         this.mAdapter.registerDataSetObserver(this.mObserver);
         this.mPopulatePending = false;
         boolean var3 = this.mFirstLayout;
         this.mFirstLayout = true;
         this.mExpectedAdapterCount = this.mAdapter.getCount();
         if(this.mRestoredCurItem >= 0) {
            this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
            this.setCurrentItemInternal(this.mRestoredCurItem, false, true);
            this.mRestoredCurItem = -1;
            this.mRestoredAdapterState = null;
            this.mRestoredClassLoader = null;
         } else if(!var3) {
            this.populate();
         } else {
            this.requestLayout();
         }
      }

      if(this.mAdapterChangeListener != null && var5 != var1) {
         this.mAdapterChangeListener.onAdapterChanged(var5, var1);
      }

   }

   void setChildrenDrawingOrderEnabledCompat(boolean var1) {
      if(VERSION.SDK_INT >= 7) {
         if(this.mSetChildrenDrawingOrderEnabled == null) {
            try {
               this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException var4) {
               Log.e("ViewPager", "Can\'t find setChildrenDrawingOrderEnabled", var4);
            }
         }

         try {
            this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(var1)});
         } catch (Exception var3) {
            Log.e("ViewPager", "Error changing children drawing order", var3);
            return;
         }
      }

   }

   public void setCurrentItem(int var1) {
      this.mPopulatePending = false;
      boolean var2;
      if(!this.mFirstLayout) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setCurrentItemInternal(var1, var2, false);
   }

   public void setCurrentItem(int var1, boolean var2) {
      this.mPopulatePending = false;
      this.setCurrentItemInternal(var1, var2, false);
   }

   void setCurrentItemInternal(int var1, boolean var2, boolean var3) {
      this.setCurrentItemInternal(var1, var2, var3, 0);
   }

   void setCurrentItemInternal(int var1, boolean var2, boolean var3, int var4) {
      boolean var6 = false;
      if(this.mAdapter != null && this.mAdapter.getCount() > 0) {
         if(!var3 && this.mCurItem == var1 && this.mItems.size() != 0) {
            this.setScrollingCacheEnabled(false);
         } else {
            int var5;
            if(var1 < 0) {
               var5 = 0;
            } else {
               var5 = var1;
               if(var1 >= this.mAdapter.getCount()) {
                  var5 = this.mAdapter.getCount() - 1;
               }
            }

            var1 = this.mOffscreenPageLimit;
            if(var5 > this.mCurItem + var1 || var5 < this.mCurItem - var1) {
               for(var1 = 0; var1 < this.mItems.size(); ++var1) {
                  ((ViewPager$ItemInfo)this.mItems.get(var1)).scrolling = true;
               }
            }

            var3 = var6;
            if(this.mCurItem != var5) {
               var3 = true;
            }

            if(this.mFirstLayout) {
               this.mCurItem = var5;
               if(var3 && this.mOnPageChangeListener != null) {
                  this.mOnPageChangeListener.onPageSelected(var5);
               }

               if(var3 && this.mInternalPageChangeListener != null) {
                  this.mInternalPageChangeListener.onPageSelected(var5);
               }

               this.requestLayout();
            } else {
               this.populate(var5);
               this.scrollToItem(var5, var2, var4, var3);
            }
         }
      } else {
         this.setScrollingCacheEnabled(false);
      }
   }

   ViewPager$OnPageChangeListener setInternalPageChangeListener(ViewPager$OnPageChangeListener var1) {
      ViewPager$OnPageChangeListener var2 = this.mInternalPageChangeListener;
      this.mInternalPageChangeListener = var1;
      return var2;
   }

   public void setOffscreenPageLimit(int var1) {
      int var2 = var1;
      if(var1 <= 0) {
         Log.w("ViewPager", "Requested offscreen page limit " + var1 + " too small; defaulting to 1");
         var2 = 1;
      }

      if(var2 != this.mOffscreenPageLimit) {
         this.mOffscreenPageLimit = var2;
         this.populate();
      }

   }

   void setOnAdapterChangeListener(ViewPager$OnAdapterChangeListener var1) {
      this.mAdapterChangeListener = var1;
   }

   public void setOnPageChangeListener(ViewPager$OnPageChangeListener var1) {
      this.mOnPageChangeListener = var1;
   }

   public void setPageMargin(int var1) {
      int var2 = this.mPageMargin;
      this.mPageMargin = var1;
      int var3 = this.getWidth();
      this.recomputeScrollPosition(var3, var3, var1, var2);
      this.requestLayout();
   }

   public void setPageMarginDrawable(int var1) {
      this.setPageMarginDrawable(this.getContext().getResources().getDrawable(var1));
   }

   public void setPageMarginDrawable(Drawable var1) {
      this.mMarginDrawable = var1;
      if(var1 != null) {
         this.refreshDrawableState();
      }

      boolean var2;
      if(var1 == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setPageTransformer(boolean var1, ViewPager$PageTransformer var2) {
      byte var4 = 1;
      if(VERSION.SDK_INT >= 11) {
         boolean var5;
         if(var2 != null) {
            var5 = true;
         } else {
            var5 = false;
         }

         boolean var6;
         if(this.mPageTransformer != null) {
            var6 = true;
         } else {
            var6 = false;
         }

         boolean var3;
         if(var5 != var6) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.mPageTransformer = var2;
         this.setChildrenDrawingOrderEnabledCompat(var5);
         if(var5) {
            if(var1) {
               var4 = 2;
            }

            this.mDrawingOrder = var4;
         } else {
            this.mDrawingOrder = 0;
         }

         if(var3) {
            this.populate();
         }
      }

   }

   void smoothScrollTo(int var1, int var2) {
      this.smoothScrollTo(var1, var2, 0);
   }

   void smoothScrollTo(int var1, int var2, int var3) {
      if(this.getChildCount() == 0) {
         this.setScrollingCacheEnabled(false);
      } else {
         int var7 = this.getScrollX();
         int var8 = this.getScrollY();
         int var9 = var1 - var7;
         var2 -= var8;
         if(var9 == 0 && var2 == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
         } else {
            this.setScrollingCacheEnabled(true);
            this.setScrollState(2);
            var1 = this.getClientWidth();
            int var10 = var1 / 2;
            float var6 = Math.min(1.0F, (float)Math.abs(var9) * 1.0F / (float)var1);
            float var4 = (float)var10;
            float var5 = (float)var10;
            var6 = this.distanceInfluenceForSnapDuration(var6);
            var3 = Math.abs(var3);
            if(var3 > 0) {
               var1 = Math.round(1000.0F * Math.abs((var5 * var6 + var4) / (float)var3)) * 4;
            } else {
               var4 = (float)var1;
               var5 = this.mAdapter.getPageWidth(this.mCurItem);
               var1 = (int)(((float)Math.abs(var9) / (var4 * var5 + (float)this.mPageMargin) + 1.0F) * 100.0F);
            }

            var1 = Math.min(var1, 600);
            this.mScroller.startScroll(var7, var8, var9, var2, var1);
            ViewCompat.postInvalidateOnAnimation(this);
         }
      }
   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mMarginDrawable;
   }
}
