package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gy$a;
import java.util.ArrayList;
import java.util.Iterator;

public final class gy extends RelativeLayout implements OnClickListener {
   private boolean a;
   private float b = 1.0F;
   private View c;
   private View d;
   private FrameLayout e;
   private ImageView f;
   private gn g;
   private gy$a h;

   public gy(Context var1, gn var2, gy$a var3) {
      super(var1);
      var1 = this.getContext();
      this.c = new View(var1);
      this.c.setId(1);
      LayoutParams var4 = new LayoutParams(0, 0);
      var4.addRule(13);
      this.addView(this.c, var4);
      this.d = new View(var1);
      var4 = new LayoutParams(0, 0);
      var4.addRule(13);
      this.addView(this.d, var4);
      this.e = new FrameLayout(var1);
      var4 = new LayoutParams(0, 0);
      var4.addRule(13);
      this.addView(this.e, var4);
      this.f = new ImageView(var1);
      this.f.setOnClickListener(this);
      LayoutParams var5 = new LayoutParams(0, 0);
      var5.addRule(7, this.c.getId());
      var5.addRule(6, this.c.getId());
      this.addView(this.f, var5);
      this.g = var2;
      this.h = var3;
      this.f.setImageBitmap(var2.c.a());
   }

   private int a(int var1) {
      return (int)((float)var1 * this.b);
   }

   public final void onClick(View var1) {
      if(var1 == this.f) {
         this.h.a();
      } else if(var1.getTag() instanceof gm) {
         this.h.a((gm)var1.getTag());
         return;
      }

   }

   protected final void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
   }

   protected final void onMeasure(int var1, int var2) {
      // $FF: Couldn't be decompiled
   }

   public final void setLandscape(boolean var1) {
      this.a = var1;
      ArrayList var2;
      Bitmap var3;
      Bitmap var4;
      if(var1) {
         var4 = this.g.b.a();
         var3 = this.g.f.a();
         var2 = this.g.j;
      } else {
         var4 = this.g.a.a();
         var3 = this.g.e.a();
         var2 = this.g.i;
      }

      com.tapjoy.internal.ah.a(this.c, new BitmapDrawable((Resources)null, var4));
      com.tapjoy.internal.ah.a(this.d, new BitmapDrawable((Resources)null, var3));
      if(this.e.getChildCount() > 0) {
         this.e.removeAllViews();
      }

      Context var7 = this.getContext();
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         gm var5 = (gm)var6.next();
         View var8 = new View(var7);
         var8.setTag(var5);
         var8.setOnClickListener(this);
         android.widget.FrameLayout.LayoutParams var9 = new android.widget.FrameLayout.LayoutParams(0, 0, 51);
         this.e.addView(var8, var9);
      }

   }
}
