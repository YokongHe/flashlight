package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class AccessibilityDelegateCompatJellyBean {
   public static Object getAccessibilityNodeProvider(Object var0, View var1) {
      return ((AccessibilityDelegate)var0).getAccessibilityNodeProvider(var1);
   }

   public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean var0) {
      return new AccessibilityDelegate() {
         public final boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
            return var0.dispatchPopulateAccessibilityEvent(var1, var2);
         }

         public final AccessibilityNodeProvider getAccessibilityNodeProvider(View var1) {
            return (AccessibilityNodeProvider)var0.getAccessibilityNodeProvider(var1);
         }

         public final void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
            var0.onInitializeAccessibilityEvent(var1, var2);
         }

         public final void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
            var0.onInitializeAccessibilityNodeInfo(var1, var2);
         }

         public final void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
            var0.onPopulateAccessibilityEvent(var1, var2);
         }

         public final boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
            return var0.onRequestSendAccessibilityEvent(var1, var2, var3);
         }

         public final boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
            return var0.performAccessibilityAction(var1, var2, var3);
         }

         public final void sendAccessibilityEvent(View var1, int var2) {
            var0.sendAccessibilityEvent(var1, var2);
         }

         public final void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
            var0.sendAccessibilityEventUnchecked(var1, var2);
         }
      };
   }

   public static boolean performAccessibilityAction(Object var0, View var1, int var2, Bundle var3) {
      return ((AccessibilityDelegate)var0).performAccessibilityAction(var1, var2, var3);
   }
}
