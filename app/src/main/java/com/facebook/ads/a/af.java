package com.facebook.ads.a;

import android.content.Context;
import android.widget.RelativeLayout;

public class af extends RelativeLayout {
   private int a = 0;
   private int b = 0;

   public af(Context var1) {
      super(var1);
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.b > 0 && this.getMeasuredWidth() > this.b) {
         this.setMeasuredDimension(this.b, this.getMeasuredHeight());
      } else if(this.getMeasuredWidth() < this.a) {
         this.setMeasuredDimension(this.a, this.getMeasuredHeight());
         return;
      }

   }

   protected void setMaxWidth(int var1) {
      this.b = var1;
   }

   public void setMinWidth(int var1) {
      this.a = var1;
   }
}
