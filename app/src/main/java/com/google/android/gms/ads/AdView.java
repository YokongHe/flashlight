package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public final class AdView extends ViewGroup {
   private final com.google.android.gms.internal.A a;

   public AdView(Context var1) {
      super(var1);
      this.a = new com.google.android.gms.internal.A(this);
   }

   public AdView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a = new com.google.android.gms.internal.A(this, var2, false);
   }

   public AdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a = new com.google.android.gms.internal.A(this, var2, false);
   }

   public final void a() {
      this.a.a();
   }

   public final void a(com.google.android.gms.ads.a var1) {
      this.a.a(var1);
   }

   public final void a(com.google.android.gms.ads.b var1) {
      this.a.a(var1.a());
   }

   public final void a(com.google.android.gms.ads.d var1) {
      this.a.a(new com.google.android.gms.ads.d[]{var1});
   }

   public final void a(String var1) {
      this.a.a(var1);
   }

   public final void b() {
      this.a.c();
   }

   public final void c() {
      this.a.d();
   }

   protected final void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      View var8 = this.getChildAt(0);
      if(var8 != null && var8.getVisibility() != 8) {
         int var6 = var8.getMeasuredWidth();
         int var7 = var8.getMeasuredHeight();
         var2 = (var4 - var2 - var6) / 2;
         var3 = (var5 - var3 - var7) / 2;
         var8.layout(var2, var3, var6 + var2, var7 + var3);
      }

   }

   protected final void onMeasure(int var1, int var2) {
      int var3 = 0;
      View var6 = this.getChildAt(0);
      com.google.android.gms.ads.d var5 = this.a.b();
      int var4;
      if(var6 != null && var6.getVisibility() != 8) {
         this.measureChild(var6, var1, var2);
         var4 = var6.getMeasuredWidth();
         var3 = var6.getMeasuredHeight();
      } else if(var5 != null) {
         Context var7 = this.getContext();
         var4 = var5.b(var7);
         var3 = var5.a(var7);
      } else {
         var4 = 0;
      }

      var4 = Math.max(var4, this.getSuggestedMinimumWidth());
      var3 = Math.max(var3, this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(View.resolveSize(var4, var1), View.resolveSize(var3, var2));
   }
}
