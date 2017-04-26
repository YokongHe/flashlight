package com.millennialmedia.android;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;

class AdViewOverlayView$CloseDrawable extends Drawable {
   protected boolean enabled = true;
   protected final Paint paint;

   AdViewOverlayView$CloseDrawable(boolean var1) {
      this.enabled = var1;
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.paint.setStyle(Style.STROKE);
   }

   public void draw(Canvas var1) {
      Rect var6 = this.copyBounds();
      int var4 = var6.right - var6.left;
      int var5 = var6.bottom - var6.top;
      float var2 = (float)var4 / 6.0F;
      this.paint.setStrokeWidth(var2);
      short var3;
      if(this.enabled) {
         var3 = 255;
      } else {
         var3 = 80;
      }

      this.paint.setARGB(255, var3, var3, var3);
      var1.drawLine(var2 / 2.0F, var2 / 2.0F, (float)var4 - var2 / 2.0F, (float)var5 - var2 / 2.0F, this.paint);
      var1.drawLine((float)var4 - var2 / 2.0F, var2 / 2.0F, var2 / 2.0F, (float)var5 - var2 / 2.0F, this.paint);
   }

   public int getOpacity() {
      return -3;
   }

   public void setAlpha(int var1) {
   }

   public void setColorFilter(ColorFilter var1) {
   }
}
