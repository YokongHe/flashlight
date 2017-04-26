package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;

public class ao extends com.tapjoy.internal.ap {
   private int a = 0;
   private final Matrix b = new Matrix();
   private final float[] c = new float[2];

   public ao(Context var1) {
      super(var1);
   }

   protected void dispatchDraw(Canvas param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean dispatchTouchEvent(MotionEvent var1) {
      if(this.a == 0) {
         return super.dispatchTouchEvent(var1);
      } else {
         float[] var2 = this.c;
         var2[0] = var1.getX();
         var2[1] = var1.getY();
         this.b.mapPoints(var2);
         var1.setLocation(var2[0], var2[1]);
         return super.dispatchTouchEvent(var1);
      }
   }

   public int getRotationCount() {
      return this.a;
   }

   public void onMeasure(int var1, int var2) {
      if(this.a % 2 == 0) {
         super.onMeasure(var1, var2);
      } else {
         super.onMeasure(var2, var1);
         this.setMeasuredDimension(this.getMeasuredHeight(), this.getMeasuredWidth());
      }
   }

   public void setRotationCount(int var1) {
      this.a = var1 & 3;
   }
}
