package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Cap;
import com.mopub.mobileads.resource.CircleDrawable;

public class CloseButtonDrawable extends CircleDrawable {
   private Point bottomLeftPoint;
   private Point bottomRightPoint;
   private Point centerPoint;
   private final Paint closeButtonPaint = new Paint(this.getPaint());
   private int mDisplacement;
   private Point topLeftPoint;
   private Point topRightPoint;

   public CloseButtonDrawable() {
      this.closeButtonPaint.setStrokeWidth(4.5F);
      this.closeButtonPaint.setStrokeCap(Cap.ROUND);
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      this.mDisplacement = (int)(0.5F * (float)this.getRadius() / (float)Math.sqrt(2.0D));
      this.centerPoint = new Point(this.getCenterX(), this.getCenterY());
      this.bottomLeftPoint = new Point(this.centerPoint);
      this.bottomLeftPoint.offset(-this.mDisplacement, this.mDisplacement);
      this.topLeftPoint = new Point(this.centerPoint);
      this.topLeftPoint.offset(-this.mDisplacement, -this.mDisplacement);
      this.topRightPoint = new Point(this.centerPoint);
      this.topRightPoint.offset(this.mDisplacement, -this.mDisplacement);
      this.bottomRightPoint = new Point(this.centerPoint);
      this.bottomRightPoint.offset(this.mDisplacement, this.mDisplacement);
      var1.drawLine((float)this.bottomLeftPoint.x, (float)this.bottomLeftPoint.y, (float)this.topRightPoint.x, (float)this.topRightPoint.y, this.closeButtonPaint);
      var1.drawLine((float)this.topLeftPoint.x, (float)this.topLeftPoint.y, (float)this.bottomRightPoint.x, (float)this.bottomRightPoint.y, this.closeButtonPaint);
   }
}
