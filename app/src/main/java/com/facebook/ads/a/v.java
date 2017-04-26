package com.facebook.ads.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class v extends View {
   private Paint a = new Paint();
   private Paint b;
   private Paint c;

   public v(Context var1) {
      super(var1);
      this.a.setColor(-3355444);
      this.a.setStyle(Style.STROKE);
      this.a.setStrokeWidth(3.0F);
      this.a.setAntiAlias(true);
      this.b = new Paint();
      this.b.setColor(-1287371708);
      this.b.setStyle(Style.FILL);
      this.b.setAntiAlias(true);
      this.c = new Paint();
      this.c.setColor(-1);
      this.c.setStyle(Style.STROKE);
      this.c.setStrokeWidth(6.0F);
      this.c.setAntiAlias(true);
   }

   protected void onDraw(Canvas var1) {
      int var2 = Math.min(var1.getWidth(), var1.getHeight());
      int var3 = var2 / 2;
      int var4 = var3 * 2 / 3;
      var1.drawCircle((float)var3, (float)var3, (float)var4, this.a);
      var1.drawCircle((float)var3, (float)var3, (float)(var4 - 2), this.b);
      var2 /= 3;
      var1.drawLine((float)var2, (float)var2, (float)(var2 * 2), (float)(var2 * 2), this.c);
      var1.drawLine((float)(var2 * 2), (float)var2, (float)var2, (float)(var2 * 2), this.c);
      super.onDraw(var1);
   }
}
