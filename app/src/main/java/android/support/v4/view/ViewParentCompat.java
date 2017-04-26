package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewParentCompat$ViewParentCompatICSImpl;
import android.support.v4.view.ViewParentCompat$ViewParentCompatImpl;
import android.support.v4.view.ViewParentCompat$ViewParentCompatStubImpl;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewParentCompat {
   static final ViewParentCompat$ViewParentCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new ViewParentCompat$ViewParentCompatICSImpl();
      } else {
         IMPL = new ViewParentCompat$ViewParentCompatStubImpl();
      }
   }

   public static boolean requestSendAccessibilityEvent(ViewParent var0, View var1, AccessibilityEvent var2) {
      return IMPL.requestSendAccessibilityEvent(var0, var1, var2);
   }
}
