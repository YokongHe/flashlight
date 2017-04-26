package com.inmobi.re.container;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.view.View;
import com.inmobi.re.container.CustomView$SwitchIconType;

public class CustomView extends View {
   private float a;
   private float b;
   private float c;
   private float d;
   private float e;
   private CustomView$SwitchIconType f;
   private int g;
   private Paint h;
   private Path i;
   private RectF j;

   private CustomView(Context var1) {
      super(var1);
   }

   public CustomView(Context var1, float var2, CustomView$SwitchIconType var3) {
      this(var1);
      this.f = var3;
      this.a = var2;
      this.g = 15;
      this.b = 50.0F * this.a / 2.0F;
      this.c = 30.0F * this.a / 2.0F;
      this.d = this.b - this.c / 3.0F;
      this.e = this.b + this.c / 3.0F;
      this.h = new Paint(1);
      this.j = new RectF();
      this.i = new Path();
   }

   public void disableView(boolean var1) {
      if(var1) {
         this.setClickable(false);
         this.setEnabled(false);
      } else {
         this.setClickable(true);
         this.setEnabled(true);
      }
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      this.h.reset();
      switch(null.a[this.f.ordinal()]) {
      case 1:
         this.h.setAntiAlias(true);
         this.h.setColor(-16777216);
         this.h.setStrokeWidth(3.0F);
         this.h.setStyle(Style.FILL_AND_STROKE);
         var1.drawCircle(this.b, this.b, this.c, this.h);
         this.h.setColor(-1);
         this.h.setStyle(Style.STROKE);
         var1.drawLine(this.d, this.d, this.e, this.e, this.h);
         var1.drawLine(this.d, this.e, this.e, this.d, this.h);
         var1.drawCircle(this.b, this.b, this.c, this.h);
         return;
      case 2:
         this.h.setAntiAlias(true);
         this.h.setColor(0);
         this.h.setStrokeWidth(3.0F);
         this.h.setStyle(Style.FILL_AND_STROKE);
         var1.drawCircle(this.b, this.b, this.b, this.h);
         return;
      case 3:
         this.i.reset();
         this.i.setFillType(FillType.EVEN_ODD);
         this.i.moveTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - (float)this.g * this.a / 2.0F);
         this.i.lineTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2));
         this.i.lineTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) + (float)this.g * this.a / 2.0F);
         this.i.lineTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - (float)this.g * this.a / 2.0F);
         this.i.close();
         this.h.setAntiAlias(true);
         this.h.setColor(-16777216);
         this.h.setStrokeWidth(3.0F);
         this.h.setStyle(Style.FILL_AND_STROKE);
         var1.drawPath(this.i, this.h);
         return;
      case 4:
         this.i.reset();
         this.i.setFillType(FillType.EVEN_ODD);
         this.i.moveTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - (float)this.g * this.a / 2.0F);
         this.i.lineTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2));
         this.i.lineTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) + (float)this.g * this.a / 2.0F);
         this.i.lineTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - (float)this.g * this.a / 2.0F);
         this.i.close();
         this.h.setAntiAlias(true);
         this.h.setColor(-12303292);
         this.h.setStrokeWidth(3.0F);
         this.h.setStyle(Style.FILL_AND_STROKE);
         var1.drawPath(this.i, this.h);
         return;
      case 5:
         this.i.reset();
         this.i.setFillType(FillType.EVEN_ODD);
         this.i.moveTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2));
         this.i.lineTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - (float)this.g * this.a / 2.0F);
         this.i.lineTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) + (float)this.g * this.a / 2.0F);
         this.i.lineTo((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2));
         this.i.close();
         this.h.setAntiAlias(true);
         this.h.setColor(-16777216);
         this.h.setStrokeWidth(3.0F);
         this.h.setStyle(Style.FILL_AND_STROKE);
         var1.drawPath(this.i, this.h);
         return;
      case 6:
         this.i.reset();
         this.h.setAntiAlias(true);
         this.h.setColor(-16777216);
         this.h.setStrokeWidth(5.0F);
         this.h.setStyle(Style.STROKE);
         this.j.set((float)(this.getWidth() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - (float)this.g * this.a / 2.0F, (float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) + (float)this.g * this.a / 2.0F);
         var1.drawArc(this.j, 0.0F, 270.0F, false, this.h);
         this.i.setFillType(FillType.EVEN_ODD);
         this.i.moveTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - this.a * 2.0F);
         this.i.lineTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F - this.a * 2.0F, (float)(this.getHeight() / 2));
         this.i.lineTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F + this.a * 2.0F, (float)(this.getHeight() / 2));
         this.i.lineTo((float)(this.getWidth() / 2) + (float)this.g * this.a / 2.0F, (float)(this.getHeight() / 2) - this.a * 2.0F);
         this.i.close();
         this.h.setStyle(Style.FILL_AND_STROKE);
         var1.drawPath(this.i, this.h);
         return;
      case 7:
         this.h.setAntiAlias(true);
         this.h.setColor(-16777216);
         this.h.setStrokeWidth(5.0F);
         this.h.setStyle(Style.STROKE);
         float var2 = (float)(this.getWidth() / 2);
         float var3 = (float)this.g * this.a / 2.0F;
         float var4 = (float)(this.getHeight() / 2);
         float var5 = (float)this.g * this.a / 2.0F;
         float var6 = (float)(this.getWidth() / 2);
         float var7 = (float)this.g * this.a / 2.0F;
         float var8 = (float)(this.getHeight() / 2);
         var1.drawLine(var2 - var3, var4 - var5, var7 + var6, (float)this.g * this.a / 2.0F + var8, this.h);
         var2 = (float)(this.getWidth() / 2);
         var3 = (float)this.g * this.a / 2.0F;
         var4 = (float)(this.getHeight() / 2);
         var5 = (float)this.g * this.a / 2.0F;
         var6 = (float)(this.getWidth() / 2);
         var1.drawLine(var2 - var3, var5 + var4, (float)this.g * this.a / 2.0F + var6, (float)(this.getHeight() / 2) - (float)this.g * this.a / 2.0F, this.h);
         return;
      default:
      }
   }

   public void setSwitchInt(CustomView$SwitchIconType var1) {
      this.f = var1;
   }
}
