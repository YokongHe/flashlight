package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubClientPositioning;
import com.mopub.nativeads.NativeAdData;
import java.util.Iterator;
import java.util.List;

class PlacementData {
   private static final int MAX_ADS = 200;
   public static final int NOT_FOUND = -1;
   private final NativeAdData[] mAdDataObjects = new NativeAdData[200];
   private final int[] mAdjustedAdPositions = new int[200];
   private int mDesiredCount = 0;
   private final int[] mDesiredInsertionPositions = new int[200];
   private final int[] mDesiredOriginalPositions = new int[200];
   private final int[] mOriginalAdPositions = new int[200];
   private int mPlacedCount = 0;

   private PlacementData(int[] var1) {
      this.mDesiredCount = Math.min(var1.length, 200);
      System.arraycopy(var1, 0, this.mDesiredInsertionPositions, 0, this.mDesiredCount);
      System.arraycopy(var1, 0, this.mDesiredOriginalPositions, 0, this.mDesiredCount);
   }

   private static int binarySearch(int[] var0, int var1, int var2, int var3) {
      --var2;

      while(true) {
         if(var1 > var2) {
            var2 = ~var1;
            break;
         }

         int var4 = var1 + var2 >>> 1;
         int var5 = var0[var4];
         if(var5 < var3) {
            var1 = var4 + 1;
         } else {
            var2 = var4;
            if(var5 <= var3) {
               break;
            }

            var2 = var4 - 1;
         }
      }

      return var2;
   }

   private static int binarySearchFirstEquals(int[] var0, int var1, int var2) {
      var1 = binarySearch(var0, 0, var1, var2);
      if(var1 < 0) {
         return ~var1;
      } else {
         for(var2 = var0[var1]; var1 >= 0 && var0[var1] == var2; --var1) {
            ;
         }

         return var1 + 1;
      }
   }

   private static int binarySearchGreaterThan(int[] var0, int var1, int var2) {
      var2 = binarySearch(var0, 0, var1, var2);
      int var3;
      if(var2 < 0) {
         var3 = ~var2;
      } else {
         int var4 = var0[var2];

         while(true) {
            var3 = var2;
            if(var2 >= var1) {
               break;
            }

            var3 = var2;
            if(var0[var2] != var4) {
               break;
            }

            ++var2;
         }
      }

      return var3;
   }

   static PlacementData empty() {
      return new PlacementData(new int[0]);
   }

   static PlacementData fromAdPositioning(MoPubNativeAdPositioning$MoPubClientPositioning var0) {
      int var2 = 0;
      List var5 = var0.getFixedPositions();
      int var4 = var0.getRepeatingInterval();
      int var3;
      if(var4 == Integer.MAX_VALUE) {
         var3 = var5.size();
      } else {
         var3 = 200;
      }

      int[] var6 = new int[var3];
      Iterator var7 = var5.iterator();

      int var1;
      for(var1 = 0; var7.hasNext(); ++var2) {
         var1 = ((Integer)var7.next()).intValue() - var2;
         var6[var2] = var1;
      }

      while(var2 < var3) {
         var1 = var1 + var4 - 1;
         var6[var2] = var1;
         ++var2;
      }

      return new PlacementData(var6);
   }

   void clearAds() {
      if(this.mPlacedCount != 0) {
         this.clearAdsInRange(0, this.mAdjustedAdPositions[this.mPlacedCount - 1] + 1);
      }
   }

   int clearAdsInRange(int var1, int var2) {
      byte var6 = 0;
      int[] var9 = new int[this.mPlacedCount];
      int[] var10 = new int[this.mPlacedCount];
      int var4 = 0;

      int var3;
      int var5;
      for(var3 = 0; var4 < this.mPlacedCount; var3 = var5) {
         int var7 = this.mOriginalAdPositions[var4];
         int var8 = this.mAdjustedAdPositions[var4];
         if(var1 <= var8 && var8 < var2) {
            var9[var3] = var7;
            var10[var3] = var8 - var3;
            this.mAdDataObjects[var4].getAd().destroy();
            this.mAdDataObjects[var4] = null;
            var5 = var3 + 1;
         } else {
            var5 = var3;
            if(var3 > 0) {
               var5 = var4 - var3;
               this.mOriginalAdPositions[var5] = var7;
               this.mAdjustedAdPositions[var5] = var8 - var3;
               this.mAdDataObjects[var5] = this.mAdDataObjects[var4];
               var5 = var3;
            }
         }

         ++var4;
      }

      if(var3 == 0) {
         return 0;
      } else {
         var1 = var10[0];
         var2 = binarySearchFirstEquals(this.mDesiredInsertionPositions, this.mDesiredCount, var1);

         for(var1 = this.mDesiredCount - 1; var1 >= var2; --var1) {
            this.mDesiredOriginalPositions[var1 + var3] = this.mDesiredOriginalPositions[var1];
            this.mDesiredInsertionPositions[var1 + var3] = this.mDesiredInsertionPositions[var1] - var3;
         }

         for(var1 = var6; var1 < var3; ++var1) {
            this.mDesiredOriginalPositions[var2 + var1] = var9[var1];
            this.mDesiredInsertionPositions[var2 + var1] = var10[var1];
         }

         this.mDesiredCount += var3;
         this.mPlacedCount -= var3;
         return var3;
      }
   }

   int getAdjustedCount(int var1) {
      return var1 == 0?0:this.getAdjustedPosition(var1 - 1) + 1;
   }

   int getAdjustedPosition(int var1) {
      return binarySearchGreaterThan(this.mOriginalAdPositions, this.mPlacedCount, var1) + var1;
   }

