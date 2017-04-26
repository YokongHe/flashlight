package com.google.android.gms.plus;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class c extends FrameLayout {
   public c(Context var1, int var2) {
      byte var5 = 24;
      super(var1);
      Button var7 = new Button(var1);
      var7.setEnabled(false);
      com.google.android.gms.plus.e var6 = new com.google.android.gms.plus.e(this.getContext(), (byte)0);
      Object var8 = var6;
      if(!var6.a()) {
         var8 = new com.google.android.gms.plus.f(this.getContext(), (byte)0);
      }

      Object var11 = var8;
      if(!((com.google.android.gms.plus.g)var8).a()) {
         var11 = new com.google.android.gms.plus.d(this.getContext(), (byte)0);
      }

      var7.setBackgroundDrawable(((com.google.android.gms.plus.g)var11).a(var2));
      Point var9 = new Point();
      byte var10;
      switch(var2) {
      case 0:
         var10 = 14;
         break;
      case 1:
         var5 = 32;
         var10 = 20;
         break;
      case 2:
         var5 = 50;
         var10 = 20;
         break;
      default:
         var5 = 38;
         var10 = 24;
      }

      DisplayMetrics var12 = this.getResources().getDisplayMetrics();
      float var3 = TypedValue.applyDimension(1, (float)var5, var12);
      float var4 = TypedValue.applyDimension(1, (float)var10, var12);
      var9.x = (int)((double)var3 + 0.5D);
      var9.y = (int)((double)var4 + 0.5D);
      this.addView(var7, new LayoutParams(var9.x, var9.y, 17));
   }
}
