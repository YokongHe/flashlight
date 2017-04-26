package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl {
   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object var1, View var2) {
      var1 = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(var1, var2);
      return var1 != null?new AccessibilityNodeProviderCompat(var1):null;
   }

   public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat var1) {
      return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean() {
         public boolean dispatchPopulateAccessibilityEvent(View var1x, AccessibilityEvent var2) {
            return var1.dispatchPopulateAccessibilityEvent(var1x, var2);
         }

         public Object getAccessibilityNodeProvider(View var1x) {
            AccessibilityNodeProviderCompat var2 = var1.getAccessibilityNodeProvider(var1x);
            return var2 != null?var2.getProvider():null;
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

         public boolean performAccessibilityAction(View var1x, int var2, Bundle var3) {
            return var1.performAccessibilityAction(var1x, var2, var3);
         }

         public void sendAccessibilityEvent(View var1x, int var2) {
            var1.sendAccessibilityEvent(var1x, var2);
         }

         public void sendAccessibilityEventUnchecked(View var1x, AccessibilityEvent var2) {
            var1.sendAccessibilityEventUnchecked(var1x, var2);
         }
      });
   }

   public boolean performAccessibilityAction(Object var1, View var2, int var3, Bundle var4) {
      return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(var1, var2, var3, var4);
   }
}
