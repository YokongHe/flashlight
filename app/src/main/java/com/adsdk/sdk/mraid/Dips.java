package com.adsdk.sdk.mraid;

import android.content.Context;
import android.util.TypedValue;

public class Dips {
   public static float asFloatPixels(float var0, Context var1) {
      return TypedValue.applyDimension(1, var0, var1.getResources().getDisplayMetrics());
   }

   public static int asIntPixels(float var0, Context var1) {
      return (int)(asFloatPixels(var0, var1) + 0.5F);
   }
}
