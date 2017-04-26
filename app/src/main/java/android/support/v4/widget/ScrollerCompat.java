package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImplBase;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImplGingerbread;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImplIcs;
import android.view.animation.Interpolator;

public class ScrollerCompat {
   static final ScrollerCompat$ScrollerCompatImpl IMPL;
   Object mScroller;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 14) {
         IMPL = new ScrollerCompat$ScrollerCompatImplIcs();
      } else if(var0 >= 9) {
         IMPL = new ScrollerCompat$ScrollerCompatImplGingerbread();
      } else {
         IMPL = new ScrollerCompat$ScrollerCompatImplBase();
      }
   }

   ScrollerCompat(Context var1, Interpolator var2) {
      this.mScroller = IMPL.createScroller(var1, var2);
   }

   public static ScrollerCompat create(Context var0) {
      return create(var0, (Interpolator)null);
   }

   public static ScrollerCompat create(Context var0, Interpolator var1) {
      return new ScrollerCompat(var0, var1);
   }

   public void abortAnimation() {
      IMPL.abortAnimation(this.mScroller);
   }

   public boolean computeScrollOffset() {
      return IMPL.computeScrollOffset(this.mScroller);
   }

   public void fling(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      IMPL.fling(this.mScroller, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void fling(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      IMPL.fling(this.mScroller, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public float getCurrVelocity() {
      return IMPL.getCurrVelocity(this.mScroller);
   }

   public int getCurrX() {
      return IMPL.getCurrX(this.mScroller);
   }

   public int getCurrY() {
      return IMPL.getCurrY(this.mScroller);
   }

   public int getFinalX() {
      return IMPL.getFinalX(this.mScroller);
   }

   public int getFinalY() {
      return IMPL.getFinalY(this.mScroller);
   }

   public boolean isFinished() {
      return IMPL.isFinished(this.mScroller);
   }

   public boolean isOverScrolled() {
      return IMPL.isOverScrolled(this.mScroller);
   }

   public void notifyHorizontalEdgeReached(int var1, int var2, int var3) {
      IMPL.notifyHorizontalEdgeReached(this.mScroller, var1, var2, var3);
   }

   public void notifyVerticalEdgeReached(int var1, int var2, int var3) {
      IMPL.notifyVerticalEdgeReached(this.mScroller, var1, var2, var3);
   }

   public void startScroll(int var1, int var2, int var3, int var4) {
      IMPL.startScroll(this.mScroller, var1, var2, var3, var4);
   }

   public void startScroll(int var1, int var2, int var3, int var4, int var5) {
      IMPL.startScroll(this.mScroller, var1, var2, var3, var4, var5);
   }
}
