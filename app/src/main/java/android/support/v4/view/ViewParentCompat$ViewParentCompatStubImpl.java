package android.support.v4.view;

import android.support.v4.view.ViewParentCompat$ViewParentCompatImpl;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

class ViewParentCompat$ViewParentCompatStubImpl implements ViewParentCompat$ViewParentCompatImpl {
   public boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3) {
      if(var2 == null) {
         return false;
      } else {
         ((AccessibilityManager)var2.getContext().getSystemService("accessibility")).sendAccessibilityEvent(var3);
         return true;
      }
   }
}
