package com.amazon.device.ads;

import android.content.Context;
import android.view.WindowManager;
import com.amazon.device.ads.AndroidTargetUtils;

class DisplayUtils {
   private static int[][] rotationArray = new int[][]{{1, 0, 9, 8}, {0, 9, 8, 1}};

   public static int determineCanonicalScreenOrientation(Context var0) {
      byte var2 = 0;
      int var3 = AndroidTargetUtils.getOrientation(((WindowManager)var0.getSystemService("window")).getDefaultDisplay());
      int var1 = var0.getResources().getConfiguration().orientation;
      boolean var4;
      if(var1 == 1) {
         if(var3 != 0 && var3 != 2) {
            var4 = false;
         } else {
            var4 = true;
         }
      } else if(var1 == 2) {
         if(var3 != 1 && var3 != 3) {
            var4 = false;
         } else {
            var4 = true;
         }
      } else {
         var4 = true;
      }

      byte var5;
      if(var4) {
         var5 = var2;
      } else {
         var5 = 1;
      }

      return rotationArray[var5][var3];
   }
}
