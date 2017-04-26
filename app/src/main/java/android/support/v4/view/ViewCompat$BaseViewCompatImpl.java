package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat$ViewCompatImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

class ViewCompat$BaseViewCompatImpl implements ViewCompat$ViewCompatImpl {
   public boolean canScrollHorizontally(View var1, int var2) {
      return false;
   }

   public boolean canScrollVertically(View var1, int var2) {
      return false;
   }

   public int getAccessibilityLiveRegion(View var1) {
      return 0;
   }

   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
      return null;
   }

   public float getAlpha(View var1) {
      return 1.0F;
   }

   long getFrameTime() {
      return 10L;
   }

   public int getImportantForAccessibility(View var1) {
      return 0;
   }

   public int getLabelFor(View var1) {
      return 0;
   }

   public int getLayerType(View var1) {
      return 0;
   }

   public int getLayoutDirection(View var1) {
      return 0;
   }

   public int getMeasuredHeightAndState(View var1) {
      return var1.getMeasuredHeight();
   }

   public int getMeasuredState(View var1) {
      return 0;
   }

   public int getMeasuredWidthAndState(View var1) {
      return var1.getMeasuredWidth();
   }

   public int getOverScrollMode(View var1) {
      return 2;
   }

   public ViewParent getParentForAccessibility(View var1) {
      return var1.getParent();
   }

   public boolean hasTransientState(View var1) {
      return false;
   }

   public boolean isOpaque(View var1) {
      boolean var3 = false;
      Drawable var4 = var1.getBackground();
      boolean var2 = var3;
      if(var4 != null) {
         var2 = var3;
         if(var4.getOpacity() == -1) {
            var2 = true;
         }
      }

      return var2;
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return false;
   }

   public void postInvalidateOnAnimation(View var1) {
      var1.postInvalidateDelayed(this.getFrameTime());
   }

   public void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5) {
      var1.postInvalidateDelayed(this.getFrameTime(), var2, var3, var4, var5);
   }

   public void postOnAnimation(View var1, Runnable var2) {
      var1.postDelayed(var2, this.getFrameTime());
   }

   public void postOnAnimationDelayed(View var1, Runnable var2, long var3) {
      var1.postDelayed(var2, this.getFrameTime() + var3);
   }

   public int resolveSizeAndState(int var1, int var2, int var3) {
      return View.resolveSize(var1, var2);
   }

   public void setAccessibilityDelegate(View var1, AccessibilityDelegateCompat var2) {
   }

   public void setAccessibilityLiveRegion(View var1, int var2) {
   }

   public void setHasTransientState(View var1, boolean var2) {
   }

   public void setImportantForAccessibility(View var1, int var2) {
   }

   public void setLabelFor(View var1, int var2) {
   }

   public void setLayerPaint(View var1, Paint var2) {
   }

   public void setLayerType(View var1, int var2, Paint var3) {
   }

   public void setLayoutDirection(View var1, int var2) {
   }

   public void setOverScrollMode(View var1, int var2) {
   }
}
