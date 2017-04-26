package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewConfigurationCompat$BaseViewConfigurationVersionImpl;
import android.support.v4.view.ViewConfigurationCompat$FroyoViewConfigurationVersionImpl;
import android.support.v4.view.ViewConfigurationCompat$ViewConfigurationVersionImpl;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat {
   static final ViewConfigurationCompat$ViewConfigurationVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new ViewConfigurationCompat$FroyoViewConfigurationVersionImpl();
      } else {
         IMPL = new ViewConfigurationCompat$BaseViewConfigurationVersionImpl();
      }
   }

   public static int getScaledPagingTouchSlop(ViewConfiguration var0) {
      return IMPL.getScaledPagingTouchSlop(var0);
   }
}
