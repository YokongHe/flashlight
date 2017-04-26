package android.support.v4.view;

import android.support.v4.view.ViewCompat$JbMr1ViewCompatImpl;
import android.support.v4.view.ViewCompatKitKat;
import android.view.View;

class ViewCompat$KitKatViewCompatImpl extends ViewCompat$JbMr1ViewCompatImpl {
   public int getAccessibilityLiveRegion(View var1) {
      return ViewCompatKitKat.getAccessibilityLiveRegion(var1);
   }

   public void setAccessibilityLiveRegion(View var1, int var2) {
      ViewCompatKitKat.setAccessibilityLiveRegion(var1, var2);
   }
}
