package com.adsdk.sdk.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class AspectRatioImageViewWidth extends ImageView {
   public AspectRatioImageViewWidth(Context var1) {
      super(var1);
   }

   public AspectRatioImageViewWidth(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public AspectRatioImageViewWidth(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(MeasureSpec.getSize(var1), MeasureSpec.getSize(var2));
   }
}
