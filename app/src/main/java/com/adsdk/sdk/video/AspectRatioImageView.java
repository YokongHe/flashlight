package com.adsdk.sdk.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class AspectRatioImageView extends ImageView {
   private boolean mFill = false;
   private int mMaxH = -1;
   private int mMinW = -1;

   public AspectRatioImageView(Context var1) {
      super(var1);
   }

   public AspectRatioImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public AspectRatioImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public static float dip2pixel(int var0, Context var1) {
      Resources var2 = var1.getResources();
      return TypedValue.applyDimension(1, (float)var0, var2.getDisplayMetrics());
   }

   void ensureConstraintMetAndSet(int var1, int var2, int var3, int var4) {
      boolean var6;
      if(var3 < var4) {
         var6 = true;
      } else {
         var6 = false;
      }

      float var5;
      int var7;
      int var8;
      if(var6) {
         var7 = var1;
         var8 = var2;
         if(this.mMinW > 0) {
            var5 = dip2pixel(this.mMinW, this.getContext());
            var7 = var1;
            var8 = var2;
            if((float)var1 < var5) {
               var7 = (int)var5;
               var8 = var4 / var3 * var7;
            }
         }

         var1 = var7;
         var2 = var8;
         if(this.mMaxH > 0) {
            var5 = dip2pixel(this.mMaxH, this.getContext());
            var1 = var7;
            var2 = var8;
            if((float)var8 > var5) {
               var2 = (int)var5;
               var1 = var2 * var3 / var4;
            }
         }
      } else {
         var7 = var1;
         var8 = var2;
         if(this.mMaxH > 0) {
            var5 = dip2pixel(this.mMaxH, this.getContext());
            var7 = var1;
            var8 = var2;
            if((float)var2 > var5) {
               var8 = (int)var5;
               var7 = var8 * var3 / var4;
            }
         }

         var1 = var7;
         var2 = var8;
         if(this.mMinW > 0) {
            var5 = dip2pixel(this.mMinW, this.getContext());
            var1 = var7;
            var2 = var8;
            if((float)var7 < var5) {
               var1 = (int)var5;
               var2 = var4 / var3 * var1;
            }
         }
      }

      this.setMeasuredDimension(var1, var2);
   }

   public void fillParent(boolean var1, int var2, int var3) {
      this.mFill = var1;
      this.mMaxH = var3;
      this.mMinW = var2;
   }

   int getConstrainedHeight(int var1, int var2, int var3, int var4) {
      boolean var6;
      if(var3 < var4) {
         var6 = true;
      } else {
         var6 = false;
      }

      float var5;
      int var8;
      if(var6) {
         var8 = var2;
         if(this.mMinW > 0) {
            var5 = dip2pixel(this.mMinW, this.getContext());
            var8 = var2;
            if((float)var1 < var5) {
               var1 = (int)var5;
               var8 = var4 / var3 * var1;
            }
         }

         var1 = var8;
         if(this.mMaxH > 0) {
            var5 = dip2pixel(this.mMaxH, this.getContext());
            var1 = var8;
            if((float)var8 > var5) {
               var1 = (int)var5;
            }
         }
      } else {
         int var7 = var1;
         var8 = var2;
         if(this.mMaxH > 0) {
            var5 = dip2pixel(this.mMaxH, this.getContext());
            var7 = var1;
            var8 = var2;
            if((float)var2 > var5) {
               var8 = (int)var5;
               var7 = var8 * var3 / var4;
            }
         }

         var1 = var8;
         if(this.mMinW > 0) {
            var5 = dip2pixel(this.mMinW, this.getContext());
            var1 = var8;
            if((float)var7 < var5) {
               var1 = (int)var5;
               return var4 / var3 * var1;
            }
         }
      }

      return var1;
   }

   protected int getMeasuredHeight(int var1, int var2) {
      int var3 = MeasureSpec.getSize(var1);
      MeasureSpec.getSize(var2);
      if(this.mFill && this.getDrawable() != null) {
         int var4 = this.getDrawable().getIntrinsicHeight();
         int var5 = this.getDrawable().getIntrinsicWidth();
         if(var5 > var4) {
            var2 = var3 * var4 / var5;
            var1 = var3;
         } else {
            var1 = var3 * var5 / var4;
            var2 = var3;
         }

         return this.getConstrainedHeight(var1, var2, var5, var4);
      } else {
         super.onMeasure(var1, var2);
         return 0;
      }
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getSize(var1);
      MeasureSpec.getSize(var2);
      if(this.mFill && this.getDrawable() != null) {
         int var4 = this.getDrawable().getIntrinsicHeight();
         int var5 = this.getDrawable().getIntrinsicWidth();
         if(var5 > var4) {
            var1 = var3 * var4 / var5;
         } else {
            var2 = var3 * var5 / var4;
            var1 = var3;
            var3 = var2;
         }

         this.ensureConstraintMetAndSet(var3, var1, var5, var4);
      } else {
         super.onMeasure(var1, var2);
      }
   }
}
