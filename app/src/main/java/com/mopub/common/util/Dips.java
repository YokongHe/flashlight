package com.mopub.common.util;

import android.content.Context;
import android.util.TypedValue;

public class Dips {
   public static float asFloatPixels(float var0, Context var1) {
      return TypedValue.applyDimension(1, var0, var1.getResources().getDisplayMetrics());
   }

   public static int asIntPixels(float var0, Context var1) {
      return (int)(asFloatPixels(var0, var1) + 0.5F);
   }

   public static float dipsToFloatPixels(float var0, Context var1) {
      return getDensity(var1) * var0;
   }

   public static int dipsToIntPixels(float var0, Context var1) {
      return (int)(dipsToFloatPixels(var0, var1) + 0.5F);
   }

   private static float getDensity(Context var0) {
      return var0.getResources().getDisplayMetrics().density;
   }

   public static float pixelsToFloatDips(float var0, Context var1) {
      return var0 / getDensity(var1);
   }

   public static int pixelsToIntDips(float var0, Context var1) {
      return (int)(pixelsToFloatDips(var0, var1) + 0.5F);
   }
}
