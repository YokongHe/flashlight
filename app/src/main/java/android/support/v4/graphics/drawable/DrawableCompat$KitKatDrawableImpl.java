package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatKitKat;

class DrawableCompat$KitKatDrawableImpl extends DrawableCompat$HoneycombDrawableImpl {
   public boolean isAutoMirrored(Drawable var1) {
      return DrawableCompatKitKat.isAutoMirrored(var1);
   }

   public void setAutoMirrored(Drawable var1, boolean var2) {
      DrawableCompatKitKat.setAutoMirrored(var1, var2);
   }
}
