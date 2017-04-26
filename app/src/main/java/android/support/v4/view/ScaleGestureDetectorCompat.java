package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl;
import android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl;
import android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorImpl;

public class ScaleGestureDetectorCompat {
   static final ScaleGestureDetectorCompat$ScaleGestureDetectorImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl(null);
      } else {
         IMPL = new ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl(null);
      }
   }

   public static boolean isQuickScaleEnabled(Object var0) {
      return IMPL.isQuickScaleEnabled(var0);
   }

   public static void setQuickScaleEnabled(Object var0, boolean var1) {
      IMPL.setQuickScaleEnabled(var0, var1);
   }
}
