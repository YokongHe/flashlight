package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatHoneycomb;

class DrawableCompat$HoneycombDrawableImpl extends DrawableCompat$BaseDrawableImpl {
   public void jumpToCurrentState(Drawable var1) {
      DrawableCompatHoneycomb.jumpToCurrentState(var1);
   }
}
