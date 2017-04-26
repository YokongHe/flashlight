package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.CircleDrawable;
import com.mopub.mobileads.resource.TextDrawable;

public class CountdownDrawable extends CircleDrawable implements TextDrawable {
   private static final float TEXT_SIZE_SP = 18.0F;
   private String mSecondsRemaining = "";
   private final Paint mTextPaint = new Paint();
   private Rect mTextRect;
   private final float textSizePixels;

   public CountdownDrawable(Context var1) {
      this.textSizePixels = Dips.dipsToFloatPixels(18.0F, var1);
      this.mTextPaint.setTextSize(this.textSizePixels);
      this.mTextPaint.setAntiAlias(true);
      this.mTextPaint.setColor(-1);
      this.mTextPaint.setStyle(Style.FILL);
      this.mTextPaint.setTextAlign(Align.LEFT);
      this.mTextRect = new Rect();
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      String var6 = String.valueOf(this.mSecondsRemaining);
      this.mTextPaint.getTextBounds(var6, 0, var6.length(), this.mTextRect);
      int var2 = this.getCenterX();
      int var3 = this.mTextRect.width() / 2;
      int var4 = this.getCenterY();
      int var5 = this.mTextRect.height() / 2;
      var1.drawText(var6, (float)(var2 - var3), (float)(var4 + var5), this.mTextPaint);
   }

   public void updateText(String var1) {
      if(!this.mSecondsRemaining.equals(var1)) {
         this.mSecondsRemaining = var1;
         this.invalidateSelf();
      }

   }
}
