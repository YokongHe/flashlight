package android.support.v4.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat$BaseViewCompatImpl;
import android.support.v4.view.ViewCompat$GBViewCompatImpl;
import android.support.v4.view.ViewCompat$HCViewCompatImpl;
import android.support.v4.view.ViewCompat$ICSViewCompatImpl;
import android.support.v4.view.ViewCompat$JBViewCompatImpl;
import android.support.v4.view.ViewCompat$JbMr1ViewCompatImpl;
import android.support.v4.view.ViewCompat$KitKatViewCompatImpl;
import android.support.v4.view.ViewCompat$ViewCompatImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewCompat {
   public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
   public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
   public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
   private static final long FAKE_FRAME_TIME = 10L;
   static final ViewCompat$ViewCompatImpl IMPL;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
   public static final int LAYER_TYPE_HARDWARE = 2;
   public static final int LAYER_TYPE_NONE = 0;
   public static final int LAYER_TYPE_SOFTWARE = 1;
   public static final int LAYOUT_DIRECTION_INHERIT = 2;
   public static final int LAYOUT_DIRECTION_LOCALE = 3;
   public static final int LAYOUT_DIRECTION_LTR = 0;
   public static final int LAYOUT_DIRECTION_RTL = 1;
   public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
   public static final int MEASURED_SIZE_MASK = 16777215;
   public static final int MEASURED_STATE_MASK = -16777216;
   public static final int MEASURED_STATE_TOO_SMALL = 16777216;
   public static final int OVER_SCROLL_ALWAYS = 0;
   public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
   public static final int OVER_SCROLL_NEVER = 2;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 19) {
         IMPL = new ViewCompat$KitKatViewCompatImpl();
      } else if(var0 >= 17) {
         IMPL = new ViewCompat$JbMr1ViewCompatImpl();
      } else if(var0 >= 16) {
         IMPL = new ViewCompat$JBViewCompatImpl();
      } else if(var0 >= 14) {
         IMPL = new ViewCompat$ICSViewCompatImpl();
      } else if(var0 >= 11) {
         IMPL = new ViewCompat$HCViewCompatImpl();
      } else if(var0 >= 9) {
         IMPL = new ViewCompat$GBViewCompatImpl();
      } else {
         IMPL = new ViewCompat$BaseViewCompatImpl();
      }
   }

   public static boolean canScrollHorizontally(View var0, int var1) {
      return IMPL.canScrollHorizontally(var0, var1);
   }

   public static boolean canScrollVertically(View var0, int var1) {
      return IMPL.canScrollVertically(var0, var1);
   }

   public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var0) {
      return IMPL.getAccessibilityNodeProvider(var0);
   }

   public static float getAlpha(View var0) {
      return IMPL.getAlpha(var0);
   }

   public static int getImportantForAccessibility(View var0) {
      return IMPL.getImportantForAccessibility(var0);
   }

   public static int getLabelFor(View var0) {
      return IMPL.getLabelFor(var0);
   }

   public static int getLayerType(View var0) {
      return IMPL.getLayerType(var0);
   }

   public static int getLayoutDirection(View var0) {
      return IMPL.getLayoutDirection(var0);
   }

   public static int getMeasuredHeightAndState(View var0) {
      return IMPL.getMeasuredHeightAndState(var0);
   }

   public static int getMeasuredState(View var0) {
      return IMPL.getMeasuredState(var0);
   }

   public static int getMeasuredWidthAndState(View var0) {
      return IMPL.getMeasuredWidthAndState(var0);
   }

   public static int getOverScrollMode(View var0) {
      return IMPL.getOverScrollMode(var0);
   }

   public static ViewParent getParentForAccessibility(View var0) {
      return IMPL.getParentForAccessibility(var0);
   }

   public static boolean hasTransientState(View var0) {
      return IMPL.hasTransientState(var0);
   }

   public static boolean isOpaque(View var0) {
      return IMPL.isOpaque(var0);
   }

   public static void onInitializeAccessibilityEvent(View var0, AccessibilityEvent var1) {
      IMPL.onInitializeAccessibilityEvent(var0, var1);
   }

   public static void onInitializeAccessibilityNodeInfo(View var0, AccessibilityNodeInfoCompat var1) {
      IMPL.onInitializeAccessibilityNodeInfo(var0, var1);
   }

   public static void onPopulateAccessibilityEvent(View var0, AccessibilityEvent var1) {
      IMPL.onPopulateAccessibilityEvent(var0, var1);
   }

   public static boolean performAccessibilityAction(View var0, int var1, Bundle var2) {
      return IMPL.performAccessibilityAction(var0, var1, var2);
   }

   public static void postInvalidateOnAnimation(View var0) {
      IMPL.postInvalidateOnAnimation(var0);
   }

   public static void postInvalidateOnAnimation(View var0, int var1, int var2, int var3, int var4) {
      IMPL.postInvalidateOnAnimation(var0, var1, var2, var3, var4);
   }

   public static void postOnAnimation(View var0, Runnable var1) {
      IMPL.postOnAnimation(var0, var1);
   }

   public static void postOnAnimationDelayed(View var0, Runnable var1, long var2) {
      IMPL.postOnAnimationDelayed(var0, var1, var2);
   }

   public static int resolveSizeAndState(int var0, int var1, int var2) {
      return IMPL.resolveSizeAndState(var0, var1, var2);
   }

   public static void setAccessibilityDelegate(View var0, AccessibilityDelegateCompat var1) {
      IMPL.setAccessibilityDelegate(var0, var1);
   }

   public static void setHasTransientState(View var0, boolean var1) {
      IMPL.setHasTransientState(var0, var1);
   }

   public static void setImportantForAccessibility(View var0, int var1) {
      IMPL.setImportantForAccessibility(var0, var1);
   }

   public static void setLabelFor(View var0, int var1) {
      IMPL.setLabelFor(var0, var1);
   }

   public static void setLayerPaint(View var0, Paint var1) {
      IMPL.setLayerPaint(var0, var1);
   }

   public static void setLayerType(View var0, int var1, Paint var2) {
      IMPL.setLayerType(var0, var1, var2);
   }

   public static void setLayoutDirection(View var0, int var1) {
      IMPL.setLayoutDirection(var0, var1);
   }

   public static void setOverScrollMode(View var0, int var1) {
      IMPL.setOverScrollMode(var0, var1);
   }

   public int getAccessibilityLiveRegion(View var1) {
      return IMPL.getAccessibilityLiveRegion(var1);
   }

   public void setAccessibilityLiveRegion(View var1, int var2) {
      IMPL.setAccessibilityLiveRegion(var1, var2);
   }
}
