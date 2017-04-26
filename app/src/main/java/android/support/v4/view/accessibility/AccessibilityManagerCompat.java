package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerStubImpl;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerVersionImpl;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public class AccessibilityManagerCompat {
   private static final AccessibilityManagerCompat$AccessibilityManagerVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityManagerCompat$AccessibilityManagerIcsImpl();
      } else {
         IMPL = new AccessibilityManagerCompat$AccessibilityManagerStubImpl();
      }
   }

   // $FF: synthetic method
   static AccessibilityManagerCompat$AccessibilityManagerVersionImpl access$000() {
      return IMPL;
   }

   public static boolean addAccessibilityStateChangeListener(AccessibilityManager var0, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var1) {
      return IMPL.addAccessibilityStateChangeListener(var0, var1);
   }

   public static List getEnabledAccessibilityServiceList(AccessibilityManager var0, int var1) {
      return IMPL.getEnabledAccessibilityServiceList(var0, var1);
   }

   public static List getInstalledAccessibilityServiceList(AccessibilityManager var0) {
      return IMPL.getInstalledAccessibilityServiceList(var0);
   }

   public static boolean isTouchExplorationEnabled(AccessibilityManager var0) {
      return IMPL.isTouchExplorationEnabled(var0);
   }

   public static boolean removeAccessibilityStateChangeListener(AccessibilityManager var0, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var1) {
      return IMPL.removeAccessibilityStateChangeListener(var0, var1);
   }
}
