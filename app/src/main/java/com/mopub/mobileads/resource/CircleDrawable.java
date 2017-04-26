package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;

public abstract class CircleDrawable extends Drawable {
   private final Paint mPaint = new Paint();

   public CircleDrawable() {
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStrokeWidth(3.0F);
      this.mPaint.setColor(-1);
      this.mPaint.setStyle(Style.STROKE);
   }

   public void draw(Canvas var1) {
      var1.drawCircle((float)this.getCenterX(), (float)this.getCenterY(), (float)this.getRadius(), this.mPaint);
   }

   protected int getCenterX() {
      return this.getBounds().width() / 2;
   }

   protected int getCenterY() {
      return this.getBounds().height() / 2;
   }

   public int getOpacity() {
      return 0;
   }

   protected Paint getPaint() {
      return this.mPaint;
   }

   protected int getRadius() {
      return Math.min(this.getCenterX(), this.getCenterY());
   }

   public void setAlpha(int var1) {
   }

   public void setColorFilter(ColorFilter var1) {
   }
}
