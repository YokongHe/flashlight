package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl {
   public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat var1) {
      return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge() {
         public Object createAccessibilityNodeInfo(int var1x) {
            AccessibilityNodeInfoCompat var2 = var1.createAccessibilityNodeInfo(var1x);
            return var2 == null?null:var2.getInfo();
         }

         public List findAccessibilityNodeInfosByText(String var1x, int var2) {
            List var5 = var1.findAccessibilityNodeInfosByText(var1x, var2);
            ArrayList var4 = new ArrayList();
            int var3 = var5.size();

            for(var2 = 0; var2 < var3; ++var2) {
               var4.add(((AccessibilityNodeInfoCompat)var5.get(var2)).getInfo());
            }

            return var4;
         }

         public Object findFocus(int var1x) {
            AccessibilityNodeInfoCompat var2 = var1.findFocus(var1x);
            return var2 == null?null:var2.getInfo();
         }

         public boolean performAction(int var1x, int var2, Bundle var3) {
            return var1.performAction(var1x, var2, var3);
         }
      });
   }
}
