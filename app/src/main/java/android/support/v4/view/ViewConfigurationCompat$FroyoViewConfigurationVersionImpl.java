package android.support.v4.view;

import android.support.v4.view.ViewConfigurationCompat$ViewConfigurationVersionImpl;
import android.support.v4.view.ViewConfigurationCompatFroyo;
import android.view.ViewConfiguration;

class ViewConfigurationCompat$FroyoViewConfigurationVersionImpl implements ViewConfigurationCompat$ViewConfigurationVersionImpl {
   public int getScaledPagingTouchSlop(ViewConfiguration var1) {
      return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(var1);
   }
}
