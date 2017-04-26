package com.adsdk.sdk.nativeads;

public class BaseAdapterUtil {
   private int adPositionInterval;
   private int firstAdPosition;

   public BaseAdapterUtil(int var1, int var2) {
      if(var1 < 0) {
         throw new IllegalArgumentException("First ad position cannot be negative!");
      } else if(var2 <= 0) {
         throw new IllegalArgumentException("Number of rows of original content between ads cannot be lower than 1.");
      } else {
         this.firstAdPosition = var1;
         this.adPositionInterval = var2 + 1;
      }
   }

   private int adsAlreadyShown(int var1) {
      return var1 <= this.firstAdPosition?0:(int)Math.floor((double)(var1 - this.firstAdPosition) / (double)this.adPositionInterval) + 1;
   }

   private int countAdsWithinContent(int var1) {
      if(var1 <= this.firstAdPosition) {
         return 0;
      } else {
         int var2 = this.adPositionInterval - 1;
         return (var1 - this.firstAdPosition) % var2 == 0?(var1 - this.firstAdPosition) / var2:(int)Math.floor((double)(var1 - this.firstAdPosition) / (double)var2) + 1;
      }
   }

   public int calculateShiftedCount(int var1) {
      return this.countAdsWithinContent(var1) + var1;
   }

   public int calculateShiftedPosition(int var1) {
      return var1 - this.adsAlreadyShown(var1);
   }

   public boolean isAdPosition(int var1) {
      return var1 >= this.firstAdPosition && (var1 - this.firstAdPosition) % this.adPositionInterval == 0;
   }
}
