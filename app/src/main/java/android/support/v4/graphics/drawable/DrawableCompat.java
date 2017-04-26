package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$DrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$KitKatDrawableImpl;

public class DrawableCompat {
   static final DrawableCompat$DrawableImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 19) {
         IMPL = new DrawableCompat$KitKatDrawableImpl();
      } else if(var0 >= 11) {
         IMPL = new DrawableCompat$HoneycombDrawableImpl();
      } else {
         IMPL = new DrawableCompat$BaseDrawableImpl();
      }
   }

   public static boolean isAutoMirrored(Drawable var0) {
      return IMPL.isAutoMirrored(var0);
   }

   public static void jumpToCurrentState(Drawable var0) {
      IMPL.jumpToCurrentState(var0);
   }

   public static void setAutoMirrored(Drawable var0, boolean var1) {
      IMPL.setAutoMirrored(var0, var1);
   }
}
