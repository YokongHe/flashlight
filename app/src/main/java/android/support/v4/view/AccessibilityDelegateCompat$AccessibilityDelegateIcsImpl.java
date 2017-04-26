package android.support.v4.view;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateStubImpl;
import android.support.v4.view.AccessibilityDelegateCompatIcs;
import android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl extends AccessibilityDelegateCompat$AccessibilityDelegateStubImpl {
   public boolean dispatchPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(var1, var2, var3);
   }

   public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat var1) {
      return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge() {
         public boolean dispatchPopulateAccessibilityEvent(View var1x, AccessibilityEvent var2) {
            return var1.dispatchPopulateAccessibilityEvent(var1x, var2);
         }

         public void onInitializeAccessibilityEvent(View var1x, AccessibilityEvent var2) {
            var1.onInitializeAccessibilityEvent(var1x, var2);
         }

         public void onInitializeAccessibilityNodeInfo(View var1x, Object var2) {
            var1.onInitializeAccessibilityNodeInfo(var1x, new AccessibilityNodeInfoCompat(var2));
         }

         public void onPopulateAccessibilityEvent(View var1x, AccessibilityEvent var2) {
            var1.onPopulateAccessibilityEvent(var1x, var2);
         }

         public boolean onRequestSendAccessibilityEvent(ViewGroup var1x, View var2, AccessibilityEvent var3) {
            return var1.onRequestSendAccessibilityEvent(var1x, var2, var3);
         }

         public void sendAccessibilityEvent(View var1x, int var2) {
            var1.sendAccessibilityEvent(var1x, var2);
         }

         public void sendAccessibilityEventUnchecked(View var1x, AccessibilityEvent var2) {
            var1.sendAccessibilityEventUnchecked(var1x, var2);
         }
      });
   }

   public Object newAccessiblityDelegateDefaultImpl() {
      return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
   }

   public void onInitializeAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(var1, var2, var3);
   }

   public void onInitializeAccessibilityNodeInfo(Object var1, View var2, AccessibilityNodeInfoCompat var3) {
      AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(var1, var2, var3.getInfo());
   }

   public void onPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(var1, var2, var3);
   }

   public boolean onRequestSendAccessibilityEvent(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4) {
      return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(var1, var2, var3, var4);
   }

   public void sendAccessibilityEvent(Object var1, View var2, int var3) {
      AccessibilityDelegateCompatIcs.sendAccessibilityEvent(var1, var2, var3);
   }

   public void sendAccessibilityEventUnchecked(Object var1, View var2, AccessibilityEvent var3) {
      AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(var1, var2, var3);
   }
}
