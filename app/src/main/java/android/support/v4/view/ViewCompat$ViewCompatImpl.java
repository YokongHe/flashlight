package android.support.v4.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

interface ViewCompat$ViewCompatImpl {
   boolean canScrollHorizontally(View var1, int var2);

   boolean canScrollVertically(View var1, int var2);

   int getAccessibilityLiveRegion(View var1);

   AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1);

   float getAlpha(View var1);

   int getImportantForAccessibility(View var1);

   int getLabelFor(View var1);

   int getLayerType(View var1);

   int getLayoutDirection(View var1);

   int getMeasuredHeightAndState(View var1);

   int getMeasuredState(View var1);

   int getMeasuredWidthAndState(View var1);

   int getOverScrollMode(View var1);

   ViewParent getParentForAccessibility(View var1);

   boolean hasTransientState(View var1);

   boolean isOpaque(View var1);

   void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2);

   void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2);

   void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2);

   boolean performAccessibilityAction(View var1, int var2, Bundle var3);

   void postInvalidateOnAnimation(View var1);

   void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5);

   void postOnAnimation(View var1, Runnable var2);

   void postOnAnimationDelayed(View var1, Runnable var2, long var3);

   int resolveSizeAndState(int var1, int var2, int var3);

   void setAccessibilityDelegate(View var1, AccessibilityDelegateCompat var2);

   void setAccessibilityLiveRegion(View var1, int var2);

   void setHasTransientState(View var1, boolean var2);

   void setImportantForAccessibility(View var1, int var2);

   void setLabelFor(View var1, int var2);

   void setLayerPaint(View var1, Paint var2);

   void setLayerType(View var1, int var2, Paint var3);

   void setLayoutDirection(View var1, int var2);

   void setOverScrollMode(View var1, int var2);
}
