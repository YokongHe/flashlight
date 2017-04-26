package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

interface AccessibilityManagerCompat$AccessibilityManagerVersionImpl {
   boolean addAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var2);

   List getEnabledAccessibilityServiceList(AccessibilityManager var1, int var2);

   List getInstalledAccessibilityServiceList(AccessibilityManager var1);

   boolean isTouchExplorationEnabled(AccessibilityManager var1);

   Object newAccessiblityStateChangeListener(AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var1);

   boolean removeAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var2);
}
