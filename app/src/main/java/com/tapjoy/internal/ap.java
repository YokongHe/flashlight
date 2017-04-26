package com.tapjoy.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ap extends ViewGroup {
   public ap(Context var1) {
      super(var1);
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return new LayoutParams(this.getContext(), var1);
   }

   protected LayoutParams generateLayoutParams(LayoutParams var1) {
      return new LayoutParams(var1);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var3 = this.getPaddingLeft();
      var4 = this.getPaddingTop();
      var5 = this.getChildCount();

      for(var2 = 0; var2 < var5; ++var2) {
         View var6 = this.getChildAt(var2);
         if(var6.getVisibility() != 8) {
            var6.layout(var3, var4, var6.getMeasuredWidth() + var3, var6.getMeasuredHeight() + var4);
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      int var4 = 0;
      int var8 = this.getChildCount();
      this.measureChildren(var1, var2);
      int var5 = 0;

      int var3;
      int var6;
      for(var3 = 0; var5 < var8; var3 = var6) {
         View var9 = this.getChildAt(var5);
         int var7 = var4;
         var6 = var3;
         if(var9.getVisibility() != 8) {
            var7 = Math.max(var4, var9.getMeasuredWidth());
            var6 = Math.max(var3, var9.getMeasuredHeight());
         }

         ++var5;
         var4 = var7;
      }

      var5 = this.getPaddingLeft();
      var6 = this.getPaddingRight();
      var3 = Math.max(var3 + this.getPaddingTop() + this.getPaddingBottom(), this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(resolveSize(Math.max(var4 + var5 + var6, this.getSuggestedMinimumWidth()), var1), resolveSize(var3, var2));
   }
}
