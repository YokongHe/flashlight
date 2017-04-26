package android.support.v4.view;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat$HCViewCompatImpl;
import android.support.v4.view.ViewCompatICS;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ViewCompat$ICSViewCompatImpl extends ViewCompat$HCViewCompatImpl {
   public boolean canScrollHorizontally(View var1, int var2) {
      return ViewCompatICS.canScrollHorizontally(var1, var2);
   }

   public boolean canScrollVertically(View var1, int var2) {
      return ViewCompatICS.canScrollVertically(var1, var2);
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      ViewCompatICS.onInitializeAccessibilityEvent(var1, var2);
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      ViewCompatICS.onInitializeAccessibilityNodeInfo(var1, var2.getInfo());
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      ViewCompatICS.onPopulateAccessibilityEvent(var1, var2);
   }

   public void setAccessibilityDelegate(View var1, AccessibilityDelegateCompat var2) {
      ViewCompatICS.setAccessibilityDelegate(var1, var2.getBridge());
   }
}
