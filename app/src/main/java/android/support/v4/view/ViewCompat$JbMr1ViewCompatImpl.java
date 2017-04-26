package android.support.v4.view;

import android.graphics.Paint;
import android.support.v4.view.ViewCompat$JBViewCompatImpl;
import android.support.v4.view.ViewCompatJellybeanMr1;
import android.view.View;

class ViewCompat$JbMr1ViewCompatImpl extends ViewCompat$JBViewCompatImpl {
   public int getLabelFor(View var1) {
      return ViewCompatJellybeanMr1.getLabelFor(var1);
   }

   public int getLayoutDirection(View var1) {
      return ViewCompatJellybeanMr1.getLayoutDirection(var1);
   }

   public void setLabelFor(View var1, int var2) {
      ViewCompatJellybeanMr1.setLabelFor(var1, var2);
   }

   public void setLayerPaint(View var1, Paint var2) {
      ViewCompatJellybeanMr1.setLayerPaint(var1, var2);
   }

   public void setLayoutDirection(View var1, int var2) {
      ViewCompatJellybeanMr1.setLayoutDirection(var1, var2);
   }
}
