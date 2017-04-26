package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class AccessibilityNodeProviderCompatKitKat {
   public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge var0) {
      return new AccessibilityNodeProvider() {
         public final AccessibilityNodeInfo createAccessibilityNodeInfo(int var1) {
            return (AccessibilityNodeInfo)var0.createAccessibilityNodeInfo(var1);
         }

         public final List findAccessibilityNodeInfosByText(String var1, int var2) {
            return var0.findAccessibilityNodeInfosByText(var1, var2);
         }

         public final AccessibilityNodeInfo findFocus(int var1) {
            return (AccessibilityNodeInfo)var0.findFocus(var1);
         }

         public final boolean performAction(int var1, int var2, Bundle var3) {
            return var0.performAction(var1, var2, var3);
         }
      };
   }
}
