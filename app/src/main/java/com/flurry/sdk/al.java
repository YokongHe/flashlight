package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.TextView;
import com.flurry.sdk.fc;

public class al {
   private static int a;
   private static int b;
   private Path c = null;
   private PathShape d = null;
   private ShapeDrawable e = null;
   private TextView f = null;
   private int g = 0;
   private float h = 0.0F;
   private RectF i = null;
   private final float j = -90.0F;

   public al() {
      a = 3;
      b = 1;
   }

   public al(Context var1, int var2, int var3) {
      a = fc.b(2);
      b = fc.b(1);
      this.g = this.a(var2, var3);
      this.a(var1);
   }

   private int a(int var1, int var2) {
      return var1 < var2?var1 / 2:var2 / 2;
   }

   private void a(Context var1) {
      this.f = new TextView(var1);
      this.f.setTextColor(-1);
      this.f.setTypeface(Typeface.MONOSPACE);
      this.f.setTextSize(1, 12.0F);
      this.f.setGravity(17);
   }

   @SuppressLint({"NewApi"})
   private void c(int var1) {
      Drawable var2 = this.b(var1);
      if(VERSION.SDK_INT >= 16) {
         this.f.setBackground(var2);
      } else {
         this.f.setBackgroundDrawable(var2);
      }
   }

   private void d(int var1) {
      this.c(var1);
   }

   private void e(int var1) {
      this.f.setText(Integer.toString(var1));
   }

   public View a() {
      return this.f;
   }

   public void a(int var1) {
      this.h = 360.0F / (float)(var1 / 1000);
      this.c(var1);
   }

   public void a(int var1, boolean var2) {
      if(this.f != null) {
         this.c(var1);
         this.e(var1);
      }

   }

   public Drawable b(int var1) {
      this.i = new RectF();
      this.i.set((float)a, (float)a, (float)(this.g - a), (float)(this.g - a));
      this.c = new Path();
      this.c.arcTo(this.i, -90.0F, (float)(-var1) * this.h + 1.0F, false);
      this.d = new PathShape(this.c, (float)this.g, (float)this.g);
      this.e = new ShapeDrawable(this.d);
      this.e.setIntrinsicHeight(this.g * 2);
      this.e.setIntrinsicWidth(this.g * 2);
      this.e.getPaint().setStyle(Style.STROKE);
      this.e.getPaint().setColor(-1);
      this.e.getPaint().setStrokeWidth((float)b);
      this.e.getPaint().setAntiAlias(true);
      GradientDrawable var2 = new GradientDrawable();
      var2.setColor(-16777216);
      var2.setShape(1);
      var2.setAlpha(178);
      return new LayerDrawable(new Drawable[]{var2, this.e});
   }
}
