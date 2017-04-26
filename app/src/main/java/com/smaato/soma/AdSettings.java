package com.smaato.soma;

import com.smaato.soma.AdDimension;
import com.smaato.soma.AdSettingsInterface;
import com.smaato.soma.AdType;

public class AdSettings implements AdSettingsInterface {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$AdDimension;
   private boolean dimensionStrict;
   private boolean formatStrict;
   private AdDimension mAdDimension;
   private AdType mAdType;
   private int mAdspaceId;
   private int mPublisherId;
   private int mbannerHeight;
   private int mbannerWidth;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$AdDimension() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$AdDimension;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[AdDimension.values().length];

         try {
            var0[AdDimension.DEFAULT.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            var0[AdDimension.INTERSTITIAL_LANDSCAPE.ordinal()] = 6;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[AdDimension.INTERSTITIAL_PORTRAIT.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[AdDimension.LEADERBOARD.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[AdDimension.MEDIUMRECTANGLE.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[AdDimension.NOT_SET.ordinal()] = 7;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[AdDimension.SKYSCRAPER.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$AdDimension = var0;
         return var0;
      }
   }

   public AdSettings() {
      this.mAdType = AdType.ALL;
      this.formatStrict = true;
      this.mAdDimension = AdDimension.DEFAULT;
      this.mbannerWidth = 0;
      this.mbannerHeight = 0;
      this.mPublisherId = 0;
      this.mAdspaceId = 0;
      this.dimensionStrict = true;
   }

   public final AdDimension getAdDimension() {
      return this.mAdDimension;
   }

   public final AdType getAdType() {
      return this.mAdType;
   }

   public final int getAdspaceId() {
      return this.mAdspaceId;
   }

   public int getBannerHeight() {
      // $FF: Couldn't be decompiled
   }

   public int getBannerWidth() {
      // $FF: Couldn't be decompiled
   }

   public final int getPublisherId() {
      return this.mPublisherId;
   }

   public boolean isDimensionStrict() {
      return this.dimensionStrict;
   }

   public boolean isFormatStrict() {
      return this.formatStrict;
   }

   public final void setAdDimension(AdDimension var1) {
      this.mAdDimension = var1;
   }

   public final void setAdType(AdType var1) {
      this.mAdType = var1;
   }

   public final void setAdspaceId(int var1) {
      this.mAdspaceId = var1;
   }

   public void setBannerHeight(int var1) {
      this.mbannerHeight = var1;
   }

   public void setBannerWidth(int var1) {
      this.mbannerWidth = var1;
   }

   public void setDimensionStrict(boolean var1) {
      this.dimensionStrict = var1;
   }

   public void setFormatStrict(boolean var1) {
      this.formatStrict = var1;
   }

   public final void setPublisherId(int var1) {
      this.mPublisherId = var1;
   }
}
