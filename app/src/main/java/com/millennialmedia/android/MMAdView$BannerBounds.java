package com.millennialmedia.android;

import android.view.ViewGroup.LayoutParams;
import com.millennialmedia.android.DTOResizeParameters;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdView$BannerBounds$BoundsResult;

class MMAdView$BannerBounds {
   DTOResizeParameters resizeParams;
   // $FF: synthetic field
   final MMAdView this$0;
   int translationX;
   int translationY;

   MMAdView$BannerBounds(MMAdView var1, DTOResizeParameters var2) {
      this.this$0 = var1;
      this.resizeParams = var2;
      this.translationX = var2.offsetX;
      this.translationY = var2.offsetY;
   }

   private MMAdView$BannerBounds$BoundsResult calculateBounds(int var1, int var2, int var3, int var4) {
      int var5;
      int var6;
      if(var1 + var3 + var2 > var4) {
         var2 += var4 - var3;
         if(var2 < 0) {
            var5 = 0;
            var6 = var4;
         } else {
            var5 = var2;
            var6 = var3;
            if(var2 + var3 > var4) {
               var5 = var4 - var3;
               var6 = var3;
            }
         }
      } else {
         var5 = var2;
         var6 = var3;
         if(var2 <= 0) {
            var5 = var1;
            var6 = var3;
         }
      }

      MMAdView$BannerBounds$BoundsResult var7 = new MMAdView$BannerBounds$BoundsResult(this, null);
      var7.translation = var5 - var1;
      var7.size = var6;
      return var7;
   }

   private void calculateXBounds() {
      int[] var1 = new int[2];
      this.this$0.getLocationInWindow(var1);
      MMAdView$BannerBounds$BoundsResult var2 = this.calculateBounds(var1[0], this.resizeParams.offsetX, this.resizeParams.width, this.resizeParams.xMax);
      this.resizeParams.width = var2.size;
      this.translationX = var2.translation;
   }

   private void calculateYBounds() {
      int[] var1 = new int[2];
      this.this$0.getLocationInWindow(var1);
      MMAdView$BannerBounds$BoundsResult var2 = this.calculateBounds(var1[1], this.resizeParams.offsetY, this.resizeParams.height, this.resizeParams.yMax);
      this.resizeParams.height = var2.size;
      this.translationY = var2.translation;
   }

   void calculateOnScreenBounds() {
      this.calculateXBounds();
      this.calculateYBounds();
   }

   LayoutParams modifyLayoutParams(LayoutParams var1) {
      var1.width = this.resizeParams.width;
      var1.height = this.resizeParams.height;
      return var1;
   }
}
