package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Cap;
import com.mopub.mobileads.resource.CircleDrawable;

public class LearnMoreDrawable extends CircleDrawable {
   private Point bottomLeftPoint;
   private Point centerPoint;
   private final Paint learnMorePaint = new Paint(this.getPaint());
   private Point leftBarbPoint;
   private int mBarbLength;
   private int mDisplacement;
   private Point rightBarbPoint;
   private Point topRightPoint;

   public LearnMoreDrawable() {
      this.learnMorePaint.setStrokeWidth(4.5F);
      this.learnMorePaint.setStrokeCap(Cap.ROUND);
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      this.mDisplacement = (int)((double)(0.5F * (float)this.getRadius()) / Math.sqrt(2.0D));
      this.mBarbLength = (int)(1.5F * (float)this.mDisplacement);
      this.centerPoint = new Point(this.getCenterX(), this.getCenterY());
      this.bottomLeftPoint = new Point(this.centerPoint);
      this.bottomLeftPoint.offset(-this.mDisplacement, this.mDisplacement);
      this.topRightPoint = new Point(this.centerPoint);
      this.topRightPoint.offset(this.mDisplacement, -this.mDisplacement);
      this.leftBarbPoint = new Point(this.topRightPoint);
      this.leftBarbPoint.offset(-this.mBarbLength, 0);
      this.rightBarbPoint = new Point(this.topRightPoint);
      this.rightBarbPoint.offset(0, this.mBarbLength);
      var1.drawLine((float)this.bottomLeftPoint.x, (float)this.bottomLeftPoint.y, (float)this.topRightPoint.x, (float)this.topRightPoint.y, this.learnMorePaint);
      var1.drawLine((float)this.topRightPoint.x, (float)this.topRightPoint.y, (float)this.leftBarbPoint.x, (float)this.leftBarbPoint.y, this.learnMorePaint);
      var1.drawLine((float)this.topRightPoint.x, (float)this.topRightPoint.y, (float)this.rightBarbPoint.x, (float)this.rightBarbPoint.y, this.learnMorePaint);
   }
}
