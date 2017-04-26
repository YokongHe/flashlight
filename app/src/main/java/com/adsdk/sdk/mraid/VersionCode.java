package com.adsdk.sdk.mraid;

import android.os.Build.VERSION;

public enum VersionCode {
   BASE(1),
   BASE_1_1(2),
   CUPCAKE(3),
   CUR_DEVELOPMENT(10000),
   DONUT(4),
   ECLAIR(5),
   ECLAIR_0_1(6),
   ECLAIR_MR1(7),
   FROYO(8),
   GINGERBREAD(9),
   GINGERBREAD_MR1(10),
   HONEYCOMB(11),
   HONEYCOMB_MR1(12),
   HONEYCOMB_MR2(13),
   ICE_CREAM_SANDWICH(14),
   ICE_CREAM_SANDWICH_MR1(15),
   JELLY_BEAN(16),
   JELLY_BEAN_MR1(17),
   JELLY_BEAN_MR2(18);

   private int mApiLevel;

   private VersionCode(int var3) {
      this.mApiLevel = var3;
   }

   public static VersionCode currentApiLevel() {
      return forApiLevel(VERSION.SDK_INT);
   }

   private static VersionCode forApiLevel(int var0) {
      VersionCode[] var5 = values();
      int var2 = var5.length;
      int var1 = 0;

      VersionCode var3;
      while(true) {
         if(var1 >= var2) {
            var3 = CUR_DEVELOPMENT;
            break;
         }

         VersionCode var4 = var5[var1];
         var3 = var4;
         if(var4.getApiLevel() == var0) {
            break;
         }

         ++var1;
      }

      return var3;
   }

   public final int getApiLevel() {
      return this.mApiLevel;
   }

   public final boolean isAtLeast(VersionCode var1) {
      return this.getApiLevel() >= var1.getApiLevel();
   }

   public final boolean isAtMost(VersionCode var1) {
      return this.getApiLevel() <= var1.getApiLevel();
   }

   public final boolean isBelow(VersionCode var1) {
      return this.getApiLevel() < var1.getApiLevel();
   }
}