   int getOriginalCount(int var1) {
      byte var2 = -1;
      byte var4;
      if(var1 == 0) {
         var4 = 0;
      } else {
         int var3 = this.getOriginalPosition(var1 - 1);
         var4 = var2;
         if(var3 != -1) {
            return var3 + 1;
         }
      }

      return var4;
   }

   int getOriginalPosition(int var1) {
      int var2 = binarySearch(this.mAdjustedAdPositions, 0, this.mPlacedCount, var1);
      return var2 < 0?var1 - ~var2:-1;
   }

   NativeAdData getPlacedAd(int var1) {
      var1 = binarySearch(this.mAdjustedAdPositions, 0, this.mPlacedCount, var1);
      return var1 < 0?null:this.mAdDataObjects[var1];
   }

   int[] getPlacedAdPositions() {
      int[] var1 = new int[this.mPlacedCount];
      System.arraycopy(this.mAdjustedAdPositions, 0, var1, 0, this.mPlacedCount);
      return var1;
   }

   void insertItem(int var1) {
      int[] var3;
      for(int var2 = binarySearchFirstEquals(this.mDesiredOriginalPositions, this.mDesiredCount, var1); var2 < this.mDesiredCount; ++var2) {
         var3 = this.mDesiredOriginalPositions;
         ++var3[var2];
         var3 = this.mDesiredInsertionPositions;
         ++var3[var2];
      }

      for(var1 = binarySearchFirstEquals(this.mOriginalAdPositions, this.mPlacedCount, var1); var1 < this.mPlacedCount; ++var1) {
         var3 = this.mOriginalAdPositions;
         ++var3[var1];
         var3 = this.mAdjustedAdPositions;
         ++var3[var1];
      }

   }

   boolean isPlacedAd(int var1) {
      boolean var2 = false;
      if(binarySearch(this.mAdjustedAdPositions, 0, this.mPlacedCount, var1) >= 0) {
         var2 = true;
      }

      return var2;
   }

   void moveItem(int var1, int var2) {
      this.removeItem(var1);
      this.insertItem(var2);
   }

   int nextInsertionPosition(int var1) {
      var1 = binarySearchGreaterThan(this.mDesiredInsertionPositions, this.mDesiredCount, var1);
      return var1 == this.mDesiredCount?-1:this.mDesiredInsertionPositions[var1];
   }

   void placeAd(int var1, NativeAdData var2) {
      int var3 = binarySearchFirstEquals(this.mDesiredInsertionPositions, this.mDesiredCount, var1);
      if(var3 != this.mDesiredCount && this.mDesiredInsertionPositions[var3] == var1) {
         int var5 = this.mDesiredOriginalPositions[var3];
         int var4 = binarySearchGreaterThan(this.mOriginalAdPositions, this.mPlacedCount, var5);
         if(var4 < this.mPlacedCount) {
            int var6 = this.mPlacedCount - var4;
            System.arraycopy(this.mOriginalAdPositions, var4, this.mOriginalAdPositions, var4 + 1, var6);
            System.arraycopy(this.mAdjustedAdPositions, var4, this.mAdjustedAdPositions, var4 + 1, var6);
            System.arraycopy(this.mAdDataObjects, var4, this.mAdDataObjects, var4 + 1, var6);
         }

         this.mOriginalAdPositions[var4] = var5;
         this.mAdjustedAdPositions[var4] = var1;
         this.mAdDataObjects[var4] = var2;
         ++this.mPlacedCount;
         var1 = this.mDesiredCount - var3 - 1;
         System.arraycopy(this.mDesiredInsertionPositions, var3 + 1, this.mDesiredInsertionPositions, var3, var1);
         System.arraycopy(this.mDesiredOriginalPositions, var3 + 1, this.mDesiredOriginalPositions, var3, var1);
         --this.mDesiredCount;

         int[] var7;
         for(var1 = var3; var1 < this.mDesiredCount; ++var1) {
            var7 = this.mDesiredInsertionPositions;
            ++var7[var1];
         }

         for(var1 = var4 + 1; var1 < this.mPlacedCount; ++var1) {
            var7 = this.mAdjustedAdPositions;
            ++var7[var1];
         }
      } else {
         MoPubLog.w("Attempted to insert an ad at an invalid position");
      }

   }

   int previousInsertionPosition(int var1) {
      var1 = binarySearchFirstEquals(this.mDesiredInsertionPositions, this.mDesiredCount, var1);
      return var1 == 0?-1:this.mDesiredInsertionPositions[var1 - 1];
   }

   void removeItem(int var1) {
      int[] var3;
      for(int var2 = binarySearchGreaterThan(this.mDesiredOriginalPositions, this.mDesiredCount, var1); var2 < this.mDesiredCount; ++var2) {
         var3 = this.mDesiredOriginalPositions;
         --var3[var2];
         var3 = this.mDesiredInsertionPositions;
         --var3[var2];
      }

      for(var1 = binarySearchGreaterThan(this.mOriginalAdPositions, this.mPlacedCount, var1); var1 < this.mPlacedCount; ++var1) {
         var3 = this.mOriginalAdPositions;
         --var3[var1];
         var3 = this.mAdjustedAdPositions;
         --var3[var1];
      }

   }

   boolean shouldPlaceAd(int var1) {
      boolean var2 = false;
      if(binarySearch(this.mDesiredInsertionPositions, 0, this.mDesiredCount, var1) >= 0) {
         var2 = true;
      }

      return var2;
   }
}
