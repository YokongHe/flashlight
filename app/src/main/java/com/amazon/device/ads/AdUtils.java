package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AdUtils$AdUtilsExecutor;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.MetricsCollector;

class AdUtils {
   public static final String LOG_TAG = AdUtils.class.getSimpleName();
   public static final String REQUIRED_ACTIVITY = "com.amazon.device.ads.AdActivity";
   private static AdUtils$AdUtilsExecutor executor = new AdUtils$AdUtilsExecutor();

   public static double calculateScalingMultiplier(int var0, int var1, int var2, int var3) {
      return executor.calculateScalingMultiplier(var0, var1, var2, var3);
   }

   static boolean checkDefinedActivities(Context var0) {
      return executor.checkDefinedActivities(var0);
   }

   public static int deviceIndependentPixelToPixel(int var0) {
      return executor.deviceIndependentPixelToPixel(var0);
   }

   public static float getScalingFactorAsFloat() {
      return executor.getScalingFactorAsFloat();
   }

   public static double getViewportInitialScale(double var0) {
      return executor.getViewportInitialScale(var0);
   }

   public static int pixelToDeviceIndependentPixel(int var0) {
      return executor.pixelToDeviceIndependentPixel(var0);
   }

   static void setConnectionMetrics(ConnectionInfo var0, MetricsCollector var1) {
      executor.setConnectionMetrics(var0, var1);
   }
}
