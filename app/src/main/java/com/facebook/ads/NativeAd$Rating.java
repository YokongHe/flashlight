package com.facebook.ads;

import org.json.JSONObject;

public class NativeAd$Rating {
   private final double scale;
   private final double value;

   private NativeAd$Rating(double var1, double var3) {
      this.value = var1;
      this.scale = var3;
   }

   public static NativeAd$Rating fromJSONObject(JSONObject var0) {
      if(var0 != null) {
         double var1 = var0.optDouble("value", 0.0D);
         double var3 = var0.optDouble("scale", 0.0D);
         if(var1 != 0.0D && var3 != 0.0D) {
            return new NativeAd$Rating(var1, var3);
         }
      }

      return null;
   }

   public double getScale() {
      return this.scale;
   }

   public double getValue() {
      return this.value;
   }
}
