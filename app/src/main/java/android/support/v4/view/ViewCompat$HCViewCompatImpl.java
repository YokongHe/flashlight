package android.support.v4.view;

import android.graphics.Paint;
import android.support.v4.view.ViewCompat$GBViewCompatImpl;
import android.support.v4.view.ViewCompatHC;
import android.view.View;

class ViewCompat$HCViewCompatImpl extends ViewCompat$GBViewCompatImpl {
   public float getAlpha(View var1) {
      return ViewCompatHC.getAlpha(var1);
   }

   long getFrameTime() {
      return ViewCompatHC.getFrameTime();
   }

   public int getLayerType(View var1) {
      return ViewCompatHC.getLayerType(var1);
   }

   public int getMeasuredHeightAndState(View var1) {
      return ViewCompatHC.getMeasuredHeightAndState(var1);
   }

   public int getMeasuredState(View var1) {
      return ViewCompatHC.getMeasuredState(var1);
   }

   public int getMeasuredWidthAndState(View var1) {
      return ViewCompatHC.getMeasuredWidthAndState(var1);
   }

   public int resolveSizeAndState(int var1, int var2, int var3) {
      return ViewCompatHC.resolveSizeAndState(var1, var2, var3);
   }

   public void setLayerPaint(View var1, Paint var2) {
      this.setLayerType(var1, this.getLayerType(var1), var2);
      var1.invalidate();
   }

   public void setLayerType(View var1, int var2, Paint var3) {
      ViewCompatHC.setLayerType(var1, var2, var3);
   }
}
