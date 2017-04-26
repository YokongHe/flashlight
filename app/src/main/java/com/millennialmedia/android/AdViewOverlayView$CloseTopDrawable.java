package com.millennialmedia.android;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import com.millennialmedia.android.AdViewOverlayView$CloseDrawable;

class AdViewOverlayView$CloseTopDrawable extends AdViewOverlayView$CloseDrawable {
   final float dist;
   final float scale;

   AdViewOverlayView$CloseTopDrawable(boolean var1, float var2) {
      super(var1);
      this.scale = var2;
      this.dist = 4.0F * var2;
      this.paint.setColor(-16777216);
   }

   public void draw(Canvas var1) {
      Rect var5 = this.copyBounds();
      float var2 = (float)(var5.right - var5.left) / 10.0F;
      float var3 = (float)var5.right - this.scale * 20.0F;
      float var4 = (float)var5.top + this.scale * 20.0F;
      this.paint.setStrokeWidth(var2);
      this.paint.setColor(-16777216);
      this.paint.setStyle(Style.STROKE);
      var1.drawCircle(var3, var4, 12.0F * this.scale, this.paint);
      this.paint.setColor(-1);
      this.paint.setStyle(Style.FILL_AND_STROKE);
      var1.drawCircle(var3, var4, this.scale * 10.0F, this.paint);
      this.paint.setColor(-16777216);
      var1.drawCircle(var3, var4, 7.0F * this.scale, this.paint);
      this.paint.setColor(-1);
      this.paint.setStrokeWidth(var2 / 2.0F);
      this.paint.setStyle(Style.STROKE);
      var1.drawLine(var3 - this.dist, var4 - this.dist, var3 + this.dist, var4 + this.dist, this.paint);
      var1.drawLine(var3 + this.dist, var4 - this.dist, var3 - this.dist, var4 + this.dist, this.paint);
   }
}
