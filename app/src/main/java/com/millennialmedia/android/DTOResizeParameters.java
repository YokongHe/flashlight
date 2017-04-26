package com.millennialmedia.android;

class DTOResizeParameters {
   boolean allowOffScreen;
   String customClosePosition;
   int height;
   int offsetX;
   int offsetY;
   int width;
   int xMax;
   int yMax;

   DTOResizeParameters(float var1, int var2, int var3, String var4, int var5, int var6, boolean var7, int var8, int var9) {
      this.width = (int)((float)var2 * var1);
      this.height = (int)((float)var3 * var1);
      this.customClosePosition = var4;
      this.offsetX = (int)((float)var5 * var1);
      this.offsetY = (int)((float)var6 * var1);
      this.allowOffScreen = var7;
      this.xMax = var8;
      this.yMax = var9;
   }

   public String toString() {
      return String.format("width[%d] height[%d] offsetX[%d] offsetY[%d] allowOffScreen[%b] customClosePosition[%s] maxX[%d] maxY[%d]", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.offsetX), Integer.valueOf(this.offsetY), Boolean.valueOf(this.allowOffScreen), this.customClosePosition, Integer.valueOf(this.xMax), Integer.valueOf(this.yMax)});
   }
}
